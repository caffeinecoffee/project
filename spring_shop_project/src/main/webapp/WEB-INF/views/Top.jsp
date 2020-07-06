<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table>
	<tr>
		<c:choose>
			<c:when test="${member.mem_id==null}">
				<th><a href="/login">로그인</a></th>
				<th><a href="/register">회원가입</a></th>
			</c:when>
			<c:otherwise>
				<th><a href="/logout">로그아웃</a></th>
				<th><a href="/memberUpdate">회원수정</a></th>
			</c:otherwise>
		</c:choose>
		<th><a href="/productList">상품목록</a></th>
		<th><a href="/cartList">장바구니</a></th>
		<th><a href="/orderList">구매목록</a></th>
	</tr>
</table>
