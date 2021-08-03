package kr.or.pets.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class FileDownloadController
 */

public class FileDownloadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String ARTICLE_IMAGE = "C:\\workspace-pets\\article_image";
	private static String NOTICE_IMAGE = "C:\\workspace-pets\\notice_image";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		//protect image 처리
	 	String imageFileName = request.getParameter("imageFileName");
	 	String pro_boardNum = request.getParameter("pro_boardNum");
	 	System.out.println("imageFileName : " + imageFileName);
	 	
	 	//notice image 처리
	 	String noticeImageFileName = request.getParameter("noticeImageFileName");
	 	String noNumber = request.getParameter("noNumber");
	 	System.out.println("noticeImageFileName : "+ noticeImageFileName);
	 	
	 	
	 	
	 	response.setHeader("Cache-Control", "no-chache");
	 	response.addHeader("content-disposition", "attachment;filename=" + imageFileName);
	 	response.addHeader("content-disposition", "attachment;filename="+noticeImageFileName);
	 	
	 	
	 	String path = ARTICLE_IMAGE +"\\"+ pro_boardNum +"\\"+ imageFileName;
	 	File imageFile = new File(path);
	 	OutputStream out = response.getOutputStream();
	 	FileInputStream in = new FileInputStream(imageFile);

	 	String noticePath = NOTICE_IMAGE + "\\" +noNumber +"\\" + noticeImageFileName;
	 	File noticeImageFile = new File(noticePath);
	 	//OutputStream noticeOut = request.getOutputStream();
	 	FileInputStream noticeIn = new FileInputStream(noticeImageFile);
	 	
	 	byte[] buffer = new byte[1024 * 8];
	 	while(true) {
	 		int count = in.read(buffer);
	 		if(count == -1) break;
	 		out.write(buffer, 0, count);
	 	}
	 	
	 	byte[] noticeBuffer = new byte[1024 * 8];
	 	while(true) {
	 		int noticeCount = noticeIn.read(noticeBuffer);
	 		if(noticeCount== -1) break;
	 		out.write(noticeBuffer, 0, noticeCount);
	 	}
	 	
	 	noticeIn.close();
	 	in.close();
	 	out.close();
		
	}

}

























