package controller;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PowerDao;

@WebServlet("/DeletePowerController")
public class DeletePowerController extends HttpServlet {
	private PowerDao powerDao;
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
		int powerNo = 0;
		// request값 받아오기
		if(request.getParameter("powerNo")!= null || request.getParameter("powerNo") != "") {
			powerNo = Integer.parseInt(request.getParameter("powerNo"));
		}
		// 디버깅
		System.out.println(powerNo+"<-powerNo");
		
		// dao
		powerDao = new PowerDao();
		powerDao.deletePower(powerNo);
		
		response.sendRedirect(request.getContextPath()+"/DigitalDownloadController");	
	}

}
