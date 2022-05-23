package controller;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Cooler;
import dao.CoolerDao;

@WebServlet("/CartAddCoolerController")
public class CartAddCoolerController extends HttpServlet {
	private CoolerDao coolerDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request 값 받기
		int coolerNo = Integer.parseInt(request.getParameter("coolerNo"));
		
		// vo
		Cooler cooler = new Cooler();
		
		// dao
		coolerDao = new CoolerDao();
		cooler = coolerDao.selectCoolerOne(coolerNo);
		
		// 값 보내주기
		request.setAttribute("coolerOne", cooler);
		request.getRequestDispatcher("WEB-INF/view/nonCustomer/coolerOne.jsp").forward(request, response);
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
		
		// request 값 받아오기 cooler -> basket
		int coolerNo =Integer.parseInt(request.getParameter("coolerNo"));
		System.out.println(coolerNo+"<-coolerNo");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		System.out.println(quantity+"<-quantity");
		
		// vo
		Cooler cooler = new Cooler(); // 장바구니 isert
		
		// cooler 정보 넣기
		cooler = coolerDao.selectCoolerOne(coolerNo);
		cooler.setQuantity(quantity);
		System.out.println(cooler.toString());
		
		// dao
		coolerDao = new CoolerDao();
		int row = coolerDao.insertCartCooler(customerId, cooler);
		
		// 상품 데이터 등록 성공 체크 코드
		if (row == 1) { 
	    	System.out.println("등록 성공! CartAddCoolerController.dopost");
	    	response.sendRedirect(request.getContextPath() + "/CoolerListController");
	    	return;
	    } else {
	    	System.out.println("등록 실패! CartAddCoolerController.dopost");
	    	response.sendRedirect(request.getContextPath() + "/CoolerListController?error=error!");
	    }
	}
}
