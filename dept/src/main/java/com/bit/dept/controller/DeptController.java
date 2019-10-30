package com.bit.dept.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dept.dao.DeptDao;
@Controller
public class DeptController {
	@Autowired
	DeptDao dao = new DeptDao();
	
	public void setDao(DeptDao dao) {
		this.dao = dao;
	}
	@RequestMapping(value = "/listEmp.do", method = RequestMethod.GET)
	public void listForm()
	{	
		System.out.println("컨트롤러 동작함");
	}
	
	@RequestMapping(value = "/listEmp.do", method = RequestMethod.POST)
	public ModelAndView listAll(String name)
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.listAll(name));
		mav.setViewName("listEmp");
		return mav;
	}
}
