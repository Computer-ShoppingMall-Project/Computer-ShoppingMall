package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DButil;
import vo.Power;

public class PowerDao {
	// power 상품삭제
	public void deletePower(int powerNo) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		String sql="DELETE FROM power WHERE power_no=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, powerNo);
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
	// power 상품상세보기
	// power 상품수정
	// power 상품등록
	public int insertPower(Power p) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		int row=0;
		String sql = "INSERT INTO power(power_name, rated_power, price, quantity, memo, update_date) VALUES (?,?,?,?,?, NOW())";
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, p.getPowerName());
			stmt.setString(2, p.getRatedPower());
			stmt.setInt(3, p.getPrice());
			stmt.setInt(4, p.getQuantity());
			stmt.setString(5, p.getMemo());
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
