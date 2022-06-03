package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CaseDao;
import dao.CoolerDao;
import vo.Case;
import vo.Cooler;

@WebServlet("/UpdateCoolerController")
public class UpdateCoolerController extends HttpServlet {
	private CoolerDao coolerDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 세션확인!
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sessionAdminId") == null) {
		// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
		response.sendRedirect(request.getContextPath() + "/LoginController");
		return;
		
		}
		// dao
		coolerDao = new CoolerDao();

		// cooler 정보
		ArrayList<Cooler> coolerList = coolerDao.selectCoolerList();
		// company
		ArrayList<String> companyList = coolerDao.companyKind();
		// kind
		ArrayList<String> kindList = coolerDao.kindKind();
		// size
		ArrayList<String> sizeList = coolerDao.coolerSizeKind();
		// 값보내기
		request.setAttribute("coolerList", coolerList);
		request.setAttribute("companyList", companyList);
		request.setAttribute("kindList", kindList);
		request.setAttribute("sizeList", sizeList);
		
		// vo
		Cooler c = new Cooler();
		if(request.getParameter("coolerNo") != null ){
			int coolerNo = Integer.parseInt(request.getParameter("coolerNo"));
			c = coolerDao.selectCoolerOne(coolerNo);
			
			request.setAttribute("cooler", c);
			request.getRequestDispatcher("/WEB-INF/view/admin/updateCoolerForm.jsp").forward(request, response);
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
		coolerDao = new CoolerDao();
		// cooler 정보
		ArrayList<Cooler> coolerList = coolerDao.selectCoolerList();
		// company
		ArrayList<String> companyList = coolerDao.companyKind();
		// kind
		ArrayList<String> kindList = coolerDao.kindKind();
		// size
		ArrayList<String> sizeList = coolerDao.coolerSizeKind();
		
		// 요청값받기
		String coolerName = request.getParameter("coolerName");
		String categoryName = request.getParameter("categoryName");
		// companyName 직접입력 분기
		String companyName = null;
		if(request.getParameter("companyNameInsert") != null  && !"".equals(request.getParameter("companyNameInsert"))) {
			companyName = request.getParameter("companyNameInsert");
		} else if(request.getParameter("companyName") != null  && !"".equals(request.getParameter("companyName"))) {
			companyName = request.getParameter("companyName");
		}
		// kind 직접입력 분기
		String kind = null;
		if(request.getParameter("kindInsert") != null  && !"".equals(request.getParameter("kindInsert"))) {
			kind = request.getParameter("kindInsert");
		} else if(request.getParameter("kind") != null  && !"".equals(request.getParameter("kind"))) {
			kind = request.getParameter("kind");
		}
		// size 직접입력 분기
		String coolerSize = null;
		if(request.getParameter("coolerSizeInsert") != null  && !"".equals(request.getParameter("coolerSizeInsert"))) {
			coolerSize = request.getParameter("coolerSizeInsert");
		} else if(request.getParameter("coolerSize") != null  && !"".equals(request.getParameter("coolerSize"))) {
			coolerSize = request.getParameter("coolerSize");
		}
		int price = Integer.parseInt(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int coolerImageNo = Integer.parseInt(request.getParameter("coolerImageNo"));
		String memo = request.getParameter("memo");
		int coolerNo = Integer.parseInt(request.getParameter("coolerNo"));
		
		// vo
		Cooler c = new Cooler();
		c.getCoolerName();
		c.getCategoryName();
		c.getCompanyName();
		c.getKind();
		c.getCoolerSize();
		c.getPrice();
		c.getQuantity();
		c.getCoolerImageNo();
		c.getMemo();
		c.getCoolerNo();
		System.out.println("[updateCoolerController] : " + c.toString()); // 디버깅	
		
		
		int row = coolerDao.updateCooler(c);
		System.out.print(row + " <-- row UpdateCoolerController.dopost"); // 디버깅
		
		String msg = "";
		// 상품수정 성공/실패 확인 코드
		if (row == 1) {
			System.out.println("[UpdateCoolerController] : Cooler 수정 성공");
			request.setAttribute("coolerList", coolerList);
			request.setAttribute("companyList", companyList);
			request.setAttribute("kindList", kindList);
			request.setAttribute("sizeList", sizeList);
			request.getRequestDispatcher("/WEB-INF/view/nonCustomer/coolerList.jsp").forward(request, response);	
		} else {
			System.out.println("[UpdateCoolerController] : Cooler 수정 실패");
			msg = "에 실패했습니다.";
			// 값 셋팅 후 보내주기
			request.setAttribute("msg", msg);
			request.setAttribute("coolerList", coolerList);
			request.setAttribute("companyList", companyList);
			request.setAttribute("kindList", kindList);
			request.setAttribute("sizeList", sizeList);
			request.getRequestDispatcher("/WEB-INF/view/admin/updateCoolerForm.jsp").forward(request, response);
		}	
	}

}

