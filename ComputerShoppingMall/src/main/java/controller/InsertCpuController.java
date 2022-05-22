package controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.CpuDao;
import vo.Cpu;
import vo.Image;

@WebServlet("/InsertCpuController")
public class InsertCpuController extends HttpServlet {
	private CpuDao cpuDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		
		request.getRequestDispatcher("/WEB-INF/view/admin/insertCpuForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		request.getRequestDispatcher("/WEB-INF/view/admin/insertCpuForm.jsp").forward(request, response);
		
		// Cpu image 경로지정
		String path = request.getSession().getServletContext().getRealPath("/image");
		System.out.println("[InsertCpuController.doPost photo path] : " + path); // 디버깅 
		// 사진 파일 처리
		MultipartRequest multiReq = new MultipartRequest(request, path, 1024 * 1024 * 100, "utf-8", new DefaultFileRenamePolicy());
		// 사진 받아오기
		String originalName = multiReq.getOriginalFileName("image"); // 사진 원본 이름
		String name = multiReq.getFilesystemName("image"); // 중복 발생 시 변경된 이름
		String type = multiReq.getContentType("image");
		Image i = null;
		
		// 이미지 형태라면 하나의 변수로 묶기
		if (type.equals("image/gif") || type.equals("image/png") || type.equals("image/jpeg")) { 
			// 하나의 변수로 묶어주기 -> DB 저장용
			i = new Image();
			i.setOriginalName(originalName);
			i.setName(name);
			i.setType(type);
		} else { // 이미지 등록 실패시, CpuListController로 이동
			System.out.println("[InsertCpuController] : 이미지 타입 아님");
			// 잘못 업로드 된 파일이므로 삭제 처리
			File file = new File(path + "\\" + name);
			file.delete();
			
			response.sendRedirect(request.getContextPath() + "/CpuListController");
			return;
		}

		// Form에 입력된 값 받는 코드
		String cpuName = multiReq.getParameter("cpuName");
		String companyName = multiReq.getParameter("companyName");
		String categoryName = multiReq.getParameter("categoryName");
		String socketSize = multiReq.getParameter("socketSize");
		String core = multiReq.getParameter("core");
		String thread = multiReq.getParameter("thread");
		int price = Integer.parseInt(multiReq.getParameter("price"));
		int quantity = Integer.parseInt(multiReq.getParameter("quantity"));
		String memo = multiReq.getParameter("memo");
		// vo.Cpu
		Cpu c = new Cpu();
		c.setCpuName(cpuName);
		c.setCompanyName(companyName);
		c.setCategoryName(categoryName);
		c.setSocketSize(socketSize);
		c.setCore(core);
		c.setThread(thread);
		c.setPrice(price);
		c.setQuantity(quantity);
		c.setMemo(memo);
		// 디버깅
		System.out.println("[InsertCpuController] : " + i.toString());
		System.out.println("[InsertCpuController] : " + c.toString());
		
		// dao.insertCpu
		cpuDao = new CpuDao();
		int row = cpuDao.insertCpu(i, c);
		
		// 상품등록 성공/실패 확인 코드
		if (row == 1) {
			System.out.println("[InsertCpuController] : Cpu 등록 성공");
		} else {
			System.out.println("[InsertCpuController] : Cpu 등록 실패");
		}
	}
}
