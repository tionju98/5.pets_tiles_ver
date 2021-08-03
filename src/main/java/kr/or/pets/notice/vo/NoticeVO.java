package kr.or.pets.notice.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Date;

import org.springframework.stereotype.Component;


/*noNumber   number(20)   not null      PRIMARY KEY
, noTitle   varchar2(20)   not null
, noContent   varchar2(4000)   not null
, noWriter   varchar2(20)
, noDate    date default sysdate 
, noHits   number(20)
, noImage   varchar2(30)  */

@Component("noticeVO")
public class NoticeVO {
	private int noNumber;
	private String noTitle;
	private String noContent;
	private String noWriter;
	private Date noDate;
	private int noHits;
	private String noImage;
	
	



	public int getNoNumber() {
		return noNumber;
	}


	public void setNoNumber(int noNumber) {
		this.noNumber = noNumber;
	}


	public String getNoTitle() {
		return noTitle;
	}


	public void setNoTitle(String noTitle) {
		this.noTitle = noTitle;
	}


	public String getNoContent() {
		return noContent;
	}


	public void setNoContent(String noContent) {
		this.noContent = noContent;
	}


	public String getNoWriter() {
		return noWriter;
	}


	public void setNoWriter(String noWriter) {
		this.noWriter = noWriter;
	}


	public Date getNoDate() {
		return noDate;
	}


	public void setNoDate(Date noDate) {
		this.noDate = noDate;
	}


	public int getNoHits() {
		return noHits;
	}


	public void setNoHits(int noHits) {
		this.noHits = noHits;
	}


	public String getNoImage() {
		
		try {
			
			if(noImage != null && noImage.length() != 0) {
				noImage = URLDecoder.decode(noImage, "utf-8");
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return noImage;
	
	}


	public void setNoImage(String noImage) {
		try {
			if(noImage != null && noImage.length() != 0) {
				this.noImage = URLEncoder.encode(noImage, "utf-8");
			}
		} catch (UnsupportedEncodingException e ) {
			e.printStackTrace();
		}
	}


	
	
}
