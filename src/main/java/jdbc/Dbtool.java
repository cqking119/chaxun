package jdbc;

import entity.host;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbtool {
	
	public static synchronized Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//本地数据库
			String url = "jdbc:mysql://"+host.hostjdbc+"?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&autoReconnect=true&failOverReadOnly=false";
			conn=DriverManager.getConnection(url, host.hostuser, host.hostpassword);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 关闭数据库连接
	 */
	/** public static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			LogRecord.error(Dbtool.class, e);
		}
	}
**/

}
