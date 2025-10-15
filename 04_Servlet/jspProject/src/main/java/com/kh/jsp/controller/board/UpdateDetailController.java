package com.kh.jsp.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.fileupload2.core.DiskFileItemFactory;
import org.apache.commons.fileupload2.core.FileItem;
import org.apache.commons.fileupload2.jakarta.JakartaServletFileUpload;

import com.kh.jsp.model.vo.Attachment;
import com.kh.jsp.model.vo.Board;
import com.kh.jsp.model.vo.Member;
import com.kh.jsp.service.AttachmentService;
import com.kh.jsp.service.BoardService;

/**
 * Servlet implementation class UpdateDetailController
 */
@MultipartConfig
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
		
		Part newFile = request.getPart("upfile");
		
		if (session.getAttribute("loginMember") == null) {
			request.setAttribute("errorMsg", "잘못된 접근입니다.");
			request.getRequestDispatcher("views/common/error.jsp").forward(request, response);
			return;
		}
		
		if (JakartaServletFileUpload.isMultipartContent(request)) {
			
			int boardUser = currentBoard.getBoardWriter();
			int boardNo = currentBoard.getBoardNo();
			int loginUser = loginMember.getMemberNo();
			Attachment oldAt = new AttachmentService().selectBoardFile(boardNo);
			
			if (loginUser != boardUser) {
				request.setAttribute("errorMsg", "권한이 없습니다.");
				response.sendRedirect(request.getContextPath() + "/list.bo");
				return;
			}
			int fileMaxSize = 1024 * 1024 * 50; // 50MB
			
			int requestMaxSize = 1024 * 1024 * 60;// 전체 요청 크기 제한
			// 저장 시킬 파일 경로
			String savePath = request.getServletContext().getRealPath("/resources/board-file/");
			
			//3. DiskFileItemFactory(파일을 임시로 저장) 객체 생성
			DiskFileItemFactory factory = DiskFileItemFactory.builder().get();
			
			//4. JakartaServletFileUpload : http요청으로 전달된 파일데이터를 파싱 -> 개별 FileItem 객체로 변환
			JakartaServletFileUpload upload = new JakartaServletFileUpload(factory);
			upload.setFileSizeMax(fileMaxSize);
			upload.setSizeMax(requestMaxSize);
			List<FileItem> formItems = upload.parseRequest(request);
			
			Board b = new Board();
			Attachment at = null;
			
			for (FileItem item : formItems) {
				if(item.isFormField()) {
					switch(item.getFieldName()) {
					case "category":
						int newCategory = Integer.parseInt(item.getString(Charset.forName("UTF-8")));
						b.setCategoryNo(newCategory);
						break;
					case "title" :
						String newTitle = item.getString(Charset.forName("UTF-8"));
						b.setBoardTitle(newTitle);
						break;
					case "content" : 
						String newContent = item.getString(Charset.forName("UTF-8"));
						b.setBoardContent(newContent);
						break;
					}
				} else {
					String originName = item.getName();
					
					if (originName.length() > 0) {
						
						if (!originName.equals(oldAt.getOriginName())) {
							String tmpName = "kh_" +System.currentTimeMillis() + ((int)(Math.random() * 10000)+1);
							String type = originName.substring(originName.lastIndexOf("."));
							String changeName = tmpName + type;
							
							File f = new File(savePath,changeName);
							item.write(f.toPath()); //지정한 경로에 파일 업로드
							
							at = new Attachment();
							at.setOriginName(originName);
							at.setChangeName(changeName);
							at.setFilePath("/resources/board-file");
						}
						
					} else {
						
						if (oldAt.getOriginName() != null) {
							new File(savePath + oldAt.getChangeName()).delete();
						}
						
					}
				}
				
			}
			
			
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
		
	

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
