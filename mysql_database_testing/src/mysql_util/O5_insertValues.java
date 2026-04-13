package mysql_util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class O5_insertValues {

	public static void insertValues() {

		Connection conn = null;
		PreparedStatement ps = null;
		Scanner sc = new Scanner(System.in);

		try {
			conn = ConnectToMysqlDatabase.connectToMySql();

			if (conn != null) {

				System.out.print("Enter name: ");
				String name = sc.nextLine();

				System.out.print("Enter email: ");
				String email = sc.nextLine();

				System.out.print("Enter fees: ");
				double fees = sc.nextDouble();

				String sqlQuery = "INSERT INTO students(name, email, fees) VALUES (?, ?, ?)";

				ps = conn.prepareStatement(sqlQuery);
				ps.setString(1, name);
				ps.setString(2, email);
				ps.setDouble(3, fees);

				ps.executeUpdate();

				System.out.println("Record inserted successfully.");

			}

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Unable to insert values.");
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			ConnectToMysqlDatabase.closeConnection(conn);
		}
	}

	public static void main(String[] args) {
		insertValues();
	}
}