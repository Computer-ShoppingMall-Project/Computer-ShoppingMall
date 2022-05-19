package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CaseDao;
import vo.Case;

@WebServlet("/CartAddCaseController")
public class CartAddCaseController extends HttpServlet {
	private CaseDao caseDao;
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
		productName = request.getParameter("caseName");
		categoryName = request.getParameter("categoryName");
		productNumber = Integer.parseInt(request.getParameter("caseNo"));
		price = Integer.parseInt(request.getParameter("price"));
		quantity = Integer.parseInt(request.getParameter("quantity"));
		
		// vo
		Case c = new Case();
		c.setCaseName(productName);
		c.setCategoryName(categoryName);
		c.setCaseNo(productNumber);
		c.setPrice(price);
		c.setQuantity(quantity);
		
		// dao
		caseDao = new CaseDao();
		int row = caseDao.insertCartCase(customerId, c);
		
		// 상품 데이터 등록 성공 체크 코드
		if (row == 1) { 
	    	System.out.println("등록 성공! CartAddCaseController.dopost");
	    	response.sendRedirect(request.getContextPath() + "/CaseListController");
	    	return;
	    } else {
	    	System.out.println("등록 실패! CartAddCaseController.dopost");
	    	response.sendRedirect(request.getContextPath() + "/CaseListController?error=error!");
	    }
	}
}
