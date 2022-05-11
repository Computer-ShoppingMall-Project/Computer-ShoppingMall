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

@WebServlet("/UpdateMemberController")
public class UpdateMemberController extends HttpServlet {	
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
			Customer c = new Customer();
			// dao.selectMemberOne
			MemberDao dao = new MemberDao();
			c = dao.selectMemberOne(sessionCustomerId); 
			request.setAttribute("c", c);
			// updateMemberForm.jsp 생성 작업 필요
			request.getRequestDispatcher("/WEB-INF/view/updateMemberForm.jsp").forward(request, response);
		}
		
	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   // 한글 깨짐 방지 인코딩
		   request.setCharacterEncoding("UTF-8");
		   // 접속허가체크
		   HttpSession session = request.getSession();
		   String sessionCustomerId = (String)session.getAttribute("sessionCustomer");
		   // 로그인 확인
		   if(sessionCustomerId == null) {
			   response.sendRedirect(request.getContextPath() + "/LoginController");
			   System.out.println("로그아웃 상태");
			   return;
		   }
		   // null 확인코드
		   if(request.getParameter("name") == null || request.getParameter("nickname") == null || request.getParameter("email") == null || request.getParameter("phone") == null || request.getParameter("addressId") == null || request.getParameter("detailAddress") == null || request.getParameter("customerId") == null || request.getParameter("name") == null ) {
			   System.out.println("null UpdateMembercontroller.dopost");
			   response.sendRedirect(request.getContextPath() + "/UpdateMemberController");
			   return;
		   }
		   
		   // UpdateMemberForm.jsp 요청 값 처리
		   Customer c = new Customer();
		   c.setCustomerId(request.getParameter("customerId"));
		   c.setCustomerPw(request.getParameter("customerPw"));
		   c.setName(request.getParameter("name"));
		   c.setName(request.getParameter("nickname"));
		   c.setName(request.getParameter("email"));
		   c.setName(request.getParameter("phone"));
		   c.setAddressId(Integer.parseInt(request.getParameter("addressId")));
		   c.setDetailAddress(request.getParameter("detailAddress"));
		   // 디버깅
		   System.out.println(c.toString() + " <-- UpdateMemberController.dopost");
		   
		   // dao.updateMember
		   MemberDao dao = new MemberDao();
		   // 회원정보 수정됐는지... 확인코드
		   int row = dao.updateMember(c);
		   System.out.print(row + " <-- row UpdateMemberController.dopost");
		   // 1) row값이 1이면 회원정보 수정 성공 -> SelectMemberOneController 호출
		   if(row == 1) {
			   System.out.print("수정성공! UpdateMemberController.doposdt");
			   response.sendRedirect(request.getContextPath() + "/SelectMemberOneController");
			   return;
		   }
		   // 2) row값이 0이면 회원정보 수정 오류 -> UpdateMemberController 호출
		   else if(row == 0) {
		    	System.out.println("수정실패! UpdateMemberController.dopost");
		    	response.sendRedirect(request.getContextPath() + "/UpdateMemberController?msg=failrenewpassword");
		   } 
		   // 3) row값이 -1이면 SQL 오류
		   else if (row == -1) {
		    	System.out.println("예외 발생 UpdateMemberController.dopost");
		    	response.sendRedirect(request.getContextPath() + "/UpdateMemberController?msg=exception");
		   }
	   }
}












