package model.bean;

public class KhachHang {
	private int maKhachHang;
	private String hoVaTen;
	private String tenDangNhap;
	private String matKhau;
	private String soDienThoai;
	private String diaChi;
	private int capBac;

	public KhachHang() {
		super();
	}

	public KhachHang(int maKhachHang, String hoVaTen, String tenDangNhap, String matKhau, String soDienThoai,
			String diaChi, int capBac) {
		super();
		this.maKhachHang = maKhachHang;
		this.hoVaTen = hoVaTen;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.capBac = capBac;
	}

	public int getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
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

	public int getCapBac() {
		return capBac;
	}

	public void setCapBac(int capBac) {
		this.capBac = capBac;
	}

	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", hoVaTen=" + hoVaTen + ", tenDangNhap=" + tenDangNhap
				+ ", matKhau=" + matKhau + ", soDienThoai=" + soDienThoai + ", diaChi=" + diaChi + ", capBac=" + capBac
				+ "]";
	}

}
