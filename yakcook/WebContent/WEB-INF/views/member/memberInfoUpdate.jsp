<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	#div-wrap{
		width : 70vw;
		background-color : skyblue;
		margin : 0 auto;
	}
	table{
		width : 100%;
	}
</style>
<body>
    <%@ include file="../common/header.jsp"%>
    <h1>탐색</h1>
    
    <div id="div-wrap">
    <form action = "memberinfoupdate" method = "post">
        <div id="div-wrap">
        <table border="1">
	        <tr>
	            <td> 아이디 : <input type = "text" id = "qnano" name = "uesrid" value = "${m.user_id}" style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;" readonly></td>
	        </tr>
	       	<tr>
	            <td> 이름 : <input type = "text" id = "qnano" name = "username" value = "${m.user_name}" style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;" readonly></td>
	        </tr>
	      	<tr>
	            <td> 이메일 : <input type = "text" id = "qnano" name = "usereamil" value = "${m.user_email}" style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;"> </td>
	        </tr>
	       	<tr>
	            <td> 핸드폰 : <input type = "text" id = "qnano" name = "userphone" value = "${m.user_phone}" style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;"></td>
	        </tr>
        </table>
    </div>
		<input type = "submit" value = "회원정보변경">
    </form>
</body>
</html>