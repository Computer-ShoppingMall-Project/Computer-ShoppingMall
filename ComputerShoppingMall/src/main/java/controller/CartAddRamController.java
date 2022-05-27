package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RamDao;
import vo.Ram;

@WebServlet("/CartAddRamController")
public class CartAddRamController extends HttpServlet {
	private RamDao ramDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request 값 받기
		int ramNo = Integer.parseInt(request.getParameter("ramNo"));
		
		// vo
		Ram ram = new Ram();
		
		// dao
		ramDao = new RamDao();
		ram = ramDao.selectRamOne(ramNo);
		
		// 값 보내주기
		request.setAttribute("ramOne", ram);
		request.getRequestDispatcher("WEB-INF/view/nonCustomer/ramOne.jsp").forward(request, response);
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
		int ramNo =Integer.parseInt(request.getParameter("ramNo"));
		System.out.println(ramNo+"<-ramNo");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		System.out.println(quantity+"<-quantity");
	      
	     // vo
	     Ram ram = new Ram();
	     
	     // ram정보 봅기
	     ram = ramDao.selectRamOne(ramNo);
	     ram.setQuantity(quantity);
	      
	     // dao
	     ramDao = new RamDao();
	     int row = ramDao.insertCartRam(customerId, ram);
	      
	     // 상품 데이터 등록 성공 체크 코드
		 if (row == 1) {
			 System.out.println("등록 성공! CartAddRamController.dopost");
			 response.sendRedirect(request.getContextPath() + "/MyBasketController");
			 return;
		 } else {
			 System.out.println("등록 실패! CartAddRamController.dopost");
			 response.sendRedirect(request.getContextPath() + "/RamListController?error=error!");
		}
	}
}
