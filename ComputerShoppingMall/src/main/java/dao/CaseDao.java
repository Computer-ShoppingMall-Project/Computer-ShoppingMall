package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DButil;
import vo.Case;

public class CaseDao {
	// case 상품등록
	public int insertCase(Case c) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		int row=0;
		String sql = "INSERT INTO `case`(case_name, case_size, gpu_size, bay89mm, bay64mm, price,quantity,memo, update_date) VALUES (?,?,?,?,?,?,?,?, NOW())";
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, c.getCaseName());
			stmt.setString(2, c.getCaseSize());
			stmt.setInt(3, c.getGpuSize());
			stmt.setInt(4, c.getBay89mm());
			stmt.setInt(5, c.getBay64mm());
			stmt.setInt(6, c.getPrice());
			stmt.setInt(7, c.getQuantity());
			stmt.setString(8, c.getMemo());
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
