package mongodb_testing_Anusha;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoIterable;

public class O2_List_all_databases 
{
	public static void main (String[] args)
	{
		 com.mongodb.client.MongoClient connection = null;
	        try {
	            connection = MongoClients.create("mongodb://localhost:27017");        // connect

	            if (connection != null) 
	            {
	                System.out.println("Connected to MongoDB and it is reachable.");  // if connected fetch all databases and print
	                MongoIterable<String> allDatabaseNames = connection.listDatabaseNames();

	                boolean databaseFetched = false; // ASSUMING there is no databases and count =0
	                int count = 0; 
	                
	                
	                for (String eachDataBasename : allDatabaseNames) // database is fetching one by one 
	                {
	                    System.out.println(" - " + eachDataBasename);
	                    count++;
 	                    databaseFetched = true;  //after fetcing database count will increase then databasefetched will be true 
	                   
	                }

	                if (databaseFetched==false) 
	                {
	                    System.out.println("(no databases found)");
	                }
	                else
	                {
	                	System.out.println("Tatal Databases : " + count);
	                }
	            }
	            else
	            {
	                System.out.println("Not Connected ,unable to connect to mongodB.");
	            }
	        } 
	        catch (Exception ex) 
	        {
	            ex.printStackTrace();
	        } 
	        finally 
	        {
	            if (connection != null)
	            	{
	            	connection.close();
	            	}
	        }
	    }
	}


