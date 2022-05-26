package controller;

import java.io.IOException;
import java.util.ArrayList;

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
		String updateCheck = null; // updateList에서 넘어왔다면 updateDetail(취소/환불 목록)만 보여주기
		if(request.getParameter("updateCheck")!=null && !"".equals("updateCheck")) {
			updateCheck = request.getParameter("updateCheck");
			orderNo = Integer.parseInt(request.getParameter("orderNo"));
		} 
		
		orderDao = new OrderDao();
		ArrayList<Order> list = orderDao.adminOrderList(updateCheck);
		
		request.setAttribute("orderNo", orderNo);
		request.setAttribute("updateCheck", updateCheck);
		request.setAttribute("detailOrderList", list);
		request.setAttribute("customerId", customerId);
		request.setAttribute("createDate", createDate);
		request.setAttribute("orderStatus", list.get(0).getOrderStatus()); // 현재 주문 상태 보내주기 (옵션 유지를 위해)
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
		
		String updateCheck = null; // updateList에서 넘어왔다면 updateDetail(취소/환불 목록)만 보여주기
		int orderNo = 0;
		
		int row = 0;
		
		if(request.getParameter("updateCheck")!=null && !"".equals("updateCheck")) {
			updateCheck = request.getParameter("updateCheck");
			orderNo = Integer.parseInt(request.getParameter("orderNo"));
		}
		
		orderDao = new OrderDao();
		row = orderDao.AdminUpdateOrderStatus(orderStatus, customerId, createDate, updateCheck, orderNo);
		
		if(updateCheck!=null && "".equals(updateCheck)) { // 취소폼이라면 updateCheck 여부도 같이 보내주기
			response.sendRedirect(request.getContextPath()+"/AdminDetailOrderController?customerId="+customerId +"&&createDate="+createDate+"&&updateCheck="+updateCheck);
			return;
		}
		
		if(row > 0) { // 업데이트 성공시 리스트로 돌아가기
			System.out.println("[AdminDetailOrderController] : 상태변경 성공 " + row + "개 정보 업데이트 완료");
		} else { // 업데이트 실패시 리스트로 돌아가기
			System.out.println("[AdminDetailOrderController] : 상태변경 실패" + row + "개 정보 업데이트 완료 > 업데이트 실패");
		}
		
		response.sendRedirect(request.getContextPath()+"/AdminDetailOrderController?customerId="+customerId +"&&createDate="+createDate);
	}
}
