package com.kh.mybatis.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;

import com.kh.mybatis.model.vo.Attachment;
import com.kh.mybatis.model.vo.Board;
import com.kh.mybatis.model.vo.Member;
import com.mybatis.jsp.service.BoardService;



/**
 * Servlet implementation class DeleteBoardController
 */
@WebServlet("/deleteBoard.bo")
public class DeleteBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //게시글 삭제
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Board currentBoard = (Board)session.getAttribute("boardDetail");
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		
		
		int loginUser = loginMember.getMemberNo();
		int boardUser = currentBoard.getBoardWriter();
		int boardNo = currentBoard.getBoardNo();
		
		Attachment a = new BoardService().selectBoardFile(boardNo);
		
		if (session.getAttribute("loginMember") == null) {
			request.setAttribute("errorMsg", "잘못된 접근입니다.");
			request.getRequestDispatcher("views/common/error.jsp").forward(request, response);
			return;
		}
		
		if (loginUser != boardUser) {
			request.setAttribute("errorMsg", "권한이 없습니다.");
			response.sendRedirect(request.getContextPath() + "/list.bo");
			return;
		}
		
		int result = new BoardService().deleteBoard(currentBoard.getBoardNo());
		int fileResult = 1;
		
		if (a.getFileNo() != 0) {
			fileResult = new BoardService().deleteFile(a.getFileNo());
			
			String filePath = a.getFilePath();
			String fileName = a.getOriginName();
			String changeName = a.getChangeName();
			File deleteFile = new File(filePath+changeName);
			
			if (deleteFile.exists()) {
			    if (deleteFile.delete()) {
			        System.out.println("파일 삭제 완료: " + filePath);
			    } else {
			        System.out.println("파일 삭제 실패 (권한 또는 접근 문제): " + filePath);
			    }
			} else {
			    System.out.println("파일이 존재하지 않습니다: " + filePath);
			}
		}

		
		
		if (result > 0 && fileResult > 0) {
			session.setAttribute("alertMsg", "게시글 삭제 성공");
			session.setAttribute("boardDetail", null);
			
			response.sendRedirect(request.getContextPath() + "/list.bo");
		} else {
			request.setAttribute("errorMsg", "게시글 삭제에 실패하였습니다. 관리자에게 문의 하세요.");
			request.getRequestDispatcher("views/common/error.jsp").forward(request, response);
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
