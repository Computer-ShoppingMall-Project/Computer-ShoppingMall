package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DButil;
import vo.Cooler;
import vo.Image;

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
	public int deleteCooler(int cooler) {
		int row = 0;
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
		return row;
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
	public int insertCooler(Image i, Cooler c) {
		// insert 성공/실패 확인 변수 선언
		int row = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		// SQL 쿼리
		String imgSql = "INSERT INTO cooler_image(NAME, original_name, `type`, create_date, update_date) VALUES (?, ?, ?, NOW(), NOW())";
		String productSql = "INSERT INTO cooler(cooler_name, company_name, category_name, kind, cooler_size, price, quantity, cooler_image_no, memo, update_date)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";
		try {
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(imgSql, PreparedStatement.RETURN_GENERATED_KEYS); // 기본키를 외래키로 참조
			stmt.setString(1, i.getName());
			stmt.setString(2, i.getOriginalName());
			stmt.setString(3, i.getType());
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			int imgNo = 0;
			if (rs.next()) {
				imgNo = rs.getInt(1);
			}
			stmt.close();
			// insert + img key값 받아오기
			stmt = conn.prepareStatement(productSql);
			stmt.setString(1, c.getCoolerName());
			stmt.setString(2, c.getCompanyName());
			stmt.setString(3, c.getCategoryName());
			stmt.setString(4, c.getKind());
			stmt.setInt(5, c.getCoolerSize());
			stmt.setInt(6, c.getPrice());
			stmt.setInt(7, c.getQuantity());
			stmt.setInt(8, imgNo);
			stmt.setString(9, c.getMemo());
			row = stmt.executeUpdate();

			if (row == 1) {
				conn.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback(); // 오류 발생시, rollback
			} catch (SQLException e1) {
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
	
	// coolerList 보기
	public ArrayList<Cooler> selectCoolerList() {
		ArrayList<Cooler> list = new ArrayList<Cooler>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT "
				+ " c.cooler_no coolerNo"
				+ ", c.cooler_name coolerName"
				+ ", c.company_name companyName"
				+ ", c.category_name categoryName"
				+ ", c.kind"
				+ ", c.cooler_size coolerSize"
				+ ", c.price"
				+ ", c.quantity"
				+ ", c.cooler_image_no coolerImageNo"
				+ ", c.memo"
				+ ", c.update_date updateDate"
				+ ", ci.name imageName"
				+ " FROM cooler c INNER JOIN cooler_image ci"
				+ " ON c.cooler_image_no = ci.cooler_image_no";
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
				c.setCoolerImageName(rs.getString("imageName"));
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
				+ " c.cooler_no coolerNo"
				+ ", c.cooler_name coolerName"
				+ ", c.company_name companyName"
				+ ", c.category_name categoryName"
				+ ", c.kind"
				+ ", c.cooler_size coolerSize"
				+ ", c.price"
				+ ", c.quantity"
				+ ", c.cooler_image_no coolerImageNo"
				+ ", c.memo"
				+ ", c.update_date updateDate"
				+ ", ci.name imageName"
				+ " FROM cooler c INNER JOIN cooler_image ci"
				+ " ON c.cooler_image_no = ci.cooler_image_no"
				+ " WHERE c.cooler_no = ?";
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
				c.setCoolerImageName(rs.getString("imageName"));
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
	// cooler 상세검색
	public ArrayList<Cooler> coolerDetailSearch(String[] companyName, String[] kind, String[] coolerSize, String search) {
		ArrayList<Cooler> list = new ArrayList<Cooler>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT "
				+ " c.cooler_no coolerNo"
				+ ", c.cooler_name coolerName"
				+ ", c.company_name companyName"
				+ ", c.category_name categoryName"
				+ ", c.kind"
				+ ", c.cooler_size coolerSize"
				+ ", c.price"
				+ ", c.quantity"
				+ ", c.cooler_image_no coolerImageNo"
				+ ", c.memo"
				+ ", c.update_date updateDate"
				+ ", ci.name imageName"
				+ " FROM cooler c INNER JOIN cooler_image ci"
				+ " ON c.cooler_image_no = ci.cooler_image_no"
				+ " WHERE cooler_name LIKE ?"; // WHERE절 아무 검색조건 없을 시 전체 상품 조회 -> 검색 키워드 들어올 시, 함께 검색
		
		// 같은 배열끼리 비교는 OR 조건, 다른 배열끼리 비교는 AND -> 동적쿼리 (makeWhereSql 메서드 이용)
		// 값이 존재한다면 쿼리 추가 (AND 조건문으로 시작)
		sql += makeWhereSql("company_name", companyName);
		sql += makeWhereSql("kind", kind);
		sql += makeWhereSql("cooler_size", coolerSize);
		
		System.out.println("[CPU cooler SQL] : " + sql);
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%"+search+"%");
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
				c.setCoolerImageName(rs.getString("imageName"));
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