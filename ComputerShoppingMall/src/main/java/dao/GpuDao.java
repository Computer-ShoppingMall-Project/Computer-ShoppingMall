package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DButil;
import vo.Gpu;

public class GpuDao {
	public int insertGpu(Gpu g) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		int row=0;
		String sql="INSERT INTO gpu(gpu_name,company_name, chipset_company, gpu_size, price, quantity, memo, update_date) VALUES (?,?,?,?,?,?,?, NOW())";
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, g.getGpuName());
			stmt.setString(2, g.getCompanyName());
			stmt.setString(3, g.getChipsetCompany());
			stmt.setInt(4, g.getGpuSize());
			stmt.setInt(5, g.getPrice());
			stmt.setInt(6, g.getQuantity());
			stmt.setString(7, g.getMemo());
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
