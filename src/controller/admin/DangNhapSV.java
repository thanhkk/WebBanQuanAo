package controller.admin;

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
 * Servlet implementation class DangNhapSV
 */
@WebServlet("/DangNhapSV")
public class DangNhapSV extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangNhapSV() {
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

		RequestDispatcher rd = request.getRequestDispatcher("Admin/dangNhap.jsp");
		HttpSession ss = request.getSession();
		KhachHang admin = (KhachHang) ss.getAttribute("admin");
		if (admin != null) {
			rd = request.getRequestDispatcher("DashboardSV");
			request.setAttribute("thatBai", "Bạn đã đăng nhập từ trước");
			rd.include(request, response);
			return;
		}

		if ("dangNhap".equals(request.getParameter("dangNhap"))) {
			String tenDangNhap = request.getParameter("tenDangNhap");
			String matKhau = request.getParameter("matKhau");
			KhachHangBO khachHangBO = new KhachHangBO();
			admin = khachHangBO.getKhachHang(tenDangNhap, matKhau);
			if (admin != null && admin.getCapBac() == 1) {
				ss.setAttribute("admin", admin);
				rd = request.getRequestDispatcher("DashboardSV");
				request.setAttribute("thanhCong", "Xin chào " + admin.getHoVaTen());
				rd.include(request, response);
				return;
			} else {
				request.setAttribute("thatBai", "Nhập sai tên hoặc mật khẩu");
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
