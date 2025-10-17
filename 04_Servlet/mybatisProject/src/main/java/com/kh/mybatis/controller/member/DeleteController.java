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
 * Servlet implementation class DeleteController
 */
@WebServlet("/delete.me")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userPwd = request.getParameter("userPwd");
		HttpSession session =  request.getSession();
		Member currentInfo = (Member) session.getAttribute("loginMember");
		String currentPwd = currentInfo.getMemberPwd();
		String userId = currentInfo.getMemberId();
		

		
		if (!userPwd.equals(currentPwd)) {
			request.setAttribute("errorMsg", "비밀번호가 일치하지 않습니다.");
			request.getRequestDispatcher("views/common/error.jsp").forward(request, response);
			return;
		}
		
		int result = new MemberService().deleteMember(userId);
		
		if (result > 0) {
			session.setAttribute("loginMember",null);
			session.setAttribute("alertMsg", "회원탈퇴 성공");
			
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("errorMsg", "알수없는 오류가 발생했습니다. 관리자에게 문의 바랍니다.");
			request.getRequestDispatcher("views/common/error.jsp").forward(request, response);
			return;
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
