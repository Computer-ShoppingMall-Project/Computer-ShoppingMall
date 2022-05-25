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
@WebServlet("/UpdateCpuController") 
public class UpdateCpuController extends HttpServlet {
	private CpuDao cpuDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		// dao
		cpuDao = new CpuDao();
		// vo
		Cpu c = new Cpu();
		if(request.getParameter("cpuNo") != null ){
		int cpuNo = Integer.parseInt(request.getParameter("cpuNo"));
		c = cpuDao.selectCpuOne(cpuNo);
					
		request.setAttribute("caseOne", c);
		request.getRequestDispatcher("/WEB-INF/view/admin/updateCaseForm.jsp").forward(request, response);
			}
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
		int CpuNo = 0;
		int price = 0;
		int quantity = 0;
		
		// request값 받기
		if(request.getParameter("CpuNo")!= null || request.getParameter("CpuNo") != "") {
			CpuNo = Integer.parseInt(request.getParameter("CpuNo"));
		}
		if(request.getParameter("price")!= null || request.getParameter("price") != "") {
			price = Integer.parseInt(request.getParameter("price"));
		}
		if(request.getParameter("quantity")!= null || request.getParameter("quantity") != "") {
			quantity = Integer.parseInt(request.getParameter("quantity"));
		}
		
		// 디버깅
		System.out.println(CpuNo+"<-CpuNo");
		System.out.println(price+"<-price");
		System.out.println(quantity+"<-quantity");
		
		// vo
		Cpu c = new Cpu();
		c.getCpuNo();
		c.getPrice();
		c.getQuantity();
		
		System.out.println("[updateCpuController] : " + c.toString());
		
		// dao
		cpuDao = new CpuDao();
		cpuDao.updateCpu(c);
		
		response.sendRedirect(request.getContextPath()+"/DigitalDownloadController");
	}

}

