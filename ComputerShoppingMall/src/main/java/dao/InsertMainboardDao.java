package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.DButil;
import vo.Mainboard;

public class InsertMainboardDao {
	public void insertMainboard(Mainboard m) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		String sql = "INSERT INTO mainboard(mainboard_name, mainboard_kind, socket_size, chipset, ram_version, price, quantity, company_name,mainboardImageNo, memo, update_date) VALUES (?,?,?,?,?,?,?,?,?,?, NOW())";
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
			stmt.setInt(9, m.getMainboardImageNo());
			stmt.setString(10, m.getMemo());
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
		} try {
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}
}
