<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>아이디 찾기</h2>
	<form action = "findId" method = "post" onsubmit="return Check();">
		이름 : <input type = "text" name = "Name" id = "userName"><br>
		이메일 : <input type = "email" name = "Email" id = "userEmail"><br>
		<input type = "submit" value = "아이디 찾기">
	</form>
</body>
<script type = "text/javascript" src = "resouce/JS/findId.js?ver=12"></script>
</html>