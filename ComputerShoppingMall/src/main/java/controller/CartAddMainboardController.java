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
		// request 값 받기
		int mainboardNo = Integer.parseInt(request.getParameter("mainboardNo"));
		
		// vo
		Mainboard mainboard = new Mainboard();
		
		// dao
		mainboardDao = new MainboardDao();
		mainboard = mainboardDao.selectMainboardOne(mainboardNo);
		
		// 값 보내주기
		request.setAttribute("mainboardOne", mainboard);
		request.getRequestDispatcher("WEB-INF/view/nonCustomer/mainboardOne.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		String customerId = (String) session.getAttribute("sessionCustomerId");
		if ((String) session.getAttribute("sessionCustomerId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		
		// request 값 받아오기
		int mainboardNo =Integer.parseInt(request.getParameter("mainboardNo"));
		System.out.println(mainboardNo+"<-mainboardNo");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		System.out.println(quantity+"<-quantity");
		  
		// vo
		Mainboard mainboard = new Mainboard();
		
		// mainboard정보 뽑기
		mainboard = mainboardDao.selectMainboardOne(mainboardNo);
		mainboard.setQuantity(quantity);
		  
		// dao
		mainboardDao = new MainboardDao();
		int row = mainboardDao.insertCartMainboard(customerId, mainboard);
		
		// 상품 데이터 등록 성공 체크 코드
		if (row == 1) { 
	    	System.out.println("등록 성공! CartAddMainboardController.dopost");
	    	response.sendRedirect(request.getContextPath() + "/MyBasketController");
	    	return;
	    } else {
	    	System.out.println("등록 실패! CartAddMainboardController.dopost");
	    	response.sendRedirect(request.getContextPath() + "/MainboardListController?error=error!");
	    }
	}
}
