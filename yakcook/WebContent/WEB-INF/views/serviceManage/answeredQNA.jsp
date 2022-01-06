<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/yakcook/resources/css/serviceManage/AnswerQNA.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/manager/managerHeader.jsp" %>
	<section>
		<div id="tableWrap">
            <span class="title">QNA 답변 수정</span>
            <br>
            <table>
                <tr>
                    <th class="t1"><label for="title">제목</label></th>
                    <th class="t2" id="title">${qv.qnaTitle}</th>
                    <th class="t3">
                    	분류 <br>
                    	문의자 <br>
                    	문의일
                    </th>
                    <th class="t4">
                    	${qv.qnaCategory} <br>
                    	${qv.userId} <br>
                    	${qv.writeDateString()}
                    </th>
                </tr>
                <tr>
                	<td colspan="4">${qv.qnaContent}</td>
                </tr>
                <tr>
                	<th class="left" colspan="4">답변자 : ${qv.managerId}</th>
                </tr>
                <tr>
                	<td colspan="4">
                    	<textarea rows="30" cols="85" id="contents" required>${qv.managerQuestion}</textarea>
                    </td>
                </tr>
            </table>
            <br>
            <div class="btnWrap">
           		<button type="button" class="QNABtn" id="AnswerQNA">수정</button>
            </div> 
            
    </div>    
	</section>
	<br><br><br><br><br>
	<script>
    window.onload=()=>{
    	$(document).ready(function() {
    		$('#title').val('${qv.qnaTitle}');
            var text = $("textarea#contents").val();
			text = text.replace(/(<br>|<br\/>|<br \/>)/g, '\r\n');
			$("textarea#contents").val(text)
        });
		$('.logoutbtn').on('click', function(){
			window.location = "/yakcook/managerlogout";
        }); 
		
		$('#AnswerQNA').on('click', function(){
    		if(isEmpty($("textarea#contents").val())){
    			alert("내용을 입력해 주세요");
    			return false;
    		} else {
    			var text = $("textarea#contents").val();
    			text = text.replace(/(?:\r\n|\r|\n)/g, '<br>');
        		$.ajax({
                	url : '/yakcook/answeredqna',
                	method : 'post',
                	data: {
                		QNANum : ${qv.qnaNo},
                		manageNo : ${manager.managerNo},
                		QNAContents : text
                	},
                	success : function(result){
               			const data1 = $.trim(result);
               			if(data1 == "true"){
               				alert("답변 수정 성공");
               				window.location.replace("/yakcook/answeredmanageqna");
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