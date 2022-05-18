package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CpuDao;
import vo.Cpu;

@WebServlet("/CartAddCpuController")
public class CartAddCpuController extends HttpServlet {
	private CpuDao cpuDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 새션 확인
		HttpSession session = request.getSession();
		String customerId = (String)session.getAttribute("sessionCustomerId");
		if ((String)session.getAttribute("sessionCustomerId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		
		// 변수 등록 (basket)
		String productName = null;
		String categoryName = null;
		int productNumber = 0;
		int price = 0;
		int quantity = 0;
		
		// request 값 받아오기 Cpu -> basket
		productName = request.getParameter("cpuName");
		categoryName = request.getParameter("categoryName");
		productNumber = Integer.parseInt(request.getParameter("CpuNo"));
		price = Integer.parseInt(request.getParameter("price"));
		quantity = Integer.parseInt(request.getParameter("quantity"));
		
		// vo
		Cpu cpu = new Cpu();
		cpu.setCpuName(productName);
		cpu.setCategoryName(categoryName);
		cpu.setCpuNo(productNumber);
		cpu.setPrice(price);
		cpu.setQuantity(quantity);
		
		// dao
		cpuDao = new CpuDao();
		int row = cpuDao.insertCartCpu(customerId, cpu);
		
		// 상품 데이터 등록 성공 체크 코드
		if (row == 1) { 
			   System.out.println("등록 성공! CartAddCpuController.dopost");
			   response.sendRedirect(request.getContextPath() + "/CpuListController");
			   return;
		} else {
			   System.out.println("등록 실패! CartAddCpyuController.dopost");
			   response.sendRedirect(request.getContextPath() + "/CpuListController?error=error!");
		}
	}
}
