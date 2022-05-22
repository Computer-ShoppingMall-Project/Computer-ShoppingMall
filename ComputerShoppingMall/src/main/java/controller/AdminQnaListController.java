package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;

import dao.QnaDao;
import vo.Qna;

@WebServlet("/AdminQnaListController")
public class AdminQnaListController extends HttpServlet {
	
	private QnaDao qnaDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("sessionAdminId"); 
		if((String)session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		
		String answer = null; // 답변/미답변 모아보기 여부(dao 판별용도)
		if("answer".equals(request.getParameter("answer"))) {
			answer = request.getParameter("answer"); // 답변 모아보기 버튼을 누른다면 answer 반환
		} else if("noAnswer".equals(request.getParameter("answer"))) {
			answer = request.getParameter("answer"); // 미답변 모아보기 버튼을 누른다면 noAnswer 반환 
		}
		
		qnaDao = new QnaDao();
		ArrayList<Qna> list = qnaDao.selectQnaListAdmin(answer);
		request.setAttribute("qnaList", list);
		
		// 관리자 QNA (모든 고객의 문의 모아보기)
		request.getRequestDispatcher("/WEB-INF/view/admin/adminQnaList.jsp").forward(request, response);
	}
}
