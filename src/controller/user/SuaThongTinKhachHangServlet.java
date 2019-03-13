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
 * Servlet implementation class SuaThongTinKhachHangServlet
 */
@WebServlet("/SuaThongTinKhachHangServlet")
public class SuaThongTinKhachHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuaThongTinKhachHangServlet() {
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
		RequestDispatcher rd = request.getRequestDispatcher("Main/thongTinKhachHang.jsp");
		if (khachHang == null) {
			rd = request.getRequestDispatcher("Main/dangNhapDangKy.jsp");
			request.setAttribute("thatBai", "Bạn cần đăng nhập trước !");
			rd.include(request, response);
			return;
		}

		else if ("sua".equals(request.getParameter("sua"))) {
			String hoVaTen = request.getParameter("hoVaTen");
			String tenDangNhap = khachHang.getTenDangNhap();
			String matKhau = request.getParameter("matKhau");
			String soDienThoai = request.getParameter("soDienThoai");
			String diaChi = request.getParameter("diaChi");
			int capBac = Integer.parseInt(request.getParameter("capBac"));
			KhachHangBO khachHangBO = new KhachHangBO();

			if (khachHangBO.editKhachHang(new KhachHang(khachHang.getMaKhachHang(), hoVaTen, tenDangNhap, matKhau,
					soDienThoai, diaChi, capBac))) {
				request.setAttribute("thanhCong", "Cập nhật thông tin thành công !");
//				ss.removeAttribute("khachHang");
				khachHang = khachHangBO.getKhachHang(tenDangNhap, matKhau);
				ss.setAttribute("khachHang", khachHang);
			} else {
				request.setAttribute("thatBai", "Cập nhật thông tin thất bại !");
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
