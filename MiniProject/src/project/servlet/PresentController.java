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

import project.dao.LectureDao;
import project.dao.PresentDao;
import project.dto.Lecture;

/** 현재 수강 목록을 활용하기 위한 servlet */
@WebServlet("/Present.do")
public class PresentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String command = request.getParameter("command");

		//명령어 확인
		if (command.equals("getList"))
			getList(request, response);
		else if (command.equals("detail"))
			getDetail(request, response);
		else if(command.equals("delete"))
			delete(request,response);

	}// end of doGet
	
	/** 수강 중인 강의 삭제 */
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 각종 데이터들 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		int num = Integer.parseInt(request.getParameter("num"));
		PresentDao pd = PresentDao.getInstance();

		// 데이터 삭제
		int result = pd.deletePresent("scott", num);

		// 삭제 결과에 따른 메시지 전송
		if (result == 0)
			session.setAttribute("msg", "삭제에 실패했습니다.");
		else
			session.setAttribute("msg", "삭제에 성공했습니다.");

		// 다음 페이지로 이동
		response.sendRedirect("Present.do?command=getList&num=" + num);
		
	}//end of delete

	/** 현재 수강신청 중인 리스트 가져오는 함수 */
	private void getList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 각종 데이터들 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		PresentDao pd = PresentDao.getInstance();
		List<Lecture> list = pd.getList("scott");

		// list를 request에 저장
		request.setAttribute("pList", list);

		// 다음 페이지로 이동
		RequestDispatcher rd = request.getRequestDispatcher("present/present.jsp");
		rd.forward(request, response);

	}// end of getList

	/** 강좌 상세 정보 가져오기 */
	private void getDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 각종 데이터들 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		int num = Integer.parseInt(request.getParameter("num"));
		LectureDao ld = LectureDao.getInstance();
		Lecture l = ld.getLecture(num);
		
		System.out.println(num);

		// lecture를 저장
		request.setAttribute("lecture", l);

		// l이 null이라면 메시지 전송
		if (l == null) {
			request.setAttribute("msg", "가져오는데 실패했습니다.");
			System.out.println("실패");
		}

		// 다음 페이지로 이동
		RequestDispatcher rd = request.getRequestDispatcher("present/presentDetail.jsp");
		rd.forward(request, response);

	}// end of getDetail

}// end of PresentController
