package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CpuDao;
import dao.MainboardDao;
import vo.Cpu;
import vo.Mainboard;

@WebServlet("/MainboardListController")
public class MainboardListController extends HttpServlet {
	
	private MainboardDao mainboardDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		mainboardDao = new MainboardDao();
		
		// 리스트 받아오기 -> 상품명, 가격 mainboardName, price
		ArrayList<Mainboard> mainboardList = mainboardDao.selectMainboardList();
		// COMPANY
		ArrayList<String> companyList = mainboardDao.companyKind();
		// CPU Socket
		ArrayList<String> socketSizeList = mainboardDao.socketSizeKind();
		// CHIPSET
		ArrayList<String> chipsetList = mainboardDao.chipsetKind();
		// RAM VERSION
		ArrayList<String> ramVersionList = mainboardDao.ramVersionKind();
		// KIND
		ArrayList<String> kindList = mainboardDao.kindKind();
		
		int count = mainboardList.size(); // 상품 개수(0개일시, 조건해당 상품 없다는 메세지 띄우기 용도 + 개수 표시)
		
		request.setAttribute("mainboardList", mainboardList);
		request.setAttribute("companyList", companyList);
		request.setAttribute("socketSizeList", socketSizeList);
		request.setAttribute("chipsetList", chipsetList);
		request.setAttribute("ramVersionList", ramVersionList);
		request.setAttribute("kindList", kindList);
		request.setAttribute("count", count);
		
		request.getRequestDispatcher("/WEB-INF/view/nonCustomer/mainboardList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// String[]로 다중선택값 저장(체크박스)
		String[] companyName = request.getParameterValues("companyName");
		String[] socketSize = request.getParameterValues("socketSize");
		String[] chipset = request.getParameterValues("chipset");
		String[] ramVersion = request.getParameterValues("ramVersion");
		String[] kind = request.getParameterValues("kind");
		
		// CPU 체크박스 값(중복제거 데이터)
		mainboardDao = new MainboardDao();
		// 검색결과 리스트 받아오기 -> 상품명, 가격 mainboardName, price
		ArrayList<Mainboard> mainboardList = mainboardDao.mainboardDetailSearch(companyName, socketSize, chipset, ramVersion, kind);
		
		// COMPANY
		ArrayList<String> companyList = mainboardDao.companyKind();
		// CPU Socket
		ArrayList<String> socketSizeList = mainboardDao.socketSizeKind();
		// CHIPSET
		ArrayList<String> chipsetList = mainboardDao.chipsetKind();
		// RAM VERSION
		ArrayList<String> ramVersionList = mainboardDao.ramVersionKind();
		// KIND
		ArrayList<String> kindList = mainboardDao.kindKind();
		
		
		int count = mainboardList.size(); // 상품 개수(0개일시, 조건해당 상품 없다는 메세지 띄우기 용도 + 개수 표시)
		
		// 값 셋팅 후 보내주기
		request.setAttribute("mainboardList", mainboardList);
		request.setAttribute("companyList", companyList);
		request.setAttribute("socketSizeList", socketSizeList);
		request.setAttribute("chipsetList", chipsetList);
		request.setAttribute("ramVersionList", ramVersionList);
		request.setAttribute("kindList", kindList);
		request.setAttribute("count", count);
		// 체크여부 확인
		request.setAttribute("companyName", companyName);
		request.setAttribute("socketSize", socketSize);
		request.setAttribute("chipset", chipset);
		request.setAttribute("ramVersion", ramVersion);
		request.setAttribute("kind", kind);
		
		request.getRequestDispatcher("/WEB-INF/view/nonCustomer/mainboardList.jsp").forward(request, response);
	}
}
