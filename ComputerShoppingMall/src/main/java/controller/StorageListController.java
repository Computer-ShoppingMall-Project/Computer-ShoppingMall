package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GpuDao;
import dao.StorageDao;
import vo.Gpu;
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
		
		int count = storageList.size(); // 상품 개수(0개일시, 조건해당 상품 없다는 메세지 띄우기 용도 + 개수 표시)
		
		request.setAttribute("storageList", storageList);
		request.setAttribute("companyList", companyList);
		request.setAttribute("interfaceList", interfaceList);
		request.setAttribute("capacityList", capacityList);
		request.setAttribute("count", count);
		request.getRequestDispatcher("/WEB-INF/view/nonCustomer/storageList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 체크박스 값 받기
		String[] companyName = request.getParameterValues("companyName");
		String[] storageInterface = request.getParameterValues("storageInterface");
		String[] capacity = request.getParameterValues("capacity");
		
		String search = request.getParameter("search"); // 검색어 받아오기
		
		storageDao = new StorageDao();
		// gpu 상세검색 리스트 
		ArrayList<Storage> storageList = storageDao.storageDetailSearch(companyName, storageInterface, capacity, search);
		// 체크박스
		ArrayList<String> companyList = storageDao.companyKind(); // company
		ArrayList<String> interfaceList = storageDao.interfaceKind(); // interface
		ArrayList<String> capacityList = storageDao.capacityKind(); // capacity
		
		int count = storageList.size(); // 상품 개수(0개일시, 조건해당 상품 없다는 메세지 띄우기 용도 + 개수 표시)
		
		// 체크여부 확인
		request.setAttribute("companyName", companyName);
		request.setAttribute("storageInterface", storageInterface);
		request.setAttribute("capacity", capacity);
		
		request.setAttribute("storageList", storageList);
		request.setAttribute("companyList", companyList);
		request.setAttribute("interfaceList", interfaceList);
		request.setAttribute("capacityList", capacityList);
		request.setAttribute("count", count);
		// 검색어 유지
		request.setAttribute("search", search);
		
		request.getRequestDispatcher("/WEB-INF/view/nonCustomer/storageList.jsp").forward(request, response);
	}
}
