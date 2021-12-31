<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="/yakcook/resources/css/tagManage/tagAdd.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>태그 추가</title>
</head>
<body onload="checking();">
	<section>
			<span>태그 추가 </span> 
			<br> <br> 
			<span> 
				<input type="text" name="tag_add" id="tag_add" required ="required">
				<button type="button" class="btn1" id="dupCheckbtn">중복 확인</button>
			</span>

			<div id="dupCheckSet">&nbsp</div>
			<br>
			<div id="dupCheckVal" style="display: none">false</div>
			<br> <input class="btn1" type="submit" value="추가" id="register">

	</section>
	<script>
    window.onload=()=>{
    	$(document).on('click','#dupCheckbtn', function(){
        	$.ajax({
        		url : '/yakcook/tagDupCheck',
        		method : 'get',
        		data: {
        			name : $("#tag_add").val()
        		},
        		async : true,
        		success : function(result){
       				const data1 = $.trim(result);
       				if(data1 == "true"){
       					$("#dupCheckSet").css("color","green");
        				$("#dupCheckSet").text("사용가능한 태그 이름입니다.");
        				$("#dupCheckVal").text("true");
        			} else {
        				$("#dupCheckSet").css("color","red");
        				$("#dupCheckSet").text("중복된 태그 이름입니다.");
        				$("#dupCheckVal").text("false");
        			}	
        		},
        		error : function(err){
        			alert("error");
        		}
        	});
        });  
    	
    	$(document).on('click','#register', function(){
    		if($("#dupCheckVal").text() != "true"){
    			alert("중복 체크를 해주세요");
    			return false;
    		} else {
    			$.ajax({
            		url : '/yakcook/tagadd',
            		method : 'post',
            		async : true,
            		data: {
            			tag_add : $("#tag_add").val(),
            		},
            		success : function(result){
           				const data1 = $.trim(result);
           				if(data1 == "true"){
           					alert("태그 등록 성공");
           					opener.location.reload();
           					window.close();
            			} else {
            				alert("오류입니다. 다시 실행해 주십시오.")
            			}	
            		},
            		error : function(err){
            			alert("error");
            		}
            	});
    		}
        	
        });  
    	
    
    };
   
	</script>
</body>
</html>