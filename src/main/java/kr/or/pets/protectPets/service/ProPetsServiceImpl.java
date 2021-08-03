package kr.or.pets.protectPets.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.pets.protectPets.dao.ProPetsDAO;
import kr.or.pets.protectPets.vo.ImageVO;
import kr.or.pets.protectPets.vo.ProPetsVO;

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
//		List<ImageVO> imageFileList = proPetsDAO.selectImageFileList();
		
		Map articlesMap = new HashMap();
		articlesMap.put("boardsList", boardsList);
		articlesMap.put("totBoards", totBoards);
		
		return articlesMap;
	}

	@Override
	public int addNewArticle(Map articleMap) throws Exception {
		int proBoardNum = proPetsDAO.insertNewArticle(articleMap);
		articleMap.put("proBoardNum", proBoardNum);
		proPetsDAO.insertNewImage(articleMap);
		return proBoardNum;
	}

	@Override
	public int removeBoard(int proBoardNum) throws Exception {
		return proPetsDAO.deleteBoard(proBoardNum);
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
	public Map viewBoard(int proBoardNum) throws Exception {
		Map articleMap = new HashMap();
		ProPetsVO proPetsVO = proPetsDAO.selectBoard(proBoardNum);
		List<ImageVO> imageFileList = proPetsDAO.selectImageFileList(proBoardNum);
		
		articleMap.put("proPets", proPetsVO);
		articleMap.put("imageFileList", imageFileList);
		
		return articleMap;
		
	}

}







