package kr.or.pets.protectPets.dao;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import kr.or.pets.board.vo.BoardVO;
import kr.or.pets.protectPets.vo.ImageVO;
import kr.or.pets.protectPets.vo.ProPetsVO;

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
	public int deleteBoard(int proBoardNum) throws DataAccessException {
		int result = sqlSession.delete("mapper.protect.deleteBoard", proBoardNum);
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

	@Override
	public ProPetsVO viewBoard(int proBoardNum) throws DataAccessException {
		return sqlSession.selectOne("mapper.protect.viewBoard", proBoardNum);
	}
	
	@Override
	public int insertNewArticle(Map articleMap) throws DataAccessException {
		//articleNo 값이 기존 max 값 + 1이 되어야 함.
		int proBoardNum = selectNewArticleNo();
		articleMap.put("proBoardNum", proBoardNum);
		
		sqlSession.insert("mapper.protect.insertNewArticle", articleMap);
		return proBoardNum;
	}
	
	//다중 파일 업로드
	@Override
	public void insertNewImage(Map articleMap) throws DataAccessException {
		List<ImageVO> imageFileList = (ArrayList)articleMap.get("ImageFileList");
		int proBoardNum = (Integer)articleMap.get("proBoardNum");
		
		//이미지파일들은 별도의 테이블에 별도의 imageFileNo로 저장함.
		int imageFileNo = selectNewImageFileNo();				//기존 파일 No값을 먼저 구한다.
		
		if (imageFileList != null && imageFileList.size() != 0) {
			//여러 이미지일경우 대비
			for (ImageVO imageVO : imageFileList) {
				imageVO.setImageFileNo(++imageFileNo);
				imageVO.setProBoardNum(proBoardNum);
			}
			//(다중) 파일 insert (별도의 테이블에다 함)
			sqlSession.insert("mapper.protect.insertNewImage", imageFileList);
		}
		
	}
	
	public int selectNewImageFileNo() throws DataAccessException {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.protect.selectNewImageFileNo");
	}

	//  max 값 + 1
	public int selectNewArticleNo() throws DataAccessException {
		return sqlSession.selectOne("mapper.protect.selectNewArticleNo");
	}

	@Override
	public ProPetsVO selectBoard(int proBoardNum) throws DataAccessException {
		
		return sqlSession.selectOne("mapper.protect.selectBoard", proBoardNum);
	}

	@Override
	public List<ImageVO> selectImageFileList(int proBoardNum) throws DataAccessException {
		
		List<ImageVO> imageFileList = sqlSession.selectList("mapper.protect.selectImageFileList", proBoardNum);
		
		return imageFileList;
	}

}
