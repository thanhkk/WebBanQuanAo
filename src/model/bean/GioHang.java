package model.bean;

public class GioHang {
	private int idGioHang;
	private int soLuong;
	private SanPham sanPham;

	public GioHang() {
		super();
	}

	public GioHang(int idGioHang, int soLuong, SanPham sanPham) {
		super();
		this.idGioHang = idGioHang;
		this.soLuong = soLuong;
		this.sanPham = sanPham;
	}

	public int getIdGioHang() {
		return idGioHang;
	}

	public void setIdGioHang(int idGioHang) {
		this.idGioHang = idGioHang;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	@Override
	public String toString() {
		return "GioHang [idGioHang=" + idGioHang + ", soLuong=" + soLuong + ", sanPham=" + sanPham + "]";
	}



}
