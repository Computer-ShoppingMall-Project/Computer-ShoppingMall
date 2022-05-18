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
		HttpSession session = request.getSession();
		String customerId = (String)session.getAttribute("sessionCustomerId");
		if(customerId != null) {
			// 이미 로그인이 되어 있는 상태라면
			response.sendRedirect(request.getContextPath() + "/IndexController");
			return;
		}
		  
		// request 값 받아오기
		String productName = null;
		String categoryName = null;
		int cateogryNumber = 0;
		int categoryPrice = 0;
		int categoryQuantity = 0;
		  
		productName = request.getParameter("puductName");
		categoryName = request.getParameter("categoryName");
		cateogryNumber = Integer.parseInt(request.getParameter("cateogryNumber"));
		categoryPrice= Integer.parseInt(request.getParameter("categoryPrice"));
		categoryQuantity = Integer.parseInt(request.getParameter("categoryQuantity"));
		  
		  
		// vo
		Power power = new Power();
		power.setCategoryName(categoryName);
		power.setPowerName(productName);
		power.setPowerNo(cateogryNumber);
		power.setPrice(categoryPrice);
		power.setQuantity(categoryQuantity);
		  
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
