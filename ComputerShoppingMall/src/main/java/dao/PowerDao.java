package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DButil;
import vo.Gpu;
import vo.Power;

public class PowerDao {
	// 장바구니 담기
	public int insertCartPower(String customerId, Power power) {
		int row = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		String sql="INSERT INTO basket (customer_id, product_name, category_name, product_number, price, quantity, create_date, update_date) VALUES (?,?,?,?,?,?,now(),now())";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customerId);
			stmt.setString(2, power.getPowerName());
			stmt.setString(3, power.getCategoryName());
			stmt.setInt(4, power.getPowerNo());
			stmt.setInt(5, power.getPrice());
			stmt.setInt(6, power.getQuantity());
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
				+ " p.power_no powerNo"
				+ " ,p.power_name powerName"
				+ " ,p.category_name categoryName"
				+ " ,p.rated_power ratedPower"
				+ " ,p.price"
				+ " ,p.quantity"
				+ " ,p.power_image_no powerImageNo"
				+ " ,p.memo"
				+ " ,p.update_date updateDate"
				+ ", pi.name imageName"
				+ " FROM power p INNER JOIN power_image pi"
				+ " ON p.power_image_no = pi.power_image_no";
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
				p.setPowerImageName(rs.getString("imageName"));
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
				+ " p.power_no powerNo"
				+ " ,p.power_name powerName"
				+ " ,p.category_name categoryName"
				+ " ,p.rated_power ratedPower"
				+ " ,p.price"
				+ " ,p.quantity"
				+ " ,p.power_image_no powerImageNo"
				+ " ,p.memo"
				+ " ,p.update_date updateDate"
				+ ", pi.name imageName"
				+ " FROM power p INNER JOIN power_image pi"
				+ " ON p.power_image_no = pi.power_image_no"
				+ " WHERE p.power_no = ?";
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
				p.setPowerImageName(rs.getString("imageName"));
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
	// power 상세검색
	public ArrayList<Power> powerDetailSearch(String[] ratedPower, String search) {
		ArrayList<Power> list = new ArrayList<Power>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT"
				+ " p.power_no powerNo"
				+ " ,p.power_name powerName"
				+ " ,p.category_name categoryName"
				+ " ,p.rated_power ratedPower"
				+ " ,p.price"
				+ " ,p.quantity"
				+ " ,p.power_image_no powerImageNo"
				+ " ,p.memo"
				+ " ,p.update_date updateDate"
				+ ", pi.name imageName"
				+ " FROM power p INNER JOIN power_image pi"
				+ " ON p.power_image_no = pi.power_image_no"
				+ " WHERE power_name LIKE ?"; // WHERE절 아무 검색조건 없을 시 전체 상품 조회 -> 검색 키워드 들어올 시, 함께 검색
		
		// 같은 배열끼리 비교는 OR 조건, 다른 배열끼리 비교는 AND -> 동적쿼리 (makeWhereSql 메서드 이용)
		// 값이 존재한다면 쿼리 추가 (AND 조건문으로 시작)
		sql += makeWhereSql("rated_power", ratedPower);
		
		System.out.println("[CPU power SQL] : " + sql);
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%"+search+"%");
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
				p.setPowerImageName(rs.getString("imageName"));
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
	// 같은 배열끼리 비교는 OR 조건, 다른 배열끼리 비교는 AND -> 동적쿼리
	// 값이 존재한다면 쿼리 추가 (AND 조건문으로 시작)
	private String makeWhereSql (String columnName, String[] columnValueArr) {
		String sql = "";
		if(columnValueArr != null) {
			for(int i=0; i< columnValueArr.length; i++) {
					if(i == 0) { // 0번째 값에는 구분을 위해 "(" 추가
						sql += " AND ("+columnName+"='" + columnValueArr[i] + "'";
						if(columnValueArr.length == 1) { // i가 첫번째이자 마지막이라면 ")"
							sql+=")";
						}
					} else if(i > 0) {
							sql += " OR " + columnName + "='" + columnValueArr[i] + "'";
							if(i == columnValueArr.length-1) { // 마지막 값에는 구분을 위해 ")" 추가
								sql += ")";
							}
						}
			}
		}
			return sql;
	}
}
