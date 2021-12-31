<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>결제페이지</title>
    <link rel="stylesheet" href="./01_결제.css">
    <script src="http://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>

<body>
    <div id="wrap">
        <header>

        </header>

        <section>

            <div id="postdiv">
                <!--수령자 정보-->

                <div id="order"><label>주문자</label></div>
                <div id="order-info">

                    <label>이름</label>
                    <br>
                    <input type="text" name="order" id="order">
                    <br>
                    <label>연락처</label>
                    <br>
                    <input type="text" name="phone1" class="phone" maxlength="3"> -
                    <input type="text" name="phone2" class="phone" maxlength="4"> -
                    <input type="text" name="phone3" class="phone" maxlength="4">
                    <br>
                </div>

                <div id="addressname">
                    <label>배송지</label>
                </div>

                <div id="orderaddress">
                    <label>이름</label><br>
                    <input type="text" name="" id=""><br>


                    <label>우편번호</label><br>
                    <input type="text" id="postcode" placeholder="우편번호"><br>
                    <input type="button" onclick="execDaumPostcode()" value="우편번호 검색" id="postbtn"><br>


                    <label>배송지</label>
                    <br>
                    <input type="text" id="address" placeholder="주소"><br>


                    상세주소
                    <br>
                    <input type="text" id="detailAddress" placeholder="상세주소">
                </div>

                <div id="delivery_memo">
                    <label>배송메모</label>
                    <select name="memo_option" id="memo_option">
                        <option value="postmemo1">배송 시 요청사항을 선택해주세요</option>
                        <option value="postmemo2">부재 시 경비실에 맡겨주세요</option>
                        <option value="postmemo3">부재 시 집 앞에 놔주세요</option>
                        <option value="postmemo4">배송 전 연락 바랍니다</option>
                        <option value="postmemo5">파손의 위험이 있는 상품입니다 배송시 주의해주세요</option>
                        <option value="postmemo6">직접입력</option>
                    </select>
                    <br>
                    <textarea name="selbox" id="selbox" cols="60" rows="5" maxlength="50" placeholder="최대 50까지 가능합니다."></textarea>
                    <br>
                    <span id="추가배송비">제주 및 산간 지역의 배송은 추가 배송비가 발생할 수 있습니다. </span>
                </div>



            </div>

            <div id="info-list">
                <!--결제정보-->
                <div>
                    <span id="sum">상품 합계</span>
                    <span id="pro.val">155000</span>
                </div>

                <div>
                    <span id="delivery">배송비</span>
                    <span id="delivery.val">3000</span>
                </div>

                <div>
                    <span id="sale">총 할인 금액</span>
                    <span id="sale.val">0</span>
                </div>

                <div>
                    <span>결제 금액</span>
                    <span>158000</span>
                </div>

            </div>

            
        </section>

        <footer>


        </footer>
    </div>
    <script>
        // 카카오주소 API
        function execDaumPostcode() {
            new daum.Postcode({
                oncomplete: function (data) {
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
        };


        $(function () {
            $("#selbox").hide();

            $("#memo_option").change(function () {
                if ($("#memo_option").val() == "postmemo6") {
                    $("#selbox").show();
                } else {
                    $("#selbox").hide();
                }
            })
        });

      


    </script>
</body>

</html>