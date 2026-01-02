package mysql_database_testing;

import java.sql.*;

public class O2_ShowingAlldatabases {

	public static void main(String[] args)
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
			if(conn==null)
			{
				System.out.println("connection failed");
			}
			else
			{
				System.out.println("connected successfully to my sql database");
				PreparedStatement ps = conn.prepareStatement("show databases");
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					  System.out.println(rs.getString(1));
				}
			}
		}
		catch(Exception ex){
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
