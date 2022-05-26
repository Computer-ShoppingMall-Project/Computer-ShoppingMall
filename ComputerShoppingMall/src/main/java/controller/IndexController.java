package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDao;

@WebServlet("/IndexController")
public class IndexController extends HttpServlet {
	private OrderDao orderDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// 상품 몇순위까지 보여줄껀지
		int cpuRanking = 3; // 디폴트3개
		int caseRanking = 3;
		int coolerRanking = 3;
		int gpuRanking = 3;
		int mainboardRanking = 3;
		int powerRanking = 3;
		int ramRanking = 3;
		int storageRanking = 3;
		orderDao = new OrderDao();
		List<Map<String, Object>> cpuRank = orderDao.rankCpuImage(cpuRanking);
		List<Map<String, Object>> caseRank = orderDao.rankCaseImage(caseRanking);
		List<Map<String, Object>> coolerRank = orderDao.rankCoolerImage(coolerRanking);
		List<Map<String, Object>> gpuRank = orderDao.rankGpuImage(gpuRanking);
		List<Map<String, Object>> mainboardRank = orderDao.rankMainboardImage(mainboardRanking);
		List<Map<String, Object>> powerRank = orderDao.rankPowerImage(powerRanking);
		List<Map<String, Object>> ramRank = orderDao.rankRamImage(ramRanking);
		List<Map<String, Object>> storageRank = orderDao.rankStorageImage(storageRanking);
		// set
		request.setAttribute("cpuRank",cpuRank);
		request.setAttribute("caRank",caseRank);
		request.setAttribute("coolerRank",coolerRank);
		request.setAttribute("gpuRank",gpuRank);
		request.setAttribute("mainboardRank",mainboardRank);
		request.setAttribute("powerRank",powerRank);
		request.setAttribute("ramRank",ramRank);
		request.setAttribute("storageRank",storageRank);
		
		request.getRequestDispatcher("/WEB-INF/view/nonCustomer/index.jsp").forward(request, response);
	}
}