package kr.or.pets.missPets.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.pets.board.vo.BoardVO;
import kr.or.pets.missPets.dao.MissDAO;
import kr.or.pets.missPets.vo.MissVO;

@Service("missService")
@Transactional(propagation = Propagation.REQUIRED)
public class MissServiceImpl implements MissService {
	private static final Logger logger = LoggerFactory.getLogger(MissServiceImpl.class);
	@Autowired
	private MissDAO missDAO;
	
	public void setMissDAO(MissDAO missDAO) {
		this.missDAO = missDAO;
	}
	
	@Override
	public Map m_listBoards(Map<String, Integer> pagingMap) throws DataAccessException {
		List<MissVO> m_boardsList = missDAO.selectAllBoardList(pagingMap);		/* 전달된 pagingMap을 사용해 글 목록을 조회함*/
		int totBoards = missDAO.selectTotBoards();								/* 테이블에 존재하는 글 수를 조회함 */
		
		Map missMap = new HashMap();
		missMap.put("m_boardsList", m_boardsList);
		missMap.put("totBoards", totBoards);
		
		return missMap;
	}

	@Override
	public int m_removeBoard(int missBoardNum) throws DataAccessException {
		
		return missDAO.deleteBoard(missBoardNum);
	}

	@Override
	public int m_addBoard(Map missMap) throws DataAccessException {
		int missBoardNum = missDAO.insertBoard(missMap);
		missMap.put("missBoardNum", missBoardNum);
		
		return missBoardNum;
	}

	@Override
	public Map m_viewBoard(int missBoardNum) throws Exception {
		Map missMap = new HashMap();
		MissVO missVO = missDAO.viewBoard(missBoardNum);
		
		missMap.put("miss", missVO);
		
		return missMap;
	}

	@Override
	public void m_modBoard(Map<String, Object> missMap) throws DataAccessException {
		missDAO.updateBoard(missMap);
		
	}

	@Override
	public List<String> m_keywordSearch(String keyword) throws Exception {
		List<String> list = missDAO.selectKeywordSearch(keyword);
		
		return list;
	}

	@Override
	public List<MissVO> m_searchBoards(String searchWord) throws Exception {
		List<MissVO> m_boardsList = missDAO.selectBoardsBySearchWord(searchWord);
		
		return m_boardsList;
	}

}
