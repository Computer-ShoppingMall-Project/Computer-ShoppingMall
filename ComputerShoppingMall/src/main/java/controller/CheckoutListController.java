package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CheckoutDao;
import vo.Checkout;

@WebServlet("/CheckoutListController")
public class CheckoutListController extends HttpServlet {
	private CheckoutDao dao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		String customerId = (String)session.getAttribute("sessionCustomerId");
		if((String)session.getAttribute("sessionCustomerId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}

		dao = new CheckoutDao();
		ArrayList<Checkout> list = dao.selectCheckoutList(customerId);
		request.setAttribute("CheckoutList", list);
		request.getRequestDispatcher("/WEB-INF/view/checkout.jsp").forward(request, response);
	}
}
