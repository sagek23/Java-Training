package com.bit.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.BookDao;
@Controller
public class BookController {
	@Autowired
	BookDao dao = new BookDao();
	@RequestMapping("/listBook.do")
	public ModelAndView listAll(@RequestParam(value = "sort", defaultValue = "")String sort, 
			HttpSession session, @RequestParam(value = "search", defaultValue = "")String search,
			@RequestParam(value = "keyword", defaultValue = "")String keyword,
			@RequestParam(value = "oper", defaultValue = "")String oper)
	{
		HashMap map = new HashMap();
		/*
		if(search.equals(""))
		{
			search = "bookname";
			session.setAttribute("search", search);
		
		}
		if(oper.equals(""))
		{
			oper = "=";
			session.setAttribute("oper", oper);
		}*/
		String sessionkey = null;
		if(session.getAttribute("keyword")!=null)
		{
			sessionkey = (String)session.getAttribute("keyword");
		}
		if(sessionkey!=null && !sessionkey.equals(""))
		{
			map.put("search", session.getAttribute("search"));
			map.put("keyword", session.getAttribute("keyword"));
			map.put("oper", session.getAttribute("oper"));
		}
		
		
		if(keyword!=null && !keyword.equals(""))
		{
			map.put("search", search);
			map.put("keyword", keyword);
			map.put("oper", oper);
			
			session.setAttribute("search", search);
			session.setAttribute("keyword", keyword);
			session.setAttribute("oper", oper);
		}
		
		map.put("sort", sort);
		session.setAttribute("sort", sort);
		
		ModelAndView mav= new ModelAndView();
		mav.addObject("list", dao.listAll(map));
		mav.setViewName("listBook");
		return mav;
	}
}
