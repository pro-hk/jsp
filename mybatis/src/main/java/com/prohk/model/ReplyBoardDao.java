package com.prohk.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class ReplyBoardDao {
	public int insertBoard(ReplyBoardDto replyBoardDto) {
		int result = 0;

		int reGroup = 0;
		int reStep = 1;
		int reLevel = 1;
		reGroup = getMaxRegroup() + 1; // 자동증가가 없어서 제일큰거 받아서 더하기 1하면 제일 큰 숫자가 됨.

		replyBoardDto.setReGroup(reGroup);
		replyBoardDto.setReStep(reStep);
		replyBoardDto.setReLevel(reLevel);

		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("insertBoard", replyBoardDto);
		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return result;
	}

	public int getMaxRegroup() {
		int result = 0;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.selectOne("getMaxReGroup");
		sqlSession.close();
		return result;
	}
	
	public List<ReplyBoardDto> getAllList(int start, int end,String search_select, String search_word) {
		HashMap<String,Object> pageMap = new HashMap<>();
		pageMap.put("start", start);
		pageMap.put("end", end);
		pageMap.put("searchSelect", search_select);
		pageMap.put("searchWord", search_word);
		
		List<ReplyBoardDto> boardList = null;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		boardList = sqlSession.selectList("getAllList", pageMap); //마이바티스 메서드는 매개변수 하나밖에 못넘기...
		sqlSession.close();
		return boardList;
	}
	
	public List<ReplyBoardDto> getSearchAllList(String search_select, String search_word) {
	
		HashMap<String,String> searchMap = new HashMap<>();
		searchMap.put("searchSelect", search_select);
		searchMap.put("searchWord", search_word);
		
		List<ReplyBoardDto> boardList = null;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		boardList = sqlSession.selectList("getSearchAllList", searchMap); //마이바티스 메서드는 매개변수 하나밖에 못넘기...
		sqlSession.close();
		return boardList;
	}
	
	public ReplyBoardDto getSelectOne(int no) {
		ReplyBoardDto replyBoardDto = null;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		replyBoardDto = sqlSession.selectOne("getSelectOne",no);
		sqlSession.close();
		return replyBoardDto;
	}
	
	public ReplyBoardDto getPrevSelect(int num) {
		ReplyBoardDto replyBoardDto = null;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		replyBoardDto = sqlSession.selectOne("getPrevSelect",num);
		sqlSession.close();
		return replyBoardDto;
	}
	
	public ReplyBoardDto getNextSelect(int num) {
		ReplyBoardDto replyBoardDto = null;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		replyBoardDto = sqlSession.selectOne("getNextSelect",num);
		sqlSession.close();
		return replyBoardDto;
	}
	
	public int updateHit(int no) {
		int result = 0;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.update("updateHit",no);
		sqlSession.commit();
		sqlSession.close();
		
		return result;
	}
	
	public int deleteBoard(ReplyBoardDto replyBoardDto) {
		int result = 0;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.delete("deleteBoard", replyBoardDto);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
	public int getTotal(String search_select,String search_word) {
		HashMap <String,String> searchMap = new HashMap<>();
		searchMap.put("searchSelect",search_select);
		searchMap.put("searchWord",search_word);
		int result = 0;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.selectOne("getTotal",searchMap);
		sqlSession.close();
		return result;
	}
}
