package com.kh.spring.model.mapper;

import com.kh.spring.model.vo.Attachment;
import com.kh.spring.model.vo.Board;
import com.kh.spring.model.vo.Category;
import com.kh.spring.model.vo.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;


import java.util.List;

@Mapper
public interface BoardMapper {

    /**
     * 게시글 조회
     * @param cpage
     * @return
     */
    List<Board> selectBoardList(RowBounds rowBounds);

    /**
     * 게시글 갯수
     * @return
     */
    int selectBoardListCount();

    /**
     * 게시글 등록
     * @param board
     * @return
     */
    int insertBoard(Board board);

    /**
     * 게시글 상세
     * @param boardNo
     * @return
     */
    Board selectBoardByNo(int boardNo);

    int updateBoard(Board board);

    /**
     * 조회수 증가
     * @param boardNo
     * @return
     */
    int increaseCount(int boardNo);
    
    /**
     * 첨부파일 등록
     * @param attachment
     * @return
     */
    int insertAttachment(Attachment attachment);

    /**
     * 게시글 첨부파일 조회
     * @param boardNo
     * @return
     */
    Attachment selectAttachmentByBoardNo(int boardNo);

    int updateAttachment(Attachment attachment);

    /**
     * 카테고리 조회
     * @return
     */
    List<Category> selectCategories();


    int insertReply(Reply reply);

    /**
     * 댓글 리스트
     * @param boardNo
     * @return
     */
    List<Reply> getReplyListByBoardNo(int boardNo);
}
