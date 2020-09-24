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

<script src="/resources/js/inquiryReviewWrite.js"></script>
<script src="/resources/summernote/lang/summernote-ko-KR.js"></script>
<script src="/resources/summernote/summernote-lite.js"></script>
<link rel="stylesheet" href="/resources/summernote/summernote-lite.css">
<script type="text/javascript">
$(document).ready(function() {
	$('#summernote').val("${indto.inq_content}");
// 	$('#summernote').summernote('editor.insertText', '${indto.inq_content}');
	//여기 아래 부분
	$('#summernote').summernote({
		  height: 300,					// 에디터 높이
		  minHeight: null,				// 최소 높이
		  maxHeight: null,				// 최대 높이
		  focus: false,					// 에디터 로딩후 포커스를 맞출지 여부
		  lang: "ko-KR",				// 한글 설정
		  callbacks: {
	        	onImageUpload: function(files, editor, welEditable) {
	        		for(var i = files.length -1; i>=0; i--) {
	        			sendFile(files[i], this);
	        		}
	        	}
	        }
	});
});
</script>

<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">

<!-- 사용자 추가 -->
<script src="/resources/js/sang.js"></script>
<!-- 사용자 추가 -->

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
	<!-- Start Contact Us  -->
	<div class="contact-box-main">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-sm-12">
					<div class="contact-form-right">
						<h2>상품 문의</h2>
						<h6></h6>
						<form id="contactForm" action="/itemInquiryUpdateProc">
						<input type="hidden" name="item_no" value="${indto.item_no}">
						<input type="hidden" name="inq_no" value="${indto.inq_no}">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group" style="margin-bottom: 2px;">
										<select id="select" class="question_no" name="question_no" data-placeholder="">
											<option value="0" data-display="Select">문의 내용 선택</option>
											<option value="1" <c:if test="${indto.question_no==1}">selected</c:if> >배송</option>
											<option value="2" <c:if test="${indto.question_no==2}">selected</c:if> >4</option>
											<option value="3" <c:if test="${indto.question_no==3}">selected</c:if> >3</option>
											<option value="4" <c:if test="${indto.question_no==4}">selected</c:if> >2</option>
											<option value="5" <c:if test="${indto.question_no==5}">selected</c:if> >1</option>
										</select>
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
										<div class="help-block with-errors"></div>
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
										<input type="text" class="form-control" id="subject"
											name="inq_title" value="${indto.inq_title}" readonly="readonly">
										<div class="help-block with-errors"></div>
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
										<form method="post">
											<textarea id="summernote" name="inq_content"></textarea>
										</form>
									</div>
									<div class="submit-button text-center">
										<button class="btn hvr-hover" id="writeSubmit" type="submit">수정</button>
										<button class="btn hvr-hover" id="reset" onclick="history.back(-1)">취소(뒤로가기)</button>
										<div id="msgSubmit" class="h3 text-center hidden"></div>
										<div class="clearfix"></div>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Cart -->
	<c:import url="footer.jsp" />

	<a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a>
</body>

</html>