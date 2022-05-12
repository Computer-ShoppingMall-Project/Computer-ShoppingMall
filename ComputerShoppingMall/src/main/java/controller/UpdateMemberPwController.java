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

@WebServlet("/UpdateMemberPwController")
public class UpdateMemberPwController extends HttpServlet {	
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
			// dao.selectMemberOne
			MemberDao dao = new MemberDao();
			customer = dao.selectMemberOne(sessionCustomerId); 
			request.setAttribute("customer", customer);
			// updateMemberForm.jsp 생성 작업 필요
			request.getRequestDispatcher("/WEB-INF/view/UpdateMemberPw.jsp").forward(request, response);
		}
		
	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   // 한글 깨짐 방지 인코딩
		   request.setCharacterEncoding("UTF-8");
		   // 접속허가체크
		   HttpSession session = request.getSession();
		   String sessionCustomerId = (String)session.getAttribute("sessionCustomerId");
		   // 로그인 확인
		   if(sessionCustomerId == null) {
			   response.sendRedirect(request.getContextPath() + "/LoginController");
			   System.out.println("로그아웃 상태");
			   return;
		   }
		   // null 확인코드
		   if(request.getParameter("customerId") == null || request.getParameter("customerPw") == null ) {
			   System.out.println("null UpdateMemberPwcontroller.dopost");
			   response.sendRedirect(request.getContextPath() + "/UpdateMemberPwController");
			   return;
		   }
		   
		   // UpdateMemberForm.jsp 요청 값 처리
		   Customer customer = new Customer();
		   customer.setCustomerId(request.getParameter("customerId"));
		   customer.setCustomerPw(request.getParameter("customerPw"));
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
		   MemberDao dao = new MemberDao();
		   // 회원정보 수정됐는지... 확인코드
		   int row = dao.updateMemberPasswordByIdPw(customer);
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
		    	response.sendRedirect(request.getContextPath() + "/UpdateMemberPwController?msg=failrenewpassword");
		   } 
		   // 3) row값이 -1이면 SQL 오류
		   else if (row == -1) {
		    	System.out.println("예외 발생 UpdateMemberPwController.dopost");
		    	response.sendRedirect(request.getContextPath() + "/UpdateMemberPwController?msg=exception");
		   }
	   }
}









