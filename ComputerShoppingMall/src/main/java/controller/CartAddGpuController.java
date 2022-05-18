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
		String customerId = (String)session.getAttribute("sessionCustomerId");
		if(customerId != null) {
			// 이미 로그인이 되어 있는 상태라면
			response.sendRedirect(request.getContextPath() + "/IndexController");
			return;
		}
		  
		// request 값 받아오기
		String productName = null;
		String categoryName = null;
		int cateogryNumber = 0;
		int categoryPrice = 0;
		int categoryQuantity = 0;
		  
		productName = request.getParameter("puductName");
		categoryName = request.getParameter("categoryName");
		cateogryNumber = Integer.parseInt(request.getParameter("cateogryNumber"));
		categoryPrice= Integer.parseInt(request.getParameter("categoryPrice"));
		categoryQuantity = Integer.parseInt(request.getParameter("categoryQuantity"));
		  
		  
		// vo
		Gpu gpu = new Gpu();
		gpu.setCategoryName(categoryName);
		gpu.setGpuName(productName);
		gpu.setGpuNo(cateogryNumber);
		gpu.setPrice(categoryPrice);
		gpu.setQuantity(categoryQuantity);
		  
		// dao
		gpuDao = new GpuDao();
		int row = gpuDao.insertCartGpu(customerId, gpu);
		// 상품 데이터 등록 성공 체크 코드
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
