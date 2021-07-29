package kr.or.pets.notice.controller;

import java.net.http.HttpHeaders;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.or.pets.notice.service.NoticeService;
import kr.or.pets.notice.vo.NoticeVO;

@Controller("noticeController")
public class NoticeControllerImpl implements NoticeController {
	private static final Logger logger = LoggerFactory.getLogger(NoticeControllerImpl.class);
	
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
	@RequestMapping(value = "/notice/addNotice.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView addNotice(@ModelAttribute("notice") NoticeVO noticeVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		int result = noticeService.addNotice(noticeVO);
		
		ModelAndView mav = new ModelAndView("redirect:/notice/listNotices.do");
		
		return mav;
	}


	@Override
	public ModelAndView addNotice(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
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


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		/*
		 * @Override public ModelAndView viewNotice(HttpServletRequest request,
		 * HttpServletResponse response, HttpSession session) throws Exception {
		 * 
		 * System.out.println(
		 * "========================================-------------------------B"); String
		 * viewName = (String)request.getAttribute("viewName"); // 조회수 증가 처리
		 * //noticeService.increaseViewCnt(no_number, session); // 모델(데이터) + 뷰(화면)를 함께
		 * 전달하는 객체 System.out.println(
		 * "========================================-------------------------C");
		 * 
		 * ModelAndView mav = new ModelAndView(viewName); //뷰의 이름
		 * mav.setViewName("/viewNotice"); // 뷰에 전달할 데이터
		 * //mav.addObject("viewNotice",noticeService.readNotice(no_number)); return
		 * mav;
		 * 
		 * }
		 */
}
	
/*
 * //02-1. 공시자항 작성화면
 * 
 * @RequestMapping(value = "notice/noticeInsert.do", method = RequestMethod.GET)
 * //get방식 public ModelAndView noticeInsert(HttpServletRequest request,
 * HttpServletResponse response) throws Exception{ //return
 * "notice/noticeInsert.do"; noticeInsert.jsp로 이동
 * 
 * String viewName = (String)request.getAttribute("viewName"); ModelAndView mav
 * = new ModelAndView(); mav.setViewName(viewName); return mav; }
 * 
 * //02-2. 공지사항 작성 처리
 * 
 * @Override
 * 
 * @RequestMapping(value = "notice/addNotice.do", method = RequestMethod.POST)
 * //post방식 public ModelAndView addNotice(HttpServletRequest request,
 * HttpServletResponse response) throws Exception {
 * request.setCharacterEncoding("utf-8");
 * 
 * NoticeVO noticeVO = new NoticeVO();
 * 
 * bind(request, noticeVO); int result = noticeService.addNotice(noticeVO);
 * 
 * ModelAndView mav = new ModelAndView("redirect:/notice/listNotices.do");
 * 
 * return mav; }
 * 
 * //03. 공지사항 상세내용 조회, 공지사항 조회수 증가 처리
 * 
 * @RequestMapping(value = "/notice/viewNotice.do" , method = RequestMethod.GET
 * ) public ModelAndView viewNotice(@RequestParam("no_number") int
 * no_number,HttpServletRequest request, HttpServletResponse response) throws
 * Exception { System.out.println(
 * "========================================-------------------------B");
 * request.setCharacterEncoding("utf-8");
 * 
 * // 조회수 증가 처리 //noticeService.increaseViewCnt(no_number, session);
 * 
 * // 모델(데이터) + 뷰(화면)를 함께 전달하는 객체 ModelAndView mav = new ModelAndView(); //뷰의 이름
 * mav.setViewName("/viewNotice"); // 뷰에 전달할 데이터
 * mav.addObject("notice",noticeService.readNotice(no_number)); return mav; }
 * 
 * 
 * @Override public ModelAndView viewNotice(HttpServletRequest request,
 * HttpServletResponse response) throws Exception { // TODO Auto-generated
 * method stub return null; }
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */







//@RequestMapping(value = "/notice/viewNotice.do"  /* , method = RequestMethod.GET */)
	/*
	 * public ModelAndView viewNotice1(HttpServletRequest request,
	 * HttpServletResponse response ,HttpSession session) throws Exception { String
	 * viewName = getViewName(request); // 조회수 증가 처리
	 * //noticeService.increaseViewCnt(no_number, session); // 모델(데이터) + 뷰(화면)를 함께
	 * 전달하는 객체 System.out.println(
	 * "========================================-------------------------S");
	 * 
	 * ModelAndView mav = new ModelAndView(); //뷰의 이름
	 * mav.setViewName("/viewNotice"); // 뷰에 전달할 데이터
	 * //mav.addObject("viewNotice",noticeService.readNotice(no_number)); return
	 * mav; }
	 */


	//viewNotice로 넘어가기 성공
	
	
	 
	
	
	/*
	 * @Override public ModelAndView viewNotice(HttpServletRequest request,
	 * HttpServletResponse response,HttpSession session) throws Exception {
	 * 
	 * System.out.println(
	 * "========================================-------------------------B"); String
	 * viewName = getViewName(request);
	 * 
	 * // 조회수 증가 처리 int no_number =
	 * Integer.getInteger(request.getParameter("no_number"));
	 * noticeService.increaseViewCnt(no_number, session); // 모델(데이터) + 뷰(화면)를 함께
	 * 전달하는 객체 System.out.println(
	 * "========================================-------------------------C");
	 * 
	 * ModelAndView mav = new ModelAndView(viewName); //뷰의 이름
	 * mav.setViewName("/viewNotice"); // 뷰에 전달할 데이터
	 * mav.addObject("viewNotice",noticeService.readNotice(no_number)); return mav;
	 * }
	 */