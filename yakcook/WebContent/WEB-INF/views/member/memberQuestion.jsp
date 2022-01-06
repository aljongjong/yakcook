<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core"  prefix="c"%>  
    <%@page import="com.yakcook.member.model.vo.*"%>
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
<link rel="stylesheet" type="text/css" href="resouce/CSS/table.css">

  <style>
  body {padding-top: 60px;}
  </style>

<body>
<%@ include file="/WEB-INF/views/common/headerFinal.jsp"%>
      <div class="container-fluid">
		<div class="row">
		  <div class="col-md-2">
		<!-- 사이드 바 메뉴-->
		<div class="panel panel-success">
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
		    <div class="panel panel-1info">
		<div class="panel-heading">
		</div>
		    <!-- 사이드바 메뉴목록3 -->
		  </div>
		</div> 
		<!-- 9단길이의 첫번째 열 -->
		  <div class="col-md-10">
		    <div class="jumbotron">
		    <h1>문의 조회</h1>
		    <p>
	<table class="styled-table">
		<tr>
			<td> 문의 번호 </td>
			<td> 아이디 </td>
			<td> 카테고리 </td>
			<td> 제목 </td>
			<td> 내용 </td>
			<td> 답변 </td>
		</tr>
		<a href = "memberquestionwriter" style = "text-align:right";>글쓰기</a>
 		<c:forEach items="${qnaList}" var = "q">
			<tr onclick="location.href='QnADetail?qna_no=${q.qna_no}'" style = "cursor:pointer;">
					<td>${q.qna_no}</td>
					<td>${q.user_id}</td>
					<td>${q.qna_category}</td>
					<td>${q.qna_title}</td>
					<td>${q.qna_content}</td>
					<td>${q.manager_answer}</td>
			</tr>
		</c:forEach> 
	</table>
    </p>
    </div>
    </div>
  </div>
</div>
  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="resouce/js/bootstrap.min.js"></script>
</body>
<%@ include file="../common/footerFinal.jsp"%>
</html>