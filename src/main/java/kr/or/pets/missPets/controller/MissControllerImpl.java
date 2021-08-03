package kr.or.pets.missPets.controller;

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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import kr.or.pets.member.vo.MemberVO;
import kr.or.pets.missPets.service.MissService;
import kr.or.pets.missPets.vo.MissVO;
import net.sf.json.JSONObject;


@Controller("missController")
public class MissControllerImpl extends MultiActionController implements MissController{
	private static final Logger logger = LoggerFactory.getLogger(MissControllerImpl.class);
	@Autowired
	private MissService missService;
	@Autowired
	private MissVO missVO;
	
	/* 글작성 */
	@RequestMapping(value = "/miss/missForm.do", method = {RequestMethod.GET, RequestMethod.POST} )
	public ModelAndView missForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		
		String viewName = (String)request.getAttribute("viewName");
		
		logger.info("viewName : " + viewName);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		
		return mav;
	}	
	
	/* 게시판 리스트 */
	@Override
	@RequestMapping(value = "/miss/m_listBoards.do", method = {RequestMethod.GET, RequestMethod.POST}  )
	public ModelAndView m_listBoards(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
		
		Map missMap = missService.m_listBoards(pagingMap);
		logger.info("missMap :" + missMap);
		missMap.put("section", section);
		missMap.put("pageNum", pageNum);
		
		
		String viewName = (String)request.getAttribute("viewName");
		logger.info("viewName :" + viewName);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("missMap", missMap);
		
		return mav;
	}
	
	
	
	@RequestMapping(value = "/miss/*Form.do", method = {RequestMethod.GET, RequestMethod.POST} )
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	
	/* 글삭제 */
	@RequestMapping(value = "/miss/m_removeBoard.do", method = {RequestMethod.GET, RequestMethod.POST} )
	public ModelAndView m_removeBoard(@RequestParam("missBoardNum") int missBoardNum, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		missService.m_removeBoard(missBoardNum);
		ModelAndView mav = new ModelAndView("redirect:/miss/m_listBoards.do");
		
		return mav;
	}
	
	/* 글추가 */
	@RequestMapping(value = "/miss/m_addBoard.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity m_addBoard(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		
		Map missMap = new HashMap();
		Enumeration enu = multipartRequest.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = (String)enu.nextElement();
			String value = multipartRequest.getParameter(name);
			missMap.put(name, value);
		}
		HttpSession session = multipartRequest.getSession();
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		
		String userID = memberVO.getUserID();	
		String userNAME = memberVO.getUserNAME();
		String userEmail = memberVO.getUserEmail();
		String userAddress = memberVO.getUserAddress();
		String userPhoneNumber = memberVO.getUserPhoneNumber();
		missMap.put("userID", userID);	
		missMap.put("userNAME", userNAME);	
		missMap.put("userEmail", userEmail);	
		missMap.put("userAddress", userAddress);	
		missMap.put("userPhoneNumber", userPhoneNumber);	
		
		 HttpHeaders responseHeaders = new HttpHeaders();
		   responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		   String message;
		   ResponseEntity responseEntity = null;
		    
		    try {
		    	
		     int missBoardNum = missService.m_addBoard(missMap);
		     
		     
		     
				  message = "<script>";
				  message += " alert('새글을 등록했습니다.');";			  
				  message += " location.href='"+multipartRequest.getContextPath()+"/miss/m_viewBoard.do?missBoardNum="
					  		+ missMap.get("missBoardNum") +   "';";			  
				  message += " </script>";
				  
				  responseEntity = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);	     
		     
		    	
		    } catch (Exception e) {
				  message = "<script>";
				  message += " alert('오류가 발생했습니다. 다시 시도해주세요.');";			  
				  message += " location.href='"+multipartRequest.getContextPath()+"/miss/missForm.do';";
				  message += " </script>";			  
				  
				  responseEntity = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
				  
				  e.printStackTrace();
			}
			
			return responseEntity;
		}
	
	/* 글상세보기 */
	@RequestMapping(value = "/miss/m_viewBoard.do", method = {RequestMethod.GET, RequestMethod.POST} )
	public ModelAndView m_viewBoard(@RequestParam("missBoardNum") int missBoardNum, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		String viewName = (String)request.getAttribute("viewName");
		System.out.println("===============missBoardNum: " + missBoardNum);
		Map missMap = missService.m_viewBoard(missBoardNum);
				
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName(viewName);
		mav.addObject("missMap", missMap);
		
		return mav;
	}
	
	/* 글수정 */
	@RequestMapping(value = "/miss/m_modBoard.do", method = {RequestMethod.GET,RequestMethod.POST} ) 
	  @ResponseBody
	  public ResponseEntity m_modBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		  request.setCharacterEncoding("utf-8");
	  	
		  Map<String, Object> missMap = new HashMap<>();
		  
		  Enumeration enu = request.getParameterNames();
		  while (enu.hasMoreElements()) {						// 여기로 진입을 안함 ==> 당연히 put도 실행이 안됨.
			  String name = (String) enu.nextElement();
			  String value = request.getParameter(name);
			  missMap.put(name, value);						// 여기에서 articleMap에 put(저장)함.
		  }
	    
		  HttpHeaders responseHeaders = new HttpHeaders();
		  responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		  String message;
		  ResponseEntity responseEntity = null;
		  String missBoardNum = (String)missMap.get("missBoardNum");
		 
		  try {
			  missService.m_modBoard(missMap);			//디비 수정

			  message = "<script>";
			  message += " alert('글을 수정했습니다.');";			  
			  message += " location.href='"+request.getContextPath()+"/miss/m_viewBoard.do?missBoardNum="
				  		+ missBoardNum +   "';";			  
			  message += " </script>";

			  responseEntity = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);

		  } catch (Exception e) {

			  message = "<script>";
			  message += " alert('오류가 발생했습니다. 다시 수정해주세요.');";			  
			  message += " location.href='"+request.getContextPath()+"/miss/m_viewBoard.do?missBoardNum="
					  + missBoardNum +   "';";

			  message += " </script>";			  

			  responseEntity = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		  }  
		  return responseEntity;
	  }

	/* 글검색 */
	@Override
	@RequestMapping(value = "/miss/m_keywordSearch.do", method = RequestMethod.GET, produces = "application/text; charset=utf-8")
	public String m_keywordSearch(@RequestParam("keyword") String keyword, HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		if(keyword == null || keyword.equals(""))
			return null;
		
		keyword = keyword.toUpperCase();
		
		List<String> keywordList = missService.m_keywordSearch(keyword);
		
		//최종 완성될  JSONObject 선언
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("keyword", keywordList);
		
		String jsonInfo = jsonObject.toString();
		
		return jsonInfo;
	}
	
	/* 글검색 */
	@Override
	@RequestMapping(value = "/miss/m_searchBoards.do", method = RequestMethod.GET)
	public ModelAndView m_searchBoards(@RequestParam("searchWord") String searchWord, HttpServletRequest request, HttpServletResponse response)throws Exception {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String viewName = (String)request.getAttribute("viewName");
		List<MissVO> m_boardsList = missService.m_searchBoards(searchWord);
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("m_boardsList", m_boardsList);
		
		return mav;
	}
	
	@Override
	public ModelAndView m_removeBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView m_viewBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
