<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>태그 검색 결과 페이지</title>
<link rel="stylesheet" href="/yakcook/resources/css/product/searchProduct.css">
<script src="https://kit.fontawesome.com/77be500183.js" crossorigin="anonymous"></script>
</head>
<body>
	<div class="wrapTagSearch">
        <div class="categoryHorizon">
            <div class="categoryHorizon_title" style="display:inline">#태그 검색 결과 : <span> ${tagName}</span></div>
        </div>
        
        <c:forEach items="${tagSearchList}" var="ts" begin="0" end="25">
           	<div class="tagSearch_product" style="width:18%">
                <div class="sp_photo">
                <c:forEach items="${productImgList}" var="pi">
                	<c:if test="${ts.productNo eq pi.productNo}">
                		<img src="upload/product/${pi.productImgName}">
                	</c:if>
                </c:forEach>
                </div>
<!-- 세션에 로그인 유저 있을 경우 -->	<c:if test="${loginUser != null}"></c:if>
<!-- 세션에 로그인 유저 없을 경우 -->	<c:if test="${loginUser == null}">
								<!-- 로그인이 필요합니다. 로그인 창으로 이동하시겠습니까? -->
								</c:if>
                <div class="sb">
                	<form action="shoppingBasket" method="POST" style="display:inline;">
                		<input type="hidden" name="productNo" value="${ts.productNo}">
	                	<input type="hidden" name="price" value="${ts.price}">
	                	<input type="hidden" name="amount" value="1" id="toSBamount">
	                	<input type="hidden" name="categoryNo" value="${ts.categoryNo}">
	                	<input type="hidden" name="productName" value="${ts.productName}">
                    	<button type="submit" id="searchToShoppingBasketBtn"><i class="fas fa-cart-plus"></i><span> 장바구니 담기</span></button>
                	</form>
                </div>
                <div class="sp_name_price">
	                <div>
		                <form action="detailsProduct" method="POST" style="display:inline-block; float:left">
		                	<input type="hidden" name="productNo" value="${ts.productNo}">
		                	<input type="hidden" name="price" value="${ts.price}">
		                	<input type="hidden" name="categoryDate" value="${ts.categoryDate}">
		                	<input type="hidden" name="productContents" value="${ts.productContents}">
		                	<input type="hidden" name="productDelete" value="${ts.productDelete}">
		                	<input type="hidden" name="lasteditDate" value="${ts.lasteditDate}">
		                	<input type="hidden" name="inventory" value="${ts.inventory}">
		                	<input type="hidden" name="categoryNo" value="${ts.categoryNo}">
		                    <input type="submit" name="productName" value="${ts.productName}" id="searchProductTodetails">
		                </form>
	                </div>
	                <div>
	                    <a style="float:right">${ts.price}원</a>
	                </div>
                </div>
                <!-- 각 제품에 부여된 태그 조인해서 가져오기 -->
                <c:forEach items="${tagProductList}" var="tp">
                	<c:if test="${ts.productNo eq tp.productNo}">
		                <div class="sp_tag">
		                	<form action="tagSearchProduct" method="GET" style="display:inline-block; float:left">
		                		<c:if test="${tp.tagName eq tagName}">
			                		<input type="hidden" name="tagName" value="${tp.tagName}">
			                    	<button style="background: rgb(108, 128, 75); height: 32px; transform: translateY(-3px);" type="submit">#${tp.tagName}</button>
		                		</c:if>
		                		<c:if test="${tp.tagName != tagName}">
			                		<input type="hidden" name="tagName" value="${tp.tagName}">
			                    	<button type="submit">#${tp.tagName}</button>
		                    	</c:if>
		                	</form>
		                </diV>
                	</c:if>		                
                </c:forEach>
           	</div>
      	</c:forEach>
	</div>
</body>
</html>