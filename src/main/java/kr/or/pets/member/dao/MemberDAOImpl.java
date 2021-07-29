package kr.or.pets.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import kr.or.pets.member.vo.MemberVO;

@Repository("memberDAO")							/* id가 memberDAO인 빈을 자동 생성함. */
public class MemberDAOImpl implements MemberDAO {
	@Autowired										/* XML 설정 파일에서 생성한 id가 sqlSession인 빈을 자동 주입함. */
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List selectAllMemberList() throws DataAccessException {
		List<MemberVO> membersList = sqlSession.selectList("mapper.member.selectAllMemberList");
		return membersList;
	}

	@Override
	public int insertMember(MemberVO memberVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.member.insertMember", memberVO);
		return result;
	}

	@Override
	public int deleteMember(String user_ID) throws DataAccessException {
		int result = sqlSession.delete("mapper.member.deleteMember", user_ID);
		return result;
	}

	@Override
	public MemberVO loginById(MemberVO memberVO) throws DataAccessException {
		MemberVO vo = sqlSession.selectOne("mapper.member.loginById", memberVO);
		
		return vo;
	}
	
	@Override
	public List selectAllShelterList() throws DataAccessException {
		List<MemberVO> membersList = sqlSession.selectList("mapper.member.selectAllShelterList");
		return membersList;
	}
}









