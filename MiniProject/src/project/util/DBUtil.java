package project.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/** DB 연결과 해제를 담당하는 클래스 */
public class DBUtil {

	/** DB Connection을 생성하는 클래스 */
	public static Connection getConnection() {
		
		Connection c = null;
		
		try {
			
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			c = ds.getConnection();
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
		
	}//end of getConnection
	
	/** DB Connection 해제하는 함수 */
	public static void close(Connection c,PreparedStatement ps, ResultSet rs) {
		
		try {
			
			if(rs != null) {rs.close(); rs = null;}
			if(ps != null) {ps.close(); ps = null;}
			if(c != null) {c.close(); c = null;}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//end of close
	
}//end of DBUtil
