package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CpuDao;
import vo.Cpu;
import vo.Image;

import java.util.*;

@WebServlet("/CpuListController")
public class CpuListController extends HttpServlet {

	private CpuDao cpuDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// CPU 체크박스 값(중복제거 데이터)
		cpuDao = new CpuDao();
		// 게시글 이름, 가격 받아오기
		ArrayList<Cpu> list = cpuDao.selectCpuList();
		
		// compnay
		ArrayList<String> companyList = cpuDao.companyKind();
		// socketSize
		ArrayList<String> socketSizeList = cpuDao.socketSizeKind();
		// core
		ArrayList<String> coreList = cpuDao.coreKind();
		// thread
		ArrayList<String> threadList = cpuDao.threadKind();
		
		int count = list.size(); // 상품 개수(0개일시, 조건해당 상품 없다는 메세지 띄우기 용도 + 개수 표시)
		
		// 값 셋팅 후 보내주기
		request.setAttribute("cpuList", list);
		request.setAttribute("companyList", companyList);
		request.setAttribute("socketSizeList", socketSizeList);
		request.setAttribute("coreList", coreList);
		request.setAttribute("threadList", threadList);
		request.setAttribute("count", count);
		
		request.getRequestDispatcher("/WEB-INF/view/nonCustomer/cpuList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// String[]로 다중선택값 저장(체크박스)
		String[] companyName = request.getParameterValues("companyName");
		String[] socketSize = request.getParameterValues("socketSize");
		String[] core = request.getParameterValues("core");
		String[] thread = request.getParameterValues("thread");
		
		String search = request.getParameter("search"); // 검색어 받아오기
		
		// CPU 체크박스 값(중복제거 데이터)
		cpuDao = new CpuDao();
		ArrayList<Cpu> list = cpuDao.cpuDetailSearch(companyName, socketSize, core, thread, search);
		
		// compnay
		ArrayList<String> companyList = cpuDao.companyKind();
		// socketSize
		ArrayList<String> socketSizeList = cpuDao.socketSizeKind();
		// core
		ArrayList<String> coreList = cpuDao.coreKind();
		// thread
		ArrayList<String> threadList = cpuDao.threadKind();
		
		int count = list.size(); // 상품 개수(0개일시, 조건해당 상품 없다는 메세지 띄우기 용도 + 개수 표시)
		
		
		// 값 셋팅 후 보내주기
		request.setAttribute("cpuList", list);
		request.setAttribute("companyList", companyList);
		request.setAttribute("socketSizeList", socketSizeList);
		request.setAttribute("coreList", coreList);
		request.setAttribute("threadList", threadList);
		request.setAttribute("count", count);
		// 체크여부 확인
		request.setAttribute("companyName", companyName);
		request.setAttribute("socketSize", socketSize);
		request.setAttribute("core", core);
		request.setAttribute("thread", thread);
		// 검색어 유지
		request.setAttribute("search", search);
		
		request.getRequestDispatcher("/WEB-INF/view/nonCustomer/cpuList.jsp").forward(request, response);
	}
}
