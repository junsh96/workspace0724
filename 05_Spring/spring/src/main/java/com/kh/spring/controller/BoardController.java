package com.kh.spring.controller;

import com.kh.spring.model.vo.Board;
import com.kh.spring.model.vo.Category;
import com.kh.spring.model.vo.Member;
import com.kh.spring.model.vo.Reply;
import com.kh.spring.service.BoardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Controller
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    /**
     * 게시물 목록 조회
     * @param cpage
     * @return
     */
    @GetMapping("list.bo")
    public String selectBoardList(@RequestParam(value ="cpage", defaultValue = "1") int cpage, Model model) {
        Map<String,Object> result =  boardService.getBoardList(cpage);

        model.addAttribute("list",result.get("list"));
        model.addAttribute("pi",result.get("pi"));

        return  "board/listView";
    }

    @GetMapping("/enrollForm.bo")
    public String enrillForm(Model model) {
        List<Category> categories = boardService.selectCategories();

        model.addAttribute("categories",categories);
        return "board/enrollForm";
    }

    @GetMapping("/detail.bo")
    public String detailBoard(@RequestParam(value = "bno", required = true) int boardNo, Model model) {
        Map<String,Object> result = boardService.getBoardByIdWithCount(boardNo);

        if (result.get("board") != null) {
            model.addAttribute("board",result.get("board"));
            model.addAttribute("at",result.get("at"));
            return  "board/detailView";
        } else {
            model.addAttribute("errorMsg","에러가 발생하였습니다.");

            return "common/error";
        }

    }

    @GetMapping("/updateForm.bo")
    public String updateForm(@RequestParam(value = "bno", required = true) int boardNo, Model model) {
        List<Category> categories = boardService.selectCategories();

        Map<String,Object> result = boardService.getBoardById(boardNo);

        model.addAttribute("categories",categories);
        model.addAttribute("board",result.get("board"));
        model.addAttribute("at",result.get("at"));
        return "board/updateForm";
    }

    //게시글 수정
    @PostMapping("/update.bo")
    public String updateBoard(Board board,
                              @RequestParam(value = "upfile", required = false) MultipartFile file,
                              @RequestParam(value = "originFileNo", required = false) Integer originFileNo,
                              HttpSession session , Model model) {

        int reuslt = boardService.updateBoard(board,originFileNo,file);
        return "";
    }

    //spring boot에는 spring boot starter web 의존을 추가하면
    @PostMapping("/insert.bo")
    public String insertBoard(Board board,
                              @RequestParam(value="upFile" , required = false) MultipartFile upFile,
                              HttpSession  session, Model model) {

        Member loginMember = (Member) session.getAttribute("loginMember");
        System.out.println(board);
        board.setBoardWriter(loginMember.getMemberNo());
        int result = boardService.insertBoard(board,upFile);

        if (result > 0) {
            session.setAttribute("alertMsg", "게시글 등록 완료");
            return "redirect:/list.bo";
        } else {
            model.addAttribute("errMsg", "게시글 등록 실패");
            return "common/error";
        }


    }

    @PostMapping("/rinsert.bo")
    @ResponseBody
    public String insertReply(@RequestParam("boardNo") int boardNo,
                              @RequestParam("content") String content,
                              HttpSession session, Model model) {

        Member loginMember = (Member)session.getAttribute("loginMember");
        Reply reply = new Reply();

        reply.setRefBno(boardNo);
        reply.setReplyContent(content);
        reply.setReplyWriter(loginMember.getMemberNo());

        int result = boardService.insertReply(reply);

        if (result > 0) {
            return "1";
        } else {
            return "0";
        }

    }

    @GetMapping("/rilst.bo")
    @ResponseBody
    public List<Reply> rilstBoard(@RequestParam(value = "boardNo", required = true) int boardNo, Model model) {

       return boardService.getReplyListByBoardNo(boardNo);
    }



}
