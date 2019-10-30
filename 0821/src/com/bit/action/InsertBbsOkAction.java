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
		String path = request.getRealPath("/upload");
		System.out.println(path);
		MultipartRequest multi = new MultipartRequest(request, path, "UTF-8");
		//System.out.println("multi:"+ multi);
		v.setTitle(multi.getParameter("title"));
		v.setWriter(multi.getParameter("writer"));
		v.setPwd(multi.getParameter("pwd"));
		v.setContent(multi.getParameter("content"));
		v.setIp(ip);
		v.setFname(multi.getOriginalFileName("fname"));
		
		int re = dao.insertBbs(v);
		System.out.println(re);
		request.setAttribute("re", re);
		return "insertBbsOk.jsp";
	}

}
