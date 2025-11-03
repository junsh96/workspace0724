package com.kh.spring.service;

import com.kh.spring.model.vo.Board;
import com.kh.spring.model.vo.Category;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
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
     * 카테고리 조회
     * @return
     */
    public List<Category>  selectCategories();
}
