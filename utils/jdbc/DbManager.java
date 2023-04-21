package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbManager {
	
	private static final String URL = "jdbc:mysql://localhost/?"
			+ "useSSL=false&"
			+ "allowPublicKeyRetrieval=true&"
			+ "ChacterEncoing=UTF-8&"
			+ "severTimezone=UTC&"
			+ "allowLoadLocalInfile=true&"
			+ "allowMultiQueries=true";
	private static final String ID = "root";
	private static final String PW = "qwasqaws12";
	private Connection con;

	public DbManager() {
		try {
			con = DriverManager.getConnection(URL, ID, PW);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getData(String sql, Object... vals) {
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			int cont = 1;
			for (Object val : vals) {
				pstmt.setObject(cont , pstmt);
			}
			
			pstmt.
			
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}		
		
	}
}
