package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DButil;
import vo.Basket;

public class MyBasketDao {
	public Basket selectMyBasket(String customerId) {
		Basket basket = new Basket();
		// DB 초기화
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// DButil
		conn = DButil.getConnection();
		// SQL 쿼리
		String sql = "SELECT basket_no basketNo" 
				+ "						,customer_id customerId"	
				+ "						,category_name categoryName"	
				+ "						,category_number categoryNumber"
				+ "						,price"
				+ "						,quantity"
				+ "						,create_date createDate"
				+ "						,update_date updateDate"
				+ "			FROM basket"
				+ "			WHERE customer_id = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customerId);
			rs = stmt.executeQuery();
			if(rs.next()) {
				basket.setBasketNo(rs.getInt("basketNo"));
				basket.setCustomerId(rs.getString("customerId"));
				basket.setCategoryName(rs.getString("CategoryName"));
				basket.setCategoryNumber(rs.getInt("CategoryNumber"));
				basket.setPrice(rs.getInt("price"));
				basket.setQuantity(rs.getInt("quantity"));
				basket.setCreateDate(rs.getString("createDate"));
				basket.setUpdateDate(rs.getString("updateDate"));
			}
				} catch (Exception e) {
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
		return basket;
	}
}
