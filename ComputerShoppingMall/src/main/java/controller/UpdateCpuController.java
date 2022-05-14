package controller;

import java.io.IOException; 
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
		HttpSession session = request.getSession();
		String sessionCustomerId = (String)session.getAttribute("sessionCustomerId");
		System.out.println(sessionCustomerId+"<-sessionCustomerId");
		if(sessionCustomerId == null) {
			response.sendRedirect(request.getContextPath()+"/LoginController");
			return;
		}
		request.getRequestDispatcher("/WEB-INF/view/deleteCpuForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		// dao
		cpuDao = new CpuDao();
		cpuDao.updateCpu(c);
		
		response.sendRedirect(request.getContextPath()+"/DigitalDownloadController");
	}

}