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
	KhachHang admin = (KhachHang) session.getAttribute("admin");
	String thanhCong = (String) request.getAttribute("thanhCong");
	String thatBai = (String) request.getAttribute("thatBai");
%>


<body>
	<header>
		<div class="container-fluid">
			<div class="row">
				<div class="header-left col-sm-2 text-center">
					<h4>Administrator</h4>
				</div>
				<div class="header-right col-sm-10 text-right">
					<a href="DangXuatSV" title="Đăng xuất">Đăng xuất <i class="fas fa-sign-out-alt"></i></a>
				</div>
			</div>
		</div>
	</header>
	<main>
	<div class="container-fluid">
		<div class="row">
			<div class="body-left col-sm-2">
				<div class="admin">
					<a href="DashboardSV" title=""><img src="./logo/logoblue.png"
						alt="BlueKids"></a>
				</div>
				<div class="menu">
					<div id="menu-i">
						<a href="DashboardSV" title="Dashboard"><i
							class="fas fa-tachometer-alt"></i>Dashboard</a>
					</div>

					<div id="menu-i">
						<a href="KhachHangSV" title="Khách hàng"><i
							class="fas fa-users"></i>Khách hàng</a>
					</div>
					<div id="menu-i">
						<a href="DanhMucSV" title="Danh mục sản phẩm"><i
							class="fas fa-book"></i>Danh mục</a>
					</div>
					<div id="menu-i">
						<a href="SanPhamSV" title="Sản phẩm"><i class="fas fa-server"></i>Sản
							phẩm</a>
					</div>
					<div id="menu-i">
						<a href="DonHangSV" title="Đơn hàng"><i
							class="fas fa-address-card"></i>Đơn hàng</a>
					</div>
					<!-- <div id="menu-i">
						<a href="#" title="Chi tiết đơn hàng"><i
							class="fas fa-sitemap"></i>Chi tiết</a>
					</div> -->
				</div>
			</div>
			<div class="body-right col-sm-10">