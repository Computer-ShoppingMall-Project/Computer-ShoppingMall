package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DButil;
import vo.Cpu;

public class CpuDao {
	// cpu 상품삭제
	public void deleteCpu(int cpuNo) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		String sql="DELETE FROM cpu WHERE cpu_no=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, cpuNo);
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
	// cpu 상품상세보기
	// cpu 상품수정
	// cpu 상품등록
	public int insertCpu(Cpu c) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		int row=0;
		String sql="INSERT INTO cpu (cpu_name, cpu_kind, socket_size, core, thread, price, quantity, memo, update_date) VALUES (?,?,?,?,?,?,?,?, NOW())";
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, c.getCpuName());
			stmt.setString(2, c.getCpuKind());
			stmt.setString(3, c.getSocketSize());
			stmt.setString(4, c.getCore());
			stmt.setString(5, c.getThread());
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
