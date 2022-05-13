package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PowerDao;
import dao.RamDao;
import vo.Power;
import vo.Ram;
@WebServlet("/UpdatePowerController")
public class UpdatePowerController extends HttpServlet {
    private PowerDao powerDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sessionCustomerId = (String)session.getAttribute("sessionCustomerId");
		System.out.println(sessionCustomerId+"<-sessionCustomerId");
		if(sessionCustomerId == null) {
			response.sendRedirect(request.getContextPath()+"/LoginController");
			return;
		}
		request.getRequestDispatcher("/WEB-INF/view/deletePowerForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 변수등록
		int powerNo = 0;
		int price = 0;
		int quantity = 0;
		
		// request값 받기
		if(request.getParameter("powerNo")!= null || request.getParameter("powerNo") != "") {
			powerNo = Integer.parseInt(request.getParameter("powerNo"));
		}
		if(request.getParameter("price")!= null || request.getParameter("price") != "") {
			price = Integer.parseInt(request.getParameter("price"));
		}
		if(request.getParameter("quantity")!= null || request.getParameter("quantity") != "") {
			quantity = Integer.parseInt(request.getParameter("quantity"));
		}
		
		// 디버깅
		System.out.println(powerNo+"<-powerNo");
		System.out.println(price+"<-price");
		System.out.println(quantity+"<-quantity");
		
		// vo
		Power p = new Power();
		p.getPowerNo();
		p.getPrice();
		p.getQuantity();
		
		// dao
		powerDao = new PowerDao();
		powerDao.updatePower(p);
		
		response.sendRedirect(request.getContextPath()+"/DigitalDownloadController");	
	}

}
