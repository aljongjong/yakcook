<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 목록</title>
<link rel="stylesheet" href="/yakcook/resources/css/userManage/userList.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
 	<section>
        <a href="/yakcook/userlist" id="home">유저 목록</a>
        <div id="search_tap">
        	<form action="userlist" method="get">
        		<span><label for="user_search">아이디 검색</label>&nbsp;&nbsp;
                    <input type="text" name="user_search" id="user_search">
                    <input class="btn1" type="submit" value="검색">
                </span>   
        	</form>     
        </div>
        
        <table>
            <tr>
                <th class="t1">번호</th>
                <th class="t2">아이디</th>
                <th class="t3">이름</th>
                <th class="t4">이메일</th>
                <th class="t5">전화번호</th>
                <th class="t6">강제탈퇴</th>
            </tr>
            <c:forEach items="${userList}" var="u">
			<tr>
				<td>${u.userNo}</td>
				<td>${u.userId}</td>
				<td>${u.userName}</td>
				<td>${u.userEmail}</td>
				<td>${u.userPhone}</td>
                <td><input type="button" class="delUser" value="탈퇴"></td>
			</tr>
			</c:forEach>

        </table>

		<div class="page-area">
			<c:forEach var="i" begin="${paging.startPage}" end="${paging.endPage}">
				<c:if test="${i le paging.maxPage}">
					<%
					if(request.getAttribute("search") != null) {%>
						<div class="paging">
							<a class='page' href="?user_search=${search}&currentPage=${i}">${i}</a>
						</div>
						
					<%}else { %>
						<div class="paging">
							<a class='page' href="?currentPage=${i}">${i}</a>
						</div>
					<%} %>
				</c:if>
			</c:forEach>
		</div>
		
        
    </section>

	<script>
		window.onload=()=>{
			$(document).on('click','.delUser', function(){
				let btn = $(this);
				let tr = btn.parent().parent();
				let td = tr.children();
	        	$.ajax({
	        		url : '/yakcook/userdel',
	        		method : 'get',
	        		data: {
	        			userDel : td.eq(0).text()
	        		},
	        		
	        		success : function(result){
	       				const data1 = $.trim(result);
	       				if(data1 == "true"){
	       					alert("유저 탈퇴 완료");
	       					location.reload();
	        			} else {
	        				alert("유저 탈퇴 실패")
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