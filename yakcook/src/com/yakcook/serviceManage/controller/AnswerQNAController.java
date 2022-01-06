package com.yakcook.serviceManage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.serviceManage.model.vo.QNAVo;
import com.yakcook.serviceManage.service.serviceManageService;

@WebServlet("/answerqna")
public class AnswerQNAController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int qnaNo = Integer.parseInt(req.getParameter("qnaNo"));
		QNAVo qv = new serviceManageService().selectQNA(qnaNo);
		req.setAttribute("qv", qv);
		req.getRequestDispatcher("/WEB-INF/views/serviceManage/answerQNA.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int QNANum = Integer.parseInt(req.getParameter("QNANum"));
		String contents = req.getParameter("QNAContents");
		int managerNo = Integer.parseInt(req.getParameter("manageNo"));
		
		QNAVo qv = new QNAVo();
		qv.setManagerNo(managerNo);
		qv.setQnaNo(QNANum);
		qv.setManagerQuestion(contents);

		
		int result = new serviceManageService().answerQNA(qv);
		
		if(result != 1) {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print(false);	
		} else {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print(true);
		}
	}
}
