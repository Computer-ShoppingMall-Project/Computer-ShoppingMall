package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CoolerDao;

@WebServlet("/DeleteCoolerController")
public class DeleteCoolerController extends HttpServlet {
	private CoolerDao coolerDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sessionCustomerId = (String)session.getAttribute("sessionCustomerId");
		System.out.println(sessionCustomerId+"<-sessionCustomerId");
		if(sessionCustomerId == null) {
			response.sendRedirect(request.getContextPath()+"/LoginController");
			return;
		}
		request.getRequestDispatcher("/WEB-INF/view/deleteCoolerForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 변수 등록
	int coolerNo = 0;
	// request값 받아오기
	if(request.getParameter("coolerNo")!= null && request.getParameter("coolerNo") != "") {
			coolerNo = Integer.parseInt(request.getParameter("coolerNo"));
		}
	// 디버깅	System.out.println(coolerNo+"<-coolerNo");
	
	// dao
	coolerDao = new CoolerDao();
	coolerDao.deleteCooler(coolerNo);

		response.sendRedirect(request.getContextPath()+"/DigitalDownloadController");
	}

}
