package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.dto.Lecture;
import project.util.DBUtil;

/** Lecture Table과 연동하기 위한 클래스 */
public class LectureDao {

	/* 변수 */
	private static LectureDao instance = null;
	
	/* 생성자 */
	private LectureDao() {}
	
	/* 접근자 */
	public static LectureDao getInstance() {
		
		if(instance == null)
			instance = new LectureDao();
		
		return instance;
		
	}//end of getInstance
	
	/* 함수 */
	/** 강좌 번호에 해당하는 강좌 가져오는 함수 */
	public Lecture getLecture(int lectureNum) {
		
		Lecture l = null;
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			//Connection생성 및 쿼리문 생성,실행
			c = DBUtil.getConnection();
			ps = c.prepareStatement("select * from lecture where lecture_num = ?");
			ps.setInt(1, lectureNum);
			rs = ps.executeQuery();
			
			//존재한다면 새로운 객체 생성
			rs.next();
			l = new Lecture(rs.getInt("lecture_Num"), rs.getString("lecture_Name"),rs.getString("lecture_Teacher"), 
						rs.getDate("lecture_Start_Date"),rs.getDate("lecture_End_Date"),rs.getDate("lecture_Start_Time"), rs.getDate("lecture_End_Time")
						, rs.getString("lecture_Content"),rs.getString("lecture_Student"),rs.getString("lecture_Day"),rs.getInt("lecture_Max_Num")
						, rs.getInt("lecture_Price"),rs.getString("lecture_Address"),rs.getString("lecture_Company"), rs.getDate("lecture_Receipt_Start"),
						rs.getDate("lecture_Receipt_End"),rs.getString("lecture_Receipt_Method"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps, rs);
		}
		
		return l;
		
	}//end of getLecture
	
}//end of LectureDao
