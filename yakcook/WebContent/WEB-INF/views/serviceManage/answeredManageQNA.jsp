<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/yakcook/resources/css/serviceManage/manageQNA.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/manager/managerHeader.jsp" %>
	
	<section>
	<div id="tableWrap">
            <span class="title">답변완료 QNA</span>
            <span class="title" id="link">미답변 QNA로 가기</span>
            <br>
            <a href="answeredmanageqna" class="category">전체</a>
            <a href="answeredmanageqna?category=제품" class="category">제품</a>
            <a href="answeredmanageqna?category=회원관리" class="category">회원관리</a>
            <a href="answeredmanageqna?category=주문/결제" class="category">주문/결제</a>
            <a href="answeredmanageqna?category=교환/반품" class="category">교환/반품</a>
            <a href="answeredmanageqna?category=기타" class="category">기타</a>
            <table>
                <tr>
                    <th class="t1">분류</th>
                    <th class="t2">제목</th>
                    <th class="t3">문의자</th>
                    <th class="t4">답변자</th>
                    <th class="t5">문의일</th>
                </tr>
                <c:forEach items="${qnaList}" var="q">
				<tr class="view">
					<td class="hidetd">${q.qnaNo}</td>
              		<td>${q.qnaCategory}</td>
              		<td>${q.qnaTitle}</td>
              		<td class="center">${q.userId}</td>
              		<td class="center">${q.managerId}</td>
              		<td class="center">${q.writeDateString()}</td>
				</tr>
				</c:forEach>
              	
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
       
        <br><br><br><br><br>
    </section>

    <script>
    window.onload=()=>{
    	$('.logoutbtn').on('click', function(){
			window.location = "/yakcook/managerlogout";
        }); 
    	$('.view').on('click', function(){
    		let td = $(this).children();
			let number = td.eq(0).text();
			let url = "answeredqna?qnaNo=" + number;
			window.location = url;
    	});
    	$('#link').on('click', function(){
    		window.location = "/yakcook/manageQNA";
    	})
		
    }
    </script>

</body>
</html>