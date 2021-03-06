package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import vo.Customer;

@WebServlet("/InsertMemberController")
public class InsertMemberController extends HttpServlet {
	private MemberDao dao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 이미 로그인 상태면 IndexController 호출
		HttpSession session = request.getSession();
		if(session.getAttribute("sessionCustomerId") != null) {
			response.sendRedirect(request.getContextPath() + "/IndexController");
			return;
		}
		// dao
		dao = new MemberDao();
		// 중복을 검사할 아이디
		String checkCustomerId = null;
		if(request.getParameter("checkCustomerId") != null) {
			checkCustomerId = request.getParameter("checkCustomerId");
			if(dao.idCheckMember(checkCustomerId) == 1) { 
				System.out.println("아이디 중복!");
				request.setAttribute("msg", "이미 존재하는 아이디입니다!");
				request.getRequestDispatcher("/WEB-INF/view/customer/insertMember.jsp").forward(request, response);
				return;
			}
			request.setAttribute("customerId", checkCustomerId);
		}
		
		request.getRequestDispatcher("/WEB-INF/view/customer/insertMember.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 이미 로그인 상태면 IndexController 호출
		HttpSession session = request.getSession();
		if(session.getAttribute("sessionCustomerId") != null) {
			response.sendRedirect(request.getContextPath() + "/IndexController");
			return;
		}
	    // 요청값 처리
		if (request.getParameter("customerId") == null || request.getParameter("name") == null
				|| request.getParameter("nickName") == null || request.getParameterValues("email") == null
				|| request.getParameter("phone") == null || request.getParameter("zipCode") == null
				|| request.getParameter("province") == null || request.getParameter("city") == null
				|| request.getParameter("town") == null || request.getParameter("roadAddress") == null
				|| request.getParameter("detailAddress") == null || request.getParameter("customerPw1") == null || request.getParameter("customerPw2") == null) {
			response.sendRedirect(request.getContextPath() + "/InsertMemberController?msg=null");
			return;
		}
		
	    // customerPw = 비밀번호 선언후 초기화
		String customerPw = null;
	    if(request.getParameter("customerPw1") != null && request.getParameter("customerPw2") != null && request.getParameter("customerPw1").equals(request.getParameter("customerPw2"))) {
		    // null, 빈칸이 아닌 비밀번호가 둘이 일치한다면 customerPw에 저장
		    customerPw = request.getParameter("customerPw1");
	    } 
	    
	    // vo
	    Customer c = new Customer();
	    c.setCustomerId(request.getParameter("customerId"));
	    c.setCustomerPw(customerPw);
	    c.setName(request.getParameter("name"));
	    c.setNickName(request.getParameter("nickName"));
	    c.setEmail(request.getParameter("email"));
	    c.setPhone(request.getParameter("phone"));
	    c.setZipCode(Integer.parseInt(request.getParameter("zipCode")));
	    c.setProvince(request.getParameter("province"));
	    c.setCity(request.getParameter("city"));
	    c.setTown(request.getParameter("town"));
	    c.setRoadAddress(request.getParameter("roadAddress"));
	    c.setDetailAddress(request.getParameter("detailAddress"));
	    
	    // 디버깅
	    System.out.println(c.toString() + "<-- InsertMemberController.dopost");
	    
	    // dao.insertMember 호출
	    dao = new MemberDao();
	    int row = dao.insertMember(c);
	    
	    // 1) 회원가입 성공시, Logincontroller 호출
	    if (row == 1) { 
	    	System.out.println("가입성공 InsertMemberController.dopost");
	    	response.sendRedirect(request.getContextPath() + "/LoginController");
	    	return;
	    }
	    // 2) 회원가입 실패시(row값이 0이면...), 가입실패 + InsertMemberController 호출
	    else if(row == 0) {
	    	System.out.println("가입실패 InsertMemberController.dopost");
	    	response.sendRedirect(request.getContextPath() + "/InsertMemberController?msg=회원가입 실패!");
	    }
	    // 3) row값이 -1이면(default 값) SQL오류
	    else if (row == -1) {
	    	System.out.println("예외 발생 InsertMemberController.dopost");
	    	response.sendRedirect(request.getContextPath() + "/InsertMemberController?msg=exception");
	    }
	}
}