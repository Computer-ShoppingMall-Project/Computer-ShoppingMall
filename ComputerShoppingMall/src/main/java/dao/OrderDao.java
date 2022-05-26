package dao;

import java.sql.*;
import java.util.*;

import util.DButil;
import vo.Order;
// import vo.Qna;

public class OrderDao {
	// 결제
	public int insertOrder(String customerId, int zipCode, String roadAddress, String detailAddress) {
		int row = 0;
		// DB 초기화
		Connection conn = null;
		PreparedStatement stmt = null;
		// DButil
		conn = DButil.getConnection();
		// SQL 쿼리
		String orderSql = "INSERT INTO `order` (basket_no, customer_id, product_name, category_name , category_number, category_price, category_quantity, order_status, create_date, zip_code, road_address, detail_address)"
				+ "   SELECT basket_no, customer_id, product_name, category_name, product_number, price, quantity, '입금 확인', NOW(), ?, ?, ?" // 바로 입금 확인 처리되게끔 처리 + 주소 입력
				+ "   FROM basket WHERE customer_id = ?";
		String deleteBasketSql = "DELETE b"
				+ " FROM basket b INNER JOIN `order` o"
				+ "	ON b.customer_id = o.customer_id "
				+ " WHERE o.customer_id=? ";
		try {
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(orderSql);
			stmt.setInt(1, zipCode);
			stmt.setString(2, roadAddress);
			stmt.setString(3,detailAddress);
			stmt.setString(4, customerId);
			row = stmt.executeUpdate();
			stmt.close();
			
			// 장바구니 삭제
			stmt = conn.prepareStatement(deleteBasketSql); // sql 쿼리 셋팅
			stmt.setString(1, customerId); // customer_id = ?
			stmt.executeUpdate(); // row에 입력 성공여부 값 대입
			if(row > 0) {
				conn.commit();
				System.out.println("입력성공");
			} else {
				System.out.println("입력실패");
			}
		} catch (Exception e) {
			try {
				conn.rollback(); // 오류 발생시, rollback
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
      }      
      return row;
   }
	// 판매 순위
	public List<Map<String, Object>> rankCpuImage(int cpuRanking) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// DB 변수 선언
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs= null;
		conn = DButil.getConnection();
		String sql ="SELECT product_name productName,c.cpu_image_no , ci.name cpuImage,SUM(o.category_quantity) s  "
				+ " FROM `order` o "
				+ "	INNER JOIN cpu c  "
				+ "		ON o.product_name = c.cpu_name "
				+ "	INNER JOIN cpu_image ci "
				+ "		ON c.cpu_image_no = ci.cpu_image_no "
				+ "GROUP BY o.product_name "
				+ "	order BY SUM(o.category_quantity) desc LIMIT 0,? " ;
		try {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, cpuRanking);
				rs = stmt.executeQuery();
				while(rs.next()) {
					Map<String, Object> map = new HashMap<String, Object> ();
					map.put("productName", rs.getString("productName"));
					map.put("cpuImage", rs.getString("cpuImage"));
					list.add(map);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	// 판매 순위
	public List<Map<String, Object>> rankCaseImage(int caseRanking) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// DB 변수 선언
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs= null;
		conn = DButil.getConnection();
		String sql ="SELECT o.product_name productName,c.case_image_no, ci.name caseImage,SUM(o.category_quantity) s  "
				+ "FROM `order` o "
				+ "	INNER JOIN `case` c "
				+ "		ON o.product_name = c.case_name "
				+ "	INNER JOIN case_image ci "
				+ "		ON c.case_image_no = ci.case_image_no "
				+ "GROUP BY o.product_name "
				+ "	order BY SUM(o.category_quantity) desc LIMIT 0,? " ;
		try {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, caseRanking);
				rs = stmt.executeQuery();
				while(rs.next()) {
					Map<String, Object> map = new HashMap<String, Object> ();
					map.put("productName", rs.getString("productName"));
					map.put("caseImage", rs.getString("caseImage"));
					map.put("s", rs.getInt("s"));
					list.add(map);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	// 판매 순위
	public List<Map<String, Object>> rankCoolerImage(int coolerRanking) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// DB 변수 선언
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs= null;
		conn = DButil.getConnection();
		String sql ="SELECT product_name productName,c.cooler_image_no, ci.name coolerImage,SUM(o.category_quantity) s "
				+ " FROM `order` o "
				+ "	INNER JOIN cooler c "
				+ "		ON o.product_name = c.cooler_name "
				+ "	INNER JOIN cooler_image ci "
				+ "		ON c.cooler_image_no = ci.cooler_image_no "
				+ " GROUP BY o.product_name "
				+ "	ORDER BY SUM(o.category_quantity) desc LIMIT 0,? " ;
		try {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, coolerRanking);
				rs = stmt.executeQuery();
				while(rs.next()) {
					Map<String, Object> map = new HashMap<String, Object> ();
					map.put("productName", rs.getString("productName"));
					map.put("coolerImage", rs.getString("coolerImage"));
					map.put("s", rs.getString("s"));
					list.add(map);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	// 판매 순위
	public List<Map<String, Object>> rankGpuImage(int gpuRanking) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// DB 변수 선언
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs= null;
		conn = DButil.getConnection();
		String sql ="SELECT product_name productName,g.gpu_image_no , ci.name gpuImage, SUM(o.category_quantity) s  "
				+ "FROM `order` o "
				+ "	INNER JOIN gpu g "
				+ "		ON o.product_name = g.gpu_name "
				+ "	INNER JOIN gpu_image ci "
				+ "		ON g.gpu_image_no = ci.gpu_image_no "
				+ " GROUP BY o.product_name "
				+ "	order BY SUM(o.category_quantity) desc LIMIT 0,? " ;
		try {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, gpuRanking);
				rs = stmt.executeQuery();
				while(rs.next()) {
					Map<String, Object> map = new HashMap<String, Object> ();
					map.put("productName", rs.getString("productName"));
					map.put("gpuImage", rs.getString("gpuImage"));
					list.add(map);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	// 판매 순위
	public List<Map<String, Object>> rankMainboardImage(int mianboardRanking) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// DB 변수 선언
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs= null;
		conn = DButil.getConnection();
		String sql ="SELECT o.product_name productName,m.mainboard_image_no , mi.name mainboardImage,SUM(o.category_quantity) s "
				+ "FROM `order` o "
				+ "	INNER JOIN mainboard m "
				+ "		ON o.product_name = m.mainboard_name "
				+ "	INNER JOIN mainboard_image mi "
				+ "		ON m.mainboard_image_no = mi.mainboard_image_no "
				+ " GROUP BY o.product_name "
				+ "	order BY SUM(o.category_quantity) desc LIMIT 0,? " ;
		try {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, mianboardRanking);
				rs = stmt.executeQuery();
				while(rs.next()) {
					Map<String, Object> map = new HashMap<String, Object> ();
					map.put("productName", rs.getString("productName"));
					map.put("mainboardImage", rs.getString("mainboardImage"));
					list.add(map);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	// 판매 순위
	public List<Map<String, Object>> rankPowerImage(int powerRanking) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// DB 변수 선언
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs= null;
		conn = DButil.getConnection();
		String sql ="SELECT o.product_name productName,p.power_image_no , pi.name powerImage,SUM(o.category_quantity) s "
				+ "FROM `order` o "
				+ "	INNER JOIN `power` p "
				+ "		ON o.product_name = p.power_name "
				+ "	INNER JOIN power_image pi "
				+ "		ON p.power_no = pi.power_image_no "
				+ " GROUP BY o.product_name "
				+ "	order BY SUM(o.category_quantity) desc LIMIT 0,? ";
		try {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, powerRanking);
				rs = stmt.executeQuery();
				while(rs.next()) {
					Map<String, Object> map = new HashMap<String, Object> ();
					map.put("productName", rs.getString("productName"));
					map.put("powerImage", rs.getString("powerImage"));
					list.add(map);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	// 판매 순위
	public List<Map<String, Object>> rankRamImage(int ramRanking) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// DB 변수 선언
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs= null;
		conn = DButil.getConnection();
		String sql ="SELECT o.product_name productName,r.ram_image_no , ri.name ramImage,SUM(o.category_quantity) s  "
				+ " FROM `order` o "
				+ "	INNER JOIN ram r "
				+ "		ON o.product_name = r.ram_name "
				+ "	INNER JOIN ram_image ri "
				+ "		ON r.ram_no = ri.ram_image_no "
				+ "GROUP BY product_name "
				+ "	order BY SUM(o.category_quantity) desc LIMIT 0,? ";
		try {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, ramRanking);
				rs = stmt.executeQuery();
				while(rs.next()) {
					Map<String, Object> map = new HashMap<String, Object> ();
					map.put("productName", rs.getString("productName"));
					map.put("ramImage", rs.getString("ramImage"));
					list.add(map);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	// 판매 순위
	public List<Map<String, Object>> rankStorageImage(int storageRanking) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// DB 변수 선언
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs= null;
		conn = DButil.getConnection();
		String sql ="SELECT o.product_name productName,st.storage_image_no , si.name storageImage,SUM(o.category_quantity) s "
				+ " FROM `order` o "
				+ "	INNER JOIN `storage` st "
				+ "		ON o.product_name = st.storage_name "
				+ "	INNER JOIN storage_image si "
				+ "		ON st.storage_no = si.storage_image_no "
				+ " GROUP BY product_name "
				+ "	order BY SUM(o.category_quantity) desc LIMIT 0,? ";
		try {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, storageRanking);
				rs = stmt.executeQuery();
				while(rs.next()) {
					Map<String, Object> map = new HashMap<String, Object> ();
					map.put("productName", rs.getString("productName"));
					map.put("storageImage", rs.getString("storageImage"));
					map.put("s", rs.getString("s"));
					list.add(map);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	// 날짜별로 주문 내역 리스트(MyPaymentController) // 관리자 페이지에서 관리자는 전체 주문내역 리스트를 볼 수 있음
	public List<Map<String, Object>> selectOrderDateList(String customerId, String adminId, String updateCheck) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// DB 초기화
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		//  DBUtil
		conn = DButil.getConnection();
		String sql = "SELECT o.customer_id customerId"
				+ "		,o.product_name productName"
				+ "		,o.create_date createDate"
				+ "		,SUM(o.category_price) totalPrice"
				+ "		,o.order_no orderNo"
				+ "		,o.order_status orderStatus"
				+ "		,o.zip_code zipCode"
				+ "		,o.detail_address detailAddress"
				+ "		,o.road_address roadAddress"
				+ "		,o.order_status orderStatus"
				+ "		,COUNT(*) productCount"
				+ " FROM `order` o";
		
		if(adminId != null) { // 관리자 페이지에서 관리자는 전체 주문내역 리스트를 볼 수 있음(주문 상태 변경건 제외 -> 페이지 분리)
			if(updateCheck == null) {
				sql += " WHERE (o.refund_check='N' AND o.cancel_check='N')"; // updateCheck로 폼 확인
			} else {
				sql += " WHERE (o.refund_check='Y' OR o.cancel_check='Y')";
			}
			sql+= " GROUP BY o.create_date"
				+ " ORDER BY o.create_date DESC";
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, customerId);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if(customerId != null) {
			sql  += " WHERE o.customer_id=?"
					+ " GROUP BY o.create_date"
					+ " ORDER BY o.create_date DESC";
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, customerId);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(sql);
		try {
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("customerId", rs.getString("customerId"));
				map.put("createDate", rs.getString("createDate"));
				map.put("totalPrice", rs.getString("totalPrice"));
				map.put("orderStatus", rs.getString("orderStatus"));
				map.put("productName", rs.getString("productName"));
				map.put("orderNo", rs.getInt("orderNo"));
				map.put("zipCode", rs.getString("zipCode"));
				map.put("detailAddress", rs.getString("detailAddress"));
				map.put("roadAddress", rs.getString("roadAddress"));
				map.put("orderStatus", rs.getString("orderStatus"));
				map.put("productCount", rs.getInt("productCount"));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	// 관리자 주문 상태 변경 (주문 변경/변경x)
	public int AdminUpdateOrderStatus(String orderStatus, String customerId, String createDate, String updateCheck, int orderNo) {
		int row = 0;
		// DB 변수 선언
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		String sql = "UPDATE `order` SET order_status=? WHERE customer_id=? AND create_date=?";
		if(orderNo != 0 || (updateCheck != null && !"".equals(updateCheck))) { // updateCheck가 null이 아니면 쿼리 조건 추가
			sql += " AND order_no=?";
		}
		try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, orderStatus);
				stmt.setString(2, customerId);
				stmt.setString(3, createDate);
				if((updateCheck != null && !"".equals(updateCheck)) || orderNo!=0) {
					stmt.setInt(4, orderNo);
				}
				row = stmt.executeUpdate();
			} catch (SQLException e) {
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
	// 고객 취소/환불 여부 변경
	public int updateOrderStatus(String customerUpdateCheck, int orderNo) {
		int row = 0;
		// DB 변수 선언
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();

		String sql = null;
		if("cancel".equals(customerUpdateCheck)) {
			sql = "UPDATE `order` SET cancel_check='Y', order_status='취소 요청중' WHERE order_no=?";
		} else if("refund".equals(customerUpdateCheck)) {
			sql = "UPDATE `order` SET refund_check='Y', order_status='교환 요청중' WHERE order_no=?";
		}
		try {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, orderNo);
				row = stmt.executeUpdate();
		} catch (SQLException e) {
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
	// 회원별 주문내역 상세보기
	public ArrayList<Order> selectOrderList(String customerId, String createDate, String updateCheck, int orderNo) {
		ArrayList<Order> list = new ArrayList<Order>();
		Order checkout = null;
		// DB 초기화
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		//  DBUtil
		conn = DButil.getConnection();
		String sql = "SELECT order_no orderNo"
				+ "		,customer_id customerId "
				+ "		,basket_no basketNo"
				+ "		,category_number categoryNumber"
				+ "		,category_name categoryName"
				+ "		,product_name productName"
				+ "		,category_price categoryPrice"
				+ "	 	,category_quantity categoryQuantity"
				+ "		,create_date createDate"
				+ "		,order_status orderStatus"
				+ "		,zip_code zipCode"
				+ "		,road_address roadAddress"
				+ "		,detail_address detailAddress"
				+ " FROM `order`";
			if(updateCheck == null || "".equals(updateCheck)) {
				sql += " WHERE customer_id = ? AND create_date = ?";
				try {
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, customerId);
					stmt.setString(2, createDate);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				sql += " WHERE customer_id = ? AND create_date = ?"
						+ " AND (refund_check='Y' OR cancel_check='Y')";
				try {
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, customerId);
					stmt.setString(2, createDate);
					stmt.setInt(3, orderNo);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		try {
			rs = stmt.executeQuery();
			while(rs.next()) {
				checkout = new Order();
				checkout.setOrderNo(rs.getInt("orderNo"));
				checkout.setCustomerId(rs.getString("customerId"));
				checkout.setBasketNo(rs.getInt("basketNo"));
				checkout.setCategoryNumber(rs.getInt("categoryNumber"));
				checkout.setCategoryName(rs.getString("categoryName"));
				checkout.setCategoryPrice(rs.getInt("categoryPrice"));
				checkout.setCategoryQuantity(rs.getInt("categoryQuantity"));
				checkout.setCreateDate(rs.getString("createDate"));
				checkout.setOrderStatus(rs.getString("orderStatus"));
				checkout.setProductName(rs.getString("productName"));
				checkout.setZipCode(rs.getInt("zipCode"));
				checkout.setRoadAddress(rs.getString("roadAddress"));
				checkout.setDetailAddress(rs.getString("detailAddress"));
				list.add(checkout);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
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