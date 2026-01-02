package mysql_database_testing;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class L10PostgreSQLConnectionExample {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            String url = "jdbc:postgresql://your_host:your_port/your_database";
            String user = "your_username";
            String password = "your_password";

            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Connected to the PostgreSQL database.");
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("PostgreSQL JDBC Driver not found.");
        } catch (SQLException e) {
            System.err.println("PostgreSQL connection error: " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("PostgreSQL connection close error: " + e.getMessage());
            }
        }
    }
}

