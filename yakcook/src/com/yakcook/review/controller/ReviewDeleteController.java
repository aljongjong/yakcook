package com.yakcook.review.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.review.service.ReviewService;
import com.yakcook.review.vo.deleteReviewVo;

@WebServlet("/delete")
public class ReviewDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String titleNo = req.getParameter("reviewNo");
		

		

		int result = new ReviewService().deleteReview(titleNo);
		if (result > 0) {
			req.setAttribute("msg", "게시물삭제에 성공하였습니다");
			req.getRequestDispatcher("WEB-INF/views/common/Review/deleteSuccessPage.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "게시물삭제가 실패되었습니다.");
			req.getRequestDispatcher("WEB-INF/views/common/Review/deleteErrorPage.jsp").forward(req, resp);
		}

	}
}
