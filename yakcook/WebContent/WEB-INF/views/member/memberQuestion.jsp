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
<body>
<h1>문의 사항 조회 페이지</h1>
	<table border="1">
		<tr>
			<td> 문의 번호 </td>
			<td> 아이디 </td>
			<td> 카테고리 </td>
			<td> 제목 </td>
			<td> 내용 </td>
		</tr>
		<a href = "memberquestionwriter">글쓰기</a>
 		<c:forEach items="${qnaList}" var = "q">
			<tr onclick="location.href='QnADetail?qna_no=${q.qna_no}'" style = "cursor:pointer;">
					<td>${q.qna_no}</td>
					<td>${q.user_id}</td>
					<td>${q.qna_category}</td>
					<td>${q.qna_title}</td>
					<td>${q.qna_content}</td>
			</tr>
		</c:forEach> 
	</table>
</body>
</html>