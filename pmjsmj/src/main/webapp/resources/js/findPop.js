	function find_check(num) {
		if (num == '1') {
			document.getElementById("findPop PWfind").style.display = "none";
			document.getElementById("findPop IDfind").style.display = "";
			var mb_ID = $("#mbID").val();
			var mbPWPhone1 = $("#mbPWPhone1").val();
			var mbPWPhone2 = $("#mbPWPhone2").val();
			var mbPWPhone3 = $("#mbPWPhone3").val();
		}
		if (num == '2') {
			document.getElementById("findPop IDfind").style.display = "none";
			document.getElementById("findPop PWfind").style.display = "";
			$("#mbName").val("");
			$("#mbIDPhone1").val("");
			$("#mbIDPhone2").val("");
			$("#mbIDPhone3").val("");
		}
	}

	function find_PWcheck() {
		document.getElementById("findPop find form").style.display = "";
		document.getElementById("findPop IDfind").style.display = "none";
		document.getElementById("findPop PWfind").style.display = "";
		document.getElementById("findPop IDok").style.display = "none";
		$("#radioFindPW").attr("checked", true);
		$("#mbName").val("");
		$("#mbIDPhone1").val("");
		$("#mbIDPhone2").val("");
		$("#mbIDPhone3").val("");

	}
	function CloseWindow(url, intWidth, intHeight) {
		window.close('/login/findPop', 'popup',
				'width=600,height=400,left=0,top=0');
	}
	function ID_check() {
		var mb_Name = $("#mbName").val();
		var email = $("#email").val();

		//alert(mb_Phone);

		$.get("/id_check", {
			mem_name : mb_Name,
			mem_email : email

		},

		function(result) {

			if (result == "") {
				$(".idCheckMsg").css("color", "red");
				$(".idCheckMsg").text("이름 또는 이메일을 입력해주세요.");
			} else if (result == "실패") {
				$(".idCheckMsg").css("color", "red");
				$(".idCheckMsg").text("이름 또는 이메일이 존재하지 않습니다.");
			} else {
				$(".idCheckMsg").css("color", "green");
				$(".idCheckMsg").text("이메일로 아이디를 전송하였습니다.");
			}
		});

	}
	function PW_check() {
		var mb_ID = $("#mbID").val();
		var mem_email = $("#mem_email").val();
		//alert(mb_Phone);

	$.get("/pw_check",
				{
					mem_id : mb_ID,
					mem_email : mem_email
				},
					function(result) {
						if (result == "") {
							$(".pwCheckMsg").css("color","red");
							$(".pwCheckMsg").text("아이디 또는 이메일을 입력해주세요");
						} else if (result == "성공") {
							$(".verification_code_th").css("display","block");
							$(".verification_code_formbox").css("display","block");
							$(".pwCheckMsg").css("color","green");
							$(".pwCheckMsg").text("이메일로 인증번호를 전송하였습니다.");
						} else{
							$(".pwCheckMsg").css("color","red");
							$(".pwCheckMsg").text("아이디 또는 이메일이 존재하지 않습니다");
						}
					});

	}
$(function(){
	$("#certification_number_btn").click(function(){
		var code = $("#verification_code").val();
		$.ajax({
			async : true,
			type : 'post',
			url : "pwCodeCheck",
			data : {
				code :code 
			},
			success : function(data) {
				if(data == "실패"){
					$(".pwCheckMsg").css("color","red");
					$(".pwCheckMsg").text("인증번호가 일치하지 않습니다.");
				}else{
					$(".pwCheckMsg").css("color","red");
					$(".pwCheckMsg").text("비밀번호가 "+data+"로 변경 되었습니다");
				}
			}
		});
	});
});