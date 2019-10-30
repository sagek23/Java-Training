package com.bit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.ManagerDao;

/**
 * Servlet implementation class Manager
 */
@WebServlet("/manager.do")
public class Manager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		ManagerDao dao= new ManagerDao();
		dao.dropManager();
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ManagerDao dao= new ManagerDao();
		dao.createManager();
		dao.insertManager();
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public Manager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		String str = "";
		str +="<form action='manager.do' method='post'>";
		str +="<input type='text' name='id'>";
		str +="<input type='password' name='pwd'>";
		str +="<input type='submit' value='로그인'>";
		str +="</form>";
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(str);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ManagerDao dao = new ManagerDao();
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		if(dao.isManager(id, pwd))
		{
			response.sendRedirect("managerMain.do");
		}
		else
		{
			response.sendRedirect("manager.do");
		}
	}

}
