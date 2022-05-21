package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RamDao;
import vo.Ram;

@WebServlet("/RamListController")
public class RamListController extends HttpServlet {

	private RamDao ramDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ramDao = new RamDao();
		// ram 제목, 가격 
		ArrayList<Ram> rmaList = ramDao.selectRamList();
		// COMPANY
		ArrayList<String> companyList = ramDao.companyKind();
		// KIND
		ArrayList<String> kindList = ramDao.kindKind();
		
		int count = rmaList.size(); // 상품 개수(0개일시, 조건해당 상품 없다는 메세지 띄우기 용도 + 개수 표시)
		
		request.setAttribute("ramList", rmaList);
		request.setAttribute("companyList", companyList);
		request.setAttribute("kindList", kindList);
		request.setAttribute("count", count);
	
		request.getRequestDispatcher("/WEB-INF/view/nonCustomer/ramList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// String[]로 다중선택값 저장(체크박스)
		String[] companyName = request.getParameterValues("companyName");
		String[] kind = request.getParameterValues("kind");
		
		ramDao = new RamDao();
		// ram 제목, 가격 
		ArrayList<Ram> ramList = ramDao.ramDetailSearch(companyName, kind);
		// 체크박스 
		ArrayList<String> companyList = ramDao.companyKind(); // COMPANY
		ArrayList<String> kindList = ramDao.kindKind(); // KIND
		
		int count = ramList.size(); // 상품 개수(0개일시, 조건해당 상품 없다는 메세지 띄우기 용도 + 개수 표시)
		
		// 값 셋팅 후 보내주기
		request.setAttribute("ramList", ramList);
		request.setAttribute("companyList", companyList);
		request.setAttribute("kindList", kindList);
		request.setAttribute("count", count);
		// 체크여부 확인
		request.setAttribute("companyName", companyName);
		request.setAttribute("kind", kind);
		
		request.getRequestDispatcher("/WEB-INF/view/nonCustomer/ramList.jsp").forward(request, response);
	}
}
