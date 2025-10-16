package com.kh.jsp.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import com.kh.jsp.model.vo.Attachment;
import com.kh.jsp.model.vo.Board;
import com.kh.jsp.service.BoardService;

/**
 * Servlet implementation class ThumbnailDetailController
 */
@WebServlet("/detail.th")
public class ThumbnailDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThumbnailDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		//조회수 증가
		//board정보 조회 -> 첨부파일 여러개
		Board b = new BoardService().boardDetail(boardNo);
		
		ArrayList<Attachment> list = new BoardService().selectThumbnailFile(boardNo);
		//thumbnailDetailView.jsp로 응답
		
		if (b == null) {
			request.setAttribute("errorMsg", "알수 없는 오류가 발생하였습니다.");
			request.getRequestDispatcher("views/common/error.jsp").forward(request, response);
		} else {
			session.setAttribute("boardDetail", b);
			session.setAttribute("boardFile", list);
			request.getRequestDispatcher("views/board/detailView.jsp").forward(request, response);
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
