package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CaseDao;
import vo.Case;

@WebServlet("/CaseListController")
public class CaseListController extends HttpServlet {

	private CaseDao caseDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		caseDao = new CaseDao();
		// case 이름, 가격 정보
		ArrayList<Case> caseList = caseDao.selectCaseList();
		// case size
		ArrayList<String> caseSizeList = caseDao.caseSizeList();
		// gpu size
		ArrayList<String> gpuSizeList = caseDao.gpuSizeList();
		// bay64mm
		ArrayList<String> bay64mmList = caseDao.bay64mmList();
		// bay89mm
		ArrayList<String> bay89mmList = caseDao.bay89mmList();
		
		int count = caseList.size(); // 상품 개수(0개일시, 조건해당 상품 없다는 메세지 띄우기 용도 + 개수 표시)
		
		request.setAttribute("caseList", caseList);
		request.setAttribute("caseSizeList", caseSizeList);
		request.setAttribute("gpuSizeList", gpuSizeList);
		request.setAttribute("bay64mmList", bay64mmList);
		request.setAttribute("bay89mmList", bay89mmList);
		request.setAttribute("count", count);
		
		request.getRequestDispatcher("/WEB-INF/view/nonCustomer/caseList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 체크박스 값 받기
		String[] caseSize = request.getParameterValues("caseSize");
		String[] gpuSize = request.getParameterValues("gpuSize");
		String[] bay64mm = request.getParameterValues("bay64mm");
		String[] bay89mm = request.getParameterValues("bay89mm");
		
		String search = request.getParameter("search"); // 검색어 받아오기
		
		caseDao = new CaseDao();
		// case 이름, 가격 정보
		ArrayList<Case> caseList = caseDao.caseDetailSearch(caseSize, gpuSize, bay64mm, bay89mm, search);
		// case size
		ArrayList<String> caseSizeList = caseDao.caseSizeList();
		// gpu size
		ArrayList<String> gpuSizeList = caseDao.gpuSizeList();
		// bay64mm
		ArrayList<String> bay64mmList = caseDao.bay64mmList();
		// bay89mm
		ArrayList<String> bay89mmList = caseDao.bay89mmList();
		
		int count = caseList.size(); // 상품 개수(0개일시, 조건해당 상품 없다는 메세지 띄우기 용도 + 개수 표시)
		
		// 체크여부 확인
		request.setAttribute("caseSize", caseSize);
		request.setAttribute("gpuSize", gpuSize);
		request.setAttribute("bay64mm", bay64mm);
		request.setAttribute("bay89mm", bay89mm);
		
		request.setAttribute("caseList", caseList);
		request.setAttribute("caseSizeList", caseSizeList);
		request.setAttribute("gpuSizeList", gpuSizeList);
		request.setAttribute("bay64mmList", bay64mmList);
		request.setAttribute("bay89mmList", bay89mmList);
		request.setAttribute("count", count);
		// 검색어 유지
		request.setAttribute("search", search);
		
		request.getRequestDispatcher("/WEB-INF/view/nonCustomer/caseList.jsp").forward(request, response);
	}
}
