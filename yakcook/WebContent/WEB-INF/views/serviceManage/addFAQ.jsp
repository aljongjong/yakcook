<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ 글쓰기</title>
<link rel="stylesheet" href="/yakcook/resources/css/serviceManage/addFAQ.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/manager/managerHeader.jsp" %>
	<section>
		<div id="tableWrap">
            <span class="title">FAQ 글쓰기</span>
            <br>
            <table>
                <tr>
                    <th class="t1"><label for="title">제목</label></th>
                    <th class="t2"><input type="text" class="insert" id="title"> </th>
                    <th class="t3">분류</th>
                    <th>
                    	<select name="category">
                    		<option value="제품" selected>제품</option>
                    		<option value="회원관리">회원관리</option>
                    		<option value="주문/결제">주문/결제</option>
                    		<option value="교환/반품">교환/반품</option>
                    		<option value="기타">기타</option>
                    	</select>
                    </th>
                </tr>
            </table>
            <br>
            <div class="btnWrap">
           		<button class="noticeBtn" id="noticeadd">등록</button>
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