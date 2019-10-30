package com.bit.ajaxTest2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.ajaxTest2.dao.GoodsDao;
import com.bit.ajaxTest2.vo.GoodsVo;
import com.bit.ajaxTest2.vo.MemberVo;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class BitController {
	@Autowired
	private GoodsDao  dao= new GoodsDao();
	
	
	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}
	
	@ResponseBody
	@RequestMapping("/listGoods.do")
	public String listGoods()
	{
		List<GoodsVo> list = dao.listAll();
		String str = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			str = mapper.writeValueAsString(list);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return str;
	}
	
	/*
	@ResponseBody
	@RequestMapping("/listGoods.do")
	public String listGoods()
	{
		String str = "";
		str += "[";
		//str += "{no:1, name:'ball1',price:53000, qty:100, fname:'ball1.jpg'},";
		//str += "{no:2, name:'ball2',price:89000, qty:100, fname:'ball2.jpg'},";
		//str += "{no:3, name:'ball3',price:180000, qty:100, fname:'ball3.jpg'},";
		//str += "{no:4, name:'ball4',price:68000, qty:100, fname:'ball4.jpg'},";
		//str += "{no:5, name:'ball5',price:49000, qty:100, fname:'ball5.jpg'}";
		//str += "]";
		
		List<GoodsVo> list = dao.listAll();
		for(GoodsVo g:list)
		{
			str += "{no:"+g.getNo()+", name:'"+g.getName()+"',price:"+g.getPrice()+", qty:"+g.getQty()+", fname:'"+g.getFname()+"'},";
		}
		str = str.substring(0, str.length()-1);//마지막줄 comma를 삭제하기 위해 사용.
		str += "]";
		return str;
	}
	*/
	@ResponseBody
	@RequestMapping("/member.do")
	public String member()
	{
		String str= "{name:'tiger', age:20}";
		return str;
	}
	
	@ResponseBody
	@RequestMapping("/bit.do")
	public String bit()
	{
		try {
				Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return "hello bit";
	}
}
