package mongodb_db_test;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoIterable;

public class O2_ShowAllDatabases {

	public static void main(String[] args) {

		try (MongoClient conn = MongoClients.create("mongodb://localhost:27017")) {

			MongoIterable<String> databaseNames = conn.listDatabaseNames();

			System.out.println("Displaying all database names:");
			System.out.println("*****************************");

			int count = 0;
			for (String dbName : databaseNames) {
				System.out.println(dbName);
				count++;
			}

			System.out.println("**********************************");
			System.out.println("Total Database count is : " + count);
			System.out.println("**********************************");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to fetch database names.");
		}
	}
}