package mysql_util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class O7_fetchSpecificRows {

	public static void fetchById() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);

		try {
			conn = ConnectToMysqlDatabase.connectToMySql();

			if (conn != null) {

				System.out.print("Enter ID: ");
				int id = sc.nextInt();

				String sqlQuery = "SELECT * FROM students WHERE id = ?";
				ps = conn.prepareStatement(sqlQuery);
				ps.setInt(1, id);

				rs = ps.executeQuery();

				if (rs.next()) {
					System.out.println("Record Found:");
					System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getString("email")
							+ " | " + rs.getDouble("fees"));
				} else {
					System.out.println("No record found.");
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Error fetching record.");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			ConnectToMysqlDatabase.closeConnection(conn);
		}
	}

	public static void main(String[] args) {
		fetchById();
	}
}