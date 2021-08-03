package kr.or.pets.protectPets.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("ImageVO")
public class ImageVO {
	
	private int imageFileNo;
	private String imageFileName;
	private Date regDate;
	private int proBoardNum;
	
	public int getImageFileNo() {
		return imageFileNo;
	}
	public void setImageFileNo(int imageFileNo) {
		try {
			if(imageFileName != null && imageFileName.length() != 0) {
				this.imageFileName = URLEncoder.encode(imageFileName, "utf-8");		//파일이름에 특수문자가 있을 경우 인코딩합니다.
			}
		} catch (UnsupportedEncodingException e) {
			e.getMessage();
		}
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getProBoardNum() {
		return proBoardNum;
	}
	public void setProBoardNum(int proBoardNum) {
		this.proBoardNum = proBoardNum;
	}


}
