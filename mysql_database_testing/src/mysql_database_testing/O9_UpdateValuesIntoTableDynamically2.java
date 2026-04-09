package mysql_database_testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class O9_UpdateValuesIntoTableDynamically2 {

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

					System.out.println("Enter the id of the user you want to update the details for.");
					int id = sc.nextInt();

					try {

						// check whether id is present before update
						String preSqlQuery = "select * from contacts where id = ?";
						PreparedStatement prePs = conn.prepareStatement(preSqlQuery);
						prePs.setInt(1, id);
						ResultSet preResultSet = prePs.executeQuery();

						boolean userFound = false;

						System.out.println("Row Before Update \n*****************************\n");
						System.out.println("| ID | Name | EMAIL | Fees |");
						System.out.println("***********************************************************");

						while (preResultSet.next()) {
							userFound = true;
							System.out.println(preResultSet.getInt(1) + " | " + preResultSet.getString(2) + " | "
									+ preResultSet.getString(3) + " | " + preResultSet.getFloat(4));
						}

						if (userFound == false) {
							System.out.println("Id not present in contacts table. Unable to update values.");
						} else {

							try {
								String sqlQuery = "update contacts set name = ? , email = ? , fees = ? where id = ?";
								PreparedStatement ps = conn.prepareStatement(sqlQuery);
								ps.setString(1, name);
								ps.setString(2, email);
								ps.setFloat(3, fees);
								ps.setInt(4, id);

								int updatedRows = ps.executeUpdate();

								if (updatedRows > 0) {
									System.out.println("Values updated into contacts table Successfully.");
									System.out.println("Total number of rows updated = " + updatedRows);
								} else {
									System.out.println("Update query executed, but no row was updated.");
								}

							} catch (Exception ex3) {
								ex3.printStackTrace();
								System.out.println("Unable to update values for the given id.");
							}

							try {
								String sqlQuery1 = "select * from contacts where id = ?";
								PreparedStatement ps1 = conn.prepareStatement(sqlQuery1);
								ps1.setInt(1, id);
								ResultSet resultSet = ps1.executeQuery();

								System.out.println("Row After Update \n*****************************\n");
								System.out.println("| ID | Name | EMAIL | Fees |");
								System.out.println("***********************************************************");

								boolean updatedRowFound = false;

								while (resultSet.next()) {
									updatedRowFound = true;
									System.out.println(resultSet.getInt(1) + " | " + resultSet.getString(2) + " | "
											+ resultSet.getString(3) + " | " + resultSet.getFloat(4));
								}

								if (updatedRowFound == false) {
									System.out.println("Unable to fetch row after update.");
								}

							} catch (Exception ex4) {
								ex4.printStackTrace();
								System.out.println("Unable to fetch and print row after update.");
							}
						}

					} catch (Exception ex5) {
						ex5.printStackTrace();
						System.out.println("Unable to fetch user by id before update.");
					}

				} catch (Exception ex2) {
					ex2.printStackTrace();
					System.out.println("Unable to take input or update values in the table.");
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