package mysql_database_testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class O10_DeleteUserFromTable2 {

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

					System.out.println("Enter the id of the user you want to delete from Table.");
					int id = sc.nextInt();

					try {

						String presqlQuery = "select * from contacts where id = ?";
						PreparedStatement preps = conn.prepareStatement(presqlQuery);
						preps.setInt(1, id);
						ResultSet rs = preps.executeQuery();

						while (rs.next() == true) {
							try {
								String sqlQuery = "delete from contacts where id = ?";
								PreparedStatement ps = conn.prepareStatement(sqlQuery);
								ps.setInt(1, id);

								ps.executeUpdate();
								System.out.println("Deleted the user from contact table Successfull.");
							} catch (Exception ex3) {
								ex3.printStackTrace();
								System.out.println("Unable to delete user with id.");
							}

						}

						String sqlQuery1 = "select * from contacts";
						PreparedStatement ps1 = conn.prepareStatement(sqlQuery1);
						ResultSet resultSet = ps1.executeQuery();
						System.out.println("Table People From Contact Table. \n*****************************\n");

						System.out.println("| ID | Name  | EMAIL | Fees |");
						System.out.println("***********************************************************");

						while (resultSet.next()) {
							System.out.println(resultSet.getInt(1) + " | " + resultSet.getString(2) + " | "
									+ resultSet.getString(3) + " | " + resultSet.getFloat(4));
						}

					} catch (Exception ex2) {
						ex2.printStackTrace();
						System.out.println("Id not present, Unable to fetch user by id.");
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
