<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/resources/css/top.css">
<!-- Start Main Top -->
<header class="main-header">
	<!-- Start Navigation -->
	<nav
		class="navbar navbar-expand-lg navbar-light bg-light navbar-default bootsnav">
		<div class="container">
			<!-- Start Header Navigation -->
			<div class="navbar-header">
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbar-menu" aria-controls="navbars-rs-food"
					aria-expanded="false" aria-label="Toggle navigation">
					<i class="fa fa-bars"></i>
				</button>
				<a class="navbar-brand" href="index"><img
					src="/resources/images/logo.jpg" class="logo" alt=""></a>
			</div>
			<!-- End Header Navigation -->

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="navbar-menu">
				<ul class="nav navbar-nav ml-auto" data-in="fadeInDown" data-out="fadeOutUp">
					<li class="nav-item"><a class="nav-link" href="shop?category_no=0">전체 상품</a></li>
					<li class="nav-item"><a class="nav-link" href="shop?category_no=1">마리모바스켓</a></li>
					<li class="nav-item"><a class="nav-link" href="shop?category_no=2">식물바스켓</a></li>
					<li class="nav-item"><a class="nav-link" href="shop?category_no=3">셀프바스켓</a>
					<li class="nav-item"><a class="nav-link" href="shop?category_no=4">테라리움 바스켓</a></li>
					<li class="nav-item"><a class="nav-link" href="shop?category_no=5">켈리/토퍼 바스켓</a></li>
<!-- 					<li class="nav-item"><a class="nav-link" -->
<!-- 						href="contact-us.html">생활용품</a></li> -->
				</ul>
			</div>
			<!-- /.navbar-collapse -->

			<!-- Start Atribute Navigation -->
			<div class="attr-nav">
				<ul>
<!-- 					<li class="search"><a href="#"><i class="fa fa-search"></i></a></li> -->
					<li class="side-menu"><a href="#" onclick="location.href='cartDetail'"><i class="fa fa-shopping-bag"></i><p>My Cart</p>
					</a></li>
				</ul>
			</div>
			<!-- login start -->
			<!-- login end -->
			<!-- End Atribute Navigation -->
		</div>
		
		<div class="loginContain">
			<c:choose>
				<c:when test="${mdto == null}">
						<p class="joinBtn">
							<a class="loginBtnText" href="SignUp">회원가입</a>
						</p>
						<p class="loginBtn">
							<a class="loginBtnText" href="loginPage">로그인</a>
						</p>
				</c:when>
				<c:otherwise>
					<p class="loginBtn">
						<a class="userName" href="myAccount">${mdto.mem_name }</a><font class="nimFont">님</font>
						<a class="logoutBtnText" href="logout">로그아웃</a>
					</p>
				</c:otherwise>
			</c:choose>
		</div>
	</nav>
	<!-- End Navigation -->
		
</header>
<!-- End Main Top -->

<!-- Start Top Search -->
<div class="top-search">
	<div class="container">
		<div class="input-group">
			<span class="input-group-addon"><i class="fa fa-search"></i></span>
			<input type="text" class="form-control" placeholder="Search" name="search">
			<span class="input-group-addon close-search"><i class="fa fa-times"></i></span>
		</div>
	</div>
</div>
<!-- End Top Search -->