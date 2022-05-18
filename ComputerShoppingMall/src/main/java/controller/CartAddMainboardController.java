package controller;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MainboardDao;
import vo.Mainboard;

@WebServlet("/CartAddMainboardController")
public class CartAddMainboardController extends HttpServlet {
	private MainboardDao mainboardDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

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
		int productNumber = 0;
		int price = 0;
		int quantity = 0;
		  
		productName = request.getParameter("mainboardName");
		categoryName = request.getParameter("categoryName");
		productNumber = Integer.parseInt(request.getParameter("mainboardNo"));
		price = Integer.parseInt(request.getParameter("price"));
		quantity = Integer.parseInt(request.getParameter("quantity"));
		  
		  
		// vo
		Mainboard mainboard = new Mainboard();
		mainboard.setCategoryName(categoryName);
		mainboard.setMainboardName(productName);
		mainboard.setMainboardNo(productNumber);
		mainboard.setPrice(price);
		mainboard.setQuantity(quantity);
		  
		// dao
		mainboardDao = new MainboardDao();
		int row = mainboardDao.insertCartMainboard(customerId, mainboard);
		
		// 상품 데이터 등록 성공 체크 코드
		if (row == 1) { 
	    	System.out.println("등록 성공! CartAddMainboardController.dopost");
	    	response.sendRedirect(request.getContextPath() + "/MainboardListController");
	    	return;
	    } else {
	    	System.out.println("등록 실패! CartAddMainboardController.dopost");
	    	response.sendRedirect(request.getContextPath() + "/MainboardListController?error=error!");
	    }
		
	}

}
