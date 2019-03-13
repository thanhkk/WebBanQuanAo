package controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.KhachHang;
import model.bo.KhachHangBO;

/**
 * Servlet implementation class DangNhapDangKyServlet
 */
@WebServlet("/DangNhapDangKyServlet")
public class DangNhapDangKyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangNhapDangKyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		HttpSession ss = request.getSession();
		KhachHang khachHang = (KhachHang) ss.getAttribute("khachHang");
		KhachHangBO khachHangBO = new KhachHangBO();
		RequestDispatcher rd = request.getRequestDispatcher("Main/dangNhapDangKy.jsp");
		if (khachHang != null) {
			rd = request.getRequestDispatcher("IndexServlet");
			rd.include(request, response);
			return;
		}
		if ("dangNhap".equals(request.getParameter("dangNhap"))) {
			String tenDangNhap = request.getParameter("tenDangNhap");
			String matKhau = request.getParameter("matKhau");

			khachHang = khachHangBO.getKhachHang(tenDangNhap, matKhau);
			if (khachHang != null) {
				if (khachHang.getCapBac() == 2) {
					request.setAttribute("thatBai", "Tài khoản đã bị khoá !");
				} else {

					ss.setAttribute("khachHang", khachHang);
//				request.setAttribute("thanhCong", "Đăng nhập thành công !");
					rd = request.getRequestDispatcher("IndexServlet");
					rd.include(request, response);
					return;
				}
			} else {
				request.setAttribute("thatBai", "Sai tên đăng nhập hoặc mật khẩu !");
			}
		}
		if ("dangKy".equals(request.getParameter("dangKy"))) {
			String hoVaTen = request.getParameter("hoVaTen");
			String tenDangNhap = request.getParameter("tenDangNhap");
			String matKhau = request.getParameter("matKhau");
			String soDienThoai = request.getParameter("soDienThoai");
			String diaChi = request.getParameter("diaChi");
			khachHang = new KhachHang(0, hoVaTen, tenDangNhap, matKhau, soDienThoai, diaChi, 0);
			if (khachHangBO.addKhachHang(khachHang)) {
				request.setAttribute("thanhCong", "Đăng ký thành công !");
				ss.setAttribute("khachHang", khachHang);
				rd = request.getRequestDispatcher("IndexServlet");
				rd.include(request, response);
				return;
			} else {
				request.setAttribute("thatBai", "Đăng ký thất bại, hãy kiểm tra lại !");
			}
		}
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
