package mysql_util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class O1_showAllDatabases {

	public static void displayAllDatabases() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = ConnectToMysqlDatabase.connectToMySql();

			if (conn != null) {
				String sqlQuery = "show databases";
				ps = conn.prepareStatement(sqlQuery);
				rs = ps.executeQuery();

				System.out.println("Displaying all database names:");
				System.out.println("********************************");

				while (rs.next()) {
					System.out.println(rs.getString(1));
				}
			} else {
				System.out.println("Connection to MySQL server failed.");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Unable to fetch database names.");
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

			ConnectToMysqlDatabase.closeConnection(conn);
		}
	}

	public static void main(String[] args) {
		displayAllDatabases();
	}
}