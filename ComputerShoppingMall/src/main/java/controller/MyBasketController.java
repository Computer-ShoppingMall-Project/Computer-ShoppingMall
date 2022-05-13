package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MyBasketDao;
import vo.Basket;

@WebServlet("/MyBasketController")
public class MyBasketController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		// 접속허가체크 -> 새션값 요청
		HttpSession session = request.getSession();
		String sessionCustomerId = (String) session.getAttribute("sessionCustomerId");
		// 로그인 확인
		if (sessionCustomerId == null) {
			response.sendRedirect(request.getContextPath() + "/LoginController");
			System.out.println("로그아웃 상태");
			return;
		}
		*/
		String customerId = "guest";
		
		// dao.selectMyBasket
		MyBasketDao dao = new MyBasketDao();
		Basket basket = dao.selectMyBasket(customerId);
	
		request.setAttribute("basket", basket);
		
		request.getRequestDispatcher("/WEB-INF/view/MyBasket.jsp").forward(request, response);
	}
}