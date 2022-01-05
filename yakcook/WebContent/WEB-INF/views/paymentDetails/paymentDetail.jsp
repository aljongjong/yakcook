<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>결제 목록</title>
<link rel="stylesheet" href="/yakcook/resources/css/paymentDetail/paymentDetail.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/manager/managerHeader.jsp" %>
	
	<section>
	<div id="tableWrap">
            <span class="title">결제 목록</span>
            <br>
            
            <a href="paymentdetail" class="category">전체</a>
            <a href="paymentdetail?category=결제중" class="category">결제완료</a>
            <a href="paymentdetail?category=결제완료" class="category">결제완료</a>
            <a href="paymentdetail?category=배송준비" class="category">배송준비</a>
            <a href="paymentdetail?category=배송중" class="category">배송중</a>
            <a href="paymentdetail?category=배송완료" class="category">배송완료</a>
            <a href="paymentdetail?category=환불" class="category">환불</a>
            <br>
            <div id="search_tap">
        	<form action="paymentdetail" method="get">
        		<span><label for="pay_search">주문 기록 검색</label>&nbsp;&nbsp;
        			<select name="status">
        				<option value="USER_ID" selected>아이디</option>
        				<option value="ORDER_NAME">이름</option>
        				<option value="ORDER_NO">주문번호</option>
        				<option value="ORDER_PHONE">전화번호</option>
        			</select>
                    <input type="text" name="pay_search" id="pay_search">
                    <input class="btn1" type="submit" value="검색">
                </span>   
        	</form>     
        	</div>
            <table>
                <tr>
                    <th class="t1">번호</th>
                    <th class="t2">구매자 정보</th>
                    <th class="t3">주소</th>
                    <th class="t4">주문제품</th>
                    <th class="t5">주문일자</th>
                    <th class="t6">주문상태</th>

                </tr>
				<tr class="view">
					<td class="center">1</td>
					<td class="center">
					wersfv<br>
					박재한<br>
					01046669408
					</td>
					<td class="small">
					경기도 안성시 남파로 130 쌍용아파트 <br>
					101동 605호 <br>
					안성시, 쌍용아파트 <br>
					부재시 문 앞에 놔주세요 <br>
					문 앞에 놔주세요
					</td>
					<td class="small">
					California Gold Nutrition, 프로바이오틱스/4개 <br>
					California Gold Nutrition, 비타민B 복합체 구미젤리/12개 <br>
					총 금액 : 150000
					</td>
					<td class="center">
					2022-01-05
					</td>
					<td class="center">
						결제중
						<select name="status">
							<option value="결제완료">결제완료</option>
							<option value="배송준비">배송준비</option>
							<option value="배송중">배송중</option>
							<option value="배송완료">배송완료</option>
							<option value="환불">환불</option>
						</select>
						<br>
						<button class="statusBtn">상태 변경</button>
					</td>
				</tr>
            </table>
            <br>
           <div class="page-area">
			<c:forEach var="i" begin="${paging.startPage}" end="${paging.endPage}">
				<c:if test="${i le paging.maxPage}">
					<%
					if(request.getAttribute("category") != null) {%>
						<div class="paging">
							<a class='page' href="?category=${category}&currentPage=${i}">${i}</a>
						</div>	
						
					<%}else if(request.getAttribute("search") != null){ %>
						<div class="paging">
							<a class='page' href="?pay_search=${search}&currentPage=${i}">${i}</a>
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
		$(document).on('click','.delFAQ', function(){
			let btn = $(this);
			let tr = btn.parent().parent();
			let td = tr.children();
        	$.ajax({
        		url : '/yakcook/delFAQ',
        		method : 'get',
        		data: {
        			FAQDel : td.eq(0).text()
        		},
        		
        		success : function(result){
       				const data1 = $.trim(result);
       				if(data1 == "true"){
       					alert("FAQ 삭제 완료");
       					location.reload();
        			} else {
        				alert("FAQ 삭제 실패")
        			}	
        		},
        		error : function(err){
        			alert("error");
        		}
        	});
        });  
    }
    </script>

</body>
</html>