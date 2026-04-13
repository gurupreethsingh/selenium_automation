
package mysql_util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class O3_showAllTablesFromSelectedDatabase {

	public static void displayAllTables() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// Step 1: select database dynamically

			conn = ConnectToMysqlDatabase.connectToMySql();

			if (conn != null) {

				String sqlQuery = "show tables";
				ps = conn.prepareStatement(sqlQuery);
				rs = ps.executeQuery();

				System.out.println("\nDisplaying all tables from selected database:");
				System.out.println("**********************************************");

				boolean hasTables = false;

				while (rs.next()) {
					hasTables = true;
					System.out.println(rs.getString(1));
				}
				System.out.println("**********************************************");

				if (!hasTables) {
					System.out.println("No tables found in this database.");
				}

			} else {
				System.out.println("Database connection failed.");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Unable to fetch tables.");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Step 3: close connection using utility
			ConnectToMysqlDatabase.closeConnection(conn);
		}
	}

	public static void main(String[] args) {
		displayAllTables();
	}

}
