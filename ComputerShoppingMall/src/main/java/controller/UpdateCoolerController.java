package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CaseDao;
import dao.CoolerDao;
import vo.Case;
import vo.Cooler;

@WebServlet("/UpdateCoolerController")
public class UpdateCoolerController extends HttpServlet {
	private CoolerDao coolerDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/deleteCoolerForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 변수등록
		int coolerNo = 0;
		int price = 0;
		int quantity = 0;
		
		// request값 받기
		if(request.getParameter("coolerNo")!= null && request.getParameter("coolerNo") != "") {
			coolerNo = Integer.parseInt(request.getParameter("coolerNo"));
		}
		if(request.getParameter("price")!= null && request.getParameter("price") != "") {
			price = Integer.parseInt(request.getParameter("price"));
		}
		if(request.getParameter("quantity")!= null && request.getParameter("quantity") != "") {
			quantity = Integer.parseInt(request.getParameter("quantity"));
		}
		
		// 디버깅
		System.out.println(coolerNo+"<-coolerNo");
		System.out.println(price+"<-price");
		System.out.println(quantity+"<-quantity");
		
		// vo
		Cooler c = new Cooler();
		c.getCoolerNo();
		c.getPrice();
		c.getQuantity();
		
		// dao
		coolerDao = new CoolerDao();
		coolerDao.updateCooler(c);
		
		response.sendRedirect(request.getContextPath()+"/DigitalDownloadController");
	}

}
