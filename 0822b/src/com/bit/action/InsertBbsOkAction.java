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

		//String ip = local.getHostAddress();
		String ip = request.getRemoteAddr();
		BbsDao dao = new BbsDao();
		BbsVo v = new BbsVo();
		
		int bnum = dao.getNextNo();
		int bref = bnum;
		int blevel = 0;
		int bstep = 0;
		String path = request.getRealPath("/upload");
		System.out.println(path);

		MultipartRequest multi = new MultipartRequest(request, path, "UTF-8");
		
		int num = Integer.parseInt(multi.getParameter("num"));
		System.out.println(num);
		if(num!=0)
		{
			BbsVo b = dao.listBbsDetail(num);
			bref = b.getBref();
			blevel = b.getBlevel();
			bstep = b.getBstep();
			
			dao.updateBstep(bref, bstep);
			blevel++;
			bstep++;
			
		}
		
		//System.out.println("multi:"+ multi);
		v.setNum(bnum);
		v.setTitle(multi.getParameter("title"));
		v.setWriter(multi.getParameter("writer"));
		v.setPwd(multi.getParameter("pwd"));
		v.setContent(multi.getParameter("content"));
		v.setIp(ip);
		v.setFname(multi.getOriginalFileName("fname"));
		v.setBref(bref);
		v.setBlevel(blevel);
		v.setBstep(bstep);
		
		int re = dao.insertBbs(v);
		System.out.println(re);
		request.setAttribute("re", re);
		return "insertBbsOk.jsp";
	}

}
