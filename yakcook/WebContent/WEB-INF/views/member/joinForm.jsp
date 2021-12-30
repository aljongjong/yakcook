<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src = "https://developers.kakao.com/sdk/js/kakao.js"></script>
	<script>
	window.Kakao.init("eec04ecb595db3100a401b9e63601a3d");
		function kakaoLogin(){
			window.Kakao.Auth.login({
				scope:'profile_nickname, account_email, gender',
				success : function(authObj){
					console.log(authObj);
					window.Kakao.API.request({
						url:'/v2/user/me',
						success : res =>{
							const kakao_account = res.kakao_account;
							console.log(kakao_account);
							let id = res.id;
							let email = res.kakao_account.email;
							let name = res.properties.nickname;
							
							console.log(email);
							console.log(name);
							alert('로그인성공');
						}
					});
				}
			});
		} 
	//
	</script>
<style>
    #div-main{
        width: 50vw;
        height: 50vh;
        margin: auto;
        background-color: cadetblue;
    }
    
    .hint {
            color: red;
            padding-left: 10px;
    }
</style>
</head>
<body>
    <%@ include file="/WEB-INF/views/common/header.jsp"%>
    <div id="div-main">
        <form action="join" method="post" enctype="multipart/form-data" name = "insertform">
        <!-- onclick="idConfirm()" -->
            <label>아이디   : </label> <input type="text" name="id" id = "idBox" required> <button type = "button" id = "dupCheck">중복확인</button> 
            <br>
            <span id = "idspan"><label class="hint" id = "idMsg">영문자, 숫자 포함하여 총 4~12자로 입력하시오. 단, 첫 글자는 반드시 영문자로</label></span>
            <br>
            <label>비밀번호 : </label> <input type="text" name="pwd" id = "password" onkeyup="passConfirm()" onpaste="return false;" oncopy="return false;"/>
            <br>
            <label class="hint" id = "pwdspan">영문자, 숫자, 특수문자 포함하여 총 8~15자로 입력하시오.</label>
            <br>
            <label>비밀번호 재확인 : </label> <input type="text" id="passwordConfirm" onkeyup="passConfirm()"/>
            <br>
            <label class="hint" id = "pwdMsg">위의 비밀번호와 일치하게 입력하시오.</label>
            <br>
            <!-- onkeyup="nameConfirm()" -->
            <label>이름   : </label> <input type="text" name="name" id="userName" required>
            <br>
            <label class="hint" id = "nameMsg">한글로만 이루어져야 되며 2글자 이상으로 입력하시오.</label>
            <br>
            <label> 이메일 : <input type="email" name="email" id="email" required><br>
            <label class="hint">이메일 형식에 맞춰서 입력하시오.</label>
            <input type="button" name="emailconfirm_btn" value="인증" onclick="emailcheck(insertform.email.value, insertform.name.value)">
        	</label>
            <input type="submit" value="가입하기" onclick="return Check();">
        </form>
        	<a href = "javascript:kakaoLogin();"><img src="//k.kakaocdn.net/14/dn/btqbjxsO6vP/KPiGpdnsubSq3a0PHEGUK1/o.jpg" width="53%" height ="50px" /></a><br>

			<div class="checkbox_group">
				<input type="checkbox" id="check_all" >
				<label for="check_all">전체 동의</label>
			  	<br>
				<input type="checkbox" id="check_1" class="normal" >
				<label for="check_1">개인정보 처리방침 동의</label>
				<br>			  
				<input type="checkbox" id="check_2" class="normal" >
				<label for="check_2">서비스 이용약관 동의</label>
			  	<br>
				<input type="checkbox" id="check_3" class="normal" >
				<label for="check_3">마케팅 수신 동의</label>
			</div>
    </div>
<script>
</script>
<script type = "text/javascript" src = "resouce/JS/join.js"></script>
</body>
</html>