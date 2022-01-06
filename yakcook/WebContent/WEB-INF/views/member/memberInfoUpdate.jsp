<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
  <!-- Bootstrap -->
  <link href="resouce/CSS/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="resouce/CSS/table.css">
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <link href="resouce/CSS/bootstrap.min.css" rel="stylesheet">
  <style>
  body {padding-top: 60px;}
  </style>
<body>
<%@ include file="/WEB-INF/views/common/headerFinal.jsp"%>
          <div class="container-fluid">
		<div class="row">
		  <div class="col-md-2">
		<!-- 사이드 바 메뉴-->
		<div class="panel panel-info">
		  <div class="panel-heading">
		  <!-- 아이콘 붙이기 -->
		  </h3>
		</div>
		<!-- 사이드바 메뉴목록1 -->
		<ul class="list-group">
		  <li class="list-group-item"><a onclick="location.href='memberinfoupdate?user_id=${m.user_id}'" style="color: rgb(171, 184, 107);">회원정보수정</a></li>
		  <li class="list-group-item"><a href="pwdUpdateForm" style="color: rgb(171, 184, 107);">비밀번호변경</a></li>
		  <li class="list-group-item"><a href="memberReview" style="color: rgb(171, 184, 107);">내리뷰</a></li>
		  <li class="list-group-item"><a href="memberquestion" style="color: rgb(171, 184, 107);">내 문의사항</a></li>
		  <li class="list-group-item"><a href="deleteForm" style="color: rgb(171, 184, 107);">회원탈퇴</a></li>
		</ul>
		</div>
		    <div class="panel pqanel-info">
		<div class="panel-heading">
		</div>
		    <!-- 사이드바 메뉴목록3 -->
		  </div>
		</div> 
		<!-- 9단길이의 첫번째 열 -->
		  <div class="col-md-10">
		    <div class="jumbotron">
		    <h1>회원 정보 변경</h1>
		    <p>
    
    <form action = "memberinfoupdate" method = "post">
			<h5>아이디는 변경할 수 없습니다.</h5>
	           아이디 : <input type = "text" name = "uesrid" value = "${m.user_id}" style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px; background-color: #eeeeee;" readonly><br><br>
	        <h5>이름은 변경할 수 없습니다.</h5>    
	           이름 : <input type = "text"  name = "username" value = "${m.user_name}" style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px; background-color: #eeeeee;" readonly><br><br>
	      	
	           이메일 : <input type = "text" name = "usereamil" value = "${m.user_email}" style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px; background-color: #eeeeee;"><br><br>
	       
	           핸드폰 : <input type = "text" name = "userphone" value = "${m.user_phone}" style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px; background-color: #eeeeee;"><br><br>

		<input type = "submit" class="btn btn-success" value = "회원정보변경">
    </form>
    </p>
    </div>
    </div>
  </div>
</div>
  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="resouce/js/bootstrap.min.js"></script>
<%@ include file="../common/footerFinal.jsp"%>
</body>
</html>