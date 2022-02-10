package com.prohk.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class NoticeDao {
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
			conn = DriverManager.getConnection(url,id,pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public int insertNotice(NoticeDto noticeDto) {
		int result = 0;
		
		try {
			getConnection();
			String sql = "insert into notice values(seq_notice.nextval, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noticeDto.getTitle());
			pstmt.setString(2, noticeDto.getContents());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();		
		return result;
	}
	
	public ArrayList<NoticeDto> getAllList() {
		ArrayList<NoticeDto> noticeList = new ArrayList<>();
		
		try {
			getConnection();
			String sql = "select * from notice";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			NoticeDto noticeDto = new NoticeDto();
			noticeDto.setNo(rs.getInt("no"));
			noticeDto.setTitle(rs.getString("title"));
			noticeDto.setContents(rs.getString("contents"));
			noticeDto.setRegDate(rs.getString("regdate"));
			noticeList.add(noticeDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return noticeList;
	}
}
