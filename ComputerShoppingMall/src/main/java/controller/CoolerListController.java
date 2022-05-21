package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CoolerDao;
import vo.Cooler;

@WebServlet("/CoolerListController")
public class CoolerListController extends HttpServlet {
	
	private CoolerDao coolerDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		coolerDao = new CoolerDao();
		
		// cooler 이름, 가격 정보
		ArrayList<Cooler> coolerList = coolerDao.selectCoolerList();
		// company
		ArrayList<String> companyList = coolerDao.companyKind();
		// kind
		ArrayList<String> kindList = coolerDao.kindKind();
		// size
		ArrayList<String> sizeList = coolerDao.coolerSizeKind();
		
		int count = coolerList.size(); // 상품 개수(0개일시, 조건해당 상품 없다는 메세지 띄우기 용도 + 개수 표시)
		
		request.setAttribute("coolerList", coolerList);
		request.setAttribute("companyList", companyList);
		request.setAttribute("kindList", kindList);
		request.setAttribute("sizeList", sizeList);
		request.setAttribute("count", count);
		
		request.getRequestDispatcher("/WEB-INF/view/nonCustomer/coolerList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// String[]로 다중선택값 저장(체크박스)
		String[] companyName = request.getParameterValues("companyName");
		String[] kind = request.getParameterValues("kind");
		String[] coolerSize = request.getParameterValues("coolerSize");
		
		String search = request.getParameter("search"); // 검색어 받아오기
		
		coolerDao = new CoolerDao();
		
		// 상세검색 리스트
		ArrayList<Cooler> coolerList = coolerDao.coolerDetailSearch(companyName, kind, coolerSize, search);
		
		// cooler 이름, 가격 정보
		ArrayList<String> companyList = coolerDao.companyKind(); // company
		ArrayList<String> kindList = coolerDao.kindKind(); // kind
		ArrayList<String> sizeList = coolerDao.coolerSizeKind(); // size
		
		int count = coolerList.size(); // 상품 개수(0개일시, 조건해당 상품 없다는 메세지 띄우기 용도 + 개수 표시)
		
		request.setAttribute("coolerList", coolerList);
		request.setAttribute("companyList", companyList);
		request.setAttribute("kindList", kindList);
		request.setAttribute("sizeList", sizeList);
		request.setAttribute("count", count);
		
		// 체크여부 확인
		request.setAttribute("companyName", companyName);
		request.setAttribute("kind", kind);
		request.setAttribute("coolerSize", coolerSize);
		// 검색어 유지
		request.setAttribute("search", search);
		
		request.getRequestDispatcher("/WEB-INF/view/nonCustomer/coolerList.jsp").forward(request, response);
	}
}