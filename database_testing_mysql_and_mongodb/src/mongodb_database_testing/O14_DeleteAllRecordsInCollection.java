package mongodb_database_testing;

import java.util.Scanner;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;

public class O14_DeleteAllRecordsInCollection {

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
                        boolean databaseNameExists = false;
                        MongoIterable<String> allDbNames = connection.listDatabaseNames();
                        for (String name : allDbNames) {
                            if (name.equals(dbName)) {
                                databaseNameExists = true;
                                break;
                            }
                        }

                        if (databaseNameExists) {
                            MongoDatabase db = connection.getDatabase(dbName);
                            db.listCollectionNames().first();
                            System.out.println("Successfully connected to database: " + dbName);

                            System.out.println("Collections in database '" + dbName + "':");
                            MongoIterable<String> collNamesIter = db.listCollectionNames();
                            boolean anyCollection = false;
                            int collectionCount = 0;
                            for (String coll : collNamesIter) {
                                System.out.println(" - " + coll);
                                anyCollection = true;
                                collectionCount++;
                            }
                            if (!anyCollection) {
                                System.out.println(" (no collections found)");
                                return;
                            } else {
                                System.out.println("Total Collections : " + collectionCount);
                            }

                            System.out.print("Enter the collection name to DELETE ALL records: ");
                            String collName = sc.nextLine();
                            if (collName == null) {
                                System.out.println("Invalid collection name.");
                                return;
                            }
                            collName = collName.trim();
                            if (collName.length() == 0) {
                                System.out.println("Invalid collection name. It cannot be empty.");
                                return;
                            }

                            boolean collExists = false;
                            MongoIterable<String> verifyCollNames = db.listCollectionNames();
                            for (String c : verifyCollNames) {
                                if (c.equals(collName)) {
                                    collExists = true;
                                    break;
                                }
                            }
                            if (!collExists) {
                                System.out.println("Collection not found in database '" + dbName + "': " + collName);
                                return;
                            }

                            MongoCollection<org.bson.Document> collection = db.getCollection(collName);

                            // Confirm dangerous operation
                            System.out.println("WARNING: This will DELETE ALL records from collection '" + collName + "'.");
                            System.out.print("Type I_UNDERSTAND to proceed: ");
                            String confirm = sc.nextLine();
                            if (confirm == null) confirm = "";
                            confirm = confirm.trim();
                            if (!"I_UNDERSTAND".equalsIgnoreCase(confirm)) {
                                System.out.println("Operation cancelled.");
                                return;
                            }

                            // Delete all documents
                            DeleteResult dr = collection.deleteMany(new Document());

                            System.out.println("Delete acknowledged: " + dr.wasAcknowledged());
                            System.out.println("Total documents deleted: " + dr.getDeletedCount());

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
            if (sc != null) sc.close();
            if (connection != null) connection.close();
        }
    }
}

/*
	OUTPUT
	 
	Connected to MongoDB.
	Enter database name you want to connect to : Test_database
	Successfully connected to database: Test_database
	Collections in database 'Test_database':
	 - contacts
	Total Collections : 1
	Enter the collection name to DELETE ALL records: contacts
	WARNING: This will DELETE ALL records from collection 'contacts'.
	Type I_UNDERSTAND to proceed: I_UNDERSTAND
	Delete acknowledged: true
	Total documents deleted: 1
	
 * */
