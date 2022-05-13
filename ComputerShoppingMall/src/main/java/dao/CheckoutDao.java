package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DButil;
import vo.Checkout;

public class CheckoutDao {
	public int insertCheckout(Checkout checkout) {
		int row = -1;
		// DB 초기화
		Connection conn = null;
		PreparedStatement stmt = null;
		// DButil
		conn = DButil.getConnection();
		// SQL 쿼리
		String sql = "INSERT INTO checkout (basket_no, customer_id, category_name, category_number, category_price, category_quantity, create_date)"
				+ "SELECT basket_no, customer_id, category_name, category_number, category_price, category_quantity, NOW()"
				+ "FROM basket"
				+ "WHERE customer_id = ?"
				+ "ORDER BY create_date";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, checkout.getBasketNo());
			stmt.setString(2, checkout.getCustomerId());
			stmt.setString(3, checkout.getCategoryName());
			stmt.setInt(4, checkout.getCategoryNumber());
			stmt.setInt(5, checkout.getCategoryPrice());
			stmt.setInt(6, checkout.getCategoryQuantity());
			stmt.setString(7, checkout.getCreateDate());
			row = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}		
		return row;
	}
}
