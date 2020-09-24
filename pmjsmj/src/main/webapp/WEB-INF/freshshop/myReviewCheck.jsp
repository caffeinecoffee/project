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
<title>ThewayShop - Ecommerce Bootstrap 4 HTML Template</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">

<!-- Site Icons -->
<link rel="shortcut icon" href="/resources/images/favicon.ico"
	type="image/x-icon">
<link rel="apple-touch-icon"
	href="/resources/images/apple-touch-icon.png">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<!-- Site CSS -->
<link rel="stylesheet" href="/resources/css/style.css">
<!-- Responsive CSS -->
<link rel="stylesheet" href="/resources/css/responsive.css">
<!-- Custom CSS -->
<link rel="stylesheet" href="/resources/css/custom.css">
<!-- my-account-interested CSS -->
<link rel="stylesheet" href="/resources/css/myQandACheck.css">
<!-- paging CSS -->
<link rel="stylesheet" href="/resources/css/paging.css">
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
<script src="/resources/js/paging.js"></script>
</head>

<body>
	<c:if test="${mdto == null }">
		<script type="text/javascript">
			location.href = "loginPage";
		</script>
	</c:if>
	<c:import url="top.jsp" />
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
				<p style="font-size: 37px; font-weight: bold; margin-left: 275px;">리뷰
					확인</p>
			</div>
			<c:import url="my-account-left-nav.jsp" />
			<div class="QandA_Contain">
				<div class="reviewDiv">
					<p>
						<font class="reviewTitle">REVIEW</font>&nbsp; <font>내가 작성한
							리뷰</font>
					</p>
					<div class="line"></div>
					<table class="reviewTable">
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
						</tr>
						<c:if test="${hash != null }">
							<c:forEach items="${hash.mprList }" var="mprDTO">
								<tr>
									<td>${mprDTO.review_no}</td>
									<td>${mprDTO.review_title}</td>
									<td>${mprDTO.mem_id}</td>
									<td>${mprDTO.review_date }</td>
								</tr>
							</c:forEach>
						</c:if>
						<c:if test="${hash == null }">
							<tr>
								<td colspan="4">등록된 리뷰가 없습니다.</td>
							</tr>
						</c:if>
					</table>
					<c:if test="${hash != null }">
						<div class="paging">
							<c:if test="${hash.pdto.presentPage!=1}">
								<a href="/myReviewCheck?presentPage=1" class="btn_arr prev">&lt;</a>
							</c:if>

							<!-- D : 활성화페이지일 경우 : on 처리 -->
							<c:forEach var="i" begin="${hash.pdto.startPage}"
								end="${hash.pdto.endPage}">
								<c:if test="${i == hash.pdto.presentPage }">
									<a href="/myReviewCheck?presentPage=${i}" id="page${i }"
										class="on">${i }</a>
								</c:if>
								<c:if test="${i != hash.pdto.presentPage }">
									<a href="/myReviewCheck?presentPage=${i}" id="page${i }">${i }</a>
								</c:if>
							</c:forEach>
							<c:if test="${hash.pdto.presentPage!=hash.pdto.endPage}">
								<a href="/myReviewCheck?presentPage=${hash.pdto.allPage}"
									class="btn_arr next">&gt;</a>
							</c:if>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<!-- End My Account -->
	<c:import url="footer.jsp" />
</body>
</html>