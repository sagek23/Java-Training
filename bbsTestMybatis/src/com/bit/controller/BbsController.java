package com.bit.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.BbsDao;
import com.bit.vo.BbsVo;

@Controller
public class BbsController {

	@Autowired
	private BbsDao dao;
	
	
	public void setDao(BbsDao dao) {
		this.dao = dao;
	}


	@RequestMapping("/listBbs.do")
	public ModelAndView list(@RequestParam(value = "keyfield", defaultValue = "" )String keyfield, @RequestParam(value = "keyword",defaultValue = "" ) String keyword)
	{
		ModelAndView mav = new ModelAndView();
		HashMap map = new HashMap();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		
		mav.addObject("list", dao.listAll(map));
		return mav;
	}

	
	@RequestMapping("/detailBbs.do")
	public ModelAndView detail(int num)
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("b", dao.detail(num));
		mav.setViewName("detailBbs");
		return mav;
	}
	@RequestMapping(value = "/insertBbs.do", method = RequestMethod.GET)
	public ModelAndView insertForm(@RequestParam(value = "num", defaultValue = "0")int num)
	//답글이면 원글의 글번호가, 새글이면 0이 실려서 간다.
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("num", num); 
		return mav;
	}
	@RequestMapping(value = "/insertBbs.do", method = RequestMethod.POST)
	public ModelAndView insert(BbsVo b, HttpServletRequest request, HttpSession session)
	{
		String path = request.getRealPath("files");
		b.setIp(request.getRemoteAddr());
		
		int num = dao.getNextNum();
		int bref=num;
		int blevel = 0;
		int bstep = 0;
		
		int pnum = b.getNum();
		if(pnum!=0)
		{
			BbsVo p = dao.detail(pnum);// 원글정보 가져오기
			bref = p.getBref();
			blevel = p.getBlevel();
			bstep = p.getBstep();
			dao.updateStep(bref, bstep);
			bstep++; //나는 부모들의 b_step+1로설정
			blevel++; //답글	: 부모글의 b_level+1
			
		}
		
		b.setNum(num);
		b.setBref(bref);
		b.setBlevel(blevel);
		b.setBstep(bstep);
		
		MultipartFile multi = b.getUpload();
		String fname = multi.getOriginalFilename();
		if(fname!=null &&!fname.equals(""))
		{
			try {
				byte data[] = multi.getBytes();
				fname = multi.getOriginalFilename();
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);
				fos.write(data);
				fos.close();
				b.setFname(fname);
			}
		 catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		}
		else
		{
			fname = "";
			b.setFname(fname);
		}
		int re = dao.insert(b);
		ModelAndView mav = new ModelAndView("redirect:/listBbs.do");
		String msg = "";
		if(re!=1)
		{
			msg = "게시물 등록에 실패하였습니다.";
			session.setAttribute("msg", msg);
		}
		return mav;
	}
	@RequestMapping(value = "updateBbs.do", method = RequestMethod.GET)
	public ModelAndView updateForm(int num)
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("b", dao.detail(num)); //수정할 dao의 상태유지
		return mav;
	}
	@RequestMapping(value = "updateBbs.do", method = RequestMethod.POST)
	public ModelAndView update(BbsVo b, HttpSession session, HttpServletRequest request)
	{
		String path = request.getRealPath("files");
		String fname = "";
		String oldFname = b.getFname();
		MultipartFile upload = b.getUpload();
		fname = upload.getOriginalFilename();
		if(fname!=null&&!fname.equals(""))
		{
			System.out.println("사진도 수정");
			try {
				byte data[] = upload.getBytes();
				fname = upload.getOriginalFilename();
				b.setFname(fname);
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);
				fos.write(data);
				fos.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			
		}
	
		
		ModelAndView mav = new ModelAndView("redirect:/listBbs.do");
		String msg="";
		int re = dao.update(b);
		if(re!=1)
		{
			msg = "게시물수정실패";
		}
		else
		{
			if(fname!=null && !fname.equals(""))
			{
				File file = new File(path+"/"+oldFname);
				file.delete();
			}
		}
		session.setAttribute("msg", msg);
		return mav;
	}
	@RequestMapping(value = "/deleteBbs.do", method = RequestMethod.GET)
	public ModelAndView deleteForm(int num)
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("num", num);
		return mav;
	}
	@RequestMapping(value = "/deleteBbs.do", method = RequestMethod.POST)
	public ModelAndView delete(int num, String pwd, HttpSession session, HttpServletRequest request)
	{
		BbsDao dao = new BbsDao();
		String path = request.getRealPath("files");
		String oldFname = dao.detail(num).getFname();
		String msg="";
		ModelAndView mav = new ModelAndView("redirect:/listBbs.do");
		int re = dao.delete(num, pwd);
		if(re<1)
		{
			msg = "게시물 삭제실패";
		}
		else
		{
			File file = new File(path+"/"+oldFname);
			file.delete();
		}
		session.setAttribute("msg", msg);
		return mav;
	}
}










