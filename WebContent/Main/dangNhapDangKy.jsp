<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="header.jsp"%>

<main> <!-- main -->



<div class="main-body">
	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<div class="dangnhap">
					<form action="DangNhapDangKyServlet" method="post">
						<div class="form-group">
							<input type="text" class="form-control"
								placeholder="Tên đăng nhập" value="" name="tenDangNhap" required="required"/>
						</div>
						<div class="form-group">
							<input type="password" class="form-control"
								placeholder="Mật khẩu" value="" name="matKhau"required="required" />
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-info" name="dangNhap"
								value="dangNhap">Đăng nhập</button>
						</div>
					</form>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="dangky">
					<form action="DangNhapDangKyServlet" method="post">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Họ và tên"
								value="" name="hoVaTen" required="required"/>
						</div>
						<div class="form-group">
							<input type="text" class="form-control"
								placeholder="Tên đăng nhập" value="" name="tenDangNhap" required="required"/>
						</div>
						<div class="form-group">
							<input type="text" class="form-control"
								placeholder="Mật khẩu" value="" name="matKhau" required="required"/>
						</div>
						<div class="form-group">
							<input type="text" class="form-control"
								placeholder="Số điện thoại" value="" name="soDienThoai" required="required"/>
						</div>
						
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Địa chỉ"
								value="" name="diaChi"required="required" />
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-info" name="dangKy"
								value="dangKy" >Đăng ký</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</main>
<%@include file="footer.jsp"%>