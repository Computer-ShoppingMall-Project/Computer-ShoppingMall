package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StorageDao;

@WebServlet("/DeleteStorageController")
public class DeleteStorageController extends HttpServlet {
	private StorageDao storageDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if ((String) session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}

		// 변수 등록
		int storageNo = 0;

		// request값 받아오기
		if (request.getParameter("storageNo") != null && request.getParameter("storageNo") != "") {
			storageNo = Integer.parseInt(request.getParameter("storageNo"));
		}

		// 디버깅
		System.out.println(storageNo + "<-storageNo");

		// dao
		storageDao = new StorageDao();
		int row = storageDao.deleteStorage(storageNo);

		if(row == 1) { // 삭제 성공 시, List로 돌아가기
			System.out.println("[DeleteStorageController.doGet] : SDD/HDD 삭제 성공");
			response.sendRedirect(request.getContextPath() + "/StorageListController");
			return;
		} else { // 삭제 실패해도 List로 돌아가기
			System.out.println("[DeleteStorageController.doGet] : SDD/HDD 삭제 실패");
			response.sendRedirect(request.getContextPath() + "/StorageListController");
			return;
		}
	}
}
