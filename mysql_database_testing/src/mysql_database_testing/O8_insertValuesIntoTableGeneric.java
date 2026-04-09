package mysql_database_testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class O8_insertValuesIntoTableGeneric {

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

					Scanner sc = new Scanner(System.in);

					System.out.println("Enter a new name for the table.");
					String name = sc.nextLine();
					System.out.println("Enter a new email for the table.");
					String email = sc.next();
					System.out.println("Enter a new fees for the table.");
					float fees = sc.nextFloat();

					String sqlQuery = "insert into contacts (name, email, fees) values (?, ? ,?)";
					PreparedStatement ps = conn.prepareStatement(sqlQuery);
					ps.setString(1, name);
					ps.setString(2, email);
					ps.setFloat(3, fees);
					ps.executeUpdate();
					System.out.println("Valuse inserted into contact table Successfully.");

					String sqlQuery1 = "select * from contacts";
					PreparedStatement ps1 = conn.prepareStatement(sqlQuery1);
					ResultSet resultSet = ps1.executeQuery();
					System.out.println("Table Values \n*****************************\n");

					System.out.println("| ID | Name  | EMAIL | Fees |");
					System.out.println("***********************************************************");

					while (resultSet.next()) {
						System.out.println(resultSet.getInt(1) + " | " + resultSet.getString(2) + " | "
								+ resultSet.getString(3) + " | " + resultSet.getFloat(4));
					}

				} catch (Exception ex2) {
					ex2.printStackTrace();
					System.out.println("Unable to insert values in to the table.");
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
