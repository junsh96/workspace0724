package com.kh.jsp.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.fileupload2.core.DiskFileItemFactory;
import org.apache.commons.fileupload2.core.FileItem;
import org.apache.commons.fileupload2.jakarta.JakartaServletFileUpload;

import com.kh.jsp.model.vo.Attachment;
import com.kh.jsp.model.vo.Board;
import com.kh.jsp.model.vo.Member;
import com.kh.jsp.service.BoardService;

/**
 * Servlet implementation class ThumbnailInserController
 */
@WebServlet("/insert.th")
public class ThumbnailInserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThumbnailInserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (JakartaServletFileUpload.isMultipartContent(request)) {
			//파일 저장 추후 추가.
			HttpSession session = request.getSession();
			
			Member loginMember = (Member) session.getAttribute("loginMember");
			
			//파일 용량 제한
			int fileMaxSize = 1024 * 1024 * 50; // 50MB
			
			int requestMaxSize = 1024 * 1024 * 60;// 전체 요청 크기 제한
			// 저장 시킬 파일 경로
			String savePath = request.getServletContext().getRealPath("/resources/thumbnail-file/");
			
			//3. DiskFileItemFactory(파일을 임시로 저장) 객체 생성
			DiskFileItemFactory factory = DiskFileItemFactory.builder().get();
			
			//4. JakartaServletFileUpload : http요청으로 전달된 파일데이터를 파싱 -> 개별 FileItem 객체로 변환
			JakartaServletFileUpload upload = new JakartaServletFileUpload(factory);
			upload.setFileSizeMax(fileMaxSize);
			upload.setSizeMax(requestMaxSize);
			
			List<FileItem> formItems = upload.parseRequest(request);
			
			Board b = new Board();
			Attachment at = null;
			ArrayList<Attachment> list = new ArrayList<>();
			for (FileItem item : formItems) {
				
				//업로드된 데이터가 일반 폼필드인지 파일인지 구분
				if(item.isFormField()) {
					switch(item.getFieldName()) {
					case "title":
						String title = item.getString(Charset.forName("UTF-8"));
						b.setBoardTitle(title);
						break;
					case "content" :
						String content = item.getString(Charset.forName("UTF-8"));
						b.setBoardContent(content);
						break;
					case "writer" : 
						int writer = Integer.parseInt(item.getString(Charset.forName("UTF-8")));
						b.setBoardWriter(writer);
						break;
					}	
				} else {
					String originName = item.getName();
					
					if (originName.length() > 0) {
						//파일 명이 겹치면 덮어 씌우기 때문에 고유한 파일 명 생성
						String tmpName = "kh_" +System.currentTimeMillis() + ((int)(Math.random() * 10000)+1);
						String type = originName.substring(originName.lastIndexOf("."));
						String changeName = tmpName + type;
						
						File f = new File(savePath,changeName);
						item.write(f.toPath()); //지정한 경로에 파일 업로드
						
						at = new Attachment();
						at.setOriginName(originName);
						at.setChangeName(changeName);
						at.setFilePath("/resources/thumbnail-file");				
						at.setFileLevel(item.getFieldName().equals("file1") ? 1: 2);
						
						list.add(at);
						
					}
				}
			}
			
			b.setBoardType(2);
			
			
			int result = new BoardService().insertThumbBoard(b,list);
			
			if (result > 0) {
				session.setAttribute("alertMsg", "게시글 등록 성공");
				
				response.sendRedirect(request.getContextPath() + "/list.bo");
			} else {
				for (Attachment at2 : list) {
					new File(savePath + at2.getChangeName()).delete();
				}
				request.setAttribute("errorMsg", "알수 없는 오류 발생.관리자에게 문의 하세요.");
				request.getRequestDispatcher("views/common/error.jsp").forward(request, response);
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
