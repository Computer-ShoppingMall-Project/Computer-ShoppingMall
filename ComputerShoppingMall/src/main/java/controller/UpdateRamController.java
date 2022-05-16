package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RamDao;
import vo.Ram;

@WebServlet("/UpdateRamController")
public class UpdateRamController extends HttpServlet {
	private RamDao ramDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/deleteRamForm.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
				HttpSession session = request.getSession();
				if((String)session.getAttribute("sessionAdminId") == null) {
					// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
					response.sendRedirect(request.getContextPath() + "/LoginController");
					return;
				}
		// 변수등록
		int ramNo = 0;
		int price = 0;
		int quantity = 0;
		
		// request값 받기
		if(request.getParameter("ramNo")!= null && request.getParameter("ramNo") != "") {
			ramNo = Integer.parseInt(request.getParameter("ramNo"));
		}
		if(request.getParameter("price")!= null && request.getParameter("price") != "") {
			price = Integer.parseInt(request.getParameter("price"));
		}
		if(request.getParameter("quantity")!= null && request.getParameter("quantity") != "") {
			quantity = Integer.parseInt(request.getParameter("quantity"));
		}
		
		// vo
		Ram r = new Ram();
		r.getRamNo();
		r.getPrice();
		r.getQuantity();
		
		// 디버깅
		System.out.println("[updateRamController] : " + r.toString());
		
		// dao
		ramDao = new RamDao();
		ramDao.updateRam(r);
		
		response.sendRedirect(request.getContextPath()+"/DigitalDownloadController");
	}

}

