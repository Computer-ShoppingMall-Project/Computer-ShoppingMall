package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RamDao;

@WebServlet("/DeleteRamController")
public class DeleteRamController extends HttpServlet {
	private RamDao ramDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sessionCustomerId = (String)session.getAttribute("sessionCustomerId");
		System.out.println(sessionCustomerId+"<-sessionCustomerId");
		if(sessionCustomerId == null) {
			response.sendRedirect(request.getContextPath()+"/LoginController");
			return;
		}
		request.getRequestDispatcher("/WEB-INF/view/.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 변수 등록
		int ramNo = 0;
		// request값 받아오기
		if(request.getParameter("ramNo")!= null || request.getParameter("ramNo") != "") {
			ramNo = Integer.parseInt(request.getParameter("ramNo"));
		}
		// 디버깅
		System.out.println(ramNo+"<-ramNo");
		ramDao = new RamDao();
		ramDao.deleteRam(ramNo);
		
		response.sendRedirect(request.getContextPath()+"/DigitalDownloadController");
	}

}
