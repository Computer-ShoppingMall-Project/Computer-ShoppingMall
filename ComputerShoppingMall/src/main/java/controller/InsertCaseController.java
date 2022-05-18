package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CaseDao;
import dao.MainboardDao;
import vo.Case;
import vo.Mainboard;

@WebServlet("/InsertCaseController")
public class InsertCaseController extends HttpServlet {
	private CaseDao caseDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		
		request.getRequestDispatcher("/WEB-INF/admin/insertCaseForm.jsp").forward(request, response);
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
		String caseName = null;
		String categoryName = null;
		String caseSize = null;
		int gpuSize = 0;
		int bay89mm = 0;
		int bay64mm = 0;
		int price = 0;
		int quantity = 0;
		String memo = null;
		
		// request값 받아오기
		if(request.getParameter("caseName") != null && request.getParameter("caseName") !="") {
			caseName = request.getParameter("caseName");
		}
		if(request.getParameter("categoryName") != null && request.getParameter("categoryName") !="") {
			caseName = request.getParameter("categoryName");
		}
		if(request.getParameter("caseSize") != null &&request.getParameter("caseSize") !="") {
			caseSize = request.getParameter("caseSize");
		}
		if(request.getParameter("gpuSize") != null && request.getParameter("gpuSize") !="") {
			gpuSize = Integer.parseInt(request.getParameter("gpuSize"));
		}
		if(request.getParameter("bay89mm") != null && request.getParameter("bay89mm") !="") {
			bay89mm = Integer.parseInt(request.getParameter("bay89mm"));
		}
		if(request.getParameter("bay64mm") != null && request.getParameter("bay64mm") !="") {
			bay64mm = Integer.parseInt(request.getParameter("bay64mm"));
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
		Case c = new Case();
		c.setCaseName(caseName);
		c.setCategoryName(categoryName);
		c.setCaseSize(caseSize);
		c.setGpuSize(gpuSize);
		c.setBay89mm(bay89mm);
		c.setBay64mm(bay64mm);
		c.setPrice(price);
		c.setQuantity(quantity);
		c.setMemo(memo);
		
		// 디버깅
		System.out.println("[insertCaseController] : " + c.toString());
		
		// dao insert
		caseDao = new CaseDao();
		caseDao.insertCase(c);
		
		// 홈페이지 이동
		response.sendRedirect(request.getContextPath() + "/DigitalDownloadController");
	}

}
