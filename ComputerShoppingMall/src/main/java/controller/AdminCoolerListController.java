package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CoolerDao;
import vo.Cooler;

@WebServlet("/AdminCoolerListController")
public class AdminCoolerListController extends HttpServlet {
	private CoolerDao coolerDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		coolerDao = new CoolerDao();
		
		// cooler 이름, 가격 정보
		ArrayList<Cooler> coolerList = coolerDao.selectCoolerList();
		// company
		ArrayList<String> companyList = coolerDao.companyKind();
		// kind
		ArrayList<String> kindList = coolerDao.kindKind();
		// size
		ArrayList<String> sizeList = coolerDao.coolerSizeKind();
		
		request.setAttribute("coolerList", coolerList);
		request.setAttribute("companyList", companyList);
		request.setAttribute("kindList", kindList);
		request.setAttribute("sizeList", sizeList);
		request.getRequestDispatcher("/WEB-INF/view/admin/adminCoolerList.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
