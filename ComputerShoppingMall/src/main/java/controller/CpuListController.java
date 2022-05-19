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
		List<String> companyList = cpuDao.companyKind();
		// socketSize
		List<String> socketSizeList = cpuDao.socketSizeKind();
		// core
		List<String> coreList = cpuDao.coreKind();
		// thread
		List<String> threadList = cpuDao.threadKind();
		
		// 체크 박스 여부 확인
		boolean check = false;
		// 검색 결과 리스트
		ArrayList<Cpu> cpuSearchResult = (ArrayList<Cpu>)request.getAttribute("cpuSearchResult");
		if(cpuSearchResult != null) {
			check = true; // getAttribute로 받아온 값이 null이 아니라면 true로 변경
			request.setAttribute("cpuSearchResult", cpuSearchResult); // 검색 결과 값 보내주기
		}
		
		// 체크박스 검색 값 확인하기
		request.setAttribute("check", check);
		// 값 셋팅 후 보내주기
		request.setAttribute("cpuList", list);
		request.setAttribute("companyList", companyList);
		request.setAttribute("socketSizeList", socketSizeList);
		request.setAttribute("coreList", coreList);
		request.setAttribute("threadList", threadList);
		
		request.getRequestDispatcher("/WEB-INF/view/cpuList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// String[]로 다중선택값 저장
		String[] companyName = request.getParameterValues("companyName");
		String[] socketSize = request.getParameterValues("socketSize");
		String[] core = request.getParameterValues("core");
		String[] thread = request.getParameterValues("thread");
				
		// 검색 조건 적용
		cpuDao = new CpuDao();
		ArrayList<Cpu> cpuSearchResult = cpuDao.cpuDetailSearch(companyName, socketSize, core, thread);
		
		request.setAttribute("cpuSearchResult", cpuSearchResult);
		request.getRequestDispatcher("/WEB-INF/view/cpuList.jsp").forward(request, response);
	}
}
