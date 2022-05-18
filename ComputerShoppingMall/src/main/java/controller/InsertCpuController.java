package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CaseDao;
import dao.CpuDao;
import vo.Case;
import vo.Cpu;

@WebServlet("/InsertCpuController")
public class InsertCpuController extends HttpServlet {
	private CpuDao cpuDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		
		request.getRequestDispatcher("/WEB-INF/view/insertCpuForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		
		// 변수등록
		String cpuName = null;
		String companyName = null;
		String categoryName = null;
		String socketSize = null;
		String core = null;
		String thread = null;
		int price = 0;
		int quantity = 0;
		String memo = null;
		
		// request값 받아오기
		if(request.getParameter("cpuName") != null && request.getParameter("cpuName") !="") {
			cpuName = request.getParameter("cpuName");
		}
		if(request.getParameter("companyName") != null && request.getParameter("companyName") !="") {
			companyName = request.getParameter("companyName");
		}
		if(request.getParameter("categoryName") != null && request.getParameter("categoryName") !="") {
			companyName = request.getParameter("categoryName");
		}
		if(request.getParameter("socketSize") != null && request.getParameter("socketSize") !="") {
			socketSize = request.getParameter("socketSize");
		}
		if(request.getParameter("core") != null  && request.getParameter("core") !="") {
			core = request.getParameter("core");
		}
		if(request.getParameter("thread") != null && request.getParameter("thread") !="") {
			thread = request.getParameter("thread");
		}
		if(request.getParameter("price") != null && request.getParameter("price") !="") {
			price = Integer.parseInt(request.getParameter("price"));
		}
		if(request.getParameter("quantity") != null && request.getParameter("quantity") !="") {
			quantity = Integer.parseInt(request.getParameter("quantity"));
		}
		if(request.getParameter("memo") != null && request.getParameter("memo") !="") {
			memo = request.getParameter("memo");
		}
		
		// vo
		Cpu c = new Cpu();
		c.setCpuName(cpuName);
		c.setCompnayName(companyName);
		c.setCompnayName(categoryName);
		c.setSocketSize(socketSize);
		c.setCore(core);
		c.setThread(thread);
		c.setPrice(price);
		c.setQuantity(quantity);
		c.setMemo(memo);
		
		// 디버깅
		System.out.println("[insertCoolerController] : " + c.toString());
		
		// dao insert
		cpuDao = new CpuDao();
		cpuDao.insertCpu(c);
		
		// 홈페이지 이동
		response.sendRedirect(request.getContextPath() + "/DigitalDownloadController");
	}

}
