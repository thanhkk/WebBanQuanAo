package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import model.bean.ChiTiet;
import model.bean.DonHang;
import model.bean.KhachHang;
import model.bean.SanPham;
import model.bo.ChiTietBO;
import model.bo.DonHangBO;
import model.bo.KhachHangBO;
import model.bo.SanPhamBO;

public class KiemTra {

	public static String tien(int tien) {
		Locale lc = new Locale("vi", "VN");
		NumberFormat currency = NumberFormat.getCurrencyInstance(lc);
		return currency.format(tien);
	}

	public static String trangThaiKH(int n) {
		if (n == 0)
			return "Hoạt động";
		if (n == 1)
			return "Quản trị";
		return "Bị khoá";
	}

	public static String trangThai(int n) {
		if (n == 0)
			return "Đang giao";
		if (n == 1)
			return "Đã nhận";
		return "Đã hủy";
	}

	public static String tenSanPham(String n) {
		if (n == null || "null".equals(n)) {
			return "";
		}
		return n;
	}

	public static int chuoi(String s) {

		try {
			int i = Integer.parseInt(s);
			return i;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	public static void test() {
		int n = 4;
		int chon = 3;
		if (n > 1) {
			System.out.print("<< ");
			for (int i = 1; i <= n; i++) {

				if (chon > 2 && i == 1)
					System.out.print("...");
				if (i == chon - 1)
					System.out.print(i);
				if (i == chon)
					System.out.print(i);
				if (i == chon + 1)
					System.out.print(i);
				if (chon < n - 1 && i == n)
					System.out.print("...");

			}
			System.out.println(" >>");

		}

	}

	public static void listA() {
		DonHangBO donHangBO = new DonHangBO();
		KhachHangBO khachHangBO = new KhachHangBO();
		SanPhamBO sanPhamBO = new SanPhamBO();
		ChiTietBO chiTietBO = new ChiTietBO();
		ArrayList<DonHang> listDonHang = donHangBO.getDonHangList();
		ArrayList<KhachHang> listKhachHang = khachHangBO.getKhachHangList();
		ArrayList<SanPham> listSanPham = sanPhamBO.getSanPhamList(0, "");
		ArrayList<ChiTiet> listChiTiet = chiTietBO.getChiTietList();
		ArrayList<Date> listDate = donHangBO.getMonthYear();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yyyy");

		int tongDonHang1 = 0;
		int tongDonHang2 = 0;
		int tongTienVon = 0;
		int tongTienThu = 0;
		int tongChiPhi = 0;
		int tongTienLai = 0;
		for (Date date : listDate) {

			int soDonHang1 = 0;
			int soDonHang2 = 0;
			int tienVon = 0;
			int tienThu = 0;
			int chiPhi = 0;
			int tienLai = 0;
			for (DonHang dh : listDonHang) {
				if (simpleDateFormat.format(date).equals(simpleDateFormat.format(dh.getNgayTao()))) {
					soDonHang2++;

					if (dh.getTrangThai() == 1) {
						soDonHang1++;
						for (ChiTiet ct : listChiTiet) {
							if (dh.getMaDonHang() == ct.getMaDonHang()) {
								for (SanPham sp : listSanPham) {
									if (ct.getMaSanPham() == sp.getMaSanPham()) {
										tienVon += sp.getGiaNhap();
										tienThu += sp.getGiaSanPham();

									}
								}
								chiPhi = new Random().nextInt(20) * 50000;

								tienLai = tienThu - tienVon - chiPhi;

							}
						}
					}
				}
			}
			tongTienVon += tienVon;
			tongTienThu += tienThu;
			tongChiPhi += chiPhi;
			tongTienLai += tienLai;
			tongDonHang1 += soDonHang1;
			tongDonHang2 += soDonHang2;
			System.out.print("Tháng: " + simpleDateFormat.format(date));
			System.out.print(" Đơn hàng: " + soDonHang1 + "/" + soDonHang2);
			System.out.print(" Tiền nhập: " + tienVon);
			System.out.print(" Tiền bán: " + tienThu);
			System.out.print(" Chi phí: " + chiPhi);
			System.out.print(" Tiền lãi: " + tienLai);

			System.out.println();
		}
		System.out.println("Tháng: " + listDate.size());
		System.out.println("Tổng đơn hàng: " + tongDonHang1 + "/" + tongDonHang2);
		System.out.println("Tổng tiền nhập: " + tien(tongTienVon));
		System.out.println("Tổng tiền bán: " + tien(tongTienThu));
		System.out.println("Tổng chi phí: " + tien(tongChiPhi));
		System.out.println("Tổng tiền lãi: " + tien(tongTienLai));

	}

	private static String layThuMuc() {
//		return new File("").getAbsolutePath() + "\\WebContent\\img\\sp\\";
		return "D:\\Eclipse\\BanQuanAo2\\WebContent\\img\\sp\\";
	}

	public static String diChuyenAnh(String in) {
		String out = layThuMuc();
		File dest = new File(out);
		File source = new File(in);
		System.out.println("in: " + in);
		System.out.println("in2: " + out);
		System.out.println(new File("").getAbsolutePath());
		int so = dest.list().length + 1;
		System.out.println("Số:  " + so);
		out += so + ".png";
		dest = new File(out);
		System.out.println(out);
		try {
			copyFileUsingStream(source, dest);
			return "./img/sp/" + so + ".png";
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;
	}

	private static void copyFileUsingStream(File source, File dest) throws IOException {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(source);
			os = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} finally {
			is.close();
			os.close();
		}
	}

	public static void doTaiXiu() {

		Random rd = new Random();
		int xucXac1 = 0;
		int xucXac2 = 0;
		int xucXac3 = 0;
		int ngay = 300;
		int bet = 100;
		int t = 0;
		int cuoc = 100;
		int tien = 500000000;
		int luot = 0;
		for (int i = 0; i < 40 * 24 * ngay; i++) {
			if (tien < 0)
				break;
			System.out.print("ván thứ: " + i + 1 + " = ");
			xucXac1 = rd.nextInt(6) + 1;
			xucXac2 = rd.nextInt(6) + 1;
			xucXac3 = rd.nextInt(6) + 1;
			int tong = xucXac1 + xucXac2 + xucXac3;
			t++;
			if (tong < 11) {
				System.out.print("Xỉu:(" + xucXac1 + "," + xucXac2 + "," + xucXac3 + ")");
			} else {
				System.out.print("Tài:(" + xucXac1 + "," + xucXac2 + "," + xucXac3 + ")");
			}
			if (t < 3) {
				System.out.print("Bet tài: " + tien(bet));
				if (tong > 10) {
					System.out.print(" WIN " + tien(cuoc));
					luot = 0;
					tien += cuoc;
				} else {
					System.out.print(" LOSE " + tien(cuoc));
					luot++;
					tien -= cuoc;
				}
			} else {
				System.out.print("Bet xỉu: " + tien(bet));
				if (tong < 11) {
					System.out.print(" WIN " + tien(cuoc));
					luot = 0;
					tien += cuoc;
				} else {
					System.out.print(" LOSE " + tien(cuoc));
					luot++;
					tien -= cuoc;
				}
				if (t > 3) {
					t = 0;
				}
			}

			if (luot > 0) {
				cuoc *= 2.5;
			}
			if (luot > 14) {
				luot = 0;
			}
			if (luot == 0) {
				cuoc = 100;
			}
			System.out.println(" túi còn: " + tien(tien) + " thua lầnthứ:" + luot + " ngày " + i / 40 / 24);
		}
	}

	public static void hehe() {
		Random rd = new Random();
		String soi = "";
		ArrayList<String> list = new ArrayList<String>();
		int xucXac1 = 0;
		int xucXac2 = 0;
		int xucXac3 = 0;
		for (int i = 0; i < 10000; i++) {
			xucXac1 = rd.nextInt(6) + 1;
			xucXac2 = rd.nextInt(6) + 1;
			xucXac3 = rd.nextInt(6) + 1;
			int tong = xucXac1 + xucXac2 + xucXac3;
			if (tong > 10) {
				soi += "T";
			} else {
				soi += "X";
			}
		}
		for (int i = 0; i < soi.length(); i++) {
			if (soi.length() - i > 13) {
				String a = "";
				for (int j = 0; j < 13; j++) {
					a += soi.charAt(i + j);
				}

				list.add(a);
			}
		}
		for (String string : list) {
			int dem = 0;
			for (String string2 : list) {
				if (string.equals(string2)) {
					dem++;
				}
			}
			if (dem == 1) {
				System.out.println(string);
			}
		}
		System.out.println("Xong");

	}

	public static void main(String[] args) {
//		doCopyFileImg("C:\\Users\\thanhtv\\Desktop\\tumblr_p92v8pxcvm1rogvb0o1_1280.jpg");
//		System.out.println(diChuyenAnh("C:\\Users\\thanhtv\\Desktop\\ss.jpg"));
//		doTaiXiu();
		hehe();

//		System.out.println("D:\\Eclipse/BanQuanAo2WebContent/img/sp".replaceAll("\\\\", "/"));

	}

}
