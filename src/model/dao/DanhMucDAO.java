package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.DanhMuc;

public class DanhMucDAO {
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

	public boolean addDanhMuc(DanhMuc danhMuc) {
		String sql = String.format(
				" INSERT dbo.tblDanhMuc\r\n" + "         ( tenDanhMuc )\r\n"
						+ " VALUES  ( N'%s'  -- tenDanhMuc - nvarchar(50)\r\n" + "           )",
				danhMuc.getTenDanhMuc());
		return xuLy(sql);
	}

	public boolean editDanhMuc(DanhMuc danhMuc) {
		String sql = String.format(" UPDATE dbo.tblDanhMuc SET tenDanhMuc=N'%s' WHERE maDanhMuc=%s",
				danhMuc.getTenDanhMuc(), danhMuc.getMaDanhMuc());
		return xuLy(sql);
	}

	public boolean deleteDanhMuc(int maDanhMuc) {
		String sql = "DELETE dbo.tblDanhMuc WHERE maDanhMuc=" + maDanhMuc;
		return xuLy(sql);
	}

	public DanhMuc getDanhMuc2(int maDanhMuc) {
		String sql = " SELECT * FROM dbo.tblDanhMuc WHERE maDanhMuc=" + maDanhMuc;
		DanhMuc danhMuc = null;
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			if (rs.next()) {
				danhMuc = new DanhMuc(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return danhMuc;
	}

	public ArrayList<DanhMuc> getDanhMucList() {
		String sql = "SELECT * FROM dbo.tblDanhMuc";
		ArrayList<DanhMuc> list = new ArrayList<>();
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				list.add(new DanhMuc(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return list;
	}

	public static void main(String[] args) {

	}

}
