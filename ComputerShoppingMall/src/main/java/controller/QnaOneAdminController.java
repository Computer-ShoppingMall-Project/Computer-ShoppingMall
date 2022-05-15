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

@WebServlet("/QnaOneAdminController")
public class QnaOneAdminController extends HttpServlet {
	private QnaDao qnaDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 관리자 session 확인 추가 -> 관리자 로그인방식 회의 이후 추가
		
		// 상세보기 할 번호 받아오기
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
		qnaDao = new QnaDao();
		ArrayList<Qna> list = qnaDao.selectQnaOneAdmin(qnaNo);
		
		request.setAttribute("adminQnaOneList", list);
		// selectAllQnaOne
		request.getRequestDispatcher("/WEB-INF/view/adminQnaOne.jsp").forward(request, response);
	}
}
