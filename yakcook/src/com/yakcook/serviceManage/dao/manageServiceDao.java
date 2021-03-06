package com.yakcook.serviceManage.dao;

import static com.yakcook.common.JDBCTemplate.close;
import static com.yakcook.common.JDBCTemplate.commit;
import static com.yakcook.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.yakcook.serviceManage.model.vo.FAQVo;
import com.yakcook.serviceManage.model.vo.QNAVo;
import com.yakcook.serviceManage.model.vo.noticeVo;
import com.yakcook.serviceManage.model.vo.pagingVo;

public class manageServiceDao {

	public int countFAQAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(FAQ_NUMBER) FROM FAQ WHERE DELETE_YN='N'";
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return count;
	}

	public int countFAQ(Connection conn, String value) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(FAQ_NUMBER) FROM FAQ F "
				+ "JOIN CUSTOMER_CATEGORY C ON (F.CATEGORY_NUMBER = C.CATEGORY_NUMBER) "
				+ "WHERE C.CATEGORY_NAME = ? AND DELETE_YN='N'";
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, value);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return count;
	}

	public ArrayList<FAQVo> getFAQAll(Connection conn, pagingVo pv) {
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM , F.*, C.CATEGORY_NAME FROM FAQ F JOIN CUSTOMER_CATEGORY C ON (F.CATEGORY_NUMBER = C.CATEGORY_NUMBER) WHERE DELETE_YN='N' )WHERE RNUM BETWEEN ? AND ?";
		ResultSet rs = null;
		ArrayList<FAQVo> faqList = new ArrayList<FAQVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pv.getStartNo());
			pstmt.setInt(2, pv.getEndNo());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				faqList.add(new FAQVo(rs.getInt("FAQ_NUMBER"), rs.getInt("MANAGER_NUMBER"), rs.getString("CATEGORY_NAME"),
						rs.getString("FAQ_TITLE"), rs.getString("FAQ_CONTENT"), rs.getString("DELETE_YN")));
			}
			
			commit(conn);
		} catch (SQLException e) {
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return faqList;
	}

	public ArrayList<FAQVo> getFAQ(Connection conn, String value, pagingVo pv) {
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM , F.*, C.CATEGORY_NAME FROM FAQ F JOIN CUSTOMER_CATEGORY C ON (F.CATEGORY_NUMBER = C.CATEGORY_NUMBER) WHERE CATEGORY_NAME = ? AND DELETE_YN='N')WHERE RNUM BETWEEN ? AND ?";
		ResultSet rs = null;
		ArrayList<FAQVo> faqList = new ArrayList<FAQVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, value);
			pstmt.setInt(2, pv.getStartNo());
			pstmt.setInt(3, pv.getEndNo());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				faqList.add(new FAQVo(rs.getInt("FAQ_NUMBER"), rs.getInt("MANAGER_NUMBER"), rs.getString("CATEGORY_NAME"),
						rs.getString("FAQ_TITLE"), rs.getString("FAQ_CONTENT"), rs.getString("DELETE_YN")));
			}
			
			commit(conn);
		} catch (SQLException e) {
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return faqList;
	}

	public int countNotice(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(NOTICE_NUMBER) FROM NOTICE WHERE DELETE_YN='N'";
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return count;
	}

	public ArrayList<noticeVo> getNotice(Connection conn, pagingVo pv) {
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM , N.* FROM NOTICE N WHERE DELETE_YN='N')WHERE RNUM BETWEEN ? AND ?"
				+ "ORDER BY WRITE_DATE DESC";
		ResultSet rs = null;
		ArrayList<noticeVo> noticeList = new ArrayList<noticeVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pv.getStartNo());
			pstmt.setInt(2, pv.getEndNo());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				noticeList.add(new noticeVo(rs.getInt("NOTICE_NUMBER"), rs.getInt("MANAGER_NUMBER"),rs.getString("NOTICE_TITLE")
						, rs.getString("NOTICE_CONTENT"), rs.getTimestamp("WRITE_DATE")));
			}
			
			commit(conn);
		} catch (SQLException e) {
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return noticeList;
	}

	public noticeVo getNoticeDetail(Connection conn, int noticeNumber) {
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM NOTICE WHERE NOTICE_NUMBER = ? AND DELETE_YN='N'";
		ResultSet rs = null;
		noticeVo NV = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNumber);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NV = new noticeVo(rs.getInt("NOTICE_NUMBER"), rs.getInt("MANAGER_NUMBER"),rs.getString("NOTICE_TITLE")
						, rs.getString("NOTICE_CONTENT"), rs.getTimestamp("WRITE_DATE"));
			}
			
			commit(conn);
		} catch (SQLException e) {
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return NV;
	}

	public int addFAQ(Connection conn, FAQVo fv, int categoryNo) {
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FAQ(FAQ_NUMBER, MANAGER_NUMBER, CATEGORY_NUMBER, FAQ_TITLE, FAQ_CONTENT) "
				+ "VALUES(SEQ_FAQ_NUMBER.NEXTVAL, ?, ?, ?, ?)";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fv.getManagerNumber());
			pstmt.setInt(2, categoryNo);
			pstmt.setString(3, fv.getFaqTitle());
			pstmt.setString(4, fv.getFaqContent());
			result = pstmt.executeUpdate();
			commit(conn);
		} catch (SQLException e) {
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return result;
	}

	public int getCategoryNumber(Connection conn, FAQVo fv) {
		int categoryNo = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CATEGORY_NUMBER FROM CUSTOMER_CATEGORY WHERE CATEGORY_NAME = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fv.getCategory());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				categoryNo = rs.getInt("CATEGORY_NUMBER");
			}
			commit(conn);
		} catch (SQLException e) {
			close(rs);
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		
		return categoryNo;
	}

	public int FAQdel(Connection conn, int faqNo) {
		PreparedStatement pstmt = null;
		String sql = "UPDATE FAQ SET DELETE_YN = 'Y' WHERE FAQ_NUMBER = ?";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, faqNo);
			result = pstmt.executeUpdate();
			commit(conn);
		} catch (SQLException e) {
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return result;
	}

	public FAQVo getFAQSelected(Connection conn, int fAQNum) {
		PreparedStatement pstmt = null;
		String sql = "SELECT F.*, C.CATEGORY_NAME FROM FAQ F JOIN CUSTOMER_CATEGORY C ON (F.CATEGORY_NUMBER = C.CATEGORY_NUMBER) WHERE FAQ_NUMBER =?";
		ResultSet rs = null;
		FAQVo fv = new FAQVo();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fAQNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				fv = new FAQVo(rs.getInt("FAQ_NUMBER"), rs.getInt("MANAGER_NUMBER"), rs.getString("CATEGORY_NAME"),
						rs.getString("FAQ_TITLE"), rs.getString("FAQ_CONTENT"), rs.getString("DELETE_YN"));
			}
			
			commit(conn);
		} catch (SQLException e) {
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return fv;
	}

	public int modiFAQ(Connection conn, FAQVo fv, int categoryNo) {
		PreparedStatement pstmt = null;
		String sql = "UPDATE FAQ SET MANAGER_NUMBER = ?, CATEGORY_NUMBER = ?, FAQ_TITLE = ?, FAQ_CONTENT = ? "
				+ "WHERE FAQ_NUMBER = ?";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fv.getManagerNumber());
			pstmt.setInt(2, categoryNo);
			pstmt.setString(3, fv.getFaqTitle());
			pstmt.setString(4, fv.getFaqContent());
			pstmt.setInt(5, fv.getFaqNumber());
			result = pstmt.executeUpdate();
			commit(conn);
		} catch (SQLException e) {
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return result;
	}

	public int addNotice(Connection conn, noticeVo nv) {
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO NOTICE(NOTICE_NUMBER, MANAGER_NUMBER, NOTICE_TITLE, NOTICE_CONTENT) "
				+ "VALUES(SEQ_NOTICE_NUMBER.NEXTVAL, ?, ?, ?)";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nv.getManagerNo());
			pstmt.setString(2, nv.getNoticeTitle());
			pstmt.setString(3, nv.getNoticeContent());
			result = pstmt.executeUpdate();
			commit(conn);
		} catch (SQLException e) {
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return result;
	}

	public int noticeDel(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		String sql = "UPDATE NOTICE SET DELETE_YN = 'Y' WHERE NOTICE_NUMBER = ?";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			result = pstmt.executeUpdate();
			commit(conn);
		} catch (SQLException e) {
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return result;
	}

	public int modiNotice(Connection conn, noticeVo NV) {
		PreparedStatement pstmt = null;
		String sql = "UPDATE NOTICE SET MANAGER_NUMBER = ?, NOTICE_TITLE = ?, NOTICE_CONTENT = ?"
				+ "WHERE NOTICE_NUMBER = ?";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, NV.getManagerNo());
			pstmt.setString(2, NV.getNoticeTitle());
			pstmt.setString(3, NV.getNoticeContent());
			pstmt.setInt(4, NV.getNoticeNo());
			result = pstmt.executeUpdate();
			commit(conn);
		} catch (SQLException e) {
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return result;
	}
	public int countQNAAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(QNA_NO) FROM QNA WHERE QUIT_YN='N' AND MANAGER_ANSWER='N'";
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return count;
	}

	public int countQNA(Connection conn, String value) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(QNA_NO) FROM QNA "
				+ "WHERE QUIT_YN='N' AND MANAGER_ANSWER='N' AND QNA_CATEGORY=?";
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, value);;
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return count;
	}

	public ArrayList<QNAVo> getQNAAll(Connection conn, pagingVo pv) {
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM , Q.* "
				+ "FROM QNA Q WHERE Q.QUIT_YN='N' AND Q.MANAGER_ANSWER='N' ORDER BY QNA_DATE)"
				+ "WHERE RNUM BETWEEN ? AND ?";
		ResultSet rs = null;
		ArrayList<QNAVo> QNAList = new ArrayList<QNAVo>();
		QNAVo qv = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pv.getStartNo());
			pstmt.setInt(2, pv.getEndNo());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				qv = new QNAVo();
				qv.setQnaNo(rs.getInt("QNA_NO"));
				qv.setQnaTitle(rs.getString("QNA_TITLE"));
				qv.setQnaContent(rs.getString("QNA_CONTENT"));
				qv.setQnaDate(rs.getTimestamp("QNA_DATE"));
				qv.setUserId(rs.getString("USER_ID"));
				qv.setQnaCategory(rs.getString("QNA_CATEGORY"));
				QNAList.add(qv);
			}
			
			commit(conn);
		} catch (SQLException e) {
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return QNAList;
	}

	public ArrayList<QNAVo> getQNA(Connection conn, String value, pagingVo pv) {
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM , Q.* "
				+ "FROM QNA Q WHERE Q.QUIT_YN='N' AND Q.MANAGER_ANSWER='N' AND QNA_CATEGORY=? ORDER BY QNA_DATE)"
				+ "WHERE RNUM BETWEEN ? AND ?";
		ResultSet rs = null;
		ArrayList<QNAVo> QNAList = new ArrayList<QNAVo>();
		QNAVo qv = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, value);
			pstmt.setInt(2, pv.getStartNo());
			pstmt.setInt(3, pv.getEndNo());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				qv = new QNAVo();
				qv.setQnaNo(rs.getInt("QNA_NO"));
				qv.setQnaTitle(rs.getString("QNA_TITLE"));
				qv.setQnaContent(rs.getString("QNA_CONTENT"));
				qv.setQnaDate(rs.getTimestamp("QNA_DATE"));
				qv.setUserId(rs.getString("USER_ID"));
				qv.setQnaCategory(rs.getString("QNA_CATEGORY"));
				QNAList.add(qv);
			}
			
			commit(conn);
		} catch (SQLException e) {
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return QNAList;
	}

	public QNAVo selectQNA(Connection conn, int qnaNo) {
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM QNA WHERE QNA_NO = ?";
		ResultSet rs = null;
		QNAVo qv = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnaNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				qv = new QNAVo();
				qv.setQnaNo(rs.getInt("QNA_NO"));
				qv.setQnaTitle(rs.getString("QNA_TITLE"));
				qv.setQnaContent(rs.getString("QNA_CONTENT"));
				qv.setQnaDate(rs.getTimestamp("QNA_DATE"));
				qv.setUserId(rs.getString("USER_ID"));
				qv.setQnaCategory(rs.getString("QNA_CATEGORY"));
			}
			
			commit(conn);
		} catch (SQLException e) {
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return qv;
	}

	public int answerQNA(Connection conn, QNAVo qv) {
		PreparedStatement pstmt = null;
		String sql = "UPDATE QNA "
				+ "SET MANAGER_ANSWER ='Y', MANAGER_NUMBER=?, MANAGER_QUESTION= ? WHERE QNA_NO =?";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qv.getManagerNo());
			pstmt.setString(2, qv.getManagerQuestion());
			pstmt.setInt(3, qv.getQnaNo());
			result = pstmt.executeUpdate();

			commit(conn);
		} catch (SQLException e) {
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return result;
	}

	public int countAnswerdQNAAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(QNA_NO) FROM QNA WHERE QUIT_YN='N' AND MANAGER_ANSWER='Y'";
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return count;
	}

	public int countAnswerdQNA(Connection conn, String value) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(QNA_NO) FROM QNA "
				+ "WHERE QUIT_YN='N' AND MANAGER_ANSWER='Y' AND QNA_CATEGORY=?";
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, value);;
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return count;
	}

	public ArrayList<QNAVo> getAnswerdQNAAll(Connection conn, pagingVo pv) {
		PreparedStatement pstmt = null;
		String sql = "SELECT * "
				+ "FROM (SELECT ROWNUM AS RNUM , Q.*,M.MANAGER_ID "
				+ "FROM QNA Q JOIN MANAGER M ON(Q.MANAGER_NUMBER = M.MANAGER_NUMBER) "
				+ "WHERE Q.QUIT_YN='N' AND Q.MANAGER_ANSWER='Y' ORDER BY QNA_DATE)"
				+ "WHERE RNUM BETWEEN ? AND ?";
		ResultSet rs = null;
		ArrayList<QNAVo> QNAList = new ArrayList<QNAVo>();
		QNAVo qv = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pv.getStartNo());
			pstmt.setInt(2, pv.getEndNo());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				qv = new QNAVo();
				qv.setQnaNo(rs.getInt("QNA_NO"));
				qv.setQnaTitle(rs.getString("QNA_TITLE"));
				qv.setQnaContent(rs.getString("QNA_CONTENT"));
				qv.setQnaDate(rs.getTimestamp("QNA_DATE"));
				qv.setUserId(rs.getString("USER_ID"));
				qv.setQnaCategory(rs.getString("QNA_CATEGORY"));
				qv.setManagerNo(rs.getInt("MANAGER_NUMBER"));
				qv.setManagerQuestion(rs.getString("MANAGER_QUESTION"));
				qv.setManagerId(rs.getString("MANAGER_ID"));
				QNAList.add(qv);
			}
			
			commit(conn);
		} catch (SQLException e) {
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return QNAList;
	}

	public ArrayList<QNAVo> getAnswerdQNA(Connection conn, String value, pagingVo pv) {
		PreparedStatement pstmt = null;
		String sql = "SELECT * "
				+ "FROM (SELECT ROWNUM AS RNUM , Q.*,M.MANAGER_ID "
				+ "FROM QNA Q JOIN MANAGER M ON(Q.MANAGER_NUMBER = M.MANAGER_NUMBER) "
				+ "WHERE Q.QUIT_YN='N' AND Q.MANAGER_ANSWER='Y' AND QNA_CATEGORY = ? ORDER BY QNA_DATE)"
				+ "WHERE RNUM BETWEEN ? AND ?";
		ResultSet rs = null;
		ArrayList<QNAVo> QNAList = new ArrayList<QNAVo>();
		QNAVo qv = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, value);
			pstmt.setInt(2, pv.getStartNo());
			pstmt.setInt(3, pv.getEndNo());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				qv = new QNAVo();
				qv.setQnaNo(rs.getInt("QNA_NO"));
				qv.setQnaTitle(rs.getString("QNA_TITLE"));
				qv.setQnaContent(rs.getString("QNA_CONTENT"));
				qv.setQnaDate(rs.getTimestamp("QNA_DATE"));
				qv.setUserId(rs.getString("USER_ID"));
				qv.setQnaCategory(rs.getString("QNA_CATEGORY"));
				qv.setManagerNo(rs.getInt("MANAGER_NUMBER"));
				qv.setManagerQuestion(rs.getString("MANAGER_QUESTION"));
				qv.setManagerId(rs.getString("MANAGER_ID"));
				QNAList.add(qv);
			}
			
			commit(conn);
		} catch (SQLException e) {
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return QNAList;
	}

	public QNAVo selectAnswerQNA(Connection conn, int qnaNo) {
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM QNA Q JOIN MANAGER M ON(Q.MANAGER_NUMBER = M.MANAGER_NUMBER) WHERE QNA_NO = ?";
		ResultSet rs = null;
		QNAVo qv = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnaNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				qv = new QNAVo();
				qv.setQnaNo(rs.getInt("QNA_NO"));
				qv.setQnaTitle(rs.getString("QNA_TITLE"));
				qv.setQnaContent(rs.getString("QNA_CONTENT"));
				qv.setQnaDate(rs.getTimestamp("QNA_DATE"));
				qv.setUserId(rs.getString("USER_ID"));
				qv.setQnaCategory(rs.getString("QNA_CATEGORY"));
				qv.setManagerNo(rs.getInt("MANAGER_NUMBER"));
				qv.setManagerQuestion(rs.getString("MANAGER_QUESTION"));
				qv.setManagerId(rs.getString("MANAGER_ID"));
			}
			
			commit(conn);
		} catch (SQLException e) {
			close(pstmt);
			rollback(conn);
			e.printStackTrace();
		}
		return qv;
	}

	

}
