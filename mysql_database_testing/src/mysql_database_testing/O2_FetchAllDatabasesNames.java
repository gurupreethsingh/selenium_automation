package mysql_database_testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class O2_FetchAllDatabasesNames {

	public static void main(String[] args) throws SQLException {

		Connection conn = null;
		String mysqlPath = "jdbc:mysql://localhost:3306";
		String mysqlUsername = "root";
		String mysqlPassword = "";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(mysqlPath, mysqlUsername, mysqlPassword);

			if (conn == null) {
				System.out.println("Unable to connect to mysql");
			} else {
				System.out.println("Successfuly connected to Mysql database.");
				// try to print all the database names. using the sql query = "show databases"
				String sqlQuery = "show databases";
				PreparedStatement ps = conn.prepareStatement(sqlQuery);
				ResultSet resultSet = ps.executeQuery();

				while (resultSet.next()) {
					System.out.println(resultSet.getString(1));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Unable to connect to mysql");
		} finally {
			conn.close();
		}
	}
}
