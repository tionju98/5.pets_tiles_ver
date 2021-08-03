package kr.or.pets.common.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FileDownloadController {
	private static String ARTICLE_IMAGE_REPO = "C:\\workspace-sts\\article_image";
	private static String NOTICE_IMAGE_REPO = "C:\\workspace-sts\\notice_image";
	
	@RequestMapping("/download.do")
	protected void download(@RequestParam("imageFileName") String imageFileName,
							@RequestParam("proBoardNum") String proBoardNum,
							HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String downFile = ARTICLE_IMAGE_REPO +"\\"+ proBoardNum +"\\"+ imageFileName;			//값 할당안됨.
		File file = new File(downFile);				
		
	 	response.setHeader("Cache-Control", "no-chache");
	 	response.addHeader("Content-disposition", "attachment;filename=" + imageFileName);
	 	
	 	FileInputStream in = new FileInputStream(file);
	 	
	 	byte[] buffer = new byte[1024 * 8];
	 	while(true) {
	 		int count = in.read(buffer);
	 		if(count == -1) break;
	 		out.write(buffer, 0, count);
	 	}
	 	
	 	in.close();
	 	out.close();	 	
	}
	@RequestMapping("/noticeDownload.do")
	protected void noticeDownload(@RequestParam("noticeImageFileName") String noticeImageFileName,
								  @RequestParam("noNumber") String noNumber,
								  HttpServletResponse response) throws Exception{
		
		
		OutputStream out = response.getOutputStream();
		String downFile = NOTICE_IMAGE_REPO + "\\" + noNumber + "\\" + noticeImageFileName;
		File file = new File(downFile);
		
		response.setHeader("Cache-Control", "no-chache");
		response.addHeader("Content-disposition", "attachment;filename="+noticeImageFileName);
		
		FileInputStream in = new FileInputStream(file);
		
		byte[] buffer = new byte[1024*8];
		while(true) {
			int count = in.read(buffer);
			if(count == -1) break;
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
	}
	
}
