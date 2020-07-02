function sendData() {
	if (document.writeForm.subject.value == "") {
		alert("제목은 필수 입니다.");
		document.writeForm.subject.focus();
		return false;
	}
	if (document.writeForm.content.value == "") {
		alert("내용은 필수 입니다.");
		document.writeForm.content.focus();
		return false;
	}
	if (document.writeForm.writer.value == "") {
		alert("작성자는 필수 입니다.");
		document.writeForm.writer.focus();
		return false;
	}
	if (document.writeForm.passwd.value == "") {
		alert("비밀번호는 필수 입니다.");
		document.writeForm.passwd.focus();
		return false;
	}
}

function pwCheck(s) {
	window.name = "parentForm";
	if (s == 'u') {
		document.parentForm.action = 'updateForm.sp';
	} else if (s == 'd') {
		document.parentForm.action = 'deletePro.sp';
	}
	openWin = window.open("idCheck.sp", "idCheck", "left=800, top=300, width=500, height=200,toolbar=no, menubar=no, resizable=no, scrollbars=no");

}

function setParentText(object) {
	opener.document.parentForm.cpass.value = document.getElementById("pwCheck").value;
	window.close();
	compare();
}
function compare() {
	var pw = opener.document.parentForm.passwd.value;
	var cpw = opener.document.parentForm.cpass.value;
	if (pw == cpw) {
		opener.document.parentForm.submit();
		idCheck.window.close();
	} else {
		alert("비밀번호오류");
		idCheck.window.close();
	}

}
