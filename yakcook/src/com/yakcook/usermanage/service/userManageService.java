package com.yakcook.usermanage.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.yakcook.usermanage.dao.userManageDao;
import com.yakcook.usermanage.model.vo.pagingVo;
import com.yakcook.usermanage.model.vo.userVo;

import static com.yakcook.common.JDBCTemplate.*;

public class userManageService {

	public ArrayList<userVo> getUserList(String value, pagingVo pv) {
		Connection conn = getConnection();
		ArrayList<userVo> tagList = null;
		int totalBoardCount=0;
		if(value == null) {
			totalBoardCount = new userManageDao().countUserAll(conn);
		}else {
			totalBoardCount = new userManageDao().countUser(conn ,value);
		}
		
		int maxPage = totalBoardCount / pv.getBoardLimit();
		if((totalBoardCount % pv.getBoardLimit())!=0) {
			maxPage++;
		}
		pv.setMaxPage(maxPage);
		int p = pv.getCurrentPage();
		int startNo = ((p *pv.getBoardLimit()) - pv.getBoardLimit()) +1 ;
		int endNo = p * pv.getBoardLimit();
		pv.setStartNo(startNo);
		pv.setEndNo(endNo);
		
		if(value == null) {
			tagList = new userManageDao().getUserListAll(conn, pv);
		} else {
			tagList = new userManageDao().getUserList(conn, value, pv);
		}
		close(conn);
		return tagList;
	}

	public int userDel(int userNum) {
		Connection conn = getConnection();
		int result = new userManageDao().userDel(conn, userNum);
		close(conn);
		return result;
	}

}
