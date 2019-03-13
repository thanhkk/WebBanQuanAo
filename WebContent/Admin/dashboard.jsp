<%@page import="java.util.Random"%>
<%@page import="common.KiemTra"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="model.bean.ChiTiet"%>
<%@page import="model.bean.SanPham"%>
<%@page import="model.bean.DonHang"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>

<%
	ArrayList<DonHang> listDonHang = (ArrayList<DonHang>) request.getAttribute("listDonHang");
	ArrayList<KhachHang> listKhachHang = (ArrayList<KhachHang>) request.getAttribute("listKhachHang");
	ArrayList<SanPham> listSanPham = (ArrayList<SanPham>) request.getAttribute("listSanPham");
	ArrayList<ChiTiet> listChiTiet = (ArrayList<ChiTiet>) request.getAttribute("listChiTiet");
	ArrayList<Date> listDate = (ArrayList<Date>) request.getAttribute("listDate");
%>

<div class="tieude text-center">
	<h3>Dashboard</h3>

	<%
		if (thanhCong != null) {
	%>
	<div class="thanhcong badge badge-success">
		<i class="fas fa-check"></i><%=thanhCong%>
	</div>
	<%
		}
		if (thatBai != null) {
	%>
	<div class="thatbai badge badge-danger">
		<i class="fas fa-exclamation-triangle"></i><%=thatBai%>
	</div>

	<%
		}
	%>


</div>
<div class="row">
	<div class="col-sm-3">
		<div class="widget text-success">
			<h4>
				<i class="fas fa-users"></i>
				<%
					int dem = 0;
					for (KhachHang kh : listKhachHang) {
						if (kh.getCapBac() == 0) {
							dem++;
						}
					}
				%><%=dem%>
				Khách hàng
			</h4>
		</div>
	</div>
	<div class="col-sm-3">
		<div class="widget text-info">
			<h4>
				<i class="fas fa-address-card"></i><%=listDonHang.size()%>
				Đơn hàng

			</h4>
		</div>
	</div>
	<div class="col-sm-3">
		<div class="widget text-warning">
			<h4>
				<i class="fas fa-server"></i><%=listSanPham.size()%>
				Sản phẩm
			</h4>
		</div>
	</div>
	<div class="col-sm-3">
		<div class="widget text-danger">
			<h4>
				<i class="fas fa-user-tie"></i></i><%=listKhachHang.size() - dem%>
				Quản trị
			</h4>
		</div>
	</div>
</div>
<div class="bang">
	<h3 class="text-center">Báo cáo doanh thu theo tháng</h3>
	<table id="example"
		class="table table-striped table-bordered text-center">
		<thead>
			<tr>
				<th>STT</th>
				<th>Tháng năm</th>
				<th>Đơn hàng</th>
				<th>Tiền nhập</th>
				<th>Tiền bán</th>
				<th>Chi phí khác</th>
				<th>Lợi nhuận</th>
			</tr>
		</thead>
		<tbody>

			<%
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yyyy");

				int tongDonHang1 = 0;
				int tongDonHang2 = 0;
				int tongTienVon = 0;
				int tongTienThu = 0;
				int tongChiPhi = 0;
				int tongTienLai = 0;
				int stt = 0;
				for (Date date : listDate) {
			%><tr>
				<%
					stt++;
						int soDonHang1 = 0;
						int soDonHang2 = 0;
						int tienVon = 0;
						int tienThu = 0;
						int chiPhi = 0;
						int tienLai = 0;
						chiPhi = 50000;
						for (DonHang dh : listDonHang) {
							if (simpleDateFormat.format(date).equals(simpleDateFormat.format(dh.getNgayTao()))) {
								soDonHang2++;
								if (dh.getTrangThai() == 1) {
									soDonHang1++;
									tienVon += dh.getTongTien() / 100 * 50;
									tienThu += dh.getTongTien();

								}
							}
						}
						tienLai = tienThu - tienVon - chiPhi;
						tongTienVon += tienVon;
						tongTienThu += tienThu;
						tongChiPhi += chiPhi;
						tongTienLai += tienLai;
						tongDonHang1 += soDonHang1;
						tongDonHang2 += soDonHang2;
				%>
				<td><%=stt%></td>
				<td><%=simpleDateFormat.format(date)%></td>
				<td><%=soDonHang1%>/<%=soDonHang2%></td>
				<td><%=KiemTra.tien(tienVon)%></td>
				<td><%=KiemTra.tien(tienThu)%></td>
				<td><%=KiemTra.tien(chiPhi)%></td>
				<td><%=KiemTra.tien(tienLai)%></td>
			</tr>
			<%
				}
			%>


		</tbody>
		<tfoot>
			<tr>
				<th>Tổng</th>
				<th><%=listDate.size()%> tháng</th>
				<th><%=tongDonHang1%>/<%=tongDonHang2%></th>
				<th><%=KiemTra.tien(tongTienVon)%></th>
				<th><%=KiemTra.tien(tongTienThu)%></th>
				<th><%=KiemTra.tien(tongChiPhi)%></th>
				<th><%=KiemTra.tien(tongTienLai)%></th>
			</tr>
		</tfoot>





	</table>
</div>


<%@include file="footer.jsp"%>
