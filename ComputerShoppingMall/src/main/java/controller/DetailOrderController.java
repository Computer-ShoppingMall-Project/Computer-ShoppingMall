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
import vo.order;

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
		String createDate = null;
		// request create_date
		createDate = request.getParameter("createDate");
		// dao
		orderDao = new OrderDao();
		ArrayList<order> list = orderDao.selectOrderList(customerId, createDate);
		// request set
		request.setAttribute("orderList", list);
		request.getRequestDispatcher("/WEB-INF/view/customer/detailOrder.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
	}

}