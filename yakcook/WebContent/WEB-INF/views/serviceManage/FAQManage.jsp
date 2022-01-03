<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>FAQ 목록</title>
<link rel="stylesheet" href="/yakcook/resources/css/customerService/FAQ.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<section>
	<div id="tableWrap">
            <span class="title">자주 찾는 질문 FAQ</span>
            <br>
            <a href="FAQ" class="category">전체</a>
            <a href="FAQ?category=제품" class="category">제품</a>
            <a href="FAQ?category=회원관리" class="category">회원관리</a>
            <a href="FAQ?category=주문/결제" class="category">주문/결제</a>
            <a href="FAQ?category=교환/반품" class="category">교환/반품</a>
            <a href="FAQ?category=기타" class="category">기타</a>
            <table>
                <tr>
                    <th class="t1">분류</th>
                    <th class="t2">제목</th>
                </tr>
                <c:forEach items="${faqList}" var="f">
				<tr class="view">
					<td>${f.category}</td>
					<td>${f.faqTitle}</td>
				</tr>
				<tr class="content">
					<td colspan="2">${f.faqContent}</td>
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
       
        
    </section>

    <script>
    window.onload=()=>{
    	$('.view').on('click', function(){
    		let view = $(this);
			let changer = view.next();
    		if ( changer.css('display') === 'none' ) { 
    			changer.show();
    		} else { 
    			changer.hide();
    		}

    	})
    }
    </script>
</body>
</html>