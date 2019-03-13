package model.bean;

public class DanhGia {
	private int maDanhGia;
	private int maSanPham;
	private int maKhachHang;
	private int diemDanhGia;
	private String binhLuan;

	public DanhGia() {
		super();
	}

	public DanhGia(int maDanhGia, int maSanPham, int maKhachHang, int diemDanhGia, String binhLuan) {
		super();
		this.maDanhGia = maDanhGia;
		this.maSanPham = maSanPham;
		this.maKhachHang = maKhachHang;
		this.diemDanhGia = diemDanhGia;
		this.binhLuan = binhLuan;
	}

	public int getMaDanhGia() {
		return maDanhGia;
	}

	public void setMaDanhGia(int maDanhGia) {
		this.maDanhGia = maDanhGia;
	}

	public int getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(int maSanPham) {
		this.maSanPham = maSanPham;
	}

	public int getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public int getDiemDanhGia() {
		return diemDanhGia;
	}

	public void setDiemDanhGia(int diemDanhGia) {
		this.diemDanhGia = diemDanhGia;
	}

	public String getBinhLuan() {
		return binhLuan;
	}

	public void setBinhLuan(String binhLuan) {
		this.binhLuan = binhLuan;
	}

	@Override
	public String toString() {
		return "DanhGia [maDanhGia=" + maDanhGia + ", maSanPham=" + maSanPham + ", maKhachHang=" + maKhachHang
				+ ", diemDanhGia=" + diemDanhGia + ", binhLuan=" + binhLuan + "]";
	}

}
