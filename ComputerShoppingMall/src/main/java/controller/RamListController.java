package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RamDao;
import vo.Ram;

@WebServlet("/RamListController")
public class RamListController extends HttpServlet {

	private RamDao ramDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ramDao = new RamDao();
		// ram 제목, 가격 
		ArrayList<Ram> rmaList = ramDao.selectRamList();
		// COMPANY
		ArrayList<String> companyList = ramDao.companyKind();
		// KIND
		ArrayList<String> kindList = ramDao.kindKind();
		
		request.setAttribute("ramList", rmaList);
		request.setAttribute("companyList", companyList);
		request.setAttribute("kindList", kindList);
	
		request.getRequestDispatcher("/WEB-INF/view/nonCustomer/ramList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
