<%@page import="common.KiemTra"%>
<%@page import="model.bean.GioHang"%>
<%@page import="model.bean.SanPham"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>


<main> <!-- main -->
<div class="main-body">
	<div class="giohang">
		<div class="container">
			<center>
				<h3>Giỏ Hàng</h3>



				<%
					if (listGioHang == null || listGioHang.size() <= 0) {
				%>
				<center>
					<a href="IndexServlet">Trống, tiếp tục mua hàng</a>
				</center>
				<%
					} else {
				%>

				<table class="table table-borderless">
					<thead>
						<tr>
							<th>#</th>
							<th>Sản phẩm</th>
							<th>Giá bán</th>
							<th>Số lượng</th>
							<th>Thành tiền</th>
							<th>Tuỳ chọn</th>
						</tr>
					</thead>
					<tbody>
						<%
							if (listGioHang != null) {
									for (int i = 0; i < listGioHang.size(); i++) {
						%>


						<tr>
							<td><%=(i + 1)%></td>
							<td><a
								href="ChiTietSanPhamServlet?maSanPham=<%=listGioHang.get(i).getSanPham().getMaSanPham()%>"
								title=""><img
									src="<%=listGioHang.get(i).getSanPham().getLinkSanPham()%>"
									alt=""><%=listGioHang.get(i).getSanPham().getTenSanPham()%></a></td>
							<td id="pri"><%=KiemTra.tien(listGioHang.get(i).getSanPham().getGiaSanPham())%></td>

							<form
								action="GioHangServlet?capNhatSanPham=<%=listGioHang.get(i).getIdGioHang()%>"
								method="post" accept-charset="utf-8">
								<td ><input type="number" name="soLuong"
									value="<%=listGioHang.get(i).getSoLuong()%>"></td>
								<td ><%=KiemTra.tien(
								listGioHang.get(i).getSoLuong() * listGioHang.get(i).getSanPham().getGiaSanPham())%></td>

								<td>

									<button type="submit" class="btn btn-secondary">Cập nhật</button>
							</form>
							<a
								href="GioHangServlet?idGioHang=<%=listGioHang.get(i).getIdGioHang()%>"
								title=""> <input class="btn btn-warning" type="submit"
								name="xoa" value="Xoá">
							</a>



							</td>




						</tr>



						<%
							}
								}
						%>

					</tbody>
				</table>




				<%
					}
				%>
			
		</div>
	</div>
	<div class="thanhtoan">
		<div class="container">
			<form action="ThanhToanServlet" method="post" accept-charset="utf-8">
				<div class="row">
					<div class="col-sm-6">
						<!-- <input class="form-control" type="text" name="" value="" placeholder="Mã giả giá">
                                <input class="btn btn-success" type="submit" name="" value="Áp dụng"> -->
						<center>
							<h3>
								<strong>Thông tin nhận hàng</strong>
							</h3>
							<table class="table">
								<tbody>
									<tr>
										<td>Địa chỉ:</td>
										<td><input class="form-control" type="text" name="diaChi"
											value="<%if (khachHang != null)
				out.print(khachHang.getDiaChi());%>"></td>
									</tr>
									<tr>
										<td>Số điện thoại:</td>
										<td><input class="form-control" type="text"
											name="soDienThoai"
											value="<%if (khachHang != null)
				out.print(khachHang.getSoDienThoai());%>"></td>
									</tr>
									<tr>
										<td>Mã Giảm Giá:</td>
										<td><input class="form-control" type="text"
											name="MaGiamGia" value=""></td>
									</tr>


								</tbody>
							</table>
					</div>
					<div class="col-sm-5 offset-sm-1">
						<center>
							<h3>
								<strong>Tổng đơn hàng</strong>
							</h3>
						</center>
						<table class="table">
							<tbody>
								<%
									int tong = 0;
									if (listGioHang != null) {
										for (int i = 0; i < listGioHang.size(); i++) {
											tong += (listGioHang.get(i).getSoLuong() * listGioHang.get(i).getSanPham().getGiaSanPham());
										}
									}
								%>
								<tr>
									<td>Tạm tính</td>
									<td><%=KiemTra.tien(tong)%></td>
								</tr>
								<tr>
									<td>Giảm giá</td>
									<td><%=KiemTra.tien(0)%></td>
								</tr>
								<tr>
									<td>Tổng cộng</td>
									<td><%=KiemTra.tien(tong)%></td>
								</tr>
								<tr>
									<td colspan="2"><button type="submit"
											class="btn btn-success">Thanh toán</button></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</form>
		</div>
	</div>
</main>


<%@include file="footer.jsp"%>