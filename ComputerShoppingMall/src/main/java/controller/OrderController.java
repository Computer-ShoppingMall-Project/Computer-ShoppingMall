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
import dao.BasketDao;
import dao.MemberDao;
import vo.Basket;
import vo.Customer;

@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
	private OrderDao dao;
	private BasketDao bDao;
	private MemberDao memberDao;
	private BasketDao myBasketDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		String customerId = (String) session.getAttribute("sessionCustomerId");
		if ((String) session.getAttribute("sessionCustomerId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		// MyBasketDao
		bDao = new BasketDao();
		memberDao = new MemberDao();
		// MyBasketDao select
		ArrayList<Basket> list = bDao.selectMyBasket(customerId);
		// vo
		Customer c = memberDao.selectMemberOne(customerId);
		
		// request set
		request.setAttribute("basketList", list);
		request.setAttribute("customer", c);
		
		request.getRequestDispatcher("/WEB-INF/customer/order.jsp").forward(request, response);
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
		
		// CheckoutDao insert
		dao = new OrderDao();
		int row = dao.insertOrder(customerId);
		
		// MybasketDao delete
		myBasketDao = new BasketDao();
		myBasketDao.paymentDeleteMyBasket(customerId);
		
		if(row > 0) {
			System.out.println("결제 정보 저장 성공 InsertCheckoutController.dopost");
			response.sendRedirect(request.getContextPath() + "/MypaymentController");
			return;
		} else {
			System.out.println("입력실패");
			response.sendRedirect(request.getContextPath() + "/OrderController");
			return;
		}
	}

}
