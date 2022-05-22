package dao;

import java.sql.*;

import util.DButil;
import vo.Qna;
import java.util.*;

public class QnaDao {
	// 고객 QNA 등록
	public int insertQna(Qna qna) {
		int row = 0; // 등록 성공시 1, 등록 실패시 0 반환 -> 디버깅, 등록확인 변수
		// DB변수 기본값(null)으로 선언
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection(); // DB연결 static 메서드 값 셋팅
		String sql = "INSERT INTO qna" // 고객 QNA 등록 SQL 쿼리문 String sql 변수에 대입
				+ "(customer_id"
				+ ", qna_title"
				+ ", qna_content"
				+ ", create_date"
				+ ", update_date)"
				+ " VALUES(?, ?, ?, NOW(), NOW())";
		try {
			stmt = conn.prepareStatement(sql); // sql 쿼리 셋팅
			stmt.setString(1, qna.getCustomerId()); // customer_id = ?
			stmt.setString(2, qna.getQnaTitle()); // qna_title = ?
			stmt.setString(3, qna.getQnaContent()); // qna_content = ?
			row = stmt.executeUpdate(); // row에 입력 성공여부 값 대입
		} catch (SQLException e) {
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
	// 고객 QNA 상세보기
	public Qna selectQnaOne(String customerId, int qnaNo) {
		Qna qna = null; // 상세정보 담는 Qna vo
		// DB변수 기본값(null)으로 선언
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection(); // DB연결 static 메서드 값 셋팅
		String sql = "SELECT" // 고객 QNA 상세보기 SQL 쿼리문 String sql 변수에 대입
				+ " qna_no qnaNo"
				+ ", customer_id customerId"
				+ ", qna_title qnaTitle"
				+ ", qna_content qnaContent"
				+ ", qna_answer qnaAnswer"
				+ ", create_date createDate"
				+ ", update_date updateDate"
				+ " FROM qna"
				+ " WHERE customer_id=? AND qna_no=?";
		try {
			stmt = conn.prepareStatement(sql); // sql 쿼리 셋팅
			stmt.setString(1, customerId); // customer_id=?
			stmt.setInt(2, qnaNo); // qna_no=?
			rs = stmt.executeQuery();
			// 데이터 변환(가공)
			if(rs.next()) {
				// qna vo에 값 셋팅
				qna = new Qna();
				qna.setQnaNo(rs.getInt("qnaNo"));
				qna.setCustomerId(rs.getString("customerId"));
				qna.setQnaTitle(rs.getString("qnaTitle"));
				qna.setQnaContent(rs.getString("qnaContent"));
				qna.setQnaAnswer(rs.getString("qnaAnswer"));
				qna.setCreateDate(rs.getString("createDate"));
				qna.setUpdateDate(rs.getString("updateDate"));
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
		return qna;
	}
	// 고객별 QNA 리스트
	public ArrayList<Qna> selectQnaList(String customerId) {
		ArrayList<Qna> list = new ArrayList<Qna>(); // QNA 리스트 정보를 담는 ArrayList
		Qna qna = null; // qna vo
		// DB변수 기본값(null)으로 선언
		Connection conn = null; 
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection(); // DB연결 static 메서드 값 셋팅
		String sql = "SELECT *" // 고객 QNA 리스트 SQL 쿼리문 String sql 변수에 대입
					+ " FROM ("
					+ "      SELECT @ROWNUM:=@ROWNUM+1 AS rowNum"
					+ "             , Q.qna_no AS qnaNo"
					+ "              , Q.qna_title AS qnaTitle"
					+ "              , (CASE WHEN Q.qna_answer IS NULL THEN 'X'"
					+ "                       ELSE 'O' END"
					+ "               ) AS qnaAnswer"
					+ "              , Q.create_date createDate"
					+ "          FROM qna Q"
					+ "              ,(SELECT @ROWNUM:=0) R" // 고객에게 보이는 QNA 번호 추가
					+ "       WHERE Q.customer_id = ?"
					+ "        ORDER BY Q.create_date"
					+ "     ) A"
					+ " ORDER BY A.createDate desc"; 
		try {
			stmt = conn.prepareStatement(sql); // sql 쿼리 셋팅
			stmt.setString(1, customerId); // customer_id=?
			rs = stmt.executeQuery();
			// 데이터 변환(가공)
			while(rs.next()) {
				qna = new Qna(); // qna vo 선언
				// vo 값 셋팅
				qna.setCustomerNo(rs.getInt("rowNum"));
				qna.setQnaNo(rs.getInt("qnaNo"));
				qna.setQnaTitle(rs.getString("qnaTitle"));
				qna.setQnaAnswer(rs.getString("qnaAnswer"));
				qna.setCreateDate(rs.getString("createDate"));
				list.add(qna); // qna vo list에 추가
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB자원 반납
				rs.close();
				stmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	// 고객 QNA 수정
	public int updateQna(Qna qna) {
		int row = 0;  // 등록 성공시 1, 등록 실패시 0 반환 -> 디버깅, 등록확인 변수
		// DB변수 기본값(null)으로 선언
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection(); // DB연결 static 메서드 값 셋팅
		String sql = "UPDATE qna SET " // 고객 QNA 수정 SQL 쿼리문 String sql 변수에 대입
				+ " qna_title=?"
				+ ", qna_content=?"
				+ ", update_date = NOW()"
				+ " WHERE customer_id=? AND qna_no=?";
		try {
			stmt = conn.prepareStatement(sql); // sql 쿼리 셋팅
			stmt.setString(1, qna.getQnaTitle()); // qna_title=?
			stmt.setString(2, qna.getQnaContent()); // qna_content=?
			stmt.setString(3, qna.getCustomerId()); // customer_id=?
			stmt.setInt(4, qna.getQnaNo()); // qna_no=?
			row = stmt.executeUpdate(); // row에 입력 성공여부 값 대입
		} catch (SQLException e) {
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
	// QNA 삭제
	public int deleteQna(int qnaNo, String customerId) {
		int row = 0; // 등록 성공시 1, 등록 실패시 0 반환 -> 디버깅, 등록확인 변수
		// DB변수 기본값(null)으로 선언
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection(); // DB연결 static 메서드 값 셋팅
		String sql = "DELETE FROM qna WHERE qna_no=? AND customer_id=?"; // 고객 QNA 삭제 SQL 쿼리문 String sql 변수에 대입
		try {
			stmt = conn.prepareStatement(sql); // sql 쿼리 셋팅
			stmt.setInt(1, qnaNo); // qna_no=?
			stmt.setString(2, customerId); // customer_id=?
			row = stmt.executeUpdate(); // row에 입력 성공여부 값 대입
		} catch (SQLException e) {
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
	
	// 관리자 QNA 목록(고객 전채 문의 리스트)
	public ArrayList<Qna> selectQnaListAdmin(String answer) {
		ArrayList<Qna> list = new ArrayList<Qna>();
		Qna qna = null;
		// DB변수 기본값(null)으로 선언
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection(); // DB연결 static 메서드 값 셋팅
		String sql = "SELECT" // 관리자 QNA 목록 SQL 쿼리문 String sql 변수에 대입
				+ " qna_no qnaNo"
				+ ", customer_id customerId"
				+ ", qna_title qnaTitle"
				+ ", qna_answer qnaAnswer"
				+ ", create_date createDate"
				+ ", update_date updateDate"
				+ " FROM qna";
		if("answer".equals(answer)) {
			sql += " WHERE qna_answer IS NOT null ORDER BY create_date DESC"; // 답변 모아보기 선택이 있다면 qna_answer != null값만 보여주기
		} else if("noAnswer".equals(answer)) {
			sql += " WHERE qna_answer IS null ORDER BY create_date DESC"; // 미답변 모아보기 선택이 있다면 qna_answer = null값만 보여주기
		} else {
			sql += " ORDER BY create_date DESC"; // 아니라면 전체보여주기
		}
		try {
			stmt = conn.prepareStatement(sql); // sql 쿼리 셋팅
			rs = stmt.executeQuery();
			// 데이터 변환(가공)
			while(rs.next()) {
				qna = new Qna();  // qna vo 선언
				// vo 값 셋팅
				qna.setQnaNo(rs.getInt("qnaNo"));
				qna.setCustomerId(rs.getString("customerId"));
				qna.setQnaTitle(rs.getString("qnaTitle"));
				qna.setQnaAnswer(rs.getString("qnaAnswer"));
				qna.setCreateDate(rs.getString("createDate"));
				qna.setUpdateDate(rs.getString("updateDate"));
				list.add(qna); // list에 qna vo 추가
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
	// 관리자 - QNA 상세보기
	public Qna selectQnaOneAdmin(int qnaNo) {
		Qna qna = null;
		// DB변수 기본값(null)으로 선언
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection(); // DB연결 static 메서드 값 셋팅
		String sql = "SELECT" // 관리자 QNA 상세보기 SQL 쿼리문 String sql 변수에 대입
				+ " qna_no qnaNo"
				+ ", customer_id customerId"
				+ ", qna_title qnaTitle"
				+ ", qna_content qnaContent"
				+ ", qna_answer qnaAnswer"
				+ ", create_date createDate"
				+ ", update_date updateDate"
				+ " FROM qna"
				+ " WHERE qna_no=?";
		try {
			stmt = conn.prepareStatement(sql); // sql 쿼리 셋팅
			stmt.setInt(1, qnaNo); // qna_no=?
			rs = stmt.executeQuery();
			// 데이터 변환(가공)
			if(rs.next()) {
				qna = new Qna();  // qna vo 선언
				// vo 값 셋팅
				qna.setQnaNo(rs.getInt("qnaNo"));
				qna.setCustomerId(rs.getString("customerId"));
				qna.setQnaTitle(rs.getString("qnaTitle"));
				qna.setQnaContent(rs.getString("qnaContent"));
				qna.setQnaAnswer(rs.getString("qnaAnswer"));
				qna.setCreateDate(rs.getString("createDate"));
				qna.setUpdateDate(rs.getString("updateDate"));
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
		return qna;
	}
	// 관리자 QNA 답변 등록 / 수정
	public int updateQnaAdmin(String qnaAnswer, int qnaNo) {
		int row = 0; // 등록 성공시 1, 등록 실패시 0 반환 -> 디버깅, 등록확인 변수
		// DB변수 기본값(null)으로 선언
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection(); // DB연결 static 메서드 값 셋팅
		String sql = "UPDATE qna SET qna_answer=? WHERE qna_no=?"; // 관리자 QNA 답변 수정/등록 SQL 쿼리문 String sql 변수에 대입
		try {
			stmt = conn.prepareStatement(sql); // sql 쿼리 셋팅
			stmt.setString(1, qnaAnswer); // qna_answer=?
			stmt.setInt(2, qnaNo); // qna_no=?
			row = stmt.executeUpdate(); // row에 입력 성공여부 값 대입
		} catch (SQLException e) {
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
}