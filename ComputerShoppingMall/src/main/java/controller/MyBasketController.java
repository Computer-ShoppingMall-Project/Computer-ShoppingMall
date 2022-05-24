package controller;

import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BasketDao;
import dao.CaseDao;

import java.util.*;

import vo.Basket;
import vo.Case;

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
		basketDao = new BasketDao();
		if(request.getParameter("productNumber") != null && !"".equals(request.getParameter("productNumber"))) {
			// request 값
			int productNumber = Integer.parseInt(request.getParameter("productNumber"));
			String productName = request.getParameter("productName");
			String categoryName = request.getParameter("categoryName");
			int price = Integer.parseInt(request.getParameter("price"));
			int quantity = 1;
		
			
			// dao.selestMyBasket
			ArrayList<Basket> checkList = basketDao.selectMyBasket(customerId);
			if(checkList.size() > 0) {
			for (int i=0; i<checkList.size(); i++) {
					int checkProductNumber= checkList.get(i).getProductNumber();
					String checkProductName= checkList.get(i).getProductName();
					String checkCategoryName = checkList.get(i).getCategoryName();
					int basketNo = checkList.get(i).getBasketNo();
					quantity = checkList.get(i).getQuantity();
					// 이미 같은 상품이 장바구니에 존재한다면 insert대신 update로 실행
					if(productNumber == checkProductNumber && checkProductName.equals(productName) && checkCategoryName.equals(categoryName)) {
						quantity = quantity+1;
						basketDao.updateMyBasket(quantity,basketNo);
						// dao.selectMyBasket
						ArrayList<Basket> list = basketDao.selectMyBasket(customerId);
						request.setAttribute("basketList", list);
						// 고객의 장바구니 개수 등록
						basketCount = list.size();
						System.out.println(basketCount+"basketCount");
						session.setAttribute("basketCount", basketCount);
//						// 업데이트가 되면 바로 myBaske로 안하면 insert가 작동됨
//						request.getRequestDispatcher("/WEB-INF/view/customer/myBasket.jsp").forward(request, response);
//						return;
					} 
					
				}
			}
			// 장바구니에 새로운 물품이 들어온다면 insert
			// vo
			Basket basket = new Basket();
			basket.setProductNumber(productNumber);
			basket.setProductName(productName);
			basket.setCategoryName(categoryName);
			basket.setPrice(price);
			basket.setQuantity(quantity);
			// 디버깅
			System.out.println("[basketList] :"+ basket.toString());
			
			// 물품 등록
			basketDao.insertMyBasket(customerId, basket);
			
			// dao.selectMyBasket
			ArrayList<Basket> list = basketDao.selectMyBasket(customerId);
			request.setAttribute("basketList", list);
			// 고객의 장바구니 개수 등록
			basketCount = list.size();
			session.setAttribute("basketCount", basketCount);
			// 장바구니에 상품이 등록되면 장바구니로
			request.getRequestDispatcher("/WEB-INF/view/customer/myBasket.jsp").forward(request, response);
			return;
		}
		// 장바구니 리스트 뿌려주기
		ArrayList<Basket> list = basketDao.selectMyBasket(customerId);
		request.setAttribute("basketList", list);
		// 고객의 장바구니 개수 등록
		basketCount = list.size();
		session.setAttribute("basketCount", basketCount);
		request.getRequestDispatcher("/WEB-INF/view/customer/myBasket.jsp").forward(request, response);
	}
}