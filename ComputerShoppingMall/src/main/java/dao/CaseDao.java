package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DButil;
import vo.Case;

public class CaseDao {
	// 장바구니에 담기
	public int insertCartCase(String customerId, Case c) {
		int row = 0;
		Connection conn = null;
		PreparedStatement stmt =  null;
		conn = DButil.getConnection();
		String sql = "INSERT INTO basket(customer_id, product_name, category_name, product_number, price, quantity, create_date, update_date)"
				+ "VALUES (?, ?, ?, ?, ?, ?, NOW(), NOW())";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customerId);
			stmt.setString(2, c.getCaseName());
			stmt.setString(3, c.getCategoryName());
			stmt.setInt(4, c.getCaseNo());
			stmt.setInt(5, c.getPrice());
			stmt.setInt(6, c.getQuantity());
			stmt.executeUpdate();
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
	// case 상품삭제
	public void deleteCase(int caseNo) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		String sql="DELETE FROM caseWHERE case_no=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, caseNo);
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
	// case 상품수정
	public int updateCase(Case c) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		int row=0;
		String sql = "UPDATE `case` SET price=?, quantity=?, update_date=NOW() WHERE case_no=?";
		try {
			stmt= conn.prepareStatement(sql);
			stmt.setInt(1, c.getPrice());
			stmt.setInt(2, c.getQuantity());
			stmt.setInt(3, c.getCaseNo());
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
	// case 상품등록
	public int insertCase(Case c) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		int row=0;
		String sql = "INSERT INTO `case`(case_name, category_name, case_size, gpu_size, bay89mm, bay64mm, price,quantity,memo, update_date) VALUES (?,?,?,?,?,?,?,?, NOW())";
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, c.getCaseName());
			stmt.setString(2, c.getCategoryName());
			stmt.setString(3, c.getCaseSize());
			stmt.setInt(4, c.getGpuSize());
			stmt.setInt(5, c.getBay89mm());
			stmt.setInt(6, c.getBay64mm());
			stmt.setInt(7, c.getPrice());
			stmt.setInt(8, c.getQuantity());
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
		} try {
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	// caseList 보기
	public ArrayList<Case> selectCaseList() {
		ArrayList<Case> list = new ArrayList<Case>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT"
				+ "	case_no caseNo"
				+ "	, case_name caseName"
				+ "	, category_name categoryName"
				+ "	, case_size caseSize"
				+ "	, gpu_size gpuSize"
				+ "	, bay89mm"
				+ "	, bay64mm"
				+ "	, price"
				+ "	, quantity"
				+ "	, case_image_no caseImageNo"
				+ "	, memo"
				+ "	, update_date updateDate"
				+ " FROM `case`";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Case c = new Case();
				c.setCaseNo(rs.getInt("caseNo"));
				c.setCaseName(rs.getString("caseName"));
				c.setCategoryName(rs.getString("categoryName"));
				c.setCaseSize(rs.getString("caseSize"));
				c.setGpuSize(rs.getInt("gpuSize"));
				c.setBay64mm(rs.getInt("bay64mm"));
				c.setBay89mm(rs.getInt("bay89mm"));
				c.setPrice(rs.getInt("price"));
				c.setQuantity(rs.getInt("quantity"));
				c.setCaseImageNo(rs.getInt("caseImageNo"));
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
	// Case 검색 체크박스 / insertCase -> 중복제거 데이터(case_size)
	public ArrayList<String> caseSizeList() {
		ArrayList<String> list = new ArrayList<String>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT DISTINCT(case_size) caseSize FROM `case`";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String caseSize = rs.getString("caseSize");
				list.add(caseSize);
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
	// Case 검색 체크박스 / insertCase -> 중복제거 데이터(gpu_size)
	public ArrayList<String> gpuSizeList() {
		ArrayList<String> list = new ArrayList<String>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT DISTINCT(gpu_size) gpuSize FROM `case`"
				+ "ORDER BY gpu_size";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String gpuSize = rs.getString("gpuSize");
				list.add(gpuSize);
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
	// Case 검색 체크박스 / insertCase -> 중복제거 데이터(6.4mmList)
	public ArrayList<String> bay64mmList() {
		ArrayList<String> list = new ArrayList<String>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT DISTINCT(bay64mm) bay64mm FROM `case`"
				+ " ORDER BY bay64mm";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String bay64mm = rs.getString("bay64mm");
				list.add(bay64mm);
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
	// Case 검색 체크박스 / insertCase -> 중복제거 데이터(bay89mm)
	public ArrayList<String> bay89mmList() {
		ArrayList<String> list = new ArrayList<String>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT DISTINCT(bay89mm) bay89mm FROM `case`"
				+ " ORDER BY bay89mm";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String bay89mm = rs.getString("bay89mm");
				list.add(bay89mm);
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
	// caseOne 상세보기
	public Case selectCaseOne() {
		Case c = new Case();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT"
				+ "	case_no caseNo"
				+ "	, case_name caseName"
				+ "	, category_name categoryName"
				+ "	, case_size caseSize"
				+ "	, gpu_size gpuSize"
				+ "	, bay89mm"
				+ "	, bay64mm"
				+ "	, price"
				+ "	, quantity"
				+ "	, case_image_no caseImageNo"
				+ "	, memo"
				+ "	, update_date updateDate"
				+ " FROM `case` WHERE case_no = ?";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				c.setCaseNo(rs.getInt("caseNo"));
				c.setCaseName(rs.getString("caseName"));
				c.setCategoryName(rs.getString("categoryName"));
				c.setCaseSize(rs.getString("caseSize"));
				c.setGpuSize(rs.getInt("gpuSize"));
				c.setBay64mm(rs.getInt("bay64mm"));
				c.setBay89mm(rs.getInt("bay89mm"));
				c.setPrice(rs.getInt("price"));
				c.setQuantity(rs.getInt("quantity"));
				c.setCaseImageNo(rs.getInt("caseImageNo"));
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