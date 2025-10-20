package com.kh.mybatis.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.kh.mybatis.model.vo.Attachment;
import com.kh.mybatis.model.vo.Board;
import com.kh.mybatis.model.vo.Category;
import com.kh.mybatis.model.vo.Member;
import com.mybatis.jsp.service.BoardService;


/**
 * Servlet implementation class UpdateBoardController
 */
@WebServlet("/update.bo")
public class UpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /**
     * 수정하기 페이지로 이동
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		Board currentBoard = new BoardService().boardDetail(boardNo);
		Member loginMember = (Member)session.getAttribute("loginMember");

		Attachment at = new BoardService().selectBoardFile(currentBoard.getBoardNo());
		
		int boardWriter = currentBoard.getBoardWriter();
		int loginMem = loginMember.getMemberNo();
		
		ArrayList<Category> categoryList = new BoardService().categoryList();
		session.setAttribute("categoryList", categoryList);
		session.setAttribute("boardFile", at);
		
		if (boardWriter != loginMem || session.getAttribute("loginMember") == null) {
			request.setAttribute("errorMsg", "잘못된 접근입니다.");
			request.getRequestDispatcher("views/common/error.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("views/board/updateForm.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
