<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>ȸ�� ����</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery_member.js"></script>
<link href="/resources/css/board.css" rel="stylesheet">
</head>
<body>
	<form action="" name="SignPro" method="post">
		<table width="940" style="padding: 5px 0 5px 0;">
			<tr height="2" bgcolor="#FFC8C3">
				<td colspan="2"></td>
			</tr>
			<tr>
				<th>�̸�</th>
				<td><input type="text" placeholder="�̸��� �Է��ϼ���" class="chk" name="memName" title="�̸�"></td>
			</tr>
			<tr>
				<th>���̵�</th>
				<td><input type="text" placeholder="���̵� �Է��Ͻÿ�." name="memId" id ="idchk" title="���̵�" value="" class="chk"/>
					<font id="warning" size="2" color="red" >??</font>
					</td>
			</tr>
			<tr>
				<th>��й�ȣ</th>
				<td><input type="password" placeholder="��й�ȣ�� �Է��ϼ���" class="chk" id="passwd1" name="memPasswd" title="��й�ȣ"></td>
			</tr>
			<tr>
				<th>��й�ȣ Ȯ��</th>
				<td>
					<input type="password" id="passwd2" placeholder="��й�ȣ Ȯ��" name="passwdchk">
					<font name="check" color="red"></font>
				</td>
			</tr>
			<tr>
				<th>�̸���</th>
				<td><input type='text' placeholder="�̸����� �Է��ϼ���" class="chk" name="memEmail" title="�̸���"></td>
			</tr>
			<tr>
				<th>��ȭ��ȣ</th>
				<td><input type="text" placeholder="��ȭ��ȣ�� �Է��ϼ���" class="chk" name="memTel" title="��ȭ��ȣ"></td>
			</tr>
			<tr>
				<th>�������</th>
				<td><input type="date" placeholder="��������� �Է��ϼ���" class="chk" name="memBirth" title="�������"></td>
			</tr>
			<tr>
				<th>����</th>
				<td>
				<input type="radio" class="chk" name="memGender" title="����" value="M">����
				<input type="radio" class="chk" name="memGender" title="����" value="F">����
				</td>
			</tr>

			<tr height="2" bgcolor="#FFC8C3">
				<td colspan="2"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" id="submit1" value="ȸ������">
					<input type="reset" value="���">
				</td>
			</tr>
			<a href="memberList.sa"><input type="button" value="?????"></a>
		</table>
	</form>
</body>
</html>