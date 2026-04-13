package mysql_util;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class O4_createTable {

	public static void createTable() {

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = ConnectToMysqlDatabase.connectToMySql();

			if (conn != null) {

				String sqlQuery = "CREATE TABLE IF NOT EXISTS students (" + "id INT PRIMARY KEY AUTO_INCREMENT, "
						+ "name VARCHAR(100), " + "email VARCHAR(100), " + "fees DOUBLE)";

				ps = conn.prepareStatement(sqlQuery);
				ps.executeUpdate();

				System.out.println("Table created successfully.");

			} else {
				System.out.println("Database connection failed.");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Unable to create table.");
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
		createTable();
	}
}