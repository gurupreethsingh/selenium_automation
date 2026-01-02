package mongodb_database_testing;

import java.util.Scanner;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.MongoDatabase;

public class O3_CreateNewDatabase_Validated {

    public static void main(String[] args) {
        MongoClient connection = null;
        Scanner sc = null;

        try {
            connection = MongoClients.create("mongodb://localhost:27017");

            if (connection != null)  
            {
                System.out.println("Connected to MongoDB.");

                sc = new Scanner(System.in);
                System.out.print("Enter new MongoDB database name : ");
                String newDbName = sc.nextLine();

                // basic validation
                if (newDbName == null) 
                {
                    System.out.println("Invalid database name.");
                } 
                else {
                    newDbName = newDbName.trim();
                    if (newDbName.length() == 0) 
                    {
                        System.out.println("Invalid database name. It cannot be empty.");
                    } 
                    else 
                    {
                        // check if DB already exists
                        boolean allReadyExists = false;
                        MongoIterable<String> allDbNames = connection.listDatabaseNames();
                        for (String name : allDbNames) {
                            if (name.equals(newDbName)) {
                            	allReadyExists = true;
                                break;
                            }
                        }

                        if (allReadyExists) 
                        {
                            System.out.println("Database already present. Unable to create database with the same name: " + newDbName);
                        } 
                        else 
                        {
                            // create DB by creating an empty collection
                            MongoDatabase db = connection.getDatabase(newDbName);
                            db.createCollection("initial_collection");
                            System.out.println("Database created successfully: " + newDbName);
                            System.out.println("An empty collection 'initial_collection' was created.");
                        }
                    }
                }
            }
            else
            {
                System.out.println("Connection object is null. Could not connect.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (sc != null) {
                sc.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}

/*
 * output 
 * 
 * Connected to MongoDB.
Enter new MongoDB database name : Test_database
Database created successfully: Test_database
An empty collection 'initial_collection' was created.
 * 
 */
