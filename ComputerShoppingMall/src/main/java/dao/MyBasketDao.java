package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DButil;
import vo.Basket;

public class MyBasketDao {
	public ArrayList<Basket> selectMyBasket(String customerId) {
		ArrayList<Basket> list = new ArrayList<Basket>();
		Basket basket = null;
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
				+ "						,category_price categoryPrice"
				+ "						,category_quantity categoryQuantity"
				+ "						,create_date createDate"
				+ "						,update_date updateDate"
				+ "			FROM basket"
				+ "			WHERE customer_id = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customerId);
			rs = stmt.executeQuery();
			while(rs.next()) {
				basket = new Basket();
				basket.setBasketNo(rs.getInt("basketNo"));
				basket.setCustomerId(rs.getString("customerId"));
				basket.setCategoryName(rs.getString("categoryName"));
				basket.setCategoryNumber(rs.getInt("categoryNumber"));
				basket.setCategoryPrice(rs.getInt("categoryPrice"));
				basket.setCategoryQuantity(rs.getInt("categoryQuantity"));
				basket.setCreateDate(rs.getString("createDate"));
				basket.setUpdateDate(rs.getString("updateDate"));
				list.add(basket);
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
		return list;
	}
}
