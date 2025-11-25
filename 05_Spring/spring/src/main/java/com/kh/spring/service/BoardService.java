package com.kh.spring.service;

import com.kh.spring.model.vo.Board;
import com.kh.spring.model.vo.Category;
import com.kh.spring.model.vo.Reply;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface BoardService {

    /**
     * 게시물 조회
     * @param currentPage
     * @return
     */
    public Map<String,Object> getBoardList(int currentPage);
    
    /**
     * 게시글 등록
     * @param board
     * @param file
     * @return
     */
    public int insertBoard(Board board, MultipartFile file);

    /**
     * 게시글 상세
     * @param boardNo
     * @return
     */
    public Map<String,Object> getBoardByIdWithCount(int boardNo);

    public Map<String,Object> getBoardById(int boardNo);

    public int updateBoard(Board board,int originFileNo ,MultipartFile file);

    /**
     * 카테고리 조회
     * @return
     */
    public List<Category>  selectCategories();

    /**
     * 댓글 등록
     * @param reply
     * @return
     */
    public int insertReply(Reply  reply);

    /**
     * 댓글 리스트
     * @param boardNo
     * @return
     */
    public List<Reply> getReplyListByBoardNo(int boardNo);
}
