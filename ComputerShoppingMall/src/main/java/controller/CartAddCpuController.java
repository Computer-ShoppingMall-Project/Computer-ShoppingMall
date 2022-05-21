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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request 값 받기
		int cpuNo = Integer.parseInt(request.getParameter("cpuNo"));
		
		// vo
		Cpu cpu = new Cpu();
		
		// dao
		cpuDao = new CpuDao();
		cpu = cpuDao.selectCpuOne(cpuNo);
		
		// 값 보내주기
		request.setAttribute("cpuOne", cpu);
		request.getRequestDispatcher("WEB-INF/view/nonCustomer/cpuOne.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 새션 확인
		HttpSession session = request.getSession();
		String customerId = (String)session.getAttribute("sessionCustomerId");
		if ((String) session.getAttribute("sessionCustomerId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		
		// 변수 등록 (basket)
		int cpuNo =Integer.parseInt(request.getParameter("cpuNo"));
		System.out.println(cpuNo+"<-cpuNo");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		System.out.println(quantity+"<-quantity");
		
		
		// vo
		Cpu cpu = new Cpu(); // 장바구니 insert용
		Cpu cpuOne = new Cpu(); // cpuOne select용
		
		// cpu정보 뽑기
		cpuOne = cpuDao.selectCpuOne(cpuNo);
		
		// 뽑은 정보 담기
		cpu.setCpuName(cpuOne.getCpuName());
		cpu.setCategoryName(cpuOne.getCategoryName());
		cpu.setCpuNo(cpuOne.getCpuNo());
		cpu.setPrice(cpuOne.getPrice());
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
