package kr.or.pets.board.dao;


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
	public int deleteBoard(int qa_No) throws DataAccessException {
		int result = sqlSession.delete("mapper.board.deleteBoard", qa_No);
		return result;
	}

	@Override
	public int insertBoard(BoardVO boardVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.board.insertBoard", boardVO);
		return result;
	}

	@Override
	public BoardVO viewBoard(int qa_No) throws DataAccessException {
	
		return sqlSession.selectOne("mapper.board.viewBoard", qa_No);
		
	}
	@Override
	public void updateBoard(Map boardMap) throws DataAccessException{
		System.out.println("==================updateBoard=======================");
		sqlSession.update("mapper.board.updateBoard", boardMap);
	}
	}
