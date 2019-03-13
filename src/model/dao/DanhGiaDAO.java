package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.DanhGia;

public class DanhGiaDAO {

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

	public boolean addDanhGia(DanhGia danhGia) {
		String sql = String.format(
				"INSERT dbo.tblDanhGia\r\n" + "        ( maSanPham ,\r\n" + "          maKhachHang ,\r\n"
						+ "          diemDanhGia ,\r\n" + "          binhLuan\r\n" + "        )\r\n"
						+ "VALUES  ( %s , -- maSanPham - int\r\n" + "          %s , -- maKhachHang - int\r\n"
						+ "          %s , -- diemDanhGia - int\r\n" + "          N'%s'  -- binhLuan - nvarchar(max)\r\n"
						+ "        )",
				danhGia.getMaSanPham(), danhGia.getMaKhachHang(), danhGia.getDiemDanhGia(), danhGia.getBinhLuan());
		return xuLy(sql);
	}

	public ArrayList<DanhGia> getDanhGiaList(int maSanPham) {
		ArrayList<DanhGia> list = new ArrayList<>();
		String sql = "SELECT * FROM dbo.tblDanhGia WHERE maSanPham=" + maSanPham;
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				list.add(new DanhGia(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return list;
	}

	public boolean deleteDanhGia(int maDanhGia) {
		String sql = "DELETE dbo.tblDanhGia WHERE maDanhGia=" + maDanhGia;
		return xuLy(sql);
	}

	public static void main(String[] args) {

		DanhGiaDAO d = new DanhGiaDAO();
		System.out.println(d.deleteDanhGia(3));
	}

}
