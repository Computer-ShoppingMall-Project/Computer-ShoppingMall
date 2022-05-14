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
		HttpSession session = request.getSession();
		String sessionCustomerId = (String)session.getAttribute("sessionCustomerId");
		System.out.println(sessionCustomerId+"<-sessionCustomerId");
		if(sessionCustomerId == null) {
			response.sendRedirect(request.getContextPath()+"/LoginController");
			return;
		}
		request.getRequestDispatcher("/WEB-INF/view/insertCpuForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String sessionCustomerId = (String)session.getAttribute("sessionCustomerId");
		// 로그인이 안되어있을시 로그인창으로 이동
		if(sessionCustomerId == null) {
			response.sendRedirect(request.getContextPath()+"/LoginController");
			return;
		}
		// 변수등록
		String cpuName = null;
		String cpuKind = null;
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
		if(request.getParameter("cpuKind") != null && request.getParameter("cpuKind") !="") {
			cpuKind = request.getParameter("cpuKind");
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
		
		// 디버깅
		System.out.println(cpuName+"<--cpuName");
		System.out.println(cpuKind+"<--cpuKind");
		System.out.println(socketSize+"<--socketSize");
		System.out.println(core+"<--core");
		System.out.println(thread+"<--thread");
		System.out.println(price+"<--price");
		System.out.println(quantity+"<--quantity");
		System.out.println(memo+"<--memo");
		
		// vo
		Cpu c = new Cpu();
		c.setCpuName(cpuName);
		c.setCpuKind(cpuKind);
		c.setSocketSize(socketSize);
		c.setCore(core);
		c.setThread(thread);
		c.setPrice(price);
		c.setQuantity(quantity);
		c.setMemo(memo);
		
		// dao insert
		cpuDao = new CpuDao();
		cpuDao.insertCpu(c);
		
		// 홈페이지 이동
		response.sendRedirect(request.getContextPath() + "/DigitalDownloadController");
	}

}
