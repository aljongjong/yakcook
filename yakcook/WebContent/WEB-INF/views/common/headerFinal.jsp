<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
<script src="https://kit.fontawesome.com/77be500183.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="resources/css/common/header.css">
</head>
<body>
        <div class="headerWrap" id="header">
            <div class="headerlogo">
                <a href="#"><img src="resources/images/common/logoGreen.png" alt="로고" class="default" id="img"></a>
                <a href="#"><img src="resources/images/common/logoWhite.png" alt="로고"></a>
            </div>

            <div class="headerCategory">
                <div class="userInterface">
                    <ul>
                        <li><a href="loginForm">로그인</a></li>
                        <li><a href="profileForm">마이페이지</a></li>
                        <li><a href="#"><i class="fas fa-shopping-cart"></i></a></li>
                    </ul>
                </div>
                <div class="hompageInterface">
                    <ul>
                        <li><a href="tagSearchBar">태그 검색 <i class="fas fa-search"></i></a></li>
                        <li><a href="searchProduct">제품 보기</a></li>
                        <li><a href="review">상품 후기</a></li>
                        <li><a href="#">고객 센터</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div style="width:100%; height:180px"></div>
    <script>

        window.addEventListener('scroll', function(){
            const header = document.getElementById('header');
            header.classList.toggle("sticky", window.scrollY > 0);
        });
        window.addEventListener('scroll', function(){
            const img = document.getElementById('img');
            img.classList.toggle("img", window.scrollY > 0);
        });

    </script>
    </body>
</html>