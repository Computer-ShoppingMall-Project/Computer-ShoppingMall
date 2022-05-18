package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DButil;
import vo.order;
// import vo.Qna;

public class OrderDao {
   public int insertOrder(String customerId) {
	      int row = 0;
	      // DB 초기화
	      Connection conn = null;
	      PreparedStatement stmt = null;
	      // DButil
	      conn = DButil.getConnection();
	      // SQL 쿼리
	      String sql = "INSERT INTO `order` (basket_no, customer_id, category_name, category_number, category_price, category_quantity, create_date)"
	            + "   SELECT basket_no, customer_id, product_name, product_number, price, quantity, NOW()"
	            + "   FROM basket WHERE customer_id = ?";
	      try {
	         stmt = conn.prepareStatement(sql);
	         stmt.setString(1, customerId);
	         row = stmt.executeUpdate();
	         if(row > 0) {
					System.out.println("입력성공");
				} else {
					System.out.println("입력실패");
				}
	      } catch (SQLException e) {
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
	
	public ArrayList<order> selectOrderList(String customerId) {
		ArrayList<order> list = new ArrayList<order>();
		order checkout = null;
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
				+ " FROM order"
				+ " WHERE customer_id=?"
				+ " ORDER BY create_date";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customerId);
			rs = stmt.executeQuery();
			while(rs.next()) {
				checkout = new order();
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
