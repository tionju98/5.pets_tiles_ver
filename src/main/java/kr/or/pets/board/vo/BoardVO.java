package kr.or.pets.board.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("boardVO")
public class BoardVO {
	private int level;
	private int qaNo;
	private int qaParentNo;
	private String qaTitle;
	private String qaCategory;
	private String qaContent;
	private Date qaDate;
	private String userID;
	private String qaSecret;
	
	public BoardVO() {
	}

	public BoardVO(int level ,int qaNo, String qaTitle, String qaCategory, String qaContent, Date qaDate, String userID, String qaSecret) {
		super();
		this.level = level;
		this.qaNo = qaNo;
		this.qaTitle = qaTitle;
		this.qaCategory = qaCategory;
		this.qaContent = qaContent;
		this.qaDate = qaDate;
		this.userID = userID;
		this.qaSecret = qaSecret;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getQaNo() {
		return qaNo;
	}

	public void setQaNo(int qaNo) {
		this.qaNo = qaNo;
	}

	public int getQaParentNo() {
		return qaParentNo;
	}

	public void setQaParentNo(int qaParentNo) {
		this.qaParentNo = qaParentNo;
	}

	public String getQaTitle() {
		return qaTitle;
	}

	public void setQaTitle(String qaTitle) {
		this.qaTitle = qaTitle;
	}

	public String getQaCategory() {
		return qaCategory;
	}

	public void setQaCategory(String qaCategory) {
		this.qaCategory = qaCategory;
	}

	public String getQaContent() {
		return qaContent;
	}

	public void setQaContent(String qaContent) {
		this.qaContent = qaContent;
	}

	public Date getQaDate() {
		return qaDate;
	}

	public void setQaDate(Date qaDate) {
		this.qaDate = qaDate;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getQaSecret() {
		return qaSecret;
	}

	public void setQaSecret(String qaSecret) {
		this.qaSecret = qaSecret;
	}
	
}
