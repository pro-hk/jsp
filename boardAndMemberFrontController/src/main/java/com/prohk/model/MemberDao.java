package com.prohk.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MemberDao {
public List<MemberDto> getAllMemberList(int start, int end,String search_select,String search_word) {
		
		HashMap<String,Object> pageMap = new HashMap<>();
		pageMap.put("start", start);
		pageMap.put("end", end);
		pageMap.put("searchSelect", search_select);
		pageMap.put("searchWord", search_word);
		
		List<MemberDto> memberList = null;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession(); //�����....
		memberList = sqlSession.selectList("getAllMemberList",pageMap); //List���·� ������...
		sqlSession.close();
		return memberList;
	}
	public MemberDto getSelectOne(String id) {
		MemberDto memberDto = null;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession(); //�����....
		memberDto = sqlSession.selectOne("getMemberSelectOne",id);
		sqlSession.close();
		return memberDto;
	}
	public MemberDto getLoggedMember(MemberDto pMemberDto) {
		MemberDto memberDto = null;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		memberDto = sqlSession.selectOne("getLoggedMember",pMemberDto);
		//ù��° �Ű������� Mapper.xml�� �ִ� id, �ι�°�� �Ű�����
		sqlSession.close();
		return memberDto;
	}
	public int deleteMember(MemberDto memberDto) {
		int result = 0;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.delete("deleteMember",memberDto);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	public int insertMember(MemberDto memberDto) {
		int result = 0;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("insertMember",memberDto);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	public int updateMember(MemberDto memberDto) {
		int result = 0;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.update("updateMember",memberDto);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	public int idCheck(String id) {
		int result = 0;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.selectOne("idCheck",id);
		sqlSession.close();
		return result;
	}
	public int getTotal(String search_select, String search_word) {
		HashMap <String,String> searchMap = new HashMap<>();
		searchMap.put("searchSelect",search_select);
		searchMap.put("searchWord",search_word);
		int result = 0;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.selectOne("getMemberTotal",searchMap);
		sqlSession.close();
		return result;
	}
}
