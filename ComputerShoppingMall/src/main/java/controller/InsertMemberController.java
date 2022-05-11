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
//
@WebServlet("/InsertMemberController")
public class InsertMemberController extends HttpServlet {
	// doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 이미 로그인 상태면 IndexController 호출
		HttpSession session = request.getSession();
		if(session.getAttribute("sessionCustomerId") != null) {
			response.sendRedirect(request.getContextPath() + "/IndexController");
			return;
		}
		// 로그인 상태가 아니면 insertMemberForm.jsp 호출
		request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
	}
	
	// doPost
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩
		request.setCharacterEncoding("UTF-8");
		// 이미 로그인 상태면 IndexController 호출
		HttpSession session = request.getSession();
		if(session.getAttribute("sessionCustomerId") != null) {
			response.sendRedirect(request.getContextPath() + "/IndexController");
			return;
		}
		/* 나중에 추가 작업 예정 **
	    // null check
		// 요청값에 null있으면 UpdateMemberController 호출
	    if(request.getParameter("name") == null || request.getParameter("age") == null || request.getParameter("memberId") == null || request.getParameter("gender") == null) {
	    	System.out.println("null insertMembercontroller.dopost");
	    	response.sendRedirect(request.getContextPath() + "/UpdateMemberController?msg=null");
	    	return;
	    }
	    */
	    
	    // 요청값 처리
	    // customerPw = 비밀번호 선언후 초기화
	    String customerPw = null; 
	    if(request.getParameter("customerPw1") != null && request.getParameter("customerPw2") != null &&!request.getParameter("customerPw1").equals("") && request.getParameter("customerPw1").equals(request.getParameter("customerPw2"))) {
	    // null, 빈칸이 아닌 비밀번호가 둘이 일치한다면 customerPw에 저장
	     customerPw = request.getParameter("customerPw1");
	    } 
	    // null, 빈칸은 아니지만 customerPw1, customerPw2가 일치하지 않으면, InsertMemberController 호출 
	    else if(request.getParameter("customerPw1") != null && request.getParameter("customerPw2") != null&&!request.getParameter("customerPw1").equals("") &&!request.getParameter("customerPw1").equals(request.getParameter("memberPw2"))) {
	    	response.sendRedirect(request.getContextPath() + "/InsertMemberController?msg=passwordisnotMatch");
	    	return;
	    }
	    
	    // vo
	    Customer c = new Customer();
	    c.setCustomerId(request.getParameter("customerId"));
	    c.setCustomerPw(customerPw);
	    c.setName(request.getParameter("name"));
	    c.setNickname(request.getParameter("nickname"));
	    c.setEmail(request.getParameter("email"));
	    c.setPhone(Integer.parseInt(request.getParameter("phone")));
	    c.setAddressId(Integer.parseInt(request.getParameter("addressId")));
	    c.setDetailAddress(request.getParameter("detailAddress"));
	    // 디버깅
	    System.out.println(c.toString() + "<-- insertMemberController.dopost");
	    
	    // dao.insertMember 호출
	    MemberDao dao = new MemberDao();
	    int row = dao.insertMember(c);
	    
	    // 회원 가입 성공 check코드
	    // 1) 회원가입 성공시, Logincontroller 호출
	    if (row == 1) { 
	    	System.out.println("가입성공 InsertMemberController.dopost");
	    	response.sendRedirect(request.getContextPath() + "/LoginController");
	    	return;
	    }
	    // 2) 회원가입 실패시(row값이 0이면...), 가입실패 + InsertMemberController 호출
	    else if(row == 0) {
	    	System.out.println("가입실패 insertMemberController.dopost");
	    	response.sendRedirect(request.getContextPath() + "/InsertMemberController?msg=insertmemberfail");

	    }
	    // 3) row값이 -1이면(default 값) SQL오류
	    else if (row == -1) {
	    	System.out.println("예외 발생 insertMemberController.dopost");
	    	response.sendRedirect(request.getContextPath() + "/InsertMemberController?msg=exception");
	    }
	}
}
