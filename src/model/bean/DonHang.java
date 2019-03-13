package model.bean;

import java.util.Date;

public class DonHang {
	private int maDonHang;
	private int maKhachHang;
	private String soDienThoai;
	private String diaChi;
	private int trangThai;
	private int tongTien;
	private Date ngayTao;

	public DonHang() {
		super();
	}

	public DonHang(int maDonHang, int maKhachHang, String soDienThoai, String diaChi, int trangThai, int tongTien,
			Date ngayTao) {
		super();
		this.maDonHang = maDonHang;
		this.maKhachHang = maKhachHang;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.trangThai = trangThai;
		this.tongTien = tongTien;
		this.ngayTao = ngayTao;
	}

	public int getMaDonHang() {
		return maDonHang;
	}

	public void setMaDonHang(int maDonHang) {
		this.maDonHang = maDonHang;
	}

	public int getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	@Override
	public String toString() {
		return "DonHang [maDonHang=" + maDonHang + ", maKhachHang=" + maKhachHang + ", soDienThoai=" + soDienThoai
				+ ", diaChi=" + diaChi + ", trangThai=" + trangThai + ", tongTien=" + tongTien + ", ngayTao=" + ngayTao
				+ "]";
	}

}
