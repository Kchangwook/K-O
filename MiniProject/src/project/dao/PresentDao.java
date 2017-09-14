package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import project.dto.Lecture;
import project.util.DBUtil;

/** Present Table과 연동하기 위한 클래스 */
public class PresentDao {

	/* 변수 */
	private static PresentDao instance = null;
	
	/* 생성자 */
	private PresentDao() {}
	
	/* 접근자 */
	public static PresentDao getInstance() {
		
		if(instance == null)
			instance = new PresentDao();
		
		return instance;
		
	}//end of getInstance
	
	/* 함수 */
	/** 현재 수강중인 강좌의 코드를 반환 하는 함수 */
	public static List<Lecture> getList(String id){
		
		List<Lecture> list = new ArrayList<>();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			c = DBUtil.getConnection();
			ps = c.prepareStatement("select * from present p, lecture l where p.id = ? and p.lecture_num = l.lecture_num;");
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss"); 
			
//			while(rs.next()) 
//				list.add(new Lecture(rs.getInt("lectureNum"), rs.getString("lectureName"),rs.getString("lectureTeacher"), 
//						Date lectureStartDate,Date lectureEndDate, Date lectureStartTime, Date lectureEndTime, String lectureContent,
//						String lectureStudent, String lectureDay, int lectureMaxNum, int lecturePrice, String lectureAddress,
//						String lectureCompany, Date lectureReceiptStart, Date lectureReceiptEnd, String lectureReceiptMethod));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps, rs);
		}
		
		return list;
		
	}//end of getList
	
}//end of PresentDao
