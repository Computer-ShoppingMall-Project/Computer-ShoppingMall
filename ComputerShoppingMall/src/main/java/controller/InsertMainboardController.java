package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import dao.InsertMainboardDao;
import vo.Mainboard;

@WebServlet("/InsertMainboardFromController")
public class InsertMainboardController extends HttpServlet {
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
		HttpSession session = request.getSession();
		String sessionCustomerId = (String)session.getAttribute("sessionCustomerId");
		// 로그인 상태가 아니거나 관리자아이디가 아니면 로그인창으로 이동
		if(sessionCustomerId != "admin123") {
			response.sendRedirect(request.getContextPath()+"/LoginController");
			return;
		}
		if(sessionCustomerId == null) {
			response.sendRedirect(request.getContextPath()+"/LoginController");
			return;
		}
		// 변수등록
		int mainboardNo = 0;
		String mainboardName = null;
		String mainboardKind = null;
		String socketSize = null;
		String chipSet = null;
		String ramVersion = null;
		int price = 0;
		String companyName = null;
		int quantity = 0;
		int mainboardImageNo = 0;
		String memo = null;
		
		// request값 받아오기
		if(request.getParameter("mainboardNo") != null && !"".equals(request.getParameter("mainboardNo"))) {
			mainboardNo = Integer.parseInt(request.getParameter("mainboard"));
		}
		if(request.getParameter("mainboardName") != null && !"".equals(request.getParameter("mainboardName"))) {
			mainboardName = request.getParameter("mainboardName");
		}
		if(request.getParameter("mainboardKind") != null && !"".equals(request.getParameter("mainboardKind"))) {
			mainboardKind = request.getParameter("mainboardKind");
		}
		if(request.getParameter("socketSize") != null && !"".equals(request.getParameter("socketSize"))) {
			socketSize = request.getParameter("socketSize");
		}
		if(request.getParameter("chipSet") != null && !"".equals(request.getParameter("chipSet"))) {
			chipSet = request.getParameter("chipSet");
		}
		if(request.getParameter("ramVersion") != null && !"".equals(request.getParameter("ramVersion"))) {
			ramVersion = request.getParameter("ramVersion");
		}
		if(request.getParameter("price") != null && !"".equals(request.getParameter("price"))) {
			price = Integer.parseInt(request.getParameter("price"));
		}
		if(request.getParameter("quantity") != null && !"".equals(request.getParameter("quantity"))) {
			quantity = Integer.parseInt(request.getParameter("quantity"));
		}
		if(request.getParameter("companyName") != null && !"".equals(request.getParameter("companyName"))) {
			companyName = request.getParameter("companyName");
		}
		if(request.getParameter("mainboardImageNo") != null && !"".equals(request.getParameter("mainboardImageNo"))) {
			mainboardImageNo = Integer.parseInt(request.getParameter("mainboardImageNo"));
		}
		if(request.getParameter("memo") != null && !"".equals(request.getParameter("memo"))) {
			memo = request.getParameter("memo");
		}
		
		// 디버깅
		System.out.println(mainboardNo+"<--mainboardNo");
		System.out.println(mainboardName+"<--mainboardName");
		System.out.println(mainboardKind+"<--mainboardKind");
		System.out.println(socketSize+"<--socketSize");
		System.out.println(chipSet+"<--chipSet");
		System.out.println(ramVersion+"<--ramVersion");
		System.out.println(price+"<--price");
		System.out.println(quantity+"<--quantity");
		System.out.println(companyName+"<--companyName");
		System.out.println(mainboardImageNo+"<--mainboardImageNo");
		System.out.println(memo+"<--memo");
		
		// 
		Mainboard m = new Mainboard();
		m.setMainboardNo(mainboardNo);
		m.setMainboardKind(mainboardKind);
		m.setSocketSize(socketSize);
		m.setChipset(chipSet);
		m.setRamVersion(ramVersion);
		m.setPrice(price);
		m.setQuantity(quantity);
		m.setCompanyName(companyName);
		m.setMainboardImageNo(mainboardImageNo);
		m.setMemo(memo);
		
		InsertMainboardDao insertMainboardDao = new InsertMainboardDao();
		insertMainboardDao.insertMainboard(m);
		
		response.sendRedirect(request.getContextPath() + "/DigitalDownloadController");
	}
}
