<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<link rel="stylesheet" href="/yakcook/resources/css/customerService/noticeDetail.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/headerFinal.jsp" %>
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
					<td colspan=3>${NV.noticeContent}</td>
				</tr>
            </table>
    </div>    
    </section>
    <br><br><br><br>
    <br><br><br><br>
    <br><br><br><br>
    <%@ include file="/WEB-INF/views/common/footerFinal.jsp" %>
     <script>
    window.onload=()=>{
		$('.logoutbtn').on('click', function(){
			window.location = "/yakcook/managerlogout";
        });  	
	}
    </script>
</body>
</html>