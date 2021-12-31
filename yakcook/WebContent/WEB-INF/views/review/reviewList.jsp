<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/yakcook/resources/css/review/reviewList.css">
</head>
<body>
	<div id="wrap">
		<header>
			<div id="title_img"></div>
			<div id="title">상품후기</div>
			<h3>Yakcook 상품에 대해 가득한 이야기들을 확인해보세요!</h3>
		</header>
		

		<section>
			
			<ul id="review_ul">
				<c:forEach items="${data}" var="r">	

					<li class="review_li">
						<div class="review_pro">

							<a href="${path}/yakcook/detail?reviewNo=${r.reviewNo}">${r.reviewTitle}
							<br> (루테인)</a>
							
						</div>
						<div class="review_img">
							<img src="/yakcook/upload/" alt="">
						</div>
						<div class="review_contents">
							<div class="contents">${r.reviewContents}</div>
							<div class="review_date">2012.20.21</div>
						</div>
					</li>
				</c:forEach>

			</ul>

	
			<div class="page_area">
				<c:forEach var="i" begin="1" end="5">
					<c:if test="${i le maxPage}">
						<a href="reviewList?currentPage=${i}">${i}</a>
					</c:if>
				</c:forEach>
				<button type="button" onclick="location.href='reviewWrite'">글쓰기</button>
			</div>

			


		</section>


		<footer> </footer>
</body>
</html>