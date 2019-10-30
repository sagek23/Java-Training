package com.bit.sm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NameTest
 */
@WebServlet("/name.do")
public class NameTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NameTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = "홍길동";
		//어떤 일을 처리한 결과가 name이라고 하자.
		//이 결과값을 가지고 다른 서블릿으로 이동해야한다고 가정하자.
		request.setAttribute("name", name);
		
		//request에 값을 세팅한 상태유지를 한 상태에서 다른 곳으로 이동하려면
		//RequestDispatcher를 이용한다. 
		
		//RequestDispatcher dis = request.getRequestDispatcher("info.do");
		//dis.forward(request, response); //request에 필요한 값을 담고 다른곳으로 이동.
		
		RequestDispatcher dis = request.getRequestDispatcher("info.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
