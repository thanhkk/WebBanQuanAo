package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.KhachHang;

public class KhachHangDAO {

	private Connection conn;

	public void moKetNoi() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=BanQuanAo2", "sa",
					"123456");
			System.out.println("Kết nối OK");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean xuLy(String sql) {
		try {
			moKetNoi();
			conn.createStatement().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return false;

	}

	public void dongKetNoi() {
		try {
			conn.close();
			System.out.println("Đóng kết nối OK");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Boolean addKhachHang(KhachHang khachHang) {
		String sql = String.format(
				"INSERT dbo.tblKhachHang\r\n" + "        ( hoVaTen ,\r\n" + "          tenDangNhap ,\r\n"
						+ "          matKhau ,\r\n" + "          soDienThoai ,\r\n" + "          diaChi ,\r\n"
						+ "          capBac\r\n" + "        )\r\n" + "VALUES  ( N'%s' , -- hoVaTen - nvarchar(50)\r\n"
						+ "          N'%s' , -- tenDangNhap - nvarchar(50)\r\n"
						+ "          N'%s' , -- matKhau - nvarchar(50)\r\n"
						+ "          N'%s' , -- soDienThoai - nvarchar(50)\r\n"
						+ "          N'%s' , -- diaChi - nvarchar(max)\r\n" + "          %s  -- capBac - int\r\n"
						+ "        )",
				khachHang.getHoVaTen(), khachHang.getTenDangNhap(), khachHang.getMatKhau(), khachHang.getSoDienThoai(),
				khachHang.getDiaChi(), khachHang.getCapBac());
		return xuLy(sql);
	}

	public boolean editKhachHang(KhachHang khachHang) {
		String sql = String.format(
				"UPDATE dbo.tblKhachHang SET hoVaTen=N'%s',tenDangNhap=N'%s',matKhau=N'%s',soDienThoai=N'%s',diaChi=N'%s',capBac=%s WHERE maKhachHang=%s",
				khachHang.getHoVaTen(), khachHang.getTenDangNhap(), khachHang.getMatKhau(), khachHang.getSoDienThoai(),
				khachHang.getDiaChi(), khachHang.getCapBac(), khachHang.getMaKhachHang());
		return xuLy(sql);
	}

	public boolean deleteKhachHang(int maKhachHang) {
		String sql = "DELETE dbo.tblKhachHang WHERE maKhachHang=" + maKhachHang;
		return xuLy(sql);
	}

	public KhachHang getKhachHang(String tenDangNhap, String matKhau) {
		String sql = String.format("SELECT * FROM dbo.tblKhachHang WHERE tenDangNhap='%s' AND matKhau='%s';",
				tenDangNhap, matKhau);
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			if (rs.next())
				return new KhachHang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return null;
	}

	public KhachHang getKhachHang2(int maKhachHang) {
		String sql = "SELECT * FROM dbo.tblKhachHang WHERE maKhachHang=" + maKhachHang;
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			if (rs.next())
				return new KhachHang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return null;
	}

	public ArrayList<KhachHang> getKhachHangList() {
		String sql = "SELECT * FROM dbo.tblKhachHang";
		ArrayList<KhachHang> list = new ArrayList<>();
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				list.add(new KhachHang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7)));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return list;
	}

	public static void main(String[] args) {
		KhachHangDAO k = new KhachHangDAO();
		System.out.println(k.getKhachHang("user02", "123456"));
	}

}
