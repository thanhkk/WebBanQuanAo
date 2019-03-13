<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="header.jsp"%>
    
      <main>
        <!-- main -->
        <div class="main-body">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d7560.144201485486!2d105.69792000790399!3d18.660760263493128!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3139cdde5e40a551%3A0x543b433120d5699b!2zVHJ1bmcgdMOibSBDTlRUIC0gVHLGsOG7nW5nIMSQ4bqhaSBo4buNYyBWaW5o!5e0!3m2!1svi!2s!4v1544437323582" width="100%" height="100%" frameborder="0" style="border:0" allowfullscreen></iframe>
                    </div>
                    <div class="col-sm-6">
                        <div class="lienhe-top">
                            <h3>Ý kiến khách hàng</h3>
                        </div>
                        <div class="lienhe-mid">
                            <form action="/action_page.php">
                                <div class="form-group">
                                    <label for="pwd">Địa chỉ email (bắt buộc)</label>
                                    <input type="text" class="form-control" id="pwd">
                                </div>
                                <div class="form-group">
                                    <label for="pwd">Tiêu đề</label>
                                    <input type="text" class="form-control" id="pwd">
                                </div>
                                <div class="form-group">
                                    <label for="comment">Nội dung</label>
                                    <textarea class="form-control" rows="7" id="comment"></textarea>
                                </div>
                                <button type="submit" class="btn btn-success">Gửi ngay</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
        <%@include file="footer.jsp"%>