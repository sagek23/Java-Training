package com.bit.controller;

import javax.jws.WebParam.Mode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.DeptDao;

@Controller
public class DeptController {
	@Autowired
	private DeptDao dao;
	
	public void setDao(DeptDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/ldept.do")
	public ModelAndView list()
	{
		ModelAndView mav= new ModelAndView();
		mav.addObject("list", dao.listAll());
		mav.setViewName("listDept");
		return mav;
	}
}
