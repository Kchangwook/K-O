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
	public List<Lecture> getList(String id){
		
		List<Lecture> list = new ArrayList<>();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			c = DBUtil.getConnection();
			ps = c.prepareStatement("select * from present p, lecture l where p.id = ? and p.lecture_num = l.lecture_num");
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) 
				list.add(new Lecture(rs.getInt("lecture_Num"), rs.getString("lecture_Name"),rs.getString("lecture_Teacher"), 
						rs.getDate("lecture_Start_Date"),rs.getDate("lecture_End_Date"),rs.getDate("lecture_Start_Time"), rs.getDate("lecture_End_Time")
						, rs.getString("lecture_Content"),rs.getString("lecture_Student"),rs.getString("lecture_Day"),rs.getInt("lecture_Max_Num")
						, rs.getInt("lecture_Price"),rs.getString("lecture_Address"),rs.getString("lecture_Company"), rs.getDate("lecture_Receipt_Start"),
						rs.getDate("lecture_Receipt_End"),rs.getString("lecture_Receipt_Method")));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps, rs);
		}
		
		return list;
		
	}//end of getList
	
}//end of PresentDao
