package mongodb_db_test;

import java.util.Scanner;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import shadow.org.bson.Document;

public class O9_DeleteValuesFromCollection {

	public static void main(String[] args) {

		try (MongoClient conn = MongoClients.create("mongodb://localhost:27017"); Scanner sc = new Scanner(System.in)) {

			System.out.println("Enter the database name:");
			String dbName = sc.nextLine();

			System.out.println("Enter the collection name:");
			String collectionName = sc.nextLine();

			System.out.println("Enter the student name to delete:");
			String name = sc.nextLine();

			MongoDatabase database = conn.getDatabase(dbName);
			MongoCollection<Document> collection = database.getCollection(collectionName);

			Document filter = new Document("name", name);

			collection.deleteOne(filter);

			System.out.println("Document deleted successfully.");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to delete document.");
		}
	}
}