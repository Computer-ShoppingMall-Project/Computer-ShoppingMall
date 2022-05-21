package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CpuDao;
import vo.Cpu;
@WebServlet("/AdminCpuListController")

public class AdminCpuListController extends HttpServlet {
	private CpuDao cpuDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
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
		
		int count = list.size(); // 상품 개수(0개일시, 조건해당 상품 없다는 메세지 띄우기 용도 + 개수 표시)
		
		// 값 셋팅 후 보내주기
		request.setAttribute("cpuList", list);
		request.setAttribute("companyList", companyList);
		request.setAttribute("socketSizeList", socketSizeList);
		request.setAttribute("coreList", coreList);
		request.setAttribute("threadList", threadList);
		request.setAttribute("count", count);
		request.getRequestDispatcher("/WEB-INF/view/admin/adminCpuList.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
