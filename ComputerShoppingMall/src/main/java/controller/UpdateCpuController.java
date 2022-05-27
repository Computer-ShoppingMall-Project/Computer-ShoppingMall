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

@WebServlet("/UpdateCpuController")
public class UpdateCpuController extends HttpServlet {
	private CpuDao cpuDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if ((String) session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		// dao
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

		// 값 셋팅 후 보내주기
		request.setAttribute("cpuList", list);
		request.setAttribute("companyList", companyList);
		request.setAttribute("socketSizeList", socketSizeList);
		request.setAttribute("coreList", coreList);
		request.setAttribute("threadList", threadList);
		// vo
		Cpu c = new Cpu();
		if (request.getParameter("cpuNo") != null) {
			int cpuNo = Integer.parseInt(request.getParameter("cpuNo"));
			c = cpuDao.selectCpuOne(cpuNo); 

			request.setAttribute("cpu", c);
			request.getRequestDispatcher("/WEB-INF/view/admin/updateCpuForm.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if ((String) session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
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
		// update form null 확인코드
		/*
		if (request.getParameter("cpuName") == null || request.getParameter("companyName") == null
				|| request.getParameter("categoryName") == null || request.getParameter("socketSize") == null
				|| request.getParameter("core") == null || request.getParameter("thread") == null
				|| request.getParameter("price") == null || request.getParameter("quantity") == null
				|| request.getParameter("memo") == null ) {
			System.out.println("null UpdateCpuController.dopost"); // 디버깅
			response.sendRedirect(request.getContextPath() + "/UpdateCpuController");
			return;
		}
		*/
		String cpuName = request.getParameter("cpuName");
		String companyName = null;
		if(request.getParameter("companyNameInsert") != null  && !"".equals(request.getParameter("companyNameInsert"))) {
			companyName = request.getParameter("companyNameInsert");
		} else if(request.getParameter("companyName") != null  && !"".equals(request.getParameter("companyName"))) {
			companyName = request.getParameter("companyName");
		}
		String categoryName = request.getParameter("categoryName");
		String socketSize = null;
		if(request.getParameter("socketSizeInsert") != null  && !"".equals(request.getParameter("socketSizeInsert"))) {
			socketSize = request.getParameter("socketSizeInsert");
		} else if(request.getParameter("socketSize") != null  && !"".equals(request.getParameter("socketSize"))) {
			socketSize = request.getParameter("socketSize");
		}
		String core = null;
		if(request.getParameter("coreInsert") != null  && !"".equals(request.getParameter("coreInsert"))) {
			core = request.getParameter("coreInsert");
		} else if(request.getParameter("core") != null  && !"".equals(request.getParameter("core"))) {
			core = request.getParameter("core");
		}
		String thread = null;
		if(request.getParameter("threadInsert") != null  && !"".equals(request.getParameter("threadInsert"))) {
			thread = request.getParameter("threadInsert");
		} else if(request.getParameter("thread") != null  && !"".equals(request.getParameter("thread"))) {
			thread = request.getParameter("thread");
		}
		
		int price = Integer.parseInt(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int cpuImageNo = Integer.parseInt(request.getParameter("cpuImageNo"));
		String memo = request.getParameter("memo");
		int cpuNo = Integer.parseInt(request.getParameter("cpuNo"));
		
		// vo
		Cpu c = new Cpu();
		c.setCpuName(cpuName);
		c.setCompanyName(companyName);
		c.setCategoryName(categoryName);
		c.setSocketSize(socketSize);
		c.setCore(core);
		c.setThread(thread);
		c.setPrice(price);
		c.setQuantity(quantity);
		c.setCpuImageNo(cpuImageNo);
		c.setMemo(memo);
		c.setCpuNo(cpuNo);
		System.out.println("[updateCpuController] : " + c.toString()); // 디버깅
		
		int row = cpuDao.updateCpu(c);
		System.out.print(row + " <-- row UpdateMemberController.dopost"); // 디버깅
		 
		String msg = "";
		// 상품수정 성공/실패 확인 코드
		if (row == 1) {
			System.out.println("[UpdateCpuController] : Cpu 수정 성공");
			request.setAttribute("cpuList", list);
			request.setAttribute("companyList", companyList);
			request.setAttribute("socketSizeList", socketSizeList);
			request.setAttribute("coreList", coreList);
			request.setAttribute("threadList", threadList);
			request.getRequestDispatcher("/WEB-INF/view/nonCustomer/cpuList.jsp").forward(request, response);	
		} else {
			System.out.println("[UpdateCpuController] : Cpu 수정 실패");
			msg = "에 실패했습니다.";
			// 값 셋팅 후 보내주기
			request.setAttribute("msg", msg);
			request.setAttribute("companyList", companyList);
			request.setAttribute("socketSizeList", socketSizeList);
			request.setAttribute("coreList", coreList);
			request.setAttribute("threadList", threadList);
			request.getRequestDispatcher("/WEB-INF/view/admin/updateCpuForm.jsp").forward(request, response);
		}	
		
	}

}
