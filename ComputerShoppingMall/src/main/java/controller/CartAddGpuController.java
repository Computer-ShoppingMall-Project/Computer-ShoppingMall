package controller;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GpuDao;
import vo.Gpu;

@WebServlet("/CartAddGpuController")
public class CartAddGpuController extends HttpServlet {
	private GpuDao gpuDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		String customerId = (String) session.getAttribute("sessionCustomerId");
		if ((String) session.getAttribute("sessionCustomerId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		
		// 변수 등록
		String productName = null;
		String categoryName = null;
		int productNumber = 0;
		int price = 0;
		int quantity = 0;
		
		// request 값 받아오기
		productName = request.getParameter("gpuName");
		categoryName = request.getParameter("categoryName");
		productNumber = Integer.parseInt(request.getParameter("gpuNo"));
		price = Integer.parseInt(request.getParameter("price"));
		quantity = Integer.parseInt(request.getParameter("quantity"));
		  
		// vo
		Gpu gpu = new Gpu();
		gpu.setCategoryName(categoryName);
		gpu.setGpuName(productName);
		gpu.setGpuNo(productNumber);
		gpu.setPrice(price);
		gpu.setQuantity(quantity);
		  
		// dao
		gpuDao = new GpuDao();
		int row = gpuDao.insertCartGpu(customerId, gpu);
		
		if (row == 1) { 
	    	System.out.println("등록 성공! CartAddGpuController.dopost");
	    	response.sendRedirect(request.getContextPath() + "/GpuListController");
	    	return;
	    } else {
	    	System.out.println("등록 실패! CartAddGpuController.dopost");
	    	response.sendRedirect(request.getContextPath() + "/GpuListController?error=error!");
	    }
	}
}
