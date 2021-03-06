$(function() {
	let idForm = false;
	let passwdForm = false;
	let idButton = false;
	let passwdButton = false;
	let emailCheck = false;
	$('#signUpSubmit').click(function() {
		if ($('.value_check').val() == null || $('.value_check').val() == "") {
			alert('*  는 필수 입력란 입니다.');
			return false;
		}

		if (!idButton) {
			alert('ID 체크를 해주세요.');
			return false;
		}

		if (!idForm) {
			alert('입력하신 ID를 사용할 수 없습니다.');
			return false;
		}

		$.ajax({
			async : true,
			type : 'post',
			url : "IDDuplicateCheck",
			data : {
				"mem_id" : $("#id").val()
			},
			dataType : "json",
			success : function(data) {
				if (data > 0) {
					alert('이미 사용 중인 ID입니다.');
					idForm = false;
					return false;
				} else {
					idForm = true;
				}
			}
		});

		if (!passwdButton) {
			alert('비밀번호 체크를 해주세요.');
			return false;
		}

		if (!passwdForm) {
			alert('입력하신 비밀번호를 사용할 수 없습니다.');
			return false;
		}

		if (!$('input[class=Terms_of_Use]').prop('checked')) {
			alert('이용 약관 동의를 확인해주세요');
			return false;
		}

	});

	$("#passwdCheck").click(function() {
		passwdButton = true;
		let passwd = $('#passwd1').val();
		let check = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,20}$/;
	
		if (!check.test(passwd)) {
			alert("비밀번호 형식에 맞지 않습니다. \n8자리 ~ 20자리 이내이며 \n하나의 문자 및 하나의 숫자를 입력해주세요. \n특수문자 입력 불가");
			passwdForm = false;
			return false;
		}
	
		if ($('#passwd1').val() != $('#passwd2').val()) {
			alert("비밀번호 확인이 틀립니다.");
			passwdForm = false;
		} else {
			alert("사용 가능한 비밀번호 입니다.");
			passwdForm = true;
		}
		return false;
	});

	$("#IDDuplicateCheck").click(function() {
		idButton = true;
		let id = $('#id').val();
		let pattern1 = /(^[a-zA-Z])/;
		let pattern2 = /([^a-zA-Z0-9-_])/;

		if (!pattern1.test(id)) {
			alert("아이디의 첫글자는 영문이어야 합니다.\n아이디는 영문, 숫자, -, _ 만 사용할 수 있습니다.");
			idForm = false;
			return false;
		} else if (pattern2.test(id)) {
			alert("아이디는 영문, 숫자, -, _ 만 사용할 수 있습니다.");
			idForm = false;
			return false;
		}

		$.ajax({
			async : true,
			type : 'post',
			url : "IDDuplicateCheck",
			data : {
				"mem_id" : $("#id").val()
			},
			dataType : "json",
			success : function(data) {
				if (data > 0) {
					alert('이미 사용 중인 ID입니다.');
					idForm = false;
				} else {
					alert('사용 가능한 ID입니다.');
					idForm = true;
				}
			}
		});
	});

	$("#emailCheck").click(function() {
		let email = $("#mem_email").val();
		let reg_email = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
	if ($("#mem_email").val() == '') {
		$("#emailMsg").text("이메일을 입력해주세요.");
	} else if (!reg_email.test(email)) {
			alert("이메일 형식에 맞지 않습니다.");
			return false;
	} else {
		$.ajax({
			type : "POST",
			url : "emailCheck",
				data : {email : email},
				success : function(data) {
	    			if(data =="성공"){
	    				alert(data);
	    				window.open("signUpEmailCheck", "PopupWin", "width=550,height=170");
	    			}else{
	    				$(".message").html("비밀번호가 다릅니다.");
	    			}
				}
			});
	}
	return false;
});

	$("#id").keyup(function() {
		idButton = false;
	});

	$('input[class=birth]').keyup(function() {
		let inputText = $(this).val();
		let number = $(this).val().replace(/[^0-9]/g, '');
		$(this).val(number);
	});

	$('input[class=checkbox_all]').click(function() {
		let chk = $('input[class=checkbox_all]').prop('checked');
		$('input[type=checkbox]').prop('checked', chk);
	});
});

function checkbox(str) {
	if ($('div[id=' + str + ']').css('display') == 'block') {
		$('div[id=' + str + ']').css('display', 'none');
	} else {
		$('div[id=' + str + ']').css('display', 'block');
	}
}