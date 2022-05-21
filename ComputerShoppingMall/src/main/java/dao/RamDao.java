package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DButil;
import vo.Ram;

public class RamDao {
	// 장바구니 담기
	public int insertCartRam(String customerId, Ram ram) {
		int row = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		String sql="INSERT INTO basket (customer_id, product_name, category_name, product_number, price, quantity, create_date, update_date) VALUES (?,?,?,?,?,?,now(),now())";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customerId);
			stmt.setString(2, ram.getRamName());
			stmt.setString(3, ram.getCategoryName());
			stmt.setInt(4, ram.getRamNo());
			stmt.setInt(5, ram.getPrice());
			stmt.setInt(6, ram.getQuantity());
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
	// ram 상품삭제
	public void deleteRam(int ramNo ) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		String sql="DELETE FROM ram WHERE ram_no=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ramNo);
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
	// ram 상품수정
	public int updateRam(Ram r) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		int row=0;
		String sql = "UPDATE ram SET price=?, quantity=?, update_date=NOW() WHERE ram_no=?";
		try {
			stmt= conn.prepareStatement(sql);
			stmt.setInt(1, r.getPrice());
			stmt.setInt(2, r.getQuantity());
			stmt.setInt(3, r.getRamNo());
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
	// ram 상품등록
	public int insertRam(Ram r) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		int row=0;
		String sql = "INSERT INTO ram(ram_name, company_name, kind, price, quantity, memo, update_date) VALUES (?,?,?,?,?,?, NOW())";
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, r.getRamName());
			stmt.setString(2, r.getCompanyName());
			stmt.setString(3, r.getKind());
			stmt.setInt(4, r.getPrice());
			stmt.setInt(5, r.getQuantity());
			stmt.setString(6, r.getMemo());
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
	// ramList 보기
	public ArrayList<Ram> selectRamList() {
		ArrayList<Ram> list = new ArrayList<Ram>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT"
				+ "	r.ram_no ramNo"
				+ "	,r.ram_name ramName"
				+ "	,r.company_name companyName"
				+ "	,r.category_name categoryName"
				+ "	,r.kind"
				+ "	,r.price"
				+ "	,r.quantity"
				+ "	,r.ram_image_no ramImageNo"
				+ "	,r.memo"
				+ "	,r.update_date updateDate"
				+ " ,ri.name imageName"
				+ " FROM ram r INNER JOIN ram_image ri"
				+ " ON r.ram_image_no = ri.ram_image_no";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Ram r = new Ram();
				r.setRamNo(rs.getInt("ramNo"));
				r.setRamName(rs.getString("ramName"));
				r.setCompanyName(rs.getString("companyName"));
				r.setCategoryName(rs.getString("categoryName"));
				r.setKind(rs.getString("kind"));
				r.setPrice(rs.getInt("price"));
				r.setQuantity(rs.getInt("quantity"));
				r.setRamImageNo(rs.getInt("ramImageNo"));
				r.setMemo(rs.getString("memo"));
				r.setUpdateDate(rs.getString("updateDate"));
				r.setRamImageName(rs.getString("imageName"));
				list.add(r);
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
	// ram 검색 체크박스 / insertRam -> 중복제거 데이터(company_name)
	public ArrayList<String> companyKind() {
		ArrayList<String> list = new ArrayList<String>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT DISTINCT(company_name) companyName FROM ram";
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
	// ram 검색 체크박스 / insertRam -> 중복제거 데이터(kind)
	public ArrayList<String> kindKind() {
		ArrayList<String> list = new ArrayList<String>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT DISTINCT(kind) kind FROM ram";
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
	// ramOne 상세보기
	public Ram selectRamOne(int ramNo) {
		Ram r = new Ram();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT"
				+ "	ram_no ramNo"
				+ "	,ram_name ramName"
				+ "	,company_name companyName"
				+ "	,category_name categoryName"
				+ "	,kind"
				+ "	,price"
				+ "	,quantity"
				+ "	,ram_image_no ramImageNo"
				+ "	,memo"
				+ "	,update_date updateDate"
				+ " FROM ram WHERE ram_no = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ramNo);
			rs = stmt.executeQuery();
			while(rs.next()) {
				r.setRamNo(rs.getInt("ramNo"));
				r.setRamName(rs.getString("ramName"));
				r.setCompanyName(rs.getString("companyName"));
				r.setCategoryName(rs.getString("categoryName"));
				r.setKind(rs.getString("kind"));
				r.setPrice(rs.getInt("price"));
				r.setQuantity(rs.getInt("quantity"));
				r.setRamImageNo(rs.getInt("ramImageNo"));
				r.setMemo(rs.getString("memo"));
				r.setUpdateDate(rs.getString("updateDate"));
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
		return r;
	}
}
