<%@page import="common.KiemTra"%>
<%@page import="model.bean.DonHang"%>
<%@page import="model.bean.SanPham"%>
<%@page import="java.util.Hashtable"%>
<%@page import="model.bean.ChiTiet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="header.jsp"%>
<main>
<div class="main-body">
	<div class="container">
		<center>
			<h3>
				<strong>Cập nhật thông tin cá nhân</strong>
			</h3>

		</center>

		<form action="SuaThongTinKhachHangServlet">
			<div class="form-group">
				<label for="hoVaTen">Họ và tên:</label> <input type="text"
					class="form-control" id="hoVaTen" name="hoVaTen"
					value="<%=khachHang.getHoVaTen()%>" required="required">
			</div>
			<div class="form-group">
				<label for="tenDangNhap">Tên đăng nhập:</label> <input type="text"
					class="form-control" id="tenDangNhap" name="tenDangNhap"
					value="<%=khachHang.getTenDangNhap()%>" disabled>
			</div>
			<div class="form-group">
				<label for="matKhau">Mật khẩu:</label> <input type="text"
					class="form-control" id="matKhau" name="matKhau"
					value="<%=khachHang.getMatKhau()%>" required="required">
			</div>
			<div class="form-group">
				<label for="soDienThoai">Số điện thoại:</label> <input type="text"
					class="form-control" id="soDienThoai" name="soDienThoai"
					value="<%=khachHang.getSoDienThoai()%>" required="required">
			</div>

			<div class="form-group">
				<label for="diaChi">Địa chỉ:</label> <input type="text"
					class="form-control" id="diaChi" name="diaChi"
					value="<%=khachHang.getDiaChi()%>" required="required">
			</div>

			<input type="hidden" name="capBac" value="<%=khachHang.getCapBac()%>">

			<center>
				<button type="submit" class="btn btn-primary" name="sua" value="sua">Cập
					nhật thông tin</button>
			</center>

		</form>
	</div>
</main>



<%@include file="footer.jsp"%>
