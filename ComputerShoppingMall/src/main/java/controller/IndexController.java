
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BasketDao;

@WebServlet("/IndexController")
public class IndexController extends HttpServlet {
	private BasketDao basketDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// 새션 확인
		if((String)session.getAttribute("sessionAdminId") != null) {
			// 관리자 아이디로그인시 관리자 페이지로 이동
			request.getRequestDispatcher("/WEB-INF/view/admin/adminIndex.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/WEB-INF/view/nonCustomer/index.jsp").forward(request, response);
	}
}