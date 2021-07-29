package kr.or.pets.protect_pets.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import kr.or.pets.protect_pets.vo.ProPetsVO;

public interface ProPetsService {

	public Map listBoards(Map<String, Integer> pagingMap) throws Exception;

	public int addBoard(ProPetsVO proPetsVO) throws DataAccessException;

	public int removeBoard(String pro_noticeNum) throws DataAccessException;
	
	public List searchBoard(ProPetsVO proPetsVO) throws DataAccessException;

	public List<String> keywordSearch(String keyword) throws Exception;

	public List<ProPetsVO> searchBoards(String searchWord) throws Exception;

}
