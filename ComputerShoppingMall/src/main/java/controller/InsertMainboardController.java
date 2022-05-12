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
		HttpSession session = request.getSession();
		String sessionCustomerId = (String)session.getAttribute("sessionCustomerId");
		System.out.println(sessionCustomerId+"<-sessionCustomerId");
		if(sessionCustomerId == null) {
			response.sendRedirect(request.getContextPath()+"/LoginController");
			return;
		}
		request.getRequestDispatcher("/WEB-INF/view/insertMainboardForm.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String sessionCustomerId = (String)session.getAttribute("sessionCustomerId");
		System.out.println(sessionCustomerId+"<-1111111111111111");
		// 로그인 상태가 아니면 로그인창으로 이동
		if(sessionCustomerId == null) {
			response.sendRedirect(request.getContextPath()+"/LoginController");
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
		
		// 디버깅
		System.out.println(mainboardName+"<--mainboardName");
		System.out.println(mainboardKind+"<--mainboardKind");
		System.out.println(socketSize+"<--socketSize");
		System.out.println(chipSet+"<--chipSet");
		System.out.println(ramVersion+"<--ramVersion");
		System.out.println(price+"<--price");
		System.out.println(quantity+"<--quantity");
		System.out.println(companyName+"<--companyName");
		System.out.println(memo+"<--memo");
		
		// 
		Mainboard m = new Mainboard();
		m.setMainboardName(mainboardName);
		m.setMainboardKind(mainboardKind);
		m.setSocketSize(socketSize);
		m.setChipset(chipSet);
		m.setRamVersion(ramVersion);
		m.setPrice(price);
		m.setQuantity(quantity);
		m.setCompanyName(companyName);
		m.setMemo(memo);
		
		mainboardDao = new MainboardDao();
		mainboardDao.insertMainboard(m);
		
		response.sendRedirect(request.getContextPath() + "/DigitalDownloadController");
	}
}
