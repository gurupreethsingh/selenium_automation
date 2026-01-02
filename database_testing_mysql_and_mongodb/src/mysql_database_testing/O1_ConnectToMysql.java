package mysql_database_testing;

import java.sql.*;

public class O1_ConnectToMysql {

	public static void main(String[] args)
	{
		Connection conn = null;
		try
		{
			// try to connect mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
			if(conn!=null)
			{
				System.out.println("connected successfully to my sql database");
			}
			else
			{
				System.out.println("connection failed");
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
