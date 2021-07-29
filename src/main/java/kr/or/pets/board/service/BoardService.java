package kr.or.pets.board.service;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import kr.or.pets.board.vo.BoardVO;


public interface BoardService {
	public Map listBoards(Map<String, Integer> pagingMap) throws DataAccessException;
	
	public int removeBoard(int qa_No) throws DataAccessException;

	public int addBoard(BoardVO boardVO) throws DataAccessException;

	public Map viewBoard(int qa_No) throws Exception;

	public void modBoard(Map<String, Object> boardMap) throws DataAccessException ;
}
