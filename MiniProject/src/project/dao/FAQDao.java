package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.dto.FAQ;
import project.util.DBUtil;

/** FAQ Table과 연동하기 위한 클래스 */
public class FAQDao {

	/* 변수 */
	private static FAQDao instance = null;
	
	/* 생성자 */
	private FAQDao() {}
	
	/* 접근자 */
	public static FAQDao getInstance() {
		
		if(instance == null)
			instance = new FAQDao();
		
		return instance;
		
	}//end of getInstance
	
	/* 함수 */
	/** FAQ 목록을 가져다 주는 클래스 */
	public List<FAQ> getList(){
		
		List<FAQ> list = new ArrayList<>();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			c = DBUtil.getConnection();
			ps = c.prepareStatement("select * from faq");
			rs = ps.executeQuery();
			
			while(rs.next())
				list.add(new FAQ(rs.getInt("faq_num"),rs.getString("faq_name"),rs.getString("faq_content")));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps, rs);
		}
		
		return list;
		
	}//end of getList
	
	/** FAQ 번호와 일치하는 FAQ 객체 가져오기 */
	public FAQ getFAQ(int num) {
		
		FAQ f = null;
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			c = DBUtil.getConnection();
			ps = c.prepareStatement("select * from faq where faq_num = ?");
			ps.setInt(1, num);
			
			rs = ps.executeQuery();
			
			if(rs.next()) 
				f = new FAQ(rs.getInt("faq_num"),rs.getString("faq_name"),rs.getString("faq_content"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps, rs);
		}
		
		return f;
		
	}//end of GetFAQ
	
}//end of FAQDao
