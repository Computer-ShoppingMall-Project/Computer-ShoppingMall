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
		Qna qna = qnaDao.selectQnaOne(customerId, qnaNo);
		
		request.setAttribute("qna", qna);
		request.getRequestDispatcher("/WEB-INF/customer/updateQna.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션 확인
		HttpSession session = request.getSession();
		String customerId = (String)session.getAttribute("sessionCustomerId");
		if((String)session.getAttribute("sessionCustomerId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		
		// 입력값 받아오기
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
		String qnaTitle = request.getParameter("qnaTitle");
		String qnaContent = request.getParameter("qnaContent");
		
		// Qna vo로 묶기
		Qna qna = new Qna();
		qna.setQnaNo(qnaNo);
		qna.setCustomerId(customerId);
		qna.setQnaTitle(qnaTitle);
		qna.setQnaContent(qnaContent);
		
		System.out.println("[UpdateQnaController.doPost] : "+qna.toString());
		
		qnaDao = new QnaDao();
		int row = qnaDao.updateQna(qna);
		
		if(row == 1) { // QNA 수정 성공 시, 수정성공된 상세보기 페이지로 이동
			System.out.println("[UpdateQnaController.doPost] : qna 수정 성공");
			response.sendRedirect(request.getContextPath() + "/QnaOneController?qnaNo=" + qnaNo);
			return;
		} else { // QNA 수정 실패 시, 다시 UpdateQna 페이지로 이동 
			System.out.println("[UpdateQnaController.doPost] : qna 수정 실패");
			response.sendRedirect(request.getContextPath() + "/UpdateQnaContoller?qnaNo=" + qnaNo);
			return;
		}
	}
}
