package com.prohk.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

// DataBase Access Object
public class MemberDao {
	public List<MemberDto> getAllMemberList() { // List의 자식 : ArrayList
		List<MemberDto> memberList = null;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession(); // 연결
		memberList = sqlSession.selectList("getAllMemberList");  // List형태로 들고오기
		sqlSession.close();
		
		return memberList;
	}
}
