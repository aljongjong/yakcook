<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!--===============================================================================================-->	
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
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resouce/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="resouce/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resouce/CSS/util.css">
	<link rel="stylesheet" type="text/css" href="resouce/CSS/main.css">
<!--===============================================================================================-->
<body>
<h2>비밀번호 변경</h2>
<!-- <form action = "findPwdUpdate" method = "post"> -->
<%-- 	<input type = "hidden" name = "id" id = "userid" value = "${id}"><br>
	비밀번호 : <input type = "text" name = "password" id = "password" onkeyup="passConfirm()" onpaste="return false;" oncopy="return false;"><br>
	<label class="hint" id = "pwdspan">영문자, 숫자, 특수문자 포함하여 총 8~15자로 입력하시오.</label><br>
	비밀번호 재확인 : <input type = "text" name = "passwordcheck" id = "passwordConfirm" onkeyup="passConfirm()"><br>
	<label class="hint" id = "pwdMsg">위의 비밀번호와 일치하게 입력하시오.</label><br>
	<input type = "submit" value = "수정완료" onclick="return Check();"> --%>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-l-85 p-r-85 p-t-55 p-b-100">
				<form action="findPwdUpdate" method = "post" class="login100-form validate-form flex-sb flex-w">
					<span class="login100-form-title p-b-32">
						PASSWORD UPDATE
						<input type = "hidden" name = "id" id = "userid" value = "${id}"><br>
					</span>
					<span class="txt1 p-b-11">
						<h3>비밀번호</h3>
					</span>
					<div class="wrap-input100 validate-input m-b-12" data-validate = "Password is required">
						<span class="btn-show-pass">
							<i class="fa fa-eye"></i>
						</span>
						<input class="input100" type="password" name = "password" id = "password" onkeyup="passConfirm()" onpaste="return false;" oncopy="return false;" placeholder = "비밀번호를 입력해주세요" required/>
						<span class="focus-input100"></span>
					</div>
					<br>
					<label class="hint" id="pwdspan" class = "mb-50">영문자, 숫자, 특수문자 포함하여 총 8~15자로 입력하시오. <br></label>

					<span class="txt1 p-b-11">
						<h3>비밀번호 재입력</h3>
					</span>
					<div class="wrap-input100 validate-input m-b-12" data-validate="Password is required">
						<span class="btn-show-pass">
							<i class="fa fa-eye"></i>
						</span>
						<input class="input100" type="password" name = "passwordcheck" id = "passwordConfirm" onkeyup="passConfirm()" placeholder = "비밀번호 재입력해주세요" required>
						<span class="focus-input100"></span>
					</div>
					<br>
					<label class="hint" id="pwdMsg">위의 비밀번호와 일치하게 입력하시오.<br><br></label>
					<br>


					<div class="container-login100-form-btn">
						<input type="submit" value="update" onclick="return Check();">
					</div>
					<div class="container-login100-form-btn">
						<input type="reset">
					</div>
				</form>
			</div>
		</div>
	</div>	
	<div id="dropDownSelect1"></div>
<script type = "text/javascript" src = "resouce/JS/findUpPwd.js"></script>

	<script type = "text/javascript" src = "resouce/JS/findUpPwd.js"></script> -->

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
