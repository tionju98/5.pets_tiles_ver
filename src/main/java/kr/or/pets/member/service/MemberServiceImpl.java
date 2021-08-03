package kr.or.pets.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.pets.member.dao.MemberDAO;
import kr.or.pets.member.vo.MemberVO;

@Service("memberService")			/* @Service이용해서 MemberServiceImpl 클래스에 대해 id가 memberService인 빈 자동 생성함. */
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;			/* id가 memberDAO인 빈을 자동 주입함. */
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}



	@Override
	public List listMembers() throws DataAccessException {
		List membersList = memberDAO.selectAllMemberList();
		return membersList;
	}



	@Override
	public int addMember(MemberVO memberVO) throws DataAccessException {
		return memberDAO.insertMember(memberVO);
	}



	@Override
	public int removeMember(String userID) throws DataAccessException {
		return memberDAO.deleteMember(userID);
	}



	@Override
	public MemberVO login(MemberVO memberVO) throws Exception {
		return memberDAO.loginById(memberVO);
	}

	@Override
	public List listShelter() throws DataAccessException {
		List membersList = memberDAO.selectAllShelterList();
		return membersList;
	}
	
	@Override
	public List<MemberVO> searchBoards(String searchWord) throws Exception {
		List<MemberVO> boardsList = memberDAO.selectBoardsBySearchWord(searchWord);
		
		return boardsList;
	}



	@Override
	public List<String> keywordSearch(String keyword) throws Exception {
		List<String> list = memberDAO.selectKeywordSearch(keyword);
		
		return list;
	}

}






