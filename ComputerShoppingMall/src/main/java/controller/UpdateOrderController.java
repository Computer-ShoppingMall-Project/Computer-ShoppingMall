package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDao;


@WebServlet("/UpdateOrderController")
public class UpdateOrderController extends HttpServlet {
	private OrderDao orderDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 접속허가체크
		HttpSession session = request.getSession();
		String sessionCustomerId = (String)session.getAttribute("sessionCustomerId");
		// 로그인 확인
		if(sessionCustomerId == null) {
			response.sendRedirect(request.getContextPath() + "/LoginController");
			System.out.println("로그아웃 상태");
		}
		
		String customerUpdateCheck = null;
		int orderNo = Integer.parseInt(request.getParameter("orderNo"));
		String createDate = request.getParameter("createDate");
		if(request.getParameter("customerUpdateCheck") != null && !"".equals(request.getParameter("customerUpdateCheck"))) {
			customerUpdateCheck = request.getParameter("customerUpdateCheck");
		}
		System.out.println(customerUpdateCheck + orderNo);
		orderDao = new OrderDao();
		int row = orderDao.updateOrderStatus(customerUpdateCheck, orderNo);
		
		if(row == 1) {
			System.out.println("[UpdateOrderController] : 주문 변경 성공");
		} else {
			System.out.println("[UpdateOrderController] : 주문 변경 실패");
		}
		
		response.sendRedirect(request.getContextPath()+"/DetailOrderController");
	}
}
