package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;


@WebServlet("/MemberPwExtensionController")
public class MemberPwExtensionController extends HttpServlet {
	private MemberDao memberDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.memberDao = new MemberDao();

		HttpSession session = request.getSession(); // 세션 정보 불러오기

		//세션에 저장된 sessionMemberId값 memberId에 저장
		String memberId = (String)session.getAttribute("sessionMemberId");

		//이 컨트롤러로 들어왔다면 비밀번호날짜 3개월 연장해주기
		memberDao.updatePlusMonth(memberId);

		// 3개월 연장해주고 메인페이지로 이동
		response.sendRedirect(request.getContextPath()+"/indexController"); 
	}
}