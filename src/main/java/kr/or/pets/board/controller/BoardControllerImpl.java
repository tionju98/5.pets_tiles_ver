package kr.or.pets.board.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import kr.or.pets.board.service.BoardService;
import kr.or.pets.board.vo.BoardVO;
import kr.or.pets.member.vo.MemberVO;
import net.sf.json.JSONObject;

@Controller("boardController")
@EnableAspectJAutoProxy
public class BoardControllerImpl extends MultiActionController implements BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardControllerImpl.class);
	@Autowired
	private BoardService boardService;
	@Autowired
	private BoardVO boardVO;
	

	@RequestMapping(value = "/board/boardForm.do", method = {RequestMethod.GET, RequestMethod.POST} )
	public ModelAndView boardForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		
		String viewName = (String)request.getAttribute("viewName");
		
		logger.info("viewName : " + viewName);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		
		return mav;
	}	
	
	
	@RequestMapping(value = "/board/faqPage.do", method = {RequestMethod.GET, RequestMethod.POST} )
	public ModelAndView faqPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		
		String viewName = (String)request.getAttribute("viewName");
		
		logger.info("viewName : " + viewName);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		
		return mav;
	}	
	
	@Override
	@RequestMapping(value = "/board/listBoards.do", method = {RequestMethod.GET, RequestMethod.POST}  )
	public ModelAndView listBoards(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String section_ = request.getParameter("section");
		String pageNum_ = request.getParameter("pageNum");
		
		int section = Integer.parseInt(((section_== null)? "1" : section_));
		int pageNum = Integer.parseInt(((pageNum_ == null)? "1" : pageNum_));
		logger.info("section :" + section);
		logger.info("pageNum :" + pageNum);
		
		Map<String, Integer> pagingMap = new HashMap<>();			/*section값과 pageNum값을 HashMap에 저장*/
		logger.info("pagingMap :" + pagingMap);
		pagingMap.put("section", section);
		pagingMap.put("pageNum", pageNum);
		
		Map boardMap = boardService.listBoards(pagingMap);
		logger.info("boardMap :" + boardMap);
		boardMap.put("section", section);
		boardMap.put("pageNum", pageNum);
		
		
		String viewName = (String)request.getAttribute("viewName");
		logger.info("viewName :" + viewName);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("boardMap", boardMap);
		
		return mav;
	}
	
	
	
	@RequestMapping(value = "/board/*Form.do", method = {RequestMethod.GET, RequestMethod.POST} )
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	

	@RequestMapping(value = "/board/removeBoard.do", method = {RequestMethod.GET, RequestMethod.POST} )
	public ModelAndView removeBoard(@RequestParam("qaNo") int qaNo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		boardService.removeBoard(qaNo);
		ModelAndView mav = new ModelAndView("redirect:/board/listBoards.do");
		
		return mav;
	}

	@RequestMapping(value = "/board/addBoard.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity addBoard(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		
		Map boardMap = new HashMap();
		Enumeration enu = multipartRequest.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = (String)enu.nextElement();
			String value = multipartRequest.getParameter(name);
			boardMap.put(name, value);
		}
		HttpSession session = multipartRequest.getSession();
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		
		String userID = memberVO.getUserID();				
		boardMap.put("userID", userID);	
		
		 HttpHeaders responseHeaders = new HttpHeaders();
		   responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		   String message;
		   ResponseEntity responseEntity = null;
		    
		    try {
		    	
		     int boardNum = boardService.addBoard(boardMap);
		     
		     
		     
				  message = "<script>";
				  message += " alert('새글을 등록했습니다.');";			  
				  message += " location.href='"+multipartRequest.getContextPath()+"/board/viewBoard.do?qaNo="
					  		+ boardMap.get("qaNo") +   "';";			  
				  message += " </script>";
				  
				  responseEntity = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);	     
		     
		    	
		    } catch (Exception e) {
				  message = "<script>";
				  message += " alert('오류가 발생했습니다. 다시 시도해주세요.');";			  
				  message += " location.href='"+multipartRequest.getContextPath()+"/board/boardForm.do';";
				  message += " </script>";			  
				  
				  responseEntity = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
				  
				  e.printStackTrace();
			}
			
			return responseEntity;
		}
	

	@RequestMapping(value = "/board/viewBoard.do", method = {RequestMethod.GET, RequestMethod.POST} )
	public ModelAndView viewBoard(@RequestParam("qaNo") int qaNo, HttpServletRequest request, HttpServletResponse response) throws Exception {
request.setCharacterEncoding("utf-8");
		
		String viewName = (String)request.getAttribute("viewName");
		System.out.println("===============qaNo: " + qaNo);
		Map boardMap = boardService.viewBoard(qaNo);
				
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName(viewName);
		mav.addObject("boardMap", boardMap);
		
		return mav;
	}
	
		
	@RequestMapping(value = "/board/modBoard.do", method = {RequestMethod.GET,RequestMethod.POST} ) 
	  @ResponseBody
	  public ResponseEntity modBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		  request.setCharacterEncoding("utf-8");
	  	
		  Map<String, Object> boardMap = new HashMap<>();
		  
		  Enumeration enu = request.getParameterNames();
		  while (enu.hasMoreElements()) {						// 여기로 진입을 안함 ==> 당연히 put도 실행이 안됨.
			  String name = (String) enu.nextElement();
			  String value = request.getParameter(name);
			  boardMap.put(name, value);						// 여기에서 articleMap에 put(저장)함.
		  }
	    
		  HttpHeaders responseHeaders = new HttpHeaders();
		  responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		  String message;
		  ResponseEntity responseEntity = null;
		  String qaNo = (String)boardMap.get("qaNo");
		 
		  try {
			  boardService.modBoard(boardMap);			//디비 수정

			  message = "<script>";
			  message += " alert('글을 수정했습니다.');";			  
			  message += " location.href='"+request.getContextPath()+"/board/viewBoard.do?qaNo="
				  		+ qaNo +   "';";			  
			  message += " </script>";

			  responseEntity = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);

		  } catch (Exception e) {

			  message = "<script>";
			  message += " alert('오류가 발생했습니다. 다시 수정해주세요.');";			  
			  message += " location.href='"+request.getContextPath()+"/board/viewBoard.do?qaNo="
					  + qaNo +   "';";

			  message += " </script>";			  

			  responseEntity = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		  }  
		  return responseEntity;
	  }
	  
	 
	

	@Override
	public ModelAndView removeBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView viewBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
