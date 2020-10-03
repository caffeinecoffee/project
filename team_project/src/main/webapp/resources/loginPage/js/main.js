
(function ($) {
    "use strict";

    /*==================================================================
    [ Validate ]*/
    let input = $('.validate-input .input100');

    $('.validate-form').on('submit',function(){
//    	alert(input);
        let check = true;

        for(let i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }
        }
        if(check){
        	let mem_id = $("#mem_id").val();
        	let mem_password = $("#mem_password").val();
//        	alert("아이디 : "+mem_id+" 비밀번호 : "+mem_password);
        	
        	$.ajax({
        		type : "POST",
        		url : "loginProc",
        		data : {mem_id : mem_id, mem_password : mem_password},
        		success: function(data){
        			if(data ==""){
        				$("#errorMsg").html("아이디 또는 비밀번호가 다릅니다");
        			}else{
        				location.href="index";
        			}
        		}
        	});
        }
        return false;
    });


    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
           hideValidate(this);
        });
    });

    function validate (input) {
        if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
                return false;
            }
        }
        else {
            if($(input).val().trim() == ''){
                return false;
            }
        }
    }

    function showValidate(input) {
        let thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        let thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }
    
    

})(jQuery);