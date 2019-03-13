<%@page import="model.bean.DonHang"%>
<%@page import="model.bean.ChiTiet"%>
<%@page import="model.bean.ChiTiet"%>
<%@page import="model.bean.DanhMuc"%>
<%@page import="common.KiemTra"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<%
	ArrayList<ChiTiet> listChiTiet = (ArrayList<ChiTiet>) request.getAttribute("listChiTiet");
	boolean capNhat = (boolean) request.getAttribute("capNhat");
	ChiTiet chiTiet = (ChiTiet) request.getAttribute("chiTiet");
	DonHang donHang = (DonHang) request.getAttribute("donHang");
%>

<div class="tieude text-center">
	<h3>Quản lý chi tiết đơn hàng</h3>

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

<div class="edit">
	<h3 class="text-center">
		<%
			if (capNhat) {
		%>Cập nhật<%
			} else {
		%>Thêm mới<%
			}
		%>
	</h3>
	<div class="col-sm-8 offset-2">
		<form action="ChiTietDonHangSV?maDonHang=<%=donHang.getMaDonHang()%>"
			method="post">




			<div class="form-group">
				<label for="maSanPham">Mã sản phẩm:</label> <input type="number"
					class="form-control" id="maSanPham" name="maSanPham"
					<%if (chiTiet != null) {%> value="<%=chiTiet.getMaSanPham()%>"
					<%}%> required>
			</div>
			<div class="form-group">
				<label for="soLuong">Số lượng:</label> <input type="number"
					class="form-control" id="soLuong" name="soLuong"
					<%if (chiTiet != null) {%> value="<%=chiTiet.getSoLuong()%>" <%}%>
					required>
			</div>


			<div class="form-group">
				<label for="thanhTien">Thành tiền:</label> <input type="number"
					class="form-control" id="thanhTien" name="thanhTien"
					<%if (chiTiet != null) {%> value="<%=chiTiet.getThanhTien()%>"
					<%}%> required="required">
			</div>

			<center>


				<%
					if (!capNhat) {
				%>
				<button type="submit" class="btn btn-success text-center"
					name="themCTDH" value="themCTDH">Thêm mới</button>
				<%
					} else {
				%>




				<input type="hidden" name="maChiTiet"
					value="<%=chiTiet.getMaChiTiet()%>">

				<button type="submit" class="btn btn-primary text-center"
					name="capNhatCTDH" value="capNhatCTDH">Cập nhật</button>
				<button type="submit" class="btn btn-warning text-center"
					name="huyCTDH" value="huyCTDH">Huỷ</button>
				<%
					}
				%>


			</center>
		</form>
	</div>
</div>
<div class="bang">
	<!-- <h3 class="text-center">Chỉnh sửa</h3> -->
	<table id="example"
		class="table table-striped table-bordered text-center">
		<thead>
			<tr>
				<th>STT</th>
				<th>Mã chi tiết</th>
				<th>Mã sản phẩm</th>
				<th>Số lượng</th>
				<th>Thành tiền</th>
				<th>Tuỳ chọn</th>
			</tr>
		</thead>
		<tbody>
			<%
				if (listChiTiet != null & listChiTiet.size() > 0)
					for (int i = 0; i < listChiTiet.size(); i++) {
			%>

			<tr>
				<td><%=i + 1%></td>
				<td><%=listChiTiet.get(i).getMaChiTiet()%></td>
				<td><%=listChiTiet.get(i).getMaSanPham()%></td>
				<td><%=listChiTiet.get(i).getSoLuong()%></td>
				<td><%=KiemTra.tien(listChiTiet.get(i).getThanhTien())%></td>
				<td id="tuychon"><a
					href="ChiTietDonHangSV?suaCTDH=suaCTDH&maDonHang=<%=listChiTiet.get(i).getMaDonHang()%>&maChiTiet=<%=listChiTiet.get(i).getMaChiTiet()%>"
					title="Sửa chi tiết đơn hàng" id="edit"> <i class="far fa-edit"></i></a>
					<a
					href="ChiTietDonHangSV?xoaCTDH=xoaCTDH&maDonHang=<%=listChiTiet.get(i).getMaDonHang()%>&maChiTiet=<%=listChiTiet.get(i).getMaChiTiet()%>"
					title="Xoá chi tiết đơn hàng" id="delete"><i
						class="far fa-trash-alt"></i></a></td>
			</tr>


			<%
				}
			%>

		</tbody>
		<tfoot>
			<tr>
				<th>STT</th>
				<th>Mã chi tiết</th>
				<th>Mã sản phẩm</th>
				<th>Số lượng</th>
				<th>Thành tiền</th>
				<th>Tuỳ chọn</th>
			</tr>
		</tfoot>
	</table>
</div>



<%@include file="footer.jsp"%>
