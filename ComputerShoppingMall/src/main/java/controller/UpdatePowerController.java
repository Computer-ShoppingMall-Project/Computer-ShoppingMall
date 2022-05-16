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
		request.getRequestDispatcher("/WEB-INF/view/deletePowerForm.jsp").forward(request, response);
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
		int powerNo = 0;
		int price = 0;
		int quantity = 0;
		
		// request값 받기
		if(request.getParameter("powerNo")!= null && request.getParameter("powerNo") != "") {
			powerNo = Integer.parseInt(request.getParameter("powerNo"));
		}
		if(request.getParameter("price")!= null && request.getParameter("price") != "") {
			price = Integer.parseInt(request.getParameter("price"));
		}
		if(request.getParameter("quantity")!= null && request.getParameter("quantity") != "") {
			quantity = Integer.parseInt(request.getParameter("quantity"));
		}
		
		// vo
		Power p = new Power();
		p.getPowerNo();
		p.getPrice();
		p.getQuantity();
		
		// 디버깅
		System.out.println("[updatePowerController] : " + p.toString());
		
		// dao
		powerDao = new PowerDao();
		powerDao.updatePower(p);
		
		response.sendRedirect(request.getContextPath()+"/DigitalDownloadController");	
	}

}

