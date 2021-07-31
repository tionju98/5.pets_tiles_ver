package kr.or.pets.protect_pets.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.pets.protect_pets.dao.ProPetsDAO;
import kr.or.pets.protect_pets.vo.ProPetsVO;

@Service("proPetsService")
@Transactional(propagation = Propagation.REQUIRED)
public class ProPetsServiceImpl implements ProPetsService {

	@Autowired
	private ProPetsDAO proPetsDAO;
	
	public void setBoardDAO(ProPetsDAO proPetsDAO) {
		this.proPetsDAO = proPetsDAO;
	}
	
	@Override
	public Map listBoards(Map<String, Integer> pagingMap) throws Exception {
		List<ProPetsVO> boardsList = proPetsDAO.selectAllBoards(pagingMap);		/* 전달된 pagingMap을 사용해 글 목록을 조회함*/
		int totBoards = proPetsDAO.selectTotBoards();								/* 테이블에 존재하는 글 수를 조회함 */
		
		Map articlesMap = new HashMap();
		articlesMap.put("boardsList", boardsList);
		articlesMap.put("totBoards", totBoards);
		
		return articlesMap;
	}

	@Override
	public int addNewArticle(Map articleMap) throws Exception {
		int pro_boardNum = proPetsDAO.insertNewArticle(articleMap);
		articleMap.put("pro_boardNum", pro_boardNum);
		proPetsDAO.insertNewImage(articleMap);
		return pro_boardNum;
	}

	@Override
	public int removeBoard(String pro_noticeNum) throws Exception {
		return proPetsDAO.deleteBoard(pro_noticeNum);
	}

	@Override
	public List searchBoard(ProPetsVO proPetsVO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> keywordSearch(String keyword) throws Exception {
		List<String> list = proPetsDAO.selectKeywordSearch(keyword);
		
		return list;
	}

	@Override
	public List<ProPetsVO> searchBoards(String searchWord) throws Exception {
		List<ProPetsVO> boardsList = proPetsDAO.selectBoardsBySearchWord(searchWord);
		
		return boardsList;
	}
	
	@Override
	public ProPetsVO viewBoard(int pro_boardNum) throws Exception {
		
		return proPetsDAO.viewBoard(pro_boardNum);
		
	}

}
