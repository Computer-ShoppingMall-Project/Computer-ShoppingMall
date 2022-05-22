package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DButil;
import vo.Case;
import vo.Image;

public class CaseDao {
	// 장바구니에 담기
	public int insertCartCase(String customerId, Case c) {
		int row = 0;
		Connection conn = null;
		PreparedStatement stmt =  null;
		conn = DButil.getConnection();
		String sql = "INSERT INTO basket(customer_id, product_name, category_name, product_number, price, quantity, create_date, update_date)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, NOW(), NOW())";
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
	public int insertCase(Image i, Case c) {
		// insert 성공/실패 확인 변수 선언
		int row = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		// SQL 쿼리
		String imgSql =
			"INSERT INTO case_image(NAME, original_name, `type`, create_date, update_date) VALUES (?, ?, ?, NOW(), NOW())";
		String productSql = 
			"INSERT INTO case(case_name, case_size, category_name, gpu_size, bay89mm, bay64mm, price, quantity, case_image_no, memo, update_date)"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";	
		try {
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(imgSql, PreparedStatement.RETURN_GENERATED_KEYS); // 기본키를 외래키로 참조
			stmt.setString(1, i.getName());
			stmt.setString(2, i.getOriginalName());
			stmt.setString(3, i.getType());
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			int imgNo = 0;
			if(rs.next()) {
				imgNo = rs.getInt(1);
			}
			stmt.close();
			// insert + img key값 받아오기
			stmt = conn.prepareStatement(productSql);
			stmt.setString(1, c.getCaseName());
			stmt.setString(2, c.getCaseSize());
			stmt.setString(3, c.getCategoryName());
			stmt.setInt(4, c.getGpuSize());
			stmt.setInt(5, c.getBay89mm());
			stmt.setInt(6, c.getBay64mm());
			stmt.setInt(7, c.getPrice());
			stmt.setInt(8, c.getQuantity());
			stmt.setString(9, c.getMemo());
			stmt.setInt(10, imgNo);
			row = stmt.executeUpdate();
			
			if(row == 1) {
				conn.commit();
			}
		} catch (Exception e) {
			try {
				conn.rollback(); // 오류 발생시, rollback
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return row;
	}
	// caseList
	public ArrayList<Case> selectCaseList() {
		ArrayList<Case> list = new ArrayList<Case>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT"
				+ "	c.case_no caseNo"
				+ "	, c.case_name caseName"
				+ "	, c.category_name categoryName"
				+ "	, c.case_size caseSize"
				+ "	, c.gpu_size gpuSize"
				+ "	, c.bay89mm"
				+ "	, c.bay64mm"
				+ "	, c.price"
				+ "	, c.quantity"
				+ "	, c.case_image_no caseImageNo"
				+ "	, c.memo"
				+ "	, c.update_date updateDate"
				+ " , ci.name imageName"
				+ " FROM `case` c INNER JOIN case_image ci"
				+ " ON c.case_image_no = ci.case_image_no";
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
				c.setCaseImageName(rs.getString("imageName"));
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
	public Case selectCaseOne(int caseNo) {
		Case c = new Case();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT"
				+ "	c.case_no caseNo"
				+ "	, c.case_name caseName"
				+ "	, c.category_name categoryName"
				+ "	, c.case_size caseSize"
				+ "	, c.gpu_size gpuSize"
				+ "	, c.bay89mm"
				+ "	, c.bay64mm"
				+ "	, c.price"
				+ "	, c.quantity"
				+ "	, c.case_image_no caseImageNo"
				+ "	, c.memo"
				+ "	, c.update_date updateDate"
				+ " , ci.name imageName"
				+ " FROM `case` c INNER JOIN case_image ci"
				+ " ON c.case_image_no = ci.case_image_no"
				+ " WHERE c.case_no=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, caseNo);
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
				c.setCaseImageName(rs.getString("imageName"));
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
	// case 상세검색
	public ArrayList<Case> caseDetailSearch(String[] caseSize, String[] gpuSize, String[] bay64mm, String[] bay89mm, String search) {
		ArrayList<Case> list = new ArrayList<Case>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT"
				+ "	c.case_no caseNo"
				+ "	, c.case_name caseName"
				+ "	, c.category_name categoryName"
				+ "	, c.case_size caseSize"
				+ "	, c.gpu_size gpuSize"
				+ "	, c.bay89mm"
				+ "	, c.bay64mm"
				+ "	, c.price"
				+ "	, c.quantity"
				+ "	, c.case_image_no caseImageNo"
				+ "	, c.memo"
				+ "	, c.update_date updateDate"
				+ " , ci.name imageName"
				+ " FROM `case` c INNER JOIN case_image ci"
				+ " ON c.case_image_no = ci.case_image_no"
				+ " WHERE case_name LIKE ?"; // WHERE절 아무 검색조건 없을 시 전체 상품 조회 -> 검색 키워드 들어올 시, 함께 검색
		
		// 같은 배열끼리 비교는 OR 조건, 다른 배열끼리 비교는 AND -> 동적쿼리 (makeWhereSql 메서드 이용)
		// 값이 존재한다면 쿼리 추가 (AND 조건문으로 시작)
		sql += makeWhereSql("case_size", caseSize);
		sql += makeWhereSql("gpu_size", gpuSize);
		sql += makeWhereSql("bay64mm", bay64mm);
		sql += makeWhereSql("bay89mm", bay89mm);
		
		System.out.println("[CPU case SQL] : " + sql);
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%"+search+"%");
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
				c.setCaseImageName(rs.getString("imageName"));
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