package model.bean;

public class ChiTiet {
	private int maChiTiet;
	private int maDonHang;
	private int maSanPham;
	private int soLuong;
	private int thanhTien;

	public ChiTiet() {
		super();
	}

	public ChiTiet(int maChiTiet, int maDonHang, int maSanPham, int soLuong, int thanhTien) {
		super();
		this.maChiTiet = maChiTiet;
		this.maDonHang = maDonHang;
		this.maSanPham = maSanPham;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}

	public int getMaChiTiet() {
		return maChiTiet;
	}

	public void setMaChiTiet(int maChiTiet) {
		this.maChiTiet = maChiTiet;
	}

	public int getMaDonHang() {
		return maDonHang;
	}

	public void setMaDonHang(int maDonHang) {
		this.maDonHang = maDonHang;
	}

	public int getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(int maSanPham) {
		this.maSanPham = maSanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(int thanhTien) {
		this.thanhTien = thanhTien;
	}

	@Override
	public String toString() {
		return "ChiTiet [maChiTiet=" + maChiTiet + ", maDonHang=" + maDonHang + ", maSanPham=" + maSanPham
				+ ", soLuong=" + soLuong + ", thanhTien=" + thanhTien + "]";
	}

}
