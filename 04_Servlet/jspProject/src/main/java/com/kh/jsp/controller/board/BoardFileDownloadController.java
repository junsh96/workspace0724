package com.kh.jsp.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import com.kh.jsp.model.vo.Attachment;
import com.kh.jsp.service.AttachmentService;

/**
 * Servlet implementation class BoardFileDownloadController
 */
@WebServlet("/download.at")
public class BoardFileDownloadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFileDownloadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /**
     * 게시글 파일 다운로드
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String filePath = request.getParameter("filePath");
		String fileName = request.getParameter("fileName");
		String changeName = request.getParameter("changeName");
		String savePath = request.getServletContext().getRealPath(filePath);
		
		File downloadFile = new File(savePath+changeName);

        if (!downloadFile.exists()) {
            response.getWriter().print("파일이 존재하지 않습니다.");
            return;
        }
        

        response.setContentType("application/octet-stream");
        response.setContentLength((int) downloadFile.length());


        String encodedFileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + encodedFileName + "\"");


        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(downloadFile));
             BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream())) {
            
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
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
