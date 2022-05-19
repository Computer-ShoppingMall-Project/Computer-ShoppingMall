package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DButil;
import vo.Power;

public class PowerDao {
	// 장바구니 담기
	public int insertCartPower(String customerId, Power power) {
		int row = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		String sql="INSERT INTO basket (customer_id, product_name, category_name, product_number, category_price, category_quantity, create_date, update_date) VALUES (?,?,?,?,?,?,now(),now())";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customerId);
			stmt.setString(2, power.getPowerName());
			stmt.setString(3, power.getCategoryName());
			stmt.setInt(4, power.getPowerNo());
			stmt.setInt(5, power.getPrice());
			stmt.setInt(5, power.getQuantity());
			row = stmt.executeUpdate();
			if(row == 1) {
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
	// power 상품삭제
	public void deletePower(int powerNo) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		String sql="DELETE FROM power WHERE power_no=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, powerNo);
			stmt.executeUpdate();
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
	}
	// power 상품수정
	public int updatePower(Power p) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		int row=0;
		String sql = "UPDATE ram SET price=?, quantity=?, update_date=NOW() WHERE ram_no=?";
		try {
			stmt= conn.prepareStatement(sql);
			stmt.setInt(1, p.getPrice());
			stmt.setInt(2, p.getQuantity());
			stmt.setInt(3, p.getPowerNo());
			row = stmt.executeUpdate();
			if(row == 1) {
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
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	// power 상품등록
	public int insertPower(Power p) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		int row=0;
		String sql = "INSERT INTO power(power_name, rated_power, price, quantity, memo, update_date) VALUES (?,?,?,?,?, NOW())";
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, p.getPowerName());
			stmt.setString(2, p.getRatedPower());
			stmt.setInt(3, p.getPrice());
			stmt.setInt(4, p.getQuantity());
			stmt.setString(5, p.getMemo());
			row=stmt.executeUpdate();
			if(row == 1) {
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
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	// PowerList 보기
	public ArrayList<Power> selectPowerList() {
		ArrayList<Power> list = new ArrayList<Power>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT"
				+ " power_no powerNo"
				+ " ,power_name powerName"
				+ " ,category_name categoryName"
				+ " ,rated_power ratedPower"
				+ " ,price"
				+ " ,quantity"
				+ " ,power_image_no powerImageNo"
				+ " ,memo"
				+ " ,update_date updateDate"
				+ " FROM power";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Power p = new Power();
				p.setPowerNo(rs.getInt("powerNo"));
				p.setPowerName(rs.getString("powerName"));
				p.setCategoryName(rs.getString("categoryName"));
				p.setRatedPower(rs.getString("ratedPower"));
				p.setPrice(rs.getInt("price"));
				p.setQuantity(rs.getInt("quantity"));
				p.setPowerImageNo(rs.getInt("powerImageNo"));
				p.setMemo(rs.getString("memo"));
				p.setUpdateDate(rs.getString("updateDate"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB 자원반납
				rs.close();
				stmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	// Power 검색 체크박스 / insertPower -> 중복제거 데이터(rated_power)
	public ArrayList<String> ratedPowerList() {
		ArrayList<String> list = new ArrayList<String>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT DISTINCT(rated_power) ratedPower FROM power";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String ratedPower = rs.getString("ratedPower");
				list.add(ratedPower);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB 자원반납
				rs.close();
				stmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	// PowerOne 상세보기
	public Power selectPowerOne(int powerNo) {
		Power p = new Power();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT"
				+ " power_no powerNo"
				+ " ,power_name powerName"
				+ " ,category_name categoryName"
				+ " ,rated_power ratedPower"
				+ " ,price"
				+ " ,quantity"
				+ " ,power_image_no powerImageNo"
				+ " ,memo"
				+ " ,update_date updateDate"
				+ " FROM power WHERE power_no = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, powerNo);
			rs = stmt.executeQuery();
			while(rs.next()) {
				p.setPowerNo(rs.getInt("powerNo"));
				p.setPowerName(rs.getString("powerName"));
				p.setCategoryName(rs.getString("categoryName"));
				p.setRatedPower(rs.getString("ratedPower"));
				p.setPrice(rs.getInt("price"));
				p.setQuantity(rs.getInt("quantity"));
				p.setPowerImageNo(rs.getInt("powerImageNo"));
				p.setMemo(rs.getString("memo"));
				p.setUpdateDate(rs.getString("updateDate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB 자원반납
				rs.close();
				stmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return p;
	}
}
