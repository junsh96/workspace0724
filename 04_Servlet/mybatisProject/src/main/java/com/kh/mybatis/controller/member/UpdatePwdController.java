package com.kh.mybatis.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.kh.mybatis.model.vo.Member;
import com.mybatis.jsp.service.MemberService;


/**
 * Servlet implementation class UpdatePwdController
 */
@WebServlet("/updatePwd.me")
public class UpdatePwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePwdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();;
		
		String currentPwd = request.getParameter("userPwd");
		String newPwd = request.getParameter("updatePwd");
		Member currentInfo= (Member)session.getAttribute("loginMember");
		String userId = currentInfo.getMemberId();
		
		Member newInfo = new MemberService().updatePwd(currentPwd,newPwd,userId);
		
		if(currentInfo == null || !currentInfo.getMemberPwd().equals(currentPwd)) {
			request.setAttribute("errorMsg", "잘못된 접근입니다.");
			request.getRequestDispatcher("views/common/error.jsp").forward(request, response);
			return;
		} 
		
		if (newInfo != null) {
			
			session.setAttribute("loginMember",newInfo);
			session.setAttribute("alertMsg", "회원정보 수정 성공");
			
			response.sendRedirect(request.getContextPath() + "/myPage.me");
		} else {
			request.setAttribute("errorMsg", "회원 정보 수정에 실패하였습니다. 관리자에게 문의 하세요.");
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
