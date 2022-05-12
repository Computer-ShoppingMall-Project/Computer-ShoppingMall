package controller;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GpuDao;

@WebServlet("/DeleteGpuController")
public class DeleteGpuController extends HttpServlet {
    private GpuDao gpuDao;
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
		int gpuNo = 0;
		// request값 받아오기
		if(request.getParameter("gpuNo")!= null || request.getParameter("gpuNo") != "") {
			gpuNo = Integer.parseInt(request.getParameter("gpuNo"));
		}
		// 디버깅
		System.out.println(gpuNo+"<-gpuNo");
		gpuDao = new GpuDao();
		gpuDao.deleteGpu(gpuNo);
		
		response.sendRedirect(request.getContextPath()+"/DigitalDownloadController");
	}

}
