<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>태그 목록</title>
<link rel="stylesheet" href="/yakcook/resources/css/tagManage/tagList.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
 	<section>
        <a href="/yakcook/taglist" id="home">태그 목록</a>
        <div id="search_tap">
        	<form action="taglist" method="get">
        		<span><label for="tag_search">태그 검색</label>&nbsp;&nbsp;
                    <input type="text" name="tag_search" id="tag_search">
                    <input class="btn1" type="submit" value="검색">
                </span>   
        	</form>     
        </div>
        
        <table>
            <tr>
                <th class="t1">태그 번호</th>
                <th class="t2">태그 이름</th>
                <th class="t3">수정</th>
                <th class="t4">삭제</th>
            </tr>
            <c:forEach items="${tagList}" var="t">
			<tr>
				<td>${t.tagNo}</td>
				<td>${t.tagName}</td>
				<td><input type="button" class="modiTag" value="수정"></td>
                <td><input type="button" class="delTag" value="삭제"></td>
			</tr>
			</c:forEach>

        </table>
        <div id="write_tap">
            <button class="btn1" id="addTag">태그 추가</button>
        </div>

		<div class="page-area">
			<c:forEach var="i" begin="${paging.startPage}" end="${paging.endPage}">
				<c:if test="${i le paging.maxPage}">
					<%
					if(request.getAttribute("search") != null) {%>
						<div class="paging">
							<a class='page' href="?tag_search=${search}&currentPage=${i}">${i}</a>
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
			$(document).on('click', '#addTag',function(){
				farwindow1 = window.open("/yakcook/tagadd", "태그 추가", "width=550, height=300, toolbar=no, menubar=no, scrollbars=no, resizable=no");
				if (farwindow1 != null) {
					if (farwindow.opener1 == null) {
						farwindow.opener1 = self;
					}
				}
			});
		
			$(document).on('click', '.modiTag', function(){
				let btn = $(this);
				let tr = btn.parent().parent();
				let td = tr.children();
				let url = "/yakcook/tagmodi?tagNum=" +  td.eq(0).text();
				farwindow2 = window.open(url, "태그 수정", "width=550, height=300, toolbar=no, menubar=no, scrollbars=no, resizable=no");
				if (farwindow2 != null) {
					if (farwindow2.opener == null) {
						farwindow2.opener = self;
					}
				}
			});
			$(document).on('click','.delTag', function(){
				let btn = $(this);
				let tr = btn.parent().parent();
				let td = tr.children();
	        	$.ajax({
	        		url : '/yakcook/tagdel',
	        		method : 'get',
	        		data: {
	        			tagDel : td.eq(0).text()
	        		},
	        		
	        		success : function(result){
	       				const data1 = $.trim(result);
	       				if(data1 == "true"){
	       					alert("태그 삭제 완료");
	       					location.reload();
	        			} else {
	        				alert("태그 삭제 실패")
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