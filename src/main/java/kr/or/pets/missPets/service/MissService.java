package kr.or.pets.missPets.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import kr.or.pets.missPets.vo.MissVO;


public interface MissService {

	public Map m_listBoards(Map<String, Integer> pagingMap) throws DataAccessException;

	public int m_removeBoard(int missBoardNum) throws DataAccessException;

	public int m_addBoard(Map missMap) throws DataAccessException;

	public Map m_viewBoard(int missBoardNum) throws Exception;

	public void m_modBoard(Map<String, Object> missMap) throws DataAccessException;
	
	public List<String> m_keywordSearch(String keyword) throws Exception;

	public List<MissVO> m_searchBoards(String searchWord) throws Exception;

}
