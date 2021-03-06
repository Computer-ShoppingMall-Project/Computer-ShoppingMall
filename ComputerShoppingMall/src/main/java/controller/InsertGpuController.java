package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.CpuDao;
import dao.GpuDao;
import vo.Cpu;
import vo.Gpu;
import vo.Image;

@WebServlet("/InsertGpuController")
public class InsertGpuController extends HttpServlet {
	private GpuDao gpuDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		gpuDao = new GpuDao();
		// 게시글 이름, 가격 받아오기
		ArrayList<Gpu> gpuList = gpuDao.selectGpuList();
		// company
		ArrayList<String> companyList = gpuDao.companyKind();
		// chipset_company
		ArrayList<String> chipsetCompanyList = gpuDao.chipsetCompanyKind();
		// gpu_size
		ArrayList<String> gpuSizeList = gpuDao.gpuSizeKind();
		
		
		// 값 세팅 후 보내주기
		request.setAttribute("gpuList", gpuList);
		request.setAttribute("companyList", companyList);
		request.setAttribute("chipsetCompanyList", chipsetCompanyList);
		request.setAttribute("gpuSizeList", gpuSizeList);
		request.getRequestDispatcher("/WEB-INF/view/admin/insertGpuForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}
		
		gpuDao = new GpuDao();
		// 게시글 이름, 가격 받아오기
		ArrayList<Gpu> gpuList = gpuDao.selectGpuList();
		// company
		ArrayList<String> companyList = gpuDao.companyKind();
		// chipset_company
		ArrayList<String> chipsetCompanyList = gpuDao.chipsetCompanyKind();
		// gpu_size
		ArrayList<String> gpuSizeList = gpuDao.gpuSizeKind();
		
		
		// Gpu image 경로지정
		String path = request.getSession().getServletContext().getRealPath("/image");
		System.out.println("[InsertGpuController.doPost photo path] : " + path); // 디버깅
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
		} else { // 이미지 등록 실패시, GpuListController로 이동
			System.out.println("[InsertGpuController] : 이미지 타입 아님");
			// 잘못 업로드 된 파일이므로 삭제 처리
			File file = new File(path + "\\" + name);
			file.delete();
			
			response.sendRedirect(request.getContextPath() + "/GpuListController");
			return;
		}

		// Form에 입력된 값 받는 코드
		String gpuName = multiReq.getParameter("gpuName");
		String companyName = null;
		if(multiReq.getParameter("companyNameInsert") != null  && !"".equals(multiReq.getParameter("companyNameInsert"))) {
			companyName = multiReq.getParameter("companyNameInsert");
		} else if(multiReq.getParameter("companyName") != null  && !"".equals(multiReq.getParameter("companyName"))) {
			companyName = multiReq.getParameter("companyName");
		}
		String categoryName = multiReq.getParameter("categoryName");
		String chipsetCompany = null;
		if(multiReq.getParameter("chipsetCompanyInsert") != null  && !"".equals(multiReq.getParameter("chipsetCompanyInsert"))) {
			chipsetCompany = multiReq.getParameter("chipsetCompanyInsert");
		} else if(multiReq.getParameter("chipsetCompany") != null  && !"".equals(multiReq.getParameter("chipsetCompany"))) {
			chipsetCompany = multiReq.getParameter("chipsetCompany");
		}
		int gpuSize = 0;
		
		if(multiReq.getParameter("gpuSizeInsert") != null  && !"".equals(multiReq.getParameter("gpuSizeInsert"))) {
			gpuSize = Integer.parseInt(multiReq.getParameter("gpuSizeInsert"));
		} else if(multiReq.getParameter("gpuSize") != null  && !"".equals(multiReq.getParameter("gpuSize"))) {
			gpuSize = Integer.parseInt(multiReq.getParameter("gpuSize")); 
		}
		
		int price = Integer.parseInt(multiReq.getParameter("price"));
		int quantity = Integer.parseInt(multiReq.getParameter("quantity"));
		String memo = multiReq.getParameter("memo");
		
		// vo.Gpu
		Gpu g = new Gpu();
		g.setGpuName(gpuName);
		g.setCompanyName(companyName);
		g.setCategoryName(categoryName);
		g.setChipsetCompany(chipsetCompany);
		g.setGpuSize(gpuSize);
		g.setPrice(price);
		g.setQuantity(quantity);
		g.setMemo(memo);
		
		// 디버깅
		System.out.println("[InsertGpuController] : " + i.toString());
		System.out.println("[InsertGpuController] : " + g.toString());
		
		// dao.insertGpu
		gpuDao = new GpuDao();
		int row = gpuDao.insertGpu(i, g);
		
		String msg = "";
		// 상품등록 성공/실패 확인 코드
		if (row == 1) {
			System.out.println("[InsertGpuController] : Gpu 등록 성공");
			request.setAttribute("gpuList", gpuList);
			request.setAttribute("companyList", companyList);
			request.setAttribute("chipsetCompanyList", chipsetCompanyList);
			request.setAttribute("gpuSizeList", gpuSizeList);
			request.getRequestDispatcher("/WEB-INF/view/nonCustomer/gpuList.jsp").forward(request, response);	
		} else {
			System.out.println("[InsertGpuController] : Gpu 등록 실패");
			msg = "에 실패했습니다.";
			// 값 셋팅 후 보내주기
			request.setAttribute("msg", msg);
			request.setAttribute("companyList", companyList);
			request.setAttribute("chipsetCompanyList", chipsetCompanyList);
			request.setAttribute("gpuSizeList", gpuSizeList);
			request.getRequestDispatcher("/WEB-INF/view/admin/insertGpuForm.jsp").forward(request, response);
		}
	}
}