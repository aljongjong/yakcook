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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>



</head>
<body>
	<div id="wrap">

		<header></header>

		<section>



			<c:forEach items="${detailList}" var="d">
				<c:forEach items="${imgList}" var="i">
					<div id="reivew_title">
						<span>${d.reviewNo}</span> <span id="product_name">${d.reviewTitle}</span>
						<span id="writer">${d.userId}</span> <span id="date">${d.reviewDate}</span>
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
						<button type="button" id="declaration">신고하기</button>
						<button type="button" id="delete">삭제하기</button>
					</div>
					<h3 id="like_count">${d.reviewLike}</h3>
					<button type="button" id="like_btn">좋아요</button>
					<h3>조회수 :${d.reviewViews}</h3>
				</c:forEach>
			</c:forEach>
		</section>




		<footer></footer>
	</div>

	<script>
<%String id = (String) session.getAttribute("userId");%>

	$(function(){
		$('#like_btn').on('click',function(){
			if("<%=id%>"!=null){
				alert("참여해주셔서 감사합니다.");
				$.ajax({
					url:'reviewLike',
					type:'post',
					data:{reviewNo : <%=request.getAttribute("reviewNo")%>},
					success :function(data){
						$('#like_count').html(data);
					},
					error: function(){
						alert('ERROR');
					}
				})
			}else{
				alert('회원만 가능한 기능입니다. \로그인 하시기 바랍니다.')
			}
		})
	})
		
	
	
	$(function(){
		$('#declaration').on('click',function(){
			if("<%=id%>"!=null){
				$.ajax({
					url:'declaration',
					type:'post',
					data:{reviewNo : <%=request.getAttribute("reviewNo")%>},
					success :function(data){
						alert('신고가 접수되었습니다.')
					},
					error: function(){
						alert('ERROR');
					}
				})
			}else{
				alert('회원만 가능한 기능입니다. \로그인 하시기 바랍니다.')
			}
		})
	})
	
	
	$(function(){
		  $('#delete').on('click',function(){
		         if(confirm("게시물을 삭제하시겠습니까?")){  
		    $.ajax({   
		         url:'reviewDelete',  
		         type:'post',  
		         data: {reviewNo:<%=request.getAttribute("reviewNo")%>,userId:"<%=id%>"},
		         success : function(data){  
		                   alert(data);
		                   location.href='/yakcook/reviewList';
		           },
		          error : function(){
		          alert('신고가 실패하였습니다.');
		          }
		    });   
		   }
		  });
		  
		});



	
	
</script>
</body>
</html>