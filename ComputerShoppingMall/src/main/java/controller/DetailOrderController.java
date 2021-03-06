package controller;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet("/DetailOrderController")
public class DetailOrderController extends HttpServlet {
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
		// 변수 등록
		String customerUpdateCheck = null;
		String createDate = request.getParameter("createDate");
		int orderNo = 0;
		String updateCheck = null;
		if(request.getParameter("updateCheck") != null && !"".equals(request.getParameter("updateCheck"))) {
			updateCheck = request.getParameter("updateCheck");
		}
		// dao
		orderDao = new OrderDao();
		List<Order> list = orderDao.selectOrderList(customerId, createDate, updateCheck, orderNo);
		// request set
		request.setAttribute("customerUpdateCheck", customerUpdateCheck);
		request.setAttribute("orderList", list);
		request.getRequestDispatcher("/WEB-INF/view/customer/detailOrder.jsp").forward(request, response);
	}

}