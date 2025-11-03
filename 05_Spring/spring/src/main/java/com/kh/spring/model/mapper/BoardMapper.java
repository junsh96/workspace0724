package com.kh.spring.model.mapper;

import com.kh.spring.model.vo.Attachment;
import com.kh.spring.model.vo.Board;
import com.kh.spring.model.vo.Category;
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
     * 첨부파일 등록
     * @param attachment
     * @return
     */
    int insertAttachment(Attachment attachment);

    /**
     * 카테고리 조회
     * @return
     */
    List<Category> selectCategories();
}
