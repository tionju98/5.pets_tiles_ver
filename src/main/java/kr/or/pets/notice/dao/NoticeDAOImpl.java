package kr.or.pets.notice.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

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
	
	//02-1. 공지사항 등록
	@Override
	public int insertNotice(NoticeVO noticeVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.notice.insertNotice",noticeVO);
		return result;
	}
	
	//03. 공지사항 상세보기
	@Override
	public NoticeVO viewNotice(int no_number) throws DataAccessException {
		
		return sqlSession.selectOne("mapper.notice.viewNotice",no_number);
	}
	
	//04. 공지사항 삭제
	@Override
	public int removeNotice(int no_number) throws DataAccessException {
		int result = sqlSession.delete("mapper.notice.removeNotice",no_number);
		return result;
	}
	
	//05. 공지사항 수정
	@Override
	public int updateNotice(NoticeVO noticeVO) throws DataAccessException {
		int result = sqlSession.update("mapper.notice.updateNotice",noticeVO);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!DAO");
		return result;
	}
	
	

}
