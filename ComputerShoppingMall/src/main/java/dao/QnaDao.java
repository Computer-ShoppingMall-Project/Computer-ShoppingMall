package dao;

import java.sql.*;

import util.DButil;
import vo.Qna;
import java.util.*;

public class QnaDao {
	// 고객 QNA 등록
	public int insertQna(Qna qna) {
		int row = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DButil.getConnection();
		String sql = "INSERT INTO qna"
				+ "(customer_id"
				+ ", qna_title"
				+ ", qna_content"
				+ ", create_date"
				+ ", update_date)"
				+ " VALUES(?, ?, ?, NOW(), NOW())";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, qna.getCustomerId());
			stmt.setString(2, qna.getQnaTitle());
			stmt.setString(3, qna.getQnaContent());
			row = stmt.executeUpdate();
		} catch (SQLException e) {
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
	// 고객 QNA 상세보기
	public ArrayList<Qna> selectQnaOne(String customerId) {
		ArrayList<Qna> list = new ArrayList<Qna>();
		Qna qna = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		String sql = "SELECT"
				+ " qna_no qnaNo"
				+ ", customer_id customerId"
				+ ", qna_title qnaTitle"
				+ ", qna_content qnaContent"
				+ ", qna_answer qnaAnswer"
				+ ", create_date createDate"
				+ ", update_date updateDate"
				+ " FROM qna"
				+ " WHERE customer_id=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customerId);
			rs = stmt.executeQuery();
			while(rs.next()) {
				qna = new Qna();
				qna.setQnaNo(rs.getInt("qnaNo"));
				qna.setCustomerId(rs.getString("customerId"));
				qna.setQnaTitle(rs.getString("qnaTitle"));
				qna.setQnaContent(rs.getString("qnaContent"));
				qna.setQnaAnswer(rs.getString("qnaAnswer"));
				qna.setCreateDate(rs.getString("createDate"));
				qna.setUpdateDate(rs.getString("updateDate"));
				list.add(qna);
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
	// 고객 QNA 수정
	/*
	 * public int updateQna(Qna qna) {
	 * 
	 * }
	 */
}
