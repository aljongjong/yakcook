<%@page import="com.yakcook.member.controller.EmailConfirm"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<script type="text/javascript" src="resouce/JS/join.js"></script>
<%
String emailch=null;
String email=request.getParameter("email");
int emailNum = 0;
if(!email.equals("")){
	emailch=email;
}
// 위에서 작성한 java파일 객체 생성
EmailConfirm emailconfirm = new EmailConfirm();
String authNum=emailconfirm.connectEmail(email);
%>
<form method="post" action="" name="emailcheck">
	<table>
		<tr>
			<th colspan="2">인증번호를 입력하세요.</th>
		</tr>
		<tr>
			<td>
				<input type="text" name="emailconfirm">
			</td>
			<td>
				<input type="button" value="확인" 
                 onclick="confirmemail(emailcheck.emailconfirm.value,<%=authNum%>,<%=emailNum%>)">
			</td>
		</tr>
	</table>
</form>