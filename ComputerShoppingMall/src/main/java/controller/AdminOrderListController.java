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

@WebServlet("/AdminOrderListController")
public class AdminOrderListController extends HttpServlet {
	private OrderDao orderDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/MyPaymentController");
			return;
		}
		
		String customerId = null;
		String adminId = (String)session.getAttribute("sessionAdminId"); // 고객 전체보기 sql 쿼리를 타게하기 위함
		String updateCheck = null; // 배송 상태 수정이 들어오지 않았을 때 상태
		if(request.getParameter("updateCheck") != null && !"".equals("updateCheck")) {
			updateCheck = request.getParameter("updateCheck"); // 주문 취소/환불 사항 리스트
		}
		
		orderDao = new OrderDao();
		List<Map<String, Object>> list = orderDao.selectOrderDateList(customerId, adminId, updateCheck);
		
		request.setAttribute("orderList", list);
		request.setAttribute("updateCheck", updateCheck);
		request.getRequestDispatcher("/WEB-INF/view/admin/adminOrderList.jsp").forward(request, response);
	}
}