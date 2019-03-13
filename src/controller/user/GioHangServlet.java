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

import model.bean.GioHang;
import model.bo.SanPhamBO;

/**
 * Servlet implementation class GioHangServlet
 */
@WebServlet("/GioHangServlet")
public class GioHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GioHangServlet() {
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
		SanPhamBO sanPhamBO = new SanPhamBO();

		ArrayList<GioHang> listGioHang = (ArrayList<GioHang>) ss.getAttribute("listGioHang");

		if (request.getParameter("idGioHang") != null) {
			int idGioHang = Integer.parseInt(request.getParameter("idGioHang"));
			for (int i = 0; i < listGioHang.size(); i++) {
				if (listGioHang.get(i).getIdGioHang() == idGioHang) {
					listGioHang.remove(i);
				}
			}
//			request.setAttribute("thanhCong", "Xóa sản phẩm thành công !");
		}
		if (request.getParameter("capNhatSanPham") != null) {
			int maSanPham = Integer.parseInt(request.getParameter("capNhatSanPham"));
			int soLuong = Integer.parseInt(request.getParameter("soLuong"));
			if (soLuong > 0) {
				for (int i = 0; i < listGioHang.size(); i++) {
					if (listGioHang.get(i).getIdGioHang() == maSanPham) {
						listGioHang.get(i).setSoLuong(soLuong);
//						request.setAttribute("thanhCong", "Sản phẩm đã tồn tại, thêm số lượng !");
					}
				}
			} else {
				for (int i = 0; i < listGioHang.size(); i++) {
					if (listGioHang.get(i).getIdGioHang() == maSanPham) {
						listGioHang.remove(i);
//						request.setAttribute("thanhCong", "Sản phẩm đã tồn tại, thêm số lượng !");
					}
				}
			}
			request.setAttribute("thanhCong", "Cập nhật giỏ hàng thành công !");
		}
		if (request.getParameter("maSanPham") != null) {

			int maSanPham = Integer.parseInt(request.getParameter("maSanPham"));
			int soLuong = Integer.parseInt(request.getParameter("soLuong"));
			if (listGioHang == null) {
				listGioHang = new ArrayList<>();
			}

			boolean c = false;
			for (int i = 0; i < listGioHang.size(); i++) {
				if (listGioHang.get(i).getIdGioHang() == maSanPham) {
					listGioHang.get(i).setSoLuong(soLuong + listGioHang.get(i).getSoLuong());
					request.setAttribute("thanhCong", "Sản phẩm đã tồn tại, thêm số lượng !");
					c = true;
				}
			}
			if (c == false) {
				listGioHang.add(new GioHang(maSanPham, soLuong, sanPhamBO.getSanPham(maSanPham)));
				request.setAttribute("thanhCong", "Thêm sản phẩm mới thành công !");
				ss.setAttribute("listGioHang", listGioHang);
			}

		}
		ss.setAttribute("listGioHang", listGioHang);
		RequestDispatcher rd = request.getRequestDispatcher("Main/gioHang.jsp");
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
