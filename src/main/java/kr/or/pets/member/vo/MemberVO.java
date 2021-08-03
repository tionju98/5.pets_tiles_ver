package kr.or.pets.member.vo;

import org.springframework.stereotype.Component;
/*
create table petsUser (
userID varchar2(20) unique not null,
userNAME varchar2(20) not null,
userPW varchar2(20) not null,
userEmail varchar2(50) not null,
userAddress varchar2(2048) not null,
userPhoneNumber number(20) not null,
userIC varchar2(64) not null
);
*/

@Component("memberVO")
public class MemberVO {
	private String userID;
	private String userPW;
	private String userNAME;
	private String userEmail;
	private String userAddress;
	private String userPhoneNumber;
	private String userIC;
	
	public MemberVO() {
		// TODO Auto-generated constructor stub
	}

	public MemberVO(String userID, String userPW, String userNAME, String userEmail, String userAddress,
			String userPhoneNumber, String userIC) {
		super();
		this.userID = userID;
		this.userPW = userPW;
		this.userNAME = userNAME;
		this.userEmail = userEmail;
		this.userAddress = userAddress;
		this.userPhoneNumber = userPhoneNumber;
		this.userIC = userIC;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPW() {
		return userPW;
	}

	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}

	public String getUserNAME() {
		return userNAME;
	}

	public void setUserNAME(String userNAME) {
		this.userNAME = userNAME;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public String getUserIC() {
		return userIC;
	}

	public void setUserIC(String userIC) {
		this.userIC = userIC;
	}
}
