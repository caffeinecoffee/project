<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>회원 가입</title>
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
				<th>이름</th>
				<td><input type="text" placeholder="이름을 입력하세요" class="chk" name="memName" title="이름"></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type="text" placeholder="아이디를 입력하시오." name="memId" id ="idchk" title="아이디" value="" class="chk"/>
					<font id="warning" size="2" color="red" >??</font>
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
				<th>이메일</th>
				<td><input type='text' placeholder="이메일을 입력하세요" class="chk" name="memEmail" title="이메일"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" placeholder="전화번호를 입력하세요" class="chk" name="memTel" title="전화번호"></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="date" placeholder="생년월일을 입력하세요" class="chk" name="memBirth" title="생년월일"></td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
				<input type="radio" class="chk" name="memGender" title="성별" value="M">남자
				<input type="radio" class="chk" name="memGender" title="성별" value="F">여자
				</td>
			</tr>

			<tr height="2" bgcolor="#FFC8C3">
				<td colspan="2"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" id="submit1" value="회원가입">
					<input type="reset" value="취소">
				</td>
			</tr>
			<a href="memberList.sa"><input type="button" value="?????"></a>
		</table>
	</form>
</body>
</html>