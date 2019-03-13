package model.bean;

public class SanPham {
	private int maSanPham;
	private String tenSanPham;
	private int maDanhMuc;
	private int giaSanPham;
	private String linkSanPham;
	private int giaNhap;

	public SanPham() {
		super();
	}

	public SanPham(int maSanPham, String tenSanPham, int maDanhMuc, int giaSanPham, String linkSanPham, int giaNhap) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.maDanhMuc = maDanhMuc;
		this.giaSanPham = giaSanPham;
		this.linkSanPham = linkSanPham;
		this.giaNhap = giaNhap;
	}

	public int getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(int maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public int getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(int maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}

	public int getGiaSanPham() {
		return giaSanPham;
	}

	public void setGiaSanPham(int giaSanPham) {
		this.giaSanPham = giaSanPham;
	}

	public String getLinkSanPham() {
		return linkSanPham;
	}

	public void setLinkSanPham(String linkSanPham) {
		this.linkSanPham = linkSanPham;
	}

	public int getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(int giaNhap) {
		this.giaNhap = giaNhap;
	}

	@Override
	public String toString() {
		return "SanPham [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", maDanhMuc=" + maDanhMuc
				+ ", giaSanPham=" + giaSanPham + ", linkSanPham=" + linkSanPham + ", giaNhap=" + giaNhap + "]";
	}

}
