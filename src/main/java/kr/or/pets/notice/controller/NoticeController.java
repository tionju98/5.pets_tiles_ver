package kr.or.pets.notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import kr.or.pets.notice.vo.NoticeVO;
import oracle.net.aso.h;

public interface NoticeController {

	 //01. 공지사항 전체 목록
	 public ModelAndView listNotices(HttpServletRequest request, HttpServletResponse response) throws Exception;

	 //02-1. 공지사항 등록
	 public ModelAndView insertNotice(HttpServletRequest request, HttpServletResponse response) throws Exception;
	 
	 //02-2. 공지사항 등록 처리
	 public ResponseEntity addNotice(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception;
	 
	 //03. 공지사항 상세보기
	 public ModelAndView viewNotice(@RequestParam("no_number") int no_number, HttpServletRequest request, HttpServletResponse response) throws Exception;
	 
	 //04. 공지사항 삭제
	 public ModelAndView removeNotice(HttpServletRequest request, HttpServletResponse response) throws Exception;
	 
	 //05-1. 공지사항 수정
	 public ModelAndView updateNotice(HttpServletRequest request, HttpServletResponse response) throws Exception;
	 
	 //05-2.공지사항 등록
	 public ModelAndView modNotice( NoticeVO noticeVO,HttpServletRequest request, HttpServletResponse response) throws Exception;
	 
	 
	 
	 
	//public ModelAndView viewNotice(HttpServletRequest request, HttpServletResponse response, HttpSession session)throws Exception;

}
