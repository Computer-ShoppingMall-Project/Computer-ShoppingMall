package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// .
public class DButil {
	// DB연결 메서드(DB정보 수정에 용이하게하기위함)
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://52.78.238.26/computer","root","mariadb1234");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}