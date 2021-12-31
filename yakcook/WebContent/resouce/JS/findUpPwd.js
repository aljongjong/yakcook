let pwdMsg = document.getElementById('pwdMsg');	//확인 메세지
let pwdspan = document.getElementById('pwdspan');
let passwordCheckNum = 0; 	
//비밀번호 정규식
//비밀번호 일치 불일치
function passConfirm() {
	if(!(/^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/.test(password.value))){
		pwdspan.innerHTML ="!!!!영문자, 숫자, 특수문자 포함하여 총 8~15자로 입력하시오!!!!.";
		console.log("실패")
	}else{
		pwdspan.innerHTML ="성공";
		console.log("성공")
		/* 비밀번호, 비밀번호 확인 입력창에 입력된 값을 비교해서 같다면 비밀번호 일치, 그렇지 않으면 불일치 라는 텍스트 출력.*/
			if(password.value == passwordConfirm.value){//password 변수의 값과 passwordConfirm 변수의 값과 동일하다.
				/*pwdMsg.style.color = correctColor;*//* span 태그의 ID(confirmMsg) 사용  */
				pwdMsg.innerHTML ="비밀번호 일치";/* innerHTML : HTML 내부에 추가적인 내용을 넣을 때 사용하는 것. */
				passwordCheckNum = 1;
			}else{
				/*pwdMsg.style.color = wrongColor;*/
				pwdMsg.innerHTML ="비밀번호 불일치";
		}
	}
}

function Check(){
	if(passwordCheckNum === 0){
		console.log(passwordCheckNum)
		alert("비밀번호 정규식을 만족하지 않습니다.");
	  	document.getElementById('password').focus();
		return false;
	}
	
	// 비밀번호가 동일하지 않을 경우 넘어가지 않도록
	if(password.value !== passwordConfirm.value) {
		   alert("동일한 비밀번호 값을 입력하세요.")
		   document.getElementById('passwordConfirm').value = '';
		   document.getElementById('passwordConfirm').focus();
		   return false;
		}
}