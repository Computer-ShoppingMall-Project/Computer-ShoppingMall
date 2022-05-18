package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import dao.MainboardDao;
import vo.Mainboard;

@WebServlet("/InsertMainboardController")
public class InsertMainboardController extends HttpServlet {
	private MainboardDao mainboardDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		
		request.getRequestDispatcher("/WEB-INF/view/insertMainboardForm.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		
		// 변수등록
		String mainboardName = null;
		String mainboardKind = null;
		String socketSize = null;
		String chipSet = null;
		String ramVersion = null;
		int price = 0;
		int quantity = 0;
		String companyName = null;
		String memo = null;
		
		// request값 받아오기
		if(request.getParameter("mainboardName") != null || request.getParameter("mainboardName") !="") {
			mainboardName = request.getParameter("mainboardName");
		}
		if(request.getParameter("mainboardKind") != null ||request.getParameter("mainboardName") !="") {
			mainboardKind = request.getParameter("mainboardKind");
		}
		if(request.getParameter("socketSize") != null || request.getParameter("mainboardName") !="") {
			socketSize = request.getParameter("socketSize");
		}
		if(request.getParameter("chipSet") != null || request.getParameter("mainboardName") !="") {
			chipSet = request.getParameter("chipSet");
		}
		if(request.getParameter("ramVersion") != null || request.getParameter("mainboardName") !="") {
			ramVersion = request.getParameter("ramVersion");
		}
		if(request.getParameter("price") != null || request.getParameter("mainboardName") !="") {
			price = Integer.parseInt(request.getParameter("price"));
		}
		if(request.getParameter("companyName") != null || request.getParameter("mainboardName") !="") {
			companyName = request.getParameter("companyName");
		}
		if(request.getParameter("quantity") != null || request.getParameter("mainboardName") !="") {
			quantity = Integer.parseInt(request.getParameter("quantity"));
		}
		if(request.getParameter("memo") != null || request.getParameter("mainboardName") !="") {
			memo = request.getParameter("memo");
		}
		
		
		// vo
		Mainboard m = new Mainboard();
		m.setMainboardName(mainboardName);
		m.setCompanyName(companyName);
		m.setSocketSize(socketSize);
		m.setChipset(chipSet);
		m.setRamVersion(ramVersion);
		m.setPrice(price);
		m.setQuantity(quantity);
		m.setCompanyName(companyName);
		m.setMemo(memo);
		
		// 디버깅
		System.out.println("[insertCoolerController] : " + m.toString());
		
		// dao
		mainboardDao = new MainboardDao();
		mainboardDao.insertMainboard(m);
		
		response.sendRedirect(request.getContextPath() + "/DigitalDownloadController");
	}
}
