package com.bit.controller;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.GoodsDao;
import com.bit.vo.GoodsVo;

@Controller
public class GoodsController {
	
	@Autowired
	GoodsDao dao = new GoodsDao();
	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/lgoods.do")
	public ModelAndView list()
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.listAll());
		mav.setViewName("listGoods");
		return mav;
	}
	@RequestMapping("/dgoods.do")
	public ModelAndView detail(int no)
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("g", dao.detail(no));
		mav.setViewName("detailGoods");
		return mav;
	}
	@RequestMapping(value = "insertGoods.do", method = RequestMethod.GET)
	public void insertForm()
	{
	}
	@RequestMapping(value = "insertGoods.do", method = RequestMethod.POST)
	public ModelAndView insert(GoodsVo g, HttpServletRequest request)//입력한 값이 vo에 실려서 온다.
	{
		String path = request.getRealPath("img");
	
		MultipartFile file = g.getUpload();
		String fname = file.getOriginalFilename();//파일이름
		g.setFname(fname);
		try {
			byte data[]=file.getBytes();//파일의 내용
			FileOutputStream fos = new FileOutputStream(path+"/"+fname);//업로드한 파일 내보내기
			fos.write(data); 
			fos.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
		ModelAndView mav = new ModelAndView("redirect:/lgoods.do");
		int re = dao.insert(g);
		if(re!=1)
		{
			mav.addObject("msg", "상품등록실패");
			mav.setViewName("error");
		}
		return mav;
	}
	@RequestMapping(value = "updateGoods.do", method = RequestMethod.GET)
	public ModelAndView updateForm(int no)
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("g", dao.detail(no));
		return mav;
	}
	@RequestMapping(value = "updateGoods.do", method = RequestMethod.POST)
	public ModelAndView update(GoodsVo g, HttpServletRequest request, HttpSession session)
	{
		String path = request.getRealPath("img");
		
		String oldFname= g.getFname();
		String fname = null;		
		MultipartFile upload = g.getUpload();
		
		g.setFname(fname);
		
		if(upload!=null)
		{
			try {
				byte data[] = upload.getBytes();
				fname = upload.getOriginalFilename();
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);
				fos.write(data);
				fos.close();
				g.setFname(fname);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		int re = -1;
		ModelAndView mav = new ModelAndView("redirect:/lgoods.do");
		re = dao.update(g);
		if(re!=1)
		{
			mav.addObject("msg", "수정실패");
			mav.setViewName("error");
		}
		else
		{
			if(fname!=null&&!fname.equals(""))
			{
				File file = new File(path+"/"+oldFname);
				file.delete();
			}
		}
		return mav;
	
	}
	@RequestMapping(value = "deleteGoods.do", method = RequestMethod.GET)
	public ModelAndView deleteForm(int no)
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("no", no);
		return mav;
	}
	@RequestMapping(value = "deleteGoods.do", method = RequestMethod.POST)
	public ModelAndView delete(int no, String pwd, HttpSession session, HttpServletRequest request)
	{
		ModelAndView mav = new ModelAndView("redirect:/lgoods.do");
		int re = -1;
		String msg = "";
		String fname = dao.detail(no).getFname();
		String path = request.getRealPath("img");
		
		if(pwd.equals("1234"))
		{
			re = dao.delete(no);
		}
		if(re!=1)
		{
			msg = "삭제실패";
		}
		else
		{
			File file1 = new File(path+"/"+fname);
			file1.delete();
		}
		
		session.setAttribute("msg", msg);
		return mav;
	}
}
