package model.bo;

import java.util.ArrayList;
import java.util.Date;

import model.bean.DonHang;
import model.dao.DonHangDAO;

public class DonHangBO {
	DonHangDAO donHangDAO = new DonHangDAO();

	public ArrayList<DonHang> getDonHangList() {
		return donHangDAO.getDonHangList();

	}

	public ArrayList<DonHang> getDonHangList2(int maKhachHang) {
		return donHangDAO.getDonHangList2(maKhachHang);

	}

	public boolean editDonHangTrangThai(int maDonHang, int trangThai) {
		return donHangDAO.editDonHangTrangThai(maDonHang, trangThai);
	}

	public int getMaDonHangMax() {
		return donHangDAO.getMaDonHangMax();
	}

	public boolean deleteDonHang(int maDonHang) {
		return donHangDAO.deleteDonHang(maDonHang);
	}

	public boolean editDonHang(DonHang donHang) {
		return donHangDAO.editDonHang(donHang);
	}

	public boolean addDonHang(DonHang donHang) {
		return donHangDAO.addDonHang(donHang);
	}

	public ArrayList<Date> getMonthYear() {
		return donHangDAO.getMonthYear();
	}

	public DonHang getDonHang(int maDonHang) {
		return donHangDAO.getDonHang(maDonHang);
	}
}
