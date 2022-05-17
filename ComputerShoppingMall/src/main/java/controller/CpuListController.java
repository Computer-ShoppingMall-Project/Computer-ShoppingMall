package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CpuDao;
import vo.Cpu;
import java.util.*;

@WebServlet("/CpuListController")
public class CpuListController extends HttpServlet {

	private CpuDao cpuDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// CPU 체크박스 값(중복제거 데이터)
		cpuDao = new CpuDao();
		// compnay
		List<String> cpuKindList = cpuDao.duplicationCpuKind();
		// socketSize
		List<String> socketSizeList = cpuDao.duplicationSocketSize();
		// core
		List<String> coreList = cpuDao.duplicationCore();
		// thread
		List<String> threadList = cpuDao.duplicationThread();
		
		// 게시글 이름, 가격 받아오기
		List<Cpu> list = cpuDao.selectCpuList();		
		System.out.println("[CpuListController.doGet] : " + list.get(0).toString());
		
		// 값 셋팅 후 보내주기
		request.setAttribute("cpuKindList", cpuKindList);
		request.setAttribute("socketSizeList", socketSizeList);
		request.setAttribute("coreList", coreList);
		request.setAttribute("threadList", threadList);
		request.setAttribute("cpuList", list);
		request.getRequestDispatcher("/WEB-INF/view/cpuList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
