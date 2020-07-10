<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${message!=null}">
		<script type="text/javascript">
			var message = '${message}';
			alert(message);
		</script>
	</c:if>
	<script type="text/javascript">
		var url = "${url}"
		if(url.length==0 || url==null || url=="") url ='/';
		document.location.href=url;
	</script>
</body>
</html>