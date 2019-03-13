<%@page import="common.KiemTra"%>
<%@page import="model.bean.SanPham"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="header.jsp"%>
<%
	ArrayList<SanPham> listSanPham = (ArrayList<SanPham>) request.getAttribute("listSanPham");
	String tr = request.getParameter("trang");
	String ma = request.getParameter("maDanhMuc");
	String tenSanPham = request.getParameter("tenSanPham");
	int trang = 1;
	int maDanhMuc = 0;
	if (tr != null) {
		trang = Integer.parseInt(tr);
	}
	if (ma != null) {
		maDanhMuc = Integer.parseInt(ma);
	}
%>
<main> <!-- main -->
<div class="main-body">

	<div class="container-fluid">
		<div class="row">
			<!-- side bar -->
			<div class="col-sm-3">
				<div class="vertical-menu">
					<a href="#" class="active">Danh Mục Sản Phẩm</a>

					<%
						for (int i = 0; i < listDanhMuc.size(); i++) {
					%>
					<a
						href="IndexServlet?maDanhMuc=<%=listDanhMuc.get(i).getMaDanhMuc()%>"><%=listDanhMuc.get(i).getTenDanhMuc()%></a>

					<%
						}
					%>
				</div>
			</div>
			<!-- product -->
			<div class="product  col-sm-9 ">
				<a href="IndexServlet" title="Trang chủ"><i class="fas fa-home"></i>
					Trang chủ </a>

				<%
					if (ma != null) {
						for (int i = 0; i < listDanhMuc.size(); i++) {
							if (listDanhMuc.get(i).getMaDanhMuc() == maDanhMuc) {
				%>

				<a href="IndexServlet?maDanhMuc=<%=listDanhMuc.get(i).getMaDanhMuc()%>" title="Danh mục"><i
					class="fas fa-angle-right"></i> <%=listDanhMuc.get(i).getTenDanhMuc()%></a>
				<%break;
					}
						}
					}
				%>





				<!-- edit here -->
				<div class="product-mid row">
					<%
						if (listSanPham != null)
							for (int i = 0; i < listSanPham.size(); i++) {

								if (i >= (trang * 30 - 30) && i < (trang * 30)) {
					%>

					<div class="col-sm-3">
						<div class="items border">
							<div class="items-img ">
								<a
									href="ChiTietSanPhamServlet?maSanPham=<%=listSanPham.get(i).getMaSanPham()%>"
									title=""><img
									src="<%=listSanPham.get(i).getLinkSanPham()%>" alt="images"
									title="Xem chi tiết"></a>
							</div>
							<div class="items-info">
								<a
									href="ChiTietSanPhamServlet?maSanPham=<%=listSanPham.get(i).getMaSanPham()%>"
									title="Tên sản phẩm"><%=listSanPham.get(i).getTenSanPham()%></a>
								<p title="Giá sản phẩm"><%=KiemTra.tien(listSanPham.get(i).getGiaSanPham())%>

									<a
										href="GioHangServlet?maSanPham=<%=listSanPham.get(i).getMaSanPham()%>&soLuong=1"
										title="Thêm giỏ hàng"><i class="fas fa-cart-plus"
										style="color: #007bff; font-size: 17px;"></i></a>
								</p>
							</div>
						</div>
					</div>


					<%
						}
							}
					%>
					<%-- <div class="container">

						<ul class="pagination justify-content-center">
							<%
								if (listSanPham != null)
									for (int i = 0; i < (listSanPham.size() / 30); i++) {
							%>
							<li
								class="page-item <%if ((i + 1) == trang) {%>
									active
									<%}%>"><a
								class="page-link"
								href="IndexServlet?maDanhMuc=<%=maDanhMuc%>&trang=<%=(i + 1)%>&tenSanPham=<%=tenSanPham%>"><%=(i + 1)%></a></li>
							<%
								}
							%>
						</ul>

					</div> --%>


					<div class="container">
						<ul class="pagination justify-content-center">

							<%
								if (listSanPham != null) {
									int n = listSanPham.size() / 30;
									int chon = trang;
									if (n > 1) {
							%>
							<li
								class="page-item<%if (trang == 1) {%>
								disabled
								<%}%>"><a
								class="page-link"
								href="IndexServlet?maDanhMuc=<%=maDanhMuc%>&trang=1&tenSanPham=<%=tenSanPham%>"><i
									class="fas fa-angle-left"></i><i class="fas fa-angle-left"></i></a></li>
							<%
								for (int i = 1; i <= n; i++) {

											if (chon > 2 && i == 1) {
							%>
							<li class="page-item disabled"><a class="page-link" href="#">...</a></li>
							<%
								}
											if (i == chon - 1) {
							%>

							<li class="page-item"><a class="page-link"
								href="IndexServlet?maDanhMuc=<%=maDanhMuc%>&trang=<%=i%>&tenSanPham=<%=tenSanPham%>"><%=i%></a></li>
							<%
								}
											if (i == chon) {
							%>

							<li class="page-item active"><a class="page-link"
								href="IndexServlet?maDanhMuc=<%=maDanhMuc%>&trang=<%=i%>&tenSanPham=<%=tenSanPham%>"><%=i%></a></li>
							<%
								}
											if (i == chon + 1) {
							%>

							<li class="page-item"><a class="page-link"
								href="IndexServlet?maDanhMuc=<%=maDanhMuc%>&trang=<%=i%>&tenSanPham=<%=tenSanPham%>"><%=i%></a></li>
							<%
								}
											if (chon < n - 1 && i == n) {
							%>
							<li class="page-item disabled"><a class="page-link" href="#">...</a></li>
							<%
								}
										}
							%>
							<li
								class="page-item <%if (trang == n) {%>
								disabled
								<%}%> "><a
								class="page-link"
								href="IndexServlet?maDanhMuc=<%=maDanhMuc%>&trang=<%=n%>&tenSanPham=<%=tenSanPham%>"><i
									class="fas fa-angle-right"></i><i class="fas fa-angle-right"></i></a></li>

							<%
								}
								}
							%>

						</ul>
					</div>




				</div>

				<!-- end edit -->

			</div>
		</div>
	</div>
</div>
</main>

<%@include file="footer.jsp"%>