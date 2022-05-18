package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PowerDao;
import vo.Power;

@WebServlet("/PowerListController")
public class PowerListController extends HttpServlet {

	private PowerDao powerDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		powerDao = new PowerDao();
		// power 이름, 가격 가져오기
		ArrayList<Power> powerList = powerDao.selectPowerList();
		// rated_power
		ArrayList<String> ratedPowerList = powerDao.ratedPowerList();
		
		request.setAttribute("powerList", powerList);
		request.setAttribute("ratedPowerList", ratedPowerList);
		request.getRequestDispatcher("/WEB-INF/customer/powerList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
