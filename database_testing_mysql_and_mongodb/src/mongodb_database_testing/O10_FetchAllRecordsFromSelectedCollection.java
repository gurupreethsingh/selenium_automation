package mongodb_database_testing;

import java.util.Scanner;

import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

public class O10_FetchAllRecordsFromSelectedCollection {

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
                        // === Verify DB exists ===
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
                            db.listCollectionNames().first(); // light touch
                            System.out.println("Successfully connected to database: " + dbName);

                            // === List collections ===
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

                            // === Choose collection ===
                            System.out.print("Enter the collection name to FETCH records: ");
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

                            MongoCollection<Document> collection = db.getCollection(collName);

                            // === COUNT total records ===
                            long total = 0L;
                            try {
                                total = collection.countDocuments();
                            } catch (Exception e) {
                                total = -1L; // just in case
                            }

                            // === FETCH and print all documents ===
                            System.out.println();
                            System.out.println("Fetching all documents from collection '" + collName + "':");
                            FindIterable<Document> docs = collection.find();
                            MongoCursor<Document> cursor = null;
                            boolean anyDoc = false;
                            try {
                                cursor = docs.iterator();
                                while (cursor.hasNext()) {
                                    Document d = cursor.next();
                                    System.out.println(d.toJson());
                                    anyDoc = true;
                                }
                            } finally {
                                if (cursor != null) cursor.close();
                            }

                            if (!anyDoc) {
                                System.out.println(" (no documents found)");
                            }

                            // Print total count
                            if (total >= 0) {
                                System.out.println("Total records in '" + collName + "': " + total);
                            } else {
                                System.out.println("Total records in '" + collName + "': (count unavailable)");
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

/*
	output 
	
	Connected to MongoDB.
	Enter database name you want to connect to : Test_database
	Successfully connected to database: Test_database
	Collections in database 'Test_database':
	 - contacts
	Total Collections : 1
	Enter the collection name to FETCH records: contacts
	
	Fetching all documents from collection 'contacts':
	{"_id": {"$oid": "69075b673b9a64e0641518e0"}, "rollnumber": "1", "student_name": "Ram", "address": "Bangalore"}
	{"_id": {"$oid": "69075bcedcfc45cdacf2ed62"}, "student_name": "Rajesh", "address": "Chennai", "rollnumber": "2"}
	Total records in 'contacts': 2

*/
