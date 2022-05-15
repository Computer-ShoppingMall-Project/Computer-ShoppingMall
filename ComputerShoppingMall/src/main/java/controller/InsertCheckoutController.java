package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CheckoutDao;
import vo.Checkout;

@WebServlet("/InsertCheckoutController")
public class InsertCheckoutController extends HttpServlet {
	private CheckoutDao dao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		String customerId = (String) session.getAttribute("sessionCustomerId");
		if ((String) session.getAttribute("sessionCustomerId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}

		request.setAttribute("customerId", customerId);
		request.getRequestDispatcher("/WEB-INF/view/order.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 입력값 받아오기
		int basketNo  = Integer.parseInt(request.getParameter("basketNo"));
		String customerId = request.getParameter("customerId");
		String categoryName = request.getParameter("categoryName");
		int categoryNumber  = Integer.parseInt(request.getParameter("categoryNumber"));
		int categoryPrice  = Integer.parseInt(request.getParameter("categoryPrice"));
		int categoryQuantity =  Integer.parseInt(request.getParameter("categoryQuantity"));
		String createDate = request.getParameter("createDaate");
		
		// 디버깅
		System.out.println(basketNo + " <-- basketNo");
		System.out.println(customerId + " <-- customerId");
		System.out.println(categoryName + " <-- categoryName");
		System.out.println(categoryNumber + " <-- categoryNumber");
		System.out.println(categoryPrice + " <-- categoryPrice");
		System.out.println(categoryQuantity + " <-- categoryQuantity");
		System.out.println(createDate  + " <-- createDate ");
		
		// vo	
		Checkout checkout = new Checkout();
		checkout.setBasketNo(basketNo);
		checkout.setCustomerId(customerId);
		checkout.setCategoryName(categoryName);
		checkout.setCategoryNumber(categoryNumber);
		checkout.setCategoryPrice(categoryPrice);
		checkout.setCategoryQuantity(categoryQuantity);
		checkout.setCreateDate(createDate);
		
		// dao
		dao = new CheckoutDao();
		int row = dao.insertCheckout(checkout);
		
	    // 1) 데이터 입력 가입 성공
	    if (row == 1) { 
	    	System.out.println("결제 정보 저장 성공 InsertCheckoutController.dopost");
	    	response.sendRedirect(request.getContextPath() + "/CheckoutListController");
	    	return;
	    }
	    
	    // 2) 실패시(row값이 0이면...), 실패 
	    else if(row == 0) {
	    	System.out.println("결제 정보 저장 실패 InsertCheckoutController.dopost");
	    	response.sendRedirect(request.getContextPath() + "/InsertCheckoutController?msg=insert fail");
	    }
	    
	    // 3) row값이 -1이면(default 값) SQL오류
	    else if (row == -1) {
	    	System.out.println("예외 발생 InsertCheckoutController.dopost");
	    	response.sendRedirect(request.getContextPath() + "/InsertCheckoutController?msg=exception");
	    }
	}

	
}
