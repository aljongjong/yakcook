<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>태그 검색 창</title>
<link rel="stylesheet" href="/yakcook/resources/css/tagSearchBar/tagSearchBar.css">
<script src="https://kit.fontawesome.com/77be500183.js" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<body>
        <div class="wrapper">
        	<div class="yakcook-logo">
        		<img src="resources/images/product/logoGreen.png">
        	</div>
        	<div class="info-searchBar">
        		<p>
        			약cook의 태그 검색 기능으로 원하는 상품을 빠르게 검색해보세요!<br>
        			(브랜드명, 영양제 종류, 섭취 형태 등 다양한 검색 키워드를 제공합니다)
       			</p>
        	</div>
            <div class="search-input">
            <form action="tagSearchProduct" method="GET">
                <input type="text" placeholder="태그 키워드를 검색해보세요!" name="tagName">            
                <div class="autocom-box">
                </div>
                <div class="icon"><button type="submit" id="searchBtn"><i class="fas fa-search"></i></button></div>
            </form>
            </div>
        </div>
        
        
        <div id="layer_bg"></div>
        
        <% int i = 0; %>
        <c:forEach items="${tagList}" var="tl">
        	<input type="hidden" id="tN<%=i%>" value="${tl.tagName}">
        	<% i++; %>
        </c:forEach>
        
        <script>
	        let suggestions = [];
	        for ( let i = 0; i < "<c:out value='${tagList.size()}'/>"; i++) {
	        	let TagNo = document.getElementById("tN" + i);
	        	suggestions.push(TagNo.value);
			}
        </script>
        <script src="/yakcook/resources/js/tagSearchBar/script.js"></script>

    </body>
</body>
</html>