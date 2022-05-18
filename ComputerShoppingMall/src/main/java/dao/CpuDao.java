package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		} finally {
			try {
				// DB 자원반납
				stmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	// cpu 상품수정
	public int updateCpu(Cpu c) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		int row=0;
		String sql = "UPDATE cpu SET price=?, quantity=?, update_date=NOW() WHERE cpu_no=?";
		try {
			stmt= conn.prepareStatement(sql);
			stmt.setInt(1, c.getPrice());
			stmt.setInt(2, c.getQuantity());
			stmt.setInt(3, c.getCpuNo());
			row = stmt.executeUpdate();
			if(row == 1) {
				System.out.println("입력성공");
			} else {
				System.out.println("입력실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// DB 자원반납
				stmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	// cpu 상품등록
	public int insertCpu(Cpu c) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		int row=0;
		String sql="INSERT INTO cpu (cpu_name, company_name, socket_size, core, thread, price, quantity, memo, update_date) VALUES (?,?,?,?,?,?,?,?, NOW())";
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, c.getCpuName());
			stmt.setString(2, c.getCompnayName());
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
			try {
				// DB 자원반납
				stmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	// cpu 정보 상세보기
	public ArrayList<Cpu> selectCpuList() {
		ArrayList<Cpu> list = new ArrayList<Cpu>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT cpu_no cpuNo"
				+ ", cpu_name cpuName"
				+ ", company_name companyName"
				+ ", socket_size socketSize"
				+ ", core"
				+ ", thread"
				+ ", price"
				+ ", quantity"
				+ ", cpu_image_no cpuImageNo"
				+ ", memo"
				+ ", update_date updateDate"
				+ " FROM cpu";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Cpu c = new Cpu();
				c.setCpuNo(rs.getInt("cpuNo"));
				c.setCpuName(rs.getString("cpuName"));
				c.setCompnayName(rs.getString("companyName"));
				c.setSocketSize(rs.getString("socketSize"));
				c.setCore(rs.getString("core"));
				c.setThread(rs.getString("thread"));
				c.setPrice(rs.getInt("price"));
				c.setQuantity(rs.getInt("quantity"));
				c.setCpuImageNo(rs.getInt("cpuImageNo"));
				c.setMemo(rs.getString("memo"));
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB 자원반납
				rs.close();
				stmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	// cpu 검색 체크박스 / insertCpu -> 중복제거 데이터(company_name)
	public ArrayList<String> companyKind() {
		ArrayList<String> list = new ArrayList<String>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT DISTINCT(company_name) companyName FROM cpu";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String companyName = rs.getString("companyName");
				list.add(companyName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB 자원반납
				rs.close();
				stmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	// cpu 검색 체크박스 / insertCpu -> 중복제거 데이터(socket_size)
	public ArrayList<String> socketSizeKind() {
		ArrayList<String> list = new ArrayList<String>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT DISTINCT(socket_size) socketSize FROM cpu";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String socketSize = rs.getString("socketSize");
				list.add(socketSize);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB 자원반납
				rs.close();
				stmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	// cpu 검색 체크박스 / insertCpu -> 중복제거 데이터(core)
	public ArrayList<String> coreKind() {
		ArrayList<String> list = new ArrayList<String>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT DISTINCT(core) core FROM cpu";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String core = rs.getString("core");
				list.add(core);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB 자원반납
				rs.close();
				stmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	// cpu 검색 체크박스 / insertCpu -> 중복제거 데이터(thread)
	public ArrayList<String> threadKind() {
		ArrayList<String> list = new ArrayList<String>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT DISTINCT(thread) thread FROM cpu"
				+ " ORDER BY thread";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String thread = rs.getString("thread");
				list.add(thread);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB 자원반납
				rs.close();
				stmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
