package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CoolerDao;
import vo.Cooler;

@WebServlet("/CoolerListController")
public class CoolerListController extends HttpServlet {
	
	private CoolerDao coolerDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		coolerDao = new CoolerDao();
		
		// cooler 이름, 가격 정보
		ArrayList<Cooler> coolerList = coolerDao.selectCoolerList();
		// company
		ArrayList<String> companyList = coolerDao.companyKind();
		// kind
		ArrayList<String> kindList = coolerDao.kindKind();
		// size
		ArrayList<String> sizeList = coolerDao.coolerSizeKind();
		
		request.setAttribute("coolerList", coolerList);
		request.setAttribute("companyList", companyList);
		request.setAttribute("kindList", kindList);
		request.setAttribute("sizeList", sizeList);
		request.getRequestDispatcher("/WEB-INF/view/nonCustomer/coolerList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
