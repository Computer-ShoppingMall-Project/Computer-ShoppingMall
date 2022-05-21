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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request 값 받기
		int gpuNo = Integer.parseInt(request.getParameter("gpuNo"));
		
		// vo
		Gpu gpu = new Gpu();
		
		// dao
		gpuDao = new GpuDao();
		gpu = gpuDao.selectGpuOne(gpuNo);
		
		// 값 보내주기
		request.setAttribute("gpuOne", gpu);
		request.getRequestDispatcher("WEB-INF/view/nonCustomer/gpuOne.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		String customerId = (String) session.getAttribute("sessionCustomerId");
		if ((String) session.getAttribute("sessionCustomerId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		
		// 변수 등록 (basket)
		int gpuNo =Integer.parseInt(request.getParameter("gpuNo"));
		System.out.println(gpuNo+"<-gpuNo");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		System.out.println(quantity+"<-quantity");
		
		// vo
		Gpu gpuOne = new Gpu();
		Gpu gpu = new Gpu();
		// gpu정보 뽑기
		gpuOne = gpuDao.selectGpuOne(gpuNo);
		
		gpu.setGpuName(gpuOne.getGpuName());
		gpu.setCategoryName(gpuOne.getCategoryName());
		gpu.setGpuNo(gpuOne.getGpuNo());
		gpu.setPrice(gpuOne.getPrice());
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
