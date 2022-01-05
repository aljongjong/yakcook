<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QNA 관리</title>
<link rel="stylesheet" href="/yakcook/resources/css/serviceManage/manageQNA.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/manager/managerHeader.jsp" %>
	
	<section>
	<div id="tableWrap">
            <span class="title">QNA 관리</span>
            <br>
            <a href="manageQNA" class="category">전체</a>
            <a href="manageQNA?category=제품" class="category">제품</a>
            <a href="manageQNA?category=회원관리" class="category">회원관리</a>
            <a href="manageQNA?category=주문/결제" class="category">주문/결제</a>
            <a href="manageQNA?category=교환/반품" class="category">교환/반품</a>
            <a href="manageQNA?category=기타" class="category">기타</a>
            <table>
                <tr>
                    <th class="t1">분류</th>
                    <th class="t2">제목</th>
                    <th class="t3">문의자</th>
                    <th class="t4">답변자</th>
                    <th class="t5">문의일</th>
                </tr>
              	<tr class="view">
              		<td class="hidetd">1</td>
              		<td>제품</td>
              		<td>이제품은 어떻게 먹어야 하나요?</td>
              		<td class="center">wersfv</td>
              		<td class="center">yakadmin</td>
              		<td class="center">2022-01-05</td>
              	</tr>
              	
            </table>
            <br>
            <div class="page-area">
			<c:forEach var="i" begin="${paging.startPage}" end="${paging.endPage}">
				<c:if test="${i le paging.maxPage}">
					<%
					if(request.getAttribute("category") != null) {%>
						<div class="paging">
							<a class='page' href="?category=${search}&currentPage=${i}">${i}</a>
						</div>	
					<%}else { %>
						<div class="paging">
							<a class='page' href="?currentPage=${i}">${i}</a>
						</div>
					<%} %>
				</c:if>
			</c:forEach>
		</div>
        </div>
       
        
    </section>

    <script>
    window.onload=()=>{
    	$('.logoutbtn').on('click', function(){
			window.location = "/yakcook/managerlogout";
        }); 
		
    }
    </script>

</body>
</html>