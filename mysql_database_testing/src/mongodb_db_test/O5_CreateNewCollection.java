package mongodb_db_test;

import java.util.Scanner;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class O5_CreateNewCollection {

	public static void main(String[] args) {

		try (MongoClient conn = MongoClients.create("mongodb://localhost:27017"); Scanner sc = new Scanner(System.in)) {

			System.out.println("Enter the database name:");
			String dbName = sc.nextLine();

			System.out.println("Enter the new collection name:");
			String collectionName = sc.nextLine();

			MongoDatabase database = conn.getDatabase(dbName);
			database.createCollection(collectionName);

			System.out.println("Collection created successfully: " + collectionName);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to create collection.");
		}
	}
}