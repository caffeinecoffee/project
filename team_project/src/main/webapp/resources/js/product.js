

//새로운 배송지를 클릭했을때 정보 지워지는 기능
$(function(){
	$("#new-address").click(function(){
		$("#order_zipcode").val("");
		$("#order_to_address").val("");
		$("#order_address_detail").val("");
		$(".order_to_name").val("");
		$(".order_to_phone").val("");
	});
	
	$(".pay-card").click(function(){
		$(".depositor_name").css("display","none");
		$(".pay_bank_depositor").val("");
		$(".pay_bank_info").val("none").attr("selected","selected");
		$(".shopBank").css("display","none");
		$(".cardNum").css("display","block");
		$(".cardChoice").css("display","block");
	});
	
	$(".pay-bank").click(function(){
		$(".pay_credit_num").val("");
		$(".pay_credit_name").val("none").attr("selected","selected");
		$(".depositor_name").css("display","block");
		$(".shopBank").css("display","block");
		$(".cardNum").css("display", "none");
		$(".cardChoice").css("display","none");
	});
	$(".order-btn").click(function(){
		var order_pay_option = $('input[id="order_pay_option"]:checked').val();
		var pay_bank_info = $('select[id="pay_bank_info"]').val();
		var pay_credit_name =$('select[id="pay_credit_name"]').val();
		if($(".order_zipcode").val() == ""){
			$(".order_zipcode_msg").text("*우편번호를 선택해주세요");
			$(".order_zipcode").focus();
		}else if($(".order_address_detail").val() == ""){
			$(".order_address_detail_msg").text("*상세주소를 입력해주세요");
			$(".order_address_detail").focus();
		}else if($(".order_to_name").val()==""){
			$(".order_to_name_msg").text("*받는사람을 입력해주세요");
			$(".order_to_name").focus();
		}else if($(".order_to_phone").val()==""){
			$(".order_to_phone_msg").text("*받는사람 연락처를 입력해주세요");
			$(".order_to_phone").focus();
		}else if($(".order_request").val()==""){
			$(".order_request_msg").text("*요청사항을 입력해주세요");
			$(".order_request").focus();
		}else if(order_pay_option == "무통장입금"){
			$(".pay_card").attr("name","");
			if($(".pay_bank_depositor").val() == ""){
				$(".pay_bank_depositor_msg").text("*입금자명을 입력해주세요");
			}else if(pay_bank_info == "none"){
				$(".pay_bank_info_msg").text("*가상계좌를 선택해주세요");
			}else{
				$("#orderCompleteProcForm").submit();
			}
		}else if(order_pay_option == "신용카드"){
			$(".pay_bank").attr("name","");
			if($(".pay_credit_num").val()==""){
				$(".pay_credit_num_msg").text("*카드번호를 입력해주세요");
			}else if(pay_credit_name == "none"){
				$(".pay_credit_name_msg").text("*카드사를 선택해주세요");
			}else{
				$("#orderCompleteProcForm").submit();
			}
		}
		
	});
	
	$(".order_address_detail").keyup(function(){
		$(".order_address_detail_msg").text("");
	});
	$(".order_to_name").keyup(function(){
		$(".order_to_name_msg").text("");
	});
	$(".order_to_phone").keyup(function(){
		$(".order_to_phone_msg").text("");
	});
	$(".order_request").keyup(function(){
		$(".order_request_msg").text("");
	});
	$(".pay_bank_depositor").keyup(function(){
		$(".pay_bank_depositor_msg").text("");
	});
	$(".pay_bank_info").change(function(){
		$(".pay_bank_info_msg").text("");
	});
	$(".pay_credit_num").keyup(function(){
		$(".pay_credit_num_msg").text("");
	});
	$(".pay_credit_name").change(function(){
		$(".pay_credit_name_msg").text("");
	});
	
	$(".refund-btn").click(function(){
		if($(".cancel_reason").val() == ""){
			$(".cancel_reason_msg").text("* 취소사유를 적어주세요");
			$(".cancel_reason").focus();
			return false;
		}else if($(".detail_reason").val() == ""){
			$(".detail_reason_msg").text("* 상세내용을 적어주세요");
			$(".detail_reason").focus();
			return false;
		}		
	});
	$(".cancel_reason").keyup(function(){
		$(".cancel_reason_msg").text("");
	});
	$(".detail_reason").keyup(function(){
		$(".detail_reason_msg").text("");
	});
});

function plus(i,item_no,first,discount,sum) {
//	 alert("i : "+i);
//	 alert("item_no :" + item_no);
//	 alert("first : "+first);
//	 alert("discount : "+discount);
	 var val = Number($(".numBox" + i).val());
	   $(".numBox" + i).val(val + 1);
	   var plusVal = Number($(".numBox" + i).val());
	   
	   var sumPriceCal = Number((first-(first - discount)) * plusVal);
	   var money = Number(first-(first - discount));
	   $(".sumPrice" + i).text(sumPriceCal.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
	   
	   
	var cart_cnt = $(".numBox"+i).val();
	$.ajax({
		type : "POST",
		url : "/itemCount",
		data : {cart_cnt : cart_cnt, item_no: item_no, money : money, stat : "plus"},
		success: function(data){
			$(".sum").text(data.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
			$(".allSum").text((data+2500).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
		}
	});
		
	}
function minus(i,item_no,first,discount,sum) {
	var val = Number($(".numBox" + i).val());
	if (val <= 1) {
		$(".numBox" + i).val(1);
	} else {
		$(".numBox" + i).val(val - 1);
		var plusVal = Number($(".numBox" + i).val());
		   
		var sumPriceCal = Number((first-(first - discount)) * plusVal);
		var money = Number(first-(first - discount));
		$(".sumPrice" + i).text(sumPriceCal.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
		   
		var cart_cnt = $(".numBox"+i).val();	
		$.ajax({
			type : "POST",
			url  : "itemCount",
			data : {cart_cnt : cart_cnt, item_no: item_no, money : money,stat : "minus"},
			success: function(data){
				$(".sum").text(data.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
				$(".allSum").text((data+2500).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
			}
		});
		
	}
}

//다음 API 주소
function zipCheck() {
    new daum.Postcode(
            {
                oncomplete : function(data) {
                    // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
                    // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                    // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                    var fullAddr = ''; // 최종 주소 변수
                    var extraAddr = ''; // 조합형 주소 변수

                    // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                    if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                        fullAddr = data.roadAddress;

                    } else { // 사용자가 지번 주소를 선택했을 경우(J)
                        fullAddr = data.jibunAddress;
                    }

                    // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                    if (data.userSelectedType === 'R') {
                        //법정동명이 있을 경우 추가한다.
                        if (data.bname !== '') {
                            extraAddr += data.bname;
                        }
                        // 건물명이 있을 경우 추가한다.
                        if (data.buildingName !== '') {
                            extraAddr += (extraAddr !== '' ? ', '
                                    + data.buildingName : data.buildingName);
                        }
                        // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                        fullAddr += (extraAddr !== '' ? ' (' + extraAddr
                                + ')' : '');
                    }
                    // 우편번호와 주소 정보를 해당 필드에 넣는다.
                    document.getElementById('order_zipcode').value = data.zonecode; //5자리 새우편번호 사용
                    document.getElementById('order_to_address').value = fullAddr;
                    // 커서를 상세주소 필드로 이동한다.
                    document.getElementById('order_address_detail').focus();
                    document.getElementById('order_zipcode_msg').innerHTML='';
//                    document.getElementsByClassName('order_zipcode_msg').innerHTML ='asd';
                    
                }
            }).open();
}