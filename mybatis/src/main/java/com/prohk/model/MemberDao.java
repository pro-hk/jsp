package com.prohk.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

// DataBase Access Object
public class MemberDao {
	public List<MemberDto> getAllMemberList() { // List�� �ڽ� : ArrayList
		List<MemberDto> memberList = null;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession(); // ����
		memberList = sqlSession.selectList("getAllMemberList");  // List���·� ������
		sqlSession.close();
		
		return memberList;
	}
}
