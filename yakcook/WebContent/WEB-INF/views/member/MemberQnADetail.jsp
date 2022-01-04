<%@page import="com.yakcook.member.model.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/yakcook/resources/css/review/detailReview.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>


</style>


</head>
<body>
	<div id="wrap">

		<header></header>
			<c:forEach items="${qnaList}" var="q">
			<form action = "qnadelete" method = "get">
					<div id="qnd_title">
						
						문의 번호 : <input type = "text" id = "qnano" name = "qnano" value = "${q.qna_no}" readonly style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;"><br>
						아이디 : <input type = "text" id = "userId" name = "userId" value = "${q.user_id}" readonly style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;"><br>
						제목 : <input type = "text" id = "qnatitle" name = "qnatitle" value = "${q.qna_title}" readonly style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;"><br>
						
					</div>

					<div id="review_contents">${q.qna_content}</div>

					</div>

					<div id="review_button">
						<button type="button" onclick="location.href='memberQuestion'">목록으로</button>
						<input type="submit" value = "삭제">
					</div>
					</form>
			</c:forEach>




		<footer></footer>
	</div>
</body>
</html>