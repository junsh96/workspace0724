package com.kh.jsp.controller.reply;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.kh.jsp.model.vo.Member;
import com.kh.jsp.model.vo.Reply;
import com.kh.jsp.service.ReplyService;

/**
 * Servlet implementation class InsertReplyController
 */
@WebServlet("/insertReply.re")
public class InsertReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertReplyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /**
     * 댓글 등록
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int refBno = Integer.parseInt(request.getParameter("boardNo"));
		
		String reply = request.getParameter("reply");
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		int writerNo = loginMember.getMemberNo();
		System.out.println(refBno);
		System.out.println(reply);
		System.out.println(writerNo);
		
		Reply r = new Reply().insertReply(reply, refBno, writerNo);
		
		int result = new ReplyService().insertReply(r);
		
		
		if (result > 0) {
			session.setAttribute("alertMsg", "댓글 등록 성공");
			
			response.sendRedirect(request.getContextPath() + "/detail.bo");
		} else {
			request.setAttribute("errorMsg", "알수 없는 오류 발생.관리자에게 문의 하세요.");
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
