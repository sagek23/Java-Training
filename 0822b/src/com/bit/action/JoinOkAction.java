package com.bit.action;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.MemberDao;
import com.bit.vo.MemberVo;

public class JoinOkAction implements BitAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		MemberDao dao = new MemberDao();
		MemberVo v = new MemberVo();
		v.setId(request.getParameter("id"));
		v.setPwd(request.getParameter("pwd"));
		v.setName(request.getParameter("name"));
		v.setAge(Integer.parseInt(request.getParameter("age")));
		v.setTel(request.getParameter("tel"));
		v.setAddr(request.getParameter("addr"));
		v.setHobby(Arrays.toString(request.getParameterValues("hobby")));
		v.setJob(request.getParameter("job"));
		v.setSex(request.getParameter("sex"));
		int re = dao.insertMem(v);
		request.setAttribute("re", re);
		return "joinOk.jsp";
	}

}
