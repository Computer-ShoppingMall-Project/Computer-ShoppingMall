package dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DButil;
import vo.Cooler;

public class CoolerDao {
	// 장바구니에 담기
	public int insertCartCooler(String customerId, Cooler cooler) {
		int row = 0;
		Connection conn = null;
		PreparedStatement stmt =  null;
		conn = DButil.getConnection();
		String sql = "INSERT INTO basket(customer_id, product_name, category_name, product_number, price, quantity, create_date, update_date)"
				+ "VALUES (?, ?, ?, ?, ?, ?,  NOW(), NOW())";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customerId);
			stmt.setString(2, cooler.getCoolerName());
			stmt.setString(3, cooler.getCategoryName());
			stmt.setInt(4, cooler.getCoolerNo());
			stmt.setInt(5, cooler.getPrice());
			stmt.setInt(6, cooler.getQuantity());
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
	// cooler 상품삭제
	public void deleteCooler(int cooler) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		String sql="DELETE FROM cooler WHERE cooler_no=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, cooler);
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
	// cooler 상품수정	
	public int updateCooler(Cooler c) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		int row=0;
		String sql = "UPDATE ram SET price=?, quantity=?, update_date=NOW() WHERE cooler_no=?";
		try {
			stmt= conn.prepareStatement(sql);
			stmt.setInt(1, c.getPrice());
			stmt.setInt(2, c.getQuantity());
			stmt.setInt(3, c.getCoolerNo());
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
	// cooler 상품등록
	public int insertCooler(Cooler c) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		int row=0;
		String  sql="INSERT INTO cooler (cooler_name, company_name, category_name, kind,cooler_size, price, quantity, memo, update_date) VALUES (?,?,?,?,?,?,?,?, NOW())";  
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, c.getCoolerName());
			stmt.setString(2, c.getCompanyName());
			stmt.setString(3, c.getKind());
			stmt.setString(4, c.getCategoryName());
			stmt.setInt(5, c.getCoolerSize());
			stmt.setInt(6, c.getPrice());
			stmt.setInt(7, c.getQuantity());
			stmt.setString(8, c.getMemo());
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
	
	// coolerList 보기
	public ArrayList<Cooler> selectCoolerList() {
		ArrayList<Cooler> list = new ArrayList<Cooler>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT "
				+ " cooler_no coolerNo"
				+ ", cooler_name coolerName"
				+ ", company_name companyName"
				+ ", category_name categoryName"
				+ ", kind"
				+ ", cooler_size coolerSize"
				+ ", price"
				+ ", quantity"
				+ ", cooler_image_no coolerImageNo"
				+ ", memo"
				+ ", update_date updateDate"
				+ " FROM cooler";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Cooler c = new Cooler();
				c.setCoolerNo(rs.getInt("coolerNo"));
				c.setCoolerName(rs.getString("coolerName"));
				c.setCompanyName(rs.getString("companyName"));
				c.setCategoryName(rs.getString("categoryName"));
				c.setKind(rs.getString("kind"));
				c.setCoolerSize(rs.getInt("coolerSize"));
				c.setPrice(rs.getInt("price"));
				c.setQuantity(rs.getInt("quantity"));
				c.setCoolerImageNo(rs.getInt("coolerImageNo"));
				c.setMemo(rs.getString("memo"));
				c.setUpdateDate(rs.getString("updateDate"));
				list.add(c);
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
	// cooler 검색 체크박스 / insert cooler -> 중복제거 데이터(company_name)
	public ArrayList<String> companyKind() {
		ArrayList<String> list = new ArrayList<String>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT DISTINCT(company_name) companyName FROM cooler";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String companyName = rs.getString("companyName");
				list.add(companyName);
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
	// cooler 검색 체크박스 / insert cooler -> 중복제거 데이터(kind)
	public ArrayList<String> kindKind() {
		ArrayList<String> list = new ArrayList<String>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT DISTINCT(kind) kind FROM cooler";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String kind = rs.getString("kind");
				list.add(kind);
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
	// cooler 검색 체크박스 / insert cooler -> 중복제거 데이터(cooler_size)
	public ArrayList<String> coolerSizeKind() {
		ArrayList<String> list = new ArrayList<String>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT DISTINCT(cooler_size) coolerSize FROM cooler"
				+ " ORDER BY cooler_size";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String coolerSize = rs.getString("coolerSize");
				list.add(coolerSize);
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
	// coolerOne 상세보기
	public Cooler selectCoolerOne(int coolerNo) {
		Cooler c = new Cooler();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT "
				+ " cooler_no coolerNo"
				+ ", cooler_name coolerName"
				+ ", company_name companyName"
				+ ", category_name categoryName"
				+ ", kind"
				+ ", cooler_size coolerSize"
				+ ", price"
				+ ", quantity"
				+ ", cooler_image_no coolerImageNo"
				+ ", memo"
				+ ", update_date updateDate"
				+ " FROM cooler WHERE cooler_no = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, coolerNo);
			rs = stmt.executeQuery();
			while(rs.next()) {
				c.setCoolerNo(rs.getInt("coolerNo"));
				c.setCoolerName(rs.getString("coolerName"));
				c.setCompanyName(rs.getString("companyName"));
				c.setCategoryName(rs.getString("categoryName"));
				c.setKind(rs.getString("kind"));
				c.setCoolerSize(rs.getInt("coolerSize"));
				c.setPrice(rs.getInt("price"));
				c.setQuantity(rs.getInt("quantity"));
				c.setCoolerImageNo(rs.getInt("coolerImageNo"));
				c.setMemo(rs.getString("memo"));
				c.setUpdateDate(rs.getString("updateDate"));
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
		return c;
	}
}