package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DButil;
import vo.Image;
import vo.Mainboard;

public class MainboardDao {
	// 장바구니 담기
	public int insertCartMainboard(String customerId, Mainboard mainboard) {
		int row = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		String sql="INSERT INTO basket (customer_id, product_name, category_name, product_number,price,quantity, create_date, update_date) VALUES (?,?,?,?,?,?,now(),now())";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customerId);
			stmt.setString(2, mainboard.getMainboardName());
			stmt.setString(3, mainboard.getCategoryName());
			stmt.setInt(4, mainboard.getMainboardNo());
			stmt.setInt(5, mainboard.getPrice());
			stmt.setInt(6, mainboard.getQuantity());
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	// mainboard 상품삭제
	public  int deleteMainboard(int mainboardNo) {
		int row = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		String sql="DELETE FROM mainboard WHERE mainboard_no=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, mainboardNo);
			stmt.executeUpdate();
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
	// mainboard 상품수정
	public int updateMainboard(Mainboard m) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		int row=0;
		String sql = "UPDATE mainboard SET price=?, quantity=?, update_date=NOW() WHERE mainboard_no=?";
		try {
			stmt= conn.prepareStatement(sql);
			stmt.setInt(1, m.getPrice());
			stmt.setInt(2, m.getQuantity());
			stmt.setInt(3, m.getMainboardNo());
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
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	// mainboard 상품등록
	public int insertMainboard(Image i, Mainboard m) {
		// insert 성공/실패 확인 변수 선언
		int row = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		// SQL 쿼리
		String imgSql =
			"INSERT INTO mainboard_image(NAME, original_name, `type`, create_date, update_date) VALUES (?, ?, ?, NOW(), NOW())";
		String productSql = 
			"INSERT INTO mainboard(mainboard_name, category_name, kind, socket_size, chipset, ram_version, price, quantity, mainboard_image_no, memo, update_date)"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, NOW())";	
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
			stmt.setString(1, m.getMainboardName());
			stmt.setString(2, m.getCategoryName());
			stmt.setString(3, m.getKind());
			stmt.setString(4, m.getSocketSize());
			stmt.setString(5, m.getChipset());
			stmt.setString(6, m.getRamVersion());
			stmt.setInt(7, m.getPrice());
			stmt.setInt(8, m.getQuantity());
			stmt.setInt(9, imgNo);
			stmt.setString(10, m.getMemo());
			stmt.setString(11, m.getCompanyName());
			row = stmt.executeUpdate();
			
			if(row == 1) {
				conn.commit();
			}
		} catch (Exception e) {
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
	// mainboardList 보기
	public ArrayList<Mainboard> selectMainboardList() {
		ArrayList<Mainboard> list = new ArrayList<Mainboard>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT"
				+ "	m.mainboard_no mainboardNo"
				+ "	, m.mainboard_name mainboardName"
				+ "	, m.category_name categoryName"
				+ "	, m.kind"
				+ "	, m.socket_size socketSize"
				+ "	, m.chipset"
				+ "	, m.ram_version ramVersion"
				+ "	, m.price"
				+ "	, m.quantity"
				+ "	, m.company_name companyName"
				+ "	, m.mainboard_image_no mainboardImageNo"
				+ "	, m.memo"
				+ "	, m.update_date updateDate"
				+ "	, mi.name imageName"
				+ " FROM mainboard m INNER JOIN mainboard_image mi"
				+ " 	ON m.mainboard_image_no = mi.mainboard_image_no";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Mainboard m = new Mainboard();
				m.setMainboardNo(rs.getInt("mainboardNo"));
				m.setMainboardName(rs.getString("mainboardName"));
				m.setCategoryName(rs.getString("categoryName"));
				m.setKind(rs.getString("kind"));
				m.setSocketSize(rs.getString("socketSize"));
				m.setChipset(rs.getString("chipset"));
				m.setRamVersion(rs.getString("ramVersion"));
				m.setPrice(rs.getInt("price"));
				m.setQuantity(rs.getInt("quantity"));
				m.setCompanyName(rs.getString("companyName"));
				m.setMainboardImageNo(rs.getInt("mainboardImageNo"));
				m.setMemo(rs.getString("memo"));
				m.setUpdateDate(rs.getString("updateDate"));
				m.setMainboardImageName(rs.getString("imageName"));
				list.add(m);
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
	// mainboard 검색 체크박스 / insertMainboard -> 중복제거 데이터(company_name)
	public ArrayList<String> companyKind() {
		ArrayList<String> list = new ArrayList<String>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT DISTINCT(company_name) companyName FROM mainboard";
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
	// mainboard 검색 체크박스 -> 중복제거 데이터(socket_size)
	public ArrayList<String> socketSizeKind() {
		ArrayList<String> list = new ArrayList<String>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT DISTINCT(socket_size) socketSize FROM mainboard";
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
	// mainboard 검색 체크박스 -> 중복제거 데이터(chipset)
	public ArrayList<String> chipsetKind() {
		ArrayList<String> list = new ArrayList<String>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT DISTINCT(chipset) chipset FROM mainboard";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String chipset = rs.getString("chipset");
				list.add(chipset);
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
	// mainboard 검색 체크박스 -> 중복제거 데이터(ram_version)
	public ArrayList<String> ramVersionKind() {
		ArrayList<String> list = new ArrayList<String>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT DISTINCT(ram_version) ramVersion FROM mainboard";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String ramVersion = rs.getString("ramVersion");
				list.add(ramVersion);
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
	// mainboard 검색 체크박스 -> 중복제거 데이터(kind)
	public ArrayList<String> kindKind() {
		ArrayList<String> list = new ArrayList<String>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT DISTINCT(kind) kind FROM mainboard";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String kind = rs.getString("kind");
				list.add(kind);
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
	// mainboardOne 상세보기
	public Mainboard selectMainboardOne(int mainboardNo) {
		Mainboard m = new Mainboard();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT"
				+ "	m.mainboard_no mainboardNo"
				+ "	, m.mainboard_name mainboardName"
				+ "	, m.category_name categoryName"
				+ "	, m.kind"
				+ "	, m.socket_size socketSize"
				+ "	, m.chipset"
				+ "	, m.ram_version ramVersion"
				+ "	, m.price"
				+ "	, m.quantity"
				+ "	, m.company_name companyName"
				+ "	, m.mainboard_image_no mainboardImageNo"
				+ "	, m.memo"
				+ "	, m.update_date updateDate"
				+ "	, mi.name imageName"
				+ " FROM mainboard m INNER JOIN mainboard_image mi"
				+ " ON m.mainboard_image_no = mi.mainboard_image_no"
				+ " WHERE m.mainboard_no = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, mainboardNo);
			rs = stmt.executeQuery();
			while(rs.next()) {
				m.setMainboardNo(rs.getInt("mainboardNo"));
				m.setMainboardName(rs.getString("mainboardName"));
				m.setCategoryName(rs.getString("categoryName"));
				m.setKind(rs.getString("kind"));
				m.setSocketSize(rs.getString("socketSize"));
				m.setChipset(rs.getString("chipset"));
				m.setRamVersion(rs.getString("ramVersion"));
				m.setPrice(rs.getInt("price"));
				m.setQuantity(rs.getInt("quantity"));
				m.setCompanyName(rs.getString("companyName"));
				m.setMainboardImageNo(rs.getInt("mainboardImageNo"));
				m.setMemo(rs.getString("memo"));
				m.setUpdateDate(rs.getString("updateDate"));
				m.setMainboardImageName(rs.getString("imageName"));
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
		return m;
	}
	public ArrayList<Mainboard> mainboardDetailSearch(String[] companyName, String[] socketSize, String[] chipset, String[] ramVersion, String[] kind, String search) {
		ArrayList<Mainboard> list = new ArrayList<Mainboard>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql =  "SELECT"
				+ "	m.mainboard_no mainboardNo"
				+ "	, m.mainboard_name mainboardName"
				+ "	, m.category_name categoryName"
				+ "	, m.kind"
				+ "	, m.socket_size socketSize"
				+ "	, m.chipset"
				+ "	, m.ram_version ramVersion"
				+ "	, m.price"
				+ "	, m.quantity"
				+ "	, m.company_name companyName"
				+ "	, m.mainboard_image_no mainboardImageNo"
				+ "	, m.memo"
				+ "	, m.update_date updateDate"
				+ "	, mi.name imageName"
				+ " FROM mainboard m INNER JOIN mainboard_image mi"
				+ " 	ON m.mainboard_image_no = mi.mainboard_image_no"
				+ " WHERE mainboard_name LIKE ?"; // WHERE절 아무 검색조건 없을 시 전체 상품 조회 -> 검색 키워드 들어올 시, 함께 검색
		
		// 같은 배열끼리 비교는 OR 조건, 다른 배열끼리 비교는 AND -> 동적쿼리 (makeWhereSql 메서드 이용)
		// 값이 존재한다면 쿼리 추가 (AND 조건문으로 시작)
		sql += makeWhereSql("company_name", companyName);
		sql += makeWhereSql("socket_size", socketSize);
		sql += makeWhereSql("chipset", chipset);
		sql += makeWhereSql("ramVersion", ramVersion);
		sql += makeWhereSql("kind", kind);
		
		System.out.println("[CPU mainboard SQL] : " + sql);
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%"+search+"%");
			rs = stmt.executeQuery();
			while(rs.next()) {
				Mainboard m = new Mainboard();
				m.setMainboardNo(rs.getInt("mainboardNo"));
				m.setMainboardName(rs.getString("mainboardName"));
				m.setCategoryName(rs.getString("categoryName"));
				m.setKind(rs.getString("kind"));
				m.setSocketSize(rs.getString("socketSize"));
				m.setChipset(rs.getString("chipset"));
				m.setRamVersion(rs.getString("ramVersion"));
				m.setPrice(rs.getInt("price"));
				m.setQuantity(rs.getInt("quantity"));
				m.setCompanyName(rs.getString("companyName"));
				m.setMainboardImageNo(rs.getInt("mainboardImageNo"));
				m.setMemo(rs.getString("memo"));
				m.setUpdateDate(rs.getString("updateDate"));
				m.setMainboardImageName(rs.getString("imageName"));
				list.add(m);
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
