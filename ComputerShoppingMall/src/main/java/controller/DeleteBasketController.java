package controller;

import java.io.IOException; 

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BasketDao;
import vo.Basket;

@WebServlet("/DeleteBasketController")
public class DeleteBasketController extends HttpServlet {
	private BasketDao basketDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		String customerId = (String)session.getAttribute("sessionCustomerId");
		if((String)session.getAttribute("sessionCustomerId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		
		// 값 받아오기
		int basketNo = Integer.parseInt(request.getParameter("basketNo"));
		
		// vo
		Basket basket = new Basket();
		
		// dao
		basketDao = new BasketDao();
		int row = basketDao.deleteMyBasktet(basketNo);
		
		
		if(row == 1) { // 삭제 성공시, myBasket으로
			System.out.println("[DeleteBasketController.doPost] : basket 삭제 성공");
			response.sendRedirect(request.getContextPath() + "/MyBasketController");
			return;
		} else {  // 삭제 성공시, myBasket으로
			System.out.println("[DeleteBasketController.doPost] :  basket 삭제 실패");
			response.sendRedirect(request.getContextPath() + "/MyBasketController");
			return;
		}
		
	}
	

}
