package kr.or.pets.protect_pets.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import kr.or.pets.protect_pets.vo.ProPetsVO;

public interface ProPetsService {

	public Map listBoards(Map<String, Integer> pagingMap) throws Exception;
	
	public int addNewArticle(Map articleMap) throws Exception;

	public int removeBoard(String pro_noticeNum) throws Exception;
	
	public List searchBoard(ProPetsVO proPetsVO) throws Exception;

	public List<String> keywordSearch(String keyword) throws Exception;

	public List<ProPetsVO> searchBoards(String searchWord) throws Exception;

	public ProPetsVO viewBoard(int pro_boardNum) throws Exception;


}
