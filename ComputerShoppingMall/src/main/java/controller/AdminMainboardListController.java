package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MainboardDao;
import vo.Mainboard;

@WebServlet("/AdminMainboardListController")
public class AdminMainboardListController extends HttpServlet {
	private MainboardDao mainboardDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		mainboardDao = new MainboardDao();
		
		// 상세보기 받아오기 -> 상품명, 가격 mainboardName, price
		List<Mainboard> mainboadList = mainboardDao.selectMainboardList();
		// COMPANY
		List<String> companyList = mainboardDao.companyKind();
		// CPU Socket
		List<String> socketSizeList = mainboardDao.socketSizeKind();
		// CHIPSET
		List<String> chipsetList = mainboardDao.chipsetKind();
		// RAM VERSION
		List<String> ramVersionList = mainboardDao.ramVersionKind();
		// KIND
		List<String> kindList = mainboardDao.kindKind();
		
		request.setAttribute("mainboadList", mainboadList);
		request.setAttribute("companyList", companyList);
		request.setAttribute("socketSizeList", socketSizeList);
		request.setAttribute("chipsetList", chipsetList);
		request.setAttribute("ramVersionList", ramVersionList);
		request.setAttribute("kindList", kindList);
		request.getRequestDispatcher("/WEB-INF/view/admin/adminMainboardList.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
