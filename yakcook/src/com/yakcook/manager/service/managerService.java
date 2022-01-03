package com.yakcook.manager.service;

import static com.yakcook.common.JDBCTemplate.*;

import java.sql.Connection;

import com.yakcook.manager.dao.managerDao;
import com.yakcook.manager.model.vo.managerVo;

public class managerService {

	public managerVo managerCheck(managerVo mv) {
		Connection conn = getConnection();
		managerVo managerVo = null;
		int result = new managerDao().managerCheck(conn,mv);
		if(result == 1) {
			managerVo = new managerDao().getManager(conn,mv);
			if(mv.getManagerPwd().equals(managerVo.getManagerPwd())) {
				managerVo.setCheck(1);
			}
		}
		close(conn);
		return managerVo;
	}

}
