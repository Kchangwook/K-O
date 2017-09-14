package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.util.DBUtil;

public class MemberDao {

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
				
				System.out.println(idDB + " " + passwordDB);
				System.out.println(id + " " + password);
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
}
