package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

import dao.MyBasketDao;
import vo.Basket;
import vo.Qna;

@WebServlet("/MyBasketController")
public class MyBasketController extends HttpServlet {
	private MyBasketDao dao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		String customerId = (String)session.getAttribute("sessionCustomerId");
		if((String)session.getAttribute("sessionCustomerId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}

		request.setCharacterEncoding("utf-8");
		// dao.selectMyBasket
		dao = new MyBasketDao();
		ArrayList<Basket> list = dao.selectMyBasket(customerId);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/view/MyBasket.jsp").forward(request, response);
	}
}