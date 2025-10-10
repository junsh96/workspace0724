package com.kh.jsp.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.kh.jsp.model.vo.Member;
import com.kh.jsp.service.MemberService;

/**
 * Servlet implementation class InsertController
 */
@WebServlet("/insert.me")
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//member 추가
		
		//전달 받은 데이터 추출
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String[] interestArr = request.getParameterValues("interest");
		
		//String [] => 문자열로
		String interset ="";
		if (interestArr != null) {
			interset = String.join(",", interestArr);
		}

		
		Member m = Member.insertCreateMember(userId, userPwd, userName, phone, email, address, interset);

		int result = new MemberService().insertMember(m);

		
		if (result > 0) { //가입 성공
			
			request.getSession().setAttribute("alertMsg", "회원가입에 성공하셨습니다.");
			
			response.sendRedirect("/jspProject/");
		} else { //가입 실패
			request.setAttribute("errorMsg", "회원가입에 실패하였습니다.");
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
