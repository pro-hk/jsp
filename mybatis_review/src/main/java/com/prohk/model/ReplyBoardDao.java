package com.prohk.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class ReplyBoardDao {
	public List<ReplyBoardDto> getAllList() {
		List<ReplyBoardDto> boardList = null;
		
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		boardList = sqlSession.selectList("getAllBoard");
		sqlSession.close();
		
		return boardList;
	}
	
	public ReplyBoardDto getSelectOne(int no) {
		ReplyBoardDto boardDto = null;
				
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		boardDto = sqlSession.selectOne("getSelectOneBoard", no);
		sqlSession.close();
		
		return boardDto;
	}
	
	public int allDeleteBoard(int no) {
		int result = 0;
		
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.delete("allDeleteBoard", no);
		sqlSession.commit();
		sqlSession.close();
		
		return result;
	}

	public int deleteBoard(ReplyBoardDto boardDto) {
		int result = 0;
		
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.delete("deleteBoard", boardDto);
		sqlSession.commit();
		sqlSession.close();
		
		return result;
	}

	public int updateBoard(ReplyBoardDto boardDto) {
		int result = 0;
		
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("updateBoard", boardDto);
		sqlSession.commit();
		sqlSession.close();
		
		return result;
	}
}
