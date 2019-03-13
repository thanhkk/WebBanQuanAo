package model.bo;

import java.util.ArrayList;

import model.bean.DanhMuc;
import model.dao.DanhMucDAO;

public class DanhMucBO {

	DanhMucDAO danhMucDAO = new DanhMucDAO();

	public boolean addDanhMuc(DanhMuc danhMuc) {
		return danhMucDAO.addDanhMuc(danhMuc);
	}

	public boolean editDanhMuc(DanhMuc danhMuc) {
		return danhMucDAO.editDanhMuc(danhMuc);
	}

	public boolean deleteDanhMuc(int maDanhMuc) {
		return danhMucDAO.deleteDanhMuc(maDanhMuc);
	}

	public ArrayList<DanhMuc> getDanhMucList() {
		return danhMucDAO.getDanhMucList();
	}

	public DanhMuc getDanhMuc2(int maDanhMuc) {
		return danhMucDAO.getDanhMuc2(maDanhMuc);
	}
}
