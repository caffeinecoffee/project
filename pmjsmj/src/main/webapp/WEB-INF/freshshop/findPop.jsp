<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>아이디/비밀번호 찾기</title>
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
<link rel="stylesheet" type="text/css" href="/resources/css/common.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/layout.css" />
<link rel="stylesheet" type="text/css"
	href="/resources/css/showCont.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="/resources/js/placeholders.min.js"></script>
<script src="/resources/js/showCont.js"></script>
<script src="/resources/js/findPop.js"></script>
<!-- font awesome -->
<link rel="stylesheet" href="/resources/fonts/font-awesome.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>

<body>
	<div class="findPop find" id="findPop find form">
		<h3>아이디/비밀번호 찾기</h3>

		<div class="findTop clear_g">
			<label for="radioFindID"><input type="radio"
				name="radio_find2" id="radioFindID" checked="checked"
				onclick="find_check(1)" /> 아이디</label> <label for="radioFindPW"><input
				type="radio" name="radio_find2" id="radioFindPW"
				onclick="find_check(2)" />비밀번호</label>
		</div>
		<div class="findPop" id="findPop IDfind">
			<table summary="아이디, 비밀번호를 입력할수 있습니다.">
				<caption>아이디, 비밀번호 입력폼</caption>
				<colgroup>
					<col width="91px">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th scope="row"><label for="name">이름</label></th>
						<td>
							<div class="formbox">
								<input maxlength="40" type="text" id="mbName" class="text"
									name="name">
							</div>
						</td>
					</tr>
					<tr>
						<th scope="row"><label for="hp_no_ins01">이메일</label></th>
						<td>
							<div class="formbox">
								<input type="text" title="이메일" value="" name="hp_no_ins"
									id="email" class="text hp">
							</div>
						</td>
					</tr>
				</tbody>
			</table>
			<p class="idCheckMsg"></p>
			<div class="btnWrap">
				<a href="javascript:CloseWindow();"><img
					src="/resources/images/btn_cancel.gif" alt="취소" /></a> <a
					href="javascript:ID_check();"><img
					src="/resources/images/btn_ok.gif" alt="확인" /></a>
			</div>
		</div>

		<div class="findPop" id="findPop PWfind">
			<table summary="아이디, 비밀번호를 입력할	수 있습니다.">
				<caption>아이디, 비밀번호 입력폼</caption>
				<colgroup>
					<col width="91px">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th scope="row"><label for="name">아이디</label></th>
						<td>
							<div class="formbox">
								<input maxlength="40" type="text" id="mbID" class="text"
									name="name">
							</div>
						</td>
					</tr>
					<tr>
						<th scope="row"><label for="hp_no_ins01">이메일</label></th>
						<td>
							<div class="formbox">
								<input type="text" title="이메일" value="" name="hp_no_ins"
									id="mem_email" class="text hp">
							</div>
						</td>
					</tr>
					<tr>
						<th class="verification_code_th" scope="row"
							style="display: none;"><label for="hp_no_ins01">인증번호</label></th>
						<td>
							<div class="verification_code_formbox" style="display: none;">
								<input type="text" title="인증번호" value="" name="hp_no_ins"
									id="verification_code" class="text hp">
								<button type="button" class="btn btn-primary" id="certification_number_btn" style="font-size: 8pt;font-weight: bold;">인증번호 확인</button>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
			<p class="pwCheckMsg"></p>
			<div class="btnWrap">
				<a href="javascript:CloseWindow();"><img
					src="/resources/images/btn_cancel.gif" alt="취소" /></a> <a
					href="javascript:PW_check();"><img
					src="/resources/images/btn_ok.gif" alt="확인" /></a>
			</div>
		</div>
	</div>
</body>
</html>