package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QnaDao;
import vo.Qna;

@WebServlet("/UpdateQnaController")
public class UpdateQnaController extends HttpServlet {
	
	private QnaDao qnaDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션 확인
		HttpSession session = request.getSession();
		String customerId = (String)session.getAttribute("sessionCustomerId");
		if((String)session.getAttribute("sessionCustomerId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
		
		// 기존 QNA 내용 불러오기
		qnaDao = new QnaDao();
		ArrayList<Qna> list = qnaDao.selectQnaOne(customerId, qnaNo);
		
		request.setAttribute("qnaList", list);
		request.getRequestDispatcher("/WEB-INF/view/updateQna.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
