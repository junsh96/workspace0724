package com.kh.jsp.service;
import static com.kh.jsp.common.JdbcTemplate.*;

import java.sql.Connection;

import com.kh.jsp.model.dao.AttachmentDao;
import com.kh.jsp.model.dao.ReplyDao;
import com.kh.jsp.model.vo.Reply;

public class ReplyService {
	
	/**
	 * 댓글 등록
	 * @param r
	 * @return
	 */
	public int insertReply(Reply r) {
		Connection conn = getConnecntion();
		
		int result = new ReplyDao().insertReply(r, conn);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	

}
