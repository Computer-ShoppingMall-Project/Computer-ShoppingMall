package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GpuDao;
import vo.Gpu;

@WebServlet("/GpuListController")
public class GpuListController extends HttpServlet {

	private GpuDao gpuDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		gpuDao = new GpuDao();
		// gpu 상세보기(제목, 가격)
		ArrayList<Gpu> gpuList = gpuDao.selectGpuList();
		// company
		ArrayList<String> companyList = gpuDao.companyKind();
		// chipset_company
		ArrayList<String> chipsetCompanyList = gpuDao.chipsetCompanyKind();
		// gpu_size
		ArrayList<String> gpuSizeList = gpuDao.gpuSizeKind();
		
		int count = gpuList.size(); // 상품 개수(0개일시, 조건해당 상품 없다는 메세지 띄우기 용도 + 개수 표시)
		
		request.setAttribute("gpuList", gpuList);
		request.setAttribute("companyList", companyList);
		request.setAttribute("chipsetCompanyList", chipsetCompanyList);
		request.setAttribute("gpuSizeList", gpuSizeList);
		request.setAttribute("count", count);
		request.getRequestDispatcher("/WEB-INF/view/nonCustomer/gpuList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// String[]로 다중선택값 저장(체크박스)
		String[] companyName = request.getParameterValues("companyName");
		String[] chipsetCompany = request.getParameterValues("chipsetCompany");
		String[] gpuSize = request.getParameterValues("gpuSize");
		
		String search = request.getParameter("search"); // 검색어 받아오기
		
		gpuDao = new GpuDao();
		// gpu 상세검색 리스트
		ArrayList<Gpu> gpuList = gpuDao.gpuDetailSearch(companyName, chipsetCompany, gpuSize, search);
		
		// 체크박스
		ArrayList<String> companyList = gpuDao.companyKind(); // company
		ArrayList<String> chipsetCompanyList = gpuDao.chipsetCompanyKind(); // chipset_company
		ArrayList<String> gpuSizeList = gpuDao.gpuSizeKind(); // gpu_size
		
		int count = gpuList.size(); // 상품 개수(0개일시, 조건해당 상품 없다는 메세지 띄우기 용도 + 개수 표시)
		
		// 값 셋팅 후 보내주기
		request.setAttribute("gpuList", gpuList);
		request.setAttribute("companyList", companyList);
		request.setAttribute("chipsetCompanyList", chipsetCompanyList);
		request.setAttribute("gpuSizeList", gpuSizeList);
		request.setAttribute("count", count);
		// 체크여부 확인
		request.setAttribute("companyName", companyName);
		request.setAttribute("chipsetCompany", chipsetCompany);
		request.setAttribute("gpuSize", gpuSize);
		// 검색어 유지
		request.setAttribute("search", search);
		
		request.getRequestDispatcher("/WEB-INF/view/nonCustomer/gpuList.jsp").forward(request, response);
	}
}
