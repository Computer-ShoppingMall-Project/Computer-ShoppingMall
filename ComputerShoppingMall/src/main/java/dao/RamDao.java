package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DButil;
import vo.Ram;

public class RamDao {
	// ram 상품등록
	public int insertRam(Ram r) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		int row=0;
		String sql = "INSERT INTO ram(ram_name, company_name, ram_kind, price, quantity, memo, update_date) VALUES (?,?,?,?,?,?, NOW())";
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, r.getRamName());
			stmt.setString(2, r.getCompanyName());
			stmt.setString(3, r.getRamKind());
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
		} try {
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
}
