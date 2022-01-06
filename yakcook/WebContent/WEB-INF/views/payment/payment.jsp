<%@page import="com.yakcook.member.model.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제페이지</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/payment/paymentPage.css">
<script
	src="http://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://js.tosspayments.com/v1"></script>
<script>

</script>
<script>

	function toss_popup() {
		
		var tossPayments = TossPayments("test_ck_k6bJXmgo28e9WMkEoLY8LAnGKWx4");
		var button = document.getElementById("payment-button");

		var orderId = new Date().getTime();

		var method = document.querySelector('input[name=method]:checked').value; // "카드" 혹은 "가상계좌"
		
		
		var min = Math.ceil(0);
	  	var max = Math.floor(999999999999);
 	 	var orderIdRandom = Math.floor(Math.random() * (max - min)) + min; //최댓값은 제외, 최솟값은 포함
		
		var paymentData = {
			amount : ${totalPrice},
			orderId : orderIdRandom.toString(10),
			orderName : "${itemList}",
			customerName : "order",
			successUrl : window.location.origin + "/yakcook/paymentSuccess?method="+method,
			failUrl : window.location.origin + "/yakcook/paymentFail",
		};

		if (method === '가상계좌') {
			paymentData.virtualAccountCallbackUrl = window.location.origin
					+ '/virtual-account/callback'
		}

		tossPayments.requestPayment(method, paymentData);

	}
</script>

</head>

