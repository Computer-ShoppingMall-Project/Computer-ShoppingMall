package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import vo.Customer;

@WebServlet("/AdminCustomerListController")
public class AdminCustomerListController extends HttpServlet {
	private MemberDao memberDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 본인 정보 상세보기 페이지로 이동 -> 비회원일시 로그인 페이지로 이동
			response.sendRedirect(request.getContextPath() + "/SelectMemberOneController");
			return;
		}
		String customerId = ""; // 관리자는 특정 고객이 아닌 전체 회원정보 조회(아이디 검색하지 않았을 시, 기본값 공백)
		String name = ""; // 관리자는 특정 고객이 아닌 전체 회원정보 조회(이름 검색하지 않았을 시, 기본값 공백)
		String active = "0"; // 기본적으로 활동하는 회원들만 조회가능(탈퇴회원은 따로 조회버튼을 통해 들어왔을때 조회가능)
		if(request.getParameter("active") != null && !"".equals(request.getParameter("active"))) {
			active = request.getParameter("active");
		}
		
		memberDao = new MemberDao();
		List<Customer> list = memberDao.AdminselectMemberOne(customerId, name, active);
		request.setAttribute("customerId", customerId);
		request.setAttribute("name", name);
		request.setAttribute("active", active);
		request.setAttribute("customerList", list);
		request.getRequestDispatcher("/WEB-INF/view/admin/adminCustomerList.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태-> 본인 정보 상세보기 페이지로 이동 -> 비회원일시 로그인 페이지로 이동
			response.sendRedirect(request.getContextPath() + "/SelectMemberOneController");
			return;
		}
		String customerId = ""; // 관리자는 특정 고객이 아닌 전체 회원정보 조회(아이디 검색하지 않았을 시, 기본값 공백)
		String name = ""; // 관리자는 특정 고객이 아닌 전체 회원정보 조회(이름 검색하지 않았을 시, 기본값 공백)
		String active = "0"; // 기본적으로 활동하는 회원들만 조회가능(탈퇴회원은 따로 조회버튼을 통해 들어왔을때 조회가능)
		
		// 검색 조회조건이 들어왔다면 바꿔주기
		if(request.getParameter("customerId") != null && !"".equals(request.getParameter("customerId"))) {
			customerId = request.getParameter("customerId");
		}
		
		if(request.getParameter("name") != null && !"".equals(request.getParameter("name"))) {
			name = request.getParameter("name");
		}
		
		if(request.getParameter("active") != null && !"".equals(request.getParameter("active"))) {
			active = request.getParameter("active");
		}
		
		memberDao = new MemberDao();
		List<Customer> list = memberDao.AdminselectMemberOne(customerId, name, active);
		
		request.setAttribute("customerId", customerId);
		request.setAttribute("name", name);
		request.setAttribute("active", active);
		request.setAttribute("customerList", list);
		request.getRequestDispatcher("/WEB-INF/view/admin/adminCustomerList.jsp").forward(request, response);
	}
	
}
