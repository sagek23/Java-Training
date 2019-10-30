package com.bit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/hello.do") //hello.do라고 요청하면 동작
	public ModelAndView hello()
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "hi");
		mav.addObject("year", 2019);
		mav.setViewName("hello"); //hello라는 이름의 jsp뷰에 위의 내용 표현. 위치, 확장자는 xml에 표기
		return mav;
	}
}
