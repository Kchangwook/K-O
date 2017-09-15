package project.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.dao.MemberDao;

@WebServlet("/Login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String url = null;
		HttpSession session = null;
		
		try {
			String msg = MemberDao.login(id, password);
			
			if("로그인 성공".equals(msg)){
				session = request.getSession();
				session.setAttribute("id", id);
				url = "index.jsp";
			}else{
				request.setAttribute("msg", msg);
				url = "index.jsp";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
