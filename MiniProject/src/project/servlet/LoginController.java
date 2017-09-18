package project.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.dao.MemberDao;

/** 로그인을 활용하기 위한 servlet */
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
	
	/** 로그인을 위해 아이디와 비밀번호를 확인하는 함수 */
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String url = null;
		HttpSession session = null;
		
		try {
			String msg = MemberDao.login(id, password);
			request.setAttribute("msg", msg);
			if("로그인 성공".equals(msg)){
				session = request.getSession();
				session.setAttribute("id", id);
				url = "index.jsp";
			}else{
				
				url = "index.jsp";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
