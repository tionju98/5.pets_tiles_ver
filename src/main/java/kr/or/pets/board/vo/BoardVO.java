package kr.or.pets.board.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("boardVO")
public class BoardVO {
	private int level;
	private int qa_No;
	private int qa_parentNo;
	private String qa_title;
	private String qa_category;
	private String qa_content;
	private Date qa_date;
	private String user_ID;
	
	public BoardVO() {
	}

	public BoardVO(int level ,int qa_No, String qa_title, String qa_category, String qa_content, Date qa_date, String user_ID) {
		super();
		this.level = level;
		this.qa_No = qa_No;
		this.qa_title = qa_title;
		this.qa_category = qa_category;
		this.qa_content = qa_content;
		this.qa_date = qa_date;
		this.user_ID = user_ID;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public String getQa_category() {
		return qa_category;
	}

	public void setQa_category(String qa_category) {
		this.qa_category = qa_category;
	}

	public int getQa_No() {
		return qa_No;
	}

	public void setQa_No(int qa_No) {
		this.qa_No = qa_No;
	}

	public int getQa_parentNo() {
		return qa_parentNo;
	}

	public void setQa_parentNo(int qa_parentNo) {
		this.qa_parentNo = qa_parentNo;
	}

	public String getQa_title() {
		return qa_title;
	}

	public void setQa_title(String qa_title) {
		this.qa_title = qa_title;
	}

	public Date getQa_date() {
		return qa_date;
	}

	public void setQa_date(Date qa_date) {
		this.qa_date = qa_date;
	}

	public String getQa_content() {
		return qa_content;
	}

	public void setQa_content(String qa_content) {
		this.qa_content = qa_content;
	}

	public String getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}


	
	
	
	
}
