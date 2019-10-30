package bbs;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deleteCtrler
 */
@WebServlet("/delete.do")
public class deleteCtrler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteCtrler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("num"));
		BbsDao dao = new BbsDao();
		request.setAttribute("v", dao.getBbs(num));
		RequestDispatcher dis = request.getRequestDispatcher("delete.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BbsDao dao = new BbsDao();
		int num = Integer.parseInt(request.getParameter("num"));
		String pwd = request.getParameter("pwd");
		
		String fname = dao.getBbs(num).getFname();
		String path = request.getRealPath("photo");
		
		int re = dao.deleteBbs(num, pwd);
		if(re==1)
		{
			File file = new File(path+"/"+fname);
			file.delete();
			
			response.sendRedirect("listBbs.do");
		}
		else
		{
			response.sendRedirect("error.jsp");
		}
	}

}
