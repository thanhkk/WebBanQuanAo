package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.bean.DonHang;

public class DonHangDAO {
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

	public ArrayList<DonHang> getDonHangList() {
		String sql = String.format("SELECT * FROM dbo.tblDonHang");
		ArrayList<DonHang> list = new ArrayList<>();
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next())
				list.add(new DonHang(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getDate(7)));
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return list;

	}

	public DonHang getDonHang(int maDonHang) {
		String sql = "SELECT * FROM dbo.tblDonHang WHERE maDonHang=" + maDonHang;
		DonHang donHang = null;
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			if (rs.next())
				donHang = new DonHang(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getDate(7));
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return donHang;
	}

	public ArrayList<DonHang> getDonHangList2(int maKhachHang) {
		String sql = "SELECT * FROM dbo.tblDonHang WHERE maKhachHang=" + maKhachHang + " ORDER BY ngayTao DESC";
		ArrayList<DonHang> list = new ArrayList<>();
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next())
				list.add(new DonHang(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getDate(7)));
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return list;

	}

	public boolean editDonHangTrangThai(int maDonHang, int trangThai) {
		String sql = "UPDATE dbo.tblDonHang SET trangThai=" + trangThai + " WHERE maDonHang=" + maDonHang;
		return xuLy(sql);
	}

	public int getMaDonHangMax() {
		String sql = "SELECT MAX(maDonHang) FROM dbo.tblDonHang";
		int n = 0;
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			if (rs.next())
				n = rs.getInt(1);
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return n + 1;
	}

	public boolean deleteDonHang(int maDonHang) {
		String sql = "  DELETE dbo.tblDonHang WHERE maDonHang=" + maDonHang;
		return xuLy(sql);
	}

	public boolean editDonHang(DonHang donHang) {
		SimpleDateFormat sp = new SimpleDateFormat("MM/dd/yyyy");
		String sql = String.format(
				"UPDATE  dbo.tblDonHang\r\n" + "SET     maKhachHang = %s ,\r\n" + "        soDienThoai = '%s' ,\r\n"
						+ "        diaChi = N'%s' ,\r\n" + "        trangThai = %s ,\r\n"
						+ "        tongTien = %s ,\r\n" + "        ngayTao = '%s'\r\n" + "WHERE   maDonHang = %s",
				donHang.getMaKhachHang(), donHang.getSoDienThoai(), donHang.getDiaChi(), donHang.getTrangThai(),
				donHang.getTongTien(), sp.format(donHang.getNgayTao()), donHang.getMaDonHang());

		return xuLy(sql);
	}

	public boolean addDonHang(DonHang donHang) {
		String sql = String.format(
				"INSERT dbo.tblDonHang\r\n" + "		        ( maDonHang ,\r\n" + "		          maKhachHang ,\r\n"
						+ "		          soDienThoai ,\r\n" + "		          diaChi ,\r\n"
						+ "		          trangThai ,\r\n" + "		          tongTien ,\r\n"
						+ "		          ngayTao\r\n" + "		        )\r\n"
						+ "		VALUES  ( %s , -- maDonHang - int\r\n" + "		          %s , -- maKhachHang - int\r\n"
						+ "		          N'%s' , -- soDienThoai - nvarchar(50)\r\n"
						+ "		          N'%s' , -- diaChi - nvarchar(max)\r\n"
						+ "		          0 , -- trangThai - int\r\n" + "		          0 , -- tongTien - int\r\n"
						+ "		          GETDATE()  -- ngayTao - date\r\n" + "		        )",
				donHang.getMaDonHang(), donHang.getMaKhachHang(), donHang.getSoDienThoai(), donHang.getDiaChi());
		return xuLy(sql);
	}

	public ArrayList<Date> getMonthYear() {
		String sql = "SELECT MONTH(ngayTao), YEAR(ngayTao) FROM dbo.tblDonHang\r\n"
				+ "GROUP BY MONTH(ngayTao) , YEAR(ngayTao)\r\n" + "ORDER BY   YEAR(ngayTao) DESC, MONTH(ngayTao) DESC";
		ArrayList<Date> list = new ArrayList<>();
		SimpleDateFormat sp = new SimpleDateFormat("MM/yyyy");
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next())
				list.add(sp.parse(rs.getString(1) + "/" + rs.getString(2)));
		} catch (SQLException | ParseException e) {

			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return list;
	}

	public static void main(String[] args) {
		DonHangDAO d = new DonHangDAO();
//		System.out.println(d.getDonHangList().toString());
		System.out.println(d.getMonthYear());
	}

}
