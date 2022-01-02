package com.yakcook.member.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yakcook.common.JDBCTemplate;
import com.yakcook.member.model.vo.MemberQnAVo;
import com.yakcook.member.model.vo.MemberVo;

@WebServlet("/memberquestion")
public class MemberQuestionController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로그인 세션 가져오기
		HttpSession session = req.getSession();
		
		//현재 로그인 한 회원의 세션 정보 가져오기
		String loginUserId = ((MemberVo)session.getAttribute("loginUser")).getUser_id();
		System.out.println("현재 로그인 아이디 질문! : "+ loginUserId);
		
		
		Connection conn = JDBCTemplate.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM QnA WHERE USER_ID = ?";
		List<MemberQnAVo> qnaList = new ArrayList<MemberQnAVo>();
		
		// 쿼리 날리기
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,loginUserId);
			rs = pstmt.executeQuery();
			// 데이터 꺼내오기
			while(rs.next()) {
				int qna_no = rs.getInt("QNA_NO");
				String user_id = rs.getString("USER_ID");
				String qna_title = rs.getString("QNA_TITLE"); 
				String qna_content = rs.getString("QNA_CONTENT");
				
				MemberQnAVo q = new MemberQnAVo();
				q.setQna_no(qna_no);
				q.setUser_id(user_id);
				q.setQna_title(qna_title);
				q.setQna_content(qna_content);

				qnaList.add(q);
			}

		}catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("data", qnaList);
		req.getRequestDispatcher("/WEB-INF/views/member/memberQuestion.jsp").forward(req, resp);
	}
}
	

