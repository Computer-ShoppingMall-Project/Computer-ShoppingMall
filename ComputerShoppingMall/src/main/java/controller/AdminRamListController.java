package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RamDao;
import vo.Ram;

@WebServlet("/AdminRamListController")
public class AdminRamListController extends HttpServlet {
	private RamDao ramDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		
		ramDao = new RamDao();
		// ram 제목, 가격 
		ArrayList<Ram> rmaList = ramDao.selectRamList();
		// COMPANY
		ArrayList<String> companyList = ramDao.companyKind();
		// KIND
		ArrayList<String> kindList = ramDao.kindKind();
		
		int count = rmaList.size(); // 상품 개수(0개일시, 조건해당 상품 없다는 메세지 띄우기 용도 + 개수 표시)
		
		request.setAttribute("ramList", rmaList);
		request.setAttribute("companyList", companyList);
		request.setAttribute("kindList", kindList);
		request.setAttribute("count", count);
		request.getRequestDispatcher("/WEB-INF/view/admin/adminRamList.jsp").forward(request, response);
	}
}
