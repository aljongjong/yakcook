<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>제품 관리</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/product/searchProduct.css">
		<script src="https://kit.fontawesome.com/77be500183.js" crossorigin="anonymous"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    </head>
    <body>
    	<%@ include file="/WEB-INF/views/manager/managerHeader.jsp" %>

        <div class="wrap">
            <div class="category">
            <div class="category_title">상세 메뉴</div>
            <div class="category_content">
                <ul>
                    <!-- 반복문, 카테고리 테이블에서 데이터 가져옴 -->
                    <c:if test="${categoryNo == null}">
                    	<li><a class="active" href="manageProduct">전체 상품<i class="far fa-check-circle"></i></a></li>                    
                    </c:if>
                    <c:if test="${categoryNo != null}">
                    	<li><a class="" href="manageProduct">전체 상품<i class="far fa-check-circle"></i></a></li>                    
                    </c:if>
                    <c:forEach items="${categoryList}" var="c">
	   					<c:if test="${c.categoryNo == categoryNo}">
	                 		<li><a class="active" href="manageProduct?categoryNo=${c.categoryNo}">${c.categoryName}<i class="far fa-check-circle"></i></a></li>
	   					</c:if>
	   					<c:if test="${c.categoryNo != categoryNo}">
	                 		<li><a href="manageProduct?categoryNo=${c.categoryNo}">${c.categoryName}</a></li>
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
                    
                    <!-- 제품 등록 삭제 버튼 -->
                    <div class="p_register">
                        <a href="registerProduct">
                            <span>제품 등록 </span>
                            <i class="fas fa-edit"></i>
                        </a>
                    </div>
                    
                    <!-- <div class="p_range">
                        <label for="panel-label">정렬 : </label>
                        <form action="manageProduct" style="display:inline;">
	                        <select name="range" id="">
	                            <option value="1" selected="selected">제품 번호 순</option>
	                            <option value="2">제품 이름 순</option>
	                            <option value="3">가격 높은 순</option>
	                            <option value="4">가격 낮은 순</option>
	                            <option value="5">최근 등록 순</option>
	                            <option value="6">최근 수정 순</option>
	                        </select>
	     					<button type="submit" class="rp_btn"><span>조회 </span><i class="fas fa-search"></i></button>
	                    </form>
                    </div> -->
                </div>


                <!-- 제품관리 헤더 -->
                <div class="manage_product mp_header">
                    <div class="mp_photo">사진
                    </div>
                    <div class="mp_no">제품 번호</div>
                    <div class="mp_name">이름</div>
                    <div class="mp_price">가격</div>
                    <div class="mp_tag">등록된 태그</div>
                    <div class="mp_register_date">등록 일자</div>
                    <div class="mp_update_date">수정 일자</div>
                    <div class="mp_update">수정</div>
                    <div class="mp_check">삭제</div>
                </div>
                
                <!-- 여기부터 디비접근 반복문 -->
                <c:if test="${categoryNo == null}">
	           		<c:forEach items="${nextPageList}" var="np" begin="0" end="12">
		                <div class="manage_product">
		                    <div class="mp_photo">
		                        <c:forEach items="${productImgList}" var="pi">
				                	<c:if test="${np.productNo eq pi.productNo}">
				                		<img src="upload/product/${pi.productImgName}">
				                	</c:if>
				                </c:forEach>
		                    </div>
		                    <div class="mp_no">${np.productNo}</div>
		                    <div class="mp_name">${np.productName}</div>
		                    <div class="mp_price">${np.price}</div>
		                    <!-- 각 제품에 부여된 태그 조인해서 가져오기 -->
							<div class="mp_tag">
			                <c:forEach items="${tagProductList}" var="tp">
								<c:if test="${np.productName eq tp.productName}">
									<a>#${tp.tagName}</a>
								</c:if>		                
			                </c:forEach>
							</diV>
		                    <div class="mp_register_date">${np.categoryDate}</div>
		                    <div class="mp_update_date">${np.lasteditDate}</div>
		                    
		                    <form action="updateProduct" method="get" style="display:inline-block; float:left">
		                    	<input type="hidden" name="updateProuctNo" value="${np.productNo}">
			                    <div class="mp_update_button">
			                        <button type="submit" class="rp_btn">
                                		<span>수정 하기</span>
                               		 <i class="fas fa-tools"></i>
                            		</button>
			                    </div>
		                    </form>
							
							<form action="deleteProduct" method="POST" onsubmit="return deleteCheck();" style="display:inline-block; float:left">
								<input type="hidden" name="deleteProuctNo" value="${np.productNo}">
								<div class="p_delete">
									<button type="submit" class="rp_btn">
										<span>삭제 </span>
										<i class="fas fa-trash-alt"></i>
									</button>
								</div>
							</form>
		                </div>
		        	</c:forEach>
	            </c:if>
				<c:if test="${categoryNo != null}">
		           	<c:forEach items="${categoryProductList}" var="cp" begin="0" end="12">
		            	<div class="manage_product">
			                <div class="mp_photo">
		                        <c:forEach items="${productImgList}" var="pi">
				                	<c:if test="${cp.productNo eq pi.productNo}">
				                		<img src="upload/product/${pi.productImgName}">
				                	</c:if>
				                </c:forEach>
		                    </div>
			                <div class="mp_no">${cp.productNo}</div>
		                    <div class="mp_name">${cp.productName}</div>
		                    <div class="mp_price">${cp.price}</div>
			                <!-- 각 제품에 부여된 태그 조인해서 가져오기 -->
							<div class="mp_tag">
			                <c:forEach items="${tagProductList}" var="tp">
			                	<c:if test="${cp.productName eq tp.productName}">
					                    <a>#${tp.tagName}</a>
									</c:if>		                
								</c:forEach>
							</diV>
			                <div class="mp_register_date">${cp.categoryDate}</div>
		                    <div class="mp_update_date">${cp.lasteditDate}</div>
		                    
		                    <form action="updateProduct" method="get" style="display:inline-block; float:left">
		                    	<input type="hidden" name="updateProuctNo" value="${cp.productNo}">
			                    <div class="mp_update_button">
			                        <button type="submit" class="rp_btn">
                                		<span>수정 하기</span>
                               		 <i class="fas fa-tools"></i>
                            		</button>
			                    </div>
		                    </form>
		
		                    <form action="deleteProduct" method="POST" onsubmit="return deleteCheck();" style="display:inline-block; float:left;">
								<input type="hidden" name="deleteProuctNo" value="${cp.productNo}">
								<div class="p_delete">
									<button type="submit" class="rp_btn">
										<span>삭제 </span>
										<i class="fas fa-trash-alt"></i>
									</button>
								</div>
							</form>
		            	</div>
		           	</c:forEach>
            	</c:if>
    			
                <!-- fas아이콘 한페이지씩 이동 , 선택 페이지 넘버 fontweight 900, ...뒤 마지막 페이지 넘버 나오게, 선택 페이지 앞뒤 넘버 2개씩 보이게 하기  -->
                <div class="paging">
	                <ul>
	                	<c:if test="${cp != null && categoryNo == null && cp != 1}">
	                    	<li><a href="manageProduct?currentPage=${cp - 1}"><i class="fas fa-chevron-circle-left"></i></a></li>
	                	</c:if>
	                	<c:if test="${cp != null && categoryNo != null && cp != 1}">
	                    	<li><a href="manageProduct?categoryNo=${categoryNo}&currentPage=${cp - 1}"><i class="fas fa-chevron-circle-left"></i></a></li>
	                	</c:if>
	                    
	                    
	                    <c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
		                    <c:if test="${i <= maxPage}">
			                    <c:if test="${categoryNo == null}">
			                    	<c:if test="${cp == i}">
			                    		<li><a class="active" href="manageProduct?currentPage=${i}">${i}</a></li>
			                    	</c:if>
			                    	<c:if test="${cp != i}">
				                    	<li><a href="manageProduct?currentPage=${i}">${i}</a></li>
			                    	</c:if>                    
		                    	</c:if>
		                    	<c:if test="${categoryNo != null}">
			                    	<c:if test="${cp == i}">
			                    		<li><a class="active" href="manageProduct?categoryNo=${categoryNo}&currentPage=${i}">${i}</a></li>	   
			                    	</c:if>
			                    	<c:if test="${cp != i}">
				                    	<li><a href="manageProduct?categoryNo=${categoryNo}&currentPage=${i}">${i}</a></li>	   
			                    	</c:if>              	                    	
		                    	</c:if>
		                    </c:if>
	                    </c:forEach>
	                    
	                    <c:if test="${cp != null && categoryNo == null && cp != maxPage}">
	                    	<li><a href="manageProduct?currentPage=${cp + 1}"><i class="fas fa-chevron-circle-right"></i></a></li>
	                	</c:if>
	                	<c:if test="${cp != null && categoryNo != null && cp != maxPage}">
	                    	<li><a href="manageProduct?categoryNo=${categoryNo}&currentPage=${cp + 1}"><i class="fas fa-chevron-circle-right"></i></a></li>
	                	</c:if>
	                </ul>
            	</div>
            </div>

        </div>
        
        <script>
        	function deleteCheck() {
        		if(confirm("상품을 삭제하시겠습니까?")) {
        			alert("상품이 삭제되었습니다.");
        			return true;
        		} else {
        			return false;
        		}
        	}
        	
        	
        	$('.logoutbtn').on('click', function(){
                window.location = "/yakcook/managerlogout";
            });
        
        </script>
    </body>
</html>