package com.kh.jsp.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;

import com.kh.jsp.model.vo.Attachment;
import com.kh.jsp.model.vo.Board;
import com.kh.jsp.model.vo.Member;
import com.kh.jsp.service.AttachmentService;
import com.kh.jsp.service.BoardService;

/**
 * Servlet implementation class InsertBoardController
 */
@WebServlet("/insertBoard.bo")
public class InsertBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getParameter("category"));
		int category = Integer.parseInt(request.getParameter("category"));
		String boardTitle = request.getParameter("title");
		String boardContent = request.getParameter("content");
		
		File newFile = new File(request.getParameter("upfile"));
	
		

		
		
		
		//파일 저장 추후 추가.
		HttpSession session = request.getSession();
		Member currentInfo = (Member) session.getAttribute("loginMember");
		int memberNo = currentInfo.getMemberNo();
		
		Board b = new Board();
		b.setBoardTitle(boardTitle);
		b.setBoardContent(boardContent);
		b.setBoardWriter(memberNo);
		b.setCategoryNo(category);
		b.setBoardType(1);
			
		
		int result = new BoardService().insertBoard(b);
		int fileResult = 0;
//		if (newFile != null) {
//			String filePath = request.getContextPath()+"/WEB-INF/file/";
//			
//			File file = new File(filePath+newFile);
//			
//			System.out.println(file);
//			
//			Attachment a = new Attachment().insertFileAttachment(newFile.getName() ,file.getPath(), file.getName());
//			
//			fileResult = new AttachmentService().uploadFile(a);
//			
//			
//			
//		} else {
//			fileResult = 1;
//		}
		
		if (result > 0) {
			session.setAttribute("alertMsg", "게시글 등록 성공");
			
			response.sendRedirect(request.getContextPath() + "/list.bo");
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
