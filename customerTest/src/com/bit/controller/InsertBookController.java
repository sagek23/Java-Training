package com.bit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.BookDao;
import com.bit.vo.BookVo;

@Controller
@RequestMapping("/ibook.do")
public class InsertBookController {
	@Autowired
	BookDao dao = new BookDao();
	
	public void setDao(BookDao dao) {
		this.dao = dao;
	}
	@RequestMapping(method = RequestMethod.GET)
	public void form()
	{
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(BookVo b)
	{
		ModelAndView mav = new ModelAndView();
		int re = dao.insertBook(b);
		if(re==1)
		{
			mav.setViewName("redirect:/lbook.do");
		}
		else
		{
			mav.addObject("msg", "도서등록실패");
			mav.setViewName("error");
		}
		return mav;
	}
}
