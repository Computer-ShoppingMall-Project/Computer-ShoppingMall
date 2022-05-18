package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DButil;
import vo.Gpu;

public class GpuDao {
	// gpu 상품삭제
	public void deleteGpu(int gpuNo) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		String sql="DELETE FROM gpu WHERE gpu_no=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, gpuNo);
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
	// gpu 상품수정
	public int updateGpu(Gpu g) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		int row=0;
		String sql = "UPDATE gpu SET price=?, quantity=?, update_date=NOW() WHERE gpu_no=?";
		try {
			stmt= conn.prepareStatement(sql);
			stmt.setInt(1, g.getPrice());
			stmt.setInt(2, g.getQuantity());
			stmt.setInt(3, g.getGpuNo());
			row = stmt.executeUpdate();
			if(row == 1) {
				System.out.println("입력성공");
			} else {
				System.out.println("입력실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}return row;
	}
	// gpu 상품등록
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
	// GPU 정보 상세보기
	public ArrayList<Gpu> selectGpuList() {
		ArrayList<Gpu> list = new ArrayList<Gpu>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT"
				+ "	gpu_no gpuNo"
				+ "	,gpu_name gpuName"
				+ "	,company_name companyName"
				+ "	,category_name categoryName"
				+ "	,chipset_company chipsetCompany"
				+ "	,gpu_size gpuSize"
				+ "	,price"
				+ "	,quantity"
				+ "	,gpu_image_no gpuImageNo"
				+ "	,memo"
				+ "	,update_date updateDate"
				+ " FROM gpu";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Gpu g = new Gpu();
				g.setGpuNo(rs.getInt("gpuNo"));
				g.setGpuName(rs.getString("gpuName"));
				g.setCompanyName(rs.getString("companyName"));
				g.setCategoryName(rs.getString("categoryName"));
				g.setChipsetCompany(rs.getString("chipsetCompany"));
				g.setGpuSize(rs.getInt("gpuSize"));
				g.setQuantity(rs.getInt("quantity"));
				g.setPrice(rs.getInt("price"));
				g.setGpuImageNo(rs.getInt("gpuImageNo"));
				g.setMemo(rs.getString("memo"));
				g.setUpdateDate(rs.getString("updateDate"));
				list.add(g);
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
	// GPU 검색 체크박스 / insertGPU -> 중복제거 데이터(company_name)
	public ArrayList<String> companyKind() {
		ArrayList<String> list = new ArrayList<String>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT DISTINCT(company_name) companyName FROM gpu";
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
	// GPU 검색 체크박스 / insertGPU -> 중복제거 데이터(chipset_company)
	public ArrayList<String> chipsetCompanyKind() {
		ArrayList<String> list = new ArrayList<String>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT DISTINCT(chipset_company) chipsetCompany FROM gpu";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String chipsetCompany = rs.getString("chipsetCompany");
				list.add(chipsetCompany);
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
	// GPU 검색 체크박스 / insertGPU -> 중복제거 데이터(gpu_size)
	public ArrayList<String> gpuSizeKind() {
		ArrayList<String> list = new ArrayList<String>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT DISTINCT(gpu_size) gpuSize FROM gpu"
				+ " ORDER BY gpu_size";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String gpuSize = rs.getString("gpuSize");
				list.add(gpuSize);
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
