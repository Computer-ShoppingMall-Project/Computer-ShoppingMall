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

import dao.MainboardDao;
import vo.Cpu;
import vo.Mainboard;

@WebServlet("/UpdateMainboardController")
public class UpdateMainboardController extends HttpServlet {
	private MainboardDao mainboardDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if ((String) session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}

		// dao
		mainboardDao = new MainboardDao();
		// 리스트 받아오기 -> 상품명, 가격 mainboardName, price
		ArrayList<Mainboard> mainboardList = mainboardDao.selectMainboardList();
		// COMPANY
		ArrayList<String> companyList = mainboardDao.companyKind();
		// CPU Socket
		ArrayList<String> socketSizeList = mainboardDao.socketSizeKind();
		// CHIPSET
		ArrayList<String> chipsetList = mainboardDao.chipsetKind();
		// RAM VERSION
		ArrayList<String> ramVersionList = mainboardDao.ramVersionKind();
		// KIND
		ArrayList<String> kindList = mainboardDao.kindKind();
		// 값 세팅
		request.setAttribute("mainboardList", mainboardList);
		request.setAttribute("companyList", companyList);
		request.setAttribute("socketSizeList", socketSizeList);
		request.setAttribute("chipsetList", chipsetList);
		request.setAttribute("ramVersionList", ramVersionList);
		request.setAttribute("kindList", kindList);

		// vo
		Mainboard m = new Mainboard();
		if (request.getParameter("mainboardNo") != null) {
			int mainboardNo = Integer.parseInt(request.getParameter("mainboardNo"));
			m = mainboardDao.selectMainboardOne(mainboardNo);

			request.setAttribute("mainboard", m);
			request.getRequestDispatcher("/WEB-INF/view/admin/updateMainboardForm.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		
		// dao
		mainboardDao = new MainboardDao();
		// 리스트 받아오기 -> 상품명, 가격 mainboardName, price
		ArrayList<Mainboard> mainboardList = mainboardDao.selectMainboardList();
		// COMPANY
		ArrayList<String> companyList = mainboardDao.companyKind();
		// CPU Socket
		ArrayList<String> socketSizeList = mainboardDao.socketSizeKind();
		// CHIPSET
		ArrayList<String> chipsetList = mainboardDao.chipsetKind();
		// RAM VERSION
		ArrayList<String> ramVersionList = mainboardDao.ramVersionKind();
		// KIND
		ArrayList<String> kindList = mainboardDao.kindKind();
		
		String mainboardName = request.getParameter("mainboardName");
		String categoryName = request.getParameter("categoryName");
		String companyName = null;
		if(request.getParameter("companyNameInsert") != null  && !"".equals(request.getParameter("companyNameInsert"))) {
			companyName = request.getParameter("companyNameInsert");
		} else if(request.getParameter("companyName") != null  && !"".equals(request.getParameter("companyName"))) {
			companyName = request.getParameter("companyName");
		}
		String kind = null;
		if(request.getParameter("kindInsert") != null  && !"".equals(request.getParameter("kindInsert"))) {
			kind = request.getParameter("kindInsert");
		} else if(request.getParameter("kind") != null  && !"".equals(request.getParameter("kind"))) {
			kind = request.getParameter("kind");
		}
		String socketSize = null;
		if(request.getParameter("socketSizeInsert") != null  && !"".equals(request.getParameter("socketSizeInsert"))) {
			socketSize = request.getParameter("socketSizeInsert");
		} else if(request.getParameter("socketSize") != null  && !"".equals(request.getParameter("socketSize"))) {
			socketSize = request.getParameter("socketSize");
		}
		String chipset = null;
		if(request.getParameter("chipsetInsert") != null  && !"".equals(request.getParameter("chipsetInsert"))) {
			chipset = request.getParameter("chipsetInsert");
		} else if(request.getParameter("chipset") != null  && !"".equals(request.getParameter("chipset"))) {
			chipset = request.getParameter("chipset");
		}
		String ramVersion = null;
		if(request.getParameter("ramVersionInsert") != null  && !"".equals(request.getParameter("ramVersionInsert"))) {
			ramVersion = request.getParameter("ramVersionInsert");
		} else if(request.getParameter("ramVersion") != null  && !"".equals(request.getParameter("ramVersion"))) {
			ramVersion = request.getParameter("ramVersion");
		}
		
		int price = Integer.parseInt(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int mainboardImageNo = Integer.parseInt(request.getParameter("mainboardImageNo"));
		String memo = request.getParameter("memo");
		int mainboardNo = Integer.parseInt(request.getParameter("mainboardNo"));
		
		// vo.Mainboard
		Mainboard m = new Mainboard();
		m.setMainboardName(mainboardName);
		m.setCategoryName(categoryName);
		m.setCompanyName(companyName);
		m.setKind(kind);
		m.setSocketSize(socketSize);
		m.setChipset(chipset);
		m.setRamVersion(ramVersion);
		m.setPrice(price);
		m.setQuantity(quantity);
		m.setMainboardImageNo(mainboardImageNo);
		m.setMemo(memo);
		m.setMainboardNo(mainboardNo);
		System.out.println("[updateMainboardController] : " + m.toString()); // 디버깅
		
		int row = mainboardDao.updateMainboard(m);

		String msg = "";
		// 상품등록 성공/실패 확인 코드
		if (row == 1) {
			System.out.println("[UpdateMainboardController] : Mainboard 수정 성공");
			request.setAttribute("mainboardList", mainboardList);
			request.setAttribute("companyList", companyList);
			request.setAttribute("socketSizeList", socketSizeList);
			request.setAttribute("chipsetList", chipsetList);
			request.setAttribute("ramVersionList", ramVersionList);
			request.getRequestDispatcher("/WEB-INF/view/nonCustomer/mainboardList.jsp").forward(request, response);
		} else {
			System.out.println("[UpdateMainboardController] : Mainboard 수정 실패");
			msg = "에 실패했습니다.";
			// 값 셋팅 후 보내주기
			request.setAttribute("msg", msg);
			request.setAttribute("companyList", companyList);
			request.setAttribute("socketSizeList", socketSizeList);
			request.setAttribute("chipsetList", chipsetList);
			request.setAttribute("ramVersionList", ramVersionList);
			request.getRequestDispatcher("/WEB-INF/view/admin/updateMainboardForm.jsp").forward(request, response);
		}
		
	}

}