<body>

	
		<header> 
		<%@ include file="/WEB-INF/views/common/headerFinal.jsp"%>
		</header>

		<section>
		<div id="wrap">
			<c:if test="${empty shoppingList}">
				<c:forEach items="${productList}" var="p">
					<div id="order_item">
					
						<div id="item_name" class="itme_text">${p.productName}</div>
						<div class="line"></div>
						<div id="item_price" class="itme_text">${p.price}</div>
						<div class="line"></div>
						<div id="item_amount" class="itme_text">${amount}개</div>
					</div>
					<c:if test="${amount==1}">
						<div id="total_price">
							총 결제금액 <label id=total>${defaultPrice}원</label> 원
						</div>
					</c:if>
					<c:if test="${amount>1}">
						<div id="total_price">
							총 결제금액 <label id=total>${totalPrice}</label> 원
						</div>
					</c:if>
				</c:forEach>

			</c:if>

			<c:if test="${empty productList}">
				<c:forEach items="${shoppingList}" var="s">
					<div id="order_item">
					
					
						<div id="item_name" class="itme_text">${s.productName}</div>
						<div class="line"></div>
						<div id="item_price" class="itme_text">${s.price}</div>
						<div class="line"></div>
						<div id="item_amount" class="itme_text">${s.inventory}개</div>
					</div>

				</c:forEach>


				<c:if test="${totalPrice < 100000}">
					<div id="total_price">
						총 결제금액 <label id=total>${totalPrice + 2500}</label> 원
					</div>
				</c:if>


				<c:if test="${totalPrice>=100000}">
					<div id="total_price">
						총 결제금액 <label id=total>${totalPrice}</label> 원
					</div>
				</c:if>


			</c:if>


			<form action="orderInfo" method="post" id="order_form">
				<div id="order_info">

					<div id="notice">
						<label>주문자</label>
					</div>
					<hr>
					<div id="order-info">

						<label>이름</label> <br> <input type="text" name="order"
							id="order"> <br> <label>연락처</label> <br> 
						<input type="text" name="phone1" id="phone1" class="phone" maxlength="3"> -
                        <input type="text" name="phone2" id="phone2" class="phone" maxlength="4"> -
                        <input type="text" name="phone3" id="phone3" class="phone" maxlength="4">
						<br>
					</div>

					<div id="notice">
						<label>배송지</label>
						<hr>
					</div>

					<div id="orderaddress">
						<input type="text" id="postcode" placeholder="우편번호"> <input
							type="button" id="postcodeBtn" onclick="execDaumPostcode()"
							value="우편번호 찾기"><br> <input type="text"
							class="address" id="address" placeholder="주소"><br> <input
							type="text" class="address" id="detailAddress" placeholder="상세주소">
						<input type="text" class="address" id="extraAddress"
							placeholder="참고항목">
					</div>

					<div id="delivery_memo">
						<label>배송메모</label> <select name="memo_option" id="memo_option">
							<option value="postmemo1">배송 시 요청사항을 선택해주세요</option>
							<option value="postmemo2">부재 시 경비실에 맡겨주세요</option>
							<option value="postmemo3">부재 시 집 앞에 놔주세요</option>
							<option value="postmemo4">배송 전 연락 바랍니다</option>
							<option value="postmemo5">파손의 위험이 있는 상품입니다 배송시 주의해주세요</option>
							<option value="postmemo6">직접입력</option>
						</select> <br>
						<textarea name="input_memo" id="input_memo" cols="60" rows="5"
							maxlength="50" placeholder="최대 50까지 가능합니다."></textarea>
						<br> <span id="additional">제주 및 산간 지역의 배송은 추가 배송비가 발생할
							수 있습니다. </span>
					</div>
				</div>



				<div id="agreement">
					<div id="agreement_check">
						<input type="checkbox" id="checkbox"><label>개인정보
							제공 동의</label>
					</div>

					<div id="mebmerTerms">

						<p>주문자 동의
						<hr>
						<p id="agreement_title">배송 등 거래를 위해 판매자에게 개인정보가 공유됩니다.</p>
						<p id="agreement_show">약관보기</p>
						<p id="agreement_contents">
							<strong>yakcook</strong>의 회원계정으로 상품 및 서비스를 구매하고자 할 경우,
							(주)yakcook은 거래 당사자간 원활한 의사소통 및 배송, 상담 등 거래이행을 위하여 필요한 최소한의 개인정보만을
							yakcook 입점업체 판매자 및 배송업체에 아래와 같이 공유하고 있습니다.<br> <br> 1.
							yakcook은 귀하께서 yakcook 입점업체 판매자로부터 상품 및 서비스를 구매하고자 할 경우, 정보통신망
							이용촉진 및 정보보호 등에 관한 법률 제 24조의 2(개인정보 공유동의 등)에 따라 아래와 같은 사항은 안내하고
							동의를 받아 귀하의 개인정보를 판매자에게 공유합니다. "개인정보 제3자 공유 동의"를 체크하시면 개인정보 공유에 대해
							동의한 것으로 간주합니다.<br> <br> 2. 개인정보를 공유받는자 : yakcook<br>
							<br> 3. 공유하는 개인정보 항목<br> <br> - 구매자 정보: 성명, 전화번호,
							ID, 휴대전화 번호, 상품 구매정보<br> <br> - 수령자 정보: 성명, 전화번호, 휴대전화
							번호, 배송지 주소<br> <br> 4. 개인정보를 공유받는 자의 이용 목적 : 판매자와 구매자의
							거래의 원활한 진행, 본인의사의 확인, 고객 상담 및 불만처리, 상품과 경품 배송을 위한 배송지 확인 등<br>
							<br> 5. 개인정보를 공유받는 자의 개인정보 보유 및 이용 기간 : 개인정보 수집 및 이용 목적 달성
							시까지 보관합니다.<br> <br> 6. 동의 거부 시 불이익 : 본 개인정보 공유에 동의하지
							않으시는 경우, 동의를 거부할 수 있으며, 이 경우 거래가 제한됩니다.
						</p>
						</p>
					</div>

				</div>

				<label id="paymethod_text">결제방법</label>
				<hr>
				<div id="pay_method">
					<div>
						<label><input type="radio" name="method" value="카드"
							checked />신용카드</label>
					</div>
					<div>
						<label><input type="radio" name="method" value="가상계좌" />가상계좌</label>
					</div>
				</div>
				<br>
				<hr id="last_hr">
				
				<div id="paymentBtn_form">

					<%String loginUserId = ((MemberVo) session.getAttribute("loginUser")).getUser_id();%>
					<input type="hidden" name="userId" value="<%=loginUserId%>">

					<button type="button" id="payment_btn" onclick="form_object_save(this.form);">결제하기
			</form>
	</div>

	</section>

	<footer> 
	
	  </footer>
	</div>

	<script>
		function execDaumPostcode() {
			new daum.Postcode(
					{
						oncomplete : function(data) {
							// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

							// 각 주소의 노출 규칙에 따라 주소를 조합한다.
							// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
							var addr = ''; // 주소 변수
							var extraAddr = ''; // 참고항목 변수

							//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
							if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
								addr = data.roadAddress;
							} else { // 사용자가 지번 주소를 선택했을 경우(J)
								addr = data.jibunAddress;
							}

							// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
							if (data.userSelectedType === 'R') {
								// 법정동명이 있을 경우 추가한다. (법정리는 제외)
								// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
								if (data.bname !== ''
										&& /[동|로|가]$/g.test(data.bname)) {
									extraAddr += data.bname;
								}
								// 건물명이 있고, 공동주택일 경우 추가한다.
								if (data.buildingName !== ''
										&& data.apartment === 'Y') {
									extraAddr += (extraAddr !== '' ? ', '
											+ data.buildingName
											: data.buildingName);
								}
								// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
								if (extraAddr !== '') {
									extraAddr = ' (' + extraAddr + ')';
								}
								// 조합된 참고항목을 해당 필드에 넣는다.
								document.getElementById("extraAddress").value = extraAddr;

							} else {
								document.getElementById("extraAddress").value = '';
							}

							// 우편번호와 주소 정보를 해당 필드에 넣는다.
							document.getElementById('postcode').value = data.zonecode;
							document.getElementById("address").value = addr;
							// 커서를 상세주소 필드로 이동한다.
							document.getElementById("detailAddress").focus();
						}
					}).open();
		}
	</script>

	<script
		src="${pageContext.request.contextPath}/resources/js/payment/payment.js"></script>

	<script>

		var data = null;
		function form_object_save(form_object_save) {
			data = form_object_save;
			$.ajax({
				type : "post",
				url : "orderInfo",
				data : {
					order : data.order.value,
					phone1 : data.phone1.value,
					phone2 : data.phone2.value,
					phone3 : data.phone3.value,
					postcode : data.postcode.value,
					address : data.address.value,
					detailaddress : data.detailAddress.value,
					extra : data.extraAddress.value,
					memo_option : data.memo_option.value,
					input_memo : data.input_memo.value,
					userId : data.userId.value
				},
				success : function(data) {
					if (data > 0) {
						toss_popup();
					} else {
				
					}
				},
				error : function() {

				}
			})
		}
		
		
       
        


</script>
</body>

</html>