package kr.or.pets.member.vo;

import org.springframework.stereotype.Component;

/*create table pets_user (
user_ID varchar2(20) primary key,
user_NAME varchar2(20) not null,
user_PW varchar2(20) not null,
user_Email varchar2(50) not null,
user_EmailHash varchar2(2048),
user_Address varchar2(2048) not null,
user_PhoneNumber number(20) not null,
user_IC varchar2(64) not null
);*/

@Component("memberVO")
public class MemberVO {
	private String user_ID;
	private String user_PW;
	private String user_NAME;
	private String user_Email;
	private String user_Address;
	private String user_PhoneNumber;
	private String user_IC;
	
	public MemberVO() {
		// TODO Auto-generated constructor stub
	}

	public MemberVO(String user_ID, String user_PW, String user_NAME, String user_Email,
			String user_Address, String user_PhoneNumber, String user_IC) {
		super();
		this.user_ID = user_ID;
		this.user_PW = user_PW;
		this.user_NAME = user_NAME;
		this.user_Email = user_Email;
		this.user_Address = user_Address;
		this.user_PhoneNumber = user_PhoneNumber;
		this.user_IC = user_IC;
	}

	public String getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}

	public String getUser_PW() {
		return user_PW;
	}

	public void setUser_PW(String user_PW) {
		this.user_PW = user_PW;
	}

	public String getUser_NAME() {
		return user_NAME;
	}

	public void setUser_NAME(String user_NAME) {
		this.user_NAME = user_NAME;
	}

	public String getUser_Email() {
		return user_Email;
	}

	public void setUser_Email(String user_Email) {
		this.user_Email = user_Email;
	}

	public String getUser_Address() {
		return user_Address;
	}

	public void setUser_Address(String user_Address) {
		this.user_Address = user_Address;
	}

	public String getUser_PhoneNumber() {
		return user_PhoneNumber;
	}

	public void setUser_PhoneNumber(String user_PhoneNumber) {
		this.user_PhoneNumber = user_PhoneNumber;
	}

	public String getUser_IC() {
		return user_IC;
	}

	public void setUser_IC(String user_IC) {
		this.user_IC = user_IC;
	}
		
}
