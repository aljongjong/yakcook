<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<link rel="stylesheet" href="/yakcook/resources/css/customerService/notice.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<section>
	<%@ include file="/WEB-INF/views/customerService/sideMenu.jsp" %>
	<div id="tableWrap">
            <span class="title">공지사항</span>
            <br>
            <table>
                <tr>
                    <th class="t1">번호</th>
                    <th class="t2">제목</th>
                    <th class="t3">작성일</th>
                </tr>
                <c:forEach items="${noticeList}" var="n">
				<tr class="view">
					<td>${n.noticeNo}</td>
					<td>${n.noticeTitle}</td>
					<td>${n.writeDateString()}
				</tr>
				</c:forEach>
            </table>
            <br>
            <div class="page-area">
			<c:forEach var="i" begin="${paging.startPage}" end="${paging.endPage}">
				<c:if test="${i le paging.maxPage}">
					<div class="paging">
						<a class='page' href="?currentPage=${i}">${i}</a>
					</div>	
				</c:if>
			</c:forEach>
		</div>
    </div>    
    </section>
     <script>
    window.onload=()=>{
    	$('.view').on('click', function(){
    		let td = $(this).children();
			let number = td.eq(0).text();
			let url = "noticedetail?noticeNumber=" + number;
			window.location = url;
    	})
    }
    </script>
</body>
</html>