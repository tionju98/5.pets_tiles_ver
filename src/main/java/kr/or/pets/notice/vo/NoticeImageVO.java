package kr.or.pets.notice.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Date;

import org.springframework.stereotype.Component;

/*
noticeImageNo number(10) PRIMARY KEY
, noticeImageFileName varchar2(50)
, regDate DATE DEFAULT sysdate
, noNumber number(10)
, CONSTRAINT FKNoNumber FOREIGN key(noNumber)
REFERENCES noticePage(noNumber) on delete CASCADE
*/
@Component("noticeImageVO")
public class NoticeImageVO {

	private int noticeImageNo;
	private String noticeImageFileName;
	private Date regDate;
	private int noNumber;
	
	
	
	public NoticeImageVO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int getNoticeImageNo() {
		return noticeImageNo;
	}
	
	
	public void setNoticeImageNo(int noticeImageNo) {
		try {
			if(noticeImageFileName != null && noticeImageFileName.length() != 0) {
				this.noticeImageFileName = URLEncoder.encode(noticeImageFileName, "utf-8");		//파일이름에 특수문자가 있을 경우 인코딩합니다.
			}
		} catch (UnsupportedEncodingException e) {
			e.getMessage();
		}
	}
	
	public String getNoticeImageFileName() {
		return noticeImageFileName;
	}
	public void setNoticeImageFileName(String noticeImageFileName) {
		this.noticeImageFileName = noticeImageFileName;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getNoNumber() {
		return noNumber;
	}
	public void setNoNumber(int noNumber) {
		this.noNumber = noNumber;
	}
	
	
}
