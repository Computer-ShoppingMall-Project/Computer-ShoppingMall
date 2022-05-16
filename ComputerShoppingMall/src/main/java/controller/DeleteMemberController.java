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

@WebServlet("/DeleteMemberController")
public class DeleteMemberController extends HttpServlet {
	// 전역변수 선언
	private MemberDao dao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session 값 요청
		HttpSession session = request.getSession();
	    String sessionCustomerId = (String)session.getAttribute("sessionCustomerId");
	    // 로그인 check
	    if(sessionCustomerId == null) {
	        response.sendRedirect(request.getContextPath() + "/LoginController");
	        System.out.println("로그아웃 상태");
	        return;
	      }
	    request.getRequestDispatcher("/WEB-INF/view/deleteMember.jsp").forward(request, response);
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session 값 요청
		HttpSession session = request.getSession();
	    String sessionCustomerId = (String)session.getAttribute("sessionCustomerId");
	    
	    // 로그인 check
	    if(sessionCustomerId == null) {
	        response.sendRedirect(request.getContextPath() + "/LoginController");
	        System.out.println("로그아웃 상태");
	        return;
	      }
	    
		// null check
	    // if) null이면, request DeleteMemberController
	    if(request.getParameter("customerPw") == null && request.getParameter("customerId") == null) {
	    	response.sendRedirect(request.getContextPath()+"/DeleteMemberController?msg=null");
	    	return;
	    }
	    
	    // vo
	    Customer customer = new Customer();
	    customer.setCustomerId(request.getParameter("customerId"));
	    customer.setCustomerPw(request.getParameter("customerPw"));
	    
	    // 디버깅
	    System.out.println(customer.toString() + "DeleteMemberController.dopost");
	    
	    // dao.deleteMember request
	    dao = new MemberDao();
	    int row = dao.deleteMember(customer);
	    
	    // 회원 탈퇴 성공 check 코드
	    // 1) 회원 탈퇴 성공시, Login.jsp page로 이동
	    if (row == 1) { 
	    	System.out.println("삭제성공 DeleteMemberController.dopost");
	    	request.getSession().invalidate();//session 갱신 메서드-로그아웃
	    	response.sendRedirect(request.getContextPath() + "/LoginController");
	    	return;
	    }
	    
	    // 2) if) row가 0값이면 영향받은 행이 없으므로 (row 기본값 -1), 삭제 실패 -> 비밀번호 오류
	    else if(row == 0) {
	    	System.out.println("삭제실패 DeleteMemberController.dopost");
	    	response.sendRedirect(request.getContextPath() + "/DeleteMemberController?msg=wrong Pw");
	    	return;
	    }
	    
	    // 3) row가 0값이면, SQL오류 -> 예외 발생
	    else if (row == -1) {
	    	System.out.println("예외 발생 DeleteMemberController.dopost");
	    	response.sendRedirect(request.getContextPath() + "/DeleteMemberController?msg=exception");
	    	return;
	    }
	}
}