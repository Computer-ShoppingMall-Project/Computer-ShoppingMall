package controller;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PowerDao;
import vo.Power;

@WebServlet("/CartAddPowerController")
public class CartAddPowerController extends HttpServlet {
	private PowerDao powerDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		String customerId = (String) session.getAttribute("sessionCustomerId");
		if ((String) session.getAttribute("sessionCustomerId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		  
		// 변수 등록
		String productName = null;
		String categoryName = null;
		int productNumber = 0;
		int price = 0;
		int quantity = 0;
		  
		// request 값 받아오기
		productName = request.getParameter("powerName");
		categoryName = request.getParameter("categoryName");
		productNumber = Integer.parseInt(request.getParameter("powerNo"));
		price= Integer.parseInt(request.getParameter("price"));
		quantity = Integer.parseInt(request.getParameter("quantity"));
		  
		// vo
		Power power = new Power();
		power.setCategoryName(categoryName);
		power.setPowerName(productName);
		power.setPowerNo(productNumber);
		power.setPrice(price);
		power.setQuantity(quantity);
		  
		// dao
		powerDao = new PowerDao();
		int row = powerDao.insertCartPower(customerId, power);
		
		// 상품 데이터 등록 성공 체크 코드
		if (row == 1) { 
	    	System.out.println("등록 성공! CartAddPowerController.dopost");
	    	response.sendRedirect(request.getContextPath() + "/PowerListController");
	    	return;
	    } else {
	    	System.out.println("등록 실패! CartAddPowerController.dopost");
	    	response.sendRedirect(request.getContextPath() + "/PowerListController?error=error!");
	    }	
	}
}
