<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="memberdelete" method = "post">
		<label>아이디  : <%=request.getAttribute("loginUserId") %></label>
		<br>
		<label>비밀번호 : </label> <input type="text" name="userPwd">
		<br>
		<input type="submit" value="확인" onclick  = "memderdelete();">
	</form>
</body>
<script>
function memderdelete(){
	 if(confirm("진짜 탈퇴 하시는 건가요?")){
		 location.href="delete";
	 }else{
		 //이건 다시 수정하자
		 location.href="home";
	 }
}
	
</script>
</html>