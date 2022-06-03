package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GpuDao;
import vo.Gpu;

@WebServlet("/UpdateGpuController")
public class UpdateGpuController extends HttpServlet {
   private GpuDao gpuDao;
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if ((String) session.getAttribute("sessionAdminId") == null) {
			// 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
			response.sendRedirect(request.getContextPath() + "/LoginController");
			return;
		}

		// dao
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
		// vo
		Gpu g = new Gpu();
		if (request.getParameter("gpuNo") != null) {
			int gpuNo = Integer.parseInt(request.getParameter("gpuNo"));
			System.out.println(gpuNo + "<-gpuNo UpdateGpuController.doget");
			g = gpuDao.selectGpuOne(gpuNo);
			
			request.setAttribute("gpu", g);
			request.getRequestDispatcher("/WEB-INF/view/admin/updateGpuForm.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 세션확인
		HttpSession session = request.getSession();
		if ((String) session.getAttribute("sessionAdminId") == null) {
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

		// Form에 입력된 값 받는 코드
		String gpuName = request.getParameter("gpuName");
		String companyName = null;
		if (request.getParameter("companyNameInsert") != null && !"".equals(request.getParameter("companyNameInsert"))) {
			companyName = request.getParameter("companyNameInsert");
		} else if (request.getParameter("companyName") != null && !"".equals(request.getParameter("companyName"))) {
			companyName = request.getParameter("companyName");
		}
		String categoryName = request.getParameter("categoryName");
		String chipsetCompany = null;
		if (request.getParameter("chipsetCompanyInsert") != null && !"".equals(request.getParameter("chipsetCompanyInsert"))) {
			chipsetCompany = request.getParameter("chipsetCompanyInsert");
		} else if (request.getParameter("chipsetCompany") != null && !"".equals(request.getParameter("chipsetCompany"))) {
			chipsetCompany = request.getParameter("chipsetCompany");
		}
		int gpuSize = 0;
		if (request.getParameter("gpuSizeInsert") != null && !"".equals(request.getParameter("gpuSizeInsert"))) {
			gpuSize = Integer.parseInt(request.getParameter("gpuSizeInsert"));
		} else if (request.getParameter("gpuSize") != null && !"".equals(request.getParameter("gpuSize"))) {
			gpuSize = Integer.parseInt(request.getParameter("gpuSize"));
		}

		int price = Integer.parseInt(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int gpuImageNo = Integer.parseInt(request.getParameter("gpuImageNo"));
		String memo = request.getParameter("memo");
		int gpuNo = Integer.parseInt(request.getParameter("gpuNo"));

		// vo.Gpu
		Gpu g = new Gpu();
		g.setGpuName(gpuName);
		g.setCompanyName(companyName);
		g.setCategoryName(categoryName);
		g.setChipsetCompany(chipsetCompany);
		g.setGpuSize(gpuSize);
		g.setPrice(price);
		g.setGpuImageNo(gpuImageNo);
		g.setQuantity(quantity);
		g.setMemo(memo);
		g.setGpuNo(gpuNo);
		
		// 디버깅
		System.out.println("[updateGpuController] : " + g.toString());
		
		int row = gpuDao.updateGpu(g);
		System.out.print(row + " <-- row UpdateGpuController.dopost"); // 디버깅
		 
		String msg = "";
		// 상품수정 성공/실패 확인 코드
		if (row == 1) {
			System.out.println("[UpdateGpuController] : Gpu 수정 성공");
			request.setAttribute("msg", msg);
			request.setAttribute("gpuList", gpuList);
			request.setAttribute("companyList", companyList);
			request.setAttribute("chipsetCompanyList", chipsetCompanyList);
			request.setAttribute("gpuSizeList", gpuSizeList);
			request.getRequestDispatcher("/WEB-INF/view/nonCustomer/gpuList.jsp").forward(request, response);	
		} else {
			System.out.println("[UpdateGpuController] : Gpu 수정 실패");
			msg = "에 실패했습니다.";
			// 값 셋팅 후 보내주기
			request.setAttribute("msg", msg);
			request.setAttribute("gpuList", gpuList);
			request.setAttribute("companyList", companyList);
			request.setAttribute("chipsetCompanyList", chipsetCompanyList);
			request.setAttribute("gpuSizeList", gpuSizeList);
			request.getRequestDispatcher("/WEB-INF/view/admin/updateGpuForm.jsp").forward(request, response);
		}	

	}

}
