package kr.or.pets.protectPets.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import kr.or.pets.protectPets.vo.ImageVO;
import kr.or.pets.protectPets.vo.ProPetsVO;

public interface ProPetsDAO {

	public List<ProPetsVO> selectAllBoards(Map<String, Integer> pagingMap) throws DataAccessException;
	
	public int selectTotBoards() throws DataAccessException;

	public int insertNewArticle(Map articleMap) throws DataAccessException;
	
	public void insertNewImage(Map articleMap) throws DataAccessException;

	public int deleteBoard(int proBoardNum) throws DataAccessException;
	
	public List<ProPetsVO> searchBoard(ProPetsVO proPetsVO) throws DataAccessException;

	public List<String> selectKeywordSearch(String keyword) throws DataAccessException;

	public List<ProPetsVO> selectBoardsBySearchWord(String searchWord) throws DataAccessException;
	
	public ProPetsVO viewBoard(int proBoardNum) throws DataAccessException;

	public ProPetsVO selectBoard(int proBoardNum) throws DataAccessException;

	public List<ImageVO> selectImageFileList(int proBoardNum) throws DataAccessException;
	
}
