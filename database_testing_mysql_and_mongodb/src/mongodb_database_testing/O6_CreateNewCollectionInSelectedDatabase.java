package mongodb_database_testing;

import java.util.Scanner;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.MongoDatabase;

public class O6_CreateNewCollectionInSelectedDatabase {

    public static void main(String[] args) {
        MongoClient connection = null;
        Scanner sc = null;

        try {
            connection = MongoClients.create("mongodb://localhost:27017");

            if (connection != null)
            {
                System.out.println("Connected to MongoDB.");

                sc = new Scanner(System.in);
                System.out.print("Enter database name you want to connect to : ");
                String dbName = sc.nextLine();

                if (dbName == null) {
                    System.out.println("Invalid database name.");
                } else {
                    dbName = dbName.trim();
                    if (dbName.length() == 0) {
                        System.out.println("Invalid database name. It cannot be empty.");
                    } else {
                        // === Verify the DB actually exists ===
                        boolean databaseNameExists = false;
                        MongoIterable<String> allDbNames = connection.listDatabaseNames();
                        for (String name : allDbNames) {
                            if (name.equals(dbName)) {
                            	databaseNameExists = true;
                                break;
                            }
                        }

                        if (databaseNameExists) {
                            // Connect to the selected database
                            MongoDatabase db = connection.getDatabase(dbName);
                            db.listCollectionNames().first(); // light touch
                            System.out.println("Successfully connected to database: " + dbName);

                            // === Ask for new collection name ===
                            System.out.print("Enter NEW collection name to create: ");
                            String collName = sc.nextLine();

                            if (collName == null) {
                                System.out.println("Invalid collection name.");
                            } else {
                                collName = collName.trim();
                                if (collName.length() == 0) {
                                    System.out.println("Invalid collection name. It cannot be empty.");
                                } else {
                                    // Check if collection already exists
                                    boolean collExists = false;
                                    MongoIterable<String> collNames = db.listCollectionNames();
                                    for (String c : collNames) {
                                        if (c.equals(collName)) {
                                            collExists = true;
                                            break;
                                        }
                                    }

                                    if (collExists) {
                                        System.out.println("Collection already present. Unable to create collection with the same name: " + collName);
                                    } else {
                                        // Create the collection
                                        db.createCollection(collName);
                                        System.out.println("Collection created successfully: " + collName);
                                    }
                                }
                            }
                        } else {
                            System.out.println("Database not found: " + dbName);
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

/*  output 
 
	Connected to MongoDB.
	Enter database name you want to connect to : Test_database
	Successfully connected to database: Test_database
	Enter NEW collection name to create: contacts
	Collection created successfully: contacts
 * */
