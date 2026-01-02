package mongo_db_testing_shilpa;

import java.util.Scanner;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class O3_CreatingNewDBs {
	public static void main(String[] args) {
		MongoClient connection = null;
		try 
		{
			connection = MongoClients.create("mongodb://localhost:27017"); // connect

			if (connection != null) 
			{
				System.out.println("Connected to MongoDB and it is reachable.");
				
				
				System.out.println("enter a new database name you want to create");
				Scanner sc=new Scanner(System.in);
				String enteredDBSName=sc.nextLine();
				
				
				MongoIterable<String> allDatabaseNames = connection.listDatabaseNames();

				boolean databaseFetched = false;
				int count = 0;
				boolean databaseAlreadyExists=false;
				
				for (String eachDatabaseName : allDatabaseNames)
				{
					if(enteredDBSName.equals(eachDatabaseName))
					{
						databaseAlreadyExists=true;
						System.out.println("Database "+enteredDBSName+" already exists enter another name");
						 break;
					}
					
					
				}
				MongoDatabase db = connection.getDatabase(enteredDBSName);
                db.createCollection("initial_collection");
                
//                System.out.println("Database created successfully: " + enteredDBSName);
//                System.out.println("An empty collection 'initial_collection' was created.");
    			boolean newdatabaseFetched = false;
    			int newCount=0;
				  for(String eachDBSName:allDatabaseNames)
                  {
                 	 System.out.println(eachDBSName);
                 	newdatabaseFetched = true;
                 	newCount++;
                  }

				if (newdatabaseFetched==false)
				{
					System.out.println("(no databases found)");
				} 
				else 
				{
					System.out.println("Total Databases found : " + newCount);
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
