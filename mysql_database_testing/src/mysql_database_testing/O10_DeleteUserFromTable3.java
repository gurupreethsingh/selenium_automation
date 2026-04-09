package mysql_database_testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class O10_DeleteUserFromTable3 {

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

						// count rows before delete
						int countBeforeDelete = 0;
						String countBeforeQuery = "select count(*) from contacts";
						PreparedStatement countPsBefore = conn.prepareStatement(countBeforeQuery);
						ResultSet countRsBefore = countPsBefore.executeQuery();

						if (countRsBefore.next()) {
							countBeforeDelete = countRsBefore.getInt(1);
							System.out.println("Total number of rows before delete = " + countBeforeDelete);
						} else {
							System.out.println("Unable to fetch count of rows before delete.");
						}

						// print all rows before delete
						String sqlQueryBefore = "select * from contacts";
						PreparedStatement psBefore = conn.prepareStatement(sqlQueryBefore);
						ResultSet resultSetBefore = psBefore.executeQuery();

						System.out.println(
								"Table People From Contact Table Before Delete. \n*****************************\n");
						System.out.println("| ID | Name | EMAIL | Fees |");
						System.out.println("***********************************************************");

						boolean hasRowsBefore = false;
						while (resultSetBefore.next()) {
							hasRowsBefore = true;
							System.out.println(resultSetBefore.getInt(1) + " | " + resultSetBefore.getString(2) + " | "
									+ resultSetBefore.getString(3) + " | " + resultSetBefore.getFloat(4));
						}

						if (hasRowsBefore == false) {
							System.out.println("No rows present in contacts table before delete.");
						}

						// check whether entered id is present
						String presqlQuery = "select * from contacts where id = ?";
						PreparedStatement preps = conn.prepareStatement(presqlQuery);
						preps.setInt(1, id);
						ResultSet rs = preps.executeQuery();

						boolean userFound = false;

						while (rs.next() == true) {
							userFound = true;
							try {
								String sqlQuery = "delete from contacts where id = ?";
								PreparedStatement ps = conn.prepareStatement(sqlQuery);
								ps.setInt(1, id);

								int deletedRows = ps.executeUpdate();

								if (deletedRows > 0) {
									System.out.println("Deleted the user from contact table successfully.");
								} else {
									System.out.println("Delete query executed, but no row was deleted.");
								}
							} catch (Exception ex3) {
								ex3.printStackTrace();
								System.out.println("Unable to delete user with given id.");
							}
						}

						if (userFound == false) {
							System.out.println("Id not present in contact table. Unable to delete user.");
						}

						// count rows after delete
						int countAfterDelete = 0;
						String countAfterQuery = "select count(*) from contacts";
						PreparedStatement countPsAfter = conn.prepareStatement(countAfterQuery);
						ResultSet countRsAfter = countPsAfter.executeQuery();

						if (countRsAfter.next()) {
							countAfterDelete = countRsAfter.getInt(1);
							System.out.println("Total number of rows after delete = " + countAfterDelete);
						} else {
							System.out.println("Unable to fetch count of rows after delete.");
						}

						// print all rows after delete
						String sqlQuery1 = "select * from contacts";
						PreparedStatement ps1 = conn.prepareStatement(sqlQuery1);
						ResultSet resultSet = ps1.executeQuery();
						System.out.println(
								"Table People From Contact Table After Delete. \n*****************************\n");

						System.out.println("| ID | Name | EMAIL | Fees |");
						System.out.println("***********************************************************");

						boolean hasRowsAfter = false;
						while (resultSet.next()) {
							hasRowsAfter = true;
							System.out.println(resultSet.getInt(1) + " | " + resultSet.getString(2) + " | "
									+ resultSet.getString(3) + " | " + resultSet.getFloat(4));
						}

						if (hasRowsAfter == false) {
							System.out.println("No rows present in contacts table after delete.");
						}

					} catch (Exception ex2) {
						ex2.printStackTrace();
						System.out.println("Id not present, Unable to fetch user by id or perform delete operation.");
					}

				} catch (Exception ex2) {
					ex2.printStackTrace();
					System.out.println("Unable to take input or perform delete process.");
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