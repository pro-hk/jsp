package com.prohk.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MarioDao {
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
	
	public int insertMario(MarioDto marioDto) {
		int result = 0;
		try {
			getConnection();
			String sql = "insert into mario values (seq_mario.nextval, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, marioDto.getTitle());
			pstmt.setString(2, marioDto.getLink());
			pstmt.setString(3, marioDto.getBg());
			pstmt.setString(4, marioDto.getContents());
			pstmt.setString(5, marioDto.getMarioImg());
			pstmt.setString(6, marioDto.getMarioRealImg());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return result;
	}
	
	public ArrayList<MarioDto> getAllList() {
		ArrayList<MarioDto> marioList = new ArrayList<>();
		try {
			getConnection();
			String sql = "SELECT * FROM MARIO";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MarioDto marioDto = new MarioDto();
				marioDto.setNo(rs.getInt("no"));
				marioDto.setTitle(rs.getString("title"));
				marioDto.setLink(rs.getString("link"));
				marioDto.setBg(rs.getString("bg"));
				marioDto.setContents(rs.getString("contents"));
				marioDto.setMarioImg(rs.getString("mario_img"));
				marioDto.setMarioRealImg(rs.getString("mario_real_img"));
				marioList.add(marioDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return marioList;
	}
}
