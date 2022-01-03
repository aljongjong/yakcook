<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="/yakcook/resources/css/manager/managerHeader.css">
<title>관리자 페이지</title>
</head>
<body>
	<header>
        <div class="headerwrap">
            <div class="logo">
                <a href="">관리자 페이지</a>
            </div>
            <div class="blank2">&nbsp</div>
            <div class="logout">
                ${manager.managerId}
                <br>
                <button type="button" class="logoutbtn">로그아웃<img src="/yakcook/resources/images/manager/shutdown.png" alt="" width="20px" height="20px"></button>
            </div>
        </div>
    </header>
    <nav>
        <div class="headerwrap">
            <ul id="navi">
                <li><a href="/yakcook/userlist">회원관리</a></li>
                <li><a href="/yakcook/taglist">태그관리</a></li>
                <li><a href="#">제품관리</a></li>
                <li><a href="/yakcook/managenotice">공지사항</a></li>
                <li><a href="/yakcook/manageFAQ">FAQ</a></li>
                <li><a href="#">1대1문의</a></li>
                <li><a href="#">리뷰관리</a></li>
                <li><a href="#">결제관리</a></li>
        </ul>
        </div>
    </nav>
   
</body>
</html>