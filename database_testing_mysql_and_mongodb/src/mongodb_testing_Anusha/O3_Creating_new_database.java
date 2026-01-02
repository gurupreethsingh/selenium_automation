package mongodb_testing_Anusha;

import java.util.Scanner;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class O3_Creating_new_database 
{
	public static void main (String[] args)
	{
		 com.mongodb.client.MongoClient connection = null;
	        try {
	            connection = MongoClients.create("mongodb://localhost:27017");        // connect

	            if (connection != null) 
	            {
	                System.out.println("Connected to MongoDB and it is reachable.");  // if connected fetch all databases and print
                   System.out.println("entere a new database name which u want to create");
	                Scanner sc = new Scanner(System.in);
	               String enteredDataBaseName=sc.nextLine();
	                // taken input from user
	                
	                
	                MongoIterable<String> allDatabaseNames = connection.listDatabaseNames();
                    boolean dataBaseAlreadyExists=false;
	                boolean databaseFetched = false; // ASSUMING there is no databases and count =0
	                int count = 0; 
	                
	                
	                for (String eachDataBasename : allDatabaseNames) // database is fetching one by one 
	                {
	                 if(eachDataBasename.equals(enteredDataBaseName))
	                 {
	                	 dataBaseAlreadyExists = true;
	                	 System.out.println("database "+ enteredDataBaseName +" already exists give other name ");
	                	 break;
	                 }
	                 else
	                 {
	                	 // create DB by creating an empty collection
                         MongoDatabase db = connection.getDatabase(enteredDataBaseName ); 
                         db.createCollection("initial_collection");
                         System.out.println("Database created successfully: " + enteredDataBaseName );
                         System.out.println("An empty collection 'initial_collection' was created."); 
                         // after creating  a new database lets print all database and check new data abse is created or not
                         for( String eachDBnames:allDatabaseNames)
                         {
                        	 System.out.println(eachDBnames);
                         }
	                 }
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


