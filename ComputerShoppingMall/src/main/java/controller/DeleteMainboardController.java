package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MainboardDao;
@WebServlet("/DeleteMainboardController")
public class DeleteMainboardController extends HttpServlet {
	private MainboardDao mainboardDao;
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
		int mainboardNo = 0;
		// request값 받아오기
		if(request.getParameter("mainboardNo")!= null || request.getParameter("mainboardNo") != "") {
			mainboardNo = Integer.parseInt(request.getParameter("mainboardNo"));
		}
		// 디버깅
		System.out.println(mainboardNo+"<-mainboardNo");
		
		// dao
		mainboardDao = new MainboardDao();
		mainboardDao.deleteMainboard(mainboardNo);
		
		response.sendRedirect(request.getContextPath()+"/DigitalDownloadController");
	}

}
