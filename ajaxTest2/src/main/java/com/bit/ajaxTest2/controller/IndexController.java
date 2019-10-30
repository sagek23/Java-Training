package com.bit.ajaxTest2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class IndexController {
	@RequestMapping("/index.do")
	public ModelAndView index()
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", "비트캠프");
		return mav;
	}
}
