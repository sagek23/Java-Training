package com.bit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.DeptDao;
import com.bit.vo.DeptVo;
@Controller
public class DeptController {
	
	DeptDao dao = new DeptDao();
	
	public void setDao(DeptDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value = "/idept.do", method = RequestMethod.GET)//요청이름을 같게하려면 수행양식 입력
	public void insertForm() //상태유지할 값이 없으므로 void
	{
	}
	@RequestMapping(value = "/idept.do", method = RequestMethod.POST)
	public ModelAndView insertSubmit(DeptVo d)
	{
		ModelAndView mav = new ModelAndView();
		int re = dao.insert(d);
		if(re>0)
		{
			mav.setViewName("redirect:/ldept.do");
		}
		else
		{
			mav.addObject("msg", "부서등록실패");
			mav.setViewName("error.jsp");
		}
		return mav;
	}
	@RequestMapping("/ldept.do")
	public ModelAndView dept()
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.listAll());
		mav.setViewName("dept");
		return mav;
	}
}
