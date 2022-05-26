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
import vo.Order;


@WebServlet("/UpdateOrderController")
public class UpdateOrderController extends HttpServlet {
	private OrderDao orderDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 새션 확인
		HttpSession session = request.getSession();
		String customerId = (String) session.getAttribute("sessionCustomerId");
		if ((String) session.getAttribute("sessionCustomerId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		
		String customerUpdateCheck = null;
		int orderNo = Integer.parseInt(request.getParameter("orderNo"));
		String createDate = request.getParameter("createDate");
		if(request.getParameter("customerUpdateCheck") != null && !"".equals(request.getParameter("customerUpdateCheck"))) {
			customerUpdateCheck = request.getParameter("customerUpdateCheck");
		}
		String updateCheck = null;
		
		System.out.println(customerUpdateCheck + orderNo);
		orderDao = new OrderDao();
		int row = orderDao.updateOrderStatus(customerUpdateCheck, orderNo);
		
		if(row == 1) {
			System.out.println("[UpdateOrderController] : 주문 변경 성공");
		} else {
			System.out.println("[UpdateOrderController] : 주문 변경 실패");
		}
		
		List<Order> list = orderDao.selectOrderList(customerId, createDate, updateCheck, orderNo);
		
		request.setAttribute("customerUpdateCheck", customerUpdateCheck);
		request.setAttribute("orderList", list);
		request.getRequestDispatcher("/WEB-INF/view/customer/detailOrder.jsp").forward(request, response);
	}
}
