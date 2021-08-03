package kr.or.pets.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import kr.or.pets.member.vo.MemberVO;

public interface MemberService {
	public List listMembers() throws DataAccessException;

	public int addMember(MemberVO memberVO) throws DataAccessException;

	public int removeMember(String userID) throws DataAccessException;

	public MemberVO login(MemberVO memberVO) throws Exception;

	public List listShelter() throws DataAccessException;
	
	public List<MemberVO> searchBoards(String searchWord) throws Exception;

	public List<String> keywordSearch(String keyword) throws Exception;
}
