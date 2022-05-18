package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MainboardDao;
import vo.Mainboard;

@WebServlet("/MainboardListController")
public class MainboardListController extends HttpServlet {
	
	private MainboardDao mainboardDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		request.getRequestDispatcher("/WEB-INF/view/mainboardList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
