package kr.or.pets.missPets.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import kr.or.pets.missPets.vo.MissVO;

public interface MissDAO {

	public List<MissVO> selectAllBoardList(Map<String, Integer> pagingMap) throws DataAccessException;

	public int selectTotBoards() throws DataAccessException;

	public int deleteBoard(int missBoardNum) throws DataAccessException;

	public int insertBoard(Map missMap) throws DataAccessException;

	public MissVO viewBoard(int missBoardNum) throws DataAccessException;

	public void updateBoard(Map<String, Object> missMap) throws DataAccessException;

	public List<String> selectKeywordSearch(String keyword) throws DataAccessException;

	public List<MissVO> selectBoardsBySearchWord(String searchWord) throws DataAccessException;

}
