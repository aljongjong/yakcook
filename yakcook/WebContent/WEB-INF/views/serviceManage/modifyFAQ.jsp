<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ 수정</title>
<link rel="stylesheet" href="/yakcook/resources/css/serviceManage/addFAQ.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/manager/managerHeader.jsp" %>
	<section>
		<div id="tableWrap">
            <span class="title">FAQ 수정</span>
            <br>
            <table>
                <tr>
                    <th class="t1"><label for="title">제목</label></th>
                    <th class="t2"><input type="text" class="insert" id="title" required></th>
                    <th class="t3">분류</th>
                    <th>
                    	<select id="category">
                    		<option value="제품">제품</option>
                    		<option value="회원관리">회원관리</option>
                    		<option value="주문/결제">주문/결제</option>
                    		<option value="교환/반품">교환/반품</option>
                    		<option value="기타">기타</option>
                    	</select>
                    </th>
                </tr>
                <tr>
                	<td colspan="4">
                    	<textarea rows="30" cols="85" id="contents" required>${fv.faqContent}</textarea>
                    </td>
                </tr>
            </table>
            <div class="btnWrap">
           		<button type="button" class="noticeBtn" id="FAQmodi">수정</button>
            </div>
      
            
            
    </div>    
	</section>
	<script>
    window.onload=()=>{
    	$(document).ready(function() {
            $('#title').val('${fv.faqTitle}');
            $("select").val('${fv.category}').attr("selected","selected");
            var text = $("textarea#contents").val();
			text = text.replace(/(<br>|<br\/>|<br \/>)/g, '\r\n');
			$("textarea#contents").val(text)
        });
    	
		$('.logoutbtn').on('click', function(){
			window.location = "/yakcook/managerlogout";
        }); 
		
		$('#FAQmodi').on('click', function(){
    		if(isEmpty($("#contents").val()) || isEmpty($("#title").val())){
    			alert("제목과 내용을 입력해 주세요.");
    			return false;
    		} else {
    			var text = $("textarea#contents").val();
    			text = text.replace(/(?:\r\n|\r|\n)/g, '<br>');
        		$.ajax({
                	url : '/yakcook/modiFAQ',
                	method : 'post',
                	data: {
                		faqNumber : ${fv.faqNumber},
                		faqTitle : $("#title").val(),
                		category : $("#category").val(),
                		manageNo : ${manager.managerNo},
                		faqContents : text
                	},
                	success : function(result){

               			const data1 = $.trim(result);
               			if(data1 == "true"){
               				alert("FAQ 수정 성공");
               				window.location.replace("/yakcook/manageFAQ");
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
		function isEmpty(str){   
	        if(typeof str == "undefined" || str == null || str == "")
	            return true;
	        else
	            return false ;
	    }
	}
    </script>
</body>
</html>