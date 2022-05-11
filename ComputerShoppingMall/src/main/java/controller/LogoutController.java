package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LogoutController")
public class LogoutController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 새션 갱신 메서드(기존 새션 삭제후 새 새션공간 생성)
		request.getSession().invalidate();
		// 로그아웃 -> 로그인 페이지 
		response.sendRedirect(request.getContextPath() + "/LoginController");
	}
}
