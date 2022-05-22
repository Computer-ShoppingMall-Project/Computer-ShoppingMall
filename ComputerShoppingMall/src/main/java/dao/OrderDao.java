package dao;

import java.sql.*;
import java.util.*;

import util.DButil;
import vo.Order;
// import vo.Qna;

public class OrderDao {
	// 결제
	public int insertOrder(String customerId) {
		int row = 0;
		// DB 초기화
		Connection conn = null;
		PreparedStatement stmt = null;
		// DButil
		conn = DButil.getConnection();
		// SQL 쿼리
		String orderSql = "INSERT INTO `order` (basket_no, customer_id, category_name, category_number, category_price, category_quantity, create_date)"
				+ "   SELECT basket_no, customer_id, product_name, product_number, price, quantity, NOW()"
				+ "   FROM basket WHERE customer_id = ?";
		String deleteBasketSql = "DELETE b"
				+ " FROM basket b INNER JOIN `order` o"
				+ "	ON b.customer_id = o.customer_id "
				+ " WHERE o.customer_id=? ";
		try {
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(orderSql);
			stmt.setString(1, customerId);
			row = stmt.executeUpdate();
			stmt.close();
			
			// 장바구니 삭제
			stmt = conn.prepareStatement(deleteBasketSql); // sql 쿼리 셋팅
			stmt.setString(1, customerId); // customer_id = ?
			stmt.executeUpdate(); // row에 입력 성공여부 값 대입
			if(row > 0) {
				conn.commit();
				System.out.println("입력성공");
			} else {
				System.out.println("입력실패");
			}
		} catch (Exception e) {
			try {
				conn.rollback(); // 오류 발생시, rollback
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
      }      
      return row;
   }
	// 회원별 주문내역 상세보기
	public ArrayList<Order> selectOrderList(String customerId, String createDate) {
		ArrayList<Order> list = new ArrayList<Order>();
		Order checkout = null;
		// DB 초기화
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		//  DBUtil
		conn = DButil.getConnection();
		String sql = "SELECT order_no orderNo"
				+ "		,customer_id customerId "
				+ "		,basket_no basketNo"
				+ "		,category_number categoryNumber"
				+ "		,category_name categoryName"
				+ "		,product_name productName"
				+ "		,category_price categoryPrice"
				+ "	 	,category_quantity categoryQuantity"
				+ "		,create_date createDate"
				+ "		,order_status orderStatus"
				+ " FROM `order`"
				+ " WHERE customer_id = ? AND create_date = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customerId);
			stmt.setString(2, createDate);
			rs = stmt.executeQuery();
			while(rs.next()) {
				checkout = new Order();
				checkout.setOrderNo(rs.getInt("orderNo"));
				checkout.setCustomerId(rs.getString("customerId"));
				checkout.setBasketNo(rs.getInt("basketNo"));
				checkout.setCategoryNumber(rs.getInt("categoryNumber"));
				checkout.setCategoryName(rs.getString("categoryName"));
				checkout.setCategoryPrice(rs.getInt("categoryPrice"));
				checkout.setCategoryQuantity(rs.getInt("categoryQuantity"));
				checkout.setCreateDate(rs.getString("createDate"));
				checkout.setOrderStatus(rs.getString("orderStatus"));
				checkout.setProductName(rs.getString("productName"));
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
	// 날짜별로 주문 총액 확인 (MyPaymentController)
	public List<Map<String, Object>> selectOrderDateList(String customerId) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// DB 초기화
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		//  DBUtil
		conn = DButil.getConnection();
		String sql = "SELECT customer_id customerId"
				+ "		,create_date createDate"
				+ "		,SUM(o.category_price) totalPrice"
				+ " FROM `order` o"
				+ " WHERE customer_id=?"
				+ " GROUP BY o.create_date"
				+ " ORDER BY o.create_date DESC";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customerId);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("customerId", rs.getString("customerId"));
				map.put("createDate", rs.getString("createDate"));
				map.put("totalPrice", rs.getString("totalPrice"));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	// 관리자 주문 모아보기 리스트
	public ArrayList<Order> adminOrderList() {
		ArrayList<Order> list = new ArrayList<Order>();
		// DB 변수 선언
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		String sql = "SELECT"
				+ "	o.order_no orderNo"
				+ "	, o.customer_id customerId"
				+ "	, o.basket_no basketNo"
				+ "	, o.product_name productName"
				+ "	, o.category_name categoryName"
				+ "	, o.category_number categoryNumber"
				+ "	, o.category_price categoryPrice"
				+ "	, o.category_quantity categoryQuantity"
				+ "	, o.create_date createDate"
				+ " , o.order_status orderStatus"
				+ "	, COUNT(*) cnt"
				+ " FROM `order` o"
				+ " GROUP BY customer_id, create_date"
				+ " ORDER BY o.create_date DESC";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Order o = new Order();
				o.setOrderNo(rs.getInt("orderNo"));
				o.setCustomerId(rs.getString("customerId"));
				o.setBasketNo(rs.getInt("basketNo"));
				o.setCategoryNumber(rs.getInt("categoryNumber"));
				o.setCategoryName(rs.getString("categoryName"));
				o.setCategoryPrice(rs.getInt("categoryPrice"));
				o.setCategoryQuantity(rs.getInt("categoryQuantity"));
				o.setCreateDate(rs.getString("createDate"));
				o.setOrderStatus(rs.getString("orderStatus"));
				o.setProductName(rs.getString("productName"));
				o.setProductCount(rs.getInt("cnt"));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
