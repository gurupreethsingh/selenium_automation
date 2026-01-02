
package mysql_database_testing;
import java.sql.*;

public class O4ReadingFromTableAdmin {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem", "root", "root");
            if (conn == null) {
                System.out.println("Unable to connect to MySQL");
            } else {
                System.out.println("Connection successful");
                System.out.println("Displaying everything from admin table");
                PreparedStatement ps = conn.prepareStatement("select * from admin");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
                }
            }
        } 
        catch (Exception ex) {
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
