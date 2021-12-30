let email = document.getElementById('userEmail');
let emailMsg = document.getElementById('emailMsg');
let emailChNum = 0;

// 이메일 인증
function emailcheck(email){
	//유효성 검사
	if(!findPwdform.email.value){
		alert("emailerror");
		findPwdform.email.focus();
		return;
	}else{
		if(findPwdform.email.value.indexOf("@") == -1){
			alert("@를 포함해서 적어주세요")
			findPwdform.email.focus();
			return false;
		}
	}
	// 인증을 위해 새창으로 이동
	let url = "emailcheck?email="+email;
	open(url,"emailwindow", "statusbar=no, scrollbar=no, menubar=no, width=400, height=200" );
}

function confirmemail(emailconfirm_value, authNum, emailNum){
    // 입력한 값이 없거나, 인증코드가 일지하지 않을 경우
	if(!emailconfirm_value || emailconfirm_value != authNum){
		alert("인증실패");//원하는 메세지로 변경
		emailconfirm_value="";
		self.close();
		mailCheckNum = 0;
		emailNum = 0;
    // 인증코드가 일치하는 경우
	}else if(emailconfirm_value==authNum){
		emailMsg.innerHTML = "인증성공";
		alert("인증성공");
		emailconfirm_value="";
		self.close();
		opener.document.findPwdform.emailconfirm_value.value=1;
		emailNum = 1;
	}
}


let name = document.getElementById('userName');
let id = document.getElementById('userId');

function Check(){
		if(name.value === ""){
			alert("이름을 입력하세요");
			name.focus();
			return false;
		}
		if(id.value === ""){
			alert("아이디를 입력하세요");
			id.focus();
			return false;
		}
		// 이메일 입력하세요
		if(email.value === ""){
			alert("이메일을 입력하세요");
			email.focus();
			return false;
		}
		//이메일 인증 성공하면 넘어가도록
		if(emailNum === 0){
			alert("이메일 인증 실패");
			email.focus();
			return false;
		}
}


