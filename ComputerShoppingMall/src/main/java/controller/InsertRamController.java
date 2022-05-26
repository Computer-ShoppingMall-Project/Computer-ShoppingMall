package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.RamDao;
import vo.Image;
import vo.Ram;

@WebServlet("/InsertRamController")
public class InsertRamController extends HttpServlet {
	private RamDao ramDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		request.setAttribute("ramList", rmaList);
		request.setAttribute("companyList", companyList);
		request.setAttribute("kindList", kindList);
		request.getRequestDispatcher("/WEB-INF/view/admin/insertRamForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		request.getRequestDispatcher("/WEB-INF/view/admin/insertRamForm.jsp").forward(request, response);
		
		// Ram image 경로지정
		String path = request.getSession().getServletContext().getRealPath("/image");
		System.out.println("[InsertRamController.doPost photo path] : " + path); // 디버깅 
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
		} else { // 이미지 등록 실패시, RamListController로 이동
			System.out.println("[InsertRamController] : 이미지 타입 아님");
			// 잘못 업로드 된 파일이므로 삭제 처리
			File file = new File(path + "\\" + name);
			file.delete();
			
			response.sendRedirect(request.getContextPath() + "/RamListController");
			return;
		}

		// Form에 입력된 값 받는 코드
		String ramName = multiReq.getParameter("ramName");
		String companyName = multiReq.getParameter("companyName");
		String categoryName = multiReq.getParameter("categoryName");
		String kind = multiReq.getParameter("kind");
		int price = Integer.parseInt(multiReq.getParameter("price"));
		int quantity = Integer.parseInt(multiReq.getParameter("quantity"));
		String memo = multiReq.getParameter("memo");
		// vo.Ram
		Ram r = new Ram();
		r.setRamName(ramName);
		r.setCompanyName(companyName);
		r.setCategoryName(categoryName);
		r.setKind(kind);
		r.setPrice(price);
		r.setQuantity(quantity);
		r.setMemo(memo);
		// 디버깅
		System.out.println("[InsertRamController] : " + i.toString());
		System.out.println("[InsertRamController] : " + r.toString());
		
		// dao.insertRam
		ramDao = new RamDao();
		int row = ramDao.insertRam(i, r);
		
		// 상품등록 성공/실패 확인 코드
		if (row == 1) {
			System.out.println("[InsertRamController] : Ram 등록 성공");
			response.sendRedirect(request.getContextPath() + "/RamListController");
			return;
		} else {
			System.out.println("[InsertRamController] : Ram 등록 실패");
			response.sendRedirect(request.getContextPath() + "/InsertRamController");
			return;
		}
	}
}
