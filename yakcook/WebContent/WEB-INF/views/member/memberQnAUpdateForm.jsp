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
			<form action = "qnaupdate" method = "post">
			<h1>문의 내용 수정</h1>
						문의 번호 : <input type = "text" id = "qnano" name = "qnano" value = "${q.qna_no}" style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;" readonly><br><br>
						아이디 : <input type = "text" id = "userId" name = "userId" value = "${q.user_id}" style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;"readonly><br><br>
						제목 : <input type = "text" id = "qnatitle" name = "qnatitle" value = "${q.qna_title}" style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;"><br><br>
					    문의 내용 : <input type = "text" id = "qnatitle" name = "qnatitle" value = "${q.qna_content}" readonly style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;"><br></div>

					<div id="review_button">
						<input type="submit" value = "수정완료">
					</div>
		</form>
</body>
<%@ include file="../common/footerFinal.jsp"%>
</html>