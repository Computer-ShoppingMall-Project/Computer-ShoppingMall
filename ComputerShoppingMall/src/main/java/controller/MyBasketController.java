package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BasketDao;
import dao.CaseDao;
import vo.Basket;

@WebServlet("/MyBasketController")
public class MyBasketController extends HttpServlet {
	private BasketDao basketDao;
	private CaseDao caseDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		// 새션 확인
		if((String)session.getAttribute("sessionAdminId") != null) {
			// 관리자 아이디로그인시 페이지로 이동
			request.getRequestDispatcher("/WEB-INF/view/customer/myBasket.jsp").forward(request, response);
			return;
		}
		String customerId = (String)session.getAttribute("sessionCustomerId");
		if((String)session.getAttribute("sessionCustomerId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		
		int basketCount = 0;
		
		// dao
		if(request.getParameter("productNumber") != null && !"".equals(request.getParameter("productNumber"))) {
			// request 값
			int productNumber =  Integer.parseInt(request.getParameter("productNumber"));
			String productName = request.getParameter("productName");
			String categoryName = request.getParameter("categoryName");
			int price = Integer.parseInt(request.getParameter("price"));
			int quantity = 1;
			
			// vo
			Basket basket = new Basket();
			basket.setProductNumber(productNumber);
			basket.setProductName(productName);
			basket.setCategoryName(categoryName);
			basket.setPrice(price);
			basket.setQuantity(quantity);
			
			// dao.selestMyBasket
			basketDao = new BasketDao();
			ArrayList<Basket> checkList = basketDao.selectMyBasket(customerId);
			for (int i=0; i<checkList.size(); i++) {
				if(checkList.size() > 0) {
					int checkProductNumber= checkList.get(i).getProductNumber();
					String checkProductName= checkList.get(i).getProductName();
					String checkCategoryName = checkList.get(i).getCategoryName();
					int basketNo = checkList.get(i).getBasketNo();
					quantity = checkList.get(i).getQuantity();
					
					// 이미 같은 상품이 장바구니에 존재한다면 insert대신 update로 실행
					if((productNumber == checkProductNumber) && (checkProductName.equals(productName)) && (checkCategoryName.equals(categoryName))) {
						quantity += 1;
						basketDao.updateMyBasket(quantity,basketNo);
					} else {
						// dao.insertMyBasket
						basketDao.insertMyBasket(customerId, basket);
					}
						
					// dao.selectMyBasket 구매상품 모아보기
					ArrayList<Basket> list = basketDao.selectMyBasket(customerId);
					
					// 고객의 장바구니 개수 등록
					basketCount = list.size();

					// 업데이트가 되면 바로 myBaske로 안하면 insert가 작동됨
					if("goList".equals(request.getParameter("goList"))) {
						response.sendRedirect(request.getContextPath()+"/CpuListController");
						return;
					}
					
					session.setAttribute("basketCount", basketCount);
					request.setAttribute("basketList", list);
					request.getRequestDispatcher("/WEB-INF/view/customer/myBasket.jsp").forward(request, response);
				}
			}
			request.getRequestDispatcher("/WEB-INF/view/customer/myBasket.jsp").forward(request, response);
		}
	}
}
	