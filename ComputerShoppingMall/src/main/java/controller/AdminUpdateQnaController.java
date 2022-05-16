package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QnaDao;

@WebServlet("/AdminUpdateQnaController")
public class AdminUpdateQnaController extends HttpServlet {
	
	private QnaDao qnaDao;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 답변 / 수정할 내용 받아오기
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo")); // 수정 번호
		String qnaAnswer = request.getParameter("qnaAnswer"); // 답변 내용
		
		qnaDao = new QnaDao();
		int row = qnaDao.updateQnaAdmin(qnaAnswer, qnaNo);
		
		if(row == 1) { // 답변 등록/수정 성공시 list로 돌아가기
			System.out.println("[AdminUpdateQnaController.doGet] : 답변 등록/수정 성공");
			response.sendRedirect(request.getContextPath()+"/AdminQnaListController"); 
			return;
		} else { // 답변 등록/수정 실패시 다시 작성 페이지로 돌아가기
			System.out.println("[AdminUpdateQnaController.doGet] : 답변 등록/수정 실패");
			response.sendRedirect(request.getContextPath()+"/AdminQnaOneController?qnaNo=" + qnaNo);
			return;
		}
	}
}
