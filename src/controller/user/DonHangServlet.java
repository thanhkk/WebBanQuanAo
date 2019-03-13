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

import model.bean.DonHang;
import model.bean.KhachHang;
import model.bo.DonHangBO;

/**
 * Servlet implementation class DonHangServlet
 */
@WebServlet("/DonHangServlet")
public class DonHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DonHangServlet() {
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
		RequestDispatcher rd = request.getRequestDispatcher("Main/donHang.jsp");
		KhachHang khachHang = (KhachHang) ss.getAttribute("khachHang");
		DonHangBO donHangBO = new DonHangBO();

		if (khachHang == null) {
			request.setAttribute("thatBai", "Bạn phải đăng nhập trước");
			rd = request.getRequestDispatcher("Main/dangNhapDangKy.jsp");
			rd.include(request, response);
			return;
		}
		if ("daNhan".equals(request.getParameter("daNhan"))) {
			int maDonHang = Integer.parseInt(request.getParameter("maDonHang"));
			if (donHangBO.editDonHangTrangThai(maDonHang, 1)) {
				request.setAttribute("thanhCong", "Bạn đã nhận đơn hàng");
			} else {
				request.setAttribute("thatBai", "Có lỗi xảy ra, vui lòng thử lại");
			}
		}
		if ("huy".equals(request.getParameter("huy"))) {
			int maDonHang = Integer.parseInt(request.getParameter("maDonHang"));
			if (donHangBO.editDonHangTrangThai(maDonHang, 2)) {
				request.setAttribute("thanhCong", "Bạn đã huỷ đơn hàng");
			} else {
				request.setAttribute("thatBai", "Có lỗi xảy ra, vui lòng thử lại");
			}
		}
		ArrayList<DonHang> listDonHang = donHangBO.getDonHangList2(khachHang.getMaKhachHang());
		// Hashtable<Integer, SanPham> hashSanPham=sanPhamBO.getSanPhamHash();
		// Hashtable<Integer, DonHang> hashDonHang=donHangBO.getDonHangHash();
		// request.setAttribute("hashSanPham", hashSanPham);
		// request.setAttribute("hashDonHang", hashDonHang);
		request.setAttribute("listDonHang", listDonHang);
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
