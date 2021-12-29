package com.yakcook.tagManage.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.yakcook.tagManage.dao.tagManageDao;
import com.yakcook.tagManage.model.vo.pagingVo;
import com.yakcook.tagManage.model.vo.tagVo;

import static com.yakcook.common.JDBCTemplate.*;

public class tagManageService {

	public int tagAdd(String name) {
		Connection conn = getConnection();
		int result = new tagManageDao().tagAdd(conn, name);
		close(conn);
		return result;
	}

	public int dupCheck(String tagName) {
		Connection conn = getConnection();
		int result = new tagManageDao().dupCheck(conn, tagName);
		close(conn);
		return result;
	}

	public ArrayList<tagVo> getTagList(String value, pagingVo pv) {
		Connection conn = getConnection();
		ArrayList<tagVo> tagList = null;
		int totalBoardCount=0;
		if(value == null) {
			totalBoardCount = new tagManageDao().countTagAll(conn);
		}else {
			totalBoardCount = new tagManageDao().countTag(conn ,value);
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
			tagList = new tagManageDao().getTagListAll(conn, pv);
		} else {
			tagList = new tagManageDao().getTagList(conn, value, pv);
		}
		close(conn);
		return tagList;
	}

	public int tagModify(int tagNum, String tagName) {
		Connection conn = getConnection();
		int result = new tagManageDao().tagModify(conn, tagNum, tagName);
		close(conn);
		return result;
	}

	public int tagDel(int tagNum) {
		Connection conn = getConnection();
		int result = new tagManageDao().tagDel(conn, tagNum);
		close(conn);
		return result;
	}

}
