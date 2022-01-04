<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<link rel="stylesheet" href="/yakcook/resources/css/product/searchProduct.css">
<script src="https://kit.fontawesome.com/77be500183.js" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
    <div class="wrap">
        <div class="categoryHorizon_sb">
            <div class="categoryHorizon_title">장바구니</div>
        </div>

        <div class="shoppingBasket_list">
            <div class="shoppingBasket_header">
                <ul>
                    <li>제품 사진</li>
                    <li>제품명</li>
                    <li>가격</li>
                    <li>수량</li>
                    <li>수량 변경</li>
                    <li>삭제</li>
                </ul>
            </div>
            <!-- 장바구니에 있는 제품 반복 db -->
            <% int i = 1; %>
           	<c:forEach items="${shoppingBasket}" var="sb">
	            <div class="shoppingBasket_list_each">
	                <div class="shoppingBasket_list_each_photo">
		                <c:forEach items="${productImgList}" var="pi">
			               	<c:if test="${sb.productNo eq pi.productNo}">
			               	<div>		               	
			               		<img src="upload/product/${pi.productImgName}">
			               	</div>
			               	</c:if>
			            </c:forEach>
	                </div>
	                <div class="shoppingBasket_list_each_name">
	                	<c:forEach items="${allProductList}" var="ap">
	                		<c:if test="${ap.productNo eq sb.productNo}">
	                			<form action="detailsProduct" method="POST" style="display:inline-block; float:left">
				                	<input type="hidden" name="productNo" value="${ap.productNo}">
				                	<input type="hidden" name="price" value="${ap.price}">
				                	<input type="hidden" name="categoryDate" value="${ap.categoryDate}">
				                	<input type="hidden" name="productContents" value="${ap.productContents}">
				                	<input type="hidden" name="productDelete" value="${ap.productDelete}">
				                	<input type="hidden" name="lasteditDate" value="${ap.lasteditDate}">
				                	<input type="hidden" name="inventory" value="${ap.inventory}">
				                	<input type="hidden" name="categoryNo" value="${ap.categoryNo}">
				                    <input type="submit" name="productName" value="${ap.productName}" id="searchProductTodetails">
				                </form>       		
	                		</c:if>
	                	</c:forEach>
	                </div>
	                <div class="shoppingBasket_list_each_price">
	                    <c:forEach items="${allProductList}" var="ap">
	                		<c:if test="${ap.productNo eq sb.productNo}">
			                    <a>${ap.price}<span> 원</span></a>
	                		</c:if>
	                		<c:if test="${ap.productNo eq sb.productNo}">
			            		<input type="hidden" value="${ap.price}" id="xxxz">
	                		</c:if>
	                	</c:forEach>
	                </div>
	                <div class="shoppingBasket_list_each_amount">
	                    <input onchange="updateAmount<%=i%>()" type="number" value="${sb.inventory}" min="1" max=
	                    <c:forEach items="${allProductList}" var="ap">
	                		<c:if test="${ap.productNo eq sb.productNo}">
			                    ${ap.inventory}      		
	                		</c:if>
	                	</c:forEach>
	                     style="width:40px;" id="from<%=i%>">
	                </div>
	                <div class="shoppingBasket_list_each_total">
						<form action="updateShoppingBasket" method="POST">
							<input type="hidden" name="productNo" value="${sb.productNo}">
							<input type="hidden" name="shoppingBasketNo" value="${sb.shoppingBasketNo}">
							<input type="hidden" name="changeInventory" value="${sb.inventory}" id="to<%=i%>">
							<button type="submit" class="shoppingBasket_list_each_total_btn"><span>수정 </span><i class="fas fa-arrows-alt-v"></i></button>					
						</form>
	                </div>
	                <script>
						function updateAmount<%=i%>() {
							let from = document.getElementById("from<%=i%>");
					        let to = document.getElementById("to<%=i%>");
					        to.value = from.value;
					        console.log(to.value);
						}
   					</script>
   					<%i++;%>
	                <div class="shoppingBasket_list_each_check">
						<form action="deleteShoppingBasket" method="POST">
							<input type="hidden" name="productNo" value="${sb.productNo}">
							<input type="hidden" name="shoppingBasketNo" value="${sb.shoppingBasketNo}">
							<button type="submit" class="shoppingBasket_list_each_total_btn"><span>삭제 </span><i class="fas fa-minus-square"></i></button>					
						</form>
	                </div>
	            </div>
           	</c:forEach>

            <!-- 선택 삭제, 전체 삭제 -->
            <div class="shoppingBasket_selected_delete"></div>
            <div class="shoppingBasket_all_delete">
            	<form action="allDeleteShoppingBasket" method="POST">
					<input type="hidden" name="shoppingBasketNo" value="${sv.shoppingBasketNo}">
					<button type="submit" class="shoppingBasket_list_each_total_btn"><span>전체 제품 삭제 </span><i class="fas fa-trash-alt"></i></button>					
				</form>
            </div>
        </div>

        <div class="shoppingBasket_forward_pay">
            <div class="shoppingBasket_forward_pay_header">
                <div>주문내역</div>
            </div>
            <div class="shoppingBasket_forward_pay_price">
                <div>총 상품 금액</div>
                <div>${totalProductPrice}<span> 원</span></div>
            </div>
            <div class="shoppingBasket_forward_pay_delivery_price">
                <div>배송비</div>
                <c:if test="${totalProductPrice >= 100000}">
                	<div>0<span> 원</span></div>
                </c:if>                
                <c:if test="${totalProductPrice < 100000}">
                	<c:if test="${totalProductPrice > 0}">
                		<div>2500<span> 원</span></div>            	
	                </c:if>
                </c:if>
                <c:if test="${totalProductPrice == 0}">
                	<div>0<span> 원</span></div>
                </c:if>
            </div>
            <div class="shoppingBasket_forward_pay_delivery_price_details">
                <div>
                    <i class="fas fa-truck"></i> 기본 배송비는 2,500원 입니다. 총 상품 금액 10만원 이상 시 <span>무료배송</span>입니다.
                </div>
            </div>
            <div class="shoppingBasket_forward_pay_all_price">
                <div>총 결제 금액</div>
                <c:if test="${totalProductPrice >= 100000}">
                	<div style="color:red;">${totalProductPrice}<span> 원</span></div>
                </c:if>
                <c:if test="${totalProductPrice < 100000}">
                	<c:if test="${totalProductPrice > 0}">
	                	<div style="color:red;">${totalProductPrice + 2500}<span> 원</span></div>            	
                	</c:if>
                </c:if>
                <c:if test="${totalProductPrice == 0}">
	                <div>0<span> 원</span></div>            	
                </c:if>
            </div>
            <c:if test="${totalProductPrice > 0}"> <!--  -->
	            <div class="shoppingBasket_forward_pay_gopay_btn">
	            	<form action="payment" method="POST">
	            		<input type="hidden" name="shoppingBagNo" value="${sv.shoppingBasketNo}">
	                	<input type="submit" value="주문 하기" id="detailsProductToPayment">
	            	</form>
	            </div>
            </c:if>
            <div class="shoppingBasket_forward_pay_backshop_btn">
                <a href="searchProduct">쇼핑 계속 하기</a>
            </div>
        </div>
    </div>
</body>
</html>