<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="/../resources/js/main.js"></script>
</head>
<body>
<!-- <c:import url="Top.jsp"/> -->
	<form action="/admin/loginpro" name="admin_login" method="post">
		<table>
			<tr>
				<th colspan="2">�α���</th>
				<!-- ù��° �� ���� -->
			</tr>
			<tr>
				<td>���̵�</td>
				<td><input type="text" placeholder="���̵� �Է��Ͻÿ�." name="admin_id" id="log_id" title="���̵�" value="" class="chk" />
				<font id="warning" size="2" color="red" ></font></td>
			</tr>
			<tr>
				<td>�н�����</td>
				<td><input type="password" placeholder="�н����带 �Է��Ͻÿ�." name="admin_passwd" id="log_passwd" title="�н�����" value="" class="chk" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" id="admin_login_submit" value="login" class="" />
					<input type="reset" value="reset" class="" />
				</td>
			</tr>
			<tr>
<!-- 				<td colspan="2"><c:import url="Bottom.jsp" /></td> -->
			</tr>
		</table>
	</form>
</body>
</html>