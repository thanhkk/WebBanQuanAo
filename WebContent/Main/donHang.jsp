<%@page import="common.KiemTra"%>
<%@page import="model.bean.DonHang"%>
<%@page import="model.bean.SanPham"%>
<%@page import="java.util.Hashtable"%>
<%@page import="model.bean.ChiTiet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="header.jsp"%>
<%
	ArrayList<DonHang> listDonHang = (ArrayList<DonHang>) request.getAttribute("listDonHang");
%>
<main>
<div class="main-body">
	<div class="container">
		<h3>
			Đơn hàng của
			<%=khachHang.getHoVaTen()%></h3>
		<div class="donhang">


			<%
				for (int i = 0; i < listDonHang.size(); i++) {
			%>
			<table class="table-dh">
				<tr>
					<td colspan="2"><span>Đơn hàng: </span><a
						href="ChiTietDonHangServlet?maDonHang=<%=listDonHang.get(i).getMaDonHang()%>"
						title="">#order<%=listDonHang.get(i).getMaDonHang()%></a><br>
						<span>Ngày mua: <%=listDonHang.get(i).getNgayTao()%></span></td>
					<td class="text-right"><a
						href="ChiTietDonHangServlet?maDonHang=<%=listDonHang.get(i).getMaDonHang()%>"
						title="Chi tiết đơn hàng">Xem chi tiết</a></td>
				</tr>
				<tr>
					<td id="dh-info">Số điện thoại:<%=listDonHang.get(i).getSoDienThoai()%><br>Địa
						chỉ: <%=listDonHang.get(i).getDiaChi()%></td>
					<td><%=KiemTra.tien(listDonHang.get(i).getTongTien())%></td>
					<td class="text-right">
						<%
							if (listDonHang.get(i).getTrangThai() == 0) {
						%> <a
						href="DonHangServlet?daNhan=daNhan&maDonHang=<%=listDonHang.get(i).getMaDonHang()%>"
						title="Xác nhận đã nhận hàng" class="text-success"> <i
							class="far fa-check-square"></i>
					</a> <a
						href="DonHangServlet?huy=huy&maDonHang=<%=listDonHang.get(i).getMaDonHang()%>"
						title="Yêu cầu huỷ đơn hàng" class="text-warning"> <i
							class="far fa-trash-alt"></i>
					</a> <span id="danggiao">Đang giao</span> <%
 	} else if (listDonHang.get(i).getTrangThai() == 1) {
 %><span id="danhan">Đã nhận</span> <%
 	} else {
 %><span id="dahuy">Đã huỷ đơn</span> <%
 	}
 %>



					</td>

				</tr>
			</table>



			<%
				}
			%>
		
		</div>
	</div>
</main>


<%@include file="footer.jsp"%>
