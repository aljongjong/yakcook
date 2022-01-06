<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src = "https://developers.kakao.com/sdk/js/kakao.js"></script>
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
				<form action="join" method = "post" class="login100-form validate-form flex-sb flex-w" name = "insertform">
					<span class="login100-form-title p-b-32">
						Sign Up
					</span>

					<span class="txt1 p-b-11">
						아이디 
					</span>
					<div class="wrap-input100 validate-input m-b-" data-validate = "Username is required">
						<input class="input100" type="text" name="id" id = "idBox" placeholder = "아이디를 입력해주세요" required>
						<span class="focus-input100"></span>
					</div>
					<span id="idspan"><label id="idMsg"></label></span>
					<span class="txt1 p-b-11">
					<br>
						비밀번호
					</span>
					<div class="wrap-input100 validate-input m-b-12" data-validate = "Password is required">
						<span class="btn-show-pass">
							<i class="fa fa-eye"></i>
						</span>
						<input class="input100" type="password" name="pwd" id = "password" class = "none"  onkeyup="passConfirm()" onpaste="return false;" oncopy="return false;" placeholder = "비밀번호를 입력해주세요" required/>
						<span class="focus-input100"></span>
					</div>
					<br>
					<label class="hint" id="pwdspan" class = "mb-50">  <br></label>

					<span class="txt1 p-b-11">
						비밀번호 재입력
					</span>
					<div class="wrap-input100 validate-input m-b-12" data-validate="Password is required">
						<span class="btn-show-pass">
							<i class="fa fa-eye"></i>
						</span>
						<input class="input100" type="password" id="passwordConfirm" class = "none" onkeyup="passConfirm()" placeholder = "비밀번호를 재 입력해주세요" required>
						<span class="focus-input100"></span>
					</div>
					<br>
					<label class="hint" id="pwdMsg"></label>
					<span class="txt1 p-b-11">
						이름
					</span>
					<div class="wrap-input100 validate-input m-b-12" data-validate="UserName is required">
						<input class="input100" type="text" name="name" id="userName" class = "none" placeholder = "이름을 입력해주세요" required>
						<span class="focus-input100"></span>
					</div>
					<br>
					<label class="hint" id="nameMsg"><br><br></label>
					<br>

					<span class="txt1 p-b-11">
						이메일
					</span>
					<div class="wrap-input100 validate-input m-b-12" data-validate="Email is required">
						<input class="input100"  type="email" name="email" id = "email" class = "none" placeholder = "이메일을 입력해주세요" required>
						<span class="focus-input100"></span>
					</div>
						<br>
						<label class="hint" id = "emailMsg"> </label>
						<input type="button" name="emailconfirm_btn" value="인증" onclick="emailcheck(insertform.email.value, insertform.name.value)">
					
					<p class="txt1 p-b-11">
						핸드폰번호
					</p>
					<div class="wrap-input100 validate-input m-b-12" data-validate="Phone is required">
						<input class="input100" type="text" name="phone" class = "none" maxlength="13" id = "phoneNumber" placeholder = "핸드폰을 입력해주세요" required>
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