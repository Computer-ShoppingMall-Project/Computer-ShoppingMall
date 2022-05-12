package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QnaDao;
import vo.Qna;



@WebServlet("/InsertQnaController")
public class InsertQnaController extends HttpServlet {
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
		request.setAttribute("customerId", customerId);

		
		request.getRequestDispatcher("WEB-INF/view/insertQna.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ** customer **
		
		// 입력값 받아오기
		String customerId = request.getParameter("customerId");
		String qnaTitle = request.getParameter("qnaTitle");
		String qnaContent = request.getParameter("qnaContent");
		
		// Qna vo로 묶기
		Qna qna = new Qna();
		qna.setCustomerId(customerId);
		qna.setQnaTitle(qnaTitle);
		qna.setQnaContent(qnaContent);
		
		qnaDao = new QnaDao();
		int row = qnaDao.insertQna(qna);
		
		if(row == 1) { // 입력 성공시, QnaList(qna리스트) 페이지로 돌아가기
			System.out.println("[insertQuestion] : Qna 등록 성공");
			response.sendRedirect(request.getContextPath()+"/QnaListController");
			return;
		} else { // 입력 실패시, insert
			System.out.println("[insertQuestion] : Qna 등록 실패");
		}
	}
}
