package com.bit.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.chat.dao.JumunDao;
import com.bit.chat.vo.Jumun;
import com.bit.chat.vo.JumunVo;

@Controller
public class JumunCotroller {
	@Autowired
	JumunDao dao = new JumunDao();

	public void setDao(JumunDao dao) {
		this.dao = dao;
	}
	
	@ResponseBody
	@RequestMapping(value = "/insertOrder", method = RequestMethod.POST)
	public String insertOrder(Jumun jumun)
	{	
		//System.out.println("order");
		//System.out.println(jumun.getCustid());
		//System.out.println(jumun.getJumunList().size());
		String str = "0";
		str = dao.insertOrder(jumun)+"";
		return str;	
	}
}
