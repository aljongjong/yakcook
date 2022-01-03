package com.yakcook.manager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakcook.manager.model.vo.managerVo;
import com.yakcook.manager.service.managerService;

@WebServlet("/managerlogin")
public class managerLoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/manager/managerLogin.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id= req.getParameter("id");
		String pwd = req.getParameter("pwd");
		managerVo mv = new managerVo();
		mv.setManagerId(id);
		mv.setManagerPwd(pwd);
		managerVo managerVo = new managerService().managerCheck(mv);
		if(managerVo != null) {
			if(managerVo.getCheck() == 1) {
				req.getSession().setAttribute("manager", managerVo);
				resp.setContentType("text/html; charset=UTF-8");
				resp.getWriter().print(true);	
			} else {
				resp.setContentType("text/html; charset=UTF-8");
				resp.getWriter().print(false);
			}
		} else {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print(false);
		}
		
	}
}
