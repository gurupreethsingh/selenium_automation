package mysql_database_testing;
import java.sql.*;
import java.util.Scanner;

public class O7UpdatingRecords {
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
                System.out.println("Enter the new username:");
                String username = sc1.next();
                System.out.println("Enter the new password:");
                String password = sc1.next();
                System.out.println("Enter the id of the user you want to update:");
                int id = sc1.nextInt();
                PreparedStatement ps = conn.prepareStatement("update admin set username = '" + username + "', password = '" + password + "' where id = '" + id + "'");
                int result = ps.executeUpdate();
                if (result > 0) {
                    System.out.println("Records successfully updated");
                    PreparedStatement ps1 = conn.prepareStatement("select * from admin where id = '" + id + "'");
                    ResultSet rs = ps1.executeQuery();
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
                    }
                } else {
                    System.out.println("Unable to update records");
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
