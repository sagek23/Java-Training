package com.bit.book;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.BookDao;
import book.BookVo;

/**
 * Servlet implementation class BookList
 */
@WebServlet("/BookList")
public class BookList extends HttpServlet {
	private static final long serialVersionUID = 1L;
     FileWriter fw;
     /*
      
     */
     
     //서블릿이 종료(파기)될 때 동작한다.
     //서블릿은 서버가 종료될 때 소멸된다.
    @Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		try {
			fw.close(); //서블릿이 종료될 때 기록을 위한 파일을 닫는다.
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
    //서블릿이 맨처음 요청될 때 딱 한번 동작한다.
    //파일기록을 위한 스트림을 생성한다. 
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			fw = new FileWriter("c:/bit/log.txt");
			//기록을 남길 파일의 
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public BookList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String ip = request.getRemoteAddr();
		String uri = request.getRequestURI();
		String cmd= uri.substring(uri.lastIndexOf("/")+1);
		fw.write(ip+","+cmd+","+new Date()+"\r\n");
		
		
		BookDao dao = new BookDao();
		ArrayList<BookVo> list = dao.selectAll();
		String str = "";
		str += "<table border='1'>";
		str += "<tr>";
		str += "<td>도서번호</td>"
			+ "<td>도서명</td>"
			+ "<td>출판사</td>"
			+ "<td>가격</td>";		
		str += "</tr>";
		
		for(BookVo v:list)
		{
			str +="<tr>";
			str += "<td>"+v.getBookid()+"</td>"+
					"<td>"+v.getBookname()+"</td>"+
					"<td>"+v.getPublisher()+"</td>"+
					"<td>"+v.getPrice()+"</td>";
			str += "</tr>";
		}
		str += "</table>";
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(str);
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
