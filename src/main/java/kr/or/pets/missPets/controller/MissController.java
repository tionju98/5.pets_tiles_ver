package kr.or.pets.missPets.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

public interface MissController {

	public ModelAndView m_listBoards(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity m_addBoard(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception;
	public ModelAndView m_viewBoard(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView m_removeBoard(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public @ResponseBody String m_keywordSearch(@RequestParam("keyword") String keyword, 
			HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView m_searchBoards(@RequestParam("searchWord") String searchWord, 
				HttpServletRequest request, HttpServletResponse response) throws Exception;
}
