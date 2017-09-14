package project.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.dao.PresentDao;
import project.dto.Lecture;

/** 현재 수강 목록을 반환하기 위한 servlet */
@WebServlet("/Present.do")
public class PresentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//각종 데이터들 가져오기
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		PresentDao pd = PresentDao.getInstance();
		List<Lecture> list = pd.getList("scott");
		
		//list를 request에 저장
		request.setAttribute("pList", list);
		
		//다음 페이지로 이동
		RequestDispatcher rd = request.getRequestDispatcher("present/present.jsp");
		rd.forward(request, response);

	}

}//end of PresentController
