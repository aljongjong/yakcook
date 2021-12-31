<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>비밀번호 변경</h2>
<form action = "findPwdUpdate" method = "post">
	<input type = "hidden" name = "id" id = "userid" value = "${id}"><br>
	비밀번호 : <input type = "text" name = "password" id = "password" onkeyup="passConfirm()" onpaste="return false;" oncopy="return false;"><br>
	<label class="hint" id = "pwdspan">영문자, 숫자, 특수문자 포함하여 총 8~15자로 입력하시오.</label><br>
	비밀번호 재확인 : <input type = "text" name = "passwordcheck" id = "passwordConfirm" onkeyup="passConfirm()"><br>
	<label class="hint" id = "pwdMsg">위의 비밀번호와 일치하게 입력하시오.</label><br>
	<input type = "submit" value = "수정완료" onclick="return Check();">
</form>
<script type = "text/javascript" src = "resouce/JS/findUpPwd.js"></script>
</body>
</html>