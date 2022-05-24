 package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BasketDao;
import vo.Basket;

@WebServlet("/UpdateMyBasketController")
public class UpdateMyBasketController extends HttpServlet {
	private BasketDao basketDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("111111111111111111111");
		// 세션확인
		HttpSession session = request.getSession();		
		if((String)session.getAttribute("sessionCustomerId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		String customerId = (String)session.getAttribute("sessionCustomerId");
		// 장바구니 설정
		int basketCount = 0;
		if(request.getParameter("basketNo") != null && request.getParameter("quantity") != null) {
			int basketNo = Integer.parseInt(request.getParameter("basketNo"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			
			// dao
			basketDao = new BasketDao();
			
			basketDao.updateMyBasket(quantity, basketNo);
			// 장바구니 리스트 뿌려주기
			ArrayList<Basket> list = basketDao.selectMyBasket(customerId);
			request.setAttribute("basketList", list);
			// 고객의 장바구니 개수 등록
			basketCount = list.size();
			session.setAttribute("basketCount", basketCount);
			session.setAttribute("basketCount", basketCount);
			request.getRequestDispatcher("/WEB-INF/view/customer/myBasket.jsp").forward(request, response);
			return;
		}
	}
}
