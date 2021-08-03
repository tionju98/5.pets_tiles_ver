package kr.or.pets.notice.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import kr.or.pets.notice.vo.NoticeImageVO;
import kr.or.pets.notice.vo.NoticeVO;

@Repository("noticeDAO")
public class NoticeDAOImpl implements NoticeDAO{
	
	@Autowired
	private SqlSession sqlSession;

	
	
	//01-1. 공지사항 전체 목록 조회
	@Override
	public List<NoticeVO> selectAllNoticesList(Map<String, Integer> pagingMap) throws DataAccessException {
		List<NoticeVO> noticesList = sqlSession.selectList("mapper.notice.selectAllNoticesList", pagingMap);
		return noticesList;
	}
	//01-2. 공지사항 전체 목록 페이징
	@Override
	public int selectTotNotices() throws DataAccessException {
		int totNotices = sqlSession.selectOne("mapper.notice.selectTotNotices");
		return totNotices;
	}
	
	//01-3 공지사항 이미지
	@Override
	public List<NoticeImageVO> selectNoticeImageFileList(int noNumber) throws DataAccessException {
		List<NoticeImageVO> noticeImageFileList = sqlSession.selectList("mapper.notice.selectNoticeImageFileList", noNumber);
		
		return noticeImageFileList;
	}
	
	//02-1. 공지사항 등록
	@Override
	public int insertNotice(Map noticeMap) throws DataAccessException {
		//articleNo 값이 기존 max 값 + 1이 되어야 함.
		int noNumber = selectNoticeNo();
		noticeMap.put("noNumber", noNumber);
		
		sqlSession.insert("mapper.notice.insertNotice", noticeMap);
		return noNumber;
		
	}
	
	
	//02-2. 공지사항 이미지 등록
	@Override
	public void insertNoticeImage(Map noticeMap) throws DataAccessException {
		List<NoticeImageVO> noticeImageFileList = (ArrayList)noticeMap.get("noticeImageFileList");
		int noNumber = (Integer)noticeMap.get("noNumber");
		
		//이미지파일들은 별도의 테이블에 별도의 imageFileNo로 저장함.
		int noticeImageFileNo = selectNoticeImageFileNo();				//기존 파일 No값을 먼저 구한다.
		
		if (noticeImageFileList != null && noticeImageFileList.size() != 0) {
			//여러 이미지일경우 대비
			for (NoticeImageVO noticeImageVO : noticeImageFileList) {
				noticeImageVO.setNoticeImageNo(++noticeImageFileNo);
				noticeImageVO.setNoNumber(noNumber);
			}
			//(다중) 파일 insert (별도의 테이블에다 함)
			sqlSession.insert("mapper.notice.insertImage", noticeImageFileList);
		}
		
		
	}	
	
	
	public int selectNoticeImageFileNo() throws DataAccessException {
		return sqlSession.selectOne("mapper.notice.selectNoticeImageFileNo");
	}

	//  max 값 + 1
	public int selectNoticeNo() throws DataAccessException {
		return sqlSession.selectOne("mapper.notice.selectNoticeNo");
	}
	
	
	
	
	
	//03. 공지사항 상세보기
	@Override
	public NoticeVO viewNotice(int noNumber) throws DataAccessException {
		
		return sqlSession.selectOne("mapper.notice.viewNotice",noNumber);
	}
	
	//04. 공지사항 삭제
	@Override
	public int removeNotice(int noNumber) throws DataAccessException {
		int result = sqlSession.delete("mapper.notice.removeNotice",noNumber);
		return result;
	}
	
	//05. 공지사항 수정
	@Override
	public void updateNotice(Map noticeMap) throws DataAccessException {
		sqlSession.update("mapper.notice.updateNotice",noticeMap);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!DAO");	
	}
	

	

}
