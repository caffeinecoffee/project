<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="eu">
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

</head>

<body>
	<c:import url="top.jsp"/>
	
    <!-- Start Slider -->
    <div id="slides-shop" class="cover-slides">
        <ul class="slides-container">
        <c:forEach var="idto" items="${popularItem}">
            <li class="text-center">
                <img src="${idto.item_thumbnail}" alt="">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <h1 class="m-b-20"><strong>Welcome To <br> PMJSMJ</strong></h1>
                            <p><a class="btn hvr-hover" href="shop?category_no=0">Shop New</a></p>
                        </div>
                    </div>
                </div>
            </li>
		</c:forEach>
        </ul>
    </div>
    <!-- End Slider -->
    
	<!-- Start Products  -->
    <div class="products-box">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="title-all text-center">
                        <h1>MD 추천 상품</h1>
                    </div>
                </div>
            </div>
            <div class="row special-list">
                <c:forEach var="idto" items="${MDItem}">
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
            </div>
        </div>
    </div>
    <!-- End Products  -->

    <!-- Start Products  -->
    <div class="products-box">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="title-all text-center">
                        <h1>인기 상품</h1>
                    </div>
                </div>
            </div>
            <div class="row special-list">
				<c:forEach var="idto" items="${popularItem}">
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
            </div>
        </div>
    </div>
    <!-- End Products  -->

    <!-- Start Blog  -->
    <div class="latest-blog">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="title-all text-center">
                        <h1>이번 주 인기 상품</h1>
                    </div>
                </div>
            </div>
            <div class="row">
	            <c:forEach var="idto" items="${weekPopularItem}">
	                <div class="col-md-6 col-lg-4 col-xl-4">
	                    <div class="blog-box">
	                        <div class="blog-img">
	                            <img class="img-fluid" src="${idto.item_thumbnail}" alt="" />
	                        </div>
	                        <div class="blog-content">
	                            <div class="title-blog">
	                                <h3><c:out value="${idto.item_name}" /></h3>
	                                <p><c:out value="${idto.item_descripttion}" /></p>
	                            </div>
	                            <ul class="option-blog">
	                                <li><a href="shopDetail?item_no=${idto.item_no}" data-toggle="tooltip" data-placement="right" title="자세히 보기"><i class="fas fa-eye"></i></a></li>
										<li><a href="#" data-toggle="tooltip" data-placement="right" onclick="location.href='addInterestedItem?item_no=${idto.item_no}'" title="관심상품 담기"><i class="far fa-heart"></i></a></li>
	                            </ul>
	                        </div>
	                    </div>
	                </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <!-- End Blog  -->

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
	<c:import url="footer.jsp"/>
</html>