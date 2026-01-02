package mongodb_database_testing;

import java.util.Scanner;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.MongoDatabase;

public class O16_DropSelectedDatabase {

    public static void main(String[] args) {
        MongoClient connection = null;
        Scanner sc = null;

        try {
            connection = MongoClients.create("mongodb://localhost:27017");

            if (connection != null)
            {
                System.out.println("Connected to MongoDB.");

                sc = new Scanner(System.in);
                System.out.print("Enter database name to DROP: ");
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

                        if (!dbExists) {
                            System.out.println("Database not found: " + dbName);
                            return;
                        }

                        // Safety: warn about system DBs
                        if ("admin".equals(dbName) || "local".equals(dbName) || "config".equals(dbName)) {
                            System.out.println("WARNING: You are about to drop a system database: " + dbName);
                        }

                        System.out.println("WARNING: This will DROP the entire database '" + dbName + "'.");
                        System.out.print("Type DROP_DATABASE " + dbName + " to confirm: ");
                        String confirm = sc.nextLine();
                        String expected = "DROP_DATABASE " + dbName;
                        if (!expected.equalsIgnoreCase(confirm.trim())) {
                            System.out.println("Operation cancelled.");
                            return;
                        }

                        MongoDatabase db = connection.getDatabase(dbName);
                        db.drop();

                        System.out.println("Database dropped: " + dbName);
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
