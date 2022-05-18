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
		
		request.setAttribute("gpuList", gpuList);
		request.setAttribute("companyList", companyList);
		request.setAttribute("chipsetCompanyList", chipsetCompanyList);
		request.setAttribute("gpuSizeList", gpuSizeList);
		request.getRequestDispatcher("/WEB-INF/nonCustomer/gpuList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
