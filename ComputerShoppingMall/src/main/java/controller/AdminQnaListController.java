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
		// 세션확인 -> 후에 관리자 방식 선택 후 수정 예정
		/*

		HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("sessionAdminId"); 
		if((String)session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		
		*/
		
		qnaDao = new QnaDao();
		ArrayList<Qna> list = qnaDao.selectQnaListAdmin();
		request.setAttribute("qnaList", list);
		// 관리자 QNA (모든 고객의 문의 모아보기)
		request.getRequestDispatcher("/WEB-INF/view/adminQnaList.jsp").forward(request, response);
	}
}
