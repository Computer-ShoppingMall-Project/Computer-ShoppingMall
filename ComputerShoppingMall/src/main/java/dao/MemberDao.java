package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DButil;
import vo.Admin;
import vo.Customer;

public class MemberDao {
      // 1) 로그인 page
      public String selectMemberByIdPw(Customer member) {
         // 로그인 실패 -> null
         String customerId = null; 
         // DB 초기화
         Connection conn = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         // DButil
         conn = DButil.getConnection();
         // SQL 쿼리
         String sql = " SELECT * FROM customer "
               + "WHERE customer_id=? AND customer_pw=PASSWORD(?)";
         try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, member.getCustomerId());
            stmt.setString(2, member.getCustomerPw());
            rs =stmt.executeQuery();
            if(rs.next()) {
               customerId = rs.getString("customer_id");
             }
               } catch (Exception e) {
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
         return customerId;
      }
      
      // 2) 회원 정보 상세보기 page
      public Customer selectMemberOne(String customerId) {
         Customer c = new Customer();
         // DB 초기화
         Connection conn = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         // DButil
         conn = DButil.getConnection();
         String sql = "SELECT customer_id customerId"
               + "               ,name"
               + "               ,nickname nickName"
               + "               ,email"
               + "               ,phone"
               + "               ,zip_code zipCode"
               + "               ,province"
               + "               ,city"
               + "               ,town"
               + "               ,road_address roadAddress"
               + "               ,detail_address detailAddress"
               + "               ,create_date createDate"
               + "               ,update_date updateDate"
               + "               ,active"
               + "       FROM customer"
               + "       WHERE customer_id=? ";
         try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, customerId);
            rs = stmt.executeQuery();
            if(rs.next()) {
               c.setCustomerId(rs.getString("customerId"));
               c.setName(rs.getString("name"));
               c.setNickName(rs.getString("nickName"));
               c.setEmail(rs.getString("email"));
               c.setPhone(rs.getString("phone"));
               c.setZipCode(rs.getInt("zipCode"));
               c.setProvince(rs.getString("province"));
               c.setCity(rs.getString("city"));
               c.setTown(rs.getString("town"));
               c.setRoadAddress(rs.getString("roadAddress"));
               c.setDetailAddress(rs.getString("detailAddress"));
               c.setCreateDate(rs.getString("createDate"));
               c.setUpdateDate(rs.getString("updateDate"));
               c.setActive(rs.getInt("active"));
            }
               } catch (Exception e) {
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
         return c;
      }
      
      // 3) 일반 회원 가입 page
      public int insertMember(Customer member) {
         // 회원 가입 성공 여부 리턴할 정수형 변수 선언
         int row = -1; 
         // 로그인 실패시, 처리 코드 -> memberId = null
         String customerId = null; 
         // DB 초기화
         Connection conn = null;
         PreparedStatement stmt = null;
         // DButil
         conn = DButil.getConnection();
         String sql = "INSERT INTO customer (customer_id"
               + "                     ,customer_pw"
               + "                   ,name"
               + "                     ,nickname"
               + "                     ,email"
               + "                     ,phone"
               + "                     ,zip_code"
               + "                     ,province"
               + "                     ,city"
               + "                     ,town"
               + "                     ,road_address"
               + "                     ,detail_address"
               + "                     ,create_date"
               + "                     ,update_date)"
               + "   VALUES(?, PASSWORD(?), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW()) ";
         try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, member.getCustomerId());
            stmt.setString(2, member.getCustomerPw());
            stmt.setString(3, member.getName());
            stmt.setString(4, member.getNickName());
            stmt.setString(5, member.getEmail());
            stmt.setString(6, member.getPhone());
            stmt.setInt(7, member.getZipCode());
            stmt.setString(8, member.getProvince());
            stmt.setString(9, member.getCity());
            stmt.setString(10, member.getTown());
            stmt.setString(11, member.getRoadAddress());
            stmt.setString(12, member.getDetailAddress());
            stmt.setString(13, member.getCreateDate());
            stmt.setString(14, member.getUpdateDate());
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
      
      // 3-1) 아이디 중복 체크
      public int idCheckMember(String customerId) {
         // 아이디 중복 여부 리턴할 정수형 변수 선언
         int row = -1;
         // DB 초기화
         Connection conn = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         // DButil
         conn = DButil.getConnection();
         String sql = "SELECT * FROM customer WHERE customer_id = ?";
         try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, customerId);
            rs = stmt.executeQuery();
            
            if(rs.next()) {
               row = 1;
               System.out.println("중복아이디가 존재!");
            } else {
               row = 0;
               System.out.println("가입가능한 아이디입니다!");
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
      
      // 4) 회원 삭제 page
      public int deleteMember(Customer member) {
         // 회원 삭제 성공 여부 리턴할 정수형 변수 선언
         int row = -1; 
         // DB 초기화
         Connection conn = null;
         PreparedStatement stmt = null;
         // DButil
         conn = DButil.getConnection();
         // 1) customer 테이블 데이터 삭제
         String sql1 = "UPDATE customer SET active=1 WHERE customer_id=? AND customer_pw=PASSWORD(?)";
         try {
            // auto commit 해제
            conn.setAutoCommit(false); 
            // 1) customer 테이블 데이터 삭제
            stmt = conn.prepareStatement(sql1);
            stmt.setString(1, member.getCustomerId());
            stmt.setString(2, member.getCustomerPw());
            row = stmt.executeUpdate();
            // 삭제 성공(row값이 1) -> commit / 이외 상황 rollback
            if (row == 1) { 
               conn.commit();
            } else { 
               conn.rollback();
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
      
      // 5) 회원 정보 수정 page
      public int updateMember(Customer member) {
         // 회원 정보 수정 성공 여부 리턴할 정수형 변수 선언
         int row = -1; 
         // 로그인 실패시, 처리 코드 -> customerId = null
         String customerId = null;
         // DB 초기화
         Connection conn = null;
         PreparedStatement stmt = null;
         // DButil
         conn = DButil.getConnection();
         // SQL 쿼리
         String sql = "UPDATE customer SET name=? "
               + "                  ,nickname=? "
               + "                  ,email=? "
               + "                  ,phone=? "
               + "                  ,zip_code=? "
               + "                  ,province=? "
               + "                  ,city=? "
               + "                  ,town=? "
               + "                  ,road_address=? "
               + "                  ,detail_address=? "
               + "   WHERE customer_id=? ";
         try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, member.getName());
            stmt.setString(2, member.getNickName());
            stmt.setString(3, member.getEmail());
            stmt.setString(4, member.getPhone());
            stmt.setInt(5, member.getZipCode());
            stmt.setString(6, member.getProvince());
            stmt.setString(7, member.getCity());
            stmt.setString(8, member.getTown());
            stmt.setString(9, member.getRoadAddress());
            stmt.setString(10, member.getDetailAddress());
            stmt.setString(11, member.getCustomerId());
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
      
      // 6) 비밀번호 수정
      public int updateMemberPasswordByIdPw(Customer member, String newCustomerPw) {
         // 회원 정보 수정 성공 여부 리턴할 정수형 변수 선언
         int row = -1; 
         // 로그인 실패시, 처리 코드 -> customerId = null
         String customerId = null;
         if(newCustomerPw.equals("")) {
            newCustomerPw = member.getCustomerPw();
         }
         // DB 초기화
         Connection conn = null;
         PreparedStatement stmt = null;
         // DButil
         conn = DButil.getConnection();
         // SQL 쿼리
         String sql = "UPDATE customer SET name =? "
               + "                  ,nickname=? "
               + "                  ,email=? "
               + "                  ,phone=? "
               + "                  ,zip_code=? "
               + "                  ,province=? "
               + "                  ,city=? "
               + "                  ,town=? "
               + "                  ,road_address=? "
               + "                  ,detail_address=? "
               + "                  ,customer_pw = PASSWORD(?) "
               + "   WHERE customer_id=? AND customer_pw = PASSWORD(?)";
         try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, member.getName());
            stmt.setString(2, member.getNickName());
            stmt.setString(3, member.getEmail());
            stmt.setString(4, member.getPhone());
            stmt.setInt(5, member.getZipCode());
            stmt.setString(6, member.getProvince());
            stmt.setString(7, member.getCity());
            stmt.setString(8, member.getTown());
            stmt.setString(9, member.getRoadAddress());
            stmt.setString(10, member.getDetailAddress());
            stmt.setString(11, newCustomerPw);
            stmt.setString(12, member.getCustomerId());
            stmt.setString(13, member.getCustomerPw());
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
      
      // 6-1) 현재 비밀번호 체크
      public int pwCheckMember(String customerPw) {
         // 아이디 중복 여부 리턴할 정수형 변수 선언
         int row = -1;
         // DB 초기화
         Connection conn = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         // DButil
         conn = DButil.getConnection();
         String sql = "SELECT * FROM customer WHERE customer_pw = PASSWORD(?) ";
         try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, customerPw);
            rs = stmt.executeQuery();

            if (rs.next()) {
               row = 1;
               System.out.println("비밀번호 일치!");
            } else {
               row = 0;
               System.out.println("현재 비밀번호 틀림!");
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
      
      // 7) 관리자 로그인
      public String selectAdminByIdPw(Admin a) {
         // 로그인 실패 -> null
         String customerId = null; 
         // DB 초기화
         Connection conn = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         // DButil
         conn = DButil.getConnection();
         // SQL 쿼리
         String sql = " SELECT * FROM admin "
               + "WHERE admin_id=? AND admin_pw=PASSWORD(?)";
         try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, a.getAdminId());
            stmt.setString(2, a.getAdminPw());
            rs =stmt.executeQuery();
            if(rs.next()) {
               customerId = rs.getString("admin_id");
             }
               } catch (Exception e) {
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
         return customerId;
      }
      /*
      // 아이디리스트 -> 아이디중복 확인용
      public ArrayList<Customer> MemberIdList() {
         ArrayList<Customer> list = new ArrayList<Customer>();
         Connection conn = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         // DButil
         conn = DButil.getConnection();
         // SQL 쿼리
         String sql = "SELECT customer_id customerId FROM customer;";
         try {
            stmt = conn.prepareStatement(sql);
            rs =stmt.executeQuery();
            while(rs.next()) {
               Customer c = new Customer();
               c.setCustomerId(rs.getString("customerId"));
               list.add(c);
            }
               } catch (Exception e) {
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
      */
   
      // 아이디 변경 90일 체크
      public Customer lastPwDate(String customerId) {
         Customer cu = new Customer();
         // DB 초기화
         Connection conn = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         // DButiil
         conn = DButil.getConnection();
         // 입력된 아이디의 비밀번호 변경날짜를 시간 제외시키고 날짜만 불러오기
         String sql = "SELECT STR_TO_DATE(last_pw_date,'%Y-%m-%d') date " 
               + "FROM customer "
               + "WHERE customer_id = ?";

         try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, customerId); // ?에 customerId 셋팅
            rs = stmt.executeQuery();

            if (rs.next()) {
               cu.setlastPwDate(rs.getString("date"));
               System.out.println("MemberDao.selectlastPwDate() date :" + cu);
            }
         } catch (Exception e) {
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

         return cu;
      }

      public void updatePlusMonth(String customerId) {
         // DB연결을 위한 자원 준비
         Connection conn = null;
         PreparedStatement stmt = null;
         conn = DButil.getConnection();
         // customer의 비밀번호, 회원정보 수정당시 날짜 + 3개월 하여 연장된 값 last_pw_date에 저장 하기
         String sql = "UPDATE customer SET last_pw_date = date_add(NOW(), INTERVAL 3 MONTH) WHERE customer_id=?";
         try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, customerId);
            int row = stmt.executeUpdate();
            if (row == 1) {
               System.out.println("updatePlusMonth 수정 성공");
            } else {
               System.out.println("updatePlusMonth 수정 실패");
            }

         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            try {
               conn.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
      }
      // 관리자 고객 정보 리스트&상세보기 -> ID, 고객 이름으로 검색기능(AdminCustomerListController), 탈퇴회원은 볼 수 없음
      public List<Customer> AdminselectMemberOne(String customerId, String name, String active) {
    	 List<Customer> list = new ArrayList<Customer>();
         Customer c = null;
         // DB 초기화
         Connection conn = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         // DButil
         conn = DButil.getConnection();
         String sql = "SELECT customer_id customerId"
               + "               ,name"
               + "               ,nickname nickName"
               + "               ,email"
               + "               ,phone"
               + "               ,zip_code zipCode"
               + "               ,province"
               + "               ,city"
               + "               ,town"
               + "               ,road_address roadAddress"
               + "               ,detail_address detailAddress"
               + "               ,create_date createDate"
               + "               ,update_date updateDate"
               + "               ,active"
               + "       FROM customer"
               + "       WHERE customer_id LIKE ? AND name LIKE ? AND active=?";
         try {
            stmt = conn.prepareStatement(sql);
            System.out.println(sql);
            stmt.setString(1, "%"+customerId+"%");
            stmt.setString(2, "%"+name+"%");
            stmt.setString(3, active);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
               c = new Customer();
               c.setCustomerId(rs.getString("customerId"));
               c.setName(rs.getString("name"));
               c.setNickName(rs.getString("nickName"));
               c.setEmail(rs.getString("email"));
               c.setPhone(rs.getString("phone"));
               c.setZipCode(rs.getInt("zipCode"));
               c.setProvince(rs.getString("province"));
               c.setCity(rs.getString("city"));
               c.setTown(rs.getString("town"));
               c.setRoadAddress(rs.getString("roadAddress"));
               c.setDetailAddress(rs.getString("detailAddress"));
               c.setCreateDate(rs.getString("createDate"));
               c.setUpdateDate(rs.getString("updateDate"));
               c.setActive(rs.getInt("active"));
               list.add(c);
            }
               } catch (Exception e) {
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