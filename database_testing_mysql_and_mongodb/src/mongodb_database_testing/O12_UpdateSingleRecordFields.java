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
import com.mongodb.client.result.UpdateResult;

public class O12_UpdateSingleRecordFields {

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

                            System.out.print("Enter the collection name to UPDATE a single record: ");
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

                            Set<String> guidanceFieldSet = new HashSet<String>();
                            FindIterable<Document> sampleDocs = collection.find().limit(100);
                            MongoCursor<Document> sampleCursor = null;
                            try {
                                sampleCursor = sampleDocs.iterator();
                                while (sampleCursor.hasNext()) {
                                    Document d = sampleCursor.next();
                                    for (String key : d.keySet()) {
                                        if (!"_id".equals(key)) {
                                            guidanceFieldSet.add(key);
                                        }
                                    }
                                }
                            } finally {
                                if (sampleCursor != null) sampleCursor.close();
                            }
                            List<String> guidanceFields = new ArrayList<String>();
                            for (String s : guidanceFieldSet) {
                                guidanceFields.add(s);
                            }

                            if (guidanceFields.size() > 0) {
                                System.out.println("Some existing fields in this collection (for reference):");
                                for (int i = 0; i < guidanceFields.size(); i++) {
                                    System.out.println("  - " + guidanceFields.get(i));
                                }
                            }

                            System.out.print("How many fields will you use to find the record (integer >= 1): ");
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

                            Document filter = new Document();
                            int accepted = 0;
                            for (int i = 1; i <= filterCount; i++) {
                                System.out.print("Enter FIELD NAME #" + i + " to filter by: ");
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

                            Document one = collection.find(filter).first();

                            System.out.println();
                            System.out.println("Filter used: " + filter.toJson());
                            if (one == null) {
                                System.out.println("No document matched the given filter. Exiting.");
                                return;
                            }

                            System.out.println("Matched document (before update):");
                            System.out.println(one.toJson());

                            List<String> recordFields = new ArrayList<String>();
                            for (String key : one.keySet()) {
                                if (!"_id".equals(key)) {
                                    recordFields.add(key);
                                }
                            }

                            if (recordFields.size() == 0) {
                                System.out.println("The matched record has no updatable user fields.");
                                return;
                            }

                            System.out.println();
                            System.out.println("Choose update mode:");
                            System.out.println("  1) Update SELECTED fields");
                            System.out.println("  2) Update ALL fields");
                            System.out.print("Enter choice (1 or 2): ");
                            String modeStr = sc.nextLine();
                            int mode = 0;
                            try {
                                mode = Integer.parseInt(modeStr.trim());
                            } catch (Exception e) {
                                mode = 0;
                            }

                            Document setDoc = new Document();

                            if (mode == 1) {
                                System.out.println("Fields in matched record:");
                                for (int i = 0; i < recordFields.size(); i++) {
                                    String f = recordFields.get(i);
                                    Object currentVal = one.get(f);
                                    System.out.println("  " + (i + 1) + ") " + f + " (current: " + currentVal + ")");
                                }

                                System.out.print("How many fields do you want to update (integer >= 1): ");
                                String selCntStr = sc.nextLine();
                                int selCnt = 0;
                                try {
                                    selCnt = Integer.parseInt(selCntStr.trim());
                                } catch (NumberFormatException nfe) {
                                    selCnt = 0;
                                }
                                if (selCnt <= 0) {
                                    System.out.println("Nothing to update. Exiting.");
                                    return;
                                }

                                for (int i = 1; i <= selCnt; i++) {
                                    System.out.print("Enter FIELD NAME or INDEX #" + i + " to update: ");
                                    String input = sc.nextLine();
                                    if (input == null) input = "";
                                    input = input.trim();

                                    String fname = null;

                                    try {
                                        int idx = Integer.parseInt(input);
                                        if (idx >= 1 && idx <= recordFields.size()) {
                                            fname = recordFields.get(idx - 1);
                                        }
                                    } catch (NumberFormatException ignore) {}

                                    if (fname == null) {
                                        for (int k = 0; k < recordFields.size(); k++) {
                                            String candidate = recordFields.get(k);
                                            if (candidate.equalsIgnoreCase(input)) {
                                                fname = candidate;
                                                break;
                                            }
                                        }
                                    }

                                    if (fname == null) {
                                        System.out.println("No such field in this record: " + input + ". Skipping.");
                                        continue;
                                    }

                                    Object currentVal = one.get(fname);
                                    System.out.print("Enter NEW value for field '" + fname + "' (current: " + currentVal + "): ");
                                    String newVal = sc.nextLine();
                                    if (newVal == null) newVal = "";
                                    newVal = newVal.trim();
                                    setDoc.append(fname, newVal);
                                }

                            } else if (mode == 2) {
                                System.out.println("Updating ALL fields in the matched record.");
                                for (int i = 0; i < recordFields.size(); i++) {
                                    String fname = recordFields.get(i);
                                    Object currentVal = one.get(fname);
                                    System.out.print("Enter NEW value for field '" + fname + "' (current: " + currentVal + ", leave blank to keep): ");
                                    String newVal = sc.nextLine();
                                    if (newVal == null) newVal = "";
                                    newVal = newVal.trim();

                                    if (newVal.length() == 0) {
                                        continue;
                                    }
                                    setDoc.append(fname, newVal);
                                }
                            } else {
                                System.out.println("Invalid choice. Exiting.");
                                return;
                            }

                            if (setDoc.isEmpty()) {
                                System.out.println("No changes to apply. Exiting.");
                                return;
                            }

                            // --- Perform the update ---
                            Document update = new Document("$set", setDoc);
                            UpdateResult result = collection.updateOne(filter, update);

                            System.out.println("Update acknowledged: " + result.wasAcknowledged());
                            System.out.println("Matched count: " + result.getMatchedCount());
                            System.out.println("Modified count: " + result.getModifiedCount());

                            // --------- IMPORTANT CHANGE: re-fetch by _id (not by old filter) ---------
                            Object id = one.get("_id"); // this is the original _id
                            Document updated = collection.find(new Document("_id", id)).first();

                            if (updated != null) {
                                System.out.println("Document AFTER update:");
                                System.out.println(updated.toJson());
                            } else {
                                System.out.println("Could not fetch document after update.");
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
	Enter the collection name to UPDATE a single record: contacts
	Some existing fields in this collection (for reference):
	  - student_name
	  - address
	  - rollnumber
	How many fields will you use to find the record (integer >= 1): 1
	Enter FIELD NAME #1 to filter by: address
	Enter value for field 'address': Bangalore
	
	Filter used: {"address": "Bangalore"}
	Matched document (before update):
	{"_id": {"$oid": "69075b673b9a64e0641518e0"}, "rollnumber": "1", "student_name": "Ram", "address": "Bangalore"}
	
	Choose update mode:
	  1) Update SELECTED fields
	  2) Update ALL fields
	Enter choice (1 or 2): 1
	Fields in matched record:
	  1) rollnumber (current: 1)
	  2) student_name (current: Ram)
	  3) address (current: Bangalore)
	How many fields do you want to update (integer >= 1): 1
	Enter FIELD NAME or INDEX #1 to update: student_name
	Enter NEW value for field 'student_name' (current: Ram): Ram Kumar
	Update acknowledged: true
	Matched count: 1
	Modified count: 1
	Document AFTER update:
	{"_id": {"$oid": "69075b673b9a64e0641518e0"}, "rollnumber": "1", "student_name": "Ram Kumar", "address": "Bangalore"}

  */
 