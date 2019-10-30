package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.orders.GoodsDao;
import com.bit.orders.GoodsVo;
import com.oreilly.servlet.MultipartRequest;

public class insertGoodsOkAction implements BitAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String path = request.getRealPath("upload");
		
		System.out.println(path);
		
		MultipartRequest multi = new MultipartRequest(request, path, "UTF-8");
		GoodsDao dao = new GoodsDao();
		GoodsVo v = new GoodsVo();
		v.setName(request.getParameter("name"));
		v.setPrice(Integer.parseInt(multi.getParameter("price")));
		v.setQty(Integer.parseInt(multi.getParameter("qty")));
		v.setFname(multi.getOriginalFileName("fname"));
		int re = dao.insertGoods(v);
		request.setAttribute("re", re);
		return "listGoods.jsp";
	}

}
