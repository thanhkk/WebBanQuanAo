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
import model.bean.GioHang;
import model.bean.KhachHang;
import model.bo.ChiTietBO;
import model.bo.DonHangBO;

/**
 * Servlet implementation class ThanhToanServlet
 */
@WebServlet("/ThanhToanServlet")
public class ThanhToanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThanhToanServlet() {
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
		RequestDispatcher rd = request.getRequestDispatcher("Main/dangNhapDangKy.jsp");
		if (khachHang != null) {
			ArrayList<GioHang> listGioHang = (ArrayList<GioHang>) ss.getAttribute("listGioHang");
			if (listGioHang == null || listGioHang.isEmpty()) {
				request.setAttribute("thatBai", "Hãy thêm sản phẩm vào giỏ hàng !");
				rd = request.getRequestDispatcher("Main/gioHang.jsp");
				rd.include(request, response);
				return;
			} else {
				ChiTietBO chiTietBO = new ChiTietBO();
				DonHangBO donHangBO = new DonHangBO();
				int maDonHang = donHangBO.getMaDonHangMax();
				int maKhachHang = khachHang.getMaKhachHang();
				String soDienThoai = request.getParameter("soDienThoai");
				String diaChi = request.getParameter("diaChi");
				if (donHangBO.addDonHang(new DonHang(maDonHang, maKhachHang, soDienThoai, diaChi, 0, 0, null))) {
					for (GioHang gioHang : listGioHang) {
						chiTietBO.addChiTiet(new ChiTiet(0, maDonHang, gioHang.getSanPham().getMaSanPham(),
								gioHang.getSoLuong(), (gioHang.getSoLuong() * gioHang.getSanPham().getGiaSanPham())));

					}
					ss.removeAttribute("listGioHang");
					request.setAttribute("thanhCong", "Thanh toán thành công !");
					rd = request.getRequestDispatcher("DonHangServlet");
					rd.include(request, response);
					return;
				} else {
					request.setAttribute("thatBai", "Có lỗi xảy ra, vui lòng thử lại !");
					rd = request.getRequestDispatcher("Main/gioHang.jsp");
					rd.include(request, response);
					return;
				}

			}

		} else {
			request.setAttribute("thatBai", "Bạn cần phải đăng nhập !");
			rd.include(request, response);
			return;
		}
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
