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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
	<div id="wrap">

		<header></header>

		<section>

			

			<c:forEach items="${detailList}" var="d">
			<c:forEach items="${imgList}" var="i">
				<div id="reivew_title">
					<span>${d.reviewNo}</span> <span id="product_name">${d.reviewTitle}</span>
					<span id="writer">${d.writer}</span> <span id="date">${d.reviewDate}</span>
				</div>

				<div id="review_contents">${d.reviewContents}</div>
				
				<div id="review_img_file">
					<div id="review_img">
						<img src="/yakcook/reviewImg/${i.serverFile1}" alt="">
					</div>
					<div id="review_img">
						<img src="/yakcook/reviewImg/${i.serverFile2}" alt="">
					</div>
					<div id="review_img">
						<img src="/yakcook/reviewImg/${i.serverFile2}" alt="">
					</div>
				
				</div>

				<div id="review_button">
					<button type="button" onclick="location.href='reviewList'">목록으로</button>
					<button>신고하기</button>
					<button type="button"
						onclick="location.href='delete?reviewNo=${d.reviewNo}'">삭제하기</button>
				</div>
			<button type="button" value="좋아요" onclick="like()"></button>
			</c:forEach>
			</c:forEach>
		</section>




		<footer></footer>
	</div>

</body>
</html>