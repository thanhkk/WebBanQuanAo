<%@page import="model.bean.SanPham"%>
<%@page import="model.bean.DanhMuc"%>
<%@page import="common.KiemTra"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<%
	ArrayList<SanPham> listSanPham = (ArrayList<SanPham>) request.getAttribute("listSanPham");
	ArrayList<DanhMuc> listDanhMuc = (ArrayList<DanhMuc>) request.getAttribute("listDanhMuc");
	boolean capNhat = (boolean) request.getAttribute("capNhat");
	SanPham sanPham = (SanPham) request.getAttribute("sanPham");
%>

<div class="tieude text-center">
	<h3>Quản lý sản phẩm</h3>

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
		<form action="SanPhamSV" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="tenSanPham">Tên sản phẩm:</label> <input type="text"
					class="form-control" id="tenSanPham" name="tenSanPham"
					<%if (sanPham != null) {%> value="<%=sanPham.getTenSanPham()%>"
					<%}%> required>
			</div>
			<div class="form-group">
				<label for="maDanhMuc">Danh mục:</label> <select name="maDanhMuc"
					id="maDanhMuc" class="form-control" required>

					<%
						for (DanhMuc dm : listDanhMuc) {
					%>
					<option value="<%=dm.getMaDanhMuc()%>"
						<%if (sanPham != null && sanPham.getMaDanhMuc() == dm.getMaDanhMuc()) {%>
						selected <%}%>><%=dm.getTenDanhMuc()%></option>

					<%
						}
					%>

				</select>
			</div>
			<div class="form-group">
				<label for="giaSanPham">Giá bán sản phẩm:</label> <input
					type="number" class="form-control" id="giaSanPham"
					name="giaSanPham" <%if (sanPham != null) {%>
					value="<%=sanPham.getGiaSanPham()%>" <%}%> required>
			</div>
			<div class="form-group">
				<label for="linkSanPham">Hình ảnh sản phẩm:</label>
				<img id="imgSP"
					src="<%if (capNhat) {
				out.print(sanPham.getLinkSanPham());
			}%>" />
				<input type="file" class="form-control " id="linkSanPham"
					name="linkSanPham" onchange="readURL(this);" accept="image/*"
					<%if (!capNhat) {
				out.print("required");
			}%>>
			</div>
			<div class="form-group">
				<label for="giaNhap">Giá nhập sản phẩm:</label> <input type="number"
					class="form-control" id="giaNhap" name="giaNhap"
					<%if (sanPham != null) {%> value="<%=sanPham.getGiaNhap()%>" <%}%>
					required>
			</div>
			<center>
				<%
					if (!capNhat) {
				%>
				<button type="submit" class="btn btn-success text-center"
					name="themSP" value="themSP">Thêm mới</button>
				<%
					} else {
				%>

				<input type="hidden" name="maSanPham"
					value="<%=sanPham.getMaSanPham()%>">
				<button type="submit" class="btn btn-primary text-center"
					name="capNhatSP" value="capNhatSP">Cập nhật</button>
				<button type="submit" class="btn btn-warning text-center"
					name="huySP" value="huySP">Huỷ</button>
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
				<th>Sản phẩm</th>
				<th>Danh mục</th>
				<th>Giá bán</th>
				<th>Hình ảnh</th>
				<th>Giá nhập</th>
				<th>Tuỳ chọn</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (int i = 0; i < listSanPham.size(); i++) {
			%>

			<tr>
				<td><%=i + 1%></td>
				<td><%=listSanPham.get(i).getTenSanPham()%></td>
				<td>
					<%
						for (DanhMuc dm : listDanhMuc) {
								if (listSanPham.get(i).getMaDanhMuc() == dm.getMaDanhMuc()) {
					%><%=dm.getTenDanhMuc()%> <%
 	}
 		}
 %>
				</td>
				<td><%=KiemTra.tien(listSanPham.get(i).getGiaSanPham())%></td>
				<td><img src="<%=listSanPham.get(i).getLinkSanPham()%>"
					alt="Ảnh sản phẩm"></td>
				<td><%=KiemTra.tien(listSanPham.get(i).getGiaNhap())%></td>

				<td id="tuychon"><a
					href="SanPhamSV?suaSP=suaSP&maSanPham=<%=listSanPham.get(i).getMaSanPham()%>"
					title="Sửa sản phẩm" id="edit"> <i class="far fa-edit"></i></a> <a
					href="SanPhamSV?xoaSP=xoaSP&maSanPham=<%=listSanPham.get(i).getMaSanPham()%>"
					title="Xoá sản phẩm" id="delete"><i class="far fa-trash-alt"></i></a></td>
			</tr>


			<%
				}
			%>

		</tbody>
		<tfoot>
			<tr>
				<th>STT</th>
				<th>Sản phẩm</th>
				<th>Danh mục</th>
				<th>Giá bán</th>
				<th>Hình ảnh</th>
				<th>Giá nhập</th>
				<th>Tuỳ chọn</th>
			</tr>
		</tfoot>
	</table>
</div>



<%@include file="footer.jsp"%>
