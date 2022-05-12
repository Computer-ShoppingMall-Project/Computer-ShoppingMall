package dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.DButil;
import vo.Ram;

public class InsertProductRamDao {
	public void insertProductRam(Ram ram) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO ram(ram_name, company_name, ram_kind, price, quantity, memo, update_date) VALUES (?,?,?,?,?,?, NOW())";
		conn = DButil.getConnection();
		try {
			stmt= conn.prepareStatement(sql);
			stmt.setString(1, ram.getRamName());
			stmt.setString(2, ram.getCompanyName());
			stmt.setString(3, ram.getRamKind());
			stmt.setInt(4, ram.getPrice());
			stmt.setInt(5, ram.getQuantity());
			stmt.setString(6, ram.getMemo());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
	}
}
