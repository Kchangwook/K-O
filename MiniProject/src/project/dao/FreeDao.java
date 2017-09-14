package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.dto.FAQ;
import project.dto.Free;
import project.util.DBUtil;

/** Free Table과 연동하기 위한 클래스 */
public class FreeDao {

	/* 변수 */
	private static FreeDao instance = null;
	
	/* 생성자 */
	private FreeDao() {}
	
	/* 접근자 */
	public static FreeDao getInstance() {
		
		if(instance == null)
			instance = new FreeDao();
		
		return instance;
		
	}//end of getInstance
	
	/* 함수 */
	/** 게시판 글 목록을 가져다 주는 클래스 */
	public List<Free> getList(){
		
		List<Free> list = new ArrayList<>();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			c = DBUtil.getConnection();
			ps = c.prepareStatement("select * from free");
			rs = ps.executeQuery();
			
			while(rs.next())
				list.add(new Free(rs.getInt("free_num"),rs.getString("free_name")
						,rs.getString("free_content"),rs.getString("id")));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps, rs);
		}
		
		return list;
		
	}//end of getList
	
	/** 자유게시판 글 번호와 일치하는 Free 객체 가져오기 */
	public Free getFree(int num) {
		
		Free f = null;
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			c = DBUtil.getConnection();
			ps = c.prepareStatement("select * from free where free_num = ?");
			ps.setInt(1, num);
			
			rs = ps.executeQuery();
			
			if(rs.next()) 
				f = new Free(rs.getInt("free_num"),rs.getString("free_name")
						,rs.getString("free_content"),rs.getString("id"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps, rs);
		}
		
		return f;
		
	}//end of GetFAQ
	
	/** Free 내용을 수정하는 함수 */
	public int update(Free f) {
		
		int result = 0;
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			c = DBUtil.getConnection();
			ps = c.prepareStatement("update free set free_name = ?, free_content = ? where free_num = ?");
			ps.setString(1, f.getFreeName());
			ps.setString(2, f.getFreeContent());
			ps.setInt(3,f.getFreeNum());
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps);
		}
		
		return result;
		
	}//end of update
	
	/** 글을 작성하는 함수 */
	public int write(Free f) {
		int result = 0;
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			c = DBUtil.getConnection();
			ps = c.prepareStatement("insert into free values(free_num.nextval,?,?,?)");
			ps.setString(1, f.getFreeName());
			ps.setString(2, f.getFreeContent());
			ps.setString(3,f.getId());
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps);
		}
		
		return result;
		
	}//end of write
	
}//end of FreeDao
