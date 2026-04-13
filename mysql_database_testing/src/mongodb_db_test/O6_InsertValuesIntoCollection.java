package mongodb_db_test;

import java.util.Scanner;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import shadow.org.bson.Document;

public class O6_InsertValuesIntoCollection {

	public static void main(String[] args) {

		try (MongoClient conn = MongoClients.create("mongodb://localhost:27017"); Scanner sc = new Scanner(System.in)) {

			System.out.println("Enter the database name:");
			String dbName = sc.nextLine();

			System.out.println("Enter the collection name:");
			String collectionName = sc.nextLine();

			System.out.println("Enter student name:");
			String name = sc.nextLine();

			System.out.println("Enter student age:");
			int age = Integer.parseInt(sc.nextLine());

			System.out.println("Enter student city:");
			String city = sc.nextLine();

			MongoDatabase database = conn.getDatabase(dbName);
			MongoCollection<Document> collection = database.getCollection(collectionName);

			Document doc = new Document("name", name).append("age", age).append("city", city);

			collection.insertOne(doc);

			System.out.println("Document inserted successfully.");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to insert document.");
		}
	}
}