package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.ChiTiet;

public class ChiTietDAO {
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

	public boolean addChiTiet(ChiTiet chiTiet) {
		String sql = String.format(
				"INSERT dbo.tblChiTiet\r\n" + "        ( maDonHang ,\r\n" + "          maSanPham ,\r\n"
						+ "          soLuong ,\r\n" + "          thanhTien\r\n" + "        )\r\n"
						+ "VALUES  ( %s , -- maDonHang - int\r\n" + "          %s , -- maSanPham - int\r\n"
						+ "          %s , -- soLuong - int\r\n" + "          %s  -- thanhTien - int\r\n" + "        )",
				chiTiet.getMaDonHang(), chiTiet.getMaSanPham(), chiTiet.getSoLuong(), chiTiet.getThanhTien());
		return xuLy(sql);
	}

	public boolean editChiTiet(ChiTiet chiTiet) {
		String sql = String.format(
				"UPDATE dbo.tblChiTiet SET maDonHang=%s,maSanPham=%s,soLuong=%s,thanhTien=%s WHERE maChiTiet=%s;",
				chiTiet.getMaDonHang(), chiTiet.getMaSanPham(), chiTiet.getSoLuong(), chiTiet.getThanhTien(),
				chiTiet.getMaChiTiet());
		return xuLy(sql);
	}

	public ChiTiet getChiTiet(int maChiTiet) {
		String sql = "SELECT * FROM dbo.tblChiTiet WHERE maChiTiet=" + maChiTiet;
		ChiTiet chiTiet = null;
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			if (rs.next()) {
				chiTiet = new ChiTiet(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return chiTiet;
	}

	public boolean deleteChiTiet(int maChiTiet) {
		String sql = "DELETE dbo.tblChiTiet WHERE maChiTiet=" + maChiTiet;
		return xuLy(sql);
	}

	public ArrayList<ChiTiet> getChiTietList() {
		String sql = "SELECT * FROM dbo.tblChiTiet";
		ArrayList<ChiTiet> list = new ArrayList<>();
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				list.add(new ChiTiet(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return list;
	}

	public ArrayList<ChiTiet> getChiTietList2(int maDonHang) {
		String sql = "SELECT * FROM dbo.tblChiTiet WHERE maDonHang=" + maDonHang;
		ArrayList<ChiTiet> list = new ArrayList<>();
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				list.add(new ChiTiet(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return list;
	}

	public static void main(String[] args) {
		ChiTietDAO c = new ChiTietDAO();
		System.out.println(c.getChiTietList().size());
	}

}
