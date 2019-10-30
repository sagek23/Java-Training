package com.bit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.BookDao;
import com.bit.vo.BookVo;

import sun.nio.cs.ext.MacArabic;
@Controller
public class BookController {
	@Autowired
	BookDao dao = new BookDao();
	
	
	public void setDao(BookDao dao) {
		this.dao = dao;
	}
	@RequestMapping("/lbook.do")
	public ModelAndView list()
	{
		ModelAndView mav= new ModelAndView();
		mav.addObject("list", dao.listAll());
		mav.setViewName("listBook");
		return mav;
	}
	@RequestMapping("/dbook.do")
	public ModelAndView detail(int bookid)
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("b", dao.detailBook(bookid));
		mav.setViewName("detailBook");
		return mav;
	}
	@RequestMapping(value = "ibook.do", method = RequestMethod.GET)
	public void insertForm()
	{
	}
	@RequestMapping(value = "ibook.do", method = RequestMethod.POST)
	public ModelAndView insert(BookVo b)
	{
		ModelAndView mav = new ModelAndView("redirect:/lbook.do");
		int re = dao.insertBook(b);
		if(re!=1)
		{
			mav.addObject("msg", "도서등록실패");
			mav.setViewName("error");
		}
		return mav;
	}
	@RequestMapping(value = "ubook.do", method = RequestMethod.GET)
	public ModelAndView updateForm(int bookid)
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("b", dao.detailBook(bookid));//수정한 도서 상태유지
		return mav;
	}
	@RequestMapping(value = "ubook.do", method = RequestMethod.POST)
	public ModelAndView update(BookVo b)
	{
		ModelAndView mav = new ModelAndView("redirect:/lbook.do");
		int re = dao.updateBook(b);
		if(re!=1)
		{
			mav.addObject("msg", "도서정보 수정실패");
			mav.setViewName("error");
		}
		return mav;
	}
	
	@RequestMapping(value = "delBook.do", method = RequestMethod.GET)
	public ModelAndView deleteForm(int bookid)
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("bookid", bookid);
		return mav;
	}
	
	@RequestMapping(value = "delBook.do", method = RequestMethod.POST)
	public ModelAndView delete(int bookid, String pwd, HttpSession session)
	{
		int re = -1;
		String msg = "";
		ModelAndView mav = new ModelAndView("redirect:/lbook.do");
		if(pwd.equals("bitcamp"))
		{
			re = dao.deleteBook(bookid);
		}
		
		if(re!=1)
		{
			//mav.addObject("msg", "도서삭제실패");
			msg = "도서삭제실패";
			//mav.setViewName("error");
		}
		session.setAttribute("msg", msg);
		return mav;
	}
}
