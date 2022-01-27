package com.prohk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_Connection {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "tis";
	private String pw = "1234";
	
	public Connection conn;
	public PreparedStatement pstmt;
	public ResultSet rs;
	
	public JDBC_Connection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("DB���� ����");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
}
