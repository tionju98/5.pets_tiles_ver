package kr.or.pets.protectPets.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import kr.or.pets.protectPets.vo.ProPetsVO;

public interface ProPetsService {

	public Map listBoards(Map<String, Integer> pagingMap) throws Exception;
	
	public int addNewArticle(Map articleMap) throws Exception;

	public int removeBoard(int proBoardNum) throws Exception;
	
	public List searchBoard(ProPetsVO proPetsVO) throws Exception;

	public List<String> keywordSearch(String keyword) throws Exception;

	public List<ProPetsVO> searchBoards(String searchWord) throws Exception;

	public Map viewBoard(int proBoardNum) throws Exception;


}
