package mysql_database_testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class O7_CreatingATableInSelectedDatabase {

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
				try {
					String sqlQuery = "create table if not exists contacts (id int(45) primary key auto_increment, name varchar(100) , email varchar(100) , fees float(5,2))";
					PreparedStatement ps = conn.prepareStatement(sqlQuery);
					ps.executeUpdate();
					System.out.println("Table Created Successfully.");

					String sqlQuery1 = "desc contacts";
					PreparedStatement ps1 = conn.prepareStatement(sqlQuery1);
					ResultSet resultSet = ps1.executeQuery();
					System.out.println("Table structure \n*****************************\n");

					System.out.println("| FIELD | DATA TYPE  | CAN KEEP NULL | KEY  | DEFAULT VALUE  | EXTRA |");
					System.out.println("***********************************************************");

					while (resultSet.next()) {
						System.out.println(resultSet.getString(1) + " | " + resultSet.getString(2) + " | "
								+ resultSet.getString(3) + " | " + resultSet.getString(4) + " | "
								+ resultSet.getString(5) + " | " + resultSet.getString(6));
					}

				} catch (Exception ex2) {
					ex2.printStackTrace();
					System.out.println("Unable to create table.");
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
