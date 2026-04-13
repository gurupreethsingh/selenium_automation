package mysql_util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class O8_updateValues {

	public static void updateValues() {

		Connection conn = null;
		PreparedStatement ps = null;
		Scanner sc = new Scanner(System.in);

		try {
			conn = ConnectToMysqlDatabase.connectToMySql();

			if (conn != null) {

				System.out.print("Enter ID to update: ");
				int id = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter new name: ");
				String name = sc.nextLine();

				String sqlQuery = "UPDATE students SET name = ? WHERE id = ?";
				ps = conn.prepareStatement(sqlQuery);
				ps.setString(1, name);
				ps.setInt(2, id);

				int rows = ps.executeUpdate();

				if (rows > 0) {
					System.out.println("Record updated successfully.");
				} else {
					System.out.println("No record found with given ID.");
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Unable to update record.");
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
		updateValues();
	}
}