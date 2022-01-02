<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 조회</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/product/searchProduct.css">
<script src="https://kit.fontawesome.com/77be500183.js" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
    <div class="wrap">
        <div class="category">
            <div class="category_title">상세 메뉴</div>
            <div class="category_content">
                <ul>
                    <!-- 반복문, 카테고리 테이블에서 데이터 가져옴 -->
                    <c:if test="${categoryNo == null}">
                    	<li><a class="active" href="searchProduct">전체 상품<i class="far fa-check-circle"></i></a></li>                    
                    </c:if>
                    <c:if test="${categoryNo != null}">
                    	<li><a class="" href="searchProduct">전체 상품<i class="far fa-check-circle"></i></a></li>                    
                    </c:if>
                    <c:forEach items="${categoryList}" var="c">
      					<c:if test="${c.categoryNo == categoryNo}">
                    		<li><a class="active" href="searchProduct?categoryNo=${c.categoryNo}">${c.categoryName}<i class="far fa-check-circle"></i></a></li>
      					</c:if>
      					<c:if test="${c.categoryNo != categoryNo}">
                    		<li><a href="searchProduct?categoryNo=${c.categoryNo}">${c.categoryName}</a></li>
      					</c:if>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="products">
            <div class="p_title_range">
                <div class="p_title">
                	<c:if test="${categoryNo == null}">
	                	<a>전체 상품</a>
                	</c:if>
                	<c:if test="${categoryNo != null}">
	                	<c:forEach items="${categoryList}" var="c">
	                		<c:if test="${c.categoryNo == categoryNo}">
	                			<a>${c.categoryName}</a>
	                		</c:if>
	                	</c:forEach>
                	</c:if>
                </div>
                
                <div class="p_range">
                    <label for="panel-label">정렬 : </label>
                    <form action="searchProduct" style="display:inline;">
	                    <select name="range" id="range">
	                    <c:if test="${range == 0 || range == 1}">
	                    	<option value="1" selected="selected">등록순</option>
	                        <option value="2">최신순</option>
	                        <option value="3">가격 낮은 순</option>
	                        <option value="4">가격 높은 순</option>
	                    </c:if>
	                    <c:if test="${range == 2}">
	                    	<option value="1">등록순</option>
	                        <option value="2" selected="selected">최신순</option>
	                        <option value="3">가격 낮은 순</option>
	                        <option value="4">가격 높은 순</option>
	                    </c:if>
	                    <c:if test="${range == 3}">
	                    	<option value="1">등록순</option>
	                        <option value="2">최신순</option>
	                        <option value="3" selected="selected">가격 낮은 순</option>
	                        <option value="4">가격 높은 순</option>
	                    </c:if>
	                    <c:if test="${range == 4}">
	                    	<option value="1">등록순</option>
	                        <option value="2">최신순</option>
	                        <option value="3">가격 낮은 순</option>
	                        <option value="4" selected="selected">가격 높은 순</option>
	                    </c:if>
	                        
	                    </select>
     					<button type="submit" class="rp_btn"><span>조회 </span><i class="fas fa-search"></i></button>
                    </form>
                </div>
            </div>
            
            <!-- 제품, 제품이미지, 태그 테이블 데이터 -->
            <c:if test="${categoryNo == null}">
            	<c:if test="${range == 0}">
	           		<c:forEach items="${nextPageList}" var="np" begin="0" end="16">
			            	<div class="search_product">
				                <div class="sp_photo">
				                <c:forEach items="${productImgList}" var="pi">
				                	<c:if test="${np.productNo eq pi.productNo}">
				                		<img src="upload/product/${pi.productImgName}">
				                	</c:if>
				                </c:forEach>
				                </div>
				                <div class="sb">
				                	<form action="shoppingBasket" method="POST" style="display:inline;">
				                		<input type="hidden" name="productNo" value="${np.productNo}">
					                	<input type="hidden" name="price" value="${np.price}">
					                	<input type="hidden" name="amount" value="1" id="toSBamount">
					                	<input type="hidden" name="categoryNo" value="${np.categoryNo}">
					                	<input type="hidden" name="productName" value="${np.productName}">
				                    	<button type="submit" id="searchToShoppingBasketBtn"><i class="fas fa-cart-plus"></i><span> 장바구니 담기</span></button>
				                	</form>
				                </div>
				                <div class="sp_name_price">
				                
				                <form action="detailsProduct" method="POST" style="display:inline-block; float:left">
				                	<input type="hidden" name="productNo" value="${np.productNo}">
				                	<input type="hidden" name="price" value="${np.price}">
				                	<input type="hidden" name="categoryDate" value="${np.categoryDate}">
				                	<input type="hidden" name="productContents" value="${np.productContents}">
				                	<input type="hidden" name="productDelete" value="${np.productDelete}">
				                	<input type="hidden" name="lasteditDate" value="${np.lasteditDate}">
				                	<input type="hidden" name="inventory" value="${np.inventory}">
				                	<input type="hidden" name="categoryNo" value="${np.categoryNo}">
				                    <input type="submit" name="productName" value="${np.productName}" id="searchProductTodetails">
				                </form>
				                    <a style="float:right">${np.price}원</a>
				                </div>
				                <!-- 각 제품에 부여된 태그 조인해서 가져오기 -->
				                <c:forEach items="${tagProductList}" var="tp">
				                	<c:if test="${np.productName eq tp.productName}">
						                <div class="sp_tag">
						                	<form action="tagSearchProduct" method="GET" style="display:inline-block; float:left">
						                		<input type="hidden" name="tagName" value="${tp.tagName}">
						                    	<button type="submit">#${tp.tagName}</button>
						                	</form>
						                </diV>
				                	</c:if>		                
				                </c:forEach>
			            	</div>
	            	</c:forEach>
            	</c:if>
            	<c:if test="${range > 0}">
            		<c:forEach items="${nextPageList}" var="np" begin="0" end="16">
			            	<div class="search_product">
				                <div class="sp_photo">
				                    <c:forEach items="${productImgList}" var="pi">
				                	<c:if test="${np.productNo eq pi.productNo}">
				                		<img src="upload/product/${pi.productImgName}">
				                	</c:if>
				                </c:forEach>
				                </div>
				                <div class="sb">
				                    <form action="shoppingBasket" method="POST" style="display:inline;">
				                		<input type="hidden" name="productNo" value="${np.productNo}">
					                	<input type="hidden" name="price" value="${np.price}">
					                	<input type="hidden" name="amount" value="1" id="toSBamount">
					                	<input type="hidden" name="categoryNo" value="${np.categoryNo}">
					                	<input type="hidden" name="productName" value="${np.productName}">
				                    	<button type="submit" id="searchToShoppingBasketBtn"><i class="fas fa-cart-plus"></i><span> 장바구니 담기</span></button>
				                	</form>
				                </div>
				                <div class="sp_name_price">
			                    <form action="detailsProduct" method="POST" style="display:inline-block; float:left">
				                	<input type="hidden" name="productNo" value="${np.productNo}">
				                	<input type="hidden" name="price" value="${np.price}">
				                	<input type="hidden" name="categoryDate" value="${np.categoryDate}">
				                	<input type="hidden" name="productContents" value="${np.productContents}">
				                	<input type="hidden" name="productDelete" value="${np.productDelete}">
				                	<input type="hidden" name="lasteditDate" value="${np.lasteditDate}">
				                	<input type="hidden" name="inventory" value="${np.inventory}">
				                	<input type="hidden" name="categoryNo" value="${np.categoryNo}">
				                    <input type="submit" name="productName" value="${np.productName}" id="searchProductTodetails">
				                </form>
				                    <a style="float:right">${np.price}</a>
				                </div>
				                <!-- 각 제품에 부여된 태그 조인해서 가져오기 -->
				                <c:forEach items="${tagProductList}" var="tp">
				                	<c:if test="${np.productName eq tp.productName}">
						                <div class="sp_tag">
						                	<form action="tagSearchProduct" method="GET" style="display:inline-block; float:left">
						                		<input type="hidden" name="tagName" value="${tp.tagName}">
						                    	<button type="submit">#${tp.tagName}</button>
						                	</form>
						                </diV>
				                	</c:if>		                
				                </c:forEach>
			            	</div>
	            	</c:forEach>
            	</c:if>
            </c:if>
            
            <c:if test="${categoryNo != null}">
           		<c:if test="${range == 0}">
	           	<c:forEach items="${categoryProductList}" var="cp" begin="0" end="16">
	            	<div class="search_product">
		                <div class="sp_photo">
		                    <c:forEach items="${productImgList}" var="pi">
			                	<c:if test="${cp.productNo eq pi.productNo}">
			                		<img src="upload/product/${pi.productImgName}">
			                	</c:if>
			                </c:forEach>
		                </div>
		                <div class="sb">
		                   <form action="shoppingBasket" method="POST" style="display:inline;">
		                		<input type="hidden" name="productNo" value="${cp.productNo}">
			                	<input type="hidden" name="price" value="${cp.price}">
			                	<input type="hidden" name="amount" value="1" id="toSBamount">
			                	<input type="hidden" name="categoryNo" value="${cp.categoryNo}">
			                	<input type="hidden" name="productName" value="${cp.productName}">
		                    	<button type="submit" id="searchToShoppingBasketBtn"><i class="fas fa-cart-plus"></i><span> 장바구니 담기</span></button>
		                	</form>
		                </div>
		                <div class="sp_name_price">
	                     <form action="detailsProduct" method="POST" style="display:inline-block; float:left">
			                	<input type="hidden" name="productNo" value="${cp.productNo}">
			                	<input type="hidden" name="price" value="${cp.price}">
			                	<input type="hidden" name="categoryDate" value="${cp.categoryDate}">
			                	<input type="hidden" name="productContents" value="${cp.productContents}">
			                	<input type="hidden" name="productDelete" value="${cp.productDelete}">
			                	<input type="hidden" name="lasteditDate" value="${cp.lasteditDate}">
			                	<input type="hidden" name="inventory" value="${cp.inventory}">
			                	<input type="hidden" name="categoryNo" value="${cp.categoryNo}">
			                    <input type="submit" name="productName" value="${cp.productName}" id="searchProductTodetails">
		                </form>
		                    <a style="float:right">${cp.price}</a>
		                </div>
		                <!-- 각 제품에 부여된 태그 조인해서 가져오기 -->
		                <c:forEach items="${tagProductList}" var="tp">
		                	<c:if test="${np.productName eq tp.productName}">
				                <div class="sp_tag">
				                	<form action="tagSearchProduct" method="GET" style="display:inline-block; float:left">
				                		<input type="hidden" name="tagName" value="${tp.tagName}">
				                    	<button type="submit">#${tp.tagName}</button>
				                	</form>
				                </diV>
		                	</c:if>		                
		                </c:forEach>
	            	</div>
	           	</c:forEach>
	           	</c:if>
	           	<c:if test="${range > 0}">
	           	<c:forEach items="${categoryProductList}" var="cp" begin="0" end="16">
	            	<div class="search_product">
		                <div class="sp_photo">
		                    <c:forEach items="${productImgList}" var="pi">
			                	<c:if test="${cp.productNo eq pi.productNo}">
			                		<img src="upload/product/${pi.productImgName}">
			                	</c:if>
			                </c:forEach>
		                </div>
		                <div class="sb">
		                   <form action="shoppingBasket" method="POST" style="display:inline;">
		                		<input type="hidden" name="productNo" value="${cp.productNo}">
			                	<input type="hidden" name="price" value="${cp.price}">
			                	<input type="hidden" name="amount" value="1" id="toSBamount">
			                	<input type="hidden" name="categoryNo" value="${cp.categoryNo}">
			                	<input type="hidden" name="productName" value="${cp.productName}">
		                    	<button type="submit" id="searchToShoppingBasketBtn"><i class="fas fa-cart-plus"></i><span> 장바구니 담기</span></button>
		                	</form>
		                </div>
		                <div class="sp_name_price">
	                     <form action="detailsProduct" method="POST" style="display:inline-block; float:left">
			                	<input type="hidden" name="productNo" value="${cp.productNo}">
			                	<input type="hidden" name="price" value="${cp.price}">
			                	<input type="hidden" name="categoryDate" value="${cp.categoryDate}">
			                	<input type="hidden" name="productContents" value="${cp.productContents}">
			                	<input type="hidden" name="productDelete" value="${cp.productDelete}">
			                	<input type="hidden" name="lasteditDate" value="${cp.lasteditDate}">
			                	<input type="hidden" name="inventory" value="${cp.inventory}">
			                	<input type="hidden" name="categoryNo" value="${cp.categoryNo}">
			                    <input type="submit" name="productName" value="${cp.productName}" id="searchProductTodetails">
		                </form>
		                    <a style="float:right">${cp.price}</a>
		                </div>
		                <!-- 각 제품에 부여된 태그 조인해서 가져오기 -->
		                <c:forEach items="${tagProductList}" var="tp">
		                	<c:if test="${np.productName eq tp.productName}">
				                <div class="sp_tag">
				                	<form action="tagSearchProduct" method="GET" style="display:inline-block; float:left">
				                		<input type="hidden" name="tagName" value="${tp.tagName}">
				                    	<button type="submit">#${tp.tagName}</button>
				                	</form>
				                </diV>
		                	</c:if>		                
		                </c:forEach>
	            	</div>
	           	</c:forEach>
	           	</c:if>
            </c:if>
            <!-- fas아이콘 한페이지씩 이동 , 선택 페이지 넘버 fontweight 900, ...뒤 마지막 페이지 넘버 나오게, 선택 페이지 앞뒤 넘버 2개씩 보이게 하기  -->
            <div class="paging">
                <ul>
                	<c:if test="${cp != null && categoryNo == null && cp != 1 && range == 0}">
                    	<li><a href="searchProduct?currentPage=${cp - 1}"><i class="fas fa-chevron-circle-left"></i></a></li>
                	</c:if>
                	<c:if test="${cp != null && categoryNo != null && cp != 1 && range == 0}">
                    	<li><a href="searchProduct?categoryNo=${categoryNo}&currentPage=${cp - 1}"><i class="fas fa-chevron-circle-left"></i></a></li>
                	</c:if>
                	<c:if test="${cp != null && categoryNo == null && cp != 1 && range != 0}">
                    	<li><a href="searchProduct?range=${range}&currentPage=${cp - 1}"><i class="fas fa-chevron-circle-left"></i></a></li>
                	</c:if>
                	<c:if test="${cp != null && categoryNo != null && cp != 1 && range != 0}">
                    	<li><a href="searchProduct?categoryNo=${categoryNo}&range=${range}&currentPage=${cp - 1}"><i class="fas fa-chevron-circle-left"></i></a></li>
                	</c:if>
                    
                    <c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
	                    <c:if test="${i <= maxPage}">
		                    <c:if test="${categoryNo == null && range == 0}">
		                    	<c:if test="${cp == i}">
			                    	<li><a class="active" href="searchProduct?currentPage=${i}">${i}</a></li>
		                    	</c:if>
		                    	<c:if test="${cp != i}">
			                    	<li><a href="searchProduct?currentPage=${i}">${i}</a></li>
		                    	</c:if>
	                    	</c:if>
		                    <c:if test="${categoryNo == null && range != 0}">
		                    	<c:if test="${cp == i}">
			                    	<li><a class="active" href="searchProduct?range=${range}&currentPage=${i}">${i}</a></li>
		                    	</c:if>
		                    	<c:if test="${cp != i}">
			                    	<li><a href="searchProduct?range=${range}&currentPage=${i}">${i}</a></li>
		                    	</c:if>
	                    	</c:if>
	                    	<c:if test="${categoryNo != null && range == 0}">
	                    		<c:if test="${cp == i}">
			                    	<li><a class="active" href="searchProduct?categoryNo=${categoryNo}&currentPage=${i}">${i}</a></li>	   
		                    	</c:if>
		                    	<c:if test="${cp != i}">
			                    	<li><a href="searchProduct?categoryNo=${categoryNo}&currentPage=${i}">${i}</a></li>	   
		                    	</c:if>     	                    	
	                    	</c:if>
	                    	<c:if test="${categoryNo != null && range != 0}">
	                    		<c:if test="${cp == i}">
			                    	<li><a class="active" href="searchProduct?categoryNo=${categoryNo}&range=${range}&currentPage=${i}">${i}</a></li>	   
		                    	</c:if>
		                    	<c:if test="${cp != i}">
			                    	<li><a href="searchProduct?categoryNo=${categoryNo}&range=${range}&currentPage=${i}">${i}</a></li>	   
		                    	</c:if>     	                    	
	                    	</c:if>
	                    </c:if>
                    </c:forEach>
                    <c:if test="${cp != null && categoryNo == null && cp != maxPage && range == 0}">
                    	<li><a href="searchProduct?currentPage=${cp + 1}"><i class="fas fa-chevron-circle-right"></i></a></li>
                	</c:if>
                	<c:if test="${cp != null && categoryNo != null && cp != maxPage && range == 0}">
                    	<li><a href="searchProduct?categoryNo=${categoryNo}&currentPage=${cp + 1}"><i class="fas fa-chevron-circle-right"></i></a></li>
                	</c:if>
                	<c:if test="${cp != null && categoryNo == null && cp != maxPage && cp != 1 && range != 0}">
                    	<li><a href="searchProduct?range=${range}&currentPage=${cp + 1}"><i class="fas fa-chevron-circle-right"></i></a></li>
                	</c:if>
                	<c:if test="${cp != null && categoryNo != null && cp != 1 && range != 0}">
                    	<li><a href="searchProduct?categoryNo=${categoryNo}&range=${range}&currentPage=${cp + 1}"><i class="fas fa-chevron-circle-right"></i></a></li>
                	</c:if>
                	<c:if test="${cp != null && categoryNo == null && cp == 1 && range != 0}">
                    	<li><a href="searchProduct?range=${range}&currentPage=${cp + 1}"><i class="fas fa-chevron-circle-right"></i></a></li>
                	</c:if>
                </ul>
            </div>
        </div>
        <!-- 제품 나누는 선 -->
        <div class="col col1"></div>
        <div class="col col2"></div>
        <div class="col col3"></div>
        <div class="row row1"></div>
        <div class="row row2"></div>
        <div class="row row3"></div>

    </div>
    
    <script>
    </script>
</body>
</html>