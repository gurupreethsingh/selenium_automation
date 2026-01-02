package mongodb_testing_Anusha;

import com.mongodb.client.MongoClients;

public class O1_Connect_to_mongodb 
{
	public static void main (String[] args)
	{
		 com.mongodb.client.MongoClient connection = null;
	        try {
	            connection = MongoClients.create("mongodb://localhost:27017");        // clients is the sub class of client

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


