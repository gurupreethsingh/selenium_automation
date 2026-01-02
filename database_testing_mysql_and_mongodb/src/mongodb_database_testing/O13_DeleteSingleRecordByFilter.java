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
import com.mongodb.client.result.DeleteResult;

public class O13_DeleteSingleRecordByFilter {

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

                            System.out.print("Enter the collection name to DELETE a single record: ");
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

                            // Show some existing fields for guidance
                            Set<String> fieldSet = new HashSet<String>();
                            FindIterable<Document> sampleDocs = collection.find().limit(100);
                            MongoCursor<Document> sampleCursor = null;
                            try {
                                sampleCursor = sampleDocs.iterator();
                                while (sampleCursor.hasNext()) {
                                    Document d = sampleCursor.next();
                                    for (String key : d.keySet()) {
                                        if (!"_id".equals(key)) {
                                            fieldSet.add(key);
                                        }
                                    }
                                }
                            } finally {
                                if (sampleCursor != null) sampleCursor.close();
                            }
                            List<String> guidanceFields = new ArrayList<String>();
                            for (String s : fieldSet) {
                                guidanceFields.add(s);
                            }
                            if (guidanceFields.size() > 0) {
                                System.out.println("Some existing fields (for reference):");
                                for (int i = 0; i < guidanceFields.size(); i++) {
                                    System.out.println("  - " + guidanceFields.get(i));
                                }
                            }

                            // Build a filter to find ONE record
                            System.out.print("How many fields will you use to find the record (integer >= 1): ");
                            String countStr = sc.nextLine();
                            int filterCount = 0;
                            try { filterCount = Integer.parseInt(countStr.trim()); } catch (NumberFormatException nfe) { filterCount = 0; }
                            if (filterCount <= 0) {
                                System.out.println("Invalid number. Exiting.");
                                return;
                            }

                            Document filter = new Document();
                            int accepted = 0;
                            for (int i = 1; i <= filterCount; i++) {
                                System.out.print("Enter FIELD NAME #" + i + " to filter by: ");
                                String fname = sc.nextLine();
                                if (fname == null) fname = "";
                                fname = fname.trim();
                                if (fname.length() == 0) {
                                    System.out.println("Field name cannot be empty. Skipping.");
                                    continue;
                                }
                                if ("_id".equals(fname)) {
                                    System.out.println("Field '_id' is reserved. Skipping.");
                                    continue;
                                }
                                if (filter.containsKey(fname)) {
                                    System.out.println("Duplicate filter field '" + fname + "' ignored.");
                                    continue;
                                }

                                System.out.print("Enter value for field '" + fname + "': ");
                                String fval = sc.nextLine();
                                if (fval == null) fval = "";
                                fval = fval.trim();

                                filter.append(fname, fval);
                                accepted++;
                            }

                            if (accepted == 0) {
                                System.out.println("No valid filter fields provided. Exiting.");
                                return;
                            }

                            // Find ONE document first
                            Document one = collection.find(filter).first();
                            System.out.println();
                            System.out.println("Filter used: " + filter.toJson());
                            if (one == null) {
                                System.out.println("No document matched the given filter. Exiting.");
                                return;
                            }

                            System.out.println("Matched document:");
                            System.out.println(one.toJson());

                            // Confirm delete
                            System.out.print("Are you sure you want to DELETE this record? Type YES to confirm: ");
                            String confirm = sc.nextLine();
                            if (confirm == null) confirm = "";
                            confirm = confirm.trim();
                            if (!"YES".equalsIgnoreCase(confirm)) {
                                System.out.println("Delete cancelled.");
                                return;
                            }

                            // Delete by _id to guarantee exactly this record
                            Object id = one.get("_id");
                            DeleteResult dr = collection.deleteOne(new Document("_id", id));

                            System.out.println("Delete acknowledged: " + dr.wasAcknowledged());
                            System.out.println("Deleted count: " + dr.getDeletedCount());

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
	Connected to MongoDB.
	Enter database name you want to connect to : Test_database
	Successfully connected to database: Test_database
	Collections in database 'Test_database':
	 - contacts
	Total Collections : 1
	Enter the collection name to DELETE a single record: contacts
	Some existing fields (for reference):
	  - student_name
	  - address
	  - rollnumber
	How many fields will you use to find the record (integer >= 1): 1
	Enter FIELD NAME #1 to filter by: address
	Enter value for field 'address': Chennai
	
	Filter used: {"address": "Chennai"}
	Matched document:
	{"_id": {"$oid": "69075bcedcfc45cdacf2ed62"}, "student_name": "Rajesh", "address": "Chennai", "rollnumber": "2"}
	Are you sure you want to DELETE this record? Type YES to confirm: YES
	Delete acknowledged: true
	Deleted count: 1
*/
