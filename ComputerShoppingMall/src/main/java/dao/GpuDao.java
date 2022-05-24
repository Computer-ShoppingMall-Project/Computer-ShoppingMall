package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DButil;
import vo.Gpu;
import vo.Image;

public class GpuDao {
	// 장바구니 담기
	public int insertCartGpu(String customerId, Gpu gpu) {
		int row = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		String sql="INSERT INTO basket (customer_id, product_name, category_name, product_number, price, quantity, create_date, update_date) VALUES (?,?,?,?,?,?,now(),now())";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customerId);
			stmt.setString(2, gpu.getGpuName());
			stmt.setString(3, gpu.getCategoryName());
			stmt.setInt(4, gpu.getGpuNo());
			stmt.setInt(5, gpu.getPrice());
			stmt.setInt(6, gpu.getQuantity());
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
	// gpu 상품삭제
	public int deleteGpu(int gpuNo) {
		int row = 0;
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
		return row;
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
	public int insertGpu(Image i, Gpu g) {
		// insert 성공/실패 확인 변수 선언
		int row = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		// SQL 쿼리
		String imgSql =
			"INSERT INTO gpu_image(NAME, original_name, `type`, create_date, update_date) VALUES (?, ?, ?, NOW(), NOW())";
		String productSql = 
			"INSERT INTO gpu(gpu_name, company_name, category_name, chipset_company, gpu_size, price, quantity, gpu_image_no, memo, update_date)"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";	
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
			stmt.setString(1, g.getGpuName());
			stmt.setString(2, g.getCompanyName());
			stmt.setString(3, g.getCategoryName());
			stmt.setString(4, g.getChipsetCompany());
			stmt.setInt(5, g.getGpuSize());
			stmt.setInt(6, g.getPrice());
			stmt.setInt(7, g.getQuantity());
			stmt.setInt(8, imgNo);
			stmt.setString(9, g.getMemo());
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
	// GPUList 보기
	public ArrayList<Gpu> selectGpuList() {
		ArrayList<Gpu> list = new ArrayList<Gpu>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT"
				+ "	g.gpu_no gpuNo"
				+ "	,g.gpu_name gpuName"
				+ "	,g.company_name companyName"
				+ "	,g.category_name categoryName"
				+ "	,g.chipset_company chipsetCompany"
				+ "	,g.gpu_size gpuSize"
				+ "	,g.price"
				+ "	,g.quantity"
				+ "	,g.gpu_image_no gpuImageNo"
				+ "	,g.memo"
				+ "	,g.update_date updateDate"
				+ ", gi.name imageName"
				+ " FROM gpu g INNER JOIN gpu_image gi"
				+ " ON g.gpu_image_no = gi.gpu_image_no";
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
				g.setGpuImageName(rs.getString("imageName"));
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
	// GpuOne 상세보기
	public Gpu selectGpuOne(int gpuNo) {
		Gpu g = new Gpu();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT"
				+ "	g.gpu_no gpuNo"
				+ "	,g.gpu_name gpuName"
				+ "	,g.company_name companyName"
				+ "	,g.category_name categoryName"
				+ "	,g.chipset_company chipsetCompany"
				+ "	,g.gpu_size gpuSize"
				+ "	,g.price"
				+ "	,g.quantity"
				+ "	,g.gpu_image_no gpuImageNo"
				+ "	,g.memo"
				+ "	,g.update_date updateDate"
				+ ", gi.name imageName"
				+ " FROM gpu g INNER JOIN gpu_image gi"
				+ " ON g.gpu_image_no = gi.gpu_image_no"
				+ " WHERE g.gpu_no = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, gpuNo);
			rs = stmt.executeQuery();
			while(rs.next()) {
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
				g.setGpuImageName(rs.getString("imageName"));
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
		return g;
	}
	// gpu 상세검색
	public ArrayList<Gpu> gpuDetailSearch(String[] companyName, String[] chipsetCompany, String[] gpuSize, String search) {
		ArrayList<Gpu> list = new ArrayList<Gpu>();
		// DB 기본값 셋팅
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		
		String sql = "SELECT"
				+ "	g.gpu_no gpuNo"
				+ "	,g.gpu_name gpuName"
				+ "	,g.company_name companyName"
				+ "	,g.category_name categoryName"
				+ "	,g.chipset_company chipsetCompany"
				+ "	,g.gpu_size gpuSize"
				+ "	,g.price"
				+ "	,g.quantity"
				+ "	,g.gpu_image_no gpuImageNo"
				+ "	,g.memo"
				+ "	,g.update_date updateDate"
				+ ", gi.name imageName"
				+ " FROM gpu g INNER JOIN gpu_image gi"
				+ " ON g.gpu_image_no = gi.gpu_image_no"
				+ " WHERE gpu_name LIKE ?"; // WHERE절 아무 검색조건 없을 시 전체 상품 조회 -> 검색 키워드 들어올 시, 함께 검색
		
		// 같은 배열끼리 비교는 OR 조건, 다른 배열끼리 비교는 AND -> 동적쿼리 (makeWhereSql 메서드 이용)
		// 값이 존재한다면 쿼리 추가 (AND 조건문으로 시작)
		sql += makeWhereSql("company_name", companyName);
		sql += makeWhereSql("chipset_company", chipsetCompany);
		sql += makeWhereSql("gpu_size", gpuSize);
		
		System.out.println("[CPU ram SQL] : " + sql);
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%"+search+"%");
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
				g.setGpuImageName(rs.getString("imageName"));
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