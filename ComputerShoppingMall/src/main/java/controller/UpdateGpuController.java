package controller;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GpuDao;
import vo.Gpu;
@WebServlet("/login/UpdateGpuController")
public class UpdateGpuController extends HttpServlet {
	private GpuDao gpuDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/deleteGpuForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 변수등록
		int GpuNo = 0;
		int price = 0;
		int quantity = 0;
		
		// request값 받기
		if(request.getParameter("GpuNo")!= null && request.getParameter("GpuNo") != "") {
			GpuNo = Integer.parseInt(request.getParameter("GpuNo"));
		}
		if(request.getParameter("price")!= null && request.getParameter("price") != "") {
			price = Integer.parseInt(request.getParameter("price"));
		}
		if(request.getParameter("quantity")!= null && request.getParameter("quantity") != "") {
			quantity = Integer.parseInt(request.getParameter("quantity"));
		}
		
		// 디버깅
		System.out.println(GpuNo+"<-GpuNo");
		System.out.println(price+"<-price");
		System.out.println(quantity+"<-quantity");
		
		// vo
		Gpu g = new Gpu();
		g.getGpuNo();
		g.getPrice();
		g.getQuantity();
		
		// dao
		gpuDao = new GpuDao();
		gpuDao.updateGpu(g);
		
		response.sendRedirect(request.getContextPath()+"/DigitalDownloadController");
	}

}
