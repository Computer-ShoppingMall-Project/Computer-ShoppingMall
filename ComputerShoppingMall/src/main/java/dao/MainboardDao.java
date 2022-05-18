package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DButil;
import vo.Mainboard;

public class MainboardDao {
	// mainboard 상품삭제
	public void deleteMainboard(int mainboardNo) {
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
	public int insertMainboard(Mainboard m) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		int row=0;
		String sql = "INSERT INTO mainboard(mainboard_name, mainboard_kind, socket_size, chipset, ram_version, price, quantity, company_name, memo, update_date) VALUES (?,?,?,?,?,?,?,?,?, NOW())";
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, m.getMainboardName());
			stmt.setString(2, m.getKind());
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
		}  finally {
			try {
				stmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	// mainboard 정보 상세보기
	public ArrayList<Mainboard> selectMainboardList() {
		ArrayList<Mainboard> list = new ArrayList<Mainboard>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT"
				+ "	mainboard_no mainboardNo"
				+ "	, mainboard_name mainboardName"
				+ "	, category_name categoryName"
				+ "	, kind"
				+ "	, socket_size socketSize"
				+ "	, chipset"
				+ "	, ram_version ramVersion"
				+ "	, price"
				+ "	, quantity"
				+ "	, company_name companyName"
				+ "	, mainboard_image_no mainboardImageNo"
				+ "	, memo"
				+ "	, update_date updateDate"
				+ " FROM mainboard";
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
}

