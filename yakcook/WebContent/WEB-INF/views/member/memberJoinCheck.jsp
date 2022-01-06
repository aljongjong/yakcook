<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
*{margin: 0;padding: 0;box-sizing: border-box}
body{background-color: #f7f7f7;}
ul>li{list-style: none}
a{text-decoration: none;}
.clearfix::after{content: "";display: block;clear: both;}


#joinForm{width: 460px;margin: 0 auto;}
ul.join_box{border: 1px solid #ddd;background-color: #fff;}
.checkBox,.checkBox>ul{position: relative;}
.checkBox>ul>li{float: left;}
.checkBox>ul>li:first-child{width: 85%;padding: 15px;font-weight: 600;color: #888;}
.checkBox>ul>li:nth-child(2){position: absolute;top: 50%;right: 30px;margin-top: -12px;}
.checkBox textarea{width: 96%;height: 90px; margin: 0 2%;background-color: #f7f7f7;color: #888; border: none;}
.footBtwrap{margin-top: 15px;}
.footBtwrap>li{float: left;width: 50%;height: 60px;}
.footBtwrap>li>button{display: block; width: 100%;height: 100%; font-size: 20px;text-align: center;line-height: 60px;}
.fpmgBt1{background-color: #fff;color:#888}
.fpmgBt2{background-color: lightsalmon;color: #fff}


</style>
<body>
  <br><br>
<form action="join" id="joinForm" onsubmit="ChSubmit();">
  <div class = "checkbox_group">
  <ul class="join_box">
    <li class="checkBox check01">
      <ul class="clearfix">
        <li>이용약관, 개인정보 수집 및 이용,
          위치정보 이용약관(선택), 프로모션 안내
          메일 수신(선택)에 모두 동의합니다.</li>
        <li class="checkAllBtn">
          <input type="checkbox" name="chkAll" id="check_all" class="chkAll">
        </li>
      </ul>
    </li>
    <li class="checkBox check02">
      <ul class="clearfix">
        <li>이용약관 동의(필수)</li>
        <li class="checkBtn">
          <input type="checkbox" name="chk" class="normal" id="check_1">
        </li>
      </ul>
      <textarea>
제1조(목적) 

이 약관은 (주)케어위드 회사(사업자등록번호 : 759-87-00821, 통신판매업신고번호 : 제2020-서울강남-03029호, 대표자 : 고성훈)가 운영하는 온라인 웹사이트 약쿡 및 모바일 어플리케이션 약쿡케어(이하 두 서비스를 통칭하여 “약쿡”라 함)에서 제공하는 전자상거래 관련 서비스(이하 “서비스”라 한다.)를 이용함에 있어 약쿡와 이용자의 권리, 의무 및 책임사항을 규정함을 목적으로 합니다. 

*PC통신, 스마트폰 앱, 무선 등을 이용하는 전자상거래에 대해서도 그 성질에 반하지 않는 한 준용합니다. 



제2조(정의) 

① “약쿡"란 (주)케어위드 회사가 재화 또는 용역(이하 “재화 등"이라 함)을 이용자에게 제공하기 위하여 컴퓨터 등 정보통신설비를 이용하여 재화 등을 거래할 수 있도록 설정한 가상의 영업장 및 그에 부수되는 콘텐츠 서비스를 말하며, 아울러 서비스를 운영하는 사업자의 의미로도 사용합니다. 

② “이용자"란 “약쿡"에 접속하여 이 약관에 따라 “약쿡"가 제공하는 서비스를 받는 회원 및 비회원을 말합니다. 

③ “회원"이라 함은 “약쿡"에 회원등록을 한 자로서, 계속적으로 “약쿡"가 제공하는 서비스를 이용할 수 있는 자를 말합니다. 

④ “비회원"이라 함은 회원으로 가입하지 않고 “약쿡"가 제공하는 서비스를 이용하는 자를 말합니다. 



제3조 (약관 등의 명시와 설명 및 개정) 

① “약쿡”는 이 약관의 내용과 상호 및 대표자 성명, 영업소 소재지 주소(소비자의 불만을 처리할 수 있는 곳의 주소를 포함), 전화번호, 모사전송번호, 전자우편주소, 사업자등록번호, 통신판매업 신고번호, 개인정보관리책임자등을 이용자가 쉽게 알 수 있도록 약쿡의 초기 서비스화면(전면)에 게시합니다. 다만, 약관의 내용은 이용자가 연결화면을 통하여 볼 수 있도록 할 수 있습니다. 

② “약쿡"는 이용자가 약관에 동의하기에 앞서 약관에 정하여져 있는 내용 중 청약철회, 배송책임, 환불조건 등과 같은 중요한 내용을 이용자가 이해할 수 있도록 별도의 연결화면 또는 팝업화면 등을 제공하여 이용자의 확인을 구하여야 합니다. 

③ “약쿡”는「전자상거래 등에서의 소비자보호에 관한 법률」, 「약관의 규제에 관한 법률」, 「전자문서 및 전자거래기본법」, 「전자금융거래법」, 「전자서명법」, 「정보통신망 이용촉진 및 정보보호 등에 관한 법률」, 「방문판매 등에 관한 법률」, 「소비자기본법」 등 관련 법을 위배하지 않는 범위에서 이 약관을 개정할 수 있습니다. 

④ “약쿡”가 약관을 개정할 경우에는 적용일자 및 개정사유를 명시하여 현행약관과 함께 몰의 초기화면에 그 적용일자 7일 이전부터 적용일자 전일까지 공지합니다. 다만, 이용자에게 불리하게 약관내용을 변경하는 경우에는 최소한 30일 이상의 사전 유예기간을 두고 공지합니다. 이 경우 "약쿡“는 개정 전 내용과 개정 후 내용을 명확하게 비교하여 이용자가 알기 쉽도록 표시합니다. 

⑤ “약쿡”가 약관을 개정할 경우에는 그 개정약관은 그 적용일자 이후에 체결되는 계약에만 적용되고 그 이전에 이미 체결된 계약에 대해서는 개정 전의 약관조항이 그대로 적용됩니다. 다만 이미 계약을 체결한 이용자가 개정약관 조항의 적용을 받기를 원하는 뜻을 제3항에 의한 개정약관의 공지기간 내에 “약쿡”에 송신하여 “약쿡”의 동의를 받은 경우에는 개정약관 조항이 적용됩니다. 

⑥ 이 약관에서 정하지 아니한 사항과 이 약관의 해석에 관하여는 전자상거래 등에서의 소비자보호에 관한 법률, 약관의 규제 등에 관한 법률, 공정거래위원회가 정하는 전자상거래 등에서의 소비자 보호지침 및 관계법령 또는 상관례에 따릅니다. 



제4조(서비스의 제공 및 변경) 

① “약쿡”는 다음과 같은 서비스를 제공합니다. 

1. 재화 또는 용역에 대한 정보 제공 및 구매계약의 체결 

2. 구매계약이 체결된 재화 또는 용역의 배송

3. 이용자의 “약쿡” 서비스 이용에 도움이 되는 알람 및 콘텐츠 제공 

4. 기타 “약쿡”가 정하는 업무 

② “약쿡”가 제공하는 재화 또는 용역 서비스는 비의료 건강관리서비스로서 질환의 치료 목적의 서비스가 아닌 보조적 건강관리 서비스입니다. 특히 만성질환자의 경우 본 서비스 이용대상자가 아니며 의사 또는 의료기관의 도움을 받으시기를 권고 드립니다. 

③ “약쿡”는 재화 또는 용역의 품절 또는 기술적 사양의 변경 등의 경우에는 장차 체결되는 계약에 의해 제공할 재화 또는 용역의 내용을 변경할 수 있습니다. 이 경우에는 변경된 재화 또는 용역의 내용 및 제공일자를 명시하여 현재의 재화 또는 용역의 내용을 게시한 곳에 즉시 공지합니다. 

④ “약쿡”가 제공하기로 이용자와 계약을 체결한 서비스의 내용을 재화등의 품절 또는 기술적 사양의 변경 등의 사유로 변경할 경우에는 그 사유를 이용자에게 통지 가능한 주소로 즉시 통지합니다.

⑤ 전항의 경우 “약쿡”는 이로 인하여 이용자가 입은 손해를 배상합니다. 다만, “약쿡”가 고의 또는 과실이 없음을 입증하는 경우에는 그러하지 아니합니다. 



제5조(서비스의 중단) 

① “약쿡”는 연중무휴, 1일 24시간 제공을 원칙으로 합니다. 단, 컴퓨터 등 정보통신설비의 보수점검, 교체 및 고장, 통신의 두절 등의 사유가 발생한 경우에는 서비스의 제공을 일시적으로 중단할 수 있습니다. 

② “약쿡”는 제1항의 사유로 서비스의 제공이 일시적으로 중단됨으로 인하여 이용자 또는 제3자가 입은 손해에 대하여 배상합니다. 단, “약쿡”가 고의 또는 과실이 없음을 입증하는 경우에는 그러하지 아니합니다. 

③ 사업종목의 전환, 사업의 포기, 업체 간의 통합 등의 이유로 서비스를 제공할 수 없게 되는 경우에는 “약쿡”는 제8조에 정한 방법으로 이용자에게 통지하고 당초 “약쿡”에서 제시한 조건에 따라 소비자에게 보상합니다. 다만, “약쿡”가 보상기준 등을 고지하지 아니한 경우에는 이용자들의 포인트 또는 적립금 등을 “약쿡”에서 통용되는 통화가치에 상응하는 현물 또는 현금으로 이용자에게 지급합니다. 

④ 제3항에도 불구하고 “약쿡”가 이용자에게 사전에 통지할 수 없는 부득이한 사유가 있는 경우 사후에 통지할 수 있습니다.



제6조(회원가입) 

① 이용자는 “약쿡”가 정한 가입 양식에 따라 회원정보를 기입한 후 이 약관에 동의한다는 의사표시를 함으로서 회원가입을 신청합니다. 

② “약쿡”는 제1항과 같이 회원으로 가입할 것을 신청한 이용자 중 다음 각 호에 해당하지 않는 한 회원으로 등록합니다.

1. 가입신청자가 이 약관 제7조제3항에 의하여 이전에 회원자격을 상실한 적이 있는 경우, 다만 제7조제3항에 의한 회원자격 상실 후 3년이 경과한 자로서 “약쿡”의 회원재가입 승낙을 얻은 경우에는 예외로 함.

2. 등록 내용에 허위, 기재누락, 오기가 있는 경우 

3. 기타 회원으로 등록하는 것이 “약쿡”의 기술상 현저히 지장이 있다고 판단되는 경우 

4. 회원가입 및 전자상거래상의 계약에 관한 서비스는 만 14세 이상인자에 한함 

③ 회원가입계약의 성립 시기는 “약쿡”의 승낙이 회원에게 도달한 시점으로 합니다. 

④ 회원은 회원가입 시 등록한 사항에 변경이 있는 경우, 상당한 기간 이내에 “약쿡”에 대하여 회원정보 수정 등의 방법으로 그 변경사항을 알려야 합니다. 



제7조(회원 탈퇴 및 자격 상실 등) 

① 회원은 “약쿡”에 언제든지 탈퇴를 요청할 수 있으며 “약쿡”는 즉시 회원탈퇴를 처리합니다. 

② 회원이 다음 각 호의 사유에 해당하는 경우, “약쿡”는 회원자격을 제한 및 정지시킬 수 있습니다. 

1. 가입 신청 시에 허위 내용을 등록한 경우 

2. “약쿡”를 이용하여 구입한 재화 등의 대금, 기타 “약쿡”이용에 관련하여 회원이 부담하는 채무를 기일에 지급하지 않는 경우 

3. 다른 사람의 “약쿡” 이용을 방해하거나 그 정보를 도용하는 등 전자상거래 질서를 위협하는 경우 

4. “약쿡”를 이용하여 법령 또는 이 약관이 금지하거나 공서양속에 반하는 행위를 하는 경우 

③ “약쿡”가 회원 자격을 제한․정지 시킨 후, 동일한 행위가 2회 이상 반복되거나 30일 이내에 그 사유가 시정되지 아니하는 경우 “약쿡”는 회원자격을 상실시킬 수 있습니다. 

④ “약쿡”가 회원자격을 상실시키는 경우에는 회원등록을 말소합니다. 이 경우 회원에게 이를 통지하고, 회원등록 말소 전에 최소한 30일 이상의 기간을 정하여 소명할 기회를 부여합니다. 



제8조(회원에 대한 통지) 

① “약쿡”가 회원에 대한 통지를 하는 경우, 회원이 “약쿡”와 미리 약정하여 지정한 전자우편 주소로 할 수 있습니다. 

② “약쿡”는 불특정다수 회원에 대한 통지의 경우 1주일이상 “약쿡” 게시판에 게시함으로서 개별 통지에 갈음할 수 있습니다. 다만, 회원 본인의 거래와 관련하여 중대한 영향을 미치는 사항에 대하여는 개별통지를 합니다. 



제9조(구매신청) 

“약쿡”이용자는 “약쿡”상에서 다음 또는 이와 유사한 방법에 의하여 구매를 신청하며, “약쿡”는 이용자가 구매신청을 함에 있어서 다음의 각 내용을 알기 쉽게 제공하여야 합니다. 

1. 재화 등의 검색 및 선택 

2. 받는 사람의 성명, 주소, 전화번호, 전자우편주소(또는 이동전화번호) 등의 입력 

3. 약관내용, 청약철회권이 제한되는 서비스, 배송료 등의 비용부담과 관련한 내용에 대한 확인 

4. 이 약관에 동의하고 위 3.호의 사항을 확인하거나 거부하는 표시(예, 마우스 클릭) 

5. 재화등의 구매신청 및 이에 관한 확인 또는 “약쿡”의 확인에 대한 동의 

6. 결제방법의 선택 



제10조 (계약의 성립) 

① “약쿡”는 제9조와 같은 구매신청에 대하여 다음 각 호에 해당하면 승낙하지 않을 수 있습니다. 다만, 미성년자와 계약을 체결하는 경우에는 법정대리인의 동의를 얻지 못하면 미성년자 본인 또는 법정대리인이 계약을 취소할 수 있다는 내용을 고지하여야 합니다. 

1. 신청 내용에 허위, 기재누락, 오기가 있는 경우 

2. 미성년자가 담배, 주류 등 청소년보호법에서 금지하는 재화 및 용역을 구매하는 경우 

3. 기타 구매신청에 승낙하는 것이 “약쿡” 기술상 현저히 지장이 있다고 판단하는 경우 

② “약쿡”의 승낙이 제13조 제1항의 수신확인통지형태로 이용자에게 도달한 시점에 계약이 성립한 것으로 봅니다. 

③ “약쿡”의 승낙의 의사표시에는 이용자의 구매 신청에 대한 확인 및 판매가능 여부, 구매신청의 정정 취소 등에 관한 정보 등을 포함하여야 합니다. 



제11조(지급방법) 

“약쿡”에서 구매한 재화 또는 용역에 대한 대금지급방법은 다음 각 호의 방법중 가용한 방법으로 할 수 있습니다. 단, “약쿡”는 이용자의 지급방법에 대하여 재화 등의 대금에 어떠한 명목의 수수료도 추가하여 징수할 수 없습니다. 

① 폰뱅킹, 인터넷뱅킹, 메일 뱅킹 등의 각종 계좌이체 

② 선불카드, 직불카드, 신용카드 등의 각종 카드의 비인증식 정기결제 

③ 선불카드, 직불카드, 신용카드 등의 각종 카드의 인증식 일반결제 

④ 온라인무통장입금 

⑤ 포인트 등 “약쿡”가 지급한 적립금에 의한 결제 (단, 정기구매의 경우 최초 구매 신청시 1회 사용 가능) 

⑥ “약쿡"와 계약을 맺었거나 “약쿡"가 인증한 상품권에 의한 결제 

⑦ 기타 전자적 지급 방법에 의한 대금 지급 등 (각종 간편 결제 서비스) 



제12조(프로모션코드) 

① 프로모션코드는 회원에게 무상으로 발행되는 것으로 “약쿡"는 회원이 프로모션코드를 사이트에서 상품 구매 시 적용할 수 있도록 사용방법, 사용기간, 사용대상, 할인액 또는 할인율 등을 정할 수 있습니다. 프로모션코드의 종류와 내용은 “약쿡"의 정책에 따라 달라질 수 있습니다. 

② 프로모션코드는 현금으로 환급될 수 없으며, 프로모션코드의 사용기간이 만료되거나 구매 취소 시 또는 이용계약이 종료되면 소멸됩니다. 

③ “회원”은 허락되지 않은 방법으로 프로모션코드를 제3자에게 또는 다른 아이디로 양도할 수 없으며, 유상으로 거래하거나 현금으로 전환할 수 없습니다. 

④ “약쿡”는 회원이 “약쿡”가 승인하지 않은 방법으로 프로모션코드를 획득하거나 부정한 목적이나 용도로 프로모션코드를 사용하는 경우 프로모션코드의 사용을 제한하거나 프로모션코드를 사용한 구매신청을 취소하거나 회원 자격을 정지할 수 있습니다. 

⑤ “약쿡”는 “회원"이 사용한 프로모션코드와 동일한 프로모션코드로 재구매 시 해당 프로모션코드 적용을 하지 않을 수 있습니다. 



제13조(수신확인통지, 구매신청 변경 및 취소) 

① “약쿡”는 이용자의 구매신청이 있는 경우 이용자에게 수신확인통지를 합니다. 

② 수신확인통지를 받은 이용자는 의사표시의 불일치 등이 있는 경우에는 수신확인통지를 받은 후 즉시 구매신청 변경 및 취소를 요청할 수 있고 “약쿡”는 배송 전에 이용자의 요청이 있는 경우에는 지체 없이 그 요청에 따라 처리하여야 합니다. 다만 이미 대금을 지불한 경우에는 제16조의 청약철회 등에 관한 규정에 따릅니다. 



제14조(재화 등의 공급) 

① “약쿡”는 이용자와 재화 등의 공급시기에 관하여 별도의 약정이 없는 이상, 이용자가 청약을 한 날부터 7일 이내에 재화 등을 배송할 수 있도록 주문제작, 포장 등 기타의 필요한 조치를 취합니다. 다만, “약쿡”가 이미 재화 등의 대금의 전부 또는 일부를 받은 경우에는 대금의 전부 또는 일부를 받은 날부터 3영업일 이내에 조치를 취합니다. 이때 “약쿡”는 이용자가 재화 등의 공급 절차 및 진행 사항을 확인할 수 있도록 적절한 조치를 합니다. 

② “약쿡”는 이용자가 구매한 재화에 대해 배송수단, 수단별 배송비용 부담자, 수단별 배송기간 등을 명시합니다. 만약 “약쿡”가 약정 배송기간을 초과한 경우에는 그로 인한 이용자의 손해를 배상하여야 합니다. 다만 “약쿡”가 고의․과실이 없음을 입증한 경우에는 그러하지 아니합니다. 

③ 이용자는 “약쿡”가 지정하는 일부 서비스 항목 또는 “약쿡”가 지정한 기한에 한하여 회원가입 없이 무상으로 서비스를 이용할 수 있습니다. 



제15조(적립금 제도의 운영) 

① “약쿡”는 회원이 정기구매서비스를 이용하여 재화를 구매하거나 이벤트에 참여하는 등의 일정한 경우 적립금으로서 포인트를 부여할 수 있습니다. 이러한 포인트의 부여는 다음 각 호의 방법에 따르되, 그 구체적인 운영방법은 회사의 운영정책에 따릅니다. 

1. “약쿡”는 회원의 결제금액에 대하여 서비스 페이지에 고지한 특정한 비율만큼 포인트를 부여할 수 있습니다. 단, 이 경우 적립대상금액은 쿠폰, 프로모션 등 기타 방법을 통해 할인 받은 금액은 제외됩니다.

2. “약쿡”는 회원이 서비스나 이벤트 등에 참여할 경우 포인트를 부여할 수 있습니다.

3. “약쿡”에서 회원이 구매한 재화를 반품하였을 때 해당 구매로 적립된 포인트는 환수됩니다.

② 포인트는 “약쿡”의 서비스 제도로서 “약쿡”가 회원에게 사전 고지한 조건 및 비율에 따라 “약쿡”의 포인트몰에서 특정 재화로 교환이 가능합니다. 단, 포인트는 사은의 형태로 “약쿡”에서 지급하는 것으로 현금으로 환불되지는 않으며 타인에게 양도할 수 없습니다.

③ 포인트의 사용기한은 최초 적립일로부터 1년이며, 기한내 사용하지 않은 포인트는 소멸됩니다. 단일상품의 구매로 인하여 일시에 부여된 포인트에 대해서 그 중 일부만을 사용한 경우에도 동일합니다. 단, 포인트 부여시 적립금 사용기간에 대해 별도의 사전 고지 또는 특약이 있는 경우에는 그 사용기간 이내에 사용하여야 합니다.

④ 다음의 경우 포인트가 소멸됩니다.

1. 회원을 탈퇴한 경우

2. 사용기간이 경과한 경우

3. 사용가능 조건 및 소멸에 대한 내용이 별도로 공지된 경우

⑤ 포인트를 이용하여 부당 이득을 취하거나, 악의적인 상거래가 발생할 경우, “약쿡”는 포인트에 대해 지급을 중지하며 기지급된 포인트를 환수할 수 있습니다.



제16조(환급) 

“약쿡”는 이용자가 구매신청한 재화 등이 품절 등의 사유로 인도 또는 제공을 할 수 없을 때에는 지체 없이 그 사유를 이용자에게 통지하고 사전에 재화 등의 대금을 받은 경우에는 대금을 받은 날부터 3영업일 이내에 환급하거나 환급에 필요한 조치를 취합니다. 



제17조(청약철회 등) 

① “약쿡”와 재화등의 구매에 관한 계약을 체결한 이용자는 「전자상거래 등에서의 소비자보호에 관한 법률」 제13조 제2항에 따른 계약내용에 관한 서면을 받은 날(그 서면을 받은 때보다 재화 등의 공급이 늦게 이루어진 경우에는 재화 등을 공급받거나 재화 등의 공급이 시작된 날을 말합니다)부터 7일 이내에는 청약의 철회를 할 수 있습니다. 다만, 청약철회에 관하여 「전자상거래 등에서의 소비자보호에 관한 법률」에 달리 정함이 있는 경우에는 동 법 규정에 따릅니다. 

② 이용자는 재화 등을 배송 받은 경우 다음 각 호의 1에 해당하는 경우에는 반품 및 교환을 할 수 없습니다. 

1. 이용자에게 책임 있는 사유로 재화 등이 멸실 또는 훼손된 경우 (다만, 재화 등의 내용을 확인하기 위하여 포장 등을 훼손한 경우에는 청약철회를 할 수 있습니다) 

2. 이용자의 사용 또는 일부 소비에 의하여 재화 등의 가치가 현저히 감소한 경우 

3. 시간의 경과에 의하여 재판매가 곤란할 정도로 재화등의 가치가 현저히 감소한 경우 

4. 같은 성능을 지닌 재화 등으로 복제가 가능한 경우 그 원본인 재화 등의 포장을 훼손한 경우 

③ 제2항제2호 내지 제4호의 경우에 “약쿡”가 사전에 청약철회 등이 제한되는 사실을 소비자가 쉽게 알 수 있는 곳에 명기하거나 시용상품을 제공하는 등의 조치를 하지 않았다면 이용자의 청약철회 등이 제한되지 않습니다. 

④ 이용자는 제1항 및 제2항의 규정에 불구하고 재화 등의 내용이 표시•광고 내용과 다르거나 계약내용과 다르게 이행된 때에는 당해 재화 등을 공급받은 날부터 3월 이내, 그 사실을 안 날 또는 알 수 있었던 날부터 30일 이내에 청약철회 등을 할 수 있습니다. 



제18조(청약철회 등의 효과) 

① “약쿡”는 이용자로부터 재화 등을 반환받은 경우 3영업일 이내에 이미 지급받은 재화 등의 대금을 환급합니다. 이 경우 “약쿡”가 이용자에게 재화등의 환급을 지연한 때에는 그 지연기간에 대하여 「전자상거래 등에서의 소비자보호에 관한 법률 시행령」제21조의2에서 정하는 지연이자율(괄호 부분 삭제)을 곱하여 산정한 지연이자를 지급합니다. 

② “약쿡”는 위 대금을 환급함에 있어서 이용자가 신용카드 또는 전자화폐 등의 결제수단으로 재화 등의 대금을 지급한 때에는 지체 없이 당해 결제수단을 제공한 사업자로 하여금 재화 등의 대금의 청구를 정지 또는 취소하도록 요청합니다. 

③ 청약철회 등의 경우 공급받은 재화 등의 반환에 필요한 비용은 이용자가 부담합니다. “약쿡”는 이용자에게 청약철회 등을 이유로 위약금 또는 손해배상을 청구하지 않습니다. 다만 재화 등의 내용이 표시•광고 내용과 다르거나 계약내용과 다르게 이행되어 청약철회 등을 하는 경우 재화 등의 반환에 필요한 비용은 “약쿡”가 부담합니다. 

④ 이용자가 재화 등을 제공받을 때 발송비를 부담한 경우에 “약쿡”는 청약철회 시 그 비용을 누가 부담하는지를 이용자가 알기 쉽도록 명확하게 표시합니다. 



제19조(“약쿡“의 의무) 

① “약쿡”는 법령과 이 약관이 금지하거나 공서양속에 반하는 행위를 하지 않으며 이 약관이 정하는 바에 따라 지속적이고, 안정적으로 재화․용역을 제공하는데 최선을 다하여야 합니다. 

② “약쿡”는 이용자가 안전하게 인터넷 서비스를 이용할 수 있도록 이용자의 개인정보(신용정보 포함)보호를 위한 보안 시스템을 갖추어야 합니다. 

③ “약쿡”가 상품이나 용역에 대하여 「표시․광고의 공정화에 관한 법률」 제3조 소정의 부당한 표시․광고행위를 함으로써 이용자가 손해를 입은 때에는 이를 배상할 책임을 집니다. 

④ “약쿡”는 이용자가 원하지 않는 영리목적의 광고성 전자우편을 발송하지 않습니다. 



제20조(회원의 ID 및 비밀번호에 대한 의무) 

① ID와 비밀번호에 관한 관리책임은 회원에게 있으며, 어떠한 경우에도 본인의 ID 또는 비밀번호를 양도하거나 대여할 수 없습니다. 

② 회원은 자신의 ID 및 비밀번호를 제3자에게 이용하게 해서는 안되며, “약쿡”의 귀책사유 없이 이를 유출, 양도, 대여한 행위로 인하여 발생하는 손실이나 손해에 대하여는 회원 본인이 그에 대한 책임을 부담합니다.  

③ 회원이 자신의 ID 및 비밀번호를 도난당하거나 제3자가 사용하고 있음을 인지한 경우에는 바로 “약쿡”에 통보하고 “약쿡”의 안내가 있는 경우에는 그에 따라야 합니다. 



제21조(이용자의 의무) 

이용자는 다음 행위를 하여서는 안 됩니다. 

1. 신청 또는 변경 시 허위 내용의 등록 

2. 타인의 정보 도용 

3. “약쿡”에 게시된 정보의 변경 

4. “약쿡”가 정한 정보 이외의 정보(컴퓨터 프로그램 등) 등의 송신 또는 게시 

5. “약쿡” 기타 제3자의 저작권 등 지적재산권에 대한 침해 

6. “약쿡” 기타 제3자의 명예를 손상시키거나 업무를 방해하는 행위 

7. 외설 또는 폭력적인 메시지, 화상, 음성, 기타 공서양속에 반하는 정보를 몰에 공개 또는 게시하는 행위 



제22조(정기구매서비스 제공 및 이용자격) 

① 정기구매서비스는 “약쿡" 회원의 편의를 위하여 상품을 정기적으로 결제하고 배송하는 서비스입니다. 

② 정기구매서비스는 “약쿡"회원이면 누구나 정기구매서비스를 신청함으로써 이용 가능합니다. 



제23조(정기구매서비스 상품의 결제 등) 

① “약쿡"는 정기구매서비스 상품에 대하여 할인혜택을 제공할 수 있으며, 할인율 및 거래조건 등은 상품별로 다를 수 있고 변경될 수 있습니다. 할인율 및 거래조건 등이 회원에게 불리하게 변경되는 경우 “약쿡"는 2주 이상의 상당한 기간 동안 위 변경에 대하여 공지하고, 회원은 위 변경에 동의하지 않으면 위 기간 동안 본 서비스를 종료시킬 수 있으며, 위 기간 동안 서비스를 종료시키지 않으면 위 변경에 회원이 동의한 것으로 봅니다. 

② 정기구매서비스의 특성상 상품의 가격은 계속적으로 변경될 수 있으며, 회원에게 고지된 시점의 상품가격을 기준으로 결제가 이루어집니다. 가격 결정의 기준 시점은 변경될 수 있습니다. 

③ 정기구매서비스 상품의 추가 또는 변경 시 결제되는 총 상품의 금액은 변경될 수 있습니다. 

④ 카드한도 초과 등 상품의 결제가 이루어지지 않을 경우, 해당 회차의 정기구매 주문은 이루어지지 않을 수 있으며, 위와 같은 상황이 2회 이상 지속되는 경우 “약쿡"는 정기구매서비스를 중지할 수 있습니다. 



제24조(정기구매서비스 상품의 판매 종료 등) 

① 정기구매서비스의 대상 상품을 품절 등의 사유로 더 이상 판매할 수 없거나 해당 상품을 정기구매서비스로 제공할 수 없는 사유가 있는 경우, “약쿡"는 해당 상품의 정기구매서비스를 종료하거나 해당 회차의 상품을 공급하지 않을 수 있습니다. 

② 재화 등의 대금을 환급하여야 하는 경우 제16조에서 정한 사항에 따릅니다. 



제25조(정기구매서비스의 종료) 

① 회원이 “약쿡"에게 정기구매서비스의 종료를 통지하거나, “약쿡"의 마이페이지에서 해지 신청함으로써 정기구매서비스를 종료시킬 수 있습니다. 

② 정기구매서비스가 종료된 경우 해당 정기구매서비스에 적용된 프로모션코드와 장기구매고객할인 등 각종 혜택은 동시에 종료됩니다. 



제26조(정기구매서비스 이용의 제한) 

① 회원의 통지 또는 과실에 의해서 정기구매서비스가 중지되는 경우, 해당 상품의 정기구매 서비스 신청이 2개월의 범위 내에서 제한될 수 있습니다. 

② “약쿡"는 특정상품에 대하여 구매 수량을 제한할 수 있습니다. 

③ “약쿡"는 상품의 재판매 가능성이 있는 경우, 또는 불법적이거나 부당한 행위와 관련된 경우 정기구매서비스 제공을 제한할 수 있습니다. 

④ 서비스 이용의 제한에 대한 구체적인 기준은 내부 운영정책에 따라 적용됩니다. 

⑤ “약쿡"는 자체적인 시스템을 통해 모니터링과 각종 기관에서 접수된 민원 내용, 수사기관의 정보 등을 통해 정황을 확인한 후 정기구매서비스 제한 사유행위를 한 것으로 추정되는 경우 정기구매서비스 이용을 제한할 수 있습니다. 



제27조(저작권의 귀속 및 이용제한) 

① “약쿡“가 작성한 저작물에 대한 저작권 기타 지적재산권은 "약쿡"에 귀속합니다. 

② 이용자는 “약쿡”를 이용함으로써 얻은 정보 중 “약쿡”에게 지적재산권이 귀속된 정보를 “약쿡”의 사전 승낙 없이 복제, 송신, 출판, 배포, 방송 기타 방법에 의하여 영리목적으로 이용하거나 제3자에게 이용하게 하여서는 안됩니다. 

③ “약쿡”는 약정에 따라 이용자에게 귀속된 저작권을 사용하는 경우 당해 이용자에게 통보하여야 합니다. 



제28조(면책조항) 

① “약쿡”는 천재지변 또는 이에 준하는 불가항력으로 인하여 서비스를 제공할 수 없는 경우에는 서비스 제공에 관한 책임이 면제됩니다. 

② “약쿡”는 의 귀책사유로 인한 서비스 이용의 장애에 대하여 책임을 지지 않습니다. 

③ “약쿡”는 회원이 서비스를 이용하여 기대하는 수익을 상실한 것에 대하여 책임을 지지 않으며, 그 밖의 서비스를 통하여 얻은 자료로 인한 손해에 관하여 책임을 지지 않습니다. 

④ “약쿡”는 회원이 게재한 정보, 자료, 사실의 신뢰도, 정확성 등 내용에 관해서는 책임을 지지 않습니다. 

⑤ “약쿡”는 회원 간 또는 회원과 제3자 상호간에 서비스를 매개로 하여 거래 등을 한 경우에는 책임을 지지 않습니다. 



제29조(분쟁해결) 

① “약쿡”는 이용자가 제기하는 정당한 의견이나 불만을 반영하고 그 피해를 보상처리하기 위하여 피해보상처리기구를 설치․운영합니다. 

② “약쿡”는 이용자로부터 제출되는 불만사항 및 의견은 우선적으로 그 사항을 처리합니다. 다만, 신속한 처리가 곤란한 경우에는 이용자에게 그 사유와 처리일정을 즉시 통보해 드립니다. 

③ “약쿡”와 이용자 간에 발생한 전자상거래 분쟁과 관련하여 이용자의 피해구제신청이 있는 경우에는 공정거래위원회 또는 시•도지사가 의뢰하는 분쟁조정기관의 조정에 따를 수 있습니다. 



제30조(재판권 및 준거법) 

① “약쿡”와 이용자 간에 발생한 전자상거래 분쟁에 관한 소송은 제소 당시의 이용자의 주소에 의하고, 주소가 없는 경우에는 거소를 관할하는 지방법원의 전속관할로 합니다. 다만, 제소 당시 이용자의 주소 또는 거소가 분명하지 않거나 외국 거주자의 경우에는 민사소송법상의 관할법원에 제기합니다. 

② “약쿡”와 이용자 간에 제기된 전자상거래 소송에는 한국 법을 적용합니다. 



이 약관은 2020년 8월 11일부터 시행됩니다. 단, 본 약관의 공지 이후 시행일 이전에 본 약관에 동의한 경우에는 동의 시부터 본 약관이 적용됩니다. 



이전 약관(2018년 8월 8일자 시행) 보기 ▶︎

       </textarea>
    </li>
    <li class="checkBox check03">
      <ul class="clearfix">
        <li>개인정보 수집 및 이용에 대한 안내(필수)</li>
        <li class="checkBtn">
          <input type="checkbox" name="chk" class="normal" id="check_2">
        </li>
      </ul>

      <textarea name="" id="">
(주)케어위드는 (이하 "회사"는) 고객님의 개인정보를 중요시하며 개인정보보호법 등 관련 법령을 준수하고 있습니다. 회사는 개인정보처리방침을 통하여 고객님께서 제공하시는 개인정보가 어떠한 용도와 방식으로 이용되고 있으며, 개인정보보호를 위해 어떠한 조치가 취해지고 있는지 알려드립니다.



 ■ 수집하는 개인정보 항목 및 수집방법 

가. 수집하는 개인정보의 항목 

* 회사는 회원가입, 고객 상담, 서비스 신청 및 제공 등을 위해 아래와 같은 개인정보를 수집하고 있습니다. 

- 회원가입시(필수): 이메일(로그인ID), 비밀번호, 이름, 휴대전화번호 

- 회원가입시(선택): 카카오톡•네이버•페이스북 연동정보(이름/이메일/회원번호), 주소, 성별, 생년월일 

- 설문 참여시(선택): 성별, 연령대, 건강과 관련된 정보

- 구매 또는 서비스 신청시(필수): 결제 정보, 수취인의 배송지 정보(수취인명, 휴대전화번호, 수취인 주소) 

- 모바일앱 사용시: 앱 버전, OS버전 

* 서비스 이용 과정이나 사업 처리 과정에서 서비스 이용기록, 접속로그, 쿠키, 접속 IP, 결제 기록, 불량이용 기록, ADID/IDFA(광고식별자)가 생성되어 수집될 수 있습니다. 

나. 수집방법 

- 홈페이지, 설문 진행, 서면양식, 게시판, 이메일, 이벤트 응모, 배송요청, 전화, 팩스, 생성 정보 수집 툴을 통한 수집 



■ 개인정보의 수집 및 이용목적 

회사는 수집한 개인정보를 다음의 목적을 위해 활용합니다. 

* 서비스 제공에 관한 계약 이행 및 서비스 제공에 따른 요금정산 콘텐츠 제공, 구매 및 요금 결제, 물품배송 또는 청구지 등 발송, 금융거래 본인 인증 및 금융 서비스 

* 회원 관리 회원제 서비스 이용에 따른 본인확인, 개인 식별, 불량회원의 부정 이용 방지와 비인가 사용 방지, 가입 의사 확인, 불만처리 등 민원처리, 고지사항 전달 

* 마케팅 및 광고에 활용 이벤트 등 광고성 정보 전달, 접속 빈도 파악 또는 회원의 서비스 이용에 대한 통계 



■ 개인정보의 보유 및 이용기간 

원칙적으로, 개인정보 수집 및 이용목적이 달성된 후에는 해당 정보를 지체 없이 파기합니다. 단, 다음의 정보에 대해서는 아래의 이유로 명시한 기간 동안 보존합니다. 

가. 회사 내부방침에 의한 정보보유 사유 회원이 탈퇴한 경우에도 불량회원의 부정한 이용의 재발을 방지, 분쟁해결 및 수사기관의 요청에 따른 협조를 위하여, 이용계약 해지일로부터 3년간 회원의 정보를 보유할 수 있습니다. 

나. 관련 법령에 의한 정보 보유 사유 전자상거래등에서의소비자보호에관한법률 등 관계법령의 규정에 의하여 보존할 필요가 있는 경우 회사는 아래와 같이 관계법령에서 정한 일정한 기간 동안 회원정보를 보관합니다. 

* 계약 또는 청약철회 등에 관한 기록 

-보존이유: 전자상거래등에서의소비자보호에관한법률 

-보존기간: 5년 

* 대금 결제 및 재화 등의 공급에 관한 기록 

-보존이유: 전자상거래등에서의소비자보호에관한법률 

-보존기간: 5년 

* 소비자 불만 또는 분쟁처리에 관한 기록 

-보존이유: 전자상거래등에서의소비자보호에관한법률 

-보존기간: 3년 

* 로그 기록 

-보존이유: 통신비밀보호법 

-보존기간: 3개월 



■ 개인정보의 파기절차 및 방법 

회사는 원칙적으로 개인정보 수집 및 이용목적이 달성된 후에는 해당 정보를 지체없이 파기합니다. 파기절차 및 방법은 다음과 같습니다. 

* 파기절차 

회원님이 회원가입 등을 위해 입력하신 정보는 목적이 달성된 후 별도의 DB로 옮겨져(종이의 경우 별도의 서류함) 내부 방침 및 기타 관련 법령에 의한 정보보호 사유에 따라(보유 및 이용기간 참조) 일정 기간 저장된 후 파기되어집니다. 별도 DB로 옮겨진 개인정보는 법률에 의한 경우가 아니고서는 보유되어지는 이외의 다른 목적으로 이용되지 않습니다. 

* 파기방법 

전자적 파일형태로 저장된 개인정보는 기록을 재생할 수 없는 기술적 방법을 사용하여 삭제합니다. 



■ 개인정보 제공 

회사는 이용자의 개인정보를 원칙적으로 외부에 제공하지 않습니다. 다만, 아래의 경우에는 예외로 합니다. 

* 이용자들이 사전에 동의한 경우 

* 법령의 규정에 의거하거나, 수사 목적으로 법령에 정해진 절차와 방법에 따라 수사기관의 요구가 있는 경우 



■ 수집한 개인정보의 위탁 

회사는 서비스 이행을 위해 아래와 같이 외부 전문업체에 위탁하여 운영하고 있습니다. 

* NICE페이먼츠 (결제서비스) 

* 아마존 웹 서비스 (보안 및 서비스 인프라 강화) 

* (주)두손컴퍼니, CJ대한통운(주) (택배 배송 서비스) 

* (주)링크허브, 카카오 (카카오알림톡, SMS/LMS/MMS 발송서비스) 

* 메일침프, 아마존 웹 서비스 (이메일 서비스) 



■ 이용자 및 법정대리인의 권리와 그 행사방법 

* 이용자는 언제든지 등록되어 있는 자신의 개인정보를 조회하거나 수정할 수 있으며 가입해지를 요청할 수도 있습니다. 

* 이용자들의 개인정보 조회, 수정을 위해서는 "개인정보변경"(또는 "회원정보수정" 등)을 가입해지(동의철회)를 위해서는 "회원탈퇴"를 클릭하여 본인 확인 절차를 거치신 후 직접 열람, 정정 또는 탈퇴가 가능합니다. 

* 혹은 개인정보관리책임자에게 서면, 전화 또는 이메일로 연락하시면 지체없이 조치하겠습니다. 

* 귀하가 개인정보의 오류에 대한 정정을 요청하신 경우에는 정정을 완료하기 전까지 당해 개인정보를 이용 또는 제공하지 않습니다. 또한 잘못된 개인정보를 제3자에게 이미 제공한 경우에는 정정 처리결과를 제3자에게 지체없이 통지하여 정정이 이루어지도록 하겠습니다.

* 회사는 이용자의 요청에 의해 해지 또는 삭제된 개인정보는 "회사가 수집하는 개인정보의 보유 및 이용기간"에 명시된 바에 따라 처리하고 그 외의 용도로 열람 또는 이용할 수 없도록 처리하고 있습니다. 



■ 개인정보 자동수집 장치의 설치, 운영 및 그 거부에 관한 사항 

* 회사는 귀하의 정보를 수시로 저장하고 찾아내는 "쿠키(cookie)" 등을 운용합니다. 쿠키란 웹사이트를 운영하는데 이용되는 서버가 귀하의 브라우저에 보내는 아주 작은 텍스트 파일로서 귀하의 컴퓨터 하드디스크에 저장됩니다. 회사는 다음과 같은 목적을 위해 쿠키를 사용합니다. 
모바일 어플리케이션과 같이 쿠키 기능을 사용할 수 없는 경우에는 쿠키와 유사한 기능을 수행하는 기술(광고식별자 등)을 사용할 수도 있습니다.

* 쿠키 등 사용 목적 

1. 회원과 비회원의 접속 빈도나 방문 시간 등을 분석, 이용자의 취향과 관심분야를 파악 및 자취 추적, 각종 이벤트 참여 정도 및 방문 회수 파악 등을 통한 타겟 마케팅 및 개인 맞춤 서비스 제공 

2. 귀하는 쿠키 설치에 대한 선택권을 가지고 있습니다. 따라서, 귀하는 웹브라우저에서 옵션을 설정함으로써 모든 쿠키를 허용하거나, 쿠키가 저장될 때마다 확인을 거치거나, 아니면 모든 쿠키의 저장을 거부할 수도 있습니다. 

* 쿠키 설정 거부 방법 

1. 쿠키 설정을 거부하는 방법으로는 회원님이 사용하시는 웹 브라우저의 옵션을 선택함으로써 모든 쿠키를 허용 하거나 쿠키를 저장할 때마다 확인을 거치거나, 모든 쿠키의 저장을 거부할 수 있습니다. 

2. 설정방법 예(인터넷 익스플로어의 경우): 웹 브라우저 상단의 도구 > 인터넷 옵션 > 개인정보 

3. 단, 귀하께서 쿠키 설치를 거부하였을 경우 서비스 제공에 어려움이 있을 수 있습니다. 



■ 개인정보에 관한 민원서비스 

회사는 고객의 개인정보를 보호하고 개인정보와 관련한 불만을 처리하기 위하여 아래와 같이 관련 부서 및 개인정보관리책임자를 지정하고 있습니다. 

* 개인정보관리담당자 성명: 김종령 소속: (주)케어위드 전화번호: 02-6203-9810 이메일: info@carewith.us 

* 개인정보관리책임자 성명: 고성훈 소속: (주)케어위드 전화번호: 02-6203-9810 이메일: info@carewith.us 

* 귀하께서는 회사의 서비스를 이용하시며 발생하는 모든 개인정보보호 관련 민원을 개인정보관리책임자 혹은 담당부서로 신고하실 수 있습니다. 

* 회사는 이용자들의 신고사항에 대해 신속하게 충분한 답변을 드릴 것입니다. 

* 기타 개인정보침해에 대한 신고나 상담이 필요하신 경우에는 아래 기관에 문의하시기 바랍니다. 

개인정보침해신고센터 (privacy.kisa.or.kr / 국번 없이 118) 대검찰청 사이버범죄수사단 (www.spo.go.kr / 02-3480-2000) 경찰청 사이버안전국 (www.ctrc.go.kr/ 국번 없이 182) 



■ 모바일 앱 사용시 광고 식별자 (ADID/IDFA) 수집 

회사는 귀하의 ADID/IDFA를 수집할 수 있습니다. ADID/IDFA란 모바일 앱 이용자의 광고 식별 값으로서, 사용자의 맞춤 서비스 제공이나 더 나은 환경의 광고를 제공하기 위한 측정을 위해 수집될 수 있습니다. 

[거부방법] 

: iOS 설정->개인 정보 보호->광고->광고 추적 제한 

: 안드로이드 설정->구글(구글설정)->광고->광고 맞춤설정 선택 해제 



■온라인 맞춤형 광고 서비스 

회사는 다음과 같이 온라인 맞춤형 광고 사업자가 행태정보를 수집하도록 허용하고 있습니다. 

행태정보를 수집 및 처리하는 광고 사업자: 구글, 페이스북, Appsflyer, Dable, Naver 

행태정보 수집방법: 이용자가 당사 웹사이트 방문하거나 앱을 실행할 때 자동 수집 및 전송 



■ 개인정보처리방침의 개정과 그 공지 

이 개인정보처리방침은 2020년 8월 11일부터 적용됩니다. 

현 개인정보처리방침이 회사 또는 정부의 정책, 보안기술의 변경에 따라 내용의 추가, 삭제 및 변경이 있을 경우, 회사는 변경사항의 시행 7일 전부터 인터넷 홈페이지, 어플리케이션의 '공지사항'을 통해 고지할 것입니다. 변경된 개인정보처리방침은 변경 고지한 날로부터 7일 후부터 효력이 발생합니다.



이전의 개인정보처리방침은 아래에서 확인하실 수 있습니다. 



이전 개인정보처리방침(2018년 8월 8일자 시행) 보기 ▶︎

       </textarea>
    </li>
    <li class="checkBox check03">
      <ul class="clearfix">
        <li>위치정보 이용약관 동의(선택)</li>
        <li class="checkBtn">
          <input type="checkbox" name="chk" class="normal" id="check_3">
        </li>
      </ul>

      <textarea name="" id="">■ “약쿡"는 회원가입 시 수집된 개인정보를 이용하여 탈퇴 시까지 각종 서비스, 제품 및 유용한 컨텐츠에 대해서 홍보,

구매권유, 프로모션, 이벤트 안내 등의 목적으로 본인에게 정보, 광고를 전화, 문자메시지, 카카오톡, 페이스북 메시지,

이메일, 우편 및 앱 푸시 등의 방법으로 전달합니다.



■ “약쿡"는 구매, 배송, 복용관리 등 의무적으로 안내되어야 하는 정보성 내용은 수신동의 여부와 무관하게 제공됩니다.



■ 개인정보보호법 제22조 제4항에 의해 동의하지 않을 권리가 있으며, 동의하지 않는 경우에도 회원 가입 및 상품 구매는

 가능합니다.
       </textarea>
    </li>
    <li class="checkBox check04">
      <ul class="clearfix">
        <li>이벤트 등 프로모션 알림 메일 수신(선택)</li>
        <li class="checkBtn">
          <input type="checkbox" name="chk" class="normal">
        </li>
      </ul>

    </li>
  </ul>
  <ul class="footBtwrap clearfix">
    <li><button class="fpmgBt1">비동의</button></li>
    <li><button class="fpmgBt2" id="nextBtn">동의</button></li>
   
  </ul>
  </div>
</form>

<script>
  // 체크박스 전체 선택
  $(".checkbox_group").on("click", "#check_all", function () {
    $(this).parents(".checkbox_group").find('input').prop("checked", $(this).is(":checked"));
  });
  
     $(document).ready(function () {
          $("#nextBtn").click(function () {
            if ($("#check_1").is(":checked") == false) {
              alert("모든 약관에 동의 하셔야 다음 단계로 진행 가능합니다.");
              return false;
            } else if ($("#check_2").is(":checked") == false) {
              alert("모든 약관에 동의 하셔야 다음 단계로 진행 가능합니다");
              return false;
            } else if ($("#check_3").is(":checked") == false) {
              alert("모든 약관에 동의 하셔야 다음 단계로 진행 가능합니다");
              return false;
            } else {
            }
          });
        }); 
</script>
</body>
</body>
</html>