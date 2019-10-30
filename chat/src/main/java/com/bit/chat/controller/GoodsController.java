package com.bit.chat.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.chat.dao.GoodsDao;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class GoodsController {
	@Autowired
	private GoodsDao dao = new GoodsDao();
	
	
	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}
	
	@ResponseBody
	@RequestMapping("/GetProductList")
	public String listGoods()
	{
		String str = "";
		try {
			ObjectMapper mapper = new ObjectMapper();
			str = mapper.writeValueAsString(dao.listAll());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return str;
	}

	@RequestMapping("/goods.do")
	public void goods()
	{
		
	}

	
	@ResponseBody
	@RequestMapping("/GetTotalProduct")
	public String  GetTotalProductCount()
	{
		String str = "";
		str = dao.count()+"";
		return str;
	}
	@ResponseBody
	@RequestMapping("/GetPagingProductList")
	public String  GetPagingProductList(int nowPage, int perPage)
	{
		String str = "";
		int start = (nowPage-1)*perPage+1;
		int end = start+perPage-1;
		HashMap map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		ObjectMapper mapper = new ObjectMapper();
		try {
			str= mapper.writeValueAsString(dao.selectPage(map));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return str;
	}
}
