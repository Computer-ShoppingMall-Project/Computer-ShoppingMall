package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BasketDao;
import dao.MemberDao;
import dao.OrderDao;
import vo.Basket;
import vo.Customer;
import vo.Order;

@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
	private OrderDao dao;
	private MemberDao memberDao;
	private BasketDao myBasketDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		// 새션 확인
		if((String)session.getAttribute("sessionAdminId") != null) {
			// 관리자 아이디로그인시 페이지로 이동
			request.getRequestDispatcher("/WEB-INF/view/customer/order.jsp").forward(request, response); 
			return;
		}
		String customerId = (String) session.getAttribute("sessionCustomerId");
		if ((String) session.getAttribute("sessionCustomerId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		// MyBasketDao
		myBasketDao = new BasketDao();
		memberDao = new MemberDao();
		// MyBasketDao select
		ArrayList<Basket> list = myBasketDao.selectMyBasket(customerId);
		// vo
		Customer c = memberDao.selectMemberOne(customerId);
		
		// request set
		request.setAttribute("basketList", list);
		request.setAttribute("customer", c);
		request.getRequestDispatcher("/WEB-INF/view/customer/order.jsp").forward(request, response); // 05.18 경로수정
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		String customerId = (String) session.getAttribute("sessionCustomerId");
		if ((String) session.getAttribute("sessionCustomerId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
	
		// form 값 받아오기
		int zipCode = Integer.parseInt(request.getParameter("zipCode"));  
		String roadAddress = request.getParameter("roadAddress");
		String detailAddress = request.getParameter("detailAddress");
		// orderDao.insertOrder
		dao = new OrderDao();
		int row = dao.insertOrder(customerId, zipCode, roadAddress, detailAddress);
	
		if(row > 0) {
			System.out.println("결제 정보 저장 성공 OrderController.dopost");
			response.sendRedirect(request.getContextPath() + "/MyPaymentController");
			return;
		} else {
			System.out.println("입력실패");
			response.sendRedirect(request.getContextPath() + "/OrderController");
			return;
		}
	}

}
