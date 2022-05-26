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

import dao.StorageDao;
import vo.Image;
import vo.Storage;

@WebServlet("/InsertStorageController")
public class InsertStorageController extends HttpServlet {
	private StorageDao storageDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(); 
		String adminId = (String)session.getAttribute("sessionAdminId");
		if((String)session.getAttribute("sessionAdminId") == null) { // 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기 
			response.sendRedirect(request.getContextPath() +"/LoginController");
			return; 
		}
		storageDao = new StorageDao();
		// 정보(상품명, 가격)
		ArrayList<Storage> storageList = storageDao.selectStorageList();
		// company
		ArrayList<String> companyList = storageDao.companyKind();
		// interface
		ArrayList<String> interfaceList = storageDao.interfaceKind();
		// capacity
		ArrayList<String> capacityList = storageDao.capacityKind();
		// companyList
		
		request.setAttribute("storageList", storageList);
		request.setAttribute("companyList", companyList);
		request.setAttribute("interfaceList", interfaceList);
		request.setAttribute("capacityList", capacityList);
		request.getRequestDispatcher("/WEB-INF/view/admin/insertStorageForm.jsp").forward(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // 세션확인 HttpSession session = request.getSession();
		HttpSession session = request.getSession(); String adminId = (String)session.getAttribute("sessionAdminId");
		if((String)session.getAttribute("sessionAdminId") == null) { // 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기 
			response.sendRedirect(request.getContextPath() +"/LoginController");
			return; 
		}
		request.getRequestDispatcher("/WEB-INF/view/admin/insertStorageForm.jsp").forward(request, response);
		 //상태 -> 로그인 폼으로 돌아가기 response.sendRedirect("/LoginController"); return; }
	
		String path = request.getSession().getServletContext().getRealPath("/image");
		System.out.println("[InsertStorageController.doPost photo path] : " + path);

		MultipartRequest multiReq = new MultipartRequest(request, path, 1024 * 1024 * 100, "utf-8", new DefaultFileRenamePolicy());

		// 사진 받아오기
		String originalName = multiReq.getOriginalFileName("image"); // 사진 원본 이름
		String name = multiReq.getFilesystemName("image"); // 중복 발생 시 변경된 이름
		String type = multiReq.getContentType("image");
		Image i = null;
		if (type.equals("image/gif") || type.equals("image/png") || type.equals("image/jpeg")) { // 이미지 형태라면 하나의 변수로 묶기
			// 하나의 변수로 묶어주기 -> DB 저장용
			i = new Image();
			i.setOriginalName(originalName);
			i.setName(name);
			i.setType(type);
		} else { // 이미지 등록 실패시, StorageListController로 이동
			System.out.println("[InsertStorageController] : 이미지 타입 아님");
			// 잘못 업로드 된 파일이므로 삭제 처리
			File file = new File(path + "\\" + name);
			file.delete();

			response.sendRedirect(request.getContextPath() + "/StorageListController");
			return;
		}

		String storageName = multiReq.getParameter("storageName");
		String companyName = multiReq.getParameter("companyName");
		String categoryName = multiReq.getParameter("categoryName");
		String storageInterface = multiReq.getParameter("storageInterface");
		String capacity = multiReq.getParameter("capacity");
		int price = Integer.parseInt(multiReq.getParameter("price"));
		int quantity = Integer.parseInt(multiReq.getParameter("quantity"));
		String memo = multiReq.getParameter("memo");
		// 하나의 변수로 묶어주기
		Storage s = new Storage();
		s.setStorageName(storageName);
		s.setCompanyName(companyName);
		s.setCategoryName(categoryName);
		s.setStorageInterface(storageInterface);
		s.setCapacity(capacity);
		s.setPrice(price);
		s.setQuantity(quantity);
		s.setMemo(memo);

		System.out.println("[InsertStorageController] : " + i.toString());
		System.out.println("[InsertStorageController] : " + s.toString());
		storageDao = new StorageDao();
		int row = storageDao.insertStorage(i, s);
		if (row == 1) {
			System.out.println("[InsertStorageController] : 저장소 등록 성공");
		} else {
			System.out.println("[InsertStorageController] : 저장소 등록 실패");
		}
	}
}
