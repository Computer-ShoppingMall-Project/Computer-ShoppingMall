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
		// 새션 확인
		if((String)session.getAttribute("sessionAdminId") != null) {
			// 관리자 아이디로그인시 페이지로 이동
			request.getRequestDispatcher("/WEB-INF/view/customer/myBasket.jsp").forward(request, response);
			return;
		}
		String customerId = (String)session.getAttribute("sessionCustomerId");
		if((String)session.getAttribute("sessionCustomerId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		int productNumber = Integer.parseInt(request.getParameter("productNumber"));
		String productName = request.getParameter("productName");
		String categoryName =request.getParameter("categoryName");
		int price = Integer.parseInt(request.getParameter("price"));
		int quantity = 1;
		 
		// vo
		Basket basket = new Basket();
		basket.setProductNumber(productNumber);
		basket.setProductName(productName);
		basket.setCategoryName(categoryName);
		basket.setPrice(price);
		basket.setQuantity(quantity);
		// 디버깅
		System.out.println("[basketList] :"+ basket.toString());
		
		// dao
		basketDao = new BasketDao();
		// dao.insertMyBasket
		int row = basketDao.insertMyBasket(customerId, basket);
		// dao.selectMyBasket
		ArrayList<Basket> list = basketDao.selectMyBasket(customerId);
		
		if(row >1 ) {
			request.setAttribute("basketList", list);
			request.getRequestDispatcher("/WEB-INF/view/customer/myBasket.jsp").forward(request, response);
		}
	}
}