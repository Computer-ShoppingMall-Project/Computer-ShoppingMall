package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DButil;
import vo.Basket;

public class BasketDao {
	public int deleteMyBasktet(int basketNo) {
		// DB변수 기본값(null)으로 선언
		Connection conn = null;
		PreparedStatement stmt = null;
		int row = 0;
		conn = DButil.getConnection(); // DB연결 static 메서드 값 셋팅
		String sql = "DELETE basket FROM WHERE basket_no =?";
		try {
			stmt = conn.prepareStatement(sql); // sql 쿼리 셋팅
			stmt.setInt(1, basketNo); 
			stmt.executeUpdate(); // row에 입력 성공여부 값 대입
			if(row > 0) {
				System.out.println("입력성공");
			} else {
				System.out.println("입력실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	public int paymentDeleteMyBasket(String customerId) {
		// DB변수 기본값(null)으로 선언
		Connection conn = null;
		PreparedStatement stmt = null;
		int row = 0;
		conn = DButil.getConnection(); // DB연결 static 메서드 값 셋팅
		String sql = "DELETE b"
				+ " FROM basket b INNER JOIN checkout c"
				+ "	ON b.customer_id = c.customer_id "
				+ " WHERE c.customer_id=? ";
		try {
			stmt = conn.prepareStatement(sql); // sql 쿼리 셋팅
			stmt.setString(1, customerId); // customer_id = ?
			stmt.executeUpdate(); // row에 입력 성공여부 값 대입
			if(row > 0) {
				System.out.println("입력성공");
			} else {
				System.out.println("입력실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB 자원반납
				stmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
		
	}
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
				+ "						,product_name productName"
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
				basket.setProductName(rs.getString("productName"));
				basket.setCategoryName(rs.getString("categoryName"));
				basket.setPrice(rs.getInt("categoryPrice"));
				basket.setQuantity(rs.getInt("categoryQuantity"));
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
