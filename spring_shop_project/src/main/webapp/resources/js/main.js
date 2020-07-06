$(function() {

	var wformObj = $("form[name='register']");

	$('#register_submit').click(function() {
		if (fn_valiChk()) {
			return false;
		}
		wformObj.attr("action", "signPro");
		wformObj.attr("method", "post");
		wformObj.submit();
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
	$("#id").on("change", function() {
		$.ajax({
			async : true,
			type : 'post',
			url : "idcheck",
			data : {
				"memId" : $("#id").val()
			},
			dataType : "json",
			success : function(data) {
				if (data > 0) {
					$('font[id=warning]').text('');
					$('font[id=warning]').attr('color', 'red');
					$('font[id=warning]').text('이미 존재하는 아이디 입니다.');
					$("#memId").focus();
				} else {
					$('font[id=warning]').text('');
					$('font[id=warning]').attr('color', 'blue');
					$('font[id=warning]').text('사용가능한 아이디입니다.');
					$("#memId").focus();
					idck = 1; // idck 1이 아니면 submit못하게 하려고
				}
			},
			error : function(error) {
				alert("error : ");
			}
		});
	});
});

function callMember(memSeq) {
	document.memberInformation.memSeq.value = memSeq;
	document.memberInformation.submit();
};

function fn_valiChk() {
	var regForm = $("form[name='register'] .chk").length;
	for (var i = 0; i < regForm; i++) {
		if ($(".chk").eq(i).val() == "" || $(".chk").eq(i).val() == null) {
			alert($(".chk").eq(i).attr("title") + "은/는 필수입력입니다.");
			$(".chk").eq(i).focus();
			return true;
		}
	}
}
