package kr.or.pets.protectPets.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("proPetsVO")
public class ProPetsVO {
	 
	private int proBoardNum;
	private String proNoticeNum;
	private String proKind;
	private String proGender;
	private String proAge;
	private String proPlace;
	private String proFindDate;
	private String proCharacter;
	private String proNeutering;
	private String proRegistNum;
	private String proState;
	private String proShelter;
	private String proImg;
	private Date proDate;
	private String userID;

	public ProPetsVO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ProPetsVO(String proNoticeNum, String proKind, String proGender, String proAge,
			String proPlace, String proFindDate, String proCharacter, String proNeutering, String proRegistNum,
			String proState, String proShelter, String proImg, String userID) {
		super();
		this.proNoticeNum = proNoticeNum;
		this.proKind = proKind;
		this.proGender = proGender;
		this.proAge = proAge;
		this.proPlace = proPlace;
		this.proFindDate = proFindDate;
		this.proCharacter = proCharacter;
		this.proNeutering = proNeutering;
		this.proRegistNum = proRegistNum;
		this.proState = proState;
		this.proShelter = proShelter;
		this.proImg = proImg;
		this.userID = userID;
	}
	
	
	public int getProBoardNum() {
		return proBoardNum;
	}

	public void setProBoardNum(int proBoardNum) {
		this.proBoardNum = proBoardNum;
	}

	public String getProNoticeNum() {
		return proNoticeNum;
	}

	public void setProNoticeNum(String proNoticeNum) {
		this.proNoticeNum = proNoticeNum;
	}

	public String getProKind() {
		return proKind;
	}

	public void setProKind(String proKind) {
		this.proKind = proKind;
	}

	public String getProGender() {
		return proGender;
	}

	public void setProGender(String proGender) {
		this.proGender = proGender;
	}

	public String getProAge() {
		return proAge;
	}

	public void setProAge(String proAge) {
		this.proAge = proAge;
	}

	public String getProPlace() {
		return proPlace;
	}

	public void setProPlace(String proPlace) {
		this.proPlace = proPlace;
	}

	public String getProFindDate() {
		return proFindDate;
	}

	public void setProFindDate(String proFindDate) {
		this.proFindDate = proFindDate;
	}

	public String getProCharacter() {
		return proCharacter;
	}

	public void setProCharacter(String proCharacter) {
		this.proCharacter = proCharacter;
	}

	public String getProNeutering() {
		return proNeutering;
	}

	public void setProNeutering(String proNeutering) {
		this.proNeutering = proNeutering;
	}

	public String getProRegistNum() {
		return proRegistNum;
	}

	public void setProRegistNum(String proRegistNum) {
		this.proRegistNum = proRegistNum;
	}

	public String getProState() {
		return proState;
	}

	public void setProState(String proState) {
		this.proState = proState;
	}

	public String getProShelter() {
		return proShelter;
	}

	public void setProShelter(String proShelter) {
		this.proShelter = proShelter;
	}
	
	public String getProImg() {
		try {
			if(proImg != null && proImg.length() != 0) {
				proImg = URLDecoder.decode(proImg, "utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return proImg;
	}

	public void setProImg(String proImg) {
		try {
			if(proImg != null && proImg.length() != 0) {
				this.proImg = URLEncoder.encode(proImg, "utf-8");
			}
		} catch (UnsupportedEncodingException e ) {
			e.printStackTrace();
		}
	}

	public Date getProDate() {
		return proDate;
	}

	public void setProDate(Date proDate) {
		this.proDate = proDate;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	


}
