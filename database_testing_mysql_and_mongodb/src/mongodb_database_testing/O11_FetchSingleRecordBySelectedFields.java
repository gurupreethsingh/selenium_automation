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

public class O11_FetchSingleRecordBySelectedFields {

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
                            System.out.print("Enter the collection name to FETCH a single record: ");
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

                            // Convert to list for display
                            List<String> existingFields = new ArrayList<String>();
                            for (String s : existingFieldSet) {
                                existingFields.add(s);
                            }

                            if (existingFields.size() == 0) {
                                System.out.println("No user-defined fields found in this collection to filter on.");
                                System.out.println("Tip: insert some documents with fields first.");
                                return;
                            }

                            // === Show existing fields (numbered) ===
                            System.out.println("Existing fields in '" + collName + "':");
                            for (int i = 0; i < existingFields.size(); i++) {
                                System.out.println("  " + (i + 1) + ") " + existingFields.get(i));
                            }

                            System.out.print("How many fields do you want to use for filtering (integer >= 1): ");
                            String countStr = sc.nextLine();
                            int filterCount = 0;
                            try {
                                filterCount = Integer.parseInt(countStr.trim());
                            } catch (NumberFormatException nfe) {
                                filterCount = 0;
                            }
                            if (filterCount <= 0) {
                                System.out.println("Invalid number. Exiting.");
                                return;
                            }

                            // Build the query document using selected existing fields
                            Document filter = new Document();
                            int accepted = 0;
                            for (int i = 1; i <= filterCount; i++) {
                                System.out.print("Enter existing FIELD NAME or INDEX #" + i + ": ");
                                String input = sc.nextLine();
                                if (input == null) input = "";
                                input = input.trim();

                                if (input.length() == 0) {
                                    System.out.println("Empty input. Skipping this field.");
                                    continue;
                                }

                                // Resolve input to a valid field name (index or name)
                                String fname = null;

                                // Try as index
                                try {
                                    int idx = Integer.parseInt(input);
                                    if (idx >= 1 && idx <= existingFields.size()) {
                                        fname = existingFields.get(idx - 1);
                                    }
                                } catch (NumberFormatException ignore) {
                                    // Not an integer, fall through to name matching
                                }

                                // Try as name (case-insensitive)
                                if (fname == null) {
                                    for (int k = 0; k < existingFields.size(); k++) {
                                        String candidate = existingFields.get(k);
                                        if (candidate.equalsIgnoreCase(input)) {
                                            fname = candidate; // use canonical case from collection
                                            break;
                                        }
                                    }
                                }

                                if (fname == null) {
                                    System.out.println("No such existing field: " + input + ". Skipping.");
                                    continue;
                                }
                                if ("_id".equals(fname)) {
                                    System.out.println("Field '_id' is reserved. Skipping this field.");
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

                            // === Find ONE document matching the filter ===
                            Document one = collection.find(filter).first();

                            System.out.println();
                            System.out.println("Filter used: " + filter.toJson());
                            if (one != null) {
                                System.out.println("Matched document:");
                                System.out.println(one.toJson());
                            } else {
                                System.out.println("No document matched the given filter.");
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

/*      output 
 
		Connected to MongoDB.
		Enter database name you want to connect to : Test_database
		Successfully connected to database: Test_database
		Collections in database 'Test_database':
		 - contacts
		Total Collections : 1
		Enter the collection name to FETCH a single record: contacts
		Existing fields in 'contacts':
		  1) student_name
		  2) address
		  3) rollnumber
		How many fields do you want to use for filtering (integer >= 1): 1
		Enter existing FIELD NAME or INDEX #1: address
		Enter value for field 'address': Bangalore
		
		Filter used: {"address": "Bangalore"}
		Matched document:
		{"_id": {"$oid": "69075b673b9a64e0641518e0"}, "rollnumber": "1", "student_name": "Ram", "address": "Bangalore"}

*/