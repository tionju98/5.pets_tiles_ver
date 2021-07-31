package kr.or.pets.notice.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import kr.or.pets.notice.service.NoticeService;
import kr.or.pets.notice.vo.NoticeImageVO;
import kr.or.pets.notice.vo.NoticeVO;

@Controller("noticeController")
public class NoticeControllerImpl implements NoticeController {
	private static final Logger logger = LoggerFactory.getLogger(NoticeControllerImpl.class);
	private static final String NOTICE_IMAGE = "C:\\workspace-pets\\notice_image";
	
	@Autowired
	private NoticeService noticeService;
	@Autowired
	public NoticeVO noticeVO;
	
	
	//01. 공지사항 전체 목록 조회
	@Override
	@RequestMapping(value = "/notice/listNotices.do", method = {RequestMethod.GET, RequestMethod.POST}) 
	public ModelAndView listNotices(HttpServletRequest request, HttpServletResponse response) throws Exception	 {
		
		  request.setCharacterEncoding("utf-8");
		  String section_ = request.getParameter("section");
		  String pageNum_ = request.getParameter("pageNum");
		  
		  int section = Integer.parseInt(((section_== null)?"1":section_));
		  int pageNum = Integer.parseInt(((pageNum_== null)?"1":pageNum_));
		  logger.info("section :" + section);
		  logger.info("pageNum :" + pageNum);
		  
		  Map<String, Integer> pagingMap = new HashMap<>(); 
		  pagingMap.put("section", section);
		  pagingMap.put("pageNum", pageNum);
		  logger.info("pagingMap1 :" + pagingMap);
		  
		  Map noticeMap = noticeService.listNotices(pagingMap);
		  logger.info("pagingMap2 :" + pagingMap);
		  noticeMap.put("section", section);
		  noticeMap.put("pageNum", pageNum);
		  
		  String viewName = (String)request.getAttribute("viewName");
		  logger.info("viewName :" + viewName);
		  ModelAndView mav = new ModelAndView(viewName);
		  mav.addObject("noticeMap", noticeMap);
		  
		  return mav;
		 
		}


	//02-1. 공지사항 등록화면
	@Override
	@RequestMapping(value = "/notice/insertNotice.do", method = {RequestMethod.GET, RequestMethod.POST} )
	public ModelAndView insertNotice(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		
		String viewName = (String) request.getAttribute("viewName");
		
		logger.info("viewName"+viewName);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		
		return mav;
	}
	
	
	//02-2. 공지사항 등록처리
	@RequestMapping(value = "/notice/addNotice.do", method =RequestMethod.POST)
	@ResponseBody
	public ResponseEntity addNotice(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception {
		multipartRequest.setCharacterEncoding("UTF-8");
		
		Map noticeMap = new HashMap();
		Enumeration enu = multipartRequest.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = (String)enu.nextElement();
			String value = multipartRequest.getParameter(name);
			noticeMap.put(name, value);
		}
		
		//로그인 시 세션에 저장된 회원 정보에서 글쓴이 아이디 얻어와 Map에 역시 저장함.
		HttpSession session = multipartRequest.getSession();
		NoticeVO noticeVO = (NoticeVO)session.getAttribute("notice");
		//String no_writer = noticeVO.getNo_writer();				//(나중에 주석해제필요)
		//noticeMap.put("no_writer", no_writer);					//(나중에 주석해제필요)
		
		//이미지 부분 업로드부분 추가
		List<String> fileList = upload(multipartRequest);
		
		//(다중이미지 고려해서 다중) 파일을 Map에 역시 저장함.
		List<NoticeImageVO> noticeImageFileList = new ArrayList<>();
		if (fileList != null && fileList.size() != 0) {
			for (String fileName : fileList) {
				NoticeImageVO noticeImageVO = new NoticeImageVO();
				noticeImageVO.setNoticeImageFileName(fileName);
						
				noticeImageFileList.add(noticeImageVO);
				}
					
			noticeMap.put("noticeImageFileList", noticeImageFileList);
			}
		
		
		// 새글 등록시 위 이미지외에 나머지 입력사항 처리하기
	    //alert창 메시지 구현
	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.add("Content-Type", "text/html; charset=utf-8");
	    String message;
	    ResponseEntity responseEntity = null;
		String noticeImageFileName = null;
		
		 try {
		    	
		     int no_number = noticeService.addNotice(noticeMap);
		     
		     if (noticeImageFileList != null && noticeImageFileList.size() != 0) {
		    	for (NoticeImageVO  noticeImageVO : noticeImageFileList) {
		    		//2) 각 글의 임시저장위치(temp)에 있던 이미지를 해당 글 아래로 이동
		    		noticeImageFileName = noticeImageVO.getNoticeImageFileName();
		    		
		    		File srcFile = new File(NOTICE_IMAGE  +"\\"+  "temp"  +"\\"+  noticeImageFileName);
		    		File destFile = new File(NOTICE_IMAGE  +"\\"+ no_number );
		    		
		    		FileUtils.moveFileToDirectory(srcFile, destFile, true);
		    	}
		     }
		     
		     message = "<script>";
			  message += " alert('새글을 등록했습니다.');";			  
			  //message += " location.href='        "+request.getContextPath()+"     /board/viewBoard.do?qa_No=qa_No                    ';    ";
			  //message += " location.href='        "+request.getContextPath()+"     /board/viewBoard.do?qa_No="
			  //		+ qa_No +   "';";
			  message += " location.href='"+multipartRequest.getContextPath()+"/notice/viewNotice.do?no_number="
				  		+ noticeMap.get("no_number") +   "';";			  
			  message += " </script>";
			  
			  responseEntity = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);	  
		
		 } catch (Exception e) {
		    	//업로드된 파일이 있다면 삭제처리
		    	if (noticeImageFileList != null && noticeImageFileList.size() != 0) {
		    		for (NoticeImageVO noticeImageVO : noticeImageFileList) {
		    			noticeImageFileName = noticeImageVO.getNoticeImageFileName();
		    			
		    			File srcFile = new File(NOTICE_IMAGE  +"\\"+  "temp"  +"\\"+  noticeImageFileName);
		    			srcFile.delete();
		    		}
		    	}
		    	
		    	
		    	 message = "<script>";
				  message += " alert('오류가 발생했습니다. 다시 시도해주세요.');";			  
				  //message += " location.href='        "+request.getContextPath()+"     /board/viewBoard.do?qa_No=qa_No                    ';    ";
				  //message += " location.href='        "+request.getContextPath()+"     /board/viewBoard.do?qa_No="
				  //		  + qa_No +   "';";
				  message += " location.href='"+multipartRequest.getContextPath()+"/notice/insertNotice.do';";
				  
				  message += " </script>";			  
				  
				  responseEntity = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
				  
				  e.printStackTrace();
			}
			
