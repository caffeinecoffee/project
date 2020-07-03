<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 내용</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery_member.js"></script>
<link href="/resources/css/board.css" rel="stylesheet">
</head>
<body>
	<form action="" name="SignPro" method="post">
	<table>
		<thead>
			<tr>
				<th colspan="2"><h4>회원정보</h4></th>
			</tr>
			<tr>
				<th>아이디</th>
				<td>
				<c:out value="${mvo.memId}"/>
				<input type="hidden" name="memId" value='<c:out value="${mvo.memId}"/>'>
				<input type="hidden" name="memSeq" value='<c:out value="${mvo.memSeq}"/>'>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" placeholder="비밀번호를 입력하세요" class="chk" id="passwd1" name="memPasswd" title="비밀번호"></td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td>
					<input type="password" id="passwd2" placeholder="비밀번호 확인" name="passwdchk">
					<font name="check" color="red"></font>
				</td>
			</tr>
			<tr>
				<th>회원이름</th>
				<td><input type="text" name="memName" class="chk" value='<c:out value="${mvo.memName}"/>'></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="memTel" class="chk" value='<c:out value="${mvo.memTel}"/>'></td>
			</tr>
			<tr>
				<th>회원생일</th>
				<td><input type="text" name="memBirth" class="chk" value='<c:out value="${mvo.memBirth}"/>'></td>
			</tr>
			<tr>
				<th>가입일</th>
				<td>
				<c:out value="${mvo.regDate}"/>
				<input type="hidden" name="regDate" value='<c:out value="${mvo.regDate}"/>'>
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="memEmail" class="chk" value='<c:out value="${mvo.memEmail}"/>'></td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
				<input type="radio" class="chk" name="memGender" title="성별" value="M">남자
				<input type="radio" class="chk" name="memGender" title="성별" value="F">여자
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" id="up_btn" value="정보수정"/>
				<input type="button" id="del_btn" value="탈퇴"/>
				<input type="button" id="list1" value="글목록으로..." />
			<input type="hidden" name="currentPage" value='${pvo.currentPage}'/>
			</tr>
		</thead>
	</table>
	</form>
</body>
</html>