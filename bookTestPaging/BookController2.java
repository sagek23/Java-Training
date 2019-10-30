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
public class BookController2 {
	
	int pageSIZE = 10;
	//한 화면에 보여줄 레코드의 수 the number of records which appear in one page.
	int totalRecord = 0;
	//전체 레코드의 수 the number of total records
	
	int totalPage = 1;
	//전체페이지의 수 the number of total pages.
	@Autowired
	BookDao dao = new BookDao();
	@RequestMapping("/listBook.do")
	public ModelAndView listAll(@RequestParam(value = "sort", defaultValue = "")String sort, 
			HttpSession session, @RequestParam(value = "search", defaultValue = "")String search,
			@RequestParam(value = "keyword", defaultValue = "")String keyword,
			@RequestParam(value = "oper", defaultValue = "")String oper,
			@RequestParam(value = "pageNum", defaultValue = "1")int pageNum)
	{
		
		//totalRecord = dao.count();
		
		 totalPage = totalRecord/pageSIZE;
		 if(totalRecord % pageSIZE !=0)
		  	totalPage++;
	
		int start =0;
		int last = 0;
		//페이지번호에 따른 시작레코드와 마지막 레코드 first and last record according to pageNum;
		start = ((pageNum-1)*pageSIZE)+1;
		last = start+pageSIZE-1;
		
		System.out.println("시작"+start);
		System.out.println("끝"+last);
		
		System.out.println("전체레코드: "+totalRecord);
		System.out.println("전체페이지: "+totalPage);
		System.out.println(pageNum);
		HashMap map = new HashMap();
		
		
		map.put("start", start);
		map.put("last", last);
		session.setAttribute("last", last);
		session.setAttribute("start", start);
		
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
		mav.addObject("totalPage", totalPage);
		mav.addObject("start", start);
		mav.addObject("last", last);
		/*
		String pageStr = "";
		
		 for(int i=1;i<=totalPage;i++)
		 {
			 pageStr = pageStr+"<a href='listBook.do?pageNum="+i+"'>"+i+"</a>"+"&nbsp;&nbsp";
		 }
		mav.addObject("pageStr", pageStr);
		*/
		mav.setViewName("listBook");
		return mav;
	}
}
