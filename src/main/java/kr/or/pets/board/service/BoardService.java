package kr.or.pets.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import kr.or.pets.board.vo.BoardVO;


public interface BoardService {
	public Map listBoards(Map<String, Integer> pagingMap) throws DataAccessException;
	
	public int removeBoard(int qaNo) throws DataAccessException;

	public int addBoard(Map boardMap) throws DataAccessException;

	public Map viewBoard(int qaNo) throws Exception;

	public void modBoard(Map<String, Object> boardMap) throws DataAccessException ;
	
	public List<String> keywordSearch(String keyword) throws Exception;

	public List<BoardVO> searchBoards(String searchWord) throws Exception;
}
