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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/yakcook/resources/js/review/detailReview.js"></script>


</head>
<body>

	

		<header id="header">
		<%@ include file="/WEB-INF/views/common/headerFinal.jsp"%>
		</header>


		<section>
<div id="wrap">
			<c:forEach items="${detailList}" var="d">
				<c:forEach items="${imgList}" var="i">
					<div id="button_menu">
						<button type="button" id="declaration_btn">신고하기</button>
						<button type="button" id="delete">삭제하기</button>
						<p>${d.reviewDate}</p>
					</div>
					<div id="board">

						<div id="reivew_head">
							<div id="views">조회수 : ${d.reviewViews}</div>
							<div id="title">${d.reviewTitle}</div>
							<div id="writer">작성자 : ${d.userId}</div>

						</div>
						<hr>

						<div id="contents">
							<div id="review_contents">${d.reviewContents}</div>

							<div class="slide">
								<ul class="panel">
									<li><img src="resources/images/review/${i.imgServerFile1}"></li>
									<li><img src="resources/images/review/${i.imgServerFile2}"></li>
									<li><img src="resources/images/review/${i.imgServerFile3}"></li>
								</ul>
								<ul class="dot">
									<li class="on"></li>
									<li></li>
									<li></li>
								</ul>

							</div>



						</div>

					</div>


					<hr>

					<div id="like">

						<div id="like_form">
							<button type="button" id="like_btn">도움이 되었어요!</button>
							<div id="like_img">
								<img src="resources/images/review/좋아요아이콘.png" alt="">
							</div>
							<div id="like_count">현재 이 리뷰가 ${d.reviewLike}명에게 도움이 되고
								있어요.</div>
						</div>
			
					</div>
				</c:forEach>
			</c:forEach>
		</section>
		<footer id="footer">
		
		</footer>
			<%
			String loginUserId = null;
			try {
				loginUserId = ((MemberVo) session.getAttribute("loginUser")).getUser_id();
			} catch (Exception e) {
				loginUserId = null;
			}
			%>


			<script>
	
			//게시물좋아요
						$(function(){
							$('#like_btn').on('click',function(){
								if("<%=loginUserId%>" !=null && "<%=loginUserId%>" != "null"){
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
				
			
			
			//게시물삭제
			
			$(function(){
				  $('#delete').on('click',function(){
				         if(confirm("게시물을 삭제하시겠습니까?")){  
				    $.ajax({   
				         url:'reviewDelete',  
				         type:'post',  
				         data: {reviewNo:<%=request.getAttribute("reviewNo")%>,userId:"<%=loginUserId%>"},
				         success : function(data){  
				                   alert(data);
				                   location.href='/yakcook/reviewList';
				           },
				          error : function(){
				          alert('게시물 삭제를 실패하였습니다.');
				          }
				    });   
				   }
				  });
				  
				});


			
			//게시물신고
			$(function(){
				
				$('#declaration_btn').on('click',function(){
					if("<%=loginUserId%>" !=null && "<%=loginUserId%>" !="null"){
						
						window.open("declarationPopup?reviewNo=<%=request.getAttribute("reviewNo")%>","declaration","width=400,height=300,left=100,top=50")
						
					}else{
						alert('회원만 가능한 기능입니다. \n 로그인 하시길 바랍니다.')
					}
				})
			})
			
			
			
		</script>
</body>
</html>