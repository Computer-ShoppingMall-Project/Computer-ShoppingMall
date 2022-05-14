package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DButil;
import vo.Checkout;
import vo.Qna;

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
	
	public ArrayList<Checkout> selectCheckoutList(String customerId) {
		ArrayList<Checkout> list = new ArrayList<Checkout>();
		Checkout checkout = null;
		// DB 초기화
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		//  DBUtil
		conn = DButil.getConnection();
		String sql = "SELECT order_no orderNo"
				+ "		,customer_id customerId "
				+ "		,basket_no basketNo"
				+ "		,category_name categoryName"
				+ "		,category_price categoryPrice"
				+ "	 	,category_quantity categoryQuantity"
				+ "		,create_date createDate"
				+ " FROM checkout"
				+ " WHERE customer_id=?"
				+ " ORDER BY create_date";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customerId);
			rs = stmt.executeQuery();
			while(rs.next()) {
				checkout = new Checkout();
				checkout.setOrderNo(rs.getInt("orderNo"));
				checkout.setCustomerId(rs.getString("customerId"));
				checkout.setBasketNo(rs.getInt("basketNo"));
				checkout.setCategoryName(rs.getString("categoryName"));
				checkout.setCategoryPrice(rs.getInt("categoryPrice"));
				checkout.setCategoryQuantity(rs.getInt("categoryQuantity"));
				checkout.setCreateDate(rs.getString("createDate"));
				list.add(checkout);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
