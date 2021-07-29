package kr.or.pets.notice.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("noticeVO")
public class NoticeVO {
	private int no_number;
	private String no_title;
	private String no_content;
	private String no_writer;
	private Date no_date;
	private int no_hits;
	private String no_image;
	
	
	public NoticeVO() {
		// TODO Auto-generated constructor stub
	}


	public NoticeVO(String no_title, String no_content, String no_writer, String no_image) {
		super();
		this.no_title = no_title;
		this.no_content = no_content;
		this.no_writer = no_writer;
		this.no_image = no_image;
	}


	public int getNo_number() {
		return no_number;
	}


	public void setNo_number(int no_number) {
		this.no_number = no_number;
	}


	public String getNo_title() {
		return no_title;
	}


	public void setNo_title(String no_title) {
		this.no_title = no_title;
	}


	public String getNo_content() {
		return no_content;
	}


	public void setNo_content(String no_content) {
		this.no_content = no_content;
	}


	public String getNo_writer() {
		return no_writer;
	}


	public void setNo_writer(String no_writer) {
		this.no_writer = no_writer;
	}


	public Date getNo_date() {
		return no_date;
	}


	public void setNo_date(Date no_date) {
		this.no_date = no_date;
	}


	public int getNo_hits() {
		return no_hits;
	}


	public void setNo_hits(int no_hits) {
		this.no_hits = no_hits;
	}


	public String getNo_image() {
		return no_image;
	}


	public void setNo_image(String no_image) {
		this.no_image = no_image;
	}
	
	
}
