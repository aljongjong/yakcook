<%@page import="com.yakcook.member.model.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<link rel="stylesheet"
	href="/yakcook/resources/css/review/writerReview.css">
<body>

	<div id="wrap">
		<header> </header>
		<%
	String loginUserId = ((MemberVo)session.getAttribute("loginUser")).getUser_id();%>
		<section>
			<div class="review_Wrap">
				<form action="review" method="post" enctype="multipart/form-data">
					<table class="review_table">
						<tr>
							<th colspan="2">제목</th>
							<td><input type="text" name="review_title" id=""></td>
						</tr>

						<tr>
							<th colspan="2">내용</th>
							<td colspan="2"><textarea name="review_contents"
									class="review_contents" maxlength="1000"></textarea></td>
						</tr>

						<tr>
							<th colspan="2">사진1</th>
							<td><input type="file" name="review_img"
								accept=".gif, .jpg, .png"></td>
						</tr>
						<tr>
							<th colspan="2">사진2</th>
							<td><input type="file" name="review_img"
								accept=".gif, .jpg, .png"></td>
						</tr>
						<tr>
							<th colspan="2">사진3</th>
							<td><input type="file" name="review_img"
								accept=".gif, .jpg, .png"></td>
						</tr>
						<input type="hidden" name="userId" value="<%=loginUserId%>">
					</table>
					<div class="writer_button">
						<input type="submit" value="등록"> <input type="button"
							value="취소" onclick="location.href='reviewList'">

					</div>
				</form>
			</div>
		</section>

		<footer> </footer>
	</div>
</body>

</html>