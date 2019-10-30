package com.bit.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.chat.dao.ChatDao;
import com.bit.chat.vo.ChatVo;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class ChatController {
	@Autowired
	private ChatDao dao;

	public void setDao(ChatDao dao) {
		this.dao = dao;
	}
	@ResponseBody
	@RequestMapping(value = "/AddMessage", method = RequestMethod.POST)
	public String chatInsert(ChatVo c)
	{
		//System.out.println("insert컨트롤러 동작");
		String str = "";
		int re = dao.insertChat(c);
		return str+re;
	}
	@ResponseBody
	@RequestMapping("/GetList")
	public String chatList()
	{
		//System.out.println("list컨트롤러 동작");
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
}
