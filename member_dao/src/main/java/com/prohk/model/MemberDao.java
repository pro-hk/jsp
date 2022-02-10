package com.prohk.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.websocket.Session;

// DataBase Access Object
public class MemberDao {
	// 여기서 db값을 전달하고 출력
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
	
	public int insertMember(MemberDto memberDto) {
		int result = 0;
		
		getConnection();
		String sql = "insert into member values(seq_member.nextval,?,?,?,?,?,?,?,sysdate)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getId());
			pstmt.setString(2, memberDto.getPassword());
			pstmt.setString(3, memberDto.getName());
			pstmt.setString(4, memberDto.getEmail());
			pstmt.setString(5, memberDto.getPhone());
			pstmt.setInt(6, memberDto.getZipCode());
			pstmt.setString(7, memberDto.getAddress());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return result;
	}
	
	public ArrayList<MemberDto> showAllMember() {
		ArrayList<MemberDto> memberList = new ArrayList<>();
		getConnection();
		String sql = "select * from member";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDto memberDto = new MemberDto();
				memberDto.setNo(rs.getInt("no"));
				memberDto.setId(rs.getString("id"));
				memberDto.setPassword(rs.getString("password"));
				memberDto.setName(rs.getString("name"));
				memberDto.setEmail(rs.getString("email"));
				memberDto.setPhone(rs.getString("phone"));
				memberDto.setZipCode(rs.getInt("zipcode"));
				memberDto.setAddress(rs.getString("address"));
				memberDto.setRegDate(rs.getString("regdate"));
				memberList.add(memberDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return memberList;
	}
	
	public MemberDto getSelectOne(String user_id) { // MemberDto로 반환
		MemberDto memberDto = new MemberDto();
		getConnection();
		String sql = "select * from member where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDto.setNo(rs.getInt("no"));
				memberDto.setId(rs.getString("id"));
				memberDto.setPassword(rs.getString("password"));
				memberDto.setName(rs.getString("name"));
				memberDto.setEmail(rs.getString("email"));
				memberDto.setPhone(rs.getString("phone"));
				memberDto.setZipCode(rs.getInt("zipcode"));
				memberDto.setAddress(rs.getString("address"));
				memberDto.setRegDate(rs.getString("regdate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return memberDto;
	}
	
	public MemberDto getLoggedMember(MemberDto memberDto) {
		MemberDto loggedMember = null;
		getConnection();
		String sql = "select * from member where id = ? and password = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getId());
			pstmt.setString(2, memberDto.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				loggedMember = new MemberDto();
				loggedMember.setNo(rs.getInt("no"));
				loggedMember.setId(rs.getString("id"));
				loggedMember.setPassword(rs.getString("password"));
				loggedMember.setName(rs.getString("name"));
				loggedMember.setEmail(rs.getString("email"));
				loggedMember.setPhone(rs.getString("phone"));
				loggedMember.setZipCode(rs.getInt("zipcode"));
				loggedMember.setAddress(rs.getString("address"));
				loggedMember.setRegDate(rs.getString("regdate"));
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return loggedMember;
	}
	
	public int updateMember(MemberDto memberDto) {
		int result = 0;
		getConnection();
		String sql = "update member set name=?, email=?, phone=?, zipcode=?, address=? where id=? and password=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getName());
			pstmt.setString(2, memberDto.getEmail());
			pstmt.setString(3, memberDto.getPhone());
			pstmt.setInt(4, memberDto.getZipCode());
			pstmt.setString(5, memberDto.getAddress());
			pstmt.setString(6, memberDto.getId());
			pstmt.setString(7, memberDto.getPassword());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return result;
	}
	
	public int deleteMember(MemberDto memberDto) {
		int result=0;
		getConnection();
		String sql = "delete from member where id = ? and password = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getId());
			pstmt.setString(2, memberDto.getPassword());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return result;
	}
}
