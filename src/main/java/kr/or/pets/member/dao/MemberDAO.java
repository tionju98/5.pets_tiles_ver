package kr.or.pets.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import kr.or.pets.member.vo.MemberVO;

public interface MemberDAO {
	public List selectAllMemberList() throws DataAccessException;

	public int insertMember(MemberVO memberVO) throws DataAccessException;

	public int deleteMember(String userID) throws DataAccessException;
	
	public MemberVO loginById(MemberVO memberVO) throws DataAccessException;

	public List selectAllShelterList() throws DataAccessException;
	
	public List<MemberVO> selectBoardsBySearchWord(String searchWord) throws DataAccessException;

	public List<String> selectKeywordSearch(String keyword) throws DataAccessException;
}
