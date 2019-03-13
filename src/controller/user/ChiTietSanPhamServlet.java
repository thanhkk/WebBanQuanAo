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

import model.bean.DanhGia;
import model.bean.KhachHang;
import model.bean.SanPham;
import model.bo.DanhGiaBO;
import model.bo.KhachHangBO;
import model.bo.SanPhamBO;

/**
 * Servlet implementation class ChiTietSanPhamServlet
 */
@WebServlet("/ChiTietSanPhamServlet")
public class ChiTietSanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChiTietSanPhamServlet() {
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

		int maSanPham = Integer.parseInt(request.getParameter("maSanPham"));
		SanPhamBO sanPhamBO = new SanPhamBO();
		SanPham sanPham = sanPhamBO.getSanPham(maSanPham);
		request.setAttribute("sanPham", sanPham);
		DanhGiaBO danhGiaBO = new DanhGiaBO();

		KhachHangBO khachHangBO = new KhachHangBO();

		if ("danhGia".equals(request.getParameter("danhGia"))) {
			HttpSession ss = request.getSession();
			KhachHang khachHang = (KhachHang) ss.getAttribute("khachHang");
			int diemDanhGia = Integer.parseInt(request.getParameter("diemDanhGia"));
			String binhLuan = request.getParameter("binhLuan");
			if (khachHang != null) {

				if (danhGiaBO.addDanhGia(new DanhGia(0, maSanPham, khachHang.getMaKhachHang(), diemDanhGia, binhLuan)))
					request.setAttribute("thanhCong", "Cảm ơn bạn đã đánh giá sản phẩm này !");
				else
					request.setAttribute("thatBai", "Có lỗi xảy ra, vui lòng thử lại !");
			} else {
				request.setAttribute("thatBai", "Hãy đăng nhập để đánh giá !");
			}

		}

		if ("xoaBinhLuan".equals(request.getParameter("xoaBinhLuan"))) {
			int maDanhGia = Integer.parseInt(request.getParameter("maDanhGia"));
			if (danhGiaBO.deleteDanhGia(maDanhGia)) {
				request.setAttribute("thanhCong", "Bạn đã xóa bình luận !");
			} else {
				request.setAttribute("thatBai", "Xóa không thành công, hãy thử lại !");
			}
		}

		ArrayList<DanhGia> listDanhGia = danhGiaBO.getDanhGiaList(maSanPham);
		ArrayList<KhachHang> listKhachHang = khachHangBO.getKhachHangList();
		request.setAttribute("listDanhGia", listDanhGia);
		request.setAttribute("listKhachHang", listKhachHang);

		RequestDispatcher rd = request.getRequestDispatcher("Main/chiTietSanPham.jsp");
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
