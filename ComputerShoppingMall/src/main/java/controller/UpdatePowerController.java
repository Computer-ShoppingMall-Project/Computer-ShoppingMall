package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PowerDao;
import vo.Power;

@WebServlet("/UpdatePowerController")
public class UpdatePowerController extends HttpServlet {
    private PowerDao powerDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if ((String) session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		// dao
		powerDao = new PowerDao();
		// POWER 이름, 가격 가져오기
		ArrayList<Power> powerList = powerDao.selectPowerList();
		// RATED_POWER
		List<String> ratedPowerList = powerDao.ratedPowerList();
		// 값 셋팅 후 보내주기
		request.setAttribute("powerList", powerList);
		request.setAttribute("ratedPowerList", ratedPowerList);

		// vo
		Power p = new Power();
		if (request.getParameter("powerNo") != null) {
			int powerNo = Integer.parseInt(request.getParameter("powerNo"));
			p = powerDao.selectPowerOne(powerNo);

			request.setAttribute("power", p);
			request.getRequestDispatcher("/WEB-INF/view/admin/updatePowerForm.jsp").forward(request, response);
		}
	}
				
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if ((String) session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		powerDao = new PowerDao();
		// POWER 이름, 가격 가져오기
		ArrayList<Power> powerList = powerDao.selectPowerList();
		// RATED_POWER
		List<String> ratedPowerList = powerDao.ratedPowerList();

		// Form에 입력된 값 받는 코드
		String powerName = request.getParameter("powerName");
		String categoryName = request.getParameter("categoryName");
		String ratedPower = null;
		if (request.getParameter("ratedPowerInsert") != null && !"".equals(request.getParameter("ratedPowerInsert"))) {
			ratedPower = request.getParameter("ratedPowerInsert");
		} else if (request.getParameter("ratedPower") != null && !"".equals(request.getParameter("ratedPower"))) {
			ratedPower = request.getParameter("ratedPower");
		}
		int price = Integer.parseInt(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int powerImageNo = Integer.parseInt(request.getParameter("powerImageNo"));
		String memo = request.getParameter("memo");
		int powerNo = Integer.parseInt(request.getParameter("powerNo"));

		// vo.Power
		Power p = new Power();
		p.setPowerName(powerName);
		p.setCategoryName(categoryName);
		p.setRatedPower(ratedPower);
		p.setPrice(price);
		p.setQuantity(quantity);
		p.setPowerImageNo(powerImageNo);
		p.setMemo(memo);
		p.setPowerNo(powerNo);
		// 디버깅
		System.out.println("[UpdatePowerController] : " + p.toString());

		// dao
		int row = powerDao.updatePower(p);

		String msg = "";
		// 상품등록 성공/실패 확인 코드
		if (row == 1) {
			System.out.println("[UpdatePowerController] : Power 수정 성공");
			request.setAttribute("powerList", powerList);
			request.setAttribute("ratedPowerList", ratedPowerList);
			request.getRequestDispatcher("/WEB-INF/view/nonCustomer/powerList.jsp").forward(request, response);
		} else {
			System.out.println("[UpdatePowerController] : Power 수정 실패");
			msg = "에 실패했습니다.";
			// 값 셋팅 후 보내주기
			request.setAttribute("msg", msg);
			request.setAttribute("powerList", powerList);
			request.setAttribute("ratedPowerList", ratedPowerList);
			request.getRequestDispatcher("/WEB-INF/view/admin/insertPowerForm.jsp").forward(request, response);
		}
	}
}

