$(function() {
	var idck = true;

	$('#register_submit').click(function() {
		var regForm = $("form[name='register'] .chk").length;
		for (var i = 0; i < regForm; i++) {
			if ($(".chk").eq(i).val() == "" || $(".chk").eq(i).val() == null) {
				alert($(".chk").eq(i).attr("title") + "은/는 필수입력입니다.");
				$(".chk").eq(i).focus();
				return false;
			}
		}
		if (!idck) {
			alert("아이디 중복");
			$("#warning").focus();
			return false;
		}
		$("form[name='register']").submit();
	});

	$('#register_withdrawal_submit').click(function() {
		$("form[name='register']").attr("action", "registerWithdrawal");
		$("form[name='register']").attr("method", "post");
		$("form[name='register']").submit();
	});

	$('#passwd2').keyup(function() {
		$('font[name=check]').text('');
		if ($('#passwd1').val() != $('#passwd2').val()) {
			$('font[name=check]').text('');
			$('font[name=check]').attr('color', 'red');
			$('font[name=check]').text("비밀번호 다름");
		} else {
			$('font[name=check]').text('');
			$('font[name=check]').attr('color', 'blue');
			$('font[name=check]').text("비밀번호 같음");
		}
	});
	$('#passwd1').keyup(function() {
		$('font[name=check]').text('');
		if ($('#passwd1').val() != $('#passwd2').val()) {
			$('font[name=check]').text('');
			$('font[name=check]').text("비밀번호 다름");
		} else {
			$('font[name=check]').text('');
			$('font[name=check]').attr('color', 'blue');
			$('font[name=check]').text("비밀번호 같음");
		}
	});

	// ajax를 이용한 아이디 중복 확인
	// propertychange change input paste
	$("#re_id").on("change", function() {
		$.ajax({
			async : true,
			type : 'post',
			url : "idcheck",
			data : {
				"mem_id" : $("#re_id").val()
			},
			dataType : "json",
			success : function(data) {
				if (data > 0) {
					$('font[id=warning]').text('');
					$('font[id=warning]').attr('color', 'red');
					$('font[id=warning]').text('이미 존재하는 아이디 입니다.');
					$("#mem_id").focus();
					idck = false;
				} else {
					$('font[id=warning]').text('');
					$('font[id=warning]').attr('color', 'blue');
					$('font[id=warning]').text('사용가능한 아이디입니다.');
					$("#mem_id").focus();
					idck = true; // idck 1이 아니면 submit못하게 하려고
				}
			},
			error : function(error) {
				alert("error : ");
			}
		});
	});

	$('#login_submit').click(function() {
		if ($("#log_id").val() == "" || $("#log_id").val() == null) {
			alert($("#log_id").attr("title") + "은/는 필수입력입니다.");
			$("#log_id").focus();
			return false;
		}
		if ($("#log_passwd").val() == "" || $("#log_passwd").val() == null) {
			alert($("#log_passwd").attr("title") + "은/는 필수입력입니다.");
			$("#log_passwd").focus();
			return false;
		}
	});
});

function Update(number) {
	$("#mem_id").val(number);
	$("form[name='AdminMemberUpdate']").submit();
};

function productDetail(no){
	$("#no").val(no);
	$("form[name='product']").attr("action", "/productInsert");
	$("form[name='product']").attr("method", "post");
	$("form[name='product']").submit();
}

function productBasket(no){
	$("#mem_id").val(no);
$("form[name='AdminMemberUpdate']").submit();
}

function callMember(memSeq) {
	document.memberInformation.memSeq.value = memSeq;
	document.memberInformation.submit();
};
