package controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.ChiTiet;
import model.bean.DonHang;
import model.bean.KhachHang;
import model.bean.SanPham;
import model.bo.ChiTietBO;
import model.bo.DonHangBO;
import model.bo.KhachHangBO;
import model.bo.SanPhamBO;

/**
 * Servlet implementation class DashboardSV
 */
@WebServlet("/DashboardSV")
public class DashboardSV extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DashboardSV() {
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

		RequestDispatcher rd = request.getRequestDispatcher("Admin/dashboard.jsp");
		HttpSession ss = request.getSession();
		KhachHang admin = (KhachHang) ss.getAttribute("admin");
		if (admin == null || admin.getCapBac() != 1) {
			ss.invalidate();
			rd = request.getRequestDispatcher("Admin/dangNhap.jsp");
			request.setAttribute("thatBai", "Vui lòng đăng nhập !");
			rd.include(request, response);
			return;
		}
		DonHangBO donHangBO = new DonHangBO();
		KhachHangBO khachHangBO = new KhachHangBO();
		SanPhamBO sanPhamBO = new SanPhamBO();
		ChiTietBO chiTietBO = new ChiTietBO();
		ArrayList<DonHang> listDonHang = donHangBO.getDonHangList();
		ArrayList<KhachHang> listKhachHang = khachHangBO.getKhachHangList();
		ArrayList<SanPham> listSanPham = sanPhamBO.getSanPhamList(0, "");
		ArrayList<ChiTiet> listChiTiet = chiTietBO.getChiTietList();
		ArrayList<Date> listDate = donHangBO.getMonthYear();
		request.setAttribute("listDonHang", listDonHang);
		request.setAttribute("listKhachHang", listKhachHang);
		request.setAttribute("listSanPham", listSanPham);
		request.setAttribute("listChiTiet", listChiTiet);
		request.setAttribute("listDate", listDate);
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
