package project.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.soap.Detail;

import org.apache.catalina.tribes.group.interceptors.FragmentationInterceptor;

import com.sun.org.apache.bcel.internal.generic.LUSHR;

import project.dao.LectureDao;
import project.dao.MemberDao;
import project.dto.Lecture;

/** Search를 활용하기 위한 servlet */
@WebServlet("/Search.do")
public class SearchController extends HttpServlet {
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
		
		if("searchAll".equals(command)){
			searchAll(request, response);
		}else if("searchDetail".equals(command)){
			searchDetail(request, response);
		}else if("ask".equals(command)){
			ask(request, response);
		}
		
		
	}
	
	/** 강좌 정보 전체 보기 */
	public void searchAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("id");
		System.out.println("controller : " + id);
		String pageNumber=request.getParameter("pageNumber");
	    if(pageNumber==null) pageNumber="1";
	      
	    int currentPage=Integer.parseInt(pageNumber);
	    int boardSize=10;
	      
	    int startRow=(currentPage-1)*boardSize+1;
	    int endRow=currentPage*boardSize;
//		int start = Integer.valueOf(request.getParameter("start"));
//		int end = Integer.valueOf(request.getParameter("end"));
//		System.out.println(start + "  " + end);
		String url = null;
		String msg = null;
		
		try {
			Map<Integer, List<Lecture>> map = LectureDao.searchAll(startRow, endRow);
			
			Set<Integer> set = map.keySet();
			System.out.println(set);
			
			int cnt = 0;
			List<Lecture> list =null;
			for (Integer key : set) {
				cnt = key;
				list = map.get(key);
			}
//			List<Lecture> list =LectureDao.searchAll();
			System.out.println(cnt);
			request.setAttribute("cnt", cnt);			
			request.setAttribute("list", list);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("boardSize", boardSize);
			request.setAttribute("startRow", startRow);
			request.setAttribute("endRow", endRow);
			url="search/search.jsp";
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}//end of searchAll
	
	/** 강좌 정보 상세 보기 */
	public void searchDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int lectureNum = Integer.valueOf(request.getParameter("lectureNum"));
		String url = null;
		
		try {
			
			Lecture lecture = LectureDao.searchDetail(lectureNum);
			
			if(lecture !=null){
				request.setAttribute("lecture", lecture);
				url = "search/searchDetail.jsp";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} 
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}// end of searchDetail

	/** 수강 신청 */
	public void ask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int lectureNum = Integer.valueOf(request.getParameter("lectureNum"));
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("id");
		String url=null;
		String msg = null;
		
		try {
			
			msg = LectureDao.ask(lectureNum, id);
			
			url = "index.jsp";
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		response.sendRedirect(url+"?msg="+URLEncoder.encode(msg, "UTF-8"));
		
	}// end of ask
	
}// end of SearchController
