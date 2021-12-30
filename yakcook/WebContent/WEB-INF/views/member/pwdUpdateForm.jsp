<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>비밀번호 변경</h1>
<form action="pwdUpdate" method="post">
	아이디 : <input type = "text" id = "userId" name = "userId" value = "${id}" readonly><br>
	기존 비밀번호 : <input type="password" id="oldPwd" name="oldPwd"><br>
	바꿀 비밀번호 : <input type="password" maxlength="20" id="password" name="newPwd" onkeyup="passConfirm()" onpaste="return false;" oncopy="return false;"><br>
	<label class="hint" id = "pwdspan">영문자, 숫자, 특수문자 포함하여 총 8~15자로 입력하시오.</label>
	<input type="submit" value="비밀번호변경">
</form>
<script type = "text/javascript" src = "resouce/JS/findUpPwd.js"></script>
</body>
</html>