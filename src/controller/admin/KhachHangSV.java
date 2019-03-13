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

import model.bean.KhachHang;
import model.bo.KhachHangBO;

/**
 * Servlet implementation class KhachHangSV
 */
@WebServlet("/KhachHangSV")
public class KhachHangSV extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KhachHangSV() {
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

		RequestDispatcher rd = request.getRequestDispatcher("Admin/khachHang.jsp");
		HttpSession ss = request.getSession();
		KhachHang admin = (KhachHang) ss.getAttribute("admin");
		if (admin == null || admin.getCapBac() != 1) {
			ss.invalidate();
			rd = request.getRequestDispatcher("Admin/dangNhap.jsp");
			request.setAttribute("thatBai", "Vui lòng đăng nhập !");
			rd.include(request, response);
			return;
		}
		KhachHangBO khachHangBO = new KhachHangBO();
		request.setAttribute("capNhat", false);
		if ("themKH".equals(request.getParameter("themKH"))) {
			String hoVaTen = request.getParameter("hoVaTen");
			String tenDangNhap = request.getParameter("tenDangNhap");
			String matKhau = request.getParameter("matKhau");
			String soDienThoai = request.getParameter("soDienThoai");
			String diaChi = request.getParameter("diaChi");
			int capBac = Integer.parseInt(request.getParameter("capBac"));
			if (khachHangBO
					.addKhachHang(new KhachHang(0, hoVaTen, tenDangNhap, matKhau, soDienThoai, diaChi, capBac))) {
				request.setAttribute("thanhCong", "Thêm User thành công");
			} else {
				request.setAttribute("thatBai", "Thêm User thất bại, vui lòng kiểm tra lại");
			}
		}
		if ("capNhatKH".equals(request.getParameter("capNhatKH"))) {
			int maKhachHang = Integer.parseInt(request.getParameter("maKhachHang"));
			String hoVaTen = request.getParameter("hoVaTen");
			String tenDangNhap = request.getParameter("tenDangNhap");
			String matKhau = request.getParameter("matKhau");
			String soDienThoai = request.getParameter("soDienThoai");
			String diaChi = request.getParameter("diaChi");
			int capBac = Integer.parseInt(request.getParameter("capBac"));
			if (khachHangBO.editKhachHang(
					new KhachHang(maKhachHang, hoVaTen, tenDangNhap, matKhau, soDienThoai, diaChi, capBac))) {
				request.setAttribute("thanhCong", "Cập nhật User thành công");
				request.setAttribute("capNhat", false);
			} else {
				request.setAttribute("thatBai", "Cập nhật User thất bại, vui lòng kiểm tra lại");
			}
		}
		if ("huyKH".equals(request.getParameter("huyKH"))) {
			request.setAttribute("capNhat", false);
		}
		if ("xoaKH".equals(request.getParameter("xoaKH"))) {
			int maKhachHang = Integer.parseInt(request.getParameter("maKhachHang"));
			if (khachHangBO.deleteKhachHang(maKhachHang)) {
				request.setAttribute("thanhCong", "Xoá User thành công");
			} else {
				request.setAttribute("thatbBai", "Xoá User thất bại, kiểm tra lại");
			}
		}
		if ("suaKH".equals(request.getParameter("suaKH"))) {
			int maKhachHang = Integer.parseInt(request.getParameter("maKhachHang"));
			KhachHang khachHang = khachHangBO.getKhachHang2(maKhachHang);
			request.setAttribute("capNhat", true);
			request.setAttribute("khachHang", khachHang);
		}

		ArrayList<KhachHang> listKhachHang = khachHangBO.getKhachHangList();
		request.setAttribute("listKhachHang", listKhachHang);
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
