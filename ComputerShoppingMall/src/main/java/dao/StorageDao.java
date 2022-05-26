package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DButil;
import vo.Gpu;
import vo.Image;
import vo.Storage;

public class StorageDao {
	// 장바구니에 담기
	public int insertCartStorage(String customerId, Storage storage) {
		int row = 0;
		Connection conn = null;
		PreparedStatement stmt =  null;
		conn = DButil.getConnection();
		String sql = "INSERT INTO basket(customer_id, product_name, category_name, product_number, price, quantity, create_date, update_date)"
				+ "VALUES (?, ?, ?, ?, ?, ?, NOW(), NOW())";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customerId);
			stmt.setString(2, storage.getStorageName());
			stmt.setString(3, storage.getCategoryName());
			stmt.setInt(4, storage.getStorageNo());
			stmt.setInt(5, storage.getPrice());
			stmt.setInt(6, storage.getQuantity());
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
	// storage 상품삭제
	public int deleteStorage(int storageNo) {
		int row = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		String sql="DELETE FROM storage WHERE storage_no=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, storageNo);
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

	// storage 상품수정
	public int updateStorage(Storage s) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		int row=0;
		String sql = "UPDATE storage SET price=?, quantity=?, update_date=NOW() WHERE storage_no=?";
		try {
			stmt= conn.prepareStatement(sql);
			stmt.setInt(1, s.getPrice());
			stmt.setInt(2, s.getQuantity());
			stmt.setInt(3, s.getStorageNo());
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
	// storage 상품등록
	public int insertStorage(Image i, Storage s) {
		int row = 0;
		Connection conn = null;
		PreparedStatement stmt =  null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String imgSql = "INSERT INTO storage_image(NAME, original_name, `type`, create_date, update_date) VALUE(?,?,?,NOW(),NOW())";
		String productSql="INSERT INTO storage(storage_name, company_name, category_name, storage_interface, capacity, price, quantity, storage_image_no, memo, update_date) VALUES (?,?,?,?,?,?,?,?,?, NOW())";
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
			stmt.setString(1, s.getStorageName());
			stmt.setString(2, s.getCompanyName());
			stmt.setString(3, s.getCategoryName());
			stmt.setString(4, s.getStorageInterface());
			stmt.setString(5, s.getCapacity());
			stmt.setInt(6, s.getPrice());
			stmt.setInt(7, s.getQuantity());
			stmt.setInt(8, imgNo);
			stmt.setString(9, s.getMemo());
			row = stmt.executeUpdate();
			
			if(row == 1) {
				conn.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
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
	// storageList 보기
	public ArrayList<Storage> selectStorageList() {
		ArrayList<Storage> list = new ArrayList<Storage>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT"
				+ "	s.storage_no storageNo"
				+ "	,s.storage_name storageName"
				+ "	,s.company_name companyName"
				+ "	,s.category_name categoryName"
				+ "	,s.storage_interface storageInterface"
				+ "	,s.capacity"
				+ "	,s.price"
				+ "	,s.quantity"
				+ "	,s.storage_image_no storageImageNo"
				+ "	,s.memo"
				+ "	,s.update_date updateDate"
				+ " ,si.name imageName"
				+ " FROM storage s INNER JOIN storage_image si"
				+ " ON s.storage_image_no = si.storage_image_no";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Storage s = new Storage();
				s.setStorageNo(rs.getInt("storageNo"));
				s.setStorageName(rs.getString("storageName"));
				s.setCompanyName(rs.getString("companyName"));
				s.setCategoryName(rs.getString("categoryName"));
				s.setStorageInterface(rs.getString("storageInterface"));
				s.setCapacity(rs.getString("capacity"));
				s.setPrice(rs.getInt("price"));
				s.setQuantity(rs.getInt("quantity"));
				s.setStorageImageNo(rs.getInt("storageImageNo"));
				s.setMemo(rs.getString("memo"));
				s.setUpdateDate(rs.getString("updateDate"));
				s.setStorageImageName(rs.getString("imageName"));
				list.add(s);
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
	// storage 검색 체크박스 / insertStorage -> 중복제거 데이터(company_name)
	public ArrayList<String> companyKind() {
		ArrayList<String> list = new ArrayList<String>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT DISTINCT(company_name) companyName FROM storage";
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
	// storage 검색 체크박스 / insertStorage -> 중복제거 데이터(storage_interface)
	public ArrayList<String> interfaceKind() {
		ArrayList<String> list = new ArrayList<String>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT DISTINCT(storage_interface) storageInterface FROM storage";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String storageInterface = rs.getString("storageInterface");
				list.add(storageInterface);
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
	// storage 검색 체크박스 / insertStorage -> 중복제거 데이터(capacity)
	public ArrayList<String> capacityKind() {
		ArrayList<String> list = new ArrayList<String>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT DISTINCT(capacity) capacity FROM storage";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String capacity = rs.getString("capacity");
				list.add(capacity);
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
	// storageOne 상세보기
	public Storage selectStorageOne(int storageNo) {
		Storage s = new Storage();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT"
				+ "	s.storage_no storageNo"
				+ "	,s.storage_name storageName"
				+ "	,s.company_name companyName"
				+ "	,s.category_name categoryName"
				+ "	,s.storage_interface storageInterface"
				+ "	,s.capacity"
				+ "	,s.price"
				+ "	,s.quantity"
				+ "	,s.storage_image_no storageImageNo"
				+ "	,s.memo"
				+ "	,s.update_date updateDate"
				+ " ,si.name imageName"
				+ " FROM storage s INNER JOIN storage_image si"
				+ " ON s.storage_image_no = si.storage_image_no"
				+ " WHERE s.storage_no = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, storageNo);
			rs = stmt.executeQuery();
			while(rs.next()) {
				s.setStorageNo(rs.getInt("storageNo"));
				s.setStorageName(rs.getString("storageName"));
				s.setCompanyName(rs.getString("companyName"));
				s.setCategoryName(rs.getString("categoryName"));
				s.setStorageInterface(rs.getString("storageInterface"));
				s.setCapacity(rs.getString("capacity"));
				s.setPrice(rs.getInt("price"));
				s.setQuantity(rs.getInt("quantity"));
				s.setStorageImageNo(rs.getInt("storageImageNo"));
				s.setMemo(rs.getString("memo"));
				s.setUpdateDate(rs.getString("updateDate"));
				s.setStorageImageName(rs.getString("imageName"));
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
		return s;
	}
	// storage 상세검색
	public ArrayList<Storage> storageDetailSearch(String[] companyName, String[] storageInterface, String[] capacity, String search) {
		ArrayList<Storage> list = new ArrayList<Storage>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql =  "SELECT"
				+ "	s.storage_no storageNo"
				+ "	,s.storage_name storageName"
				+ "	,s.company_name companyName"
				+ "	,s.category_name categoryName"
				+ "	,s.storage_interface storageInterface"
				+ "	,s.capacity"
				+ "	,s.price"
				+ "	,s.quantity"
				+ "	,s.storage_image_no storageImageNo"
				+ "	,s.memo"
				+ "	,s.update_date updateDate"
				+ " ,si.name imageName"
				+ " FROM storage s INNER JOIN storage_image si"
				+ " ON s.storage_image_no = si.storage_image_no"
				+ " WHERE storage_name LIKE ?"; // WHERE절 아무 검색조건 없을 시 전체 상품 조회 -> 검색 키워드 들어올 시, 함께 검색
		
		// 같은 배열끼리 비교는 OR 조건, 다른 배열끼리 비교는 AND -> 동적쿼리 (makeWhereSql 메서드 이용)
		// 값이 존재한다면 쿼리 추가 (AND 조건문으로 시작)
		sql += makeWhereSql("company_name", companyName);
		sql += makeWhereSql("storage_interface", storageInterface);
		sql += makeWhereSql("capacity", capacity);
		
		System.out.println("[CPU storage SQL] : " + sql);
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%"+search+"%");
			rs = stmt.executeQuery();
			while(rs.next()) {
				Storage s = new Storage();
				s.setStorageNo(rs.getInt("storageNo"));
				s.setStorageName(rs.getString("storageName"));
				s.setCompanyName(rs.getString("companyName"));
				s.setCategoryName(rs.getString("categoryName"));
				s.setStorageInterface(rs.getString("storageInterface"));
				s.setCapacity(rs.getString("capacity"));
				s.setPrice(rs.getInt("price"));
				s.setQuantity(rs.getInt("quantity"));
				s.setStorageImageNo(rs.getInt("storageImageNo"));
				s.setMemo(rs.getString("memo"));
				s.setUpdateDate(rs.getString("updateDate"));
				s.setStorageImageName(rs.getString("imageName"));
				list.add(s);
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
