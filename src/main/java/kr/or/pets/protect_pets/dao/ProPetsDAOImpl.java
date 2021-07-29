package kr.or.pets.protect_pets.dao;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import kr.or.pets.protect_pets.vo.ProPetsVO;

@Repository("proPetsDAO")
public class ProPetsDAOImpl implements ProPetsDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ProPetsVO> selectAllBoards(Map<String, Integer> pagingMap) throws DataAccessException {
		List<ProPetsVO> boardsList = sqlSession.selectList("mapper.protect.selectAllBoards", pagingMap);
		return boardsList;
	}

	@Override
	public int selectTotBoards() throws DataAccessException {
		int totBoards = sqlSession.selectOne("mapper.protect.selectTotBoards");
		return totBoards;
	}

	@Override
	public int insertBoard(ProPetsVO proPetsVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.protect.insertBoard", proPetsVO);
		return result;
	}

	@Override
	public int deleteBoard(String pro_noticeNum) throws DataAccessException {
		int result = sqlSession.delete("mapper.protect.deleteBoard", pro_noticeNum);
		return result;
	}

	@Override
	public List<ProPetsVO> searchBoard(ProPetsVO proPetsVO) throws DataAccessException {
		List<ProPetsVO> boardsList = sqlSession.selectList("mapper.protect.searchBoard", proPetsVO);
		return boardsList;
	}

	@Override
	public List<String> selectKeywordSearch(String keyword) throws DataAccessException {
		List<String> list = sqlSession.selectList("mapper.protect.selectKeywordSearch", keyword);
		
		return list;
	}

	@Override
	public List<ProPetsVO> selectBoardsBySearchWord(String searchWord) throws DataAccessException {
		ArrayList<ProPetsVO> list = (ArrayList)sqlSession.selectList("mapper.protect.selectBoardsBySearchWord", searchWord);
		
		return list;
	}

}
