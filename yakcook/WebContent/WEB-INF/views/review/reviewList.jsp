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
	href="/yakcook/resources/css/review/reviewList.css">
<link href="https://fonts.googleapis.com/css2?family=Dokdo&family=East+Sea+Dokdo&display=swap"
	rel="stylesheet">

</head>
<body>

	<div id="wrap">
		<header>
			<div id="title_img"></div>
			<div id="title">PRODUCT REVIEW</div>


			<hr>
			<h3>Yakcook 상품에 대해 가득한 이야기들을 확인해보세요!</h3>
		</header>


		<section>

			<ul id="review_ul">
				<c:forEach items="${data}" var="r">

					<li class="review_li">
						<div class="review_pro">
							<a href="${path}/yakcook/reviewDetail?reviewNo=${r.reviewNo}">${r.reviewTitle}</a>
						</div>

						<div class="review_img">
							<img src="/yakcook/upload/" alt="">
						</div>

						<div class="review_contents">
							<div class="contents">${r.reviewContents}
								<a href="javascript:moreList();"> </a>
							</div>
							<div class="review_date">2012.20.21</div>
							<div class="userId">작성자 : ${r.userId }</div>
						</div>

					</li>
				</c:forEach>

			</ul>

			<hr>
			<div class="page_area">
				<c:forEach var="i" begin="1" end="5">
					<c:if test="${i le maxPage}">
						<a href="reviewList?currentPage=${i}">${i}</a>
					</c:if>
				</c:forEach>
				<button onclick="write_btn();" id="writer">글쓰기</button>
			</div>




		</section>


		<footer> </footer>

		<%
		String loginUserId = null;
		try {
			loginUserId = ((MemberVo) session.getAttribute("loginUser")).getUser_id();
		} catch (Exception e) {
			loginUserId = null;
		}
		%>
		<script>
		
	function write_btn() {
					var x = <%=loginUserId%>;
					alert(x);
					 if("<%=loginUserId%>" != null) {
						location.href = 'reviewWrite';
				} else {
					alert("회원만 가능한 기능입니다. \n로그인 하시기 바랍니다.")
				}
			}
		</script>
</body>

</html>