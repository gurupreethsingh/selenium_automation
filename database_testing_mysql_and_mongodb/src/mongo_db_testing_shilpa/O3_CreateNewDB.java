package mongo_db_testing_shilpa;

import java.util.Scanner;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class O3_CreateNewDB {
	public static void main(String[] args)
	{
		 MongoClient connection = null;
	        try {
	            connection = MongoClients.create("mongodb://localhost:27017");        // connect

	            if (connection != null) {
	                System.out.println("Connected to MongoDB and it is reachable.");
	                
	                System.out.println("Enter a new database name you want to create");
	                Scanner sc = new Scanner(System.in);
	                String enteredDatabaseName =  sc.nextLine();
	               
	                boolean alreadyExists = false; 
	                
	                MongoIterable<String> allDatabaseNames = connection.listDatabaseNames();
	                
	                for(String eachDatabaseName   :   allDatabaseNames)
	                {
	                	if(enteredDatabaseName.equals(eachDatabaseName))
	                			{
	                		      alreadyExists = true;
	                		      break;
	                			}
	                }
	                
	                
	                if(alreadyExists == false)
	                {
	                	// create new database.
	                	MongoDatabase newdb = connection.getDatabase(enteredDatabaseName);
	                	newdb.createCollection("Dummy_collection");
	                	System.out.println("Database created successfully.");
	                	
	                	
	                	  MongoIterable<String> allDatabaseNames1 = connection.listDatabaseNames();

	                      boolean databaseFetched = false;
	                      int count = 0; 
	                      for (String name : allDatabaseNames1) 
	                      {
	                          System.out.println(" - " + name);
	                          databaseFetched = true;
	                          count++;
	                      }
	                      System.out.println("Total database found " + count);
	                }
	                else
	                {
	                	System.out.println("Database with name "+enteredDatabaseName+" already exists, please give another name. " );
	                }
	                
	                
	                
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


