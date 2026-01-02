package mongo_db_testing_shilpa;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoIterable;

public class O2_ListAllDatabases {
	public static void main(String[] args) {
		MongoClient connection = null;
		try 
		{
			connection = MongoClients.create("mongodb://localhost:27017"); // connect

			if (connection != null) 
			{
				System.out.println("Connected to MongoDB and it is reachable.");
				MongoIterable<String> allDatabaseNames = connection.listDatabaseNames();

				boolean databaseFetched = false;
				int count = 0;
				for (String name : allDatabaseNames) {
					System.out.println(" - " + name);
					databaseFetched = true;
					count++;
				}

				if (databaseFetched==false)
				{
					System.out.println("(no databases found)");
				} 
				else 
				{
					System.out.println("Total Databases found : " + count);
				}

			}
			else 
			{
				System.out.println(" unable to connect to mongoDB.");
			}
		}
		catch (Exception ex) 
		{
			System.out.println("unable to connect to mongoDB");
			ex.printStackTrace();
		} 
		finally
		{
			if (connection != null) {
				connection.close();
			}
		}
	}
}
