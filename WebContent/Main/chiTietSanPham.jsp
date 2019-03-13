<%@page import="model.bean.DanhGia"%>
<%@page import="common.KiemTra"%>
<%@page import="model.bean.SanPham"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>

<%
	SanPham sanPham = (SanPham) request.getAttribute("sanPham");
	ArrayList<DanhGia> listDanhGia = (ArrayList<DanhGia>) request.getAttribute("listDanhGia");
	ArrayList<KhachHang> listKhachHang = (ArrayList<KhachHang>) request.getAttribute("listKhachHang");
%>
<main> <!-- main -->
<div class="main-body">
	<div class="container">

		<a href="IndexServlet" title="Trang chủ"><i class="fas fa-home"></i>
			Trang chủ </a>

		<%
			if (sanPham != null && listDanhMuc != null) {

				for (int i = 0; i < listDanhMuc.size(); i++) {
					if (listDanhMuc.get(i).getMaDanhMuc() == sanPham.getMaDanhMuc()) {
		%>
		<a href="IndexServlet?maDanhMuc=<%=sanPham.getMaDanhMuc()%>"
			title="Danh mục"><i class="fas fa-angle-right"></i> <%=listDanhMuc.get(i).getTenDanhMuc()%></a>

		<a href="ChiTietSanPhamServlet?maSanPham=<%=sanPham.getMaSanPham()%>"
			title="Sản phẩm"><i class="fas fa-angle-right"></i> <%=sanPham.getTenSanPham()%></a>

		<%
			break;
					}
				}
			}
		%>

		<div class="row">
			<div class="product-image-summary col-sm-9">
				<div class="row">
					<div class="col-sm-6 product-images">
						<img src="<%=sanPham.getLinkSanPham()%>" alt="" class="border">
					</div>
					<div class="col-sm-6 summary entry-summary">
						<div class="summary-inner ">
							<div class="basel-scroll-content">
								<h1 itemprop="name" class="product_title entry-title"><%=sanPham.getTenSanPham()%></h1>
								<p class="price">
								<h4><%=KiemTra.tien(sanPham.getGiaSanPham())%></h4>
								</p>
								<form
									action="GioHangServlet?maSanPham=<%=sanPham.getMaSanPham()%>"
									method="post" accept-charset="utf-8">
									<label>Số Lượng: </label> <input type="number" name="soLuong"
										value="1" placeholder=""><br>
									<button type="submit" name="them" value="them"
										class="btn btn-info">Thêm vào giỏ</button>
								</form>
								<div class="product_meta">
									<span class="sku_wrapper">Thông tin sản phẩm:</span>
									<p class="sku">Thành phần vải thông thoáng, an toàn cho da
										bé Thiết kế in hình xinh xắn, đáng yêu Màu sắc bắt mắt, tươi
										tắn Đường may tỉ mỉ, chắc chắn</p>
									<span class="sku_wrapper">Đánh giá: <%
										if (listDanhGia != null) {
											float sao = 0;
											float dem = 0;
											for (int i = 0; i < listDanhGia.size(); i++) {
												sao += (float) listDanhGia.get(i).getDiemDanhGia();
												dem++;
											}
											float sao2 = sao / dem;
											int sao3 = (int) sao2;
											for (int i = 0; i < 5; i++) {
												if (i < sao3) {
									%> <i class="fas fa-star saovang"></i> <%
 	} else if (sao2 - i > 0) {
 %> <i class="fas fa-star-half-alt saovang"></i> <%
 	} else {
 %> <i class="far fa-star saovang"></i> <%
 	}

 		}
 	}
 %>


									</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<aside class="sidebar-container col-sm-3 sidebar-right"
				role="complementary">
				<div class="sidebar-inner">
					<div class="widget-area">
						<div id="text-17" class="sidebar-widget widget_text">
							<div class="textwidget">
								<img src="img/hangchinhang.png" alt=""> <b><strong>HÀNG
										CHÍNH HÃNG</strong></b>
								<p>Đóng gói, nhãn mác, chất liệu an toàn cho bé</p>
							</div>
						</div>
						<div id="text-18" class="sidebar-widget widget_text">
							<div class="textwidget">
								<img src="img/hangtichluy.png" alt=""><b><strong>MUA
										HÀNG TÍCH LŨY</strong></b>
								<p>Mua nhiều được cộng dồn số lượng, hưởng giá sỉ</p>
							</div>
						</div>
						<div id="text-19" class="sidebar-widget widget_text">
							<div class="textwidget">
								<img src="img/freeship.png" alt=""><b><strong>FREE
										SHIP</strong></b>
								<p>Đơn hàng trên 500K, hỗ trợ phí ship rẻ khu vực còn lại</p>
							</div>
						</div>
					</div>
				</div>
			</aside>
		</div>
	</div>

	<div class="container">
		<h3>Đánh giá và nhận xét của khách hàng:</h3>

		<%
			boolean daBinhLuan = false;
			if (khachHang != null) {

				for (int i = 0; i < listDanhGia.size(); i++) {
					if (listDanhGia.get(i).getMaKhachHang() == khachHang.getMaKhachHang()) {
						daBinhLuan = true;
					}
				}
			}
			if (daBinhLuan == false) {
		%>

		<form
			action="ChiTietSanPhamServlet?maSanPham=<%=sanPham.getMaSanPham()%>"
			method="post">
			<div class="row">
				<div class="col-sm-5">
					<div class="form-check">
						<label class="form-check-label" for="radio1"> <input
							type="radio" class="form-check-input saovang" id="radio1"
							name="diemDanhGia" value="5" checked><i
							class="fas fa-star saovang"></i><i class="fas fa-star saovang"></i><i
							class="fas fa-star saovang"></i><i class="fas fa-star saovang"></i><i
							class="fas fa-star saovang"></i>
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label" for="radio1"> <input
							type="radio" class="form-check-input" id="radio1"
							name="diemDanhGia" value="4"><i
							class="fas fa-star saovang"></i><i class="fas fa-star saovang"></i><i
							class="fas fa-star saovang"></i><i class="fas fa-star saovang"></i>
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label" for="radio1"> <input
							type="radio" class="form-check-input" id="radio1"
							name="diemDanhGia" value="3"><i
							class="fas fa-star saovang"></i><i class="fas fa-star saovang"></i><i
							class="fas fa-star saovang"></i>
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label" for="radio1"> <input
							type="radio" class="form-check-input" id="radio1"
							name="diemDanhGia" value="2"><i
							class="fas fa-star saovang"></i><i class="fas fa-star saovang"></i>
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label" for="radio1"> <input
							type="radio" class="form-check-input" id="radio1"
							name="diemDanhGia" value="1"><i
							class="fas fa-star saovang"></i>
						</label>
					</div>

				</div>
				<div class="col-sm-6 offset-sm-1">
					<div class="form-group">
						<textarea class="form-control" rows="4" name="binhLuan" required
							placeholder="Đánh giá của bạn về sản phẩm"></textarea>
					</div>
					<button type="submit" class="btn btn-success" name="danhGia"
						value="danhGia">Đánh giá</button>
				</div>
			</div>
		</form>

		<%
			}
		%>


	</div>

	<%
		if (listDanhGia != null || !listDanhGia.isEmpty()) {
	%>


	<div class="container">
		<table class="table table-striped">
			<tbody>

				<%
					for (int i = 0; i < listDanhGia.size(); i++) {
				%>

				<tr>
					<th>
						<%
							for (int j = 0; j < listKhachHang.size(); j++) {
										if (listDanhGia.get(i).getMaKhachHang() == listKhachHang.get(j).getMaKhachHang())
											if (khachHang != null
													&& listKhachHang.get(j).getTenDangNhap().equals(khachHang.getTenDangNhap()))
												out.println(listKhachHang.get(j).getHoVaTen() + " (Bạn)");
											else
												out.println(listKhachHang.get(j).getHoVaTen());
									}
						%>
					</th>
					<td>
						<%
							for (int j = 0; j < listDanhGia.get(i).getDiemDanhGia(); j++) {
						%> <i class="fas fa-star saovang"></i> <%
 	}
 %>
					
					<td><%=listDanhGia.get(i).getBinhLuan()%></td>

					<%
						if (khachHang != null && khachHang.getCapBac() == 1) {
					%>
					<td><a
						href="ChiTietSanPhamServlet?maSanPham=<%=sanPham.getMaSanPham()%>&xoaBinhLuan=xoaBinhLuan&maDanhGia=<%=listDanhGia.get(i).getMaDanhGia()%>"
						title="Xóa bình luận"><button type="submit" name="xoaBinhLuan"
								value="xoaBinhLuan" class="btn btn-danger">Xóa</button> </a></td>

					<%
						}
					%>




				</tr>


				<%
					}
				%>


			</tbody>
		</table>
	</div>

	<%
		}
	%>


</div>
</main>


<%@include file="footer.jsp"%>