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

import common.KiemTra;
import model.bean.DanhMuc;
import model.bean.SanPham;
import model.bo.DanhMucBO;
import model.bo.SanPhamBO;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
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

		SanPhamBO sanPhamBO = new SanPhamBO();
		int maDanhMuc = KiemTra.chuoi(request.getParameter("maDanhMuc"));
		String tenSanPham = KiemTra.tenSanPham(request.getParameter("tenSanPham"));
		ArrayList<SanPham> listSanPham = sanPhamBO.getSanPhamList(maDanhMuc, tenSanPham);
		DanhMucBO danhMucBO = new DanhMucBO();
		ArrayList<DanhMuc> listDanhMuc = danhMucBO.getDanhMucList();
		HttpSession ss = request.getSession();
		ss.setAttribute("listDanhMuc", listDanhMuc);
		request.setAttribute("listSanPham", listSanPham);
		request.setAttribute("maDanhMuc", maDanhMuc);
		RequestDispatcher rd = request.getRequestDispatcher("Main/index.jsp");
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
