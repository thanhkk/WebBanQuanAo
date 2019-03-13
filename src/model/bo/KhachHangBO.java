package model.bo;

import java.util.ArrayList;

import model.bean.KhachHang;
import model.dao.KhachHangDAO;

public class KhachHangBO {
	KhachHangDAO khachHangDAO = new KhachHangDAO();

	public Boolean addKhachHang(KhachHang khachHang) {
		return khachHangDAO.addKhachHang(khachHang);
	}

	public KhachHang getKhachHang(String tenDangNhap, String matKhau) {
		return khachHangDAO.getKhachHang(tenDangNhap, matKhau);
	}

	public ArrayList<KhachHang> getKhachHangList() {
		return khachHangDAO.getKhachHangList();
	}

	public boolean editKhachHang(KhachHang khachHang) {
		return khachHangDAO.editKhachHang(khachHang);
	}

	public boolean deleteKhachHang(int maKhachHang) {
		return khachHangDAO.deleteKhachHang(maKhachHang);
	}

	public KhachHang getKhachHang2(int maKhachHang) {
		return khachHangDAO.getKhachHang2(maKhachHang);
	}

}
