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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request 값 받기
		int caseNo = Integer.parseInt(request.getParameter("caseNo"));
		
		// vo
		Case case2 = new Case();
		
		// dao
		caseDao = new CaseDao();
		case2 = caseDao.selectCaseOne(caseNo);
		
		// 값 보내주기
		request.setAttribute("caseOne", case2);
		request.getRequestDispatcher("WEB-INF/view/nonCustomer/caseOne.jsp").forward(request, response);
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
		int caseNo =Integer.parseInt(request.getParameter("caseNo"));
		System.out.println(caseNo+"<-caseNo");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		System.out.println(quantity+"<-quantity");
		
		// vo
		Case c = new Case(); // 장바구니 insert용
		Case caseOne = new Case(); // caseOne selecrt용
		
		// caseOne정보 뽑기
		caseOne = caseDao.selectCaseOne(caseNo);
		
		// 뽑은 정보 담기
		c.setCaseName(caseOne.getCaseName());
		c.setCategoryName(caseOne.getCategoryName());
		c.setCaseNo(caseOne.getCaseNo());
		c.setPrice(caseOne.getPrice());
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
