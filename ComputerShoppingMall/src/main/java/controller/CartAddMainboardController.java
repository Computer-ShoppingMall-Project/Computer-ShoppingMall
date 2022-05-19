package controller;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CpuDao;
import dao.MainboardDao;
import vo.Cpu;
import vo.Mainboard;

@WebServlet("/CartAddMainboardController")
public class CartAddMainboardController extends HttpServlet {
	private MainboardDao mainboardDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 새션 확인
		HttpSession session = request.getSession();
		String customerId = (String)session.getAttribute("sessionCustomerId");
		if ((String)session.getAttribute("sessionCustomerId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		
		// request 값 받기
		int mainboardNo = Integer.parseInt(request.getParameter("mainboardNo"));
		
		// vo
		Mainboard mainboard = new Mainboard();
		
		// dao
		mainboardDao = new MainboardDao();
		mainboard = mainboardDao.selectMainboardList(mainboardNo);
		
		
		
		// 값 보내주기
		request.setAttribute("cpuOne", mainboard);
		request.getRequestDispatcher("WEB-INF/view/customer/mainboardOne.jsp").forward(request, response);
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
		
		// 변수 등록
		String productName = null;
		String categoryName = null;
		int productNumber = 0;
		int price = 0;
		int quantity = 0;
		 
		// request 값 받아오기
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
