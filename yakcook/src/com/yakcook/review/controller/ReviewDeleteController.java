package com.yakcook.review.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.review.service.ReviewService;

@WebServlet("/reviewDelete")
public class ReviewDeleteController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String titleNo = req.getParameter("reviewNo");
		String userId = req.getParameter("userId");
		
		//deleteReivew까지 rievewNo, userId를 넘겨준다.
		int delete = new ReviewService().deleteReview(titleNo, userId);
		
		//글자 깨짐 현상으로 인하여 아래를 실행한 후 out.print를 진행한다.
		//아래 코드가 없을시에는 글자가 깨지는 현상이 발생한다.
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		
		PrintWriter out = resp.getWriter();
		//만약 delete가 0보다 클 경우 out.print를 하여 html로 해당 문구를 내보낸다.
		if(delete>0) {
			
			out.print("글이 삭제되었습니다.");
		//out.print는 html alret 창과 똑같음
		}
		else {
		//만약 delete가 0보다 작을 경우 out.print를 하여 html로 해당 문구를 내보낸다.
			out.print("게시글 작성자만 삭제할 수 있습니다.");
		}


	}
}
