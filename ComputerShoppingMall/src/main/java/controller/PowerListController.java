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
		
		int count = powerList.size(); // 상품 개수(0개일시, 조건해당 상품 없다는 메세지 띄우기 용도 + 개수 표시)
		
		request.setAttribute("powerList", powerList);
		request.setAttribute("ratedPowerList", ratedPowerList);
		request.setAttribute("count", count);
		
		request.getRequestDispatcher("/WEB-INF/view/nonCustomer/powerList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] ratedPower = request.getParameterValues("ratedPower");
		
		String search = request.getParameter("search"); // 검색어 받아오기
		
		powerDao = new PowerDao();
		// power 상세검색 리스트
		ArrayList<Power> powerList = powerDao.powerDetailSearch(ratedPower, search);
		// rated_power
		ArrayList<String> ratedPowerList = powerDao.ratedPowerList();
		
		int count = powerList.size(); // 상품 개수(0개일시, 조건해당 상품 없다는 메세지 띄우기 용도 + 개수 표시)
		
		request.setAttribute("powerList", powerList);
		request.setAttribute("ratedPowerList", ratedPowerList);
		request.setAttribute("count", count);
		
		// 체크여부 확인
		request.setAttribute("ratedPower", ratedPower);
		// 검색어 유지
		request.setAttribute("search", search);
		
		request.getRequestDispatcher("/WEB-INF/view/nonCustomer/powerList.jsp").forward(request, response);
	}
}
