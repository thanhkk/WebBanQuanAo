package model.bo;

import java.util.ArrayList;

import model.bean.DanhGia;
import model.dao.DanhGiaDAO;

public class DanhGiaBO {
	DanhGiaDAO danhGiaDAO = new DanhGiaDAO();

	public boolean addDanhGia(DanhGia danhGia) {
		return danhGiaDAO.addDanhGia(danhGia);
	}

	public ArrayList<DanhGia> getDanhGiaList(int maSanPham) {
		return danhGiaDAO.getDanhGiaList(maSanPham);
	}

	public boolean deleteDanhGia(int maDanhGia) {
		return danhGiaDAO.deleteDanhGia(maDanhGia);
	}

}
