package com.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.BookDao;
import com.bit.vo.BookVo;

//�����󼼺���, ���������ϱ� ����� �߰��� ���ϴ�.

@Controller
@RequestMapping("/ubook.do")
public class UpdateBookController {
	
	@Autowired
	private BookDao dao;
	
	public void setDao(BookDao dao) {
		this.dao = dao;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView form(HttpSession session)
	{		
		BookVo book = (BookVo)session.getAttribute("v");		
		ModelAndView mav = new ModelAndView();
		mav.addObject("v", book);
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(BookVo b)
	{		
		ModelAndView mav = new ModelAndView("redirect:/lbook.do");
		int re = dao.updateBook(b);
		if(re != 1)
		{
			mav.addObject("msg", "도서정보 수정실패.");
			mav.setViewName("error");
		}
		return mav;
	}
}





