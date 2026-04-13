package mongodb_db_test;

import java.util.Scanner;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class O4_ShowAllCollections {

	public static void main(String[] args) {

		try (MongoClient conn = MongoClients.create("mongodb://localhost:27017"); Scanner sc = new Scanner(System.in)) {

			System.out.println("Enter the database name:");
			String dbName = sc.nextLine();

			MongoDatabase database = conn.getDatabase(dbName);

			MongoIterable<String> collectionNames = database.listCollectionNames();

			System.out.println("Collections in database: " + database.getName());
			System.out.println("************************************");

			int count = 0;
			for (String collectionName : collectionNames) {
				System.out.println(collectionName);
				count++;
			}
			System.out.println("total collections found in : \'" + database.getName() + "\' is : " + count);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to fetch collections.");
		}
	}
}