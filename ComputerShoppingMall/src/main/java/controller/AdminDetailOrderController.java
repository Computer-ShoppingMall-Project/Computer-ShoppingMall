package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDao;
import vo.Order;


@WebServlet("/AdminDetailOrderController")
public class AdminDetailOrderController extends HttpServlet {

	private OrderDao orderDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/DetailOrderController");
			return;
		}
		
		String customerId = request.getParameter("customerId");
		String createDate = request.getParameter("createDate");
		int orderNo = 0;
		String orderStatus = request.getParameter("odertStatus");
		String updateCheck = null; // 배송 상태 수정이 들어오지 않았을 때 상태
		if(request.getParameter("updateCheck") != null && !"".equals("updateCheck")) {
			updateCheck = request.getParameter("updateCheck"); // 주문 취소/환불 사항 리스트
		}
		
		orderDao = new OrderDao();
		List<Order> list = orderDao.selectOrderList(customerId, createDate, updateCheck, orderNo);
		
		request.setAttribute("detailOrderList", list);
		request.setAttribute("customerId", customerId);
		request.setAttribute("createDate", createDate);
		request.setAttribute("orderStatus", orderStatus);
		request.setAttribute("updateCheck", updateCheck); // 뒤로가기 버튼 경로지정을 위해 값 전송
		request.getRequestDispatcher("/WEB-INF/view/admin/adminDetailOrder.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/DetailOrderController");
			return;
		}
		
		// 상세보기로 돌아가기 위한 정보 받아오기 & 수정을 위한 정보 받아오기
		String orderStatus = request.getParameter("orderStatus");
		String customerId = request.getParameter("customerId");
		String createDate = request.getParameter("createDate");
		System.out.println("[AdminDetailOrderController.doPost] : " + customerId +"/"+ createDate);
		
		int orderNo = 0;
		String updateCheck = null;
		if(request.getParameter("updateCheck") != null && !"".equals(request.getParameter("updateCheck"))) {
			updateCheck = request.getParameter("updateCheck");
		}
		if(request.getParameter("orderNo") != null && !"".equals(request.getParameter("orderNo"))) {
			orderNo = Integer.parseInt(request.getParameter("orderNo"));
		}
		
		orderDao = new OrderDao();
		
		System.out.println(updateCheck);
		
		int row = orderDao.AdminUpdateOrderStatus(orderStatus, customerId, createDate, orderNo);
		
		if(row > 0) { // 업데이트 성공시 해당 상세보기로 돌아가기
			System.out.println("[AdminDetailOrderController] : 상태변경 성공 " + row + "개 정보 업데이트 완료");
		} else { // 업데이트 성공시 해당 상세보기로 돌아가기
			System.out.println("[AdminDetailOrderController] : 상태변경 실패" + row + "개 정보 업데이트 완료 > 업데이트 실패");
		}
		
		orderDao = new OrderDao();
		List<Order> list = orderDao.selectOrderList(customerId, createDate, updateCheck, orderNo);
		
		request.setAttribute("detailOrderList", list);
		request.setAttribute("updateCheck", updateCheck);
		request.getRequestDispatcher("/WEB-INF/view/admin/adminDetailOrder.jsp").forward(request, response);
	}
}
