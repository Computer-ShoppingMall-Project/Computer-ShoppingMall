package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/login/*")
public class LoginFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	    // 세션에서 customerId 받아오기 
		if(request instanceof HttpServletRequest) { // HttpServletRequest 변경가능하면 적용
			HttpServletRequest req = (HttpServletRequest)request;
			HttpSession session = req.getSession();
			String customerId = (String)session.getAttribute("sessionCustomerId");
			
			// 세션이 만료되었거나, 로그인이 풀렸거나 로그인이 되지 않은 상황일 경우 
			if(customerId == null) {
				if(response instanceof HttpServletResponse) {
					((HttpServletResponse)response).sendRedirect(req.getContextPath()+"/LoginController"); // 로그인 페이지로 이동
				} 
				return;
			}
	     }
	     chain.doFilter(request, response);
	}
}