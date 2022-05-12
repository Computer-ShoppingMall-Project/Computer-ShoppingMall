package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// .
public class DButil {
	// DB연결 메서드
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/computer","root","java1234");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return conn;
	}
}