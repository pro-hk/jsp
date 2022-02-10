package com.prohk.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDao {
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
	
	public int insertBoard(BoardDto boardDto) {
		int result = 0;
		getConnection();
		String sql = "insert into board values (seq_board.nextval, ?, ?, ?, ?, ?, sysdate, 0)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getName());
			pstmt.setString(2, boardDto.getSubject());
			pstmt.setString(3, boardDto.getEmail());
			pstmt.setString(4, boardDto.getPassword());
			pstmt.setString(5, boardDto.getContents());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return result;
	}
	
	public ArrayList<BoardDto> showAllBoard() {
		ArrayList<BoardDto> boardList = new ArrayList<>();
		
		getConnection();
		String sql = "select * from board";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setNo(rs.getInt("no"));
				boardDto.setName(rs.getString("name"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setEmail(rs.getString("email"));
				boardDto.setPassword(rs.getString("password"));
				boardDto.setContents(rs.getString("contents"));
				boardDto.setRegdate(rs.getString("regdate"));
				boardDto.setHit(rs.getInt("hit"));
				boardList.add(boardDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return boardList;
	}
	
	public BoardDto getSelectOne(int no) {
		BoardDto boardDto = new BoardDto();
		
		getConnection();
		String hitUpdateSql = "update board set hit = hit + 1 where no = ?";
		try {
			pstmt = conn.prepareStatement(hitUpdateSql);
			pstmt.setInt(1, no);
			int result = pstmt.executeUpdate();

			String readSql = "select * from board where no = ?";
			pstmt = conn.prepareStatement(readSql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				boardDto.setNo(rs.getInt("no"));
				boardDto.setPassword(rs.getString("password"));
				boardDto.setName(rs.getString("name"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setEmail(rs.getString("email"));
				boardDto.setContents(rs.getString("contents"));
				boardDto.setRegdate(rs.getString("regdate"));
				boardDto.setHit(rs.getInt("hit"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return boardDto;
	}
	
	public int deleteBoard(BoardDto boardDto) {
		int result = 0;
		try {
			getConnection();
			String sql = "delete from board where no=? and password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardDto.getNo());
			pstmt.setString(2, boardDto.getPassword());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return result;
	}
	
	public int updateBoard(BoardDto boardDto) {
		int result = 0;
		try {
			getConnection();
			String sql = "update board set name = ?, subject = ?, email = ?, contents = ? where no = ? and password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getName());
			pstmt.setString(2, boardDto.getSubject());
			pstmt.setString(3, boardDto.getEmail());
			pstmt.setString(4, boardDto.getContents());
			pstmt.setInt(5, boardDto.getNo());
			pstmt.setString(6, boardDto.getPassword());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return result;
	}
}
