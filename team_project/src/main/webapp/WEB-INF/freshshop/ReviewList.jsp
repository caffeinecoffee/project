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

<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	<c:import url="top.jsp" />
	<div class="shop-detail-box-main">
		<div class="container">
			<h2><c:out value="${idto.item_name}" /></h2>
				<div class="row my-5">
					<div class="card card-outline-secondary my-4">
						<div class="card-header">
							<h2>후기</h2>
						</div>
						<div class="card-body">
							<div class="media mb-3">
								<div class="table-main table-responsive">
									<table class="table">
										<colgroup>
											<col style="width: 200px;">
											<col style="width: 700px;">
											<col style="width: 100px;">
											<col style="width: 100px;">
											<col style="width: 100px;">
											</colgroup>
										<thead>
											<tr>
												<th scope="col" class="input_txt">글번호</th>
												<th scope="col" class="input_txt">제목</th>
												<th scope="col" class="input_txt" align="left">작성자</th>
												<th scope="col" class="input_txt">작성일</th>
												<th scope="col" class="input_txt">좋아요</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="rdto" items="${reviewList}">
												<tr>
													<td scope="col" class="input_txt" style="overflow: hidden"><a href="ReviewDescribe?review_no=${rdto.review_no}" style="color: black; font-size: 16px; font-weight: 400; padding: .75rem;"><c:out value="${rdto.review_no}" /></a></td>
													<td scope="col" class="input_txt" style="overflow: hidden"><a href="ReviewDescribe?review_no=${rdto.review_no}" style="color: black; font-size: 16px; font-weight: 400; padding: .75rem;"><c:out value="${rdto.review_title}"/></a></td>
													<td scope="col" class="input_txt" align="left" style="color: black; font-size: 16px; font-weight: 400; padding: .75rem;"><c:out value="${rdto.mem_id}" /></td>
													<td scope="col" class="input_txt" style="color: black; font-size: 16px; font-weight: 400; padding: .75rem;"><c:out value="${rdto.review_date}" /></td>
													<td scope="col" class="input_txt" style="color: black; font-size: 16px; font-weight: 400; padding: .75rem;"><c:out value="${rdto.review_like}" /></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						<table>
							<h1 style="text-align: center">
								<a href="/reviewList?presentPage=1&item_no=${item_no}" style="color: black"> [start] </a>
									<c:if test="${pdto.presentPage!=1}"><a href="/reviewList?presentPage=${pdto.presentPage-1}&item_no=${item_no}" style="color: black"> < </c:if></a>
									<c:forEach var="i" begin="${pdto.startPage}" end="${pdto.endPage}">
										<c:if test="${pdto.presentPage==i}"><a href="/reviewList?presentPage=${i}&item_no=${item_no}"><span style="color: red"><c:out value="[${i}]"/></span></a></c:if>
										<c:if test="${pdto.presentPage!=i}"><a href="/reviewList?presentPage=${i}&item_no=${item_no}" style="color: black"><c:out value="[${i}]"/></a></c:if>
									</c:forEach>
									<c:if test="${pdto.presentPage!=pdto.endPage}"><a href="/reviewList?presentPage=${pdto.presentPage+1}&item_no=${item_no}" style="color: black"> > </c:if></a>
								<a href="/reviewList?presentPage=${pdto.allPage}&item_no=${item_no}" style="color: black"> [end] </a>
							</h1>
						</table>
							<hr>
							<a href="reviewWrite?item_no=${item_no}" class="btn hvr-hover">작성하기</a>
						</div>
					</div>
				</div>



		</div>
	</div>
	<!-- End Cart -->


	<c:import url="footer.jsp" />

	<a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a>

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
</body>

</html>