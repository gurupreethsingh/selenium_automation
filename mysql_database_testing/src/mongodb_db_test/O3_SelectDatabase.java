package mongodb_db_test;

import java.util.Scanner;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class O3_SelectDatabase {

	public static void main(String[] args) {

		try (MongoClient conn = MongoClients.create("mongodb://localhost:27017");
				Scanner sc = new Scanner(System.in)) {

			System.out.println("Enter the database name:");
			String dbName = sc.nextLine();

			MongoDatabase database = conn.getDatabase(dbName);

			System.out.println("Selected database: " + database.getName());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to select database.");
		}
	}
}