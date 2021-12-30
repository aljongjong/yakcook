let name = document.getElementById('userName');
let id = document.getElementById('userId');
let email = document.getElementById('userEmail');

function Check(){
		if(name.value === ""){
			alert("이름을 입력하세요");
			name.focus();
			return false;
		}
		// 이메일 입력하세요
		if(email.value === ""){
			alert("이메일을 입력하세요");
			email.focus();
			return false;
		}
}

