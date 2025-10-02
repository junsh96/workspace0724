package com.kh.jsp.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.kh.jsp.model.vo.Board;
import com.kh.jsp.model.vo.Member;
import com.kh.jsp.service.BoardService;

/**
 * Servlet implementation class UpdateDetailController
 */
@WebServlet("/updateBoard.bo")
public class UpdateDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /**
     * 게시글 수정
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Board currentBoard = (Board)session.getAttribute("boardDetail");
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		if (session.getAttribute("loginMember") == null) {
			request.setAttribute("errorMsg", "잘못된 접근입니다.");
			request.getRequestDispatcher("views/common/error.jsp").forward(request, response);
			return;
		}
		
		int boardWriter = currentBoard.getBoardWriter();
		int loginMem = loginMember.getMemberNo();
		
		String newTitle = request.getParameter("title");
		String newContent = request.getParameter("content");
		int newCategory = Integer.parseInt(request.getParameter("category"));

		Board b = new Board();
		
		b.setBoardNo(currentBoard.getBoardNo());
		b.setCategoryNo(newCategory);
		b.setBoardTitle(newTitle);
		b.setBoardContent(newContent);
		
		Board updateBoard = new BoardService().updateBoardDetail(b);
		
		if (updateBoard == null) {
			request.setAttribute("errorMsg", "게시글 수정에 실패하였습니다. 관리자에게 문의 하세요.");
			request.getRequestDispatcher("views/common/error.jsp").forward(request, response);
			return;
		} else {
			session.setAttribute("alertMsg", "게시글 수정 성공");
			session.setAttribute("boardDetail", updateBoard);
			
			response.sendRedirect(request.getContextPath() + "/list.bo");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
