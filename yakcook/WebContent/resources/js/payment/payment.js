
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

//체크박스 유무에 따라 메모 보여주기

$('input[type=radio][name=method_pay]').on('click', function() {
	var chkValue = $('input[type=radio][name=method_pay]:checked').val();

	if (chkValue == '무통장') {
		$('#no_bankbook').css('display', 'block');
		$('#Refuncd_Acc').css('display', 'none');
	} else if (chkValue == '카드') {
		$('#no_bankbook').css('display', 'none');
		$('#Refuncd_Acc').css('display', 'none');
	} else if (chkValue == '가상계좌') {
		$('#no_bankbook').css('display', 'none');
		$('#Refuncd_Acc').css('display', 'block');
	} else if (chkValue == '계좌이체') {
		$('#no_bankbook').css('display', 'none');
		$('#Refuncd_Acc').css('display', 'none');
	}
});


$("#submit").click(function() {

	// 첫번째 체크박스가 체크되어 있는경우
	if ($("#agreement_check").is(":checked")) {

	} else { // 첫번째 체크박스가 체크 되어있지 않은 있는경우
		alert("개인 정보 제공에 동의하여 주세요.")
		return false;
	}


});

console.log(document.getElementsByName("method_pay"));
