package controller;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CaseDao;
import dao.CpuDao;
import dao.GpuDao;
import vo.Case;
import vo.Cpu;
import vo.Gpu;
@WebServlet("/UpdateGpuController")
public class UpdateGpuController extends HttpServlet {
   private GpuDao gpuDao;
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // 세션확인
            HttpSession session = request.getSession();
            if((String)session.getAttribute("sessionAdminId") == null) {
               // 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
               response.sendRedirect(request.getContextPath() + "/LoginController");
               return;
            }
            
            // dao
            gpuDao = new GpuDao();
            // vo
            Gpu g = new Gpu();
            if(request.getParameter("gpuNo") != null ){
               int gpuNo = Integer.parseInt(request.getParameter("gpuNo"));
               System.out.println(gpuNo+"<-gpuNo UpdateGpuController.doget");
               g = gpuDao.selectGpuOne(gpuNo);
               request.setAttribute("gpuOne", g);
               request.getRequestDispatcher("/WEB-INF/view/admin/updateGpuForm.jsp").forward(request, response);
               }
            }
      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // 세션확인
            HttpSession session = request.getSession();
            if((String)session.getAttribute("sessionAdminId") == null) {
               // 로그인이 되어있지 않은 상태 -> 로그인 폼으로 돌아가기
               response.sendRedirect(request.getContextPath() + "/LoginController");
               return;
            }
      
            // 요청값 처리
            
            String gpuName = request.getParameter("gpuName");
            String companyName = request.getParameter("companyName");
            String categoryName = request.getParameter("categoryName");
            String chipsetCompany = request.getParameter("chipsetCompany");
            int gpuSize = Integer.parseInt(request.getParameter("gpuSize"));
            int gpuNo = Integer.parseInt(request.getParameter("gpuNo"));
            int price = Integer.parseInt(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String memo = request.getParameter("memo");
            
      // vo
            Gpu g = new Gpu();
            g.setGpuNo(gpuNo);
            g.setGpuName(gpuName);
            g.setCompanyName(companyName);
            g.setCategoryName(categoryName);
            g.setChipsetCompany(chipsetCompany);
            g.setGpuSize(gpuSize);
            g.setPrice(price);
            g.setQuantity(quantity);
            g.setMemo(memo);   
      
      // 디버깅
            System.out.println("[updateGpuController] : " + g.toString());
      
      // dao
            gpuDao = new GpuDao();
            int row= gpuDao.updateGpu(g);
            if (row == 1) { // update 수정 성공 시, 수정성공된 상세보기 페이지로 이동
            	System.out.println("[updateGpuController.dopost] :"+ g.toString());
            	response.sendRedirect(request.getContextPath()+"/adController");
            }
               }
            
            }
