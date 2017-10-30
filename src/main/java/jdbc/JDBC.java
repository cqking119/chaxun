package jdbc;

import java.sql.Connection;
import jdbc.Dbtool;

public class JDBC {
    public static Connection getConnection() {
    	Connection conn = null;
    	conn = DBPool.getInstance().getConnection();
//    	conn = Dbtool.getConnection();
		return conn;
	}
    public static Connection getConnection1() {
    	Connection conn = null;
    	conn = DBPool.getConnection1();
//    	conn = Dbtool.getConnection();
		return conn;
	}
}
