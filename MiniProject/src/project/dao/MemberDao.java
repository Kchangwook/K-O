package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.dto.Member;
import project.util.DBUtil;

public class MemberDao {

	/** 로그인 dao */
	public static String login(String id, String password){
		
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select id, password from member where id = ?";
		String msg = null;
		
		try {
			c = DBUtil.getConnection();
			
			ps = c.prepareStatement(sql);
			
			ps.setString(1, id);
			rs = ps.executeQuery();
			msg = "아이디가 올바르지 않습니다.";
			String idDB = null;
			String passwordDB = null;
			
			while(rs.next()){
				idDB = rs.getString("id");
				passwordDB = rs.getString("password");
				
				if(!password.equals(passwordDB)){
					msg = "비밀번호가 올바르지 않습니다.";
					break;
				}else{
					msg = "로그인 성공";
					break;
				}
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps, rs);
			
		}

		return msg;
		
	}
	
	/** 회원가입 dao */
	public static String join(Member member){
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?)";
		int num = 0;
		String msg = "회원가입에 실패하셨습니다.";
		try {
			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			
			ps.setString(1, member.getId());
			ps.setString(2, member.getPassword());
			ps.setString(3, member.getName());
			ps.setString(4, member.getEmail());
			ps.setString(5, member.getPhone());
			
			num = ps.executeUpdate();
			System.out.println(num);
			if(num==1){
				msg = "회원가입에 성공하셨습니다.";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		} finally {
			DBUtil.close(c, ps);
		}
		
		return msg;
	}
	
	public static Member mypage(String id){
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from member where id = ?";
		Member member = null;
		
		try {
			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()){
				
				member = new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return member;
	}
	
	public static String update(Member member){
		
		Connection c = null;
		PreparedStatement ps = null;
		String msg = "회원정보 수정에 실패하셨습니다.";
		String sql="UPDATE MEMBER SET "
				+ "PASSWORD = ?, NAME = ?, mail = ?, phone = ?"
				+ "where id = ?";
		int num = 0;
		
		try {
			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			
			ps.setString(1, member.getPassword());
			ps.setString(2, member.getName());
			ps.setString(3, member.getEmail());
			ps.setString(4, member.getPhone());
			ps.setString(5, member.getId());
			
			num = ps.executeUpdate();
			
			if(num == 1){
				msg = "회원정보 수정에 성공하셨습니다.";
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps);
		}
		
		return msg;
	}
}
