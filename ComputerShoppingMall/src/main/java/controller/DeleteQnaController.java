package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QnaDao;

@WebServlet("/DeleteQnaController")
public class DeleteQnaController extends HttpServlet {
	
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
		request.setAttribute("qnaNo", qnaNo);
		
		qnaDao = new QnaDao();
		int row = qnaDao.deleteQna(qnaNo, customerId);
		
		if(row == 1) { // QNA 삭제 성공 시, List로 돌아가기
			System.out.println("[DeleteQnaController.doGet] : qna 삭제 성공");
			response.sendRedirect(request.getContextPath() + "/QnaListController?customerId="+customerId);
			return;
		} else { // QNA 삭제 실패 시, QNA상세보기로(QNA 상세보기에 삭제버튼 존재) 돌아가기
			System.out.println("[DeleteQnaController.doGet] : qna 삭제 실패");
			response.sendRedirect(request.getContextPath() + "/QnaOneController?qnaNo="+qnaNo);
			return;
		}
	}
}
