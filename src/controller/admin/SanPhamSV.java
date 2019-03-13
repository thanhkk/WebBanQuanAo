package controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.bean.DanhMuc;
import model.bean.KhachHang;
import model.bean.SanPham;
import model.bo.DanhMucBO;
import model.bo.SanPhamBO;

/**
 * Servlet implementation class SanPhamSV
 */
@WebServlet("/SanPhamSV")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 50, // 50MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class SanPhamSV extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SanPhamSV() {
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

		RequestDispatcher rd = request.getRequestDispatcher("Admin/sanPham.jsp");
		HttpSession ss = request.getSession();
		KhachHang admin = (KhachHang) ss.getAttribute("admin");
		if (admin == null || admin.getCapBac() != 1) {
			ss.invalidate();
			rd = request.getRequestDispatcher("Admin/dangNhap.jsp");
			request.setAttribute("thatBai", "Vui lòng đăng nhập !");
			rd.include(request, response);
			return;
		}
		SanPhamBO sanPhamBO = new SanPhamBO();
		request.setAttribute("capNhat", false);
		if ("themSP".equals(request.getParameter("themSP"))) {
			String tenSanPham = request.getParameter("tenSanPham");
			int giaSanPham = Integer.parseInt(request.getParameter("giaSanPham"));
			int maDanhMuc = Integer.parseInt(request.getParameter("maDanhMuc"));
			String linkSanPham = request.getParameter("linkSanPham");
			int giaNhap = Integer.parseInt(request.getParameter("giaNhap"));
			for (Part part : request.getParts()) {
				String fileName = extractFileName(part);
				if (fileName != null && fileName.length() > 0) {
					fileName = new File(fileName).getName();
					linkSanPham = "./img/sp/" + fileName;
					part.write(this.getFolderUpload().getAbsolutePath() + File.separator + fileName);
				}
			}
			if (sanPhamBO.addSanPham(new SanPham(0, tenSanPham, maDanhMuc, giaSanPham, linkSanPham, giaNhap))) {
				request.setAttribute("thanhCong", "Thêm sản phẩm thành công");
			} else {
				request.setAttribute("thatBai", "Thêm sản phẩm thất bại, vui lòng kiểm tra lại");
			}
		}
		if ("capNhatSP".equals(request.getParameter("capNhatSP"))) {
			int maSanPham = Integer.parseInt(request.getParameter("maSanPham"));
			String tenSanPham = request.getParameter("tenSanPham");
			int giaSanPham = Integer.parseInt(request.getParameter("giaSanPham"));
			String linkSanPham = request.getParameter("linkSanPham");
			int giaNhap = Integer.parseInt(request.getParameter("giaNhap"));
			int maDanhMuc = Integer.parseInt(request.getParameter("maDanhMuc"));
			for (Part part : request.getParts()) {
				String fileName = extractFileName(part);
				if (fileName != null && fileName.length() > 0) {
					fileName = new File(fileName).getName();
					linkSanPham = "./img/sp/" + fileName;
					part.write(this.getFolderUpload().getAbsolutePath() + File.separator + fileName);
				}

			}
			if (linkSanPham == null) {
				linkSanPham = sanPhamBO.getSanPham(maSanPham).getLinkSanPham();
			}
			if (sanPhamBO
					.editSanPham(new SanPham(maSanPham, tenSanPham, maDanhMuc, giaSanPham, linkSanPham, giaNhap))) {
				request.setAttribute("thanhCong", "Cập nhật sản phẩm thành công");
				request.setAttribute("capNhat", false);
			} else {
				request.setAttribute("thatBai", "Cập nhật sản phẩm thất bại, vui lòng kiểm tra lại");
			}
		}

		if ("huySP".equals(request.getParameter("huySP"))) {
			request.setAttribute("capNhat", false);
		}
		if ("xoaSP".equals(request.getParameter("xoaSP"))) {
			int maSanPham = Integer.parseInt(request.getParameter("maSanPham"));
			if (sanPhamBO.deleteSanPham(maSanPham)) {
				request.setAttribute("thanhCong", "Xoá sản phẩm thành công");
			} else {
				request.setAttribute("thatbBai", "Xoá sản phẩm thất bại, kiểm tra lại");
			}
		}
		if ("suaSP".equals(request.getParameter("suaSP"))) {
			int maSanPham = Integer.parseInt(request.getParameter("maSanPham"));
			SanPham sanPham = sanPhamBO.getSanPham(maSanPham);
			request.setAttribute("capNhat", true);
			request.setAttribute("sanPham", sanPham);
		}
		DanhMucBO danhMucBO = new DanhMucBO();
		ArrayList<DanhMuc> listDanhMuc = danhMucBO.getDanhMucList();
		ArrayList<SanPham> listSanPham = sanPhamBO.getSanPhamList(0, "");
		request.setAttribute("listDanhMuc", listDanhMuc);
		request.setAttribute("listSanPham", listSanPham);
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

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}

	public File getFolderUpload() {

		String path = getServletContext().getRealPath("");
		path = path.substring(0, path.indexOf(".") - 1).replaceAll("\\\\", "/");
//		path = path.replaceAll("\\", "/");
		path += getServletContext().getContextPath();
		path += "/WebContent/img/sp";
		File folderUpload = new File(path);
		System.out.println(path);
		if (!folderUpload.exists()) {
			folderUpload.mkdirs();
		}
		return folderUpload;
	}

}
