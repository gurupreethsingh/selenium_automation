package mysql_database_testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class O1_ConnectToMySql {

	public static void main(String[] args) throws SQLException {

		Connection conn = null;
		// from jdbc connect to mysql using my laptop running mysql on 3306 port using
		// username root, and password of mysql root
		String mysqlPath = "jdbc:mysql://localhost:3306";
		String mysqlUsername = "root";
		String mysqlPassword = "";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(mysqlPath, mysqlUsername, mysqlPassword);

			if (conn == null) {
				System.out.println("Unable to connect to mysql");
			} else {
				System.out.println("Successfuly connected to Mysql.");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Unable to connect to mysql");
		} finally {
			conn.close();
		}
	}
}
