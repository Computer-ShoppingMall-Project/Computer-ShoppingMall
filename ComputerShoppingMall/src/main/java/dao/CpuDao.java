package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DButil;
import vo.Cpu;

public class CpuDao {
	// 장바구니에 담기
	public int insertCartCpu(String customerId, Cpu cpu) {
		int row = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		String sql = "INSERT INTO basket(customer_id, product_name, category_name, product_number, price, quantity, create_date, update_date)"
				+ "VALUES ( ?, ?, ?, ?, ?, ? ,NOW(), NOW())";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customerId);
			stmt.setString(2, cpu.getCpuName());
			stmt.setString(3, cpu.getCategoryName());
			stmt.setInt(4, cpu.getCpuNo());
			stmt.setInt(5, cpu.getPrice());
			stmt.setInt(6, cpu.getQuantity());
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
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
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
		String sql="INSERT INTO cpu (cpu_name, category_name, company_name, socket_size, core, thread, price, quantity, memo, update_date) VALUES (?,?,?,?,?,?,?,?,?, NOW())";
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, c.getCpuName());
			stmt.setString(2, c.getCategoryName());
			stmt.setString(3, c.getCompanyName());
			stmt.setString(4, c.getSocketSize());
			stmt.setString(5, c.getCore());
			stmt.setString(6, c.getThread());
			stmt.setInt(7, c.getPrice());
			stmt.setInt(8, c.getQuantity());
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
	// cpuList 보기
	public ArrayList<Cpu> selectCpuList() {
		ArrayList<Cpu> list = new ArrayList<Cpu>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT "
				+ " cpu_no cpuNo"
				+ ", cpu_name cpuName"
				+ ", category_name categoryName"
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
				c.setCategoryName(rs.getString("categoryName"));
				c.setCompanyName(rs.getString("companyName"));
				c.setSocketSize(rs.getString("socketSize"));
				c.setCore(rs.getString("core"));
				c.setThread(rs.getString("thread"));
				c.setPrice(rs.getInt("price"));
				c.setQuantity(rs.getInt("quantity"));
				c.setCpuImageNo(rs.getInt("cpuImageNo"));
				c.setMemo(rs.getString("memo"));
				c.setUpdateDate(rs.getString("updateDate"));
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
	// cpu 검색 체크박스 / insertCpu -> 중복제거 데이터(cpu_kind)
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
	// cpuOne 상세보기
	public Cpu selectCpuOne(int cpuNo) {
		Cpu c = new Cpu();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT "
				+ " cpu_no cpuNo"
				+ ", cpu_name cpuName"
				+ ", category_name categoryName"
				+ ", company_name companyName"
				+ ", socket_size socketSize"
				+ ", core"
				+ ", thread"
				+ ", price"
				+ ", quantity"
				+ ", cpu_image_no cpuImageNo"
				+ ", memo"
				+ ", update_date updateDate"
				+ " FROM cpu WHERE cpu_no = ?" ;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,cpuNo);
			rs = stmt.executeQuery();
			while(rs.next()) {
				c.setCpuNo(rs.getInt("cpuNo"));
				c.setCpuName(rs.getString("cpuName"));
				c.setCategoryName(rs.getString("categoryName"));
				c.setCompanyName(rs.getString("companyName"));
				c.setSocketSize(rs.getString("socketSize"));
				c.setCore(rs.getString("core"));
				c.setThread(rs.getString("thread"));
				c.setPrice(rs.getInt("price"));
				c.setQuantity(rs.getInt("quantity"));
				c.setCpuImageNo(rs.getInt("cpuImageNo"));
				c.setMemo(rs.getString("memo"));
				c.setUpdateDate(rs.getString("updateDate"));
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
		return c;
	}
	
	public ArrayList<Cpu> cpuDetailSearch(String[] companyName, String[] socketSize, String[] core, String[] thread) {
		ArrayList<Cpu> list = new ArrayList<Cpu>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT "
				+ " cpu_no cpuNo"
				+ ", cpu_name cpuName"
				+ ", category_name categoryName"
				+ ", company_name companyName"
				+ ", socket_size socketSize"
				+ ", core"
				+ ", thread"
				+ ", price"
				+ ", quantity"
				+ ", cpu_image_no cpuImageNo"
				+ ", memo"
				+ ", update_date updateDate"
				+ " FROM cpu"
				+ " WHERE (1=1)"; // WHERE절 1=1 아무 검색조건 없을 시 전체 상품 조회 -> where절을 놔두기 위해 둔 쿼리
		
		// 같은 배열끼리 비교는 OR 조건, 다른 배열끼리 비교는 AND -> 동적쿼리 (makeWhereSql 메서드 이용)
		// 값이 존재한다면 쿼리 추가 (AND 조건문으로 시작)
		sql += makeWhereSql("company_name", companyName);
		sql += makeWhereSql("socket_size", socketSize);
		sql += makeWhereSql("core", core);
		sql += makeWhereSql("thread", thread);
		
		System.out.println("[CPU search SQL] : " + sql);
		
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
					Cpu c = new Cpu();
					c.setCpuNo(rs.getInt("cpuNo"));
					c.setCpuName(rs.getString("cpuName"));
					c.setCategoryName(rs.getString("categoryName"));
					c.setCompanyName(rs.getString("companyName"));
					c.setSocketSize(rs.getString("socketSize"));
					c.setCore(rs.getString("core"));
					c.setThread(rs.getString("thread"));
					c.setPrice(rs.getInt("price"));
					c.setQuantity(rs.getInt("quantity"));
					c.setCpuImageNo(rs.getInt("cpuImageNo"));
					c.setMemo(rs.getString("memo"));
					c.setUpdateDate("updateDate");
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
	
	// 같은 배열끼리 비교는 OR 조건, 다른 배열끼리 비교는 AND -> 동적쿼리
	// 값이 존재한다면 쿼리 추가 (AND 조건문으로 시작)
	private String makeWhereSql (String columnName, String[] columnValueArr) {
		String sql = "";
		if(columnValueArr != null) {
			for(int i=0; i< columnValueArr.length; i++) {
					if(i == 0) { // 0번째 값에는 구분을 위해 "(" 추가
						sql += " AND ("+columnName+"='" + columnValueArr[i] + "'";
						if(columnValueArr.length == 1) { // i가 첫번째이자 마지막이라면 ")"
							sql+=")";
						}
					} else if(i > 0) {
							sql += " OR '" + columnValueArr[i] + "'";
							if(i == columnValueArr.length-1) { // 마지막 값에는 구분을 위해 ")" 추가
								sql += ")";
							}
						}
			}
		}
			return sql;
		}
}
