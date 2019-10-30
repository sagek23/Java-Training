package bbs;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class Update
 */
@WebServlet("/update.do")
public class UpdateCtrler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCtrler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//
		int num = Integer.parseInt(request.getParameter("num"));
		BbsDao dao = new BbsDao();
		request.setAttribute("v", dao.getBbs(num));
		RequestDispatcher dis = request.getRequestDispatcher("update.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BbsDao dao = new BbsDao();
		BbsVo v = new BbsVo();
		String path = request.getRealPath("photo");

		request.setCharacterEncoding("UTF-8");
		
		MultipartRequest multi= new MultipartRequest(request, path, "UTF-8");
		int num = Integer.parseInt(multi.getParameter("num"));
		String ofname = dao.getBbs(num).getFname(); //원래 사진이름을 받아온다.
		String fname = multi.getOriginalFileName("fname"); //사용자가 업로드한 파일 이름을 담는다. 
														  //만약 null이면 사진이 수정되지 않은 것이다.
		v.setTitle(multi.getParameter("title"));
		v.setContent(multi.getParameter("content"));
		v.setPwd(multi.getParameter("pwd"));
		v.setFname(ofname);
		v.setNum(num);

		if(fname!=null)//만약 fname이 null이 아니면 사진이 수정한다. 
		{
			v.setFname(fname);
		}
		int re = dao.updateCon(v);
		if(re==1)
		{
			if(fname!=null)
			{
				File file = new File(path+"/"+ofname); //원래 파일을 삭제한다
				file.delete();
			}
			response.sendRedirect("listBbs.do");
		}
	}

}
