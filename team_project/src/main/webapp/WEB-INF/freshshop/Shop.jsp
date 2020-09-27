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
<title>Freshshop - Ecommerce Bootstrap 4 HTML Template</title>
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
	<div class="all-title-box">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${category_no==0}">
						<h2>전체상품</h2>
					</c:if>
					<c:if test="${category_no==1}">
						<h2>마리모 바스켓</h2>
					</c:if>
					<c:if test="${category_no==2}">
						<h2>식물 바스켓</h2>
					</c:if>
					<c:if test="${category_no==3}">
						<h2>셀프 바스켓</h2>
					</c:if>
					<c:if test="${category_no==4}">
						<h2>테라리움 바스켓</h2>
					</c:if>
					<c:if test="${category_no==5}">
						<h2>켈리/토퍼 바스켓</h2>
					</c:if>
				</div>
			</div>
		</div>
    </div>
	<!-- Start Shop Page  -->
	<div class="shop-box-inner">
		<div class="container">
			<div class="row">
				<div class="col-xl-12 col-lg-12 col-sm-12 col-xs-12 shop-content-right">
					<div class="right-product-box">
						<div class="product-item-filter row">
							<div class="col-12 col-sm-4 text-center text-sm-left">
								<div class="toolbar-sorter-right">
									<form action="shop" id="orderListform">
										<select id="orderListSelect" name="orderListSelect" onchange="submit()">
											<option value="1" data-display="Select" <c:if test="${option==1}">selected</c:if>>등록순</option>
											<option value="2" <c:if test="${option==2}">selected</c:if> >이름 순</option>
											<option value="3" <c:if test="${option==3}">selected</c:if> >높은 가격 순</option>
											<option value="4" <c:if test="${option==4}">selected</c:if> >낮은 가격 순</option>
											<option value="5" <c:if test="${option==5}">selected</c:if> >인기순</option>
										</select>
										<input type="hidden" name="category_no" value='<c:out value="${category_no}"></c:out>'>
										<input type="hidden" name="search" value='<c:out value="${search}"></c:out>'>
									</form>
								</div>
							</div>
							<div class="col-12 col-sm-4 text-center text-sm-left">
								<div class="search-product">
									<form action="/shop">
										<input class="form-control" placeholder="검색" name="search" type="text">
										<input type="hidden" name="option" value='<c:out value="${option}"></c:out>'>
										<input type="hidden" name="category_no" value='<c:out value="${category_no}"></c:out>'>
										<button type="submit"> <i class="fa fa-search"></i>
										</button>
									</form>
								</div>
							</div>
						</div>
						<div class="product-categorie-box">
							<div class="tab-content">
								<div role="tabpanel" class="tab-pane fade show active" id="grid-view">
									<div class="row">
<!-- 그리드 정렬 상품 시작 -->
										<c:forEach var="idto" items="${list}">
											<div class="col-lg-3 col-md-6 special-grid best-seller">
												<div class="products-single fix">
													<div class="box-img-hover">
														<div class="type-lb">
															<c:if test="${idto.item_first_price>idto.item_discount}">
																<p class="sale">Sale</p>
															</c:if>
														</div>
														<img src="${idto.item_thumbnail}" class="img-fluid" alt="Image">
														<div class="mask-icon">
															<ul>
																<li><a href="shopDetail?item_no=${idto.item_no}" data-toggle="tooltip" data-placement="right" title="자세히 보기"><i class="fas fa-eye"></i></a></li>
																<li><a href="#" data-toggle="tooltip" data-placement="right" onclick="location.href='addInterestedItem?item_no=${idto.item_no}'" title="관심상품 담기"><i class="far fa-heart"></i></a></li>
															</ul>
															<a class="cart" href="#" onclick="location.href='cartProc?item_no=${idto.item_no}'">장바구니 담기</a>
														</div>
													</div>
													<div class="why-text">
														<h4>
															<c:out value="${idto.item_name}" />
														</h4>
														<h5>
														<c:if test="${idto.item_first_price>idto.item_discount}">
															<del> 
																&#8361;<c:out value="${idto.item_first_price}" />
															</del>
															&nbsp;&nbsp;&nbsp;
														</c:if>
															&#8361;<c:out value="${idto.item_discount}" />
														</h5>
													</div>
												</div>
											</div>
										</c:forEach>
<!-- 그리드 정렬 상품 끝 -->
									</div>
									<table>
										<h1 style="text-align: center">
											<a href="/shop?presentPage=1&orderListSelect=${option}&category_no=${category_no}"> [start] </a>
												<c:if test="${pdto.presentPage!=1}"><a href="/shop?presentPage=${pdto.presentPage-1}&orderListSelect=${option}&category_no=${category_no}&category_no=${category_no}"> < </c:if></a>
												<c:forEach var="i" begin="${pdto.startPage}" end="${pdto.endPage}">
													<c:if test="${pdto.presentPage==i}"><a href="/shop?presentPage=${i}&orderListSelect=${option}&category_no=${category_no}"><span style="color: red"><c:out value="[${i}]"/></span></a></c:if>
													<c:if test="${pdto.presentPage!=i}"><a href="/shop?presentPage=${i}&orderListSelect=${option}&category_no=${category_no}"><c:out value="[${i}]"/></a></c:if>
												</c:forEach>
												<c:if test="${pdto.presentPage!=pdto.endPage}"><a href="/shop?presentPage=${pdto.presentPage+1}&orderListSelect=${option}&category_no=${category_no}"> > </c:if></a>
											<a href="/shop?presentPage=${pdto.allPage}&orderListSelect=${option}&category_no=${category_no}"> [end] </a>
										</h1>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Shop Page -->

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
	<script src="/resources/js/jquery-ui.js"></script>
	<script src="/resources/js/jquery.nicescroll.min.js"></script>
	<script src="/resources/js/form-validator.min.js"></script>
	<script src="/resources/js/contact-form-script.js"></script>
	<script src="/resources/js/custom.js"></script>

	<script src="/resources/js/sang.js"></script>
</body>

</html>