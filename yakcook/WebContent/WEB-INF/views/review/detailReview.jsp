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
	<script>
	$(function(){
		  $('#like_btn').on('click',function(){
			  type: 'POST',
			  url: '/reviewLike',
			  data: {"reviewNo" : request.getAttribute("reviewNo")},
		  	success : function(){
		  		
		  	},
		  	error : function() {
		  		
		  	}
		  
		   });
		});
		</script>
</head>
<body>
	<div id="wrap">

		<header></header>

		<section>

			

			<c:forEach items="${detailList}" var="d">
			<c:forEach items="${imgList}" var="i">
				<div id="reivew_title">
					<span>${d.reviewNo}</span> <span id="product_name">${d.reviewTitle}</span>
					<span id="writer">${d.reviewWriter}</span> <span id="date">${d.reviewDate}</span>
				</div>

				<div id="review_contents">${d.reviewContents}</div>
				
				<div id="review_img_file">
					<div id="review_img">
						<img src="/yakcook/reviewImg/${i.imgServerFile1}" alt="">
					</div>
					<div id="review_img">
						<img src="/yakcook/reviewImg/${i.imgServerFile2}" alt="">
					</div>
					<div id="review_img">
						<img src="/yakcook/reviewImg/${i.imgServerFile3}" alt="">
					</div>
				
				</div>

				<div id="review_button">
					<button type="button" onclick="location.href='reviewList'">목록으로</button>
					<button>신고하기</button>
					<button type="button"
						onclick="location.href='delete?reviewNo=${d.reviewNo}'" id="declaration">삭제하기</button>
				</div>
			<button type="button" id="like_btn">좋아요</button>
			<h3>조회수 :${d.reviewViews }</h3>
			</c:forEach>
			</c:forEach>
		</section>




		<footer></footer>
	</div>

</body>
</html>