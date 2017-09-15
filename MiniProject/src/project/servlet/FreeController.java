package project.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.dao.FreeDao;
import project.dto.Free;

@WebServlet("/Free.do")
public class FreeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String command = request.getParameter("command");

		if (command.equals("getList"))
			getList(request, response);
		else if (command.equals("detail"))
			detail(request, response);
		else if (command.equals("update"))
			update(request,response);
		else if (command.equals("write"))
			write(request,response);

	}// end of doGet
	
	/** 자유 게시판 글을 작성하는 함수 */
	private void write(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		FreeDao fd = FreeDao.getInstance();
		
		Free f = new Free();
		String id = (String)request.getSession().getAttribute("id");
		String name = request.getParameter("title");
		String content = request.getParameter("content");
		f.setFreeContent(content);
		f.setFreeName(name);
		f.setId("scott");
		
		int result = fd.write(f);
		
		if(result == 0)
			request.setAttribute("msg", "작성에 실패했습니다.");
		else
			request.setAttribute("msg", "작성에 성공했습니다.");
		
		response.sendRedirect("Free.do?command=getList");
		
	}//end of write
	
	/** 자유 게시판 글을 수정하는 함수 */
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FreeDao fd = FreeDao.getInstance();
		
		int num = Integer.parseInt(request.getParameter("num"));
		String id = request.getParameter("id");
		String name = request.getParameter("title");
		String content = request.getParameter("content");
		Free f = new Free(num,name,content,"scott");
		
		int result = fd.update(f);
		
		if(result == 0)
			request.setAttribute("msg", "수정에 실패했습니다.");
		else
			request.setAttribute("msg", "수정에 성공했습니다.");
		
		request.setAttribute("command", "detail");
		response.sendRedirect("Free.do?command=getList");
		
	}//end of update

	/** 자유게시판 글을 받아오는 함수 */
	private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FreeDao fd = FreeDao.getInstance();
		int num = Integer.parseInt(request.getParameter("num"));
		String change = request.getParameter("change");
		int changes = 0; 
		if(change != null)
			changes = Integer.parseInt(change);

		Free f = fd.getFree(num);

		request.setAttribute("f", f);

		if (changes != -1) {
			RequestDispatcher rd = request.getRequestDispatcher("free/freeDetail.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("free/freeChange.jsp");
			rd.forward(request, response);
		}

	}// end of detail

	/** 자유게시판 목록을 받아오는 함수 */
	private void getList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.removeAttribute("msg");
		
		FreeDao fd = FreeDao.getInstance();
		List<Free> list = fd.getList();
		request.setAttribute("list", list);

		RequestDispatcher rd = request.getRequestDispatcher("free/free.jsp");
		rd.forward(request, response);

	}// end of getList

}// end of FreeController
