package com.yakcook.member.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.yakcook.member.model.service.MemberService;
import com.yakcook.member.model.vo.MemberVo;
@MultipartConfig(
		maxFileSize = 1024 * 1024 * 5,
		maxRequestSize = 1024 * 1024 * 5 * 5
		)
@WebServlet("/join")
public class joinController extends HttpServlet{
	
	//회원가입 화면 보여줌
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/views/member/joinForm.jsp").forward(req, resp);
	}
	//회원가입 진행
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		
		//파일 읽을 준비
//		Part part = req.getPart("profile");
//		if(part != null) {
//			String originName = part.getSubmittedFileName();
//			InputStream fis = part.getInputStream();
//			
//			//파일 저장 준비
//			String changeName = ""+ UUID.randomUUID();
//			String ext = originName.substring(originName.lastIndexOf("."),originName.length());
//			String realPath = req.getServletContext().getRealPath("/upload");
//			String filePath = realPath + File.separator + changeName +ext;
//			FileOutputStream fos = new FileOutputStream(filePath);
//			
//			byte[] buf = new byte[1024];
//			int size = 0;
//			while(fis.read(buf) != -1) {
//				fos.write(buf, 0, size);
//			}
//			fis.close();
//			fos.close();
//		}
		
		
		MemberVo m = new MemberVo();
		m.setId(id);
		m.setPwd(pwd);
		m.setName(name);
		m.setEmail(email);
		m.setPhone(phone);
		
		int result = new MemberService().join(m);
		
		if(result>0) {
			// 성공
			req.setAttribute("msg", "회원가입 성공");
			req.getRequestDispatcher("WEB-INF/views/common/successPage.jsp").forward(req, resp);
		}else {
			// 실패
			req.setAttribute("msg", "회원가입 실패");
			req.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
	}
}
