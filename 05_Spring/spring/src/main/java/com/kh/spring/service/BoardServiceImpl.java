package com.kh.spring.service;

import com.kh.spring.model.mapper.BoardMapper;
import com.kh.spring.model.vo.*;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Autowired
    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    /**
     * 게시물 조회
     * @param currentPage
     * @return
     */
    @Override
    public Map<String,Object> getBoardList(int currentPage) {
        int listCount = boardMapper.selectBoardListCount();

        PageInfo pi = new PageInfo(currentPage, listCount, 5, 5);
        int offset = (currentPage - 1) * pi.getBoardLimit();
        RowBounds rowBounds = new RowBounds(offset,pi.getBoardLimit());

        ArrayList<Board> list = (ArrayList)boardMapper.selectBoardList(rowBounds);

        Map<String,Object> map = new HashMap<>();
        map.put("list",list);
        map.put("pi",pi);

        return map;
    }

    //spring 에서 기본적으로 mvc패턴을 사용하고
    //servuce 계층에서는 하나의 기능을 정의하며, dao에서는 개별 sql단으로 처리 되므로
    //업무단위인 service계층에 트랜잭션을 걸어준다.
    @Override
    @Transactional
    public int insertBoard(Board board, MultipartFile file) {
        int result = boardMapper.insertBoard(board);

        if(result > 0 && file != null && !file.isEmpty()) {
            Attachment at = new Attachment();
            at.setRefBno(board.getBoardNo());
            String filePath = "C:/workspace/05_Spring/spring/src/main/webapp/resources/uploadFiles/";
            at.setOriginName(file.getOriginalFilename());
            at.setChangeName(saveFile(file, filePath));
            at.setFilePath(filePath);
            at.setFileLevel(1);

            result = boardMapper.insertAttachment(at);
        }

        return result;
    }

    @Override
    public Map<String,Object> getBoardByIdWithCount(int boardNo) {
        int result = boardMapper.increaseCount(boardNo);
        Map<String,Object> map = new HashMap<>();
        if (result > 0) {
            Board board = boardMapper.selectBoardByNo(boardNo);
            Attachment at = boardMapper.selectAttachmentByBoardNo(boardNo);
            map.put("board",board);
            map.put("at",at);
        }

        return map;
    }

    @Override
    public Map<String,Object> getBoardById(int boardNo) {
        Board board = boardMapper.selectBoardByNo(boardNo);
        Attachment at = boardMapper.selectAttachmentByBoardNo(boardNo);
        Map<String,Object> map = new HashMap<>();
        map.put("board",board);
        map.put("at",at);
        return map;
    }

    @Override
    public int updateBoard(Board board, int originFileNo, MultipartFile file) {
        int result = boardMapper.updateBoard(board);
        Attachment oldFile = boardMapper.selectAttachmentByBoardNo(board.getBoardNo());


        if(result > 0 && file != null && !file.isEmpty()) {
            if (oldFile != null) {
                File oldFileDir = new File(oldFile.getFilePath()+oldFile.getChangeName());
                oldFileDir.delete();
            }
            Attachment at = new Attachment();
            String filePath = "C:/workspace/05_Spring/spring/src/main/webapp/resources/uploadFiles/";
            at.setRefBno(board.getBoardNo());
            at.setOriginName(file.getOriginalFilename());
            at.setFilePath(filePath);
            at.setFileLevel(1);
            at.setChangeName(saveFile(file, filePath));

            result = boardMapper.updateAttachment(at);
        }


        return result;
    }

    private String saveFile(MultipartFile file, String path) {
        String originalName = file.getOriginalFilename();
        String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        int randomNumber = (int)(Math.random() * 90000) + 10000;

        String ext = originalName.substring(originalName.lastIndexOf("."));

        String changeName = currentTime + randomNumber + ext;

        try {
            file.transferTo(new File(path + changeName));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return changeName;

    }

    /**
     * 카테고리 조회
     * @return
     */
    @Override
    public List<Category> selectCategories() {

        return boardMapper.selectCategories();
    }

    @Override
    public int insertReply(Reply reply) {
        int result = boardMapper.insertReply(reply);
        return result;
    }

    @Override
    public List<Reply> getReplyListByBoardNo(int boardNo) {

        return boardMapper.getReplyListByBoardNo(boardNo);
    }
}
