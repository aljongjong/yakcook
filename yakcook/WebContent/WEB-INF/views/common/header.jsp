<%@page import="com.yakcook.member.model.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   #header-wrap{
      background-color: green;
      width:100vw;
      height:30vh;
   }
   #div-logo{
      background-color: blue;
      width:50%;
      height:70%;
      margin: auto;
   }
   #menubar{
      background-color: blueviolet;
      width: 100%;
      height: 30%;
   }
   #table-menubar{
      width: 100%;
      height: 100%;
      text-align: center;
   }
   #table-menubar td:hover{
      cursor: pointer;
   }
   #table-menubar td{
      background-color: burlywood;
      width: 25%;
   }
</style>
</head>
<body>
<%MemberVo vo = (MemberVo)session.getAttribute("vo"); %>
<div id="header-wrap">
	 	<div id="div-logo">
			logo~~~
		 </div>
		 <div id="menubar">
			<table id="table-menubar">
				<tr>
					<td><a href="notice">공지사항</a></td>
					<td><a href="search">탐색</a></td>
					<td>${loginUser.user_name}<a href="profile">내 프로필</a></td>
					<% if(request.getSession().getAttribute("loginUser") == null){ %>
					<td><a href="login">로그인</a></td>
					<%} else{%>
					<td>${loginUser.user_name}<a href="logout">로그아웃</a></td>
					<%} %>
				</tr>
			</table>
		 </div>
	 </div>

</body>
</html>