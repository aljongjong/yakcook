<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String id = (String)session.getAttribute("userId"); %>
<link rel="stylesheet" href="/yakcook/resources/css/review/writerReview.css">
<body>

    <div id="wrap">
        <header>

        </header>

        <section>
            <div class="review_Wrap">
                <form action="memberquestionwriter" method="post">
                <input type = "hidden" name = "id" id = "userid" value = "${id}"><br>
                    <table class="review_table">
                        <tr>
                            <th colspan="2">제목</th>
                            <td><input type="text" name="question_title" id=""></td>
                        </tr>

                        <tr>
                            <th colspan="2">내용</th>
                            <td colspan="2"><textarea name="question_contents" class="review_contents" maxlength="1000"></textarea>
                            </td>
                        </tr>
                    </table>
                    <div class="writer_button">
                            <input type="submit" value="등록">
                            <!-- onclick="location.href='reviewList'" -->
                            <input type="button" value="취소">
                            
                    </div>
                </form>
            </div>
        </section>

        <footer>

        </footer>
    </div>
</body>

</html>