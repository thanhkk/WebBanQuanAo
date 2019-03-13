<%@page import="model.bean.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Admin</title>
<link rel="stylesheet" type="text/css" href="Admin/css/style2.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<script src="js/main.js" type="text/javascript" charset="utf-8" async
	defer></script>
</head>
<%
	KhachHang admin = (KhachHang) session.getAttribute("admin");
	String thanhCong = (String) request.getAttribute("thanhCong");
	String thatBai = (String) request.getAttribute("thatBai");
%>
<body id="LoginForm">
	<div class="container">
		<div class="login-form">
			<div class="main-div col-sm-4 offset-sm-4 text-center">
				<div class="panel">
					<h2>Administrator</h2>
					<%
						if (thatBai!=null){
							%>
							<div class="thatbai badge badge-danger">
						<i class="fas fa-exclamation-triangle"></i><%=thatBai%>
					</div>
							
							<%
						}
					%>
					
				</div>
				<form id="Login" action="DangNhapSV">
					<div class="form-group">
						<input type="text" class="form-control" name="tenDangNhap"
							placeholder="Tên đăng nhập">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" name="matKhau"
							placeholder="Mật khẩu">
					</div>
					<button type="submit" class="btn btn-info" name="dangNhap"
						value="dangNhap">Đăng nhập</button>
				</form>
			</div>
		</div>
	</div>
	</div>
	<footer>
		<div class="footer-copyright text-center">© 2018 Copyright:
			thanhtv</div>
	</footer>
</body>

</html>
