package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DButil;
import vo.Cooler;

public class CoolerDao {
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
		}finally {
		}try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	// cooler 상품상세보기
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
		}finally {
			
		}try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}return row;
	}
	// cooler 상품등록
	public int insertCooler(Cooler c) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		int row=0;
		String  sql="INSERT INTO cooler (cooler_name, company_name, cooler_kind,cooler_size, price, quantity, memo, update_date) VALUES (?,?,?,?,?,?, NOW())";  
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, c.getCoolerName());
			stmt.setString(2, c.getCompanyName());
			stmt.setString(3, c.getCoolerKind());
			stmt.setInt(4, c.getCoolerSize());
			stmt.setInt(5, c.getPrice());
			stmt.setInt(6, c.getQuantity());
			stmt.setString(7, c.getMemo());
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
}
