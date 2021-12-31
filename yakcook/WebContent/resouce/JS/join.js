//전역 변수 선언하기
let idBox = document.getElementById('idBox');
let idMsg = document.getElementById('idMsg');
let idspan = document.getElementById('idspan');
let password = document.getElementById('password');					//비밀번호 
let passwordConfirm = document.getElementById('passwordConfirm');	//비밀번호 확인 값 
let pwdMsg = document.getElementById('pwdMsg');				//확인 메세지
let pwdspan = document.getElementById('pwdspan');
let userName = document.getElementById('userName'); //이름 값
let nameMsg = document.getElementById('nameMsg');
let email = document.getElementById('email') // 이메일
let passwordCheckNum = 0; // 비밀번호 일치할 때 넘어가도록 관리하는 변수
let emailCheckNum = 0; // 이메일 인증 성공시 넘어가도록 관리하는 변수
let nameCheckNum = 0; // 이름 정규식 만족하면 넘어가도록 관리하는 변수
let correctColor = "#00ff00";	//맞았을 때 출력되는 색깔.
let wrongColor ="#ff0000";	//틀렸을 때 출력되는 색깔
let userIdCheck = false;

//아이디 중복 체크 + 정규식 처리 동시에!
$('#idBox').keyup(function(){
	let replaceId = /^[A-Za-z]{1}[A-Za-z0-9_-]{3,19}$/ // 반드시 영문으로 시작 숫자+언더바/하이픈 허용 4~20자리
	if(replaceId.test(idBox.value) && idBox.value.length > 3){
		$('#idspan').text(' ');
		$.ajax({
			url :'/yakcook/memberDupCheck',
			type : 'get', 
			data : {
				id : $('#idBox').val()
			},
			success : function(data){
				$("#idspan").text(data);
				$("#idBox").focus();
				console.log(userIdCheck);
			},
			error : function(err){
				alert('error');
			}
		});
	}else{
		idspan.innerHTML = "반드시 영문으로 시작 숫자+언더바/하이픈 허용 4~20자리";
	}
});
console.log(userIdCheck);
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
				pwdMsg.style.color = correctColor;/* span 태그의 ID(confirmMsg) 사용  */
				pwdMsg.innerHTML ="비밀번호 일치";/* innerHTML : HTML 내부에 추가적인 내용을 넣을 때 사용하는 것. */
				passwordCheckNum = 1;
			}else{
				pwdMsg.style.color = wrongColor;
				pwdMsg.innerHTML ="비밀번호 불일치";
		}
	}
}

//이름 정규식 확인용 변수(정규식을 만족하면 1을 반환해준다.)
let replaceName = /^[가-힣a-zA-Z\s]+$/;

$('#userName').on('keyup', function(){
	let x = $(this).val();
	if(x.length>1){
		nameMsg.innerHTML ="글자수가 안 모자람";
		nameCheckNum = 1;
		if(!x.match(replaceName)){
			nameMsg.innerHTML = "이름은 한글, 영문만 입력 가능합니다.";
			nameCheckNum = 0;
		}
	}else{
		nameMsg.innerHTML ="글자수가 모자람";
		nameCheckNum = 0;
	}
});

// 이메일 인증
function emailcheck(email){
	//유효성 검사
	if(!insertform.email.value){
		alert("emailerror");
		insertform.email.focus();
		return;
	}else{
		if(insertform.email.value.indexOf("@") == -1){
			alert("@를 포함해서 적어주세요")
			insertform.email.focus();
			return false;
		}
	}
	// 인증을 위해 새창으로 이동
	let url = "emailcheck?email="+email;
	open(url,"emailwindow", "statusbar=no, scrollbar=no, menubar=no, width=400, height=200" );
}

function confirmemail(emailconfirm_value, authNum){
    // 입력한 값이 없거나, 인증코드가 일지하지 않을 경우
	if(!emailconfirm_value || emailconfirm_value != authNum){
		alert("인증실패");//원하는 메세지로 변경
		emailconfirm_value="";
		self.close();
    // 인증코드가 일치하는 경우
	}else if(emailconfirm_value==authNum){
		emailCheckNum = 1;
		alert("인증성공");
		emailconfirm_value="";
		self.close();
		opener.document.insertform.emailconfirm_value.value=1;		
	}
}

//sumbit버튼 눌렀을 때 일어나는 함수
function Check(){
	// 중복된 아이디면 넘어가지 않도록 
	if(userIdCheck != true){
		alert("중복된 아이디 입니다.");
	  document.getElementById('idBox').focus();
	  return false;
	}
	
	// 비밀번호 정규식 만족하지 않았을 경우 넘어가지 않도록
/*	if(passwordCheckNum === 0){
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
		
	// 이름 정규식 만족하지 않았을 경우 넘어가지 않게
	if(nameCheckNum === 0){
		alert("이름이 맞지 않습니다.");
	  	document.getElementById('userName').focus();
	 	return false;
	}*/
	
	//이메일 인증성공하지 못하면 넘어가지 않도록
/* 	if(emailCheckNum === 0){
		alert("이메일 인증을 다시 진행해주세요");
	  	document.getElementById('userName').focus();
	 	return false;
	} */
}

//필수입력항목 체크!
password.addEventListener('click', () => {
if(password.value === ""){
	pwdspan.innerText = '필수입력항목';
		password.focus();
}else{
		//pwdspan.innerText = '영문자, 숫자, 특수문자 포함하여 총 8~15자로 입력하시오.';
}
});

passwordConfirm.addEventListener('click', () => {
if(passwordConfirm.value === ""){
	pwdMsg.innerText = '필수입력항목';
	passwordConfirm.focus();
}
}); 

userName.addEventListener('click', () => {
if(userName.value === ""){
	nameMsg.innerText = '필수입력항목';
	userName.focus();
}
});

//체크 박스 체크 함수!
//체크박스 전체 선택
$(".checkbox_group").on("click", "#check_all", function () {
$(this).parents(".checkbox_group").find('input').prop("checked", $(this).is(":checked"));
});

let ch_box1 = false;
let ch_box2 = false;

//체크박스 개별 선택
$(".checkbox_group").on("click", ".normal", function() {
var is_checked = true;
$(".checkbox_group .normal").each(function(){
   is_checked = is_checked && $(this).is(":checked");
});

$("#check_all").prop("checked", is_checked);
});