			return responseEntity;
		
	}


	private List<String> upload(MultipartHttpServletRequest multipartRequest) throws Exception {
		List<String> fileList = new ArrayList<>();
		
		Iterator<String> fileNames = multipartRequest.getFileNames();				// 다중 이미지도 고려
		while(fileNames.hasNext()) {
			String fileName = fileNames.next();
			MultipartFile mFile = multipartRequest.getFile(fileName);
			
			//앞에 있는 경로(path) 분리하기 위한 작업
			String originalFileName = mFile.getOriginalFilename();
			if (originalFileName != "" && originalFileName != null) {
				//db에 이미지이름 업로드
				fileList.add(originalFileName);
				
				//fileSystem 특정위치에 업로드
				File file = new File(NOTICE_IMAGE +"\\"+ fileName);
				if (mFile.getSize() != 0) {					//파일 null 체크
					if (!file.exists()) {					//예외사항 체크(경로에 파일존재해야)
						file.getParentFile().mkdirs();		//경로에 해당하는 디렉토리들 생성
						
						mFile.transferTo(new File(NOTICE_IMAGE  +"\\"+ "temp" +"\\"+  originalFileName));			//1) 각 글의 임시저장위치(temp)에 우선저장
					}
				}
				
				
			}
			
			
			
		}
		
		
		return fileList;
	}



	//03. 공지사항 상세화면
	@RequestMapping(value = "/notice/viewNotice.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView viewNotice(@RequestParam("no_number") int no_number, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		String viewName = (String)request.getAttribute("viewName");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$no_number : "+no_number);
		
		Map noticleMap = noticeService.viewNotice(no_number);
		
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName(viewName);
		mav.addObject("noticleMap", noticleMap);
		
		return mav;
	}

	
	// 05. 공지사항 수정폼 이동  -- 상세화면과 내용 중복됨
	@RequestMapping(value = "/notice/updateNotice.do", method = {RequestMethod.GET, RequestMethod.POST} )
	public ModelAndView updateNotice(@RequestParam("no_number") int no_number,HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		
		String viewName = (String) request.getAttribute("viewName");
		
		Map noticleMap = noticeService.viewNotice(no_number);
		
		logger.info("viewName"+viewName);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("noticleMap", noticleMap);
		
		mav.setViewName(viewName);
		
		return mav;
	}	
	
	
	//05-2. 공지사항 수정
	@Override
	@RequestMapping(value = "/notice/modNotice.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView updateNotice(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		int no_number = Integer.parseInt(request.getParameter("no_number"));
		String no_title = request.getParameter("no_title");
		String no_content = request.getParameter("no_content");
		
		Map noticeMap = new HashMap();
		noticeMap.put("no_number", no_number);
		noticeMap.put("no_title", no_title);
		noticeMap.put("no_content", no_content);
		
		Map updateMap = noticeService.updateNotice(noticeMap);
		
		
		//아래 변경예정
		
		
		
		System.out.println("=====controller");
		ModelAndView mav = new ModelAndView("redirect:/notice/listNotices.do");
		
		return mav;
	}

	
	



	
	
	/*
	 * //02-2. 공지사항 등록 처리
	 * 
	 * @Override
	 * 
	 * @RequestMapping(value = "notice/addNotice.do", method = RequestMethod.POST)
	 * public ModelAndView addNotice(HttpServletRequest request, HttpServletResponse
	 * response) throws Exception { request.setCharacterEncoding("utf-8");
	 * response.setContentType("html/text;charset=utf-8");
	 * 
	 * NoticeVO noticeVO = new NoticeVO();
	 * 
	 * int result = noticeService.addNotice(noticeVO);
	 * 
	 * ModelAndView mav = new ModelAndView("redirect:/notice/listNotices.do");
	 * 
	 * return mav; }
	 */


	
	
	
	
	
	
	
	
	
	

	


	//04. 공지사항 삭제
	@RequestMapping(value = "/notice/removeNotice.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView removeNotice(@RequestParam("no_number") int no_number, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		noticeService.removeNotice(no_number);
		ModelAndView mav = new ModelAndView("redirect:/notice/listNotices.do");
		
		return mav;
	}


	@Override
	public ModelAndView removeNotice(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
				return null;
	}


	@Override
	public ModelAndView modNotice(NoticeVO noticeVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
	
	
