package model.bo;

import java.util.ArrayList;

import model.bean.ChiTiet;
import model.dao.ChiTietDAO;

public class ChiTietBO {
	ChiTietDAO chiTietDAO = new ChiTietDAO();

	public ArrayList<ChiTiet> getChiTietList() {
		return chiTietDAO.getChiTietList();
	}

	public ArrayList<ChiTiet> getChiTietList2(int maDonHang) {
		return chiTietDAO.getChiTietList2(maDonHang);
	}

	public boolean editChiTiet(ChiTiet chiTiet) {
		return chiTietDAO.editChiTiet(chiTiet);
	}

	public boolean addChiTiet(ChiTiet chiTiet) {
		return chiTietDAO.addChiTiet(chiTiet);
	}

	public boolean deleteChiTiet(int maChiTiet) {
		return chiTietDAO.deleteChiTiet(maChiTiet);
	}

	public ChiTiet getChiTiet(int maChiTiet) {
		return chiTietDAO.getChiTiet(maChiTiet);
	}

}
