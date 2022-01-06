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
	<link rel="stylesheet" type="text/css" href="animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resouce/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="resouce/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resouce/CSS/util.css">
	<link rel="stylesheet" type="text/css" href="resouce/CSS/main.css">
<!--===============================================================================================-->
<body>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-l-85 p-r-85 p-t-55 p-b-55">
				<form action = "findId" method = "post" onsubmit="return Check();"class="login100-form validate-form flex-sb flex-w">
					<span class="login100-form-title p-b-32">
						Find Id
					</span>
	
					<span class="txt1 p-b-11">
						<h3>아이디</h3>
					</span>
					<div class="wrap-input100 validate-input m-b-36" data-validate="UserName is required">
						<input class="input100" type="text" name = "Name" id = "userName">
						<span class="focus-input100"></span>
					</div>
	
					<span class="txt1 p-b-11">
						<h3>이메일</h3>
					</span>
					<div class="wrap-input100 validate-input m-b-12" data-validate="Email is required">
						<input class="input100" type="email" name = "Email" id = "userEmail">
						<span class="focus-input100"></span>
					</div>
	
					<div class="flex-sb-m w-full p-b-48">
						<div class="contact100-form-checkbox">
							<input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
						</div>
	
						<div>
						</div>
					</div>
	
					<div class="container-login100-form-btn">
						<input type="submit" value="FindId">
					</div>
				</form>
			</div>
		</div>
</body>
<script type = "text/javascript" src = "resouce/JS/findId.js?ver=12"></script>
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
<!--=============================================-->
</html>