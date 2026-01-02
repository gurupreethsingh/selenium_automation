package mongo_db_testing_shilpa;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class O1_ConnectToMongoDB {
	public static void main(String[] args)
	{
		 MongoClient connection = null;
	        try {
				//this will connect to mongoDB
	            connection = MongoClients.create("mongodb://localhost:27017");        // connect

	            if (connection != null) {
	                System.out.println("Connected to MongoDB and it is reachable.");
	            } else {
	                System.out.println("Connected, but no databases found.");
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


