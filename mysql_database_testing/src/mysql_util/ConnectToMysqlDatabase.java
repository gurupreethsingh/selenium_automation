package mysql_util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class ConnectToMysqlDatabase {

	public static final String MYSQL_HOST = "localhost";
	public static final String MYSQL_PORT = "3306";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "";

	public static final String MYSQL_SERVER_URL = "jdbc:mysql://" + MYSQL_HOST + ":" + MYSQL_PORT + "/";
	public static final String JDBC_OPTIONS = "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

	private static final Scanner SCANNER = new Scanner(System.in);

	private ConnectToMysqlDatabase() {
	}

	// This method will ALWAYS ask user for database name
	public static Connection connectToMySql() {
		System.out.println("Enter a database name (press Enter to connect only to MySQL server):");
		String databaseName = SCANNER.nextLine();
		return connectToMySql(databaseName);
	}

	// This method connects directly using the given database name
	public static Connection connectToMySql(String databaseName) {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String sanitizedDatabaseName = null;
			String fullPath;

			if (databaseName == null || databaseName.trim().isEmpty()) {
				fullPath = MYSQL_SERVER_URL + JDBC_OPTIONS;
			} else {
				sanitizedDatabaseName = databaseName.trim();
				fullPath = MYSQL_SERVER_URL + sanitizedDatabaseName + JDBC_OPTIONS;
			}

			conn = DriverManager.getConnection(fullPath, USERNAME, PASSWORD);

			if (conn != null && !conn.isClosed()) {
				if (sanitizedDatabaseName == null) {
					System.out.println("Connection established successfully to the MySQL server.");
				} else {
					System.out.println(
							"Connection established successfully to the MySQL database: " + sanitizedDatabaseName);
				}
			} else {
				if (sanitizedDatabaseName == null) {
					System.out.println("Connection could not be established to the MySQL server.");
				} else {
					System.out.println(
							"Connection could not be established to the MySQL database: " + sanitizedDatabaseName);
				}
			}

		} catch (SQLException ex) {
			handleSQLException(ex, databaseName);
		} catch (ClassNotFoundException ex) {
			System.out.println("MySQL JDBC Driver was not found in the project build path.");
		} catch (Exception ex) {
			System.out.println("An unexpected error occurred while attempting to connect to MySQL.");
			System.out.println("Error details: " + ex.getMessage());
		}

		return conn;
	}

	private static void handleSQLException(SQLException ex, String databaseName) {
		String sanitizedDatabaseName = (databaseName == null) ? "" : databaseName.trim();
		String errorMessage = ex.getMessage();

		if (errorMessage != null) {
			String lowerMessage = errorMessage.toLowerCase();

			if (lowerMessage.contains("unknown database")) {
				System.out.println(
						"Connection failed: The specified database '" + sanitizedDatabaseName + "' does not exist.");
				System.out.println("Please verify the database name and try again.");
			} else if (lowerMessage.contains("access denied")) {
				System.out.println("Connection failed: Access was denied by the MySQL server.");
				System.out.println("Please verify the username and password.");
			} else if (lowerMessage.contains("communications link failure")
					|| lowerMessage.contains("connection refused") || lowerMessage.contains("could not connect")) {
				System.out.println("Connection failed: Unable to reach the MySQL server.");
				System.out.println("Please ensure the MySQL service is running and the host/port are correct.");
			} else if (lowerMessage.contains("unknown host")) {
				System.out.println("Connection failed: The specified MySQL host could not be resolved.");
				System.out.println("Please verify the host name in the connection settings.");
			} else {
				if (sanitizedDatabaseName.isEmpty()) {
					System.out.println("Connection failed while connecting to the MySQL server.");
				} else {
					System.out.println(
							"Connection failed while connecting to the MySQL database: " + sanitizedDatabaseName);
				}
				System.out.println("SQL Error: " + ex.getMessage());
			}
		} else {
			System.out.println("Connection failed due to an unknown SQL error.");
		}
	}

	public static void closeConnection(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
				System.out.println("Database connection closed successfully.");
			}
		} catch (SQLException ex) {
			System.out.println("Unable to close the database connection properly.");
			System.out.println("SQL Error: " + ex.getMessage());
		}
	}
}