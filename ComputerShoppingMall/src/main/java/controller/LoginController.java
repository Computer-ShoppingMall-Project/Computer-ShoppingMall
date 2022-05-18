package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import vo.Admin;
import vo.Customer;
//
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
   private MemberDao memberDao;
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession();
      String sessionCustomerId = (String)session.getAttribute("sessionCustomerId");
      if(sessionCustomerId != null) {
         // 이미 로그인이 되어 있는 상태라면
         response.sendRedirect(request.getContextPath() + "/IndexController");
         return;
      }
      
      request.getRequestDispatcher("/WEB-INF/nonCustomer/login.jsp").forward(request, response);
   }
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // if) 이미 로그인 상태면, IndexController 호출
      HttpSession session = request.getSession();
      if(session.getAttribute("sessionCustomerId") != null) {
         response.sendRedirect(request.getContextPath() + "/IndexController"); 
         return;
      }
      
      // request 값 처리
      String customerId = request.getParameter("customerId");
      String customerPw = request.getParameter("customerPw");
      
      
      // customer vo
      Customer c = new Customer();
      c.setCustomerId(customerId);
      c.setCustomerPw(customerPw);
      
      // admin vo
      Admin a = new Admin();
      a.setAdminId(customerId);
      a.setAdminPw(customerPw);
      
      // 모델 호출
      memberDao = new MemberDao();
      String returnCustomerId = null;
      String returnAdminId = null;
      returnCustomerId = memberDao.selectMemberByIdPw(c);
      returnAdminId = memberDao.selectAdminByIdPw(a);
      
      // 디버깅
      System.out.println(returnCustomerId+"<-returnCustomerId");
      System.out.println(returnAdminId+"<-returnAdminId");
      
      // admin아이디가 있을 시
      if(returnAdminId != null) {
         session.setAttribute("sessionAdminId", returnAdminId);
         response.sendRedirect(request.getContextPath() + "/AdminIndexController");
         return;
      }
      
      // 로그인 실패시 로그인 폼을 재요청
      if(returnCustomerId == null) {
         System.out.println("로그인실패 <-- LoginController.doPost()");
         response.sendRedirect(request.getContextPath() + "/LoginController");
         return;
      }
      
      // 로그인 성공
      // session에 sessionCustomerId 저장
      session.setAttribute("sessionCustomerId", returnCustomerId);
      response.sendRedirect(request.getContextPath() + "/IndexController");
   }
}