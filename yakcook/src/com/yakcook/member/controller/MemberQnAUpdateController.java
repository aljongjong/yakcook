package com.yakcook.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.member.model.service.MemberService;
import com.yakcook.member.model.vo.MemberQnAVo;

@WebServlet("/qnaupdate")
public class MemberQnAUpdateController extends HttpServlet{
	// 화면 보여주기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 리뷰 번호 받아오기
		String qna_no = req.getParameter("qna_no");
		
		// 문의 사항 조회하기
		MemberQnAVo q = new MemberService().myqnaList(qna_no);
		
		//alert창 띄우기
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		// q가 있을 경우에만 처리하기!
		if( q != null) {
			 req.setAttribute("q", q);
			 req.getRequestDispatcher("/WEB-INF/views/member/memberQnAUpdateForm.jsp").forward(req, resp);
		}else {
			/*
			 * req.setAttribute("msg", "관리자가 이미 답변을 달았습니다");
			 * req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
			 */
			out.println("<script>alert('관리자가 이미 답변을 달았습니다 새로 문의해주세요'); location.href='memberquestion';</script>");				 
			out.flush();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String qnano = req.getParameter("qnano");
		String userId = req.getParameter("userId");
		String qnatitle = req.getParameter("qnatitle");
		String qnacontent = req.getParameter("qnacontent");
		
		int intqnano = Integer.valueOf(qnano).intValue();
		
		int result = new MemberService().myqnaUpdate( userId, qnatitle, qnacontent, intqnano );
		// 값 나오는 거 확인
		// System.out.println(qnano + userId + qnatitle + qnacontent);
		
		//alert창 띄우기
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		if(result > 0) {
			out.println("<script>alert('문의가 잘 접수 되었습니다.'); location.href='memberquestion';</script>");				 
			out.flush();
			}else {
				System.out.println("비번 바꾸기 실패");			
				req.setAttribute("msg", "문의 내용 변경 성공");
				req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
				 

		}
	}
}
