package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.SanPham;

public class SanPhamDAO {
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
			System.out.println(sql);
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

	public boolean addSanPham(SanPham sanPham) {
		String sql = String.format(
				"INSERT dbo.tblSanPham\r\n" + "		        ( tenSanPham ,\r\n" + "		          maDanhMuc ,\r\n"
						+ "		          giaSanPham ,\r\n" + "		          linkSanPham ,\r\n"
						+ "		          giaNhap\r\n" + "		        )\r\n"
						+ "		VALUES  ( N'%s' , -- tenSanPham - nvarchar(50)\r\n"
						+ "		          %s , -- maDanhMuc - int\r\n" + "		          %s , -- giaSanPham - int\r\n"
						+ "		          N'%s' , -- linkSanPham - nvarchar(max)\r\n"
						+ "		          %s  -- giaNhap - int\r\n" + "		        )",
				sanPham.getTenSanPham(), sanPham.getMaDanhMuc(), sanPham.getGiaSanPham(), sanPham.getLinkSanPham(),
				sanPham.getGiaNhap());
		return xuLy(sql);
	}

	public boolean editSanPham(SanPham sanPham) {
		String sql = String.format(
				"UPDATE  dbo.tblSanPham\r\n" + "SET     tenSanPham = N'%s' ,\r\n" + "        maDanhMuc = %s ,\r\n"
						+ "        giaSanPham = %s ,\r\n" + "        linkSanPham = N'%s' ,\r\n"
						+ "        giaNhap = %s\r\n" + "WHERE   maSanPham = %s",
				sanPham.getTenSanPham(), sanPham.getMaDanhMuc(), sanPham.getGiaSanPham(), sanPham.getLinkSanPham(),
				sanPham.getGiaNhap(), sanPham.getMaSanPham());
		return xuLy(sql);
	}

	public boolean deleteSanPham(int maSanPham) {
		String sql = "DELETE dbo.tblSanPham WHERE maSanPham=" + maSanPham;
		return xuLy(sql);
	}

	public SanPham getSanPham(int maSanPham) {
		String sql = "SELECT * FROM dbo.tblSanPham WHERE MaSanPham=" + maSanPham;
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			System.out.println(sql);
			if (rs.next())
				return new SanPham(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6));
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return null;
	}

	public ArrayList<SanPham> getSanPhamList(int maDanhMuc, String tenSanPham) {
		String sql = "SELECT * FROM dbo.tblSanPham WHERE tenSanPham LIKE N'%" + tenSanPham + "%'";
		ArrayList<SanPham> list = new ArrayList<>();
		if (maDanhMuc > 0) {
			String sql2 = "  AND maDanhMuc=" + maDanhMuc;
			sql += sql2;
		}
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				list.add(new SanPham(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6)));
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
