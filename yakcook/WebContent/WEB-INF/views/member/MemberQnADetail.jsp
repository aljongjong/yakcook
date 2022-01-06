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
<%@ include file="/WEB-INF/views/common/headerFinal.jsp"%>
	<div id="wrap">
			<c:forEach items="${qnaList}" var="q">
			<form action = "qnadelete" method = "get">
			<h1>문의 내용</h1>
					<div>
						문의 번호 : <input type = "text" id = "qnano" name = "qnano" value = "${q.qna_no}" readonly style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;"><br><br>
						아이디 : <input type = "text" id = "userId" name = "userId" value = "${q.user_id}" readonly style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;"><br><br>
						제목 : <input type = "text" id = "qnatitle" name = "qnatitle" value = "${q.qna_title}" readonly style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;"><br><br>
						
					</div>

					<div> 문의 내용 : <input type = "text" id = "qnatitle" name = "qnatitle" value = "${q.qna_content}" readonly style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;"><br></div>
					<hr><br>
					답변 : 
					<div>${q.manager_question}</div>
					</div>
					<div id="review_button">
						<button type="button" onclick="location.href='memberQuestion'">목록으로</button>						
						<button type="button" onclick="location.href='qnaupdate?qna_no=${q.qna_no}'">수정하기</button>
						<input type="submit" value = "삭제">
					</div>
					</form>
			</c:forEach>
		<footer></footer>
	</div>
<%@ include file="../common/footerFinal.jsp"%>
</body>
</html>