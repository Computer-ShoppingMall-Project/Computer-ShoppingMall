package controller;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StorageDao;
import vo.Storage;

@WebServlet("/InsertStorageController")
public class InsertStorageController extends HttpServlet {
	private StorageDao storageDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sessionCustomerId = (String)session.getAttribute("sessionCustomerId");
		System.out.println(sessionCustomerId+"<-sessionCustomerId");
		if(sessionCustomerId == null) {
			response.sendRedirect(request.getContextPath()+"/LoginController");
			return;
		}
		request.getRequestDispatcher("/WEB-INF/view/insertStorageForm.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String sessionCustomerId = (String)session.getAttribute("sessionCustomerId");
		// 로그인 상태가 아니면 로그인창으로 이동
		if(sessionCustomerId == null) {
			response.sendRedirect(request.getContextPath()+"/LoginController");
			return;
		}
		// 변수등록
		String storageName = null;
		String companyName = null;
		String storageInterface = null;
		String capacity = null;
		int price = 0;
		int quantity = 0;
		String memo = null;
		
		// request값 받아오기
		if(request.getParameter("storageName") != null || request.getParameter("storageName") !="") {
			storageName = request.getParameter("storageName");
		}
		if(request.getParameter("companyName") != null ||request.getParameter("companyName") !="") {
			companyName = request.getParameter("companyName");
		}
		if(request.getParameter("storageInterface") != null ||request.getParameter("storageInterface") !="") {
			storageInterface = request.getParameter("storageInterface");
		}
		if(request.getParameter("capacity") != null ||request.getParameter("capacity") !="") {
			capacity = request.getParameter("capacity");
		}
		if(request.getParameter("price") != null || request.getParameter("price") !="") {
			price = Integer.parseInt(request.getParameter("price"));
		}
		if(request.getParameter("quantity") != null || request.getParameter("quantity") !="") {
			quantity = Integer.parseInt(request.getParameter("quantity"));
		}
		if(request.getParameter("memo") != null || request.getParameter("memo") !="") {
			memo = request.getParameter("memo");
		}
		
		// 디버깅
		System.out.println(storageName+"<--storageName");
		System.out.println(companyName+"<--companyName");
		System.out.println(storageInterface+"<--storageInterface");
		System.out.println(capacity+"<--capacity");
		System.out.println(price+"<--price");
		System.out.println(quantity+"<--quantity");
		System.out.println(memo+"<--memo");
		
		// 
		Storage s = new Storage();
		s.setStorageName(storageName);
		s.setCompanyName(companyName);
		s.setStorageInterface(storageInterface);
		s.setCapacity(capacity);
		s.setPrice(price);
		s.setQuantity(quantity);
		s.setMemo(memo);
		
		storageDao = new StorageDao();
		storageDao.insertStorage(s);
		
		response.sendRedirect(request.getContextPath() + "/DigitalDownloadController");
	}

}
