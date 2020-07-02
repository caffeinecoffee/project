<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/boardScript.js"></script>
<script type="text/javascript" src="/resources/js/jquery_board.js"></script>
<link href="/resources/css/board.css" rel="stylesheet">
</head>
<body>
<!-- enctype="multipart/form-data" -->
	<form action="writePro.sp" method="post" name="writePro" enctype="multipart/form-data" onsubmit="return sendData()">
		<input type="text" name="num" value="${bvo.num}">
		
		<input type="text" name="ref" value="${bvo.ref}">
		<input type="text" name="re_step" value="${bvo.re_step}">
		<input type="text" name="re_level" value="${bvo.re_level}">
		
		<input type="text" name="currentPage" value='${pvo.currentPage}'>
		<table>
			<thead>
				<tr>
					<th colspan="2"><h4>글쓰기</h4></th>
				</tr>
				<tr>
					<c:if test="${bvo.num!=0}">
					<th>[답글] 제목</th>
					<td><input type="text" placeholder="제목을 입력하세요" name="subject" value="[답글]"/></td>
					</c:if>
					<c:if test="${bvo.num==0 }">
					<th>제목</th>
					<td><input type="text" placeholder="제목을 입력하세요" name="subject" /></td>
					</c:if>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea type="text" cols="100" rows="20"
							placeholder="내용을 입력하세요" name="content"></textarea></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="file" name="afile" /></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" placeholder="누구셈 ?" name="writer" /></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="email" placeholder="이메일 입력" name="email" /></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" placeholder="비빌번호 입력" name="passwd" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" name="submit" id="submit_article" value="등록" />
					<input type="button" name="button" id="list2" value="글목록으로..." />
				</tr>
			</thead>
		</table>
	</form>
</body>
</html>