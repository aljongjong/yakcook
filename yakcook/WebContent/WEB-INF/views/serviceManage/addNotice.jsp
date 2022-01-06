<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/yakcook/resources/css/serviceManage/addFAQ.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/manager/managerHeader.jsp" %>
	<section>
		<div id="tableWrap">
            <span class="title">공지사항 등록</span>
            <br>
            <table>
                <tr>
                    <th class="t1"><label for="title">제목</label></th>
                    <th class="t2"><input type="text" class="insert" id="title" required> </th>
                </tr>
                <tr>
                	<td colspan="2">
                    	<textarea rows="30" cols="85" id="contents" required></textarea>
                    </td>
                </tr>
            </table>
            <br>
            <div class="btnWrap">
           		<button type="button" class="noticeBtn" id="noticeadd">등록</button>
            </div>
		<br><br><br><br><br>
    </div>    
	</section>
	<script>
    window.onload=()=>{
		$('.logoutbtn').on('click', function(){
			window.location = "/yakcook/managerlogout";
        }); 
		
		$('#noticeadd').on('click', function(){
    		if(isEmpty($("textarea#contents").val()) || isEmpty($("#title").val())){
    			alert("제목과 내용을 입력해 주세요.");
    			return false;
    		} else {
    			var text = $("textarea#contents").val();
    			text = text.replace(/(?:\r\n|\r|\n)/g, '<br>');
        		$.ajax({
                	url : '/yakcook/addnotice',
                	method : 'post',
                	data: {
                		faqTitle : $("#title").val(),
                		manageNo : ${manager.managerNo},
                		faqContents : text
                	},
                	success : function(result){

               			const data1 = $.trim(result);
               			if(data1 == "true"){
               				alert("공지 등록 성공");
               				window.location.replace("/yakcook/managenotice");
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