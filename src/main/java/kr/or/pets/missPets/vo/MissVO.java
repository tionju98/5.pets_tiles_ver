package kr.or.pets.missPets.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Date;

import org.springframework.stereotype.Component;

/*

CREATE TABLE missBoard
(
      missBoardNum     VARCHAR2(50)       PRIMARY KEY
     ,missName         VARCHAR2(50)
     ,userNAME         VARCHAR2(50)
     ,userId           VARCHAR2(50)
     ,userEmail        VARCHAR2(50)
     ,userAddress      VARCHAR2(100)
     ,userPhoneNumber     VARCHAR2(50)
     ,missKind         VARCHAR2(50)      
     ,missGender       VARCHAR2(10)
     ,missAge          VARCHAR2(50)
     ,missPlace        VARCHAR2(500)
     ,missMissdate         DATE
     ,missCharacter    VARCHAR2(4000)
     ,missRegistNum    VARCHAR2(20)
     ,missImg          VARCHAR2(30)
     ,constraint FK_ID_miss foreign key(userID) 
      REFERENCES  petsUser(userID)
);
*/
@Component("missVO")
public class MissVO {
	private int missBoardNum;
	private String missName;		/* 실종동물 이름 */
	private String userNAME;
	private String userEmail;
	private String userAddress;
	private String userPhoneNumber;
	private String missKind;		/* 실종동물 종류 */
	private String missGender;		/* 실종동물 성별 */
	private String missAge;			/* 실종동물 나이 */
	private String missPlace;		/* 실종장소 */
	private String missMissdate;		/* 실종한 날짜 */
	private String missCharacter;   /* 특징 */
	private String missRegistNum;		
	private String missImg;		/* 실종동물 사진 */
	private String userID;
	
	
	public MissVO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int getMissBoardNum() {
		return missBoardNum;
	}
	public void setMissBoardNum(int missBoardNum) {
		this.missBoardNum = missBoardNum;
	}
	public String getMissName() {
		return missName;
	}
	public void setMissName(String missName) {
		this.missName = missName;
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
	public String getMissKind() {
		return missKind;
	}
	public void setMissKind(String missKind) {
		this.missKind = missKind;
	}
	public String getMissGender() {
		return missGender;
	}
	public void setMissGender(String missGender) {
		this.missGender = missGender;
	}
	public String getMissAge() {
		return missAge;
	}
	public void setMissAge(String missAge) {
		this.missAge = missAge;
	}
	public String getMissPlace() {
		return missPlace;
	}
	public void setMissPlace(String missPlace) {
		this.missPlace = missPlace;
	}
	public String getMissMissdate() {
		return missMissdate;
	}
	public void setMissMissdate(String missMissdate) {
		this.missMissdate = missMissdate;
	}
	public String getMissCharacter() {
		return missCharacter;
	}
	public void setMissCharacter(String missCharacter) {
		this.missCharacter = missCharacter;
	}
	public String getMissRegistNum() {
		return missRegistNum;
	}
	public void setMissRegistNum(String missRegistNum) {
		this.missRegistNum = missRegistNum;
	}
	public String getMissImg() {
		return missImg;
	}
	public void setMissImg(String missImg) {
		this.missImg = missImg;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public MissVO(int missBoardNum, String missName, String userNAME, String userEmail, String userAddress,
			String userPhoneNumber, String missKind, String missGender, String missAge, String missPlace,
			String missMissdate, String missCharacter, String missRegistNum, String missImg, String userID) {
		super();
		this.missBoardNum = missBoardNum;
		this.missName = missName;
		this.userNAME = userNAME;
		this.userEmail = userEmail;
		this.userAddress = userAddress;
		this.userPhoneNumber = userPhoneNumber;
		this.missKind = missKind;
		this.missGender = missGender;
		this.missAge = missAge;
		this.missPlace = missPlace;
		this.missMissdate = missMissdate;
		this.missCharacter = missCharacter;
		this.missRegistNum = missRegistNum;
		this.missImg = missImg;
		this.userID = userID;
	}


	

}
