package com.kh.jsp.service;
import static com.kh.jsp.common.JdbcTemplate.*;

import java.sql.Connection;

import com.kh.jsp.model.dao.AttachmentDao;

import com.kh.jsp.model.vo.Attachment;

public class AttachmentService {

	/**
	 * 파일 업로드
	 * @param a
	 * @return
	 */
	public int uploadFile(Attachment a) {
		Connection conn = getConnecntion();
		
		int result = new AttachmentDao().uploadFile(a, conn);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	/**
	 * 게시글 조회시 파일 조회
	 * @param boardNo
	 * @return
	 */
	public Attachment selectBoardFile(int boardNo) {
		Connection conn = getConnecntion();
		
		Attachment a = new AttachmentDao().selectBoardFile(boardNo,conn);
		
		close(conn);
		
		return a;
		
	}
	
	/**
	 * 파일 삭제
	 * @param a
	 * @return
	 */
	public int deleteFile(Attachment a) {
		Connection conn = getConnecntion();
		
		int result = new AttachmentDao().deleteFile(a,conn);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
		
	}
}
