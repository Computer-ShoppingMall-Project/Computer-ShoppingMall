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
import vo.Case;

@WebServlet("/UpdateCaseController")
public class UpdateCaseController extends HttpServlet {
	private CaseDao caseDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		// dao
		caseDao = new CaseDao();
		// case 정보
		ArrayList<Case> caseList = caseDao.selectCaseList();
		// case size
		ArrayList<String> caseSizeList = caseDao.caseSizeList();
		// gpu size
		ArrayList<String> gpuSizeList = caseDao.gpuSizeList();
		// bay64mm
		ArrayList<String> bay64mmList = caseDao.bay64mmList();
		// bay89mm
		ArrayList<String> bay89mmList = caseDao.bay89mmList();
		
		request.setAttribute("caseList", caseList); // 이름 중복 유효성 검사
		request.setAttribute("caseSizeList", caseSizeList);
		request.setAttribute("gpuSizeList", gpuSizeList);
		request.setAttribute("bay64mmList", bay64mmList);
		request.setAttribute("bay89mmList", bay89mmList);
		
		// vo
		Case c = new Case();
		// caseOne
		if(request.getParameter("caseNo") != null ){
			int caseNo = Integer.parseInt(request.getParameter("caseNo"));
			c = caseDao.selectCaseOne(caseNo);
			
			request.setAttribute("case", c);
			request.getRequestDispatcher("/WEB-INF/view/admin/updateCaseForm.jsp").forward(request, response);
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
		caseDao = new CaseDao();
		// case 정보
		ArrayList<Case> caseList = caseDao.selectCaseList();
		// case size
		ArrayList<String> caseSizeList = caseDao.caseSizeList();
		// gpu size
		ArrayList<String> gpuSizeList = caseDao.gpuSizeList();
		// bay64mm
		ArrayList<String> bay64mmList = caseDao.bay64mmList();
		// bay89mm
		ArrayList<String> bay89mmList = caseDao.bay89mmList();
		
		// 변수등록
		String caseName = request.getParameter("caseName");
		// caseSize 직접입력 분기
		String caseSize = null;
		if(request.getParameter("caseSizeInsert") != null  && !"".equals(request.getParameter("caseSizeInsert"))) {
			caseSize = request.getParameter("caseSizeInsert\"");
		} else if(request.getParameter("caseSize") != null  && !"".equals(request.getParameter("caseSize"))) {
			caseSize = request.getParameter("caseSize");
		}
		String categoryName = request.getParameter("categoryName");
		// gpuSize 직접입력 분기
		String gpuSize = null;
		if(request.getParameter("gpuSizeInsert") != null  && !"".equals(request.getParameter("gpuSizeInsert"))) {
			gpuSize  = request.getParameter("gpuSizeInsert");
		} else if(request.getParameter("gpuSize ") != null  && !"".equals(request.getParameter("gpuSize"))) {
			gpuSize  = request.getParameter("gpuSize ");
		}
		// bay89mm 직접입력 분기
		String bay89mm = null;
		if(request.getParameter("bay89mmInsert") != null  && !"".equals(request.getParameter("bay89mmInsert"))) {
			bay89mm = request.getParameter("bay89mmInsert");
		} else if(request.getParameter("bay89mm") != null  && !"".equals(request.getParameter("bay89mm"))) {
			bay89mm = request.getParameter("bay89mm");
		}
		// bay64mm 직접입력 분기
		String bay64mm = null;
		if(request.getParameter("ba64mmInsert") != null  && !"".equals(request.getParameter("bay64mmInsert"))) {
			bay89mm = request.getParameter("bay64mmInsert");
		} else if(request.getParameter("bay64mm") != null  && !"".equals(request.getParameter("bay64mm"))) {
			bay89mm = request.getParameter("bay64mm");
		}
		int price = Integer.parseInt(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int caseImageNo = Integer.parseInt(request.getParameter("caseImageNo"));
		String memo = request.getParameter("memo");
		int caseNo = Integer.parseInt(request.getParameter("caseNo"));
		
		// vo
		Case c = new Case();
		c.getCaseName();
		c.getCaseSize();
		c.getCategoryName();
		c.getGpuSize();
		c.getBay89mm();
		c.getBay64mm();
		c.getPrice();
		c.getQuantity();
		c.getCaseImageNo();
		c.setMemo(memo);
		c.getCaseNo();
		System.out.println("[updateCaseController] : " + c.toString()); // 디버깅
		
		int row = caseDao.updateCase(c);
		System.out.print(row + " <-- row UpdateCaseController.dopost"); // 디버깅
		 
		String msg = "";
		// 상품수정 성공/실패 확인 코드
		if (row == 1) {
			System.out.println("[UpdateCaseController] : Case 수정 성공");
			request.setAttribute("caseSizeList", caseSizeList);
			request.setAttribute("gpuSizeList", gpuSizeList);
			request.setAttribute("bay64mmList", bay64mmList);
			request.setAttribute("bay89mmList", bay89mmList);
			request.getRequestDispatcher("/WEB-INF/view/nonCustomer/caseList.jsp").forward(request, response);	
		} else {
			System.out.println("[UpdateCaseController] : Case 수정 실패");
			msg = "에 실패했습니다.";
			// 값 셋팅 후 보내주기
			System.out.println("[UpdateCaseController] : Case 수정 성공");
			request.setAttribute("caseSizeList", caseSizeList);
			request.setAttribute("gpuSizeList", gpuSizeList);
			request.setAttribute("bay64mmList", bay64mmList);
			request.setAttribute("bay89mmList", bay89mmList);
			request.getRequestDispatcher("/WEB-INF/view/nonCustomer/caseList.jsp").forward(request, response);	
	}
	
  }
	
}

