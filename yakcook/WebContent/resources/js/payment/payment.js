
// 배송메모 직접입력 선택할 시 
$(function() {
	$("#input_memo").hide();

	$("#memo_option").change(function() {
		if ($("#memo_option").val() == "postmemo6") {
			$("#input_memo").show();
		} else {
			$("#input_memo").hide();
		}
	})
});

 $(function(){
            $('#agreement_show').click(function(){
                if($('#agreement_contents').css("display")=="none"){
                    $('#agreement_contents').show();
                }
            });
        });
        
        $("#payment_btn").click(function(){
            
            // 첫번째 체크박스가 체크되어 있는경우
            if($("#checkbox").is(":checked")){
                
            } else { // 첫번째 체크박스가 체크 되어있지 않은 있는경우
                alert("개인 정보 제공에 동의하여 주세요.")
                return false;
            }


        });


