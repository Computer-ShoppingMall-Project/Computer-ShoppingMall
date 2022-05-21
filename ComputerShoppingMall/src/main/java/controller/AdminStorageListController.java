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

import dao.StorageDao;
import vo.Storage;

@WebServlet("/AdminStorageListController")
public class AdminStorageListController extends HttpServlet {
	private StorageDao storageDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
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
		
		request.setAttribute("storageList", storageList);
		request.setAttribute("companyList", companyList);
		request.setAttribute("interfaceList", interfaceList);
		request.setAttribute("capacityList", capacityList);
		request.getRequestDispatcher("/WEB-INF/view/admin/adminStorageList.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
