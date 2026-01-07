package database_testing.shopall_page;

import java.util.Scanner;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class O002_Database_Regression_Shoppage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String uri = "mongodb://127.0.0.1:27017";

        try (MongoClient mongoClient = MongoClients.create(uri)) {

            // 1. Show all databases
            System.out.println("\n1. Existing Databases:");
            for (String dbName : mongoClient.listDatabaseNames()) {
                System.out.println("- " + dbName);
            }

//            // 2. Create a new database (note: MongoDB creates it on first write)
//            System.out.print("\n2. Enter new database name to create: ");
//            String newDbName = sc.nextLine();
//            MongoDatabase newDb = mongoClient.getDatabase(newDbName);
//            System.out.println("Database created: " + newDbName);
//
//            // 3. Select a database
//            MongoDatabase selectedDb = mongoClient.getDatabase(newDbName);
//            System.out.println("\n3. Selected Database: " + selectedDb.getName());
//
//            // 4. Show collections in selected DB
//            System.out.println("\n4. Collections in selected DB:");
//            for (String colName : selectedDb.listCollectionNames()) {
//                System.out.println("- " + colName);
//            }
//
//            // 5. Create a collection
//            System.out.print("\n5. Enter new collection name to create: ");
//            String newColName = sc.nextLine();
//            selectedDb.createCollection(newColName);
//            System.out.println("Collection created: " + newColName);
//
//            // 6. Insert documents into the collection
//            MongoCollection<Document> collection = selectedDb.getCollection(newColName);
//            Document doc1 = new Document("name", "Canon DSLR")
//                    .append("price", 45000)
//                    .append("stock", 20);
//            collection.insertOne(doc1);
//            System.out.println("\n6. One document inserted.");
//
//            // 7. Display all documents
//            System.out.println("\n7. All documents in collection:");
//            FindIterable<Document> docs = collection.find();
//            for (Document d : docs) {
//                System.out.println(d.toJson());
//            }
//
//            // 8. Display all attributes (keys) of the first document
//            System.out.println("\n8. All keys in first document:");
//            Document firstDoc = collection.find().first();
//            if (firstDoc != null) {
//                for (String key : firstDoc.keySet()) {
//                    System.out.println("- " + key);
//                }
//            }
//
//            // 9. Display one specific attribute
//            System.out.println("\n9. Value of 'name' attribute: " + firstDoc.get("name"));
//
//            // 10. Display attribute using user input
//            System.out.print("\n10. Enter attribute name to display: ");
//            String attr = sc.nextLine();
//            System.out.println("Value: " + firstDoc.get(attr));
//
//            // 11. Update one key-value
//            System.out.println("\n11. Updating 'stock' to 15...");
//            collection.updateOne(new Document("name", "Canon DSLR"),
//                    new Document("$set", new Document("stock", 15)));
//
//            // 12. Update all keys in a document
//            System.out.println("12. Replacing whole document...");
//            Document newDoc = new Document("name", "Canon DSLR Pro")
//                    .append("price", 60000)
//                    .append("stock", 10)
//                    .append("category", "Camera");
//            collection.replaceOne(new Document("name", "Canon DSLR"), newDoc);
//
//            // 13. Delete one key from document
//            System.out.println("\n13. Deleting key 'category' from document...");
//            collection.updateOne(new Document("name", "Canon DSLR Pro"),
//                    new Document("$unset", new Document("category", "")));
//
//            // 14. Delete all documents
//            System.out.println("14. Deleting all documents in collection...");
//            collection.deleteMany(new Document());

            System.out.println("\n All operations completed.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
