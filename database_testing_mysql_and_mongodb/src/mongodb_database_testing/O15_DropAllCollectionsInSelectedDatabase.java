package mongodb_database_testing;

import java.util.Scanner;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.MongoDatabase;

public class O15_DropAllCollectionsInSelectedDatabase {

    public static void main(String[] args) {
        MongoClient connection = null;
        Scanner sc = null;

        try {
            connection = MongoClients.create("mongodb://localhost:27017");

            if (connection != null)
            {
                System.out.println("Connected to MongoDB.");

                sc = new Scanner(System.in);
                System.out.print("Enter database name to DROP ALL collections from: ");
                String dbName = sc.nextLine();

                if (dbName == null) {
                    System.out.println("Invalid database name.");
                } else {
                    dbName = dbName.trim();
                    if (dbName.length() == 0) {
                        System.out.println("Invalid database name. It cannot be empty.");
                    } else {
                        boolean dbExists = false;
                        MongoIterable<String> allDbNames = connection.listDatabaseNames();
                        for (String name : allDbNames) {
                            if (name.equals(dbName)) {
                                dbExists = true;
                                break;
                            }
                        }

                        if (dbExists) {
                            MongoDatabase db = connection.getDatabase(dbName);
                            db.listCollectionNames().first();
                            System.out.println("Successfully connected to database: " + dbName);

                            MongoIterable<String> collNames = db.listCollectionNames();
                            int collCount = 0;
                            System.out.println("Collections to drop in '" + dbName + "':");
                            for (String c : collNames) {
                                System.out.println(" - " + c);
                                collCount++;
                            }

                            if (collCount == 0) {
                                System.out.println("No collections found. Nothing to drop.");
                                return;
                            }

                            System.out.println("WARNING: This will DROP ALL " + collCount + " collections in '" + dbName + "'.");
                            System.out.print("Type DROP_ALL_COLLECTIONS to confirm: ");
                            String confirm = sc.nextLine();
                            if (!"DROP_ALL_COLLECTIONS".equalsIgnoreCase(confirm.trim())) {
                                System.out.println("Operation cancelled.");
                                return;
                            }

                            // Re-iterate and drop
                            int dropped = 0;
                            for (String c : db.listCollectionNames()) {
                                db.getCollection(c).drop();
                                dropped++;
                            }

                            System.out.println("Dropped collections count: " + dropped);

                        } else {
                            System.out.println("Database not found: " + dbName);
                        }
                    }
                }
            } else {
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
