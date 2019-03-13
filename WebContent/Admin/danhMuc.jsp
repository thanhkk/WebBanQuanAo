<%@page import="model.bean.DanhMuc"%>
<%@page import="common.KiemTra"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<%
	ArrayList<DanhMuc> listDanhMuc = (ArrayList<DanhMuc>) request.getAttribute("listDanhMuc");
	boolean capNhat = (boolean) request.getAttribute("capNhat");
	DanhMuc danhMuc = (DanhMuc) request.getAttribute("danhMuc");
%>

<div class="tieude text-center">
	<h3>Quản lý danh mục</h3>

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
		<form action="DanhMucSV" enctype="multipart/form-data" >
			<div class="form-group">
				<label for="tenDanhMuc">Tên danh mục:</label> <input type="text"
					class="form-control" id="tenDanhMuc" name="tenDanhMuc"
					<%if (danhMuc != null) {%> value="<%=danhMuc.getTenDanhMuc()%>"
					<%}%> required>
			</div>

			<center>
				<%
					if (!capNhat) {
				%>
				<button type="submit" class="btn btn-success text-center"
					name="themDM" value="themDM">Thêm mới</button>
				<%
					} else {
				%>

				<input type="hidden" name="maDanhMuc"
					value="<%=danhMuc.getMaDanhMuc()%>">

				<button type="submit" class="btn btn-primary text-center"
					name="capNhatDM" value="capNhatDM">Cập nhật</button>
				<button type="submit" class="btn btn-warning text-center"
					name="huyDM" value="huyDM">Huỷ</button>
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
				<th>Mã danh mục</th>
				<th>Tên danh mục</th>
				<th>Tuỳ chọn</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (int i = 0; i < listDanhMuc.size(); i++) {
			%>

			<tr>
				<td><%=i + 1%></td>
				<td><%=listDanhMuc.get(i).getMaDanhMuc()%></td>
				<td><%=listDanhMuc.get(i).getTenDanhMuc()%></td>

				<td id="tuychon"><a
					href="DanhMucSV?suaDM=suaDM&maDanhMuc=<%=listDanhMuc.get(i).getMaDanhMuc()%>"
					title="Sửa danh mục" id="edit"> <i class="far fa-edit"></i></a> <a
					href="DanhMucSV?xoaDM=xoaDM&maDanhMuc=<%=listDanhMuc.get(i).getMaDanhMuc()%>"
					title="Xoá danh mục" id="delete"><i class="far fa-trash-alt"></i></a></td>
			</tr>


			<%
				}
			%>
			<!-- <tr>
				<td>0</td>
				<td>họ tnee</td>
				<td>tendangnhap</td>
				<td>Mật khẩu</td>
				<td>sdt</td>
				<td>Dịa chỉ</td>
				<td>Khoá</td>
				<td id="tuychon"><a href="khachHangSV?suaDM=suaDM&maKhachHang="
					title="Sửa User" id="edit"> <i class="far fa-edit"></i></a> <a
					href="khachHangSV?xoaDM=xoaDM&maKhachHang=" title="Xoá User"
					id="delete"><i class="far fa-trash-alt"></i></a></td>
			</tr> -->
		</tbody>
		<tfoot>
			<tr>
				<th>STT</th>
				<th>Mã danh mục</th>
				<th>Tên danh mục</th>
				<th>Tuỳ chọn</th>
			</tr>
		</tfoot>
	</table>
</div>



<%@include file="footer.jsp"%>
