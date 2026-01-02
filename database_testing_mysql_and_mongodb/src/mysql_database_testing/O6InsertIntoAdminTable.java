package mysql_database_testing;
import java.sql.*;
import java.util.Scanner;

public class O6InsertIntoAdminTable {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem", "root", "root");
            if (conn == null) {
                System.out.println("Unable to connect to MySQL");
            } else {
                System.out.println("Connection successful");
                Scanner sc1 = new Scanner(System.in);
                System.out.println("Enter the username:");
                String username = sc1.next();
                System.out.println("Enter the password:");
                String password = sc1.next();
                PreparedStatement ps = conn.prepareStatement("insert into admin(username, password) values ('" + username + "','" + password + "')");
                int result = ps.executeUpdate();
                if (result > 0) {
                    PreparedStatement ps1 = conn.prepareStatement("select * from admin");
                    ResultSet rs = ps1.executeQuery();
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
                    }
                } else {
                    System.out.println("Unable to insert records");
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

