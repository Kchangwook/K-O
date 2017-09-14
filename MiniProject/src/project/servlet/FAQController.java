package project.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.dao.FAQDao;
import project.dto.FAQ;

/** FAQ를 활용하기 위한 servlet */
@WebServlet("/FAQ.do")
public class FAQController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String command = request.getParameter("command");
		
		if(command.equals("getList"))
			getList(request,response);
		else if(command.equals("detail"))
			detail(request,response);
		
		
	}//end of doGet

	/** FAQ 상세 정보를 가져오는 함수 */
	protected void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		FAQDao fd = FAQDao.getInstance();
		int num = Integer.parseInt(request.getParameter("num"));
		
		FAQ f = fd.getFAQ(num);
		request.setAttribute("f", f);
		
		RequestDispatcher rd = request.getRequestDispatcher("faq/faqDetail.jsp");
		rd.forward(request, response);
		
	}//end of detail
	
	/** FAQ 목록을 가져오는 함수 */
	protected void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		FAQDao fd = FAQDao.getInstance();
		List<FAQ> list = fd.getList();
		
		request.setAttribute("flist",list);
		
		RequestDispatcher rd = request.getRequestDispatcher("faq/faq.jsp");
		rd.forward(request, response);
		
	}//end of getList

}
