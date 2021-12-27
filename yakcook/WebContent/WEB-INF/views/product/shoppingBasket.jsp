<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<link rel="stylesheet" href="/yakcook/resources/css/product/searchProduct.css">
<script src="https://kit.fontawesome.com/77be500183.js" crossorigin="anonymous"></script>
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
                    <li>총합</li>
                    <li>선택</li>
                </ul>
            </div>
            <!-- 장바구니에 있는 제품 반복 db -->
            <div class="shoppingBasket_list_each">
                <div class="shoppingBasket_list_each_photo">
                    <img src="35.jpeg">
                </div>
                <div class="shoppingBasket_list_each_name">
                    <a href="#">ABCDEFGHIJKLMNOPQRSTUVWXYZ</a>
                </div>
                <div class="shoppingBasket_list_each_price">
                    <span>W50,000</span>
                </div>
                <div class="shoppingBasket_list_each_amount">
                    <select name="sb_amount" id="sb_amount">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                    </select>
                </div>
                <div class="shoppingBasket_list_each_total">
                    <span>W200,000</span>
                </div>
                <div class="shoppingBasket_list_each_check">
                    <input type="checkbox" name="dt_check" id="dt_check">
                </div>
            </div>
            <div class="shoppingBasket_list_each"></div>
            <div class="shoppingBasket_list_each"></div>
            <div class="shoppingBasket_list_each"></div>
            <div class="shoppingBasket_list_each"></div>

            <!-- 선택 삭제, 전체 삭제 -->
            <div class="shoppingBasket_selected_delete">
                <a href="#">
                    <span>선택 제품 삭제 </span>
                    <i class="fas fa-minus-square"></i>
                </a>
            </div>
            <div class="shoppingBasket_all_delete">
                <a href="#">
                    <span>전체 제품 삭제 </span>
                    <i class="fas fa-trash-alt"></i>
                </a>
            </div>
        </div>

        <div class="shoppingBasket_forward_pay">
            <div class="shoppingBasket_forward_pay_header">
                <div>주문내역</div>
            </div>
            <div class="shoppingBasket_forward_pay_price">
                <div>총 상품 금액</div>
                <div>₩90,000</div>
            </div>
            <div class="shoppingBasket_forward_pay_delivery_price">
                <div>배송비</div>
                <div>₩3,000</div>
            </div>
            <div class="shoppingBasket_forward_pay_delivery_price_details">
                <div>
                    <i class="fas fa-truck"></i> 총 상품 금액 10만원 이상 시 <span>무료배송</span>입니다.
                </div>
            </div>
            <div class="shoppingBasket_forward_pay_all_price">
                <div>총 결제 금액</div>
                <div>₩103,000</div>
            </div>
            <div class="shoppingBasket_forward_pay_gopay_btn">
                <a href="#">결제하기</a>
            </div>
            <div class="shoppingBasket_forward_pay_backshop_btn">
                <a href="#">쇼핑 계속 하기</a>
            </div>
        </div>
        
        
    </div>
</body>
</html>