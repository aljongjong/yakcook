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
            <a href="paymentdetail?pay_search=결제중&category=status" class="category">결제중</a>
            <a href="paymentdetail?pay_search=결제완료&category=status" class="category">결제완료</a>
            <a href="paymentdetail?pay_search=배송준비&category=status" class="category">배송준비</a>
            <a href="paymentdetail?pay_search=배송중&category=status" class="category">배송중</a>
            <a href="paymentdetail?pay_search=배송완료&category=status" class="category">배송완료</a>
            <a href="paymentdetail?pay_search=환불&category=status" class="category">환불</a>
            <br>
            <div id="search_tap">
        	<form action="paymentdetail" method="get">
        		<span><label for="pay_search">주문 기록 검색</label>&nbsp;&nbsp;
        			<select name="category">
        				<option value="USER_ID" selected>아이디</option>
        				<option value="ORDER_NAME">이름</option>
        				<option value="ORDER_NO">주문번호</option>
        				<option value="ORDER_PHONE">전화번호</option>
        			</select>
                    <input type="text" name="pay_search" id="pay_search" required>
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
                <c:forEach items="${payList}" var="p">
				<tr class="view">
					<td class="center">${p.orderNo}</td>
					<td class="center">
					${p.userId}<br>
					${p.userName}<br>
					${p.userPhone}
					</td>
					<td class="small">
					우편번호 ${p.postNo} <br>
					${p.address} <br>
					${p.detailAddress} <br>
					${p.extraAddress}  <br>
					메모 <br>
					${p.memo} / ${p.memoInput} 
					</td>
					<td class="small">
					결제 방식 : ${p.payMethod} <br>
					<c:forEach items="${p.payProduct}" var="t">
					${t.productName} / ${t.quantity}개<br>
					</c:forEach>
					총 금액 : ${p.getTotalAll()}
					</td>
					<td class="center">
					${p.writeDateString()}
					</td>
					<td class="center">
						${p.status}
						<select id="status" name="status">
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
				</c:forEach>
				
            </table>
            <br>
           <div class="page-area">
			<c:forEach var="i" begin="${paging.startPage}" end="${paging.endPage}">
				<c:if test="${i le paging.maxPage}">
						
					<%if(request.getAttribute("search") != null){ %>
						<div class="paging">
							<a class='page' href="?pay_search=${search}&category=${category}&currentPage=${i}">${i}</a>
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
		$(document).on('click','.statusBtn', function(){
			let btn = $(this);
			let tr = btn.parent().parent();
			let td = tr.children();
        	$.ajax({
        		url : '/yakcook/statusupdate',
        		method : 'get',
        		data: {
        			orderNo : td.eq(0).text(),
        			status : $(this).siblings('#status').val()
        		},
        		
        		success : function(result){
       				const data1 = $.trim(result);
       				if(data1 == "true"){
       					alert("상태 수정 완료");
       					location.reload();
        			} else {
        				alert("상태 수정 실패")
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