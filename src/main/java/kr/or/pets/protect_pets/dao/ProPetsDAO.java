package kr.or.pets.protect_pets.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import kr.or.pets.protect_pets.vo.ProPetsVO;

public interface ProPetsDAO {

	public List<ProPetsVO> selectAllBoards(Map<String, Integer> pagingMap) throws DataAccessException;
	
	public int selectTotBoards() throws DataAccessException;

	public int insertNewArticle(Map articleMap) throws DataAccessException;
	
	public void insertNewImage(Map articleMap) throws DataAccessException;

	public int deleteBoard(String pro_boardNum) throws DataAccessException;
	
	public List<ProPetsVO> searchBoard(ProPetsVO proPetsVO) throws DataAccessException;

	public List<String> selectKeywordSearch(String keyword) throws DataAccessException;

	public List<ProPetsVO> selectBoardsBySearchWord(String searchWord) throws DataAccessException;
	
	public ProPetsVO viewBoard(int pro_boardNum) throws DataAccessException;
	
}
