package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.mariadb.jdbc.export.ExceptionFactory.SqlExceptionFactory;

import util.DButil;
import vo.Storage;

public class StorageDao {
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
		}finally {
		}try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// storage 상품상세보기
	// storage 상품수정
	// storage 상품등록
	public int insertStorage(Storage s) {
		Connection conn = null;
		PreparedStatement stmt =  null;
		int row = 0;
		String sql="INSERT INTO storage(storage_name, company_name, Storage_interface, capacity, price, quantity, memo, update_date) VALUES (?,?,?,?,?,?,?, NOW())";
		conn = DButil.getConnection();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,s.getStorageName());
			stmt.setString(2,s.getCompanyName());
			stmt.setString(3,s.getStorageInterface());
			stmt.setString(4,s.getCapacity());
			stmt.setInt(5,s.getPrice());
			stmt.setInt(6,s.getQuantity());
			stmt.setString(7,s.getMemo());
			stmt.executeUpdate();
			if(row == 1) {
				System.out.println("입력성공");
			} else {
				System.out.println("입력실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		} try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return row;
	} 
}
