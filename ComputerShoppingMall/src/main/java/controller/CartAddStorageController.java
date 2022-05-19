package controller;

import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StorageDao;
import vo.Storage;

@WebServlet("/CartAddStorageController")
public class CartAddStorageController extends HttpServlet {
	private StorageDao storageDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 새션 확인
		HttpSession session = request.getSession();
		if ((String)session.getAttribute("sessionCustomerId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		
		// request 값 받기
		int storageNo = Integer.parseInt(request.getParameter("storageNo"));
		
		// vo
		Storage storage = new Storage();
		
		// dao
		storageDao = new StorageDao();
		storage = storageDao.selectStorageOne(storageNo);
		
		
		
		// 값 보내주기
		request.setAttribute("storageOne", storage);
		request.getRequestDispatcher("WEB-INF/view/customer/storageOne.jsp").forward(request, response);
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
		Storage storageOne = new Storage();
		
		// storage정보 뽑기
		storageOne = storageDao.selectStorageOne(storageNo);
		
		// 뽑은 정보 담기
		storage.setStorageName(storageOne.getStorageName());
		storage.setCategoryName(storageOne.getCategoryName());
		storage.setStorageNo(storageOne.getStorageNo());
		storage.setPrice(storageOne.getPrice());
		storage.setQuantity(quantity);
		
		// dao
		storageDao = new StorageDao();
		int row = storageDao.insertCartStorage(customerId, storage);
		
		// 상품 데이터 등록 성공 체크 코드
		if (row == 1) { 
	    	System.out.println("등록 성공! CartAddStorageController.dopost");
	    	response.sendRedirect(request.getContextPath() + "/StorageListController");
	    	return;
	    } else {
	    	System.out.println("등록 실패! CartAddStorageController.dopost");
	    	response.sendRedirect(request.getContextPath() + "/StorageListController?error=error!");
	    }
	} 
}