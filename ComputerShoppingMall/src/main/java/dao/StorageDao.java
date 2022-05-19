package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DButil;
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
	// storage 상품삭제
	public void deleteStorage(int storageNo) {
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
	public int insertStorage(Storage s) {
		Connection conn = null;
		PreparedStatement stmt =  null;
		int row = 0;
		String sql="INSERT INTO storage(storage_name, company_name, category_name, storage_interface, capacity, price, quantity, memo, update_date) VALUES (?,?,?,?,?,?,?,?, NOW())";
		conn = DButil.getConnection();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,s.getStorageName());
			stmt.setString(2,s.getCompanyName());
			stmt.setString(3,s.getCategoryName());
			stmt.setString(4,s.getStorageInterface());
			stmt.setString(5,s.getCapacity());
			stmt.setInt(6,s.getPrice());
			stmt.setInt(7,s.getQuantity());
			stmt.setString(8,s.getMemo());
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
	// storageList 보기
	public ArrayList<Storage> selectStorageList() {
		ArrayList<Storage> list = new ArrayList<Storage>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT"
				+ "	storage_no storageNo"
				+ "	,storage_name storageName"
				+ "	,company_name companyName"
				+ "	,category_name categoryName"
				+ "	,storage_interface storageInterface"
				+ "	,capacity"
				+ "	,price"
				+ "	,quantity"
				+ "	,storage_image_no storageImageNo"
				+ "	,memo"
				+ "	,update_date updateDate"
				+ " FROM storage";
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
				+ "	storage_no storageNo"
				+ "	,storage_name storageName"
				+ "	,company_name companyName"
				+ "	,category_name categoryName"
				+ "	,storage_interface storageInterface"
				+ "	,capacity"
				+ "	,price"
				+ "	,quantity"
				+ "	,storage_image_no storageImageNo"
				+ "	,memo"
				+ "	,update_date updateDate"
				+ " FROM storage WHERE storage_no = ?";
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
	
}
