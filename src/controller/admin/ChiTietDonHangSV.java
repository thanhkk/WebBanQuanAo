package controller.admin;

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
import model.bo.ChiTietBO;
import model.bo.DonHangBO;

/**
 * Servlet implementation class ChiTietDonHangSV
 */
@WebServlet("/ChiTietDonHangSV")
public class ChiTietDonHangSV extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChiTietDonHangSV() {
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

		RequestDispatcher rd = request.getRequestDispatcher("Admin/chiTietDonHang.jsp");
		HttpSession ss = request.getSession();
		KhachHang admin = (KhachHang) ss.getAttribute("admin");
		if (admin == null || admin.getCapBac() != 1) {
			ss.invalidate();
			rd = request.getRequestDispatcher("Admin/dangNhap.jsp");
			request.setAttribute("thatBai", "Vui lòng đăng nhập !");
			rd.include(request, response);
			return;
		}
		ChiTietBO chiTietBO = new ChiTietBO();
		DonHangBO donHangBO=new DonHangBO();
		request.setAttribute("capNhat", false);
		int maDonHang = Integer.parseInt(request.getParameter("maDonHang"));
		System.out.println(maDonHang);
		if ("themCTDH".equals(request.getParameter("themCTDH"))) {
			int maSanPham = Integer.parseInt(request.getParameter("maSanPham"));
			System.out.println(maSanPham);
			int soLuong = Integer.parseInt(request.getParameter("soLuong"));
			System.out.println(soLuong);
			int thanhTien = Integer.parseInt(request.getParameter("thanhTien"));
			System.out.println(thanhTien);

			if (chiTietBO.addChiTiet(new ChiTiet(0, maDonHang, maSanPham, soLuong, thanhTien))) {
				request.setAttribute("thanhCong", "Thêm chi tiết đơn hàng thành công");
			} else {
				request.setAttribute("thatBai", "Thêm chi tiết đơn hàng thất bại, vui lòng kiểm tra lại");
			}
		}
		if ("capNhatCTDH".equals(request.getParameter("capNhatCTDH"))) {
			int maChiTiet = Integer.parseInt(request.getParameter("maChiTiet"));
			int maSanPham = Integer.parseInt(request.getParameter("maSanPham"));
			int soLuong = Integer.parseInt(request.getParameter("soLuong"));
			int thanhTien = Integer.parseInt(request.getParameter("thanhTien"));

			if (chiTietBO.editChiTiet(new ChiTiet(maChiTiet, maDonHang, maSanPham, soLuong, thanhTien))) {
				request.setAttribute("thanhCong", "Cập nhật chi tiết đơn hàng thành công");
				request.setAttribute("capNhat", false);
			} else {
				request.setAttribute("thatBai", "Cập nhật chi tiết đơn hàng thất bại, vui lòng kiểm tra lại");
			}
		}
		if ("huyCTDH".equals(request.getParameter("huyCTDH"))) {
			request.setAttribute("capNhat", false);
		}
		if ("xoaCTDH".equals(request.getParameter("xoaCTDH"))) {
			int maChiTiet = Integer.parseInt(request.getParameter("maChiTiet"));
			if (chiTietBO.deleteChiTiet(maChiTiet)) {
				request.setAttribute("thanhCong", "Xoá chi tiết đơn hàng thành công");
			} else {
				request.setAttribute("thatbBai", "Xoá chi tiết đơn hàng thất bại, kiểm tra lại");
			}
		}
		if ("suaCTDH".equals(request.getParameter("suaCTDH"))) {
			int maChiTiet = Integer.parseInt(request.getParameter("maChiTiet"));
			ChiTiet chiTiet = chiTietBO.getChiTiet(maChiTiet);
			request.setAttribute("capNhat", true);
			request.setAttribute("chiTiet", chiTiet);
		}
		DonHang donHang=donHangBO.getDonHang(maDonHang);
		ArrayList<ChiTiet> listChiTiet = chiTietBO.getChiTietList2(maDonHang);
		request.setAttribute("listChiTiet", listChiTiet);
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
