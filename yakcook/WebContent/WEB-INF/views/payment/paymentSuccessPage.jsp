<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet"
	href="/yakcook/resources/css/payment/paymentSuccess.css">
</head>

<body>

    <div id="wrap">
        <header>
<%@ include file="/WEB-INF/views/common/headerFinal.jsp"%>
        </header>

        <section>
                <div id="response"> 
                   <div><h1>결제가 완료되었습니다.</h1>
                    <button id="home_btn" onclick="location.href='/yakcook'">리뷰목록 돌아가기</button></div>
                    
                </div>

        </section>

        <footer>
  <%@ include file="../common/footerFinal.jsp"%>
        </footer>
    </div>
    
</body>
</body>
</html>