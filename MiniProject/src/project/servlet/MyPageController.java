package project.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.dao.MemberDao;
import project.dto.Member;

/** 마이페이지(회원수정)를 활용하기 위한 servlet */
@WebServlet("/MyPage.do")
public class MyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String command = request.getParameter("command");
		System.out.println(command);
		
		if(command.equals("update")){
			update(request, response);
		}else if(command.equals("mypage")){
			myPage(request, response);
		}
		
		
	}
	
	/** myPage(회원수정)을 위해 리스트를 가져오는 함수 */
	public void myPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("id");
		String url = null;
		
		try {
			
			Member member = MemberDao.mypage(id);
			System.out.println("controller: " + member.toString());
			request.setAttribute("member", member);
			
			url = "mypage/mypage.jsp";
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	/**  myPage(회원수정)을 위해 값을 가져오고 데이터를 바꿔주는 함수 */
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = new Member(request.getParameter("id"), request.getParameter("password"), request.getParameter("name"), request.getParameter("email"), request.getParameter("phone"));
		String url = null;
		String msg = null;
		try {
			
			msg = MemberDao.update(member);
			
			url="index.jsp";
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		response.sendRedirect(url+"?msg="+URLEncoder.encode(msg, "UTF-8"));
		
	}
	
}
