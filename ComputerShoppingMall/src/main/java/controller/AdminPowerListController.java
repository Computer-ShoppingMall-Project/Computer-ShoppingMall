package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PowerDao;
import vo.Power;

@WebServlet("/AdminPowerListController")
public class AdminPowerListController extends HttpServlet {
	private PowerDao powerDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		powerDao = new PowerDao();
		// power 이름, 가격 가져오기
		ArrayList<Power> powerList = powerDao.selectPowerList();
		// rated_power
		ArrayList<String> ratedPowerList = powerDao.ratedPowerList();
		
		request.setAttribute("powerList", powerList);
		request.setAttribute("ratedPowerList", ratedPowerList);
		request.getRequestDispatcher("/WEB-INF/view/admin/adminPowerList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
