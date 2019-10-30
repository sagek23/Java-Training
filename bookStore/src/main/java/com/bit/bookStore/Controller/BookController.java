package com.bit.bookStore.Controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bit.bookStore.dao.BookDao;
import com.bit.bookStore.dao.GoodsDao;
import com.bit.bookStore.vo.BookVo;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class BookController {
	@Autowired
	BookDao dao = new BookDao();
	@Autowired
	GoodsDao gdao = new GoodsDao();

	public void setDao(BookDao dao) {
		this.dao = dao;
	}
	
	
	public void setGdao(GoodsDao gdao) {
		this.gdao = gdao;
	}


	@ResponseBody
	@RequestMapping("/GetTotalBook")
	public String  GetTotalBookCount()
	{
		String str = "";
		str = dao.count()+"";
		return str;
	}
	
	@ResponseBody
	@RequestMapping("/editBooks")
	public String editBook(String oper, BookVo b)
	{
		//System.out.println("aaa");
		String r = "";
		switch (oper) 
		{
			case "add": r=dao.insert(b)+"";break;
			case "edit":r=dao.update(b)+"";break;
			case "del":r=dao.delete(b)+"";break;
		}
		return r;
	}
	
	@ResponseBody
	@RequestMapping("/getBooks")
	public ModelAndView getBooks(int page, int rows) 
	//page, rows = 크롬 검사 network에서 header체크, 어떤 이름으로 오는지 확인하여 똑같은 이름으로 사용
	{
		//System.out.println("page:"+page);
		//System.out.println("rows:"+rows);
		ModelAndView mav = new ModelAndView();
		int totalRecord = dao.count();
		int totalPage = (int)Math.ceil(totalRecord/(double)rows);
		int start = (page-1)*rows+1;
		int end = start + rows -1;
		
		mav.addObject("list", dao.listAll(start, end));
		mav.addObject("page", page);
		//mav.addObject("rows", rows);
		mav.addObject("totalRecord",rows);
		mav.addObject("totalPage", totalPage);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping("/listBook")
	public String listBook()
	{
		String str= "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			str = mapper.writeValueAsString(dao.listAll(1,100));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return str;
	}
	@ResponseBody
	@RequestMapping("/searchBook")
	public ModelAndView searchBook(int bookid, String bookname, String Bookid)
	{
		ModelAndView mav = new ModelAndView();
		
		return mav;
	}
	
	@RequestMapping("/index.do")
	public void index()
	{
		
	}
	
	@RequestMapping("/ex01")
	public void ex01()
	{	
	}
	@RequestMapping("/ex02")
	public void ex02()
	{	
	}
	@RequestMapping("/ex03")
	public void ex03()
	{	
	}
	@RequestMapping("/ex04")
	public void ex04()
	{	
	}
	@ResponseBody
	@RequestMapping("/GetProductList")
	public String goodsList()
	{	
		String str = "";
		try {
			ObjectMapper mapper = new ObjectMapper();
			str = mapper.writeValueAsString(gdao.listAll());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return str;
	}
	@ResponseBody
	@RequestMapping("/goodsDetail")
	public String goodsDetail(int no)
	{	
		String str = "";
		try {
			ObjectMapper mapper = new ObjectMapper();
			str = mapper.writeValueAsString(gdao.detailGoods(no));
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

}
