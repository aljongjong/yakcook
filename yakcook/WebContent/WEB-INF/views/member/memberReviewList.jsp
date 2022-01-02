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
<body>
<h1>리뷰 조회 페이지</h1>
	<table border="1">
		<tr>
			<td> 이름 </td>
			<td> 제목 </td>
			<td> 내용 </td>
			<td> 조회수 </td>
			<td> 좋아요 </td>
		</tr>
		
		<c:forEach items="${data}" var = "b">
			<tr onclick="location.href='reviewList?reviewNo=${b.reviewNo}'" style = "cursor:pointer;">
					<td>${b.userId}</td>
					<td>${b.reviewTitle}</td>
					<td>${b.reviewContents}</td>
					<td>${b.reviewViews}</td>
					<td>${b.reviewLike}</td>
			</tr>
		</c:forEach>	
	</table>
</body>
</html>