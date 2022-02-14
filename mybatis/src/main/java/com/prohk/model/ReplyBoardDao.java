package com.prohk.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReplyBoardDao {
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "tis";
	String pw = "1234";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public void getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 새 글쓰기
	public int insertBoard(ReplyBoardDto replyBoardDto) {
		int result = 0;
		
		try {
			getConnection();
			int reGroup = 0;
			int reLevel = 1;
			int reStep = 1;
			
			String reGroupSql = "select max(regroup) as regroupmax from reply_board";
			
			pstmt = conn.prepareStatement(reGroupSql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				reGroup = rs.getInt("reGroupMax") + 1;
			}
			
			String sql = "insert into reply_board values (seq_replyboard.nextval, ?, ?, ?, ?, sysdate, ?, ?, ?, 0, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, replyBoardDto.getSubject());
			pstmt.setString(2, replyBoardDto.getName());
			pstmt.setString(3, replyBoardDto.getEmail());
			pstmt.setString(4, replyBoardDto.getPassword());
			pstmt.setInt(5, reGroup);
			pstmt.setInt(6, reLevel);
			pstmt.setInt(7, reStep);
			pstmt.setString(8, replyBoardDto.getContents());
			pstmt.setString(9, replyBoardDto.getId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return result;
	}
	
	public ArrayList<ReplyBoardDto> getAllList(int start, int end) {
		ArrayList<ReplyBoardDto> boardList = new ArrayList<>();
		try {
			getConnection();
//			String sql = "select * from reply_board order by regroup desc, relevel asc";
			String sql = "select * from "
					+ "(select  rownum as num, b.* from "
					+ "(select * from reply_board order by regroup desc , relevel asc) b)"
					+ "where num between ? and ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReplyBoardDto replyBoardDto = new ReplyBoardDto();
				replyBoardDto.setNo(rs.getInt("no"));
				replyBoardDto.setSubject(rs.getString("subject"));
				replyBoardDto.setName(rs.getString("name"));
				replyBoardDto.setEmail(rs.getString("email"));
				replyBoardDto.setPassword(rs.getString("password"));
				replyBoardDto.setRegDate(rs.getString("regdate"));
				replyBoardDto.setReGroup(rs.getInt("regroup"));
				replyBoardDto.setReLevel(rs.getInt("relevel"));
				replyBoardDto.setReStep(rs.getInt("restep"));
				replyBoardDto.setHit(rs.getInt("hit"));
				replyBoardDto.setContents(rs.getString("contents"));
				replyBoardDto.setNum(rs.getInt("num"));
				replyBoardDto.setId(rs.getString("id"));
				boardList.add(replyBoardDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return boardList;
	}
	
	// transaction(오류나도 하나는 작동하면 안됨 --> conn.setAutoCommit(false); & 마지막에 conn.commit();
	public ReplyBoardDto getSelectOne(int no) {
		ReplyBoardDto replyBoardDto = new ReplyBoardDto();

		try {
			getConnection();
			conn.setAutoCommit(false);
			
			String addHitSql = "update reply_board set hit = hit + 1 where no = ?";
			pstmt = conn.prepareStatement(addHitSql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			
			String sql = "select * from reply_board where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				replyBoardDto.setNo(rs.getInt("no"));
				replyBoardDto.setSubject(rs.getString("subject"));
				replyBoardDto.setName(rs.getString("name"));
				replyBoardDto.setEmail(rs.getString("email"));
				replyBoardDto.setPassword(rs.getString("password"));
				replyBoardDto.setRegDate(rs.getString("regdate"));
				replyBoardDto.setReGroup(rs.getInt("regroup"));
				replyBoardDto.setReLevel(rs.getInt("relevel"));
				replyBoardDto.setReStep(rs.getInt("restep"));
				replyBoardDto.setHit(rs.getInt("hit"));
				replyBoardDto.setContents(rs.getString("contents"));
				replyBoardDto.setId(rs.getString("id"));
				conn.commit();
			}
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		close();
		return replyBoardDto;
	}
	
	// transaction(오류나도 하나는 작동하면 안됨 --> conn.setAutoCommit(false); & 마지막에 conn.commit();
	public int insertReplyBoard(ReplyBoardDto replyBoardDto) {
		int result = 0;
		
		try {
			getConnection();
			conn.setAutoCommit(false);
			int reGroup = replyBoardDto.getReGroup();
			int reLevel = replyBoardDto.getReLevel();
			int reStep = replyBoardDto.getReStep();
			
			String levelAddSql = "update reply_board set relevel = relevel + 1 where regroup = ? and relevel > ?";
			pstmt = conn.prepareStatement(levelAddSql);
			pstmt.setInt(1, reGroup);
			pstmt.setInt(2, reLevel);
			pstmt.executeUpdate();
			
			String sql = "insert into reply_board values (seq_replyboard.nextval, ?, ?, ?, ?, sysdate, ?, ?, ?, 0, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, replyBoardDto.getSubject());
			pstmt.setString(2, replyBoardDto.getName());
			pstmt.setString(3, replyBoardDto.getEmail());
			pstmt.setString(4, replyBoardDto.getPassword());
			pstmt.setInt(5, reGroup);
			pstmt.setInt(6, reLevel + 1);
			pstmt.setInt(7, reStep + 1);
			pstmt.setString(8, replyBoardDto.getContents());
			pstmt.setString(9, replyBoardDto.getId());
			result = pstmt.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		close();
		return result;
	}
	
	// 검색목록(override)
	// filed는 바인딩 안됨
	public ArrayList<ReplyBoardDto> getSearchAllList(String searchField, String searchWord) {
		ArrayList<ReplyBoardDto> boardList = new ArrayList<>();
		try {
			getConnection();
			String sql = "select * from reply_board where "+ searchField + " like ? order by regroup desc, relevel asc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchWord+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReplyBoardDto replyBoardDto = new ReplyBoardDto();
				replyBoardDto.setNo(rs.getInt("no"));
				replyBoardDto.setSubject(rs.getString("subject"));
				replyBoardDto.setName(rs.getString("name"));
				replyBoardDto.setEmail(rs.getString("email"));
				replyBoardDto.setPassword(rs.getString("password"));
				replyBoardDto.setRegDate(rs.getString("regdate"));
				replyBoardDto.setReGroup(rs.getInt("regroup"));
				replyBoardDto.setReLevel(rs.getInt("relevel"));
				replyBoardDto.setReStep(rs.getInt("restep"));
				replyBoardDto.setHit(rs.getInt("hit"));
				replyBoardDto.setContents(rs.getString("contents"));
				replyBoardDto.setId(rs.getString("id"));
				boardList.add(replyBoardDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return boardList;
	}
	
	public int deleteBoard(ReplyBoardDto replyBoardDto) {
		int result = 0;
		try {
		getConnection();
		String sql = "Delete from reply_Board where no = ? and password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, replyBoardDto.getNo());
			pstmt.setString(2, replyBoardDto.getPassword());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return result;
	}
	
	public int updateBoard(ReplyBoardDto replyBoardDto) {
		int result = 0;
		
		try {
		getConnection();
		String sql = "update reply_board set name = ?, subject = ?, email = ?, contents = ? where no = ? and password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, replyBoardDto.getName());
			pstmt.setString(2, replyBoardDto.getSubject());
			pstmt.setString(3, replyBoardDto.getEmail());
			pstmt.setString(4, replyBoardDto.getContents());
			pstmt.setInt(5, replyBoardDto.getNo());
			pstmt.setString(6, replyBoardDto.getPassword());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return result;
	}
	
	public ReplyBoardDto getPrevSelect(int num) {
		ReplyBoardDto replyBoardDto = null;
		
		try {
			getConnection();
			String sql = "select * from "
					+ "		(select rownum as num, b.* from"
					+ "        (select * from reply_board order by regroup desc, relevel asc) b"
					+ "		) where num = ? - 1";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				replyBoardDto = new ReplyBoardDto();
				replyBoardDto.setNo(rs.getInt("no"));
				replyBoardDto.setSubject(rs.getString("subject"));
				replyBoardDto.setName(rs.getString("name"));
				replyBoardDto.setEmail(rs.getString("email"));
				replyBoardDto.setPassword(rs.getString("password"));
				replyBoardDto.setRegDate(rs.getString("regdate"));
				replyBoardDto.setReGroup(rs.getInt("regroup"));
				replyBoardDto.setReLevel(rs.getInt("relevel"));
				replyBoardDto.setReStep(rs.getInt("restep"));
				replyBoardDto.setHit(rs.getInt("hit"));
				replyBoardDto.setContents(rs.getString("contents"));
				replyBoardDto.setNum(rs.getInt("num"));
				replyBoardDto.setId(rs.getString("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return replyBoardDto;
	}
	
	public ReplyBoardDto getNextSelect(int num) {
		ReplyBoardDto replyBoardDto = null;
		
		try {
			getConnection();
			String sql = "select * from "
					+ "		(select rownum as num, b.* from"
					+ "        (select * from reply_board order by regroup desc, relevel asc) b"
					+ "		) where num = ? + 1";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				replyBoardDto = new ReplyBoardDto();
				replyBoardDto.setNo(rs.getInt("no"));
				replyBoardDto.setSubject(rs.getString("subject"));
				replyBoardDto.setName(rs.getString("name"));
				replyBoardDto.setEmail(rs.getString("email"));
				replyBoardDto.setPassword(rs.getString("password"));
				replyBoardDto.setRegDate(rs.getString("regdate"));
				replyBoardDto.setReGroup(rs.getInt("regroup"));
				replyBoardDto.setReLevel(rs.getInt("relevel"));
				replyBoardDto.setReStep(rs.getInt("restep"));
				replyBoardDto.setHit(rs.getInt("hit"));
				replyBoardDto.setContents(rs.getString("contents"));
				replyBoardDto.setNum(rs.getInt("num"));
				replyBoardDto.setId(rs.getString("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return replyBoardDto;
	}
	
	public int getTotal() {
		int total = 0;
		try {
			getConnection();
			String sql = "select count(*) as total from reply_board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				total = rs.getInt("total");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return total;
	}
}
