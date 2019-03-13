<%@page import="common.KiemTra"%>
<%@page import="model.bean.DonHang"%>
<%@page import="model.bean.SanPham"%>
<%@page import="java.util.Hashtable"%>
<%@page import="model.bean.ChiTiet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="header.jsp"%>
<%
	ArrayList<ChiTiet> listChiTiet = (ArrayList<ChiTiet>) request.getAttribute("listChiTiet");
	ArrayList<SanPham> listSanPham = (ArrayList<SanPham>) request.getAttribute("listSanPham");
	DonHang donHang = (DonHang) request.getAttribute("donHang");
%>
<main>
<div class="main-body">
	<div class="container">
		<h3>
			Chi tiết đơn hàng #order<%=donHang.getMaDonHang()%></h3>
		<div class="row">
			<div class="col-sm-7">
				<div class="ct-donhang">
					<table class="table-ct">
						<tr id="ct-top">
							<td colspan="2"><span id="ct-ngaymua">Ngày mua: <%=donHang.getNgayTao()%></span></td>
							<td colspan="2" class="text-right">
								<%
									if (donHang.getTrangThai() == 0) {
								%> <span id="danggiao">Đang giao</span> <%
 	} else if (donHang.getTrangThai() == 1) {
 %> <span id="danhan">Đã nhận</span> <%
 	} else {
 %> <span id="dahuy">Đã huỷ đơn</span> <%
 	}
 %>
							</td>
						</tr>
						<tr>
							<td colspan="2">Sản phẩm</td>
							<td>Số lượng</td>
							<td class="text-right">Thành tiền</td>
						</tr>
						<%
							for (ChiTiet ct : listChiTiet) {
								for (SanPham sp : listSanPham) {
									if (ct.getMaSanPham() == sp.getMaSanPham()) {
						%>
						<tr id="ct-sanpham">
							<td id="ct-img"><img src="<%=sp.getLinkSanPham()%>"
								alt="Ảnh sản phẩm"></td>
							<td><a
								href="ChiTietSanPhamServlet?maSanPham=<%=ct.getMaSanPham()%>"
								title="Chi tiết sản phẩm"><%=sp.getTenSanPham()%></a></td>
							<td><%=ct.getSoLuong()%></td>
							<td class="text-right"><%=KiemTra.tien(ct.getSoLuong() * sp.getGiaSanPham())%></td>
						</tr>

						<%
							}
								}

							}
						%>
						<!-- <tr id="ct-sanpham">
							<td id="ct-img"><img src="img/sp/s (12).jpg" alt=""></td>
							<td><a href="#" title="">tên bc àodo oạ doa j</a></td>
							<td>Qty:3s</td>
							<td class="text-right">123456đ</td>
						</tr>
						<tr id="ct-sanpham">
							<td id="ct-img"><img src="img/sp/s (12).jpg" alt=""></td>
							<td><a href="#" title="">tên bc àodo oạ doa j</a></td>
							<td>Qty:3s</td>
							<td class="text-right">123456đ</td>
						</tr>
						<tr id="ct-sanpham">
							<td id="ct-img"><img src="img/sp/s (12).jpg" alt=""></td>
							<td><a href="#" title="">tên bc àodo oạ doa j</a></td>
							<td>Qty:3s</td>
							<td class="text-right">123456đ</td>
						</tr> -->
					</table>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="ct-diachi">
					<h5>Địa chỉ giao hàng</h5>
					<span>Họ và tên: <%=khachHang.getHoVaTen()%></span><br> <span>Số
						điện thoại: <%=donHang.getSoDienThoai()%></span><br> <span>Địa
						chỉ: <%=donHang.getDiaChi()%></span>
				</div>
				<div class="ct-tongcong">
					<h4>Tổng cộng</h4>
					<div class="row">
						<div class="ct-tongcong1 col-sm-6">Tạm tính:</div>
						<div class="ct-tongcong2 col-sm-6 "><%=KiemTra.tien(donHang.getTongTien())%></div>
					</div>
					<div class="row">
						<div class="ct-tongcong1 col-sm-6">Phí vận chuyển:</div>
						<div class="ct-tongcong2 col-sm-6"><%=KiemTra.tien(0)%></div>
					</div>
					<div class="tinhtoan"></div>
					<div class="row">
						<div class="ct-tongcong1 col-sm-6">Tổng cộng (Bao gồm VAT):
						</div>
						<div class="ct-tongcong2 col-sm-6"><%=KiemTra.tien(donHang.getTongTien())%></div>
					</div>
					<div class="row">
						<div class="ct-tongcong1 col-sm-6">Hình thức thanh toán:</div>
						<div class="ct-tongcong2 col-sm-6">Thanh toán khi nhận hàng
						</div>
					</div>
					<div class="row">
						<div class="ct-tongcong1 col-sm-6">Trạng thái:</div>
						<div class="ct-tongcong2 col-sm-6"><%=KiemTra.trangThai(donHang.getTrangThai())%></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</main>

<%@include file="footer.jsp"%>
