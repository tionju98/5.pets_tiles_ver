package kr.or.pets.protect_pets.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.pets.board.controller.BoardControllerImpl;
import kr.or.pets.protect_pets.service.ProPetsService;
import kr.or.pets.protect_pets.vo.ProPetsVO;
import net.sf.json.JSONObject;

@Controller("proPetsController")
@EnableAspectJAutoProxy	
public class ProPetsControllerImpl implements ProPetsController {

	private static final Logger logger = LoggerFactory.getLogger(BoardControllerImpl.class);
	@Autowired
	private ProPetsService proPetsService;
	@Autowired
	private ProPetsVO proPetsVO;
	
	@Override
	@RequestMapping(value = "/protect/listBoards.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView listBoards(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String section_ = request.getParameter("section");
		String pageNum_ = request.getParameter("pageNum");
		
		int section = Integer.parseInt(((section_== null)? "1" : section_));
		int pageNum = Integer.parseInt(((pageNum_ == null)? "1" : pageNum_));
		
		Map<String, Integer> pagingMap = new HashMap();			/*section값과 pageNum값을 HashMap에 저장*/
		pagingMap.put("section", section);
		pagingMap.put("pageNum", pageNum);
		
		Map boardMap = proPetsService.listBoards(pagingMap);
		boardMap.put("section", section);
		boardMap.put("pageNum", pageNum);
		
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("boardMap", boardMap);
		
		return mav;
	}

	@RequestMapping(value = "/protect/addBoard.do", method = RequestMethod.GET)
	public ModelAndView addBoard(@ModelAttribute("protect") ProPetsVO proPetsVO,HttpServletRequest request, HttpServletResponse response) throws Exception {
	request.setCharacterEncoding("UTF-8");
		
		
		int result = proPetsService.addBoard(proPetsVO);
		
		ModelAndView mav = new ModelAndView("redirect:/protect/listBoards.do");
		
		return mav;
	}

	@RequestMapping(value = "/protect/removeBoard.do", method = RequestMethod.GET)
	public ModelAndView removeBoard(@RequestParam("pro_noticeNum") String pro_noticeNum, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		proPetsService.removeBoard(pro_noticeNum);
		ModelAndView mav = new ModelAndView("redirect:/protect/listBoards.do");
		
		return mav;
	}

	@Override
	@RequestMapping(value = "/protect/keywordSearch.do", method = RequestMethod.GET, produces = "application/text; charset=utf-8")
	public String keywordSearch(@RequestParam("keyword") String keyword, HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		if(keyword == null || keyword.equals(""))
			return null;
		
		keyword = keyword.toUpperCase();
		
		List<String> keywordList = proPetsService.keywordSearch(keyword);
		
		//최종 완성될  JSONObject 선언
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("keyword", keywordList);
		
		String jsonInfo = jsonObject.toString();
		
		return jsonInfo;
	}

	@Override
	@RequestMapping(value = "/protect/searchBoards.do", method = RequestMethod.GET)
	public ModelAndView searchBoards(@RequestParam("searchWord") String searchWord, HttpServletRequest request, HttpServletResponse response)throws Exception {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String viewName = (String)request.getAttribute("viewName");
		List<ProPetsVO> boardsList = proPetsService.searchBoards(searchWord);
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("boardsList", boardsList);
		
		return mav;
	}
	
	@RequestMapping(value = "/protect/*Form.do", method = RequestMethod.GET)
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}

	@Override
	public ModelAndView addBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView removeBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
