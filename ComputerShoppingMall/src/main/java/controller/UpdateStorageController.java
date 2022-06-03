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

@WebServlet("/UpdateStorageController")
public class UpdateStorageController extends HttpServlet {
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
		// 게시글 이름, 가격 받아오기
		ArrayList<Storage> storageList = storageDao.selectStorageList();
		// COMPANY
		List<String> companyList = storageDao.companyKind();
		// INTERFACE
		List<String> interfaceList = storageDao.interfaceKind();
		// CAPACITY
		List<String> capacityList = storageDao.capacityKind();
		
		
		// 값 셋팅 후 보내주기
		request.setAttribute("storageList", storageList);
		request.setAttribute("companyList", companyList);
		request.setAttribute("interfaceList", interfaceList);
		request.setAttribute("capacityList", capacityList);
		
		// vo
		Storage s = new Storage();
		if(request.getParameter("storageNo") != null ){
		int storageNo = Integer.parseInt(request.getParameter("storageNo"));
			s = storageDao.selectStorageOne(storageNo);
					
			request.setAttribute("storage", s);
			request.getRequestDispatcher("/WEB-INF/view/admin/updateStorageForm.jsp").forward(request, response);
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
				
				// Form에 입력된 값 받는 코드
				String storageName = request.getParameter("storageName");
				String companyName = request.getParameter("companyName");
				if(request.getParameter("companyNameInsert") != null  && !"".equals(request.getParameter("companyNameInsert"))) {
					companyName = request.getParameter("companyNameInsert");
				} else if(request.getParameter("companyName") != null  && !"".equals(request.getParameter("companyName"))) {
					companyName = request.getParameter("companyName");
				}
				String categoryName = request.getParameter("categoryName");
				String storageInterface = null;
				if(request.getParameter("storageInterfaceInsert") != null  && !"".equals(request.getParameter("storageInterfaceInsert"))) {
					storageInterface = request.getParameter("storageInterfaceInsert");
				} else if(request.getParameter("storageInterface") != null  && !"".equals(request.getParameter("storageInterface"))) {
					storageInterface = request.getParameter("storageInterface");
				}
				String capacity = null;
				if(request.getParameter("capacityInsert") != null  && !"".equals(request.getParameter("capacityInsert"))) {
					capacity = request.getParameter("capacityInsert");
				} else if(request.getParameter("capacityName") != null  && !"".equals(request.getParameter("capacityName"))) {
					capacity = request.getParameter("capacityName");
				}
				int price = Integer.parseInt(request.getParameter("price"));
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				int storageImageNo = Integer.parseInt(request.getParameter("storageImageNo"));
				String memo = request.getParameter("memo");
				int storageNo = Integer.parseInt(request.getParameter("storageNo"));
				
				// vo.Storage
				Storage s = new Storage();
				s.setStorageName(storageName);
				s.setCompanyName(companyName);
				s.setCategoryName(categoryName);
				s.setStorageInterface(storageInterface);
				s.setCapacity(capacity);
				s.setPrice(price);
				s.setQuantity(quantity);
				s.setQuantity(storageImageNo);
				s.setMemo(memo);
				s.setQuantity(storageNo);
				// 디버깅
				System.out.println("[UpdateStorageController] : " + s.toString());
				
				// dao
				int row = storageDao.updateStorage(s);
				
				String msg = "";
				// 상품등록 성공/실패 확인 코드
				if (row == 1) {
					System.out.println("[UpdateStorageController] : 저장소 수정 성공");
					request.setAttribute("storageList", storageList);
					request.setAttribute("companyList", companyList);
					request.setAttribute("interfaceList", interfaceList);
					request.setAttribute("capacityList", capacityList);
					request.getRequestDispatcher("/WEB-INF/view/nonCustomer/storageList.jsp").forward(request, response);
				} else {
					System.out.println("[UpdateStorageController] : 저장소 수정 실패");
					msg = "에 실패했습니다.";
					request.setAttribute("msg", msg);
					request.setAttribute("companyList", companyList);
					request.setAttribute("interfaceList", interfaceList);
					request.setAttribute("capacityList", capacityList);
					request.getRequestDispatcher("/WEB-INF/view/admin/updateStorageForm.jsp").forward(request, response);
				}
			}
	
	}


