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

// 05.17 유효성 검사 추가
@WebServlet("/UpdateMemberPwController")
public class UpdateMemberPwController extends HttpServlet {	
		// 전역변수 선언
		private MemberDao dao;
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// 접속허가체크
			HttpSession session = request.getSession();
			String sessionCustomerId = (String)session.getAttribute("sessionCustomerId");
			// 로그인 확인
			if(sessionCustomerId == null) {
				response.sendRedirect(request.getContextPath() + "/LoginController");
				System.out.println("로그아웃 상태");
			}
			
			// vo
			Customer customer = new Customer();
			// dao
			dao = new MemberDao();
			customer = dao.selectMemberOne(sessionCustomerId); 
			request.setAttribute("customer", customer);
			// 중복을 검사할 아이디
			String currentPw = "";
			if(request.getParameter("currentPw") != null) {
				currentPw = request.getParameter("currentPw");
				if(dao.pwCheckMember(currentPw) == 0) { 
					System.out.println("비밀번호 불 일치!");
					request.setAttribute("msg", "현재 비밀번호를 확인하세요!");
					request.getRequestDispatcher("/WEB-INF/view/customer/updateMemberPw.jsp").forward(request, response);
					return;
				}
				request.setAttribute("customerPw", currentPw);
			}
			request.getRequestDispatcher("/WEB-INF/view/customer/updateMemberPw.jsp").forward(request, response);
		}
		
	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   // 접속허가체크
		   HttpSession session = request.getSession();
		   String sessionCustomerId = (String)session.getAttribute("sessionCustomerId");
		   // 로그인 확인
		   if(sessionCustomerId == null) {
			   response.sendRedirect(request.getContextPath() + "/LoginController");
			   System.out.println("로그아웃 상태");
			   return;
		   }
		   // UpdateMemberPw.jsp 요청 값 처리
		   Customer customer = new Customer();
		   customer.setCustomerId(request.getParameter("customerId"));
		   customer.setCustomerPw(request.getParameter("customerPw"));
		   customer.setName(request.getParameter("name"));
		   customer.setNickName(request.getParameter("nickName"));
		   customer.setEmail(request.getParameter("email"));
		   customer.setPhone(request.getParameter("phone"));
		   customer.setZipCode(Integer.parseInt(request.getParameter("zipCode")));
		   customer.setRoadAddress(request.getParameter("roadAddress"));
		   customer.setDetailAddress(request.getParameter("detailAddress"));
		 
		   // 디버깅
		   System.out.println(customer.toString() + " <-- UpdateMemberPwController.dopost");
		   
		   // 새 비밀번호 수정 코드
		   String newCustomerPw = "";
	
		   if(request.getParameter("newCustomerPw1") != null &&!request.getParameter("newCustomerPw1").equals("") && request.getParameter("newCustomerPw1").equals(request.getParameter("newCustomerPw2"))) {
			   newCustomerPw = request.getParameter("newCustomerPw1");
			   System.out.println(newCustomerPw + "<- newCustomerPw UpdateMemberPwController.dopost");
		   } else {
			   response.sendRedirect(request.getContextPath() + "/UpdateMemberPwController?msg=new password was not Match");
			   return;
		   }
		   
		   // dao.updateMemberPasswordByIdPw
		   dao = new MemberDao();
		  
		   // 회원정보 수정됐는지... 확인코드
		   int row = dao.updateMemberPasswordByIdPw(customer, newCustomerPw);
		   System.out.print(row + " <-- row UpdateMemberPwController.dopost");
		  
		   // 1) row값이 1이면 회원정보 수정 성공 -> SelectMemberOneController 호출
		   if(row == 1) {
			   System.out.print("수정성공! UpdateMemberPwController.doposdt");
			   response.sendRedirect(request.getContextPath() + "/SelectMemberOneController");
			   return;
		   }
		  
		   // 2) row값이 0이면 회원정보 수정 오류 -> UpdateMemberController 호출
		   else if(row == 0) {
		    	System.out.println("수정실패! UpdateMemberPwController.dopost");
		    	response.sendRedirect(request.getContextPath() + "/UpdateMemberPwController?msg=1");
		   } 
		  
		   // 3) row값이 -1이면 SQL 오류
		   else if (row == -1) {
		    	System.out.println("예외 발생 UpdateMemberPwController.dopost");
		    	response.sendRedirect(request.getContextPath() + "/UpdateMemberPwController?msg=exception");
		   }
	   }
}









