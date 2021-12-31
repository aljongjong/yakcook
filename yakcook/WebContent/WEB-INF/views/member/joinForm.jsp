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
	<link rel="icon" type="image/png" href="resouce/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resouce/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resouce/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resouce/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resouce/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="resouce/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resouce/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="resouce/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resouce/CSS/util.css">
	<link rel="stylesheet" type="text/css" href="resouce/CSS/main.css">
<!--===============================================================================================-->
</head>
<body>

 <div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-l-85 p-r-85 p-t-55 p-b-100">
				<form action="join" method = "post" class="login100-form validate-form flex-sb flex-w" enctype="multipart/form-data" name = "insertform">
					<span class="login100-form-title p-b-32">
						Sign Up
					</span>

					<span class="txt1 p-b-11">
						Userid
					</span>
					<div class="wrap-input100 validate-input m-b-" data-validate = "Username is required">
						<input class="input100" type="text" name="id" id = "idBox">
						<span class="focus-input100"></span>
					</div>
					<span id="idspan"><label id="idMsg">영문자, 숫자 포함하여 총 4~12자로 입력하시오. 단, 첫 글자는 반드시 영문자로</label></span>
					
					<span class="txt1 p-b-11">
						Password
					</span>
					<div class="wrap-input100 validate-input m-b-12" data-validate = "Password is required">
						<span class="btn-show-pass">
							<i class="fa fa-eye"></i>
						</span>
						<input class="input100" type="password" name="pwd" id = "password"  onkeyup="passConfirm()" onpaste="return false;" oncopy="return false;"/>
						<span class="focus-input100"></span>
					</div>
					<br>
					<label class="hint" id="pwdspan" class = "mb-50">영문자, 숫자, 특수문자 포함하여 총 8~15자로 입력하시오. <br></label>

					<span class="txt1 p-b-11">
						Password Re
					</span>
					<div class="wrap-input100 validate-input m-b-12" data-validate="Password is required">
						<span class="btn-show-pass">
							<i class="fa fa-eye"></i>
						</span>
						<input class="input100" type="password" id="passwordConfirm" onkeyup="passConfirm()">
						<span class="focus-input100"></span>
					</div>
					<br>
					<label class="hint" id="pwdMsg">위의 비밀번호와 일치하게 입력하시오.<br><br></label>
					<br>

					<span class="txt1 p-b-11">
						UserName
					</span>
					<div class="wrap-input100 validate-input m-b-12" data-validate="UserName is required">
						<input class="input100" type="text" name="name" id="userName">
						<span class="focus-input100"></span>
					</div>
					<br>
					<label class="hint" id="nameMsg">한글로만 이루어져야 되며 2글자 이상으로 입력하시오.<br><br></label>
					<br>

					<span class="txt1 p-b-11">
						Email
					</span>
					<div class="wrap-input100 validate-input m-b-12" data-validate="Email is required">
						<input class="input100"  type="email" name="email" id="email">
						<span class="focus-input100"></span>
					</div>
						<br>
						<label class="hint">이메일 형식에 맞춰서 입력하시오.</label>
						<input type="button" name="emailconfirm_btn" value="인증" onclick="emailcheck(insertform.email.value, insertform.name.value)">
						<br>

					<span class="txt1 p-b-11">
						Phone
					</span>
					<div class="wrap-input100 validate-input m-b-12" data-validate="Phone is required">
						<input class="input100" type="text" name="phone">
						<span class="focus-input100"></span>
					</div>
					
					<div class="flex-sb-m w-full p-b-48">
						<div class="contact100-form-checkbox">
							<input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
							<label class="label-checkbox100" for="ckb1">
								Remember me
							</label>
						</div>

						<div>
							<a href="findId" class="txt3">
								Forgot Id /
							</a>
							<a href="findPwd" class="txt3">
								Forgot Password 
							</a>
						</div>
					</div>

					<div class="container-login100-form-btn">
						<input type="submit" value="Join" onclick="return Check();">
					</div>
					<div class="container-login100-form-btn">
						<input type="reset">
					</div>
				</form>
			</div>
		</div>
	</div>	
	<div id="dropDownSelect1"></div>
	<script type = "text/javascript" src = "resouce/JS/join.js"></script>
	<script src="resouce/JS/main.js"></script>
	<!--===============================================================================================-->
	<script src="resouce/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="resouce/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="resouce/vendor/bootstrap/js/popper.js"></script>
	<script src="resouce/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="resouce/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="resouce/vendor/daterangepicker/moment.min.js"></script>
	<script src="resouce/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="resouce/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->

</body>
</html>