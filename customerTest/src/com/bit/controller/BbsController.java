package com.bit.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.BbsDao;
import com.bit.vo.BbsVo;

@Controller
public class BbsController {
	
	@Autowired
	private BbsDao dao;
	
	public void setDao(BbsDao dao) {
		this.dao = dao;
	}
	//@RequestParam("") 생략가능
	@RequestMapping("/dbbs.do")
	public ModelAndView detail(int num)
	{
		ModelAndView mav = new ModelAndView();
		BbsVo v = dao.getBbs(num);
		mav.addObject("v", v);
		mav.setViewName("bbsDetail");
		return mav;
	}
	@RequestMapping(value = "/ibbs.do", method = RequestMethod.GET)//요청이름을 같게하려면 수행양식 입력
	public void insertBbs() //상태유지할 값이 없으므로 void
	{
	}
	@RequestMapping(value = "/ibbs.do", method = RequestMethod.POST)
	public ModelAndView insertSubmit(BbsVo v)
	{
		ModelAndView mav = new ModelAndView();
		int re = dao.insert(v);
		return mav;
	}
	@RequestMapping("/lbbs.do")
	public ModelAndView bbs()
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.listAll());
		mav.setViewName("listBbs");
		return mav;
	}
}
