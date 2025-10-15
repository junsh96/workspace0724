package com.kh.jsp.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.kh.jsp.model.vo.Member;
import com.kh.jsp.model.vo.Reply;
import com.kh.jsp.service.BoardService;
import com.kh.jsp.service.ReplyService;

/**
 * Servlet implementation class AjaxReplyInsertController
 */
@WebServlet("/rinsert.bo")
public class AjaxReplyInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReplyInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//보내준 정보를 받아서 저장
		HttpSession session = request.getSession();
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String content = request.getParameter("content");
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		int writerMember = loginMember.getMemberNo();
		
		Reply r = new Reply().insertReply(content, boardNo, writerMember);
		
		int result = new BoardService().insertReply(r);
		
		response.getWriter().print(result);
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
