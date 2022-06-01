package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.CaseDao;
import vo.Case;
import vo.Image;

@WebServlet("/InsertCaseController")
public class InsertCaseController extends HttpServlet {
	private CaseDao caseDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		caseDao = new CaseDao();
		// CASE  정보
		ArrayList<Case> caseList = caseDao.selectCaseList();
		// CASE SIZE
		ArrayList<String> caseSizeList = caseDao.caseSizeList();
		// GPU SIZE
		ArrayList<String> gpuSizeList = caseDao.gpuSizeList();
		// BAY64MM
		ArrayList<String> bay64mmList = caseDao.bay64mmList();
		// BAY89MM
		ArrayList<String> bay89mmList = caseDao.bay89mmList();
		
		
		// 값 셋팅 후 보내주기
		request.setAttribute("caseList", caseList);
		request.setAttribute("caseSizeList", caseSizeList);
		request.setAttribute("gpuSizeList", gpuSizeList);
		request.setAttribute("bay64mmList", bay64mmList);
		request.setAttribute("bay89mmList", bay89mmList);
		request.getRequestDispatcher("/WEB-INF/view/admin/insertCaseForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		
		caseDao = new CaseDao();
		// case  정보
		ArrayList<Case> caseList = caseDao.selectCaseList();
		// case size
		ArrayList<String> caseSizeList = caseDao.caseSizeList();
		// gpu size
		ArrayList<String> gpuSizeList = caseDao.gpuSizeList();
		// bay64mm
		ArrayList<String> bay64mmList = caseDao.bay64mmList();
		// bay89mm
		ArrayList<String> bay89mmList = caseDao.bay89mmList();
		
		
		
		// Case image 경로지정
		String path = request.getSession().getServletContext().getRealPath("/image");
		System.out.println("[InsertCaseController.doPost photo path] : " + path); // 디버깅 
		// 사진 파일 처리
		MultipartRequest multiReq = new MultipartRequest(request, path, 1024 * 1024 * 100, "utf-8", new DefaultFileRenamePolicy());
		// 사진 받아오기
		String originalName = multiReq.getOriginalFileName("image"); // 사진 원본 이름
		String name = multiReq.getFilesystemName("image"); // 중복 발생 시 변경된 이름
		String type = multiReq.getContentType("image");
		Image i = null;
		
		// 이미지 형태라면 하나의 변수로 묶기
		if (type.equals("image/gif") || type.equals("image/png") || type.equals("image/jpeg")) { 
			// 하나의 변수로 묶어주기 -> DB 저장용
			i = new Image();
			i.setOriginalName(originalName);
			i.setName(name);
			i.setType(type);
		} else { // 이미지 등록 실패시, CaseListController로 이동
			System.out.println("[InsertCaseController] : 이미지 타입 아님");
			// 잘못 업로드 된 파일이므로 삭제 처리
			File file = new File(path + "\\" + name);
			file.delete();
			
			response.sendRedirect(request.getContextPath() + "/CaseListController");
			return;
		}

		// Form에 입력된 값 받는 코드
		String caseName = multiReq.getParameter("caseName");
		
		String caseSize = null;
		
		if(multiReq.getParameter("caseSizeInsert") != null  && !"".equals(multiReq.getParameter("caseSizeInsert"))) {
			caseSize = multiReq.getParameter("caseSizeInsert");
		} else if(multiReq.getParameter("caseSize") != null  && !"".equals(multiReq.getParameter("caseSize"))) {
			caseSize = multiReq.getParameter("caseSize");
		}
		
		String categoryName = multiReq.getParameter("categoryName");
		
		int gpuSize = 0;
		
		if(multiReq.getParameter("gpuSizeInsert") != null  && !"".equals(multiReq.getParameter("gpuSizeInsert"))) {
			gpuSize = Integer.parseInt(multiReq.getParameter("gpuSizeInsert"));
		} else if(multiReq.getParameter("gpuSize") != null  && !"".equals(multiReq.getParameter("gpuSize"))) {
			gpuSize = Integer.parseInt(multiReq.getParameter("gpuSize")); 
		}
		
		int bay89mm = 0;
		
		if(multiReq.getParameter("bay89mmInsert") != null  && !"".equals(multiReq.getParameter("bay89mmInsert"))) {
			bay89mm = Integer.parseInt(multiReq.getParameter("bay89mmInsert"));
		} else if(multiReq.getParameter("bay89mm") != null  && !"".equals(multiReq.getParameter("bay89mm"))) {
			bay89mm = Integer.parseInt(multiReq.getParameter("bay89mm")); 
		}
		
		int bay64mm = 0;
		
		if(multiReq.getParameter("bay64mmInsert") != null  && !"".equals(multiReq.getParameter("bay64mmInsert"))) {
			bay64mm = Integer.parseInt(multiReq.getParameter("bay64mmInsert"));
		} else if(multiReq.getParameter("bay64mm") != null  && !"".equals(multiReq.getParameter("bay64mm"))) {
			bay64mm = Integer.parseInt(multiReq.getParameter("bay64mm")); 
		}
		
		int price = Integer.parseInt(multiReq.getParameter("price"));
		int quantity = Integer.parseInt(multiReq.getParameter("quantity"));
		String memo = multiReq.getParameter("memo");
		// vo.Cpu
		Case c = new Case();
		c.setCaseName(caseName);
		c.setCaseSize(caseSize);
		c.setCategoryName(categoryName);
		c.setGpuSize(gpuSize);
		c.setBay89mm(bay89mm);
		c.setBay64mm(bay64mm);
		c.setPrice(price);
		c.setQuantity(quantity);
		c.setMemo(memo);
		// 디버깅
		System.out.println("[InsertCaseController] : " + i.toString());
		System.out.println("[InsertCaseController] : " + c.toString());
		
		// dao.insertCpu
		caseDao = new CaseDao();
		int row = caseDao.insertCase(i, c);
		
		String msg = "";
		// 상품등록 성공/실패 확인 코드
		if (row == 1) {
			System.out.println("[InsertCaseController] : Case 등록 성공");
			request.setAttribute("caseList", caseList);
			request.setAttribute("caseSizeList", caseSizeList);
			request.setAttribute("gpuSizeList", gpuSizeList);
			request.setAttribute("bay64mmList", bay64mmList);
			request.setAttribute("bay89mmList", bay89mmList);
			request.getRequestDispatcher("/WEB-INF/view/nonCustomer/caseList.jsp").forward(request, response);	
		} else {
			System.out.println("[InsertCaseController] : Case 등록 실패");
			msg = "에 실패했습니다.";
			// 값 셋팅 후 보내주기
			request.setAttribute("msg", msg);
			request.setAttribute("caseSizeList", caseSizeList);
			request.setAttribute("gpuSizeList", gpuSizeList);
			request.setAttribute("bay64mmList", bay64mmList);
			request.setAttribute("bay89mmList", bay89mmList);
			request.getRequestDispatcher("/WEB-INF/view/admin/insertCaseForm.jsp").forward(request, response);	
		}
	}
}
