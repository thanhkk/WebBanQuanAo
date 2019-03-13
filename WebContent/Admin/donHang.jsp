<%@page import="model.bean.DonHang"%>
<%@page import="model.bean.DanhMuc"%>
<%@page import="common.KiemTra"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<%
	ArrayList<DonHang> listDonHang = (ArrayList<DonHang>) request.getAttribute("listDonHang");
	boolean capNhat = (boolean) request.getAttribute("capNhat");
	DonHang donHang = (DonHang) request.getAttribute("donHang");
%>

<div class="tieude text-center">
	<h3>Quản lý đơn hàng</h3>

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
		<form action="DonHangSV" enctype="multipart/form-data">
			<div class="form-group">
				<label for="maKhachHang">Mã khách hàng:</label> <input type="number"
					class="form-control" id="maKhachHang" name="maKhachHang"
					<%if (donHang != null) {%> value="<%=donHang.getMaKhachHang()%>"
					<%}%> required>
			</div>
			<div class="form-group">
				<label for="soDienThoai">Số điện thoại:</label> <input type="text"
					class="form-control" id="soDienThoai" name="soDienThoai"
					<%if (donHang != null) {%> value="<%=donHang.getSoDienThoai()%>"
					<%}%> required>
			</div>
			
			
			<div class="form-group">
				<label for="diaChi">Địa chỉ:</label> <input type="text"
					class="form-control" id="diaChi" name="diaChi"
					<%if (donHang != null) {%> value="<%=donHang.getDiaChi()%>" <%}%>
					required>
			</div>
			<div class="form-group">
				<label for="trangThai">Trạng thái:</label> <select name="trangThai"
					id="trangThai" class="form-control" required>
					<option value="0"
						<%if (donHang != null && donHang.getTrangThai() == 0) {%> selected
						<%}%>>Đang giao</option>
					<option value="1"
						<%if (donHang != null && donHang.getTrangThai() == 1) {%> selected
						<%}%>>Đã nhận</option>
					<option value="2"
						<%if (donHang != null && donHang.getTrangThai() == 2) {%> selected
						<%}%>>Đã huỷ</option>
				</select>
			</div>
			<div class="form-group">
				<label for="tongTien">Tổng tiền:</label> <input type="number"
					class="form-control" id="tongTien" name="tongTien"
					<%if (donHang != null) {%> value="<%=donHang.getTongTien()%>" <%}%>
					required>
			</div>
			<div class="form-group">
				<label for="ngayTao">Ngày tạo:</label> <input type="date"
					class="form-control" id="ngayTao" name="ngayTao"
					<%if (donHang != null) {%> value="<%=donHang.getNgayTao()%>" <%}%>
					required>
			</div>
			<center>
				<%
					if (!capNhat) {
				%>
				<button type="submit" class="btn btn-success text-center"
					name="themDH" value="themDH">Thêm mới</button>
				<%
					} else {
				%>

				<input type="hidden" name="maDonHang"
					value="<%=donHang.getMaDonHang()%>">

				<button type="submit" class="btn btn-primary text-center"
					name="capNhatDH" value="capNhatDH">Cập nhật</button>
				<button type="submit" class="btn btn-warning text-center"
					name="huyDH" value="huyDH">Huỷ</button>
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
				<th>Mã đơn hàng</th>
				<th>Mã khách hàng</th>
				<th>Số điện thoại</th>
				<th>Địa chỉ</th>
				<th>Trạng thái</th>
				<th>Tổng tiền</th>
				<th>Ngày tạo</th>
				<th>Tuỳ chọn</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (int i = 0; i < listDonHang.size(); i++) {
			%>

			<tr>
				<td><%=i + 1%></td>
				<td><%=listDonHang.get(i).getMaDonHang()%></td>
				<td><%=listDonHang.get(i).getMaKhachHang()%></td>
				<td><%=listDonHang.get(i).getSoDienThoai()%></td>
				<td><%=listDonHang.get(i).getDiaChi()%></td>
				<td><%=KiemTra.trangThai(listDonHang.get(i).getTrangThai())%></td>
				<td><%=KiemTra.tien(listDonHang.get(i).getTongTien())%></td>
				<td><%=listDonHang.get(i).getNgayTao()%></td>
				<td id="tuychon"><a
					href="DonHangSV?suaDH=suaDH&maDonHang=<%=listDonHang.get(i).getMaDonHang()%>"
					title="Sửa đơn hàng" id="edit"> <i class="far fa-edit"></i></a>
					
					<a
					href="ChiTietDonHangSV?maDonHang=<%=listDonHang.get(i).getMaDonHang()%>"
					title="Chi tiết đơn hàng"><i class="fas fa-external-link-alt"></i></a>
					
					 <a
					href="DonHangSV?xoaDH=xoaDH&maDonHang=<%=listDonHang.get(i).getMaDonHang()%>"
					title="Xoá đơn hàng" id="delete"><i class="far fa-trash-alt"></i></a></td>
			</tr>


			<%
				}
			%>

		</tbody>
		<tfoot>
			<tr>
				<th>STT</th>
				<th>Mã đơn hàng</th>
				<th>Mã khách hàng</th>
				<th>Số điện thoại</th>
				<th>Địa chỉ</th>
				<th>Trạng thái</th>
				<th>Tổng tiền</th>
				<th>Ngày tạo</th>
				<th>Tuỳ chọn</th>
			</tr>
		</tfoot>
	</table>
</div>



<%@include file="footer.jsp"%>
