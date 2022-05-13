package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DriverListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce)  { 
    	// 서버 실행시, 드라이버로딩
        try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("[DriverListener] : DB드라이버 로딩");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
}
