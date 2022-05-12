package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CaseDao;


@WebServlet("/DeleteCaseController")
public class DeleteCaseController extends HttpServlet {
	private CaseDao caseDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sessionCustomerId = (String)session.getAttribute("sessionCustomerId");
		System.out.println(sessionCustomerId+"<-sessionCustomerId");
		if(sessionCustomerId == null) {
			response.sendRedirect(request.getContextPath()+"/LoginController");
			return;
		}
		request.getRequestDispatcher("/WEB-INF/view/insertPowerForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 변수 등록
		int caseNo = 0 ;
		// request값 받아오기
		if(request.getParameter("caseNo")!= null || request.getParameter("caseNo") != "") {
			caseNo = Integer.parseInt(request.getParameter("caseNo"));
		}
		// 디버깅
		System.out.println(caseNo+"<-caseNo");
		
		// dao
		caseDao = new CaseDao();
		caseDao.deleteCase(caseNo);
		
		response.sendRedirect(request.getContextPath()+"/DigitalDownloadController");
	}

}
