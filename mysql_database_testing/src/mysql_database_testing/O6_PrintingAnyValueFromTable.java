package mysql_database_testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class O6_PrintingAnyValueFromTable {

	public static void main(String[] args) throws SQLException {

		Connection conn = null;
		String databaseName = "software_testing";
		String mysqlPath = "jdbc:mysql://localhost:3306/" + databaseName;
		String mysqlUsername = "root";
		String mysqlPassword = "";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(mysqlPath, mysqlUsername, mysqlPassword);

			if (conn == null) {
				System.out.println("Unable to connect to mysql");
			} else {
				System.out.println("Successfuly connected to Mysql's " + databaseName + " database.");
				String sqlQuery = "select * from emp where sal >= 3000";
				PreparedStatement ps = conn.prepareStatement(sqlQuery);
				ResultSet resultSet = ps.executeQuery();
				System.out.println("All Tables value fetched are, \n*****************************\n");

				System.out.println("| EMPNO | ENAME  | JOB       | MGR  | SAL  | COMM | DEPTNO |");
				System.out.println("***********************************************************");

				while (resultSet.next()) {
					System.out.println(resultSet.getInt(1) + " | " + resultSet.getString(2) + " | "
							+ resultSet.getString(3) + " | " + resultSet.getInt(4) + " | " + resultSet.getInt(5) + " | "
							+ resultSet.getInt(6) + " | " + resultSet.getInt(7));
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
