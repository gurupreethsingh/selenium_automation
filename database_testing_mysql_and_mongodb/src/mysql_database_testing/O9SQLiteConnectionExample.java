package mysql_database_testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class O9SQLiteConnectionExample {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:/path/to/your/database.db");
            if (connection != null) {
                System.out.println("Connected to the SQLite database.");
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("SQLite JDBC Driver not found.");
        } catch (SQLException e) {
            System.err.println("SQLite connection error: " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("SQLite connection close error: " + e.getMessage());
            }
        }
    }
}