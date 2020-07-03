<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 내용</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/boardScript.js"></script>
<script type="text/javascript" src="/resources/js/jquery_board.js"></script>
<link href="/resources/css/board.css" rel="stylesheet">
</head>
<body>
	<table>
		<thead>
			<tr>
				<th colspan="2"><h4>글쓰기</h4></th>
			</tr>
			<tr>
				<td>제목</td>
				<td><c:out value="${bvo.subject}" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea type="text" cols="100" rows="20" readonly="readonly"><c:out
							value="${bvo.content}" /></textarea></td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td><c:out value="${bvo.attachNm}" /></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><a href='mailto:<c:out value="${bvo.email}"/>'> <c:out
							value="${bvo.writer}" />
				</a></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" id="up_btn" value="글수정" onclick="pwCheck('u');" />
				<input type="button" id="del_btn" value="글삭제" onclick="pwCheck('d');" />
				<input type="button" id="reply" value="답글"/>
				<input type="button" id="list1" value="글목록으로..." />
			</tr>
		</thead>
	</table>
	<form action="" name="parentForm" method="post">
		<input type="hidden" name="passwd" value="${bvo.passwd}">
		<input type="hidden" name="num" value="${bvo.num}">
		<input type="hidden" name="cpass" value="">
		
		<input type="hidden" name="readcnt" value="${bvo.readcnt}">
		<input type="hidden" name="ref" value="${bvo.ref}">
		<input type="hidden" name="re_step" value="${bvo.re_step}">
		<input type="hidden" name="re_level" value="${bvo.re_level}">
		
		<input type="text" name="currentPage" value='${pvo.currentPage}'>
	</form>
</body>
</html>