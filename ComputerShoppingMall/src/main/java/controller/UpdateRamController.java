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

import dao.RamDao;
import vo.Ram;

@WebServlet("/UpdateRamController")
public class UpdateRamController extends HttpServlet {
	private RamDao ramDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if ((String) session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}

		ramDao = new RamDao();
		// ram 제목, 가격
		ArrayList<Ram> rmaList = ramDao.selectRamList();
		// COMPANY
		ArrayList<String> companyList = ramDao.companyKind();
		// KIND
		ArrayList<String> kindList = ramDao.kindKind();

		// 값 셋팅 후 보내주기
		request.setAttribute("ramList", rmaList);
		request.setAttribute("companyList", companyList);
		request.setAttribute("kindList", kindList);
		
		// vo
		Ram r = new Ram();
		if (request.getParameter("ramNo") != null) {
			int ramNo = Integer.parseInt(request.getParameter("ramNo"));
			r = ramDao.selectRamOne(ramNo);

			request.setAttribute("ram", r);
			request.getRequestDispatcher("/WEB-INF/view/admin/updateRamForm.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if ((String) session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		// dao
		ramDao = new RamDao();
		// ram 제목, 가격
		ArrayList<Ram> rmaList = ramDao.selectRamList();
		// COMPANY
		List<String> companyList = ramDao.companyKind();
		// KIND
		List<String> kindList = ramDao.kindKind();

		// Form에 입력된 값 받는 코드
		String ramName = request.getParameter("ramName");
		String companyName = null;
		if (request.getParameter("companyNameInsert") != null
				&& !"".equals(request.getParameter("companyNameInsert"))) {
			companyName = request.getParameter("companyNameInsert");
		} else if (request.getParameter("companyName") != null && !"".equals(request.getParameter("companyName"))) {
			companyName = request.getParameter("companyName");
		}
		String categoryName = request.getParameter("categoryName");
		String kind = null;
		if (request.getParameter("kindInsert") != null && !"".equals(request.getParameter("kindInsert"))) {
			kind = request.getParameter("kindInsert");
		} else if (request.getParameter("kind") != null && !"".equals(request.getParameter("kind"))) {
			kind = request.getParameter("kind");
		}
		int price = Integer.parseInt(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int ramImageNo = Integer.parseInt(request.getParameter("ramImageNo"));
		String memo = request.getParameter("memo");
		int ramNo = Integer.parseInt(request.getParameter("ramNo"));

		// vo.Ram
		Ram r = new Ram();
		r.setRamName(ramName);
		r.setCompanyName(companyName);
		r.setCategoryName(categoryName);
		r.setKind(kind);
		r.setPrice(price);
		r.setQuantity(quantity);
		r.setRamImageNo(ramImageNo);
		r.setMemo(memo);
		r.setRamNo(ramNo);
		// 디버깅
		System.out.println("[InsertRamController] : " + r.toString());

		// dao.insertRam
		int row = ramDao.updateRam(r);

		String msg = "";
		// 상품등록 성공/실패 확인 코드
		if (row == 1) {
			System.out.println("[UpdateRamController] : Ram 수정 성공");
			request.setAttribute("ramList", rmaList);
			request.setAttribute("companyList", companyList);
			request.setAttribute("kindList", kindList);
			request.getRequestDispatcher("/WEB-INF/view/nonCustomer/ramList.jsp").forward(request, response);
		} else {
			System.out.println("[UpdateRamController] : Ram 수정 실패");
			msg = "에 실패했습니다.";
			// 값 셋팅 후 보내주기
			request.setAttribute("msg", msg);
			request.setAttribute("ramList", rmaList);
			request.setAttribute("companyList", companyList);
			request.setAttribute("kindList", kindList);
			request.getRequestDispatcher("/WEB-INF/view/admin/updateRamForm.jsp").forward(request, response);
		}
	}
}

