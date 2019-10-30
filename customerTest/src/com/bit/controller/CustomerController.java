package com.bit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.CustomerDao;

@Controller
public class CustomerController {
	@Autowired
	CustomerDao dao = new CustomerDao();

	public void setDao(CustomerDao dao) {
		this.dao = dao;
	}
	@RequestMapping("/lcust.do")
	public ModelAndView cust()
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.listAll());
		mav.setViewName("listCustomer");
		return mav;
	}
	
}
