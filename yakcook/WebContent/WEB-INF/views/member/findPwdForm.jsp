<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>비밀번호 찾기</h2>
	<form action = "findPwd" method = "post" name = findPwdform onsubmit="return Check();">
		이름 : <input type = "text" name = "name" id = "userName"><br>
		아이디 : <input type = "text" name = "id" id = "userId"><br>
		이메일 : <input type = "email" name = "email" id = "userEmail">
		<input type="button" name="emailconfirm_btn" value="이메일 인증" onclick="emailcheck(findPwdform.email.value)">
		<br>
		<input type = "submit" value = "다음">
	</form>
</body>
<script type = "text/javascript" src = "resouce/JS/findPwd.js?ver=12"></script>
</html>