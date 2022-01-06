<%@page import="com.yakcook.review.vo.ReviewListVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri = "http://java.sun.com/jsp/jstl/core"  prefix="c"%>  
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
		    <div class="panel panel-inf1o">
		<div class="panel-heading">
		</div>
		    <!-- 사이드바 메뉴목록3 -->
		  </div>
		</div> 
		<!-- 9단길이의 첫번째 열 -->
		  <div class="col-md-10">
		    <div class="jumbotron">
		    <h1>리뷰 조회</h1>
		    <p>
	<%-- <table border="1">
		<tr>
			<td> 사진 </td>
			<td> 제목 </td>
			<td> 내용 </td>
			<td> 조회수 </td>
			<td> 좋아요 </td>
			<td> 날짜 </td>
		</tr>
		
		<c:forEach items="${data}" var = "b">
			<tr onclick="location.href='reviewList?reviewNo=${b.reviewNo}'" style = "cursor:pointer;">
					<td><img src="resources/images/review/${b.reviewImg}" alt=""></td>
					<td>${b.reviewTitle}</td>
					<td>${b.reviewContents}</td>
					<td>${b.reviewViews}</td>
					<td>${b.reviewLike}</td>
					<td>${b.reviewDate}</td>
			</tr>
		</c:forEach>	
	</table>
</head> --%>
<body>
<div class="container">
	<table class="styled-table">
		<tr>
			<td> 사진 </td>
			<td> 제목 </td>
			<td> 내용 </td>
			<td> 조회수 </td>
			<td> 좋아요 </td>
			<td> 날짜 </td>
		</tr>	
		
	<c:forEach items="${data}" var = "b">
		<tr onclick="location.href='reviewList?reviewNo=${b.reviewNo}'" style = "cursor:pointer;">
			<td><img src="resources/images/review/${b.reviewImg}" alt=""></td>
			<td>${b.reviewTitle}</td>
			<td>${b.reviewContents}</td>
			<td>${b.reviewViews}</td>
			<td>${b.reviewLike}</td>
			<td>${b.reviewDate}</td>
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
  <%@ include file="../common/footerFinal.jsp"%>
</body>
</html>