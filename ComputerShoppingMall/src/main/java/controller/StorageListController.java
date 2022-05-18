package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StorageDao;
import vo.Storage;

@WebServlet("/StorageListController")
public class StorageListController extends HttpServlet {

	private StorageDao storageDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		request.getRequestDispatcher("/WEB-INF/view/storageList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
