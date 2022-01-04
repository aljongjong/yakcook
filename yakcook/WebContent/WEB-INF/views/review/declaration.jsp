<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
    <form action="declaration" method="post">
        <h1>게시물을 신고하시겠습니까?</h1>

        <div id="reson_form"><label for="">신고사유</label><br>
            <input type="radio" name="reason" value="불법광고">불법광고<br>
            <input type="radio" name="reason" value="반복게시(도배)">반복게시(도배)<br>
            <input type="radio" name="reason" value="악성코드">악성코드<br>
            <input type="radio" name="reason" value="음란성 또는 청소년에게 부적접한 내용">음란성 또는 청소년에게 부적접한 내용<br>
            <input type="radio" name="reason" value="욕설/인신공격">욕설/인신공격<br>
            <input type="radio" name="reason" value="개인정보노출">개인정보노출<br>
            <input type="radio" name="reason" id="기타">기타
            <input type="hidden" name="reviewNo" value="<%=request.getAttribute("reviewNo")%>">
      
        </div>
        <div id="otherReasons"><textarea name="otherReasons" id="" cols="30" rows="10"></textarea></div>
       <input type="submit" value="신고하기">

    </form>
    
    <script>
    </script>
</body>
</html>