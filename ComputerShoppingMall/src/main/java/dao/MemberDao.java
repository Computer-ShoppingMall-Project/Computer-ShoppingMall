package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DButil;
import vo.Customer;

public class MemberDao {
	
	// 1) 로그인 page
	public String selectMemberByIdPw(Customer member) {
		// 로그인 실패 -> null
		String customerId = null; 
		// DB 초기화
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// DButil
		conn = DButil.getConnection();
		// SQL 쿼리
		String sql = " SELECT * FROM customer "
				+ "WHERE customer_id=? AND customer_pw=PASSWORD(?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getCustomerId());
			stmt.setString(2, member.getCustomerPw());
			rs =stmt.executeQuery();
			if(rs.next()) {
				customerId = rs.getString("customer_id");
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
		return customerId;
	}
	
	// 2) 회원 정보 상세보기 page
	public Customer selectMemberOne(String customerId) {
		Customer c = new Customer();
		// DB 초기화
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// DButil
		conn = DButil.getConnection();
		String sql = "SELECT customer_id customerId"
				+ "					,name"
				+ "					,nickname"
				+ "					,email"
				+ "					,phone"
				+ "					,address_id addressId"
				+ "					,detail_address detailAddress"
				+ "					,create_date createDate"
				+ "					,update_date updateDate"
				+ "		 FROM customer "
				+ "		 WHERE customer_id=? ";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customerId);
			rs = stmt.executeQuery();
			if(rs.next()) {
				c.setCustomerId(rs.getString("customerId"));
				c.setName(rs.getString("name"));
				c.setNickname(rs.getString("nickname"));
				c.setEmail(rs.getString("email"));
				c.setPhone(rs.getString("phone"));
				c.setAddressId(rs.getInt("addressId"));
				c.setDetailAddress(rs.getString("detailAddress"));
				c.setCreateDate(rs.getString("createDate"));
				c.setUpdateDate(rs.getString("updateDate"));
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
		return c;
	}
	
	// 3) 일반 회원 가입 page
	public int insertMember(Customer member) {
		// 회원 가입 성공 여부 리턴할 정수형 변수 선언
		int row = -1; 
		// 로그인 실패시, 처리 코드 -> memberId = null
		String customerId = null; 
		// DB 초기화
		Connection conn = null;
		PreparedStatement stmt = null;
		// DButil
		conn = DButil.getConnection();
		String sql = "INSERT INTO customer (customer_id"
				+ "						   ,customer_pw"
				+ " 					   ,name"
				+ "						   ,nickname"
				+ "						   ,email"
				+ "						   ,phone"
				+ "						   ,address_id"
				+ "						   ,detail_address"
				+ "						   ,create_date"
				+ "						   ,update_date)"
				+ "	VALUES(?, PASSWORD(?), ?, ?, ?, ?, ?, ?, NOW(), NOW()) ";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getCustomerId());
			stmt.setString(2, member.getCustomerPw());
			stmt.setString(3, member.getName());
			stmt.setString(4, member.getNickname());
			stmt.setString(5, member.getEmail());
			stmt.setString(6, member.getPhone());
			stmt.setInt(7, member.getAddressId());
			stmt.setString(8, member.getDetailAddress());
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
	
	// 4) 회원 삭제 page
	public int deleteMember(Customer member) {
		// 회원 삭제 성공 여부 리턴할 정수형 변수 선언
		int row = -1; 
		// DB 초기화
		Connection conn = null;
		PreparedStatement stmt = null;
		// DButil
		conn = DButil.getConnection();
		// 1) customer 테이블 데이터 삭제
		String sql1 = "DELETE FROM customer WHERE cusotmer_id=? AND customer_pw=PASSWORD(?)";
		
		/*
		// 2) 연관 테이블 데이터 삭제 -> 추가작업 필요
		String sql2 = "DELETE FROM cashbook WHERE member_id=?"; 
		*/
		
		try {
			// auto commit 해제
			conn.setAutoCommit(false); 
			// 1) customer 테이블 데이터 삭제
			stmt = conn.prepareStatement(sql1);
			stmt.setString(1, member.getCustomerId());
			stmt.setString(2, member.getCustomerPw());
			row = stmt.executeUpdate();
			
			/*
			// 2) cashbook 테이블 데이터 삭제 -> 추가작업 필요
			stmt = conn.prepareStatement(sql1);
			stmt.setString(1, member.getMemberId());
			stmt.executeUpdate();
			stmt.close();
			*/
			
			// 삭제 성공(row값이 1) -> commit / 이외 상황 rollback
			if (row == 1) { 
				conn.commit();
			} else { 
				conn.rollback();
			}
		} catch (Exception e1) {
			try {
				conn.rollback();

			} catch(SQLException e2) {
				e2.printStackTrace();
			}
			e1.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
		}
		return row;
	}
	
	// 5) 회원 정보 수정 page
	public int updateMember(Customer member) {
		// 회원 정보 수정 성공 여부 리턴할 정수형 변수 선언
		int row = -1; 
		// 로그인 실패시, 처리 코드 -> customerId = null
		String customerId = null;
		// DB 초기화
		Connection conn = null;
		PreparedStatement stmt = null;
		// DButil
		conn = DButil.getConnection();
		// SQL 쿼리
		String sql = "UPDATE customer SET name=? "
				+ "						,nickname=? "
				+ "						,email=? "
				+ "						,phone=? "
				+ "						,address_id "
				+ "						,detail_address=? "
				+ "	WHERE customer_id=? AND customer_pw=PASSWORD(?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getName());
			stmt.setString(2, member.getNickname());
			stmt.setString(3, member.getEmail());
			stmt.setString(4, member.getPhone());
			stmt.setInt(5, member.getAddressId());
			stmt.setString(6, member.getDetailAddress());
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
	
	//  6) 회원 비밀번호 수정
	public int updateMemberPasswordByIdPW(Customer member,String newMemberPw) {
		// 회원 정보 수정 성공 여부 리턴할 정수형 변수 선언
		int row = -1; 
		// 로그인 실패시, 처리 코드 -> customerId = null
		String customerId = null;
		// newMemberPw(새 비밀번호)가 공백 값이면, memberPw(현 비밀번호)로 값을 채움
		if(newMemberPw.equals("")) {
			newMemberPw = member.getCustomerPw();
		}
		// DB 초기화
		Connection conn = null;
		PreparedStatement stmt = null;
		// DButil
		conn = DButil.getConnection();
		// SQL 쿼리
		String sql = "UPDATE customer SET customer_pw=? "
				+ "	WHERE customer_id=? AND customer_pw=PASSWORD(?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getCustomerPw());
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