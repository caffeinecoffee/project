<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table>
	<tr>
		<c:choose>
			<c:when test="${idKey==null}">
				<script type="text/javascript">
					alert("로그인이 필요합니다.");
					location.href = "/";
				</script>
			</c:when>
			<c:otherwise>
				<th><a href="/admin/index">홈</a></th>
				<th><a href="/logout">로그아웃</a></th>
				<th><a href="/memberMgr">화원관리</a></th>
				<th><a href="/productMgr">상품관리</a></th>
				<th><a href="/oderMgr">주문관리</a></th>
			</c:otherwise>
		</c:choose>
	</tr>
</table>
