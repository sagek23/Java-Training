package com.bit.action;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.BbsDao;
import com.bit.vo.BbsVo;
import com.oreilly.servlet.MultipartRequest;

public class InsertBbsOkAction implements BitAction {
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//InetAddress local = InetAddress.getLocalHost();
		BbsDao dao = new BbsDao();
		//String ip = local.getHostAddress();
		String ip = request.getRemoteAddr();
		
		BbsVo v = new BbsVo();
		int b_no = dao.getNextNo();
		int b_ref=b_no;
		int b_level=0;
		int b_step=0;
		String path = request.getRealPath("/upload");
		System.out.println(path);
		MultipartRequest multi = new MultipartRequest(request, path, "UTF-8");
		//System.out.println("multi:"+ multi);
		
		int num = Integer.parseInt(multi.getParameter("num"));
		if(num!=0)
		{
			BbsVo p = dao.listBbsDetail(num);
			b_ref = p.getB_ref();
			b_level = p.getB_level();
			b_step = p.getB_step();
			
			dao.updateStep(b_ref,b_step);
			b_level++;
			b_step++; //새로운 답글 step의 증가
		}
		v.setNum(b_no);
		v.setTitle(multi.getParameter("title"));
		v.setWriter(multi.getParameter("writer"));
		v.setPwd(multi.getParameter("pwd"));
		v.setContent(multi.getParameter("content"));
		v.setIp(ip);
		v.setFname(multi.getOriginalFileName("fname"));
		v.setB_ref(b_ref);
		v.setB_level(b_level);
		v.setB_step(b_step);
		int re = dao.insertBbs(v);
		System.out.println(re);
		request.setAttribute("re", re);
		return "insertBbsOk.jsp";
	}

}
