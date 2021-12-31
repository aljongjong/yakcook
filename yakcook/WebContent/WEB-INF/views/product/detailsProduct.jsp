<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 상세 정보</title>
<link rel="stylesheet" href="/yakcook/resources/css/product/searchProduct.css">
<script src="https://kit.fontawesome.com/77be500183.js" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
.fa-truck
{
	text-align: center;
	padding: 5px;
}
</style>
</head>
<body>
    <div class="wrap">
        <div class="categoryHorizon">
            <div class="categoryHorizon_title">제품 상세 정보</div>
        </div>
        
        <!-- 제품이미지, 제품 설명, 가격 수량 구매하기, 장바구니 추가 버튼  -->
        <!-- dbdbdbdbdbdb -->
        <div class="detailsProduct_contents">
            <div class="dp_productImg">
                <c:forEach items="${productImgList}" var="pi">
	               	<c:if test="${detailsProduct.productNo eq pi.productNo}">
                		<div>
	               			<img src="upload/product/${pi.productImgName}">
		                </div>
	               	</c:if>
	            </c:forEach>
                <div id="dp_prev">
                    <a href="#"><i class="fas fa-chevron-left"></i></a>
                </div>
                <div id="dp_next">
                    <a href="#"><i class="fas fa-chevron-right"></i></a>
                </div>
                <div id="dp_bean">
                    <i class="fas fa-circle"></i>
                    <i class="fas fa-circle"></i>
                </div>
            </div>
            
            <div class="dp_productInfo">
                <div class="dp_info_name">
                    <span>${detailsProduct.productName}</span>
                </div>

                <div class="dp_info_stock_review">
                    <div class="dp_info_stock">
                        <a href="#">
                            <i class="fas fa-box-open"></i>
                            <span>재고 : ${detailsProduct.inventory}개</span>
                        </a>
                    </div>
                    <div class="dp_info_review">
                        <a href="#">
                            <i class="far fa-comments"></i>
                            <span>리뷰 : 99개</span>
                        </a>
                    </div>
                </div>

                <div class="dp_info_info">
                    <p>
                        ${detailsProduct.productContents}
                    </p>
                </div>
            </div>

            <div class="dp_info_go_pay_sb">
                <div class="dp_info_go_pay_sb_price">
                    <div>
                        판매가격 :
                    </div>
                    <div>${detailsProduct.price}</div><span style="font-size:14px"> 원</span>
                </div>
                
                <div class="dp_info_go_pay_sb_amount">
                    <div>
                        수량 :
                    </div>
                    <div>
                        <select oninput="totalPrice()" name="dp_info_go_pay_sb_amount" id="dpAmount">
                        <c:forEach var="i" begin="1" end="${detailsProduct.inventory}">
                       		<option value="${i}">${i}</option>                      
                        </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="dp_info_go_pay_sb_total">
					<div>총 상품 가격 : </div>
					<c:if test="${detailsProduct.price < 100000}">
						<div id="dpTotal">${detailsProduct.price + 2500}</div><span style="font-size:14px"> 원</span>
					</c:if>
					<c:if test="${detailsProduct.price >= 100000}">
						<div id="dpTotal">${detailsProduct.price}</div><span style="font-size:14px"> 원</span>
					</c:if>
                </div>

                <div class="shoppingBasket_forward_pay_delivery_price_details">
	                <div>
	                    <i class="fas fa-truck"></i> 기본 배송비는 2,500원 입니다. 총 상품 금액 10만원 이상 시 <span>무료배송</span>입니다.
	                </div>
            	</div>
                <div class="dp_info_forward_pay_gopay_btn">
                    <a href="#">주문 하기</a>
                </div>
                <div class="dp_info_forward_pay_backshop_btn">
                <form action="shoppingBasket" method="GET" style="display:inline">
                	<input type="hidden" name="productNo" value="${detailsProduct.productNo}">
                	<input type="hidden" name="price" value="${detailsProduct.price}">
                	<input type="hidden" name="amount" value="" id="toSBamount">
                	<input type="hidden" name="categoryNo" value="${detailsProduct.categoryNo}">
                	<input type="hidden" name="productName" value="${detailsProduct.productName}">
                    <input onclick="toShoppingBasket()" type="submit" value="장바구니에 담기" id="detailsProductToShoppingBasket">
                </form>
            </div>
        </div>
        

        <!--  배송 주의사항, 주문 주의사항, 반품/환불 주의사항 탭메뉴 형식으로 만들기 -->
        <div class="detailsProduct_notice">
            <div class="detailsProduct_notice_tab_btn">
                <ul>
                    <li class="active">
                        <a href="#">제품 상세 정보</a>
                    </li>
                    <li>
                        <a href="#">주문 주의사항</a>
                    </li>
                    <li>
                        <a href="#">배송 주의사항</a>
                    </li>
                    <li>
                        <a href="#">반품 / 환불 안내</a>
                    </li>
                </ul>
            </div>

            <div class="detailsProduct_notice_tab_cont">
                <div></div>
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>
        
        </div>
    </div>
    
    <script>
    	function totalPrice() {
    		$.ajax ({
    			url : "",
    			method : "GET",
    			data : {
    				price : "<c:out value='${detailsProduct.price}'/>",
    				amount : $("#dpAmount").val()
    			},
    			success : function(result) {
    				$("#dpTotal").text(result);
    			}
    		});
    	}
    	function toShoppingBasket() {
    		let amount = document.getElementById("dpAmount");
            let tosbamount = document.getElementById("toSBamount");
            tosbamount.value = amount.value;
    	}
    	
    </script>
</body>
</html>