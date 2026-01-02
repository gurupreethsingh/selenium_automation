package mysql_database_testing;
import java.sql.*;
//displaying all tables in a databases
public class O3ChoosingADatabase {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem", "root", "root");
            if (conn == null) {
                System.out.println("Unable to connect to MySQL");
            } else {
                System.out.println("Successfully connected to MySQL");
                System.out.println("Displaying all the tables in employeemanagementsystem database");
                PreparedStatement ps = conn.prepareStatement("show tables");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    System.out.println(rs.getString(1));
                }
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		finally
		{
			 try {
	                if (conn != null && !conn.isClosed()) {
	                    conn.close();
	                    System.out.println("Connection closed.");
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
		}
    }
}
