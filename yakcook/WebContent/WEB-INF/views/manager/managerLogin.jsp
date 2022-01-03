<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title>
<link rel="stylesheet" href="/yakcook/resources/css/manager/managerLogin.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<section>
		<h1>관리자 로그인</h1>
		<div class="login">
			<div class="wrap">
				<label for="id" class="write">아이디</label>
				<br> 
				<input type="text" name="id" class="insert" id="id" required>
				<br>
				<label for="pwd" class="write">비밀번호 </label>
				<br>
				<input type="password" name="pwd" class="insert" id="pwd" required>
				<br>
				<input type="submit" class="btn1">
			</div>
		</div>
	</section>
	<script>
	window.onload=()=>{
		$(document).on('click','.btn1', function(){
        	$.ajax({
        		url : '/yakcook/managerlogin',
        		method : 'post',
        		data: {
        			id : $('#id').val(),
        			pwd : $('#pwd').val()
        		},
        		
        		success : function(result){
       				const data1 = $.trim(result);
       				if(data1 == "true"){
       					window.location = "/yakcook/managerpage";
        			} else {
        				alert("로그인 실패, 아이디나 비밀번호를 확인해 주세요.")
        				$('#pwd').val('');
        				$('#pwd').focus();
        			}	
        		},
        		error : function(err){
        			alert("error");
        		}
        	});
        });  
		
		
	}
	</script>
</body>
</html>