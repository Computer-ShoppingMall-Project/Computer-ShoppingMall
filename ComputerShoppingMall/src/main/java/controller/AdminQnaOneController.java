package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QnaDao;
import vo.Qna;

@WebServlet("/AdminQnaOneController")
public class AdminQnaOneController extends HttpServlet {
	
	private QnaDao qnaDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("sessionAdminId"); 
		if((String)session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		// 상세보기 할 번호 받아오기
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
		qnaDao = new QnaDao();
		Qna qna = qnaDao.selectQnaOneAdmin(qnaNo);
		
		System.out.println("[AdminQnaOneController.doGet] : " + qna.toString());
		
		request.setAttribute("qna", qna);
		// selectAllQnaOne
		request.getRequestDispatcher("/WEB-INF/admin/adminQnaOne.jsp").forward(request, response);
	}
}
