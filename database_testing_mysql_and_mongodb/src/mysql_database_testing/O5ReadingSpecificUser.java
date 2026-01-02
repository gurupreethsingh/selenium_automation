package mysql_database_testing;
import java.sql.*;
import java.util.Scanner;

public class O5ReadingSpecificUser {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem", "root", "root");
            if (conn == null) {
                System.out.println("Unable to connect to MySQL");
            } else {
                System.out.println("Connection successful");
                System.out.println("Displaying specific user from admin table");
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the id of the user you want to see:");
                int id = sc.nextInt();
                PreparedStatement ps = conn.prepareStatement("select * from admin where id = '" + id + "'");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
                }
            }
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

