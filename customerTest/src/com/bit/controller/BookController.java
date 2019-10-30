package com.bit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.BookDao;
import com.bit.vo.BookVo;

@Controller
public class BookController {
	@Autowired
	BookDao dao = new BookDao();
	
	
	public void setDao(BookDao dao) {
		this.dao = dao;
	}
	@RequestMapping("/lbook.do")
	public ModelAndView book()
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.listAll());
		mav.setViewName("listBook");
		return mav;
	}
	@RequestMapping("/bdetail.do")
	public ModelAndView detail(int bookid)
	{
		ModelAndView mav = new ModelAndView();
		BookVo v = dao.detailBook(bookid);
		mav.addObject("v",	v);
		mav.setViewName("detailBook");
		return mav;
	}
}
