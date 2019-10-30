package com.bit.goodsTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bit.goodsTest.dao.GoodsDao;

@Controller
public class GoodsController {
	private GoodsDao dao = new GoodsDao();

	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}
	@RequestMapping("/listGoods.do")
	public ModelAndView listAll()
	{
		System.out.println("컨트롤러 동작함");
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.listAll());
		return mav;
	}
}
