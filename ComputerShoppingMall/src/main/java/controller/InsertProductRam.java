package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.*;

import vo.Ram;
@WebServlet("/InsertProductRam")
public class InsertProductRam extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ram 값 받아오기
		String ramName = null;
		String companyName = null;
		String ramKind = null;
		int price = 0;
		int quantity = 0;
		int ramImageNo = 0;
		String memo = null;
		String updateDate = null;
		
		if(!"".equals(request.getParameter("ramName")) && request.getParameter("ramName") != null) {
			ramName = request.getParameter("ramName");
		}
		if(!"".equals(request.getParameter("companyName")) && request.getParameter("companyName") != null) {
			companyName = request.getParameter("companyName");
		}
		if(!"".equals(request.getParameter("ramKind")) && request.getParameter("ramKind") != null) {
			ramKind = request.getParameter("ramKind");
		}
		if(!"".equals(request.getParameter("price")) && request.getParameter("price") != null) {
			price = Integer.parseInt(request.getParameter("price"));
		}
		if(!"".equals(request.getParameter("quantity")) && request.getParameter("quantity") != null) {
			quantity =Integer.parseInt(request.getParameter("quantity"));
		}
		if(!"".equals(request.getParameter("ramImageNo")) && request.getParameter("ramImageNo") != null) {
			ramImageNo =Integer.parseInt(request.getParameter("ramImageNo"));
		}
		if(!"".equals(request.getParameter("memo")) && request.getParameter("memo") != null) {
			memo = request.getParameter("memo");
		}
		Ram ram = new Ram();
		ram.setRamName(ramName);
		ram.setCompanyName(companyName);
		ram.setRamKind(ramKind);
		ram.setPrice(price);
		ram.setQuantity(quantity);
		ram.setRamImageNo(ramImageNo);
		
		InsertProductRamDao insertProductRamDao = new InsertProductRamDao();
		insertProductRamDao.insertProductRam(ram);
		
		// 등록되면 상품페이지로
		response.sendRedirect(request.getContextPath()+"/DigitalDownloadController");
	}
}
