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
<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-l-85 p-r-85 p-t-55 p-b-100">
				<form action="findPwd" method="post" name = findPwdform onsubmit="return Check();">
					<span class="login100-form-title p-b-32">
						PASSWORD UPDATE
					</span>

					<span class="txt1 p-b-11">
						<h3>??????</h3> 
					</span>
					<div class="wrap-input100 validate-input m-b-36" data-validate = "UserId is required">
						<input class="input100" type="text" name = "name" id = "userName" placeholder = "????????? ??????????????????" required>
						<span class="focus-input100"></span>
					</div>
					
					<span class="txt1 p-b-11">
						<h3>?????????</h3>
					</span>
					<div class="wrap-input100 validate-input m-b-12" data-validate = "Password is required">
						<span class="btn-show-pass">
							<i class="fa fa-eye"></i>
						</span>
						<input class="input100" type = "text" name = "id" id = "userId" placeholder = "???????????? ??????????????????" required>
						<span class="focus-input100"></span>
					</div>
					
					<span class="txt1 p-b-11">
						<h3>?????????</h3>
					</span>
					<div class="wrap-input100 validate-input m-b-12" data-validate = "Password is required">
						<span class="btn-show-pass">
							<i class="fa fa-eye"></i>
						</span>
						<input class="input100" type = "email" name = "email" id = "userEmail" placeholder = "???????????? ??????????????????" required>
						<span class="focus-input100"></span>
					</div>
							<input type="button" name="emailconfirm_btn" value="????????? ??????" onclick="emailcheck(findPwdform.email.value)">
							<br>
					<input type = "submit" value = "??????????????????">
					<div class="container-login100-form-btn">
						<input type ="submit"  value="Login">
					</div>					
					</div>
 				</form>
			</div>
		</div>
	<div id="dropDownSelect1"></div>
<!-- 	<h2>???????????? ??????</h2>
	<form action = "findPwd" method = "post" name = findPwdform onsubmit="return Check();">
		?????? : <input type = "text" name = "name" id = "userName"><br>
		????????? : <input type = "text" name = "id" id = "userId"><br>
		????????? : <input type = "email" name = "email" id = "userEmail">
		<input type="button" name="emailconfirm_btn" value="????????? ??????" onclick="emailcheck(findPwdform.email.value)">
		<br>
		<input type = "submit" value = "??????">
	</form> -->
<script type = "text/javascript" src = "resouce/JS/findPwd.js?ver=12"></script>
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
 