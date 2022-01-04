<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<link rel="stylesheet" href="/yakcook/resources/css/serviceManage/manageNoticeDetail.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/manager/managerHeader.jsp" %>
	<section>
	<div id="tableWrap">
            <span class="title">공지사항</span>
            <br>
            <table>
                <tr>
                    <th class="t1">${NV.noticeTitle}</th>
                    <th class="t2">${NV.writeDateString()}</th>
                </tr>
				<tr class="content">
					<td colspan=2>${NV.noticeContent}</td>
				</tr>
            </table>
            <br>
            <div class="btnWrap">
            	<c:if test="${manager.managerLevel ge 2}">
					<button class="noticeBtn" id="noticemodi">수정</button>
				</c:if>
				<c:if test="${manager.managerLevel ge 3}">
					 <button class="noticeBtn" id="noticedel">삭제</button>
				</c:if>
            </div>  
    </div>    
    </section>
    <script>
    window.onload=()=>{
		$('.logoutbtn').on('click', function(){
			window.location = "/yakcook/managerlogout";
        });
		$('#noticemodi').on('click', function(){
			let url = "/yakcook/modinotice?noticeNo=${NV.noticeNo}";
			window.location = url;
		});
		$('#noticedel').on('click', function(){
        	$.ajax({
        		url : '/yakcook/delnotice',
        		method : 'get',
        		data: {
        			noticeNo : ${NV.noticeNo}
        		},
        		success : function(result){
       				const data1 = $.trim(result);
       				if(data1 == "true"){
       					alert("공지 삭제 완료");
       					window.location.replace("/yakcook/managenotice");
        			} else {
        				alert("공지 삭제 실패")
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