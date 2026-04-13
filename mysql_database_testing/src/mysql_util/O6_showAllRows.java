package mysql_util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class O6_showAllRows {

	public static void showAllRows() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = ConnectToMysqlDatabase.connectToMySql();

			if (conn != null) {

				String sqlQuery = "SELECT * FROM students";
				ps = conn.prepareStatement(sqlQuery);
				rs = ps.executeQuery();

				while (rs.next()) {
					System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getString("email")
							+ " | " + rs.getDouble("fees"));
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Unable to fetch records.");
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
		showAllRows();
	}
}