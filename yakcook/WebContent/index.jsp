<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>약cook</title>
<link rel="stylesheet" href="resources/css/common/mainPage.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
#infoHompage
{
	background-image: url(resources/images/common/bg.jpg);
}
</style>
</head>
<body>
		<%@ include file="/WEB-INF/views/common/headerFinal.jsp" %>
        <div class="mainWrap">
            
            <section id="banner">
                <div id="slideList">
                    <div class="slideImg">
                        <img src="resources/images/common/imgSlide1.jpeg" alt="배너1">
                    </div>
                    <div class="slideImg">
                        <img src="resources/images/common/imgSlide2.jpeg" alt="배너2">
                    </div>
                    <div class="slideImg">
                        <img src="resources/images/common/imgSlide3.jpeg" alt="배너3">
                    </div>
                </div>
            </section>

            <section id="infoHompage">

                <div id="logoAndButton">
                    <ul>
                        <li><img src="resources/images/common/logoWhite.png"></li>
                        <li><a href="searchProduct">제품 구경하기</a></li>
                    </ul>
                </div>
                <div id="sentence1">
                    <ul>
                        <li>건강을 위한 한 스푼, <span>약cook</span>과 함께하세요!</li>
                        <li><img src="resources/images/common/bgProduct.png"></li>
                        <li>일상에 활력을 가득 담아 줄 영양제를 한가득 준비했습니다!</li>
                    </ul>
                </div>

            </section>

            <section id="infoTagSearch">

                <div id="sentence2">
                    <ul>
                        <li>어떻게 영양제를 찾아야 할지 고민이신가요?<br>
                            <span>태그 검색</span>을 이용해보세요!</li>
                        <li><img src="resources/images/common/bgTagSearch.png"></li>
                        <li>고객님이 원하는 영양제를 쉽고 빠르게 찾아보세요!</li>
                    </ul>
                </div>

                <div id="PicAndButton">
                    <ul>
                        <li><img src="resources/images/common/bgTagSearch2.png"></li>
                        <li><a href="tagSearchBar">태그 검색하기</a></li>
                    </ul>

                </div>

            </section>
        </div>
        <script>
            var slideCount = $(".slideImg").length
            var currentIndex = 0;
            var slidePosition;

            setInterval(function() {
                if(currentIndex < slideCount -1) {
                    currentIndex++;
                } else {
                    currentIndex = 0;
                }

                slidePosition = currentIndex * (-1200)+"px";
                $("#slideList").animate({left:slidePosition}, 500);
            }, 4000);
        </script>
        <%@ include file="/WEB-INF/views/common/footerFinal.jsp" %>
    </body>
</html>