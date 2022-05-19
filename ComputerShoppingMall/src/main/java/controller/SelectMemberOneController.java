package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import vo.Customer;

@WebServlet("/SelectMemberOneController")
public class SelectMemberOneController extends HttpServlet {
	private MemberDao dao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 접속허가체크 -> 새션값 요청
		HttpSession session = request.getSession();
		String sessionCustomerId = (String)session.getAttribute("sessionCustomerId");
		// 로그인 확인
		if(sessionCustomerId == null) {
			response.sendRedirect(request.getContextPath() + "/LoginController");
			System.out.println("로그아웃 상태");
			return;
		}
		
		dao = new MemberDao();
		Customer customer = dao.selectMemberOne(sessionCustomerId);
		
		request.setAttribute("customer", customer);
		request.getRequestDispatcher("/WEB-INF/view/customer/memberOne.jsp").forward(request, response);
	}
}