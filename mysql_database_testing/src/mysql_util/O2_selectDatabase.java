package mysql_util;

import java.sql.Connection;

public class O2_selectDatabase {

	public static void selectDatabaseAndConfirm() {

		Connection conn = null;

		try {
			conn = ConnectToMysqlDatabase.connectToMySql();

			if (conn != null) {
				System.out.println("****************************************");
				System.out.println("You have successfully selected the database.");
				System.out.println("Now you can perform operations on this database.");
				System.out.println("****************************************");
			} else {
				System.out.println("Database selection failed.");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Error while selecting database.");
		} finally {
			ConnectToMysqlDatabase.closeConnection(conn);
		}
	}

	public static void main(String[] args) {
		selectDatabaseAndConfirm();
	}
}