package mongodb_database_testing;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class O1_ConnectToMongodbDatabase {

	public static void main(String[] args)
	{
        MongoClient connection = null;
        try {
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

// output 

//Connected to MongoDB and it is reachable.