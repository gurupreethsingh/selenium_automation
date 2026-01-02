package mongodb_database_testing;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

public class O9_SelectCollection_InsertExistingOrNewFields {

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
                            System.out.print("Enter the collection name to INSERT records: ");
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

                            // === Discover EXISTING field names by scanning some documents ===
                            Set<String> existingFieldSet = new HashSet<String>();
                            FindIterable<Document> sampleDocs = collection.find().limit(100); // sample up to 100 docs
                            MongoCursor<Document> sampleCursor = null;
                            try {
                                sampleCursor = sampleDocs.iterator();
                                while (sampleCursor.hasNext()) {
                                    Document d = sampleCursor.next();
                                    for (String key : d.keySet()) {
                                        if (!"_id".equals(key)) {
                                            existingFieldSet.add(key);
                                        }
                                    }
                                }
                            } finally {
                                if (sampleCursor != null) sampleCursor.close();
                            }

                            // Convert set to a displayable list
                            List<String> existingFields = new ArrayList<String>();
                            for (String s : existingFieldSet) {
                                existingFields.add(s);
                            }

                            // === Show mode options ===
                            System.out.println();
                            System.out.println("Choose insert mode:");
                            System.out.println("  1) Use EXISTING fields");
                            System.out.println("  2) Create NEW fields");
                            System.out.print("Enter choice (1 or 2): ");
                            String choiceStr = sc.nextLine();
                            int choice = 0;
                            try {
                                choice = Integer.parseInt(choiceStr.trim());
                            } catch (Exception e) {
                                choice = 0;
                            }

                            if (choice == 1) {
                                // ---------- EXISTING FIELDS MODE (prompt by field name) ----------
                                if (existingFields.size() == 0) {
                                    System.out.println("No existing fields found in collection. Switch to NEW fields mode.");
                                    return;
                                }

                                System.out.println("Existing fields in '" + collName + "':");
                                for (int i = 0; i < existingFields.size(); i++) {
                                    System.out.println("  - " + existingFields.get(i));
                                }

                                Document doc = new Document();
                                int validFields = 0;

                                // Ask values using the actual field names; blank = skip
                                for (int i = 0; i < existingFields.size(); i++) {
                                    String fname = existingFields.get(i);
                                    System.out.print("Enter value for field '" + fname + "' (leave blank to skip): ");
                                    String fval = sc.nextLine();
                                    if (fval == null) fval = "";
                                    fval = fval.trim();
                                    if (fval.length() == 0) {
                                        continue; // skip empty
                                    }
                                    doc.append(fname, fval);
                                    validFields++;
                                }

                                if (validFields == 0) {
                                    System.out.println("No values provided for existing fields. Skipping insert.");
                                } else {
                                    collection.insertOne(doc);
                                    System.out.println("Inserted one document into '" + collName + "' using EXISTING fields.");
                                }
                            }
                            else if (choice == 2) {
                                // ---------- NEW FIELDS MODE (no _source key) ----------
                                Document doc = new Document();

                                System.out.print("How many NEW fields do you want to create (integer >= 1): ");
                                String countStr = sc.nextLine();
                                int fieldCount = 0;
                                try {
                                    fieldCount = Integer.parseInt(countStr.trim());
                                } catch (NumberFormatException nfe) {
                                    fieldCount = 0;
                                }

                                if (fieldCount <= 0) {
                                    System.out.println("Nothing to insert. Exiting.");
                                    return;
                                }

                                int validFields = 0;
                                for (int i = 1; i <= fieldCount; i++) {
                                    System.out.print("Enter new field" + i + " name: ");
                                    String fname = sc.nextLine();
                                    if (fname == null) fname = "";
                                    fname = fname.trim();

                                    if (fname.length() == 0) {
                                        System.out.println("Field name cannot be empty. Skipping this field.");
                                        continue;
                                    }
                                    if ("_id".equals(fname)) {
                                        System.out.println("Field '_id' is reserved. Skipping this field.");
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

                                    doc.append(fname, fval);
                                    validFields++;
                                }

                                if (validFields == 0) {
                                    System.out.println("No valid fields provided. Skipping insert.");
                                } else {
                                    collection.insertOne(doc);
                                    System.out.println("Inserted one document into '" + collName + "' using NEW fields.");
                                }
                            }
                            else {
                                System.out.println("Invalid choice. Exiting.");
                                return;
                            }

                            // === Fetch and print documents from the selected collection ===
                            System.out.println();
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
	Enter the collection name to INSERT records: contacts
	
	Choose insert mode:
	  1) Use EXISTING fields
	  2) Create NEW fields
	Enter choice (1 or 2): 1
	Existing fields in 'contacts':
	  - student_name
	  - address
	  - rollnumber
	Enter value for field 'student_name' (leave blank to skip): Rajesh
	Enter value for field 'address' (leave blank to skip): Chennai
	Enter value for field 'rollnumber' (leave blank to skip): 2
	Inserted one document into 'contacts' using EXISTING fields.
	
	Fetching documents from collection 'contacts':
	{"_id": {"$oid": "69075b673b9a64e0641518e0"}, "rollnumber": "1", "student_name": "Ram", "address": "Bangalore"}
	{"_id": {"$oid": "69075bcedcfc45cdacf2ed62"}, "student_name": "Rajesh", "address": "Chennai", "rollnumber": "2"}
  
 * */	 

