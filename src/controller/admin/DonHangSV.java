package controller.admin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
 * Servlet implementation class DonHangSV
 */
@WebServlet("/DonHangSV")
public class DonHangSV extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DonHangSV() {
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

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		RequestDispatcher rd = request.getRequestDispatcher("Admin/donHang.jsp");
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
		request.setAttribute("capNhat", false);
		if ("themDH".equals(request.getParameter("themDH"))) {
			int maDonHang = donHangBO.getMaDonHangMax();
			int maKhachHang = Integer.parseInt(request.getParameter("maKhachHang"));
			String soDienThoai = request.getParameter("soDienThoai");
			String diaChi = request.getParameter("diaChi");
			int trangThai = Integer.parseInt(request.getParameter("trangThai"));
			int tongTien = Integer.parseInt(request.getParameter("tongTien"));
			SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
			Date ngayTao = null;
			try {
				ngayTao = sp.parse(request.getParameter("ngayTao"));
			} catch (ParseException e) {

				e.printStackTrace();
			}
			if (donHangBO.addDonHang(
					new DonHang(maDonHang, maKhachHang, soDienThoai, diaChi, trangThai, tongTien, ngayTao))) {
				request.setAttribute("thanhCong", "Thêm đơn hàng thành công");
			} else {
				request.setAttribute("thatBai", "Thêm đơn hàng thất bại, vui lòng kiểm tra lại");
			}
		}
		if ("capNhatDH".equals(request.getParameter("capNhatDH"))) {
			int maDonHang = Integer.parseInt(request.getParameter("maDonHang"));
			int maKhachHang = Integer.parseInt(request.getParameter("maKhachHang"));
			String soDienThoai = request.getParameter("soDienThoai");
			String diaChi = request.getParameter("diaChi");
			int trangThai = Integer.parseInt(request.getParameter("trangThai"));
			int tongTien = Integer.parseInt(request.getParameter("tongTien"));
			SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
			Date ngayTao = null;
			try {
				ngayTao = sp.parse(request.getParameter("ngayTao"));
			} catch (ParseException e) {

				e.printStackTrace();
			}
			if (donHangBO.editDonHang(
					new DonHang(maDonHang, maKhachHang, soDienThoai, diaChi, trangThai, tongTien, ngayTao))) {
				request.setAttribute("thanhCong", "Cập nhật đơn hàng thành công");
				request.setAttribute("capNhat", false);
			} else {
				request.setAttribute("thatBai", "Cập nhật đơn hàng thất bại, vui lòng kiểm tra lại");
			}
		}
		if ("huyDH".equals(request.getParameter("huyDH"))) {
			request.setAttribute("capNhat", false);
		}
		if ("xoaDH".equals(request.getParameter("xoaDH"))) {
			int maDonHang = Integer.parseInt(request.getParameter("maDonHang"));
			if (donHangBO.deleteDonHang(maDonHang)) {
				request.setAttribute("thanhCong", "Xoá đơn hàng thành công");
			} else {
				request.setAttribute("thatbBai", "Xoá đơn hàng thất bại, kiểm tra lại");
			}
		}
		if ("suaDH".equals(request.getParameter("suaDH"))) {
			int maDonHang = Integer.parseInt(request.getParameter("maDonHang"));
			DonHang donHang = donHangBO.getDonHang(maDonHang);
			request.setAttribute("capNhat", true);
			request.setAttribute("donHang", donHang);
		}

		ArrayList<DonHang> listDonHang = donHangBO.getDonHangList();
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
