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
</head>
<body>
	<body>
        <div class="wrapper">
            <div class="search-input">
                <input type="text" placeholder="태그 키워드를 검색해보세요!">
                <div class="autocom-box">
                </div>
                <div class="icon"><i class="fas fa-search"></i></div>
            </div>
        </div>
        <% int i = 0; %>
        <c:forEach items="${tagList}" var="tl">
        	<input type="hidden" id="tN<%=i%>" value="${tl.tagName}">
        	<% i++; %>
        </c:forEach>
        

        <script>
        	
        	
	        let suggestions = [];
	        for ( let i = 0; i < "<c:out value='${tagList.size()}'/>"; i++) {
	        	
	        	suggestions.push()
			}
        </script>
        <script src="/yakcook/resources/js/tagSearchBar/script.js"></script>

    </body>
</body>
</html>