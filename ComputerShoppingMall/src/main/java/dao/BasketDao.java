package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DButil;
import vo.Basket;

public class BasketDao {
	// 장바구니 담기
	public int insertMyBasket(String customerId,Basket basket) {
		// DB변수 기본값(null)으로 선언
		Connection conn = null;
		PreparedStatement stmt = null;
		int row = 0;
		conn = DButil.getConnection(); // DB연결 static 메서드 값 셋팅
		String sql = "INSERT INTO basket (customer_id, product_name, category_name, product_number, price, quantity, create_date, update_date) VALUES (?,?,?,?,?,?,now(),now())";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customerId);
			stmt.setString(2, basket.getProductName());
			stmt.setString(3, basket.getCategoryName());
			stmt.setInt(4, basket.getProductNumber());
			stmt.setInt(5, basket.getPrice());
			stmt.setInt(6, basket.getQuantity());
			row = stmt.executeUpdate();
			if(row > 0) {
				System.out.println("입력성공");
			} else {
				System.out.println("입력실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	// 장바구니 삭제 코드
	public int deleteMyBasket(int basketNo) {
		// DB변수 기본값(null)으로 선언
		Connection conn = null;
		PreparedStatement stmt = null;
		int row = 0;
		conn = DButil.getConnection(); // DB연결 static 메서드 값 셋팅
		String sql = "DELETE FROM basket WHERE basket_no=?";
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
	// 장바구니 수랑 수정 코드
	public int updateMyBasket(int quantity, int basketNo) {
		// DB변수 기본값(null)으로 선언
		Connection conn = null;
		PreparedStatement stmt = null;
		int row = 0;
		conn = DButil.getConnection(); // DB연결 static 메서드 값 셋팅
		String sql = "UPDATE basket SET quantity=? WHERE basket_no=?";
		try {
			stmt = conn.prepareStatement(sql); // sql 쿼리 셋팅
			stmt.setInt(1, quantity); 
			stmt.setInt(2, basketNo); 
			row = stmt.executeUpdate(); // row에 입력 성공여부 값 대입
			if(row > 0) {
				System.out.println("수정성공");
			} else {
				System.out.println("수정실패");
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
	// 결제 후, 장바구니 삭제 코드
	public int paymentDeleteMyBasket(String customerId) {
		// DB변수 기본값(null)으로 선언
		Connection conn = null;
		PreparedStatement stmt = null;
		int row = 0;
		conn = DButil.getConnection(); // DB연결 static 메서드 값 셋팅
		String sql = "DELETE b"
				+ " FROM basket b INNER JOIN `order` o"
				+ "	ON b.customer_id = o.customer_id "
				+ " WHERE o.customer_id=? ";
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
				+ "						,product_name productName"
				+ "						,category_name categoryName"	
				+ "						,product_number productNumber"
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
			while(rs.next()) {
				basket = new Basket();
				basket.setBasketNo(rs.getInt("basketNo"));
				basket.setCustomerId(rs.getString("customerId"));
				basket.setProductName(rs.getString("productName"));
				basket.setCategoryName(rs.getString("categoryName"));
				basket.setProductNumber(rs.getInt("productNumber"));
				basket.setPrice(rs.getInt("price"));
				basket.setQuantity(rs.getInt("quantity"));
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
	// 장바구니 수량 count(화면 상단)
	public int basketTotalCount(String customerId) {
		int count = 0;
		// DB 초기화
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		String sql = "SELECT COUNT(*) cnt"
				+ " FROM basket"
				+ " WHERE customer_id=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customerId);
			rs = stmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("cnt"); // 수량 적용
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
		return count;
	}
}
