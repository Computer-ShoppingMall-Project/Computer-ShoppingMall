package controller;

import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BasketDao;

import java.util.*;

import vo.Basket;

@WebServlet("/MyBasketController")
public class MyBasketController extends HttpServlet {
	private BasketDao basketDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		String customerId = (String)session.getAttribute("sessionCustomerId");
		if((String)session.getAttribute("sessionCustomerId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		//
		request.setCharacterEncoding("utf-8");
		// dao.selectMyBasket
		basketDao = new BasketDao();
		ArrayList<Basket> list = basketDao.selectMyBasket(customerId);
		
		request.setAttribute("basketList", list);
		request.getRequestDispatcher("/WEB-INF/view/customer/myBasket.jsp").forward(request, response);
	}
}