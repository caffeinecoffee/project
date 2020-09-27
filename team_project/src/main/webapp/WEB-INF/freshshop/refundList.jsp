<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<!-- Basic -->

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Site Metas -->
    <title>환불내역 리스트</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Site Icons -->
    <link rel="shortcut icon" href="/resources/images/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" href="/resources/images/apple-touch-icon.png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <!-- Site CSS -->
    <link rel="stylesheet" href="/resources/css/style.css">
    <!-- Responsive CSS -->
    <link rel="stylesheet" href="/resources/css/responsive.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="/resources/css/custom.css">
    <!-- Cart CSS -->
    <link rel="stylesheet" href="/resources/css/cart.css">
    <!-- font style -->
	<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
     <!-- ALL JS FILES -->
    <script src="/resources/js/jquery-3.2.1.min.js"></script>
    <script src="/resources/js/popper.min.js"></script>
    <script src="/resources/js/bootstrap.min.js"></script>
    <!-- ALL PLUGINS -->
    <script src="/resources/js/jquery.superslides.min.js"></script>
    <script src="/resources/js/bootstrap-select.js"></script>
    <script src="/resources/js/inewsticker.js"></script>
    <script src="/resources/js/bootsnav.js"></script>
    <script src="/resources/js/images-loded.min.js"></script>
    <script src="/resources/js/isotope.min.js"></script>
    <script src="/resources/js/owl.carousel.min.js"></script>
    <script src="/resources/js/baguetteBox.min.js"></script>
    <script src="/resources/js/form-validator.min.js"></script>
    <script src="/resources/js/contact-form-script.js"></script>
    <script src="/resources/js/custom.js"></script>
    <script src="/resources/js/product.js"></script>
    <!-- 숫자 콤마 넣어주는 역활 (myAccount.js)-->
	<script src="/resources/js/myAccount.js"></script>
</head>

<body>
<c:if test="${mdto == null }">
	<script type="text/javascript">
		location.href="loginPage";
	</script>
</c:if>
<c:import url="top.jsp"/>
    <!-- Start All Title Box -->
    <div class="all-title-box">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h2>My Account</h2>
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Shop</a></li>
                        <li class="breadcrumb-item active">My Account</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- End All Title Box -->

    <!-- Start My Account  -->
    <div class="my-account-box-main">
        <div class="container">
        <div style="width: 100%; height: 65px;">
				<p style="font-size: 35px; font-weight: bold; margin-left: 275px;">환불내역</p>
		</div>
           <c:import url="my-account-left-nav.jsp"/>
            <!-- start 환불내역 리스트 -->
    <div class="refundList-wrap">
	    <div class="refundList-boardlist-box">
	    	<table border="1" class="refundList-boardlist">
				<thead>
					<tr>
						<th>상품정보</th>
						<th>환불금액</th>
						<th>취소신청날짜</th>
						<th>취소완료날짜</th>
						<th>승인여부</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${rflistDTO}" var="rfdto">
					<tr height="60px;">
						<td style="vertical-align: middle">
							<font>${rfdto.item_name}</font>
						</td>
						<td style="vertical-align: middle">
							<font><script type="text/javascript">numberWithCommas(${rfdto.refund_money })</script></font>
						</td>
						<td style="vertical-align: middle">
							<font>${rfdto.cancel_receipt_date}</font>
						</td>
						<td style="vertical-align: middle">
							<c:if test="${rfdto.cancel_complete_date == null}">
								<font>ㅡ</font>
							</c:if>
							<c:if test="${rfdto.cancel_complete_date != null}">
								<font>${rfdto.cancel_complete_date}</font>
							</c:if>
							
						</td>
						<td style="vertical-align: middle">
							<c:if test="${rfdto.admin_approval_or_not == 0}">
								<font>취소대기</font>
							</c:if>
							<c:if test="${rfdto.admin_approval_or_not == 1}">
								<font>취소완료</font>
							</c:if>
						</td>
						
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
    </div>
    </div>
    </div>
    <!-- End My Account -->
<c:import url="footer.jsp"/>
</body>

</html>