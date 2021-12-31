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
                    	<li><a href="searchProduct">전체 상품<i class="far fa-check-circle"></i></a></li>
                    <c:forEach items="${categoryList}" var="c">
                    	<li><a href="searchProduct?categoryNo=${c.categoryNo}">${c.categoryName}<i class="far fa-check-circle"></i></a></li>
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
                    <select oninput="range();" name="range" id="range">
                        <option value="1" selected="selected">등록순</option>
                        <option value="2">최신순</option>
                        <option value="3">가격 낮은 순</option>
                        <option value="4">가격 높은 순</option>
                        <option value="5">리뷰 많은 순</option>
                    </select>
                </div>
            </div>
            
            <!-- 제품, 제품이미지, 태그 테이블 데이터 -->
            <c:if test="${categoryNo == null}">
            	<c:if test="${range == 0}">
	           		<c:forEach items="${nextPageList}" var="np" begin="0" end="16">
			            	<div class="search_product">
				                <div class="sp_photo">
				                    <a href="#"><img src=""></a>
				                </div>
				                <div class="sb">
				                    <a href="#"><i class="fas fa-cart-plus"></i><span> 장바구니 담기</span></a>
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
				                    <input type="submit" name="productName" value="${np.productName}">
				                </form>
				                    <a href="#" style="float:right">${np.price}</a>
				                </div>
				                <!-- 각 제품에 부여된 태그 조인해서 가져오기 -->
				                <c:forEach items="${tagProductList}" var="tp">
				                	<c:if test="${np.productName eq tp.productName}">
						                <div class="sp_tag">
						                    <a href="#">#${tp.tagName}</a>
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
				                    <a href="#"><img src=""></a>
				                </div>
				                <div class="sb">
				                    <a href="#"><i class="fas fa-cart-plus"></i><span> 장바구니 담기</span></a>
				                </div>
				                <div class="sp_name_price">
				                    <a href="#">${np.productName}</a>
				                    <a href="#">${np.price}</a>
				                </div>
				                <!-- 각 제품에 부여된 태그 조인해서 가져오기 -->
				                <c:forEach items="${tagProductList}" var="tp">
				                	<c:if test="${np.productName eq tp.productName}">
						                <div class="sp_tag">
						                    <a href="#">#${tp.tagName}</a>
						                </diV>
				                	</c:if>		                
				                </c:forEach>
			            	</div>
	            	</c:forEach>
            	</c:if>
            </c:if>
            
            <c:if test="${categoryNo != null}">
	           	<c:forEach items="${categoryProductList}" var="cp" begin="0" end="16">
	            	<div class="search_product">
		                <div class="sp_photo">
		                    <a href="#"><img src=""></a>
		                </div>
		                <div class="sb">
		                    <a href="#"><i class="fas fa-cart-plus"></i><span> 장바구니 담기</span></a>
		                </div>
		                <div class="sp_name_price">
		                    <a href="#">${cp.productName}</a>
		                    <a href="#">${cp.price}</a>
		                </div>
		                <!-- 각 제품에 부여된 태그 조인해서 가져오기 -->
		                <c:forEach items="${tagProductList}" var="tp" begin="0" end="1">
		                	<c:if test="${cp.productName eq tp.productName}">
				                <div class="sp_tag">
				                    <a href="#">#${tp.tagName}</a>
				                </diV>
		                	</c:if>		                
		                </c:forEach>
	            	</div>
	           	</c:forEach>
            </c:if>
            
            <!-- fas아이콘 한페이지씩 이동 , 선택 페이지 넘버 fontweight 900, ...뒤 마지막 페이지 넘버 나오게, 선택 페이지 앞뒤 넘버 2개씩 보이게 하기  -->
            <div class="paging">
                <ul>
                	<c:if test="${cp != null && categoryNo == null && cp != 1}">
                    	<li><a href="searchProduct?currentPage=${cp - 1}"><i class="fas fa-chevron-circle-left"></i></a></li>
                	</c:if>
                	<c:if test="${cp != null && categoryNo != null && cp != 1}">
                    	<li><a href="searchProduct?categoryNo=${categoryNo}&currentPage=${cp - 1}"><i class="fas fa-chevron-circle-left"></i></a></li>
                	</c:if>
                    
                    
                    <c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
	                    <c:if test="${i <= maxPage}">
		                    <c:if test="${categoryNo == null}">
		                    	<li><a href="searchProduct?currentPage=${i}">${i}</a></li>	                    
	                    	</c:if>
	                    	<c:if test="${categoryNo != null}">
		                    	<li><a href="searchProduct?categoryNo=${categoryNo}&currentPage=${i}">${i}</a></li>	                    	                    	
	                    	</c:if>
	                    </c:if>
                    </c:forEach>
                    
                    <c:if test="${cp != null && categoryNo == null && cp != maxPage}">
                    	<li><a href="searchProduct?currentPage=${cp + 1}"><i class="fas fa-chevron-circle-right"></i></a></li>
                	</c:if>
                	<c:if test="${cp != null && categoryNo != null && cp != maxPage}">
                    	<li><a href="searchProduct?categoryNo=${categoryNo}&currentPage=${cp + 1}"><i class="fas fa-chevron-circle-right"></i></a></li>
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
    	/* 카테고리 메뉴 클릭시 배경 + 아이콘 생기게 */
    	
    	/* 정렬 */
    	function range() {
    	 	$.ajax({
    	 		url : "/yakcook/searchProduct",
    	 		method : "GET",
    	 		data : {
    	 			range : $("#range").val()
    	 		}
    			
    		});
    	}
    </script>
</body>
</html>