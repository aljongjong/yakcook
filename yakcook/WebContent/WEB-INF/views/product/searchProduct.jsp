<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 조회</title>
<link rel="stylesheet" href="/yakcook/resources/css/product/searchProduct.css">
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
                   <a href="#">전체상품 or 선택카테고리</a>
                </div>
                <div class="p_range">
                    <label for="panel-label">정렬 : </label>
                    <select oninput="range();" name="range" id="range">
                        <option value="1" selected="selected">최신</option>
                        <option value="2">가격 낮은 순</option>
                        <option value="3">가격 높은 순</option>
                        <option value="4">리뷰 많은 순</option>
                    </select>
                </div>
            </div>
            
            <!-- 제품, 제품이미지, 태그 테이블 데이터 -->
            <c:if test="${categoryNo == null}">
            	<c:forEach items="${allProductList}" var="ap" begin="1" end="16">
	            	<div class="search_product">
		                <div class="sp_photo">
		                    <a href="#"><img src="35.jpeg"></a>
		                </div>
		                <div class="sb">
		                    <a href="#"><i class="fas fa-cart-plus"></i><span> 장바구니 담기</span></a>
		                </div>
		                <div class="sp_name_price">
		                    <a href="#">${ap.productName}</a>
		                    <a href="#">${ap.price}</a>
		                </div>
		                <!-- 각 제품에 부여된 태그 조인해서 가져오기 -->
		                <div class="sp_tag">
		                    <a href="#">#태그1</a>
		                </div>
		                <div class="sp_tag">
		                    <a href="#">#태그2</a>
		                </div>
		                <div class="sp_tag">
		                    <a href="#">#태그3</a>
		                </div>
	            	</div>
            	</c:forEach>
            </c:if>
            
            <c:if test="${categoryNo != null}">
	           	<c:forEach items="${categoryProductList}" var="cp" begin="1" end="16">
	            	<div class="search_product">
		                <div class="sp_photo">
		                    <a href="#"><img src="35.jpeg"></a>
		                </div>
		                <div class="sb">
		                    <a href="#"><i class="fas fa-cart-plus"></i><span> 장바구니 담기</span></a>
		                </div>
		                <div class="sp_name_price">
		                    <a href="#">${cp.productName}</a>
		                    <a href="#">${cp.price}</a>
		                </div>
		                <!-- 각 제품에 부여된 태그 조인해서 가져오기 -->
		                <div class="sp_tag">
		                    <a href="#">#태그1</a>
		                </div>
		                <div class="sp_tag">
		                    <a href="#">#태그2</a>
		                </div>
		                <div class="sp_tag">
		                    <a href="#">#태그3</a>
		                </div>
	            	</div>
	           	</c:forEach>
            </c:if>
            
            

            <!-- fas아이콘 한페이지씩 이동 , 선택 페이지 넘버 fontweight 900, ...뒤 마지막 페이지 넘버 나오게, 선택 페이지 앞뒤 넘버 2개씩 보이게 하기  -->
            <div class="paging">
                <ul>
                    <li>
                        <a href="#">
                            <span>
                                <i class="fas fa-chevron-circle-left"></i>
                            </span>
                        </a>
                    </li>
                    
                    <c:if test=""></c:if>
                    <c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
	                    <c:if test="${i le maxPage}">
	                    	<li><a href="/currentPage=${i}">${i}</a></li>
	                    </c:if>
                    </c:forEach>
                    
                    <li>
                        <a href="#">
                            <span>
                                <i class="fas fa-chevron-circle-right"></i>
                            </span>
                        </a>
                    </li>
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
    	/* 정렬 보류%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% */
    	function range() {
    		$.ajax({
    			url : "",
    			method : "GET",
    			data : {
    				range : $("#range").val()
    			}
    			
    		});
    	}
    </script>
</body>
</html>