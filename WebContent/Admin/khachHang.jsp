<%@page import="common.KiemTra"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<%
	ArrayList<KhachHang> listKhachHang = (ArrayList<KhachHang>) request.getAttribute("listKhachHang");
	boolean capNhat = (boolean) request.getAttribute("capNhat");
	KhachHang khachHang = (KhachHang) request.getAttribute("khachHang");
%>

<div class="tieude text-center">
	<h3>Quản lý khách hàng</h3>

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
		<form action="KhachHangSV" enctype="multipart/form-data">
			<div class="form-group">
				<label for="hoVaTen">Họ và tên:</label> <input type="text"
					class="form-control" id="hoVaTen" name="hoVaTen"
					<%if (khachHang != null) {%> value="<%=khachHang.getHoVaTen()%>"
					<%}%> required>
			</div>
			<div class="form-group">
				<label for="tenDangNhap">Tên đăng nhập:</label> <input type="text"
					class="form-control" id="tenDangNhap" name="tenDangNhap"
					<%if (khachHang != null) {%>
					value="<%=khachHang.getTenDangNhap()%>" <%}%> required>
			</div>
			<div class="form-group">
				<label for="matKhau">Mật khẩu:</label> <input type="text"
					class="form-control" id="matKhau" name="matKhau"
					<%if (khachHang != null) {%> value="<%=khachHang.getMatKhau()%>"
					<%}%> required>
			</div>
			<div class="form-group">
				<label for="soDienThoai">Số điện thoại:</label> <input type="text"
					class="form-control" id="soDienThoai" name="soDienThoai"
					<%if (khachHang != null) {%>
					value="<%=khachHang.getSoDienThoai()%>" <%}%> required>
			</div>
			<div class="form-group">
				<label for="diaChi">Địa chỉ:</label> <input type="text"
					class="form-control" id="diaChi" name="diaChi"
					<%if (khachHang != null) {%> value="<%=khachHang.getDiaChi()%>"
					<%}%> required>
			</div>
			<div class="form-group">
				<label for="capBac">Trạng thái:</label> <select name="capBac"
					id="capBac" class="form-control" required>
					<option value="0"
						<%if (khachHang != null && khachHang.getCapBac() == 0) {%>
						selected <%}%>>Hoạt động</option>
					<option value="1"
						<%if (khachHang != null && khachHang.getCapBac() == 1) {%>
						selected <%}%>>Quản trị</option>
					<option value="2"
						<%if (khachHang != null && khachHang.getCapBac() == 2) {%>
						selected <%}%>>Khoá</option>
				</select>
			</div>
			<center>
				<%
					if (!capNhat) {
				%>
				<button type="submit" class="btn btn-success text-center"
					name="themKH" value="themKH">Thêm mới</button>
				<%
					} else {
				%>

				<input type="hidden" name="maKhachHang"
					value="<%=khachHang.getMaKhachHang()%>">

				<button type="submit" class="btn btn-primary text-center"
					name="capNhatKH" value="capNhatKH">Cập nhật</button>
				<button type="submit" class="btn btn-warning text-center"
					name="huyKH" value="huyKH">Huỷ</button>
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
				<th>Họ và tên</th>
				<th>Tên đăng nhập</th>
				<th>Mật khẩu</th>
				<th>Số điện thoại</th>
				<th>Địa chỉ</th>
				<th>Trạng thái</th>
				<th>Tuỳ chọn</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (int i = 0; i < listKhachHang.size(); i++) {
			%>

			<tr>
				<td><%=i + 1%></td>
				<td><%=listKhachHang.get(i).getHoVaTen()%></td>
				<td><%=listKhachHang.get(i).getTenDangNhap()%></td>
				<td><%=listKhachHang.get(i).getMatKhau()%></td>
				<td><%=listKhachHang.get(i).getSoDienThoai()%></td>
				<td>
					<%
						if (listKhachHang.get(i).getDiaChi().length() > 15) {
								out.print(listKhachHang.get(i).getDiaChi().substring(0, 15)+"...");
							} else {
								out.print(listKhachHang.get(i).getDiaChi());
							}
					%>
				</td>
				<td><%=KiemTra.trangThaiKH(listKhachHang.get(i).getCapBac())%></td>
				<td id="tuychon"><a
					href="KhachHangSV?suaKH=suaKH&maKhachHang=<%=listKhachHang.get(i).getMaKhachHang()%>"
					title="Sửa User" id="edit"> <i class="far fa-edit"></i></a> <a
					href="KhachHangSV?xoaKH=xoaKH&maKhachHang=<%=listKhachHang.get(i).getMaKhachHang()%>"
					title="Xoá User" id="delete"><i class="far fa-trash-alt"></i></a></td>
			</tr>


			<%
				}
			%>
		</tbody>
		<tfoot>
			<tr>
				<th>STT</th>
				<th>Họ và tên</th>
				<th>Tên đăng nhập</th>
				<th>Mật khẩu</th>
				<th>Số điện thoại</th>
				<th>Địa chỉ</th>
				<th>Trạng thái</th>
				<th>Tuỳ chọn</th>
			</tr>
		</tfoot>
	</table>
</div>



<%@include file="footer.jsp"%>
