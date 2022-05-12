package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.DButil;
import vo.Mainboard;

public class InsertMainboardDao {
	public int insertMainboard(Mainboard m) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		int row=0;
		String sql = "INSERT INTO mainboard(mainboard_name, mainboard_kind, socket_size, chipset, ram_version, price, quantity, company_name, memo, update_date) VALUES (?,?,?,?,?,?,?,?,?, NOW())";
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, m.getMainboardName());
			stmt.setString(2, m.getMainboardKind());
			stmt.setString(3, m.getSocketSize());
			stmt.setString(4, m.getChipset());
			stmt.setString(5, m.getRamVersion());
			stmt.setInt(6, m.getPrice());
			stmt.setInt(7, m.getQuantity());
			stmt.setString(8, m.getCompanyName());
			stmt.setString(9, m.getMemo());
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
