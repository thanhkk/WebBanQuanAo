package controller.user;

import java.io.IOException;
import java.util.ArrayList;

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
import model.bo.SanPhamBO;

/**
 * Servlet implementation class ChiTietDonHangServlet
 */
@WebServlet("/ChiTietDonHangServlet")
public class ChiTietDonHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChiTietDonHangServlet() {
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
		RequestDispatcher rd = request.getRequestDispatcher("Main/chiTietDonHang.jsp");
		KhachHang khachHang = (KhachHang) ss.getAttribute("khachHang");
		ChiTietBO chiTietBO = new ChiTietBO();
		SanPhamBO sanPhamBO = new SanPhamBO();
		DonHangBO donHangBO = new DonHangBO();
		if (khachHang == null) {
			request.setAttribute("thatBai", "Bạn phải đăng nhập trước");
			rd = request.getRequestDispatcher("Main/dangNhapDangKy.jsp");
			rd.include(request, response);
			return;
		}
		int maDonHang = Integer.parseInt(request.getParameter("maDonHang"));
		ArrayList<ChiTiet> listChiTiet = chiTietBO.getChiTietList2(maDonHang);
		ArrayList<SanPham> listSanPham = sanPhamBO.getSanPhamList(0, "");
		DonHang donHang = donHangBO.getDonHang(maDonHang);
		request.setAttribute("listChiTiet", listChiTiet);
		request.setAttribute("listSanPham", listSanPham);
		request.setAttribute("donHang", donHang);
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
