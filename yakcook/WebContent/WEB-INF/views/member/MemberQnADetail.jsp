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



</head>
<body>
	<div id="wrap">

		<header></header>

		<section>
			<c:forEach items="${qnaLiat}" var="q">
					<div id="qnd_title">
						<span>${q.qna_no}</span> <span id>${q.qna_title}</span>
						<span id="writer">${q.uesr_id}</span> <span id="date">${q.qna_date}</span>
					</div>

					<div id="review_contents">${q.qna_content}</div>

					</div>

					<div id="review_button">
						<button type="button" onclick="location.href='memberQuestion'">목록으로</button>
						<button type="button" id="delete">삭제하기</button>
					</div>
			</c:forEach>
		</section>




		<footer></footer>
	</div>
</body>
</html>