<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제페이지</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/payment/payment.css">
<script
	src="http://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://js.tosspayments.com/v1"></script>

</head>

<body>
	<div id="wrap">	
		<header> </header>

		<section>
			<form action="orderinfo" method="post">
				<div id="postdiv">
					<!--수령자 정보-->

					<div id="order">
						<label>주문자</label>
					</div>
					<div id="order-info">

						<label>이름</label> <br> <input type="text" name="order"
							id="order"> <br> <label>연락처</label> <br> <input
							type="text" name="phone1" class="phone" maxlength="3"> -
						<input type="text" name="phone2" class="phone" maxlength="4">
						- <input type="text" name="phone3" class="phone" maxlength="4">
						<br>
					</div>

					<div id="addressname">
						<label>배송지</label>
					</div>

					<div id="orderaddress">
						<input type="text" id="sample6_postcode" name="postcode" placeholder="우편번호">
						<input type="button" onclick="sample6_execDaumPostcode()"
							value="우편번호 찾기"><br> <input type="text"
							id="sample6_address" name = "address" placeholder="주소"><br> <input
							type="text" id="sample6_detailAddress" name ="detailaddress" placeholder="상세주소">
						<input type="text" id="sample6_extraAddress" name="extra" placeholder="참고항목">
					</div>

					<div id="delivery_memo">
						<label>배송메모</label> <select name="memo_option" id="memo_option">
							<option value="배송 시 요청사항을 선택해주세요">배송 시 요청사항을 선택해주세요</option>
							<option value="부재 시 경비실에 맡겨주세요">부재 시 경비실에 맡겨주세요</option>
							<option value="부재 시 집 앞에 놔주세요">부재 시 집 앞에 놔주세요</option>
							<option value="배송 전 연락 바랍니다">배송 전 연락 바랍니다</option>
							<option value="파손위험이 있는 상품입니다. 배송시 주의해주세요.">파손의 위험이 있는 상품입니다 배송시 주의해주세요</option>
							<option value="직접입력">직접입력</option>
						</select> <br>
						<textarea name="input_memo" id="input_memo" cols="60" rows="5"
							maxlength="50" placeholder="최대 50까지 가능합니다."></textarea>
						<br> <span id="additional">제주 및 산간 지역의 배송은 추가 배송비가 발생할
							수 있습니다. </span>
					</div>



				</div>

				<div id="info-list">
					<!--결제정보-->
					<div id="info-prod">
						<li> </li>
						<li>가격</li>
						<li>수량</li>
					</div>

					<div id="product_img">
						<span><img src="/./fff69c60c13cbd0e03cf0c430e49a78b.jpg"
							alt=""></span>
					</div>
					<div id="product_name">
						<span>정관장 홍삼</span>
					</div>

					<div id="product_count">
						<span>1개</span>
					</div>
				</div>

				<div id="prod-li">
					<li>총 상품 금액</li>
					<li>200000원</li>
					<li>배송비</li>
					<li>3000원</li>
					<li>결제금액</li>
					<li>230000원</li>
				</div>




				<div id="Payment_Method"></div>

				<div id="agreement">
					<input type="checkbox" id="agreement_check">개인정보 제공 동의
					<div id="mebmerTerms">

						<li>주문자 동의
							<p>배송 등 거래를 위해 판매자에게 개인정보가 공유됩니다</p>
							<p>
								yakcook의 회원계정으로 상품 및 서비스를 구매하고자 할 경우, (주)yakcook은 거래 당사자간 원활한
								의사소통 및 배송, 상담 등 거래이행을 위하여 필요한 최소한의 개인정보만을 무신사 입점업체 판매자 및 배송업체에
								아래와 같이 공유하고 있습니다.<br> 1. yakcook은 귀하께서 yakcook 입점업체 판매자로부터
								상품 및 서비스를 구매하고자 할 경우, 정보통신망 이용촉진 및 정보보호 등에 관한 법률 제 24조의 2(개인정보
								공유동의 등)에 따라 아래와 같은 사항은 안내하고 동의를 받아 귀하의 개인정보를 판매자에게 공유합니다. "개인정보
								제3자 공유 동의"를 체크하시면 개인정보 공유에 대해 동의한 것으로 간주합니다.<br> 2. 개인정보를
								공유받는자 : yakcook<br> 3. 공유하는 개인정보 항목<br> - 구매자 정보: 성명,
								전화번호, ID, 휴대전화 번호, 상품 구매정보<br> - 수령자 정보: 성명, 전화번호, 휴대전화 번호,
								배송지 주소<br> 4. 개인정보를 공유받는 자의 이용 목적 : 판매자와 구매자의 거래의 원활한 진행,
								본인의사의 확인, 고객 상담 및 불만처리, 상품과 경품 배송을 위한 배송지 확인 등<br> 5. 개인정보를
								공유받는 자의 개인정보 보유 및 이용 기간 : 개인정보 수집 및 이용 목적 달성 시까지 보관합니다.<br>
								6. 동의 거부 시 불이익 : 본 개인정보 공유에 동의하지 않으시는 경우, 동의를 거부할 수 있으며, 이 경우
								거래가 제한됩니다.
							</p>
						</li>
					</div>
				</div>

				<div id="payment_method">
					<div id="methods-container">

						<label class="method_item"> <input type="radio"
							name="method_pay" class="method_pay" value="카드"> <span>신용
								/ 체크카드</span>
						</label> </label> <label class="method_item"> <input type="radio"
							name="method_pay" class="method_pay" value="계좌이체"> <span>계좌
								이체</span>
						</label> <label class="method_item"> <input type="radio"
							name="method_pay" class="method_pay" value="가상계좌"> <span>가상
								계좌</span>
						</label> <label class="method_item"> <input type="radio"
							name="method_pay" class="method_pay" value="무통장"> <span>무통장
								입금</span>
						</label>
					</div>
				</div>

				<div id="no_bankbook">
					<label>입금자</label> <br> <input type="text" id="depositor">
					<br> <label>입금계좌</label> <br> <select id="yakcookbank">
						<option value=>국민은행(28930204338645)yakcook</option>
					</select> <br> <input type="checkbox" id="">현금 영수증 신청

				</div>
				<div id="Refuncd_Acc">
					<select name="bank" id="">
						<option value="">선택하세요.</option>
						<option value="NH농협은행">NH농협은행</option>
						<option value="KB국민은행">KB국민은행</option>
						<option value="우리은행">우리은행</option>
						<option value="신한은행">신한은행</option>
						<option value="IBK기업은행">IBK기업은행</option>
						<option value="하나은행">하나은행</option>
						<option value="경남은행">경남은행</option>
						<option value="대구은행">대구은행</option>
						<option value="부산은행">부산은행</option>
						<option value="sh수협은행">sh수협은행</option>
						<option value="우체국예금보험">우체국예금보험</option>
						<option value="KDB산업은행">KDB산업은행</option>
						<option value="SC제일은행">SC제일은행</option>
						<option value="씨티은행">씨티은행</option>
						<option value="DGB대구은행">DGB대구은행</option>
						<option value="광주은행">광주은행</option>
						<option value="제주은행">제주은행</option>
						<option value="전북은행">전북은행</option>
						<option value="새마을금고">새마을금고</option>
						<option value="신협">신협</option>
						<option value="케이뱅크">케이뱅크</option>
						<option value="카카오뱅크">카카오뱅크</option>
					</select> <br> <input type="text" name="AccountHolder" placeholder="예금주"> <br>
					<input type="text" name="AccountNumber" placeholder="계좌번호">
				</div>

				<input type="submit" id="submit" value="결제하러가기">
			</form>
		</section>

		<footer> </footer>
	</div>
	
	<script>
	function sample6_execDaumPostcode() {
		new daum.Postcode({
			oncomplete: function(data) {
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
					if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
						extraAddr += data.bname;
					}
					// 건물명이 있고, 공동주택일 경우 추가한다.
					if (data.buildingName !== '' && data.apartment === 'Y') {
						extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
					}
					// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
					if (extraAddr !== '') {
						extraAddr = ' (' + extraAddr + ')';
					}
					// 조합된 참고항목을 해당 필드에 넣는다.
					document.getElementById("sample6_extraAddress").value = extraAddr;

				} else {
					document.getElementById("sample6_extraAddress").value = '';
				}

				// 우편번호와 주소 정보를 해당 필드에 넣는다.
				document.getElementById('sample6_postcode').value = data.zonecode;
				document.getElementById("sample6_address").value = addr;
				// 커서를 상세주소 필드로 이동한다.
				document.getElementById("sample6_detailAddress").focus();
			}
		}).open();
	}</script>

	<script src="${pageContext.request.contextPath}/resources/js/payment/payment.js"></script>
</body>

</html>