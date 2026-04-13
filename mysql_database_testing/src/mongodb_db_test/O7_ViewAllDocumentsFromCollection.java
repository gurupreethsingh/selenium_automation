package mongodb_db_test;

import java.util.Scanner;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import shadow.org.bson.Document;

public class O7_ViewAllDocumentsFromCollection {

	public static void main(String[] args) {

		try (MongoClient conn = MongoClients.create("mongodb://localhost:27017"); Scanner sc = new Scanner(System.in)) {

			System.out.println("Enter the database name:");
			String dbName = sc.nextLine();

			System.out.println("Enter the collection name:");
			String collectionName = sc.nextLine();

			MongoDatabase database = conn.getDatabase(dbName);
			MongoCollection<Document> collection = database.getCollection(collectionName);

			FindIterable<Document> documents = collection.find();

			System.out.println("Displaying all documents/Rows/Records:");
			System.out.println("************************");

			for (Document doc : documents) {
				System.out.println(doc.toJson());
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to fetch documents.");
		}
	}
}