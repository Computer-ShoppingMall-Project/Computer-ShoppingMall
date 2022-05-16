package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MainboardDao;
import dao.PowerDao;
import vo.Mainboard;
import vo.Power;

@WebServlet("/InsertPowerController")
public class InsertPowerController extends HttpServlet {
	private PowerDao powerDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		
		request.getRequestDispatcher("/WEB-INF/view/insertPowerForm.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		
		// 변수등록
		String powerName = null;
		String ratedPower = null;
		int price = 0;
		int quantity = 0;
		String memo = null;
		
		// request값 받아오기
		if(request.getParameter("powerName") != null && request.getParameter("powerName") !="") {
			powerName = request.getParameter("powerName");
		}
		if(request.getParameter("ratedPower") != null && request.getParameter("ratedPower") !="") {
			ratedPower = request.getParameter("ratedPower");
		}
		if(request.getParameter("price") != null && request.getParameter("price") !="") {
			price = Integer.parseInt(request.getParameter("price"));
		}
		if(request.getParameter("quantity") != null && request.getParameter("quantity") !="") {
			quantity = Integer.parseInt(request.getParameter("quantity"));
		}
		if(request.getParameter("memo") != null && request.getParameter("memo") !="") {
			memo = request.getParameter("memo");
		}
		
		// 디버깅
		System.out.println(powerName+"<--powerName");
		System.out.println(ratedPower+"<--ratedPower");
		System.out.println(price+"<--price");
		System.out.println(quantity+"<--quantity");
		System.out.println(memo+"<--memo");
		
		// vo
		Power p = new Power();
		p.setPowerName(powerName);
		p.setRatedPower(ratedPower);
		p.setPrice(price);
		p.setQuantity(quantity);
		p.setMemo(memo);
		
		
		// dao
		powerDao = new PowerDao();
		powerDao.insertPower(p);
		
		response.sendRedirect(request.getContextPath() + "/DigitalDownloadController");
	}

}
