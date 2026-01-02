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

public class O8_InsertNewRecordIntoSelectedCollection 
{
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

                            // === List all collections inside this database ===
                            System.out.println("Collections in database '" + dbName + "':");
                            MongoIterable<String> collNames = db.listCollectionNames();
                            boolean anyCollection = false;
                            int collectionCount = 0;
                            for (String coll : collNames) {
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

                            // === Ask user to choose a collection to work with ===
                            System.out.print("Enter the collection name to INSERT and FETCH records: ");
                            String collName = sc.nextLine();

                            if (collName == null) {
                                System.out.println("Invalid collection name.");
                            } else {
                                collName = collName.trim();
                                if (collName.length() == 0) {
                                    System.out.println("Invalid collection name. It cannot be empty.");
                                } else {
                                    // Check if the entered collection exists
                                    boolean collExists = false;
                                    MongoIterable<String> verifyCollNames = db.listCollectionNames();
                                    for (String c : verifyCollNames) {
                                        if (c.equals(collName)) {
                                            collExists = true;
                                            break;
                                        }
                                    }

                                    if (collExists) {
                                        MongoCollection<Document> collection = db.getCollection(collName);

                                        // === DYNAMIC FIELDS: ask how many fields to create ===
                                        int fieldCount = 0;
                                        System.out.print("How many fields do you want to insert (integer >= 0): ");
                                        String countStr = sc.nextLine();
                                        if (countStr != null) {
                                            countStr = countStr.trim();
                                        }
                                        try {
                                            fieldCount = Integer.parseInt(countStr);
                                            if (fieldCount < 0) {
                                                System.out.println("Field count cannot be negative.");
                                                return;
                                            }
                                        } catch (NumberFormatException nfe) {
                                            System.out.println("Invalid number format for field count.");
                                            return;
                                        }

                                        Document doc = new Document();
                                        int validFields = 0; // track how many valid fields we add

                                        // Loop to collect field name/value pairs
                                        for (int i = 1; i <= fieldCount; i++) {
                                            System.out.print("Enter field" + i + " name: ");
                                            String fname = sc.nextLine();
                                            if (fname == null) fname = "";
                                            fname = fname.trim();
                                            if (fname.length() == 0) {
                                                System.out.println("Field name cannot be empty. Skipping this field.");
                                                continue;
                                            }
                                            if (fname.equals("_id")) {
                                                System.out.println("Field name '_id' is reserved. Skipping this field.");
                                                continue;
                                            }
                                            if (doc.containsKey(fname)) {
                                                System.out.println("Duplicate field name '" + fname + "' ignored.");
                                                continue;
                                            }

                                            System.out.print("Enter value for field '" + fname + "': ");
                                            String fval = sc.nextLine();
                                            if (fval == null) fval = "";
                                            fval = fval.trim();

                                            // store as string to keep it simple (no type parsing)
                                            doc.append(fname, fval);
                                            validFields++;
                                        }

                                        // If user provided zero valid fields, skip insert
                                        if (validFields == 0) {
                                            System.out.println("No valid fields provided. Skipping insert.");
                                        } else {
                                            collection.insertOne(doc);
                                            System.out.println("Inserted one document into '" + collName + "'.");
                                        }

                                        // === Fetch and print documents from the selected collection ===
                                        System.out.println("Fetching documents from collection '" + collName + "':");
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

                                    } else {
                                        System.out.println("Collection not found in database '" + dbName + "': " + collName);
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
	Collections in database 'Test_database':
	 - contacts
	Total Collections : 1
	Enter the collection name to INSERT and FETCH records: contacts
	How many fields do you want to insert (integer >= 0): 3
	Enter field1 name: rollnumber
	Enter value for field 'rollnumber': 1
	Enter field2 name: student_name
	Enter value for field 'student_name': Ram
	Enter field3 name: address
	Enter value for field 'address': Bangalore
	Inserted one document into 'contacts'.
	Fetching documents from collection 'contacts':
	{"_id": {"$oid": "69075b673b9a64e0641518e0"}, "rollnumber": "1", "student_name": "Ram", "address": "Bangalore"}
	
   */
