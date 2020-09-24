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

<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	<c:import url="top.jsp" />
	<div class="shop-detail-box-main">
		<div class="container">
			<div class="row">
				<div class="col-xl-5 col-lg-5 col-md-6">
					<div id="carousel-example-1"
						class="single-product-slider carousel slide" data-ride="carousel">
						<div class="carousel-inner" role="listbox">
							<div class="carousel-item active">
								<img class="d-block w-100"
									src="${idto.item_thumbnail}" alt="First slide">
							</div>
<!-- 							<div class="carousel-item"> -->
<!-- 								<img class="d-block w-100" -->
<!-- 									src="/resources/images/big-img-02.jpg" alt="Second slide"> -->
<!-- 							</div> -->
<!-- 							<div class="carousel-item"> -->
<!-- 								<img class="d-block w-100" -->
<!-- 									src="/resources/images/big-img-03.jpg" alt="Third slide"> -->
<!-- 							</div> -->
						</div>
<!-- 						<a class="carousel-control-prev" href="#carousel-example-1" -->
<!-- 							role="button" data-slide="prev"> <i class="fa fa-angle-left" -->
<!-- 							aria-hidden="true"></i> <span class="sr-only">Previous</span> -->
<!-- 						</a> <a class="carousel-control-next" href="#carousel-example-1" -->
<!-- 							role="button" data-slide="next"> <i class="fa fa-angle-right" -->
<!-- 							aria-hidden="true"></i> <span class="sr-only">Next</span> -->
<!-- 						</a> -->
					</div>
				</div>
				<div class="col-xl-7 col-lg-7 col-md-6">
					<div class="single-product-details">
						<h2>
							<c:out value="${idto.item_name}" />
						</h2>
						<c:if test="${idto.item_first_price>idto.item_discount}">
							<del>
								<h5>
									소비자 가격 : &#8361;
									<c:out value="${idto.item_first_price}" />
								</h5>
							</del>&nbsp;&nbsp;&nbsp;
						</c:if>
						<h5>
							판매 가격 : &#8361;
							<c:out value="${idto.item_discount}" />
						</h5>
						<h5>배송비 : &#8361;2500</h5>
						<h5>기본옵션</h5>
						<select id="basic" class="" name="option_no" data-placeholder="$ USD">
							<option value="0" data-display="Select">옵션 선택</option>
							<option value='<c:out value="${idto.item_name}"/>'><c:out value="${idto.item_name}"/></option>
						</select>
						<h4>상품 설명</h4>
						<p>
							<textarea rows="2" cols="87" style="resize: none;" readonly="readonly">
								<c:out value="${idto.item_descripttion}" />
							</textarea>
						</p>
						<ul>
							<li>
								<div class="form-group quantity-box">
									<label class="control-label">수량</label>
									<input class="" name="cart_cnt" value="0" min="0" max="20" type="number">
								</div>
							</li>
						</ul>

						<div class="price-box-bar">
							<div class="cart-and-bay-btn">
								<c:if test="${idto.item_stock==0}">
									<a class="btn hvr-disabled" data-fancybox-close="" href="#"><del>품절</del></a>
								</c:if>
								<c:if test="${idto.item_stock>0}">
									<a class=" btn hvr-hover cart" href="#" onclick="location.href='cartProc?item_no=${idto.item_no}'">장바구니 담기</a>
									<a class="btn hvr-hover" onclick="location.href='addInterestedItem?item_no=${idto.item_no}'">보관함 담기</a>
								</c:if>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- 상품 설명 이미지 -->
			<div class="row">
				<!-- 				<div class="col-xl-5 col-lg-5 col-md-6"> -->
				<!-- 					<img -->
				<!-- 						src="http://image1.coupangcdn.com/image/vendor_inventory/6570/142c11efe363794ad9a0db15388b7bbae04a206b7f83e494ca5518d73c02.jpg" -->
				<!-- 						style="width: auto; height: auto; min-width: 1100px; man-width: 1100px;"> -->
				<!-- 				</div> -->
			</div>
			<!-- 상품 설명 이미지 끝 -->
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

						<hr>
						<a href="reviewList?item_no=${idto.item_no}" class="btn hvr-hover">후기 더보기</a>
						<a href="reviewWrite?item_no=${idto.item_no}" class="btn hvr-hover">후기 작성하기</a>
					</div>
				</div>
			</div>



			<div class="row my-5">
				<div class="card card-outline-secondary my-4">
					<div class="card-header">
						<h2>상품 문의</h2>
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
									</colgroup>
									<thead>
										<tr>
											<th scope="col" class="input_txt">글번호</th>
											<th scope="col" class="input_txt">제목</th>
											<th scope="col" class="input_txt" align="left">작성자</th>
											<th scope="col" class="input_txt">작성일</th>
										</tr>
									</thead>
									<tbody>
										<!-- for문 시작 -->
										<c:forEach var="indto" items="${ItemInquiryList}">
											<tr>
												<td scope="col" class="input_txt" style="overflow: hidden"><a href="itemInquiryDescribe?inq_no=${indto.inq_no}" style="color: black; font-size: 16px; font-weight: 400; padding: .75rem;"><c:out value="${indto.inq_no}" /></a></td>
												<td scope="col" class="input_txt" style="overflow: hidden"><a href="itemInquiryDescribe?inq_no=${indto.inq_no}" style="color: black; font-size: 16px; font-weight: 400; padding: .75rem;"><c:out value="${indto.inq_title}" /></a></td>
												<td scope="col" class="input_txt" align="left" style="color: black; font-size: 16px; font-weight: 400; padding: .75rem;"><c:out value="${indto.mem_id}" /></td>
												<td scope="col" class="input_txt" style="color: black; font-size: 16px; font-weight: 400; padding: .75rem;"><c:out value="${indto.inq_reg_date}" /></td>
											</tr>
										</c:forEach>
										<!-- for문 끝 -->
									</tbody>
								</table>
							</div>
						</div>

						<hr>
						<a href="ItemInquiryList?item_no=${idto.item_no}" class="btn hvr-hover">문의 더보기</a>
						<a href="/itemInquiryWrite?item_no=${idto.item_no}" class="btn hvr-hover">문의 작성하기</a>
					</div>
				</div>
			</div>




			<!-- 같이 팔린 상품 리스트 시작 -->
			<div class="row my-5">
				<div class="col-lg-12">
					<div class="title-all text-center">
						<h1>같이 팔린 상품</h1>
					</div>
					<div class="featured-products-box owl-carousel owl-theme">
						<!-- 같이 팔린 상품 시작 -->
						<c:forEach var="lidto" items="${likingItemList}">
						<div class="item">
							<div class="products-single fix">
								<div class="box-img-hover">
									<img src="${lidto.item_thumbnail}" class="img-fluid"
										alt="Image">
									<div class="mask-icon">
										<ul>
											<li><a href="#" data-toggle="tooltip"
												data-placement="right" title="자세히 보기"><i
													class="fas fa-eye"></i></a></li>
											<li><a href="#" data-toggle="tooltip" onclick="location.href='addInterestedItem?item_no=${idto.item_no}'"
												data-placement="right" title="관심상품 담기"><i
													class="far fa-heart"></i></a></li>
										</ul>
										<a class="cart" href="#" onclick="location.href='cartProc?item_no=${idto.item_no}'">장바구니 담기</a>
									</div>
								</div>
								<div class="why-text">
									<h4>
										<c:out value="${lidto.item_name}" />
									</h4>
									<h5>
										<c:if test="${lidto.item_first_price>lidto.item_discount}">
											<del>
												&#8361;
												<c:out value="${lidto.item_first_price}" />
											</del>
															&nbsp;&nbsp;&nbsp;
														</c:if>
										&#8361;
										<c:out value="${lidto.item_discount}" />
									</h5>
								</div>
							</div>
						</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<!-- 같이 팔린 상품 리스트 끝 -->

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