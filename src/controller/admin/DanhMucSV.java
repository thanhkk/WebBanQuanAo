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

import model.bean.DanhMuc;
import model.bean.KhachHang;
import model.bo.DanhMucBO;

/**
 * Servlet implementation class DanhMucSV
 */
@WebServlet("/DanhMucSV")
public class DanhMucSV extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DanhMucSV() {
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

		RequestDispatcher rd = request.getRequestDispatcher("Admin/danhMuc.jsp");
		HttpSession ss = request.getSession();
		KhachHang admin = (KhachHang) ss.getAttribute("admin");
		if (admin == null || admin.getCapBac() != 1) {
			ss.invalidate();
			rd = request.getRequestDispatcher("Admin/dangNhap.jsp");
			request.setAttribute("thatBai", "Vui lòng đăng nhập !");
			rd.include(request, response);
			return;
		}
		DanhMucBO danhMucBO = new DanhMucBO();
		request.setAttribute("capNhat", false);
		if ("themDM".equals(request.getParameter("themDM"))) {
			String tenDanhMuc = request.getParameter("tenDanhMuc");
			if (danhMucBO.addDanhMuc(new DanhMuc(0, tenDanhMuc))) {
				request.setAttribute("thanhCong", "Thêm danh mục thành công");
			} else {
				request.setAttribute("thatBai", "Thêm danh mục thất bại, vui lòng kiểm tra lại");
			}
		}
		if ("capNhatDM".equals(request.getParameter("capNhatDM"))) {
			int maDanhMuc = Integer.parseInt(request.getParameter("maDanhMuc"));
			String tenDanhMuc = request.getParameter("tenDanhMuc");

			if (danhMucBO.editDanhMuc(new DanhMuc(maDanhMuc, tenDanhMuc))) {
				request.setAttribute("thanhCong", "Cập nhật danh mục thành công");
				request.setAttribute("capNhat", false);
			} else {
				request.setAttribute("thatBai", "Cập nhật danh mục thất bại, vui lòng kiểm tra lại");
			}
		}
		if ("huyDM".equals(request.getParameter("huyDM"))) {
			request.setAttribute("capNhat", false);
		}
		if ("xoaDM".equals(request.getParameter("xoaDM"))) {
			int maDanhMuc = Integer.parseInt(request.getParameter("maDanhMuc"));
			if (danhMucBO.deleteDanhMuc(maDanhMuc)) {
				request.setAttribute("thanhCong", "Xoá danh mục thành công");
			} else {
				request.setAttribute("thatbBai", "Xoá danh mục thất bại, kiểm tra lại");
			}
		}
		if ("suaDM".equals(request.getParameter("suaDM"))) {
			int maDanhMuc = Integer.parseInt(request.getParameter("maDanhMuc"));
			DanhMuc danhMuc = danhMucBO.getDanhMuc2(maDanhMuc);
			request.setAttribute("capNhat", true);
			request.setAttribute("danhMuc", danhMuc);
		}

		ArrayList<DanhMuc> listDanhMuc = danhMucBO.getDanhMucList();
		request.setAttribute("listDanhMuc", listDanhMuc);
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
