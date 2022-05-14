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

@WebServlet("/QnaOneController")
public class QnaOneController extends HttpServlet {
	private QnaDao qnaDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		String customerId = (String)session.getAttribute("sessionCustomerId");
		if((String)session.getAttribute("sessionCustomerId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
		
		qnaDao = new QnaDao();
		ArrayList<Qna> list = qnaDao.selectQnaOne(customerId, qnaNo);
		String adminAnswer = ""; // 사용자에게 답변이 null로 보이지 않도록 "" 처리(관리자 답변 미등록시)
		Qna qna = new Qna();
		if(qna.getQnaAnswer() != null) { // 답변 등록이 되어있다면 답변 넣어주기
			adminAnswer = qna.getQnaAnswer();
		}
		
		request.setAttribute("customerId", customerId);
		request.setAttribute("qnaOneList", list);
		request.setAttribute("adminAnswer", adminAnswer);
		request.getRequestDispatcher("WEB-INF/view/qnaOne.jsp").forward(request, response);
	}
}