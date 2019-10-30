package com.bit.goods.controller;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bit.goods.dao.GoodsDao;
import com.bit.goods.vo.GoodsVo;
@Controller
public class GoodsController {
	private GoodsDao dao = new GoodsDao();
	
	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}
	@RequestMapping("/listGoods.do")
	public ModelAndView listAll()
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.listAll());
		return mav;
	}
	@RequestMapping("/detail.do")
	public ModelAndView detail(int no)
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("g",dao.detail(no));
		mav.setViewName("detail");
		return mav;
	}
	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public void insertForm()
	//답글이면 원글의 글번호가, 새글이면 0이 실려서 간다.
	{
	}
	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public ModelAndView insert(GoodsVo g, HttpServletRequest request, HttpSession session)
	{
		String path = request.getRealPath("img");
		MultipartFile multi = g.getUpload();
		String fname = multi.getOriginalFilename();
		if(fname!=null&& !fname.equals(""))
		{
			try {
				byte data[] = multi.getBytes();
				fname = multi.getOriginalFilename();
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);
				fos.write(data);
				fos.close();
				g.setFname(fname);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
		else
		{
			fname = "";
			g.setFname(fname);
		}
		int re = dao.insert(g);
		String msg = "";
		if(re!=1 )
		{
			msg = "상품등록실패";
			session.setAttribute("msg", msg);
		}
		ModelAndView mav = new ModelAndView("redirect:/listGoods.do");
		return mav;
	}
}
