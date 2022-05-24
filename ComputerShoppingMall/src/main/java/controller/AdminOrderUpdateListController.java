package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDao;
import vo.Order;

@WebServlet("/AdminOrderUpdateListController")
public class AdminOrderUpdateListController extends HttpServlet {
	
	private OrderDao orderDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/MyPaymentController");
			return;
		}
		
		orderDao = new OrderDao();
		ArrayList<Order> list = orderDao.adminOrderList();
		
		request.setAttribute("orderList", list);
		request.getRequestDispatcher("/WEB-INF/view/admin/adminOrderUpdateList.jsp").forward(request, response);
	}
}
