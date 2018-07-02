package s57map.utils;

import java.sql.*;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class DbUtils {
	private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/unmannedshipnavigation170824?useUnicode=true&amp;characterEncoding=utf-8";
	public final static int PAGE_SIZE = 2;

	private static String USERID = "root";
	private static String UERPASSWORD = "root";

	// 禁止实例对象
	private DbUtils() {
	}

	static {
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 获得打开的数据连�?
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USERID, UERPASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 关闭数据�?/语句/连接对象
	public static void close(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
