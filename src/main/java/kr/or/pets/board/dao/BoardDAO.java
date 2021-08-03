package kr.or.pets.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import kr.or.pets.board.vo.BoardVO;

public interface BoardDAO {
	public List<BoardVO> selectAllBoardList(Map<String, Integer> pagingMap) throws DataAccessException;

	public int deleteBoard(int qaNo) throws DataAccessException;

	public int insertBoard(Map boardMap) throws DataAccessException;

	public BoardVO viewBoard(int qaNo) throws DataAccessException;

	public int selectTotBoards() throws DataAccessException;
	
	public void updateBoard(Map boardMap) throws DataAccessException;
	
	public List<String> selectKeywordSearch(String keyword) throws DataAccessException;

	public List<BoardVO> selectBoardsBySearchWord(String searchWord) throws DataAccessException;

}
