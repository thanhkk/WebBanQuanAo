package model.bo;

import java.util.ArrayList;

import model.bean.SanPham;
import model.dao.SanPhamDAO;

public class SanPhamBO {
	SanPhamDAO sanPhamDAO = new SanPhamDAO();

	public boolean addSanPham(SanPham sanPham) {
		return sanPhamDAO.addSanPham(sanPham);
	}

	public boolean editSanPham(SanPham sanPham) {
		return sanPhamDAO.editSanPham(sanPham);
	}

	public boolean deleteSanPham(int maSanPham) {
		return sanPhamDAO.deleteSanPham(maSanPham);
	}

	public SanPham getSanPham(int maSanPham) {
		return sanPhamDAO.getSanPham(maSanPham);
	}

	public ArrayList<SanPham> getSanPhamList(int maDanhMuc, String tenSanPham) {
		return sanPhamDAO.getSanPhamList(maDanhMuc, tenSanPham);
	}

}
