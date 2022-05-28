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
import dao.StorageDao;
import vo.Basket;
import vo.Storage;

@WebServlet("/CartAddStorageController")
public class CartAddStorageController extends HttpServlet {
	private StorageDao storageDao;
	private BasketDao basketDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request 값 받기
		int storageNo = Integer.parseInt(request.getParameter("storageNo"));
		
		// vo
		Storage storage = new Storage();
		
		// dao
		storageDao = new StorageDao();
		storage = storageDao.selectStorageOne(storageNo);
		
		// 값 보내주기
		request.setAttribute("storageOne", storage);
		request.getRequestDispatcher("WEB-INF/view/nonCustomer/storageOne.jsp").forward(request, response);
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
		
		// 변수 등록 (basket)
		int storageNo =Integer.parseInt(request.getParameter("storageNo"));
		System.out.println(storageNo+"<-storageNo");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		System.out.println(quantity+"<-quantity");
				
		
		// vo
		Storage storage = new Storage();
		
		// storage정보 뽑기
		storage = storageDao.selectStorageOne(storageNo);
		storage.setQuantity(quantity);
		int basketCount = 0;
		// dao
		basketDao = new BasketDao();
		// dao.selestMyBasket
		ArrayList<Basket> checkList = basketDao.selectMyBasket(customerId);
		if(checkList.size() > 0) {
			for (int i=0; i<checkList.size(); i++) {
				int checkProductNumber= checkList.get(i).getProductNumber();
				int basketNo = checkList.get(i).getBasketNo();
				int checkQuantity = checkList.get(i).getQuantity();
				// 이미 같은 상품이 장바구니에 존재한다면 insert대신 update로 실행
				if(storageNo == checkProductNumber) {
					quantity = quantity+checkQuantity;
					basketDao.updateMyBasket(quantity,basketNo);
					// dao.selectMyBasket
					ArrayList<Basket> list = basketDao.selectMyBasket(customerId);
					request.setAttribute("basketList", list);
					// 고객의 장바구니 개수 등록
					basketCount = list.size();
					System.out.println(basketCount+"basketCount");
					session.setAttribute("basketCount", basketCount);
					// 업데이트가 되면 바로 myBaske로 안하면 insert가 작동됨
					request.getRequestDispatcher("/WEB-INF/view/customer/myBasket.jsp").forward(request, response);
					return;
				} 
			}
		}
		
		// dao
		storageDao = new StorageDao();
		int row = storageDao.insertCartStorage(customerId, storage);
		
		// 상품 데이터 등록 성공 체크 코드
		if (row == 1) { 
	    	System.out.println("등록 성공! CartAddStorageController.dopost");
	    	response.sendRedirect(request.getContextPath() + "/MyBasketController");
	    	return;
	    } else {
	    	System.out.println("등록 실패! CartAddStorageController.dopost");
	    	response.sendRedirect(request.getContextPath() + "/StorageListController?error=error!");
	    }
	} 
}