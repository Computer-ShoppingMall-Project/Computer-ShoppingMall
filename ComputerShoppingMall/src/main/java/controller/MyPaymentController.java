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

@WebServlet("/MyPaymentController")
public class MyPaymentController extends HttpServlet {
	private OrderDao orderDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// 새션 확인
		if((String)session.getAttribute("sessionAdminId") != null) {
			// 관리자 아이디로그인시 페이지로 이동
			request.getRequestDispatcher("/WEB-INF/view/customer/myPayment.jsp").forward(request, response);
			return;
		}
		String customerId = (String) session.getAttribute("sessionCustomerId");
		if ((String) session.getAttribute("sessionCustomerId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		
		String adminId = null; // 관리자가 아님을 표시
		String updateCheck = null; // 관리자만 이용 가능한 정보
		// dao
		orderDao = new OrderDao();
		// OrderDao SELECT
		List<Map<String,Object>> list = orderDao.selectOrderDateList(customerId, adminId, updateCheck);
		
		// request set
		request.setAttribute("orderList", list);
		request.getRequestDispatcher("/WEB-INF/view/customer/myPayment.jsp").forward(request, response);
	}
}
