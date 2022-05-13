package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DButil;
import vo.Cooler;

public class InsertCoolerDao {
	public int insertCooler(Cooler c) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		int row=0;
		String sql = sql="INSERT INTO cooler (cooler_name, company_name, cooler_kind,cooler_size, price, quantity, memo, update_date) VALUES (?,?,?,?,?,?, NOW())";  
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, c.getCoolerName());
			stmt.setString(2, c.getCompanyName());
			stmt.setString(3, c.getCoolerKind());
			stmt.setInt(4, c.getCoolerSize());
			stmt.setInt(6, c.getPrice());
			stmt.setInt(7, c.getQuantity());
			stmt.setString(9, c.getMemo());
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

	public void insertCoolerDao(Cooler c) {
		// TODO Auto-generated method stub
		
	}
}
