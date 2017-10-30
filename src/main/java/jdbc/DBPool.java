package jdbc;

import entity.host;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class DBPool {
	private static DBPool dbPool;
	private ComboPooledDataSource dataSource;
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();  
	static {
		dbPool = new DBPool();
	}

	public DBPool() {
		try {
			dataSource = new ComboPooledDataSource();
			//数据库账号
			dataSource.setUser(host.hostuser);
			//数据库密码
			dataSource.setPassword(host.hostpassword);
			//数据连接url
//			dataSource.setJdbcUrl("jdbc:postgresql://"+Host.hostjdbc+"?useUnicode=true&characterEncoding=utf8&rewriteBatchedStatements=TRUE&zeroDateTimeBehavior=convertToNull");
			dataSource.setJdbcUrl("jdbc:mysql://"+host.hostjdbc+"?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&autoReconnect=true&failOverReadOnly=false");
			//数据库驱动
//			dataSource.setDriverClass("org.postgresql.Driver");
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
            // 设置连接池的最小值！   
            dataSource.setMinPoolSize(10);  
            // 设置连接池的最大值！   
            dataSource.setMaxPoolSize(50);
            // 解决长时间不连接的超时问题
            dataSource.setAutomaticTestTable("SELECT 1 FROM DUAL");
            dataSource.setTestConnectionOnCheckin(true);
            dataSource.setIdleConnectionTestPeriod(60);
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
	}

	public final static DBPool getInstance() {
		return dbPool;
	}

	public final Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("无法从数据源获取连接 ", e);
		}
	}
	
	/** 
     * 获取数据库的Connection对象 
     *  
     * @return 
     */  
    public static synchronized Connection getConnection1() {  
        Connection conn = tl.get(); // 当前线程取出连接实例  
        try {
			if (null == conn || conn.isClosed()) {  
			    conn =  getInstance().getConnection(); // 从连接池中取出一个连接实例  
				tl.set(conn); // 把它绑定到当前线程上    
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        return conn;  
    }


}