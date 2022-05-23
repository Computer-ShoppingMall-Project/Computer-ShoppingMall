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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request 값 받기
		int powerNo = Integer.parseInt(request.getParameter("powerNo"));
		
		// vo
		Power power = new Power();
		
		// dao
		powerDao = new PowerDao();
		power = powerDao.selectPowerOne(powerNo);
		
		// 값 보내주기
		request.setAttribute("powerOne", power);
		request.getRequestDispatcher("WEB-INF/view/nonCustomer/powerOne.jsp").forward(request, response);
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
		int powerNo = Integer.parseInt(request.getParameter("powerNo"));
		System.out.println(powerNo+"<-powerNo");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		System.out.println(quantity+"<-quantity");
		  
		// vo
		Power power = new Power();
		// mainboard정보 뽑기
		power = powerDao.selectPowerOne(powerNo);
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
