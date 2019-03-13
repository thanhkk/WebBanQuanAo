<%@page import="model.bean.DanhMuc"%>
<%@page import="model.bean.GioHang"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Quần Áo Trẻ Em</title>
<link rel="stylesheet" type="text/css" href="Main/css/style.css">
<link href="data:image/x-icon;base64,AAABAAEAEBAQAAEABAAoAQAAFgAAACgAAAAQAAAAIAAAAAEABAAAAAAAgAAAAAAAAAAAAAAAEAAAAAAAAAAAAAAAPYOmAP///wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACIgAAAAAAACICIAAAAAAAIAAgAAAAAQIiIhEBAAABAiIhEQEAABECAiEBARAAEQIiIREBEAABECIiEREAAAABEiIhAAAAAAAAAAAAAAAAAAAAAAAAD//wAA//8AAP//AAD//wAA/H8AAPg/AADwHwAA0BcAAIADAACAAwAAAAEAAAABAACAAwAAwAcAAPAfAAD//wAA" rel="icon" type="image/x-icon" />

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css" />
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>



</head>
<%
	KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");
	String thanhCong = (String) request.getAttribute("thanhCong");
	String thatBai = (String) request.getAttribute("thatBai");

	ArrayList<GioHang> listGioHang = (ArrayList<GioHang>) session.getAttribute("listGioHang");
	ArrayList<DanhMuc> listDanhMuc = (ArrayList<DanhMuc>) session.getAttribute("listDanhMuc");
%>
<body>
	<header>
		<div class="header-top">
			<div class="container">
				<div class="row">
					<div class="header-top-left col-sm-8">
						<a href="tel:+84987174321" title=""><i
							class="fas fa-mobile-alt"></i> Hotline: 0987174321</a>
					</div>
					<div class="header-top-right col-sm-4">

						<%
							if (khachHang == null) {
						%>
						<a href="DangNhapDangKyServlet" title="Đăng ký Đăng nhập"> <%
 	} else {
 %> <a href="SuaThongTinKhachHangServlet" title="Thông tin cá nhân">
								<%
									}
								%> <i class="far fa-user"></i> <%
 	if (khachHang != null) {
 %><%=khachHang.getHoVaTen()%> <%
 	} else {
 %>Đăng nhập/Đăng ký<%
 	}
 %> <%
 	if (khachHang != null) {
 %>
						</a> <a href="DonHangServlet" title="Xem đơn hàng">Đơn hàng</a> <a
							href="DangXuatServlet" title="Đăng xuất">Đăng xuất</a> <%
 	}
 %>
					</div>
				</div>
			</div>
		</div>
		<div class="header-mid">
			<div class="container">
				<div class="row">
					<div class="header-mid-left col-sm-3">
						<!-- <h1>LOGO</h1> -->
						<a href="IndexServlet" title=""> <img
							src="./logo/logoblue.png" alt=""></a>
					</div>
					<div class="header-mid-right col-sm-9">
						<a href="IndexServlet" title="">Trang chủ</a> <a
							href="IndexServlet?maDanhMuc=4" title="">Khuyến mãi</a> <a
							href="LienHeServlet" title="">Liên hệ</a> <a
							href="GioiThieuServlet" title="">Giới thiệu</a> <a
							href="GioHangServlet" title=""><i
							class="fas fa-shopping-cart"></i> <%
 	if (listGioHang != null && !listGioHang.isEmpty()) {
 %> <sup style="color: red;"><%=listGioHang.size()%></sup> <%
 	}
 %> Giỏ Hàng</a>
					</div>
				</div>
			</div>
		</div>

		<div class="header-bot">
			<div class="container">
				<div class="row">
					<div class="col-sm-3"></div>
					<div class="col-sm-9">
						<form action="IndexServlet" method="post" accept-charset="utf-8">
							<div class="row">
								<div class="form-group col-sm-7">
									<input type="search" name="tenSanPham" value=""
										placeholder="Tìm kiếm sản phẩm . . ." class="form-control">
								</div>
								<div class="form-group">
									<input type="submit" name="" value="Tìm kiếm"
										class="btn btn-light">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>

			<!-- <div class="container">
				<div id="demo" class="carousel slide" data-ride="carousel">
					<ul class="carousel-indicators">
						<li data-target="#demo" data-slide-to="0" class="active"></li>
						<li data-target="#demo" data-slide-to="1"></li>
						<li data-target="#demo" data-slide-to="2"></li>
					</ul>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="https://www.w3schools.com/bootstrap4/la.jpg" alt="Los Angeles" width="1100" height="500">
							<div class="carousel-caption">
								<h3>Los Angeles</h3>
								<p>We had such a great time in LA!</p>
							</div>
						</div>
						<div class="carousel-item">
							<img src="https://www.w3schools.com/bootstrap4/chicago.jpg" alt="Chicago" width="1100" height="500">
							<div class="carousel-caption">
								<h3>Chicago</h3>
								<p>Thank you, Chicago!</p>
							</div>
						</div>
						<div class="carousel-item">
							<img src="https://www.w3schools.com/bootstrap4/ny.jpg" alt="New York" width="1100" height="500">
							<div class="carousel-caption">
								<h3>New York</h3>
								<p>We love the Big Apple!</p>
							</div>
						</div>
					</div>
					<a class="carousel-control-prev" href="#demo" data-slide="prev">
						<span class="carousel-control-prev-icon"></span>
					</a> <a class="carousel-control-next" href="#demo" data-slide="next">
						<span class="carousel-control-next-icon"></span>
					</a>
				</div>
			</div> -->
		</div>
		<%
			if (thanhCong != null || thatBai != null) {
		%>

		<div class="container">
			<div class="thongbao">
				<div class="col-sm-6 offset-3">
					<%
						if (thanhCong != null) {
					%>
					<div class="badge badge-success">
						<i class="fas fa-check"></i>
						<%=thanhCong%>
					</div>
					<%
						}
					%>
					<%
						if (thatBai != null) {
					%>
					<div class="badge badge-danger">
						<i class="fas fa-exclamation-triangle"></i>
						<%=thatBai%>
					</div>
					<%
						}
					%>


				</div>
			</div>
		</div>

		<%
			}
		%>

	</header>
	<!-- /header -->