package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DButil;
import vo.Cpu;
import vo.Image;

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
	public int deleteCpu(int cpuNo) {
		int row = 0;
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
		return row;
	}
	// cpu 상품수정
	public int updateCpu(Cpu c) {
		// 상품 수정 확인할 리턴값 변수 선언-!
		int row = -1;
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		String sql = "UPDATE cpu SET cpu_name=? "
				+ "					,company_name=? " 
				+ "					,category_name=? " 
				+ "					,socket_size=? " 
				+ "					,core=? " 
				+ "					,thread=? " 
				+ "					,price=? " 
				+ "					,quantity=? " 
				+ "					,cpu_image_no=? " 
				+ "					,memo=? "
				+ "WHERE cpu_no=?"; 
		try {
			stmt= conn.prepareStatement(sql);
			stmt.setString(1, c.getCpuName());
			stmt.setString(2, c.getCompanyName());
			stmt.setString(3, c.getCategoryName());
			stmt.setString(4, c.getSocketSize());
			stmt.setString(5, c.getCore());
			stmt.setString(6, c.getThread());
			stmt.setInt(7, c.getPrice());
			stmt.setInt(8, c.getQuantity());
			stmt.setInt(9, c.getCpuImageNo());
			stmt.setString(10, c.getMemo());
			stmt.setInt(11, c.getCpuNo());
			row = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	// cpu 상품등록
	public int insertCpu(Image i, Cpu c) {
		// insert 성공/실패 확인 변수 선언
		int row = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		// SQL 쿼리
		String imgSql =
			"INSERT INTO cpu_image(NAME, original_name, `type`, create_date, update_date) VALUES (?, ?, ?, NOW(), NOW())";
		String productSql = 
			"INSERT INTO cpu(cpu_name, company_name, category_name, socket_size, core, thread, price, quantity, cpu_image_no, memo, update_date)"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";	
		try {
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(imgSql, PreparedStatement.RETURN_GENERATED_KEYS); // 기본키를 외래키로 참조
			stmt.setString(1, i.getName());
			stmt.setString(2, i.getOriginalName());
			stmt.setString(3, i.getType());
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			int imgNo = 0;
			if(rs.next()) {
				imgNo = rs.getInt(1);
			}
			stmt.close();
			// insert + img key값 받아오기
			stmt = conn.prepareStatement(productSql);
			stmt.setString(1, c.getCpuName());
			stmt.setString(2, c.getCompanyName());
			stmt.setString(3, c.getCategoryName());
			stmt.setString(4, c.getSocketSize());
			stmt.setString(5, c.getCore());
			stmt.setString(6, c.getThread());
			stmt.setInt(7, c.getPrice());
			stmt.setInt(8, c.getQuantity());
			stmt.setInt(9, imgNo);
			stmt.setString(10, c.getMemo());
			row = stmt.executeUpdate();
			
			if(row == 1) {
				conn.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback(); // 오류 발생시, rollback
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return row;
	}
	// cpuList 보기 + 이미지 이름 불러오기
	public ArrayList<Cpu> selectCpuList() {
		ArrayList<Cpu> list = new ArrayList<Cpu>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT "
				+ "	 c.cpu_no cpuNo"
				+ "	, c.cpu_name cpuName"
				+ "	, c.category_name categoryName"
				+ "	, c.company_name companyName"
				+ "	, c.socket_size socketSize"
				+ "	, c.core"
				+ "	, c.thread"
				+ "	, c.price"
				+ "	, c.quantity"
				+ "	, c.cpu_image_no cpuImageNo"
				+ "	, c.memo"
				+ "	, c.update_date updateDate"
				+ "	, ci.name imageName"
				+ " FROM cpu c INNER JOIN cpu_image ci"
				+ " 	ON c.cpu_image_no = ci.cpu_image_no";
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
				c.setCpuImageName(rs.getString("imageName"));
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
				+ "	 c.cpu_no cpuNo"
				+ "	, c.cpu_name cpuName"
				+ "	, c.category_name categoryName"
				+ "	, c.company_name companyName"
				+ "	, c.socket_size socketSize"
				+ "	, c.core"
				+ "	, c.thread"
				+ "	, c.price"
				+ "	, c.quantity"
				+ "	, c.cpu_image_no cpuImageNo"
				+ "	, c.memo"
				+ "	, c.update_date updateDate"
				+ "	, ci.name imageName"
				+ " FROM cpu c INNER JOIN cpu_image ci"
				+ " ON c.cpu_image_no = ci.cpu_image_no"
				+ " WHERE c.cpu_no = ?" ;
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
				c.setCpuImageName(rs.getString("imageName"));
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
	
	public ArrayList<Cpu> cpuDetailSearch(String[] companyName, String[] socketSize, String[] core, String[] thread, String search) {
		ArrayList<Cpu> list = new ArrayList<Cpu>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT "
				+ "	 c.cpu_no cpuNo"
				+ "	, c.cpu_name cpuName"
				+ "	, c.category_name categoryName"
				+ "	, c.company_name companyName"
				+ "	, c.socket_size socketSize"
				+ "	, c.core"
				+ "	, c.thread"
				+ "	, c.price"
				+ "	, c.quantity"
				+ "	, c.cpu_image_no cpuImageNo"
				+ "	, c.memo"
				+ "	, c.update_date updateDate"
				+ "	, ci.name imageName"
				+ " FROM cpu c INNER JOIN cpu_image ci"
				+ " ON c.cpu_image_no = ci.cpu_image_no"
				+ " WHERE cpu_name LIKE ?"; // WHERE절 아무 검색조건 없을 시 전체 상품 조회 -> 검색 키워드 들어올 시, 함께 검색
		
		// 같은 배열끼리 비교는 OR 조건, 다른 배열끼리 비교는 AND -> 동적쿼리 (makeWhereSql 메서드 이용)
		// 값이 존재한다면 쿼리 추가 (AND 조건문으로 시작)
		sql += makeWhereSql("company_name", companyName);
		sql += makeWhereSql("socket_size", socketSize);
		sql += makeWhereSql("core", core);
		sql += makeWhereSql("thread", thread);
		
		System.out.println("[CPU search SQL] : " + sql);
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%"+search+"%");
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
					c.setCpuImageName(rs.getString("imageName"));
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
							sql += " OR " + columnName + "='" + columnValueArr[i] + "'";
							if(i == columnValueArr.length-1) { // 마지막 값에는 구분을 위해 ")" 추가
								sql += ")";
							}
						}
			}
		}
			return sql;
	}
}
