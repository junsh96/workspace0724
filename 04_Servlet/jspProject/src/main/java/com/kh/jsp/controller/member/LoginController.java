package com.kh.jsp.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.kh.jsp.model.vo.Member;
import com.kh.jsp.service.MemberService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login.me")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		Member m = new Member();
		m.setMemberId(userId);
		m.setMemberPwd(userPwd);
		
		Member result = new MemberService().loginMember(userId,userPwd);
		
		if (result != null) { //로그인 성공
			//로그인 성공 메세지.
			HttpSession session = request.getSession();
			session.setAttribute("loginMember",result);
			session.setAttribute("alertMsg", "로그인 성공");
			
			//request.getSession().setAttribute("alertMsg", "로그인에 성공하셨습니다.");
			//request.getSession().setAttribute("loginStatus", "Y");
			//request.getSession().setAttribute("userName", result.get(0).getMemberName());
			
			//기존에 해당 페이지를 응답하는 url이 존재한다면 굳이 다른 화면을 보여주는 것이 아니라 
			//내가 원하는 응답페이지를 다시 요청하도록 한다.
			response.sendRedirect(request.getContextPath());
			//-> localhost:8000/jspProject
		} else { // 로그인 실패
			//포워딩 방식 -> 해당 url이 변경되지 않는다.
			//기본적으로 로그인 url을 우지하면서 실패 화면을 보여야함.
			//포워드를 사용.
			request.setAttribute("errorMsg", "로그인에 실패하였습니다. 아이디와 비밀번호를 확인해주세요.");
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
