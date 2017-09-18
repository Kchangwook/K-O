package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.bcel.internal.generic.LUSHR;

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
	
	/** 강의 전체 목록을 가져오는 함수*/
	public static Map<Integer, List<Lecture>> searchAll(int startRow, int endRow){
		List<Lecture> list = new ArrayList<>();
		Map<Integer, List<Lecture>> map = new HashMap<>();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select count(lecture_num) from lecture";
		ResultSet rs2 = null;
		int cnt = 0;
		try {
			c = DBUtil.getConnection();

			ps = c.prepareStatement(sql);
			rs2 = ps.executeQuery();
			
			if(rs2.next()){
				cnt = rs2.getInt(1);
			}
			System.out.println(cnt);
			ps.close();
//			sql = "select * from lecture";
			System.out.println(startRow + "      " + endRow);
			sql = "SELECT * FROM "
					+ "( SELECT l.*, ROWNUM AS RNUM FROM "
					+ "( SELECT * FROM lecture ) l ) WHERE RNUM >= ? AND RNUM <= ?";
			ps = c.prepareStatement(sql);
			ps.setInt(1, startRow);
			ps.setInt(2, endRow);
			
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(new Lecture(rs.getInt(1), rs.getString(2),rs.getString(3), 
						rs.getDate(4),rs.getDate(5),rs.getDate(6), rs.getDate(7)
						, rs.getString(8),rs.getString(8),rs.getString(10),rs.getInt(11)
						, rs.getInt(12),rs.getString(13),rs.getString(14), rs.getDate(15),
						rs.getDate(16),rs.getString(17)));
			}
			
			map.put(cnt, list);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps, rs);
		}
		
		return map;
		
	}//end of searchAll

	/** 강좌 정보 상세 보기 함수*/
	public static Lecture searchDetail(int lectureNum) {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Lecture lecture = null;
		String sql = "select * from lecture where lecture_num = ?";
		
		try {
			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			ps.setInt(1, lectureNum);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				lecture = new Lecture(rs.getInt("lecture_Num"), rs.getString("lecture_Name"),rs.getString("lecture_Teacher"), 
						rs.getDate("lecture_Start_Date"),rs.getDate("lecture_End_Date"),rs.getDate("lecture_Start_Time"), rs.getDate("lecture_End_Time")
						, rs.getString("lecture_Content"),rs.getString("lecture_Student"),rs.getString("lecture_Day"),rs.getInt("lecture_Max_Num")
						, rs.getInt("lecture_Price"),rs.getString("lecture_Address"),rs.getString("lecture_Company"), rs.getDate("lecture_Receipt_Start"),
						rs.getDate("lecture_Receipt_End"),rs.getString("lecture_Receipt_Method"));
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lecture;
	}

	/** 수강 신청하는 dao */
	public static String ask(int lectureNum, String id) {
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "insert into present values(?,?)";
		int num = 0;
		String msg = "수강 신청을 실패하셨습니다.";
		
		try {
			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			
			ps.setString(1, id);
			ps.setInt(2, lectureNum);
			num = ps.executeUpdate();
			
			if(num == 1){
				msg = "수강 신청에 성공하셨습니다.";
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps);
		}
		
		return msg;
	}// end of ask
	
}//end of LectureDao
