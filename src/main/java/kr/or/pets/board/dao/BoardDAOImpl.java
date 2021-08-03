package kr.or.pets.board.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import kr.or.pets.board.vo.BoardVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<BoardVO> selectAllBoardList(Map<String, Integer> pagingMap) throws DataAccessException {
		List<BoardVO> boardsList = sqlSession.selectList("mapper.board.selectAllBoardList", pagingMap);
		return boardsList;
	}
	
	@Override
	public int selectTotBoards() throws DataAccessException {
		int totBoards = sqlSession.selectOne("mapper.board.selectTotBoards");
		return totBoards;
	}

	@Override
	public int deleteBoard(int qaNo) throws DataAccessException {
		int result = sqlSession.delete("mapper.board.deleteBoard", qaNo);
		return result;
	}

	@Override
	public int insertBoard(Map boardMap) throws DataAccessException {
		int qaNo = selectNewQaNo();
		boardMap.put("qaNo", qaNo);
		sqlSession.insert("mapper.board.insertBoard", boardMap);
		return qaNo;
	}

	public int selectNewQaNo() throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectNewQa_No");
	}

	@Override
	public BoardVO viewBoard(int qaNo) throws DataAccessException {
	
		return sqlSession.selectOne("mapper.board.viewBoard", qaNo);
		
	}
	@Override
	public void updateBoard(Map boardMap) throws DataAccessException{
		System.out.println("==================updateBoard=======================");
		sqlSession.update("mapper.board.updateBoard", boardMap);
	}

	@Override
	public List<String> selectKeywordSearch(String keyword) throws DataAccessException {
		List<String> list = sqlSession.selectList("mapper.board.selectKeywordSearch", keyword);
		
		return list;
	}

	@Override
	public List<BoardVO> selectBoardsBySearchWord(String searchWord) throws DataAccessException {
		ArrayList<BoardVO> list = (ArrayList)sqlSession.selectList("mapper.board.selectBoardsBySearchWord", searchWord);
		
		return list;
	}
	}
