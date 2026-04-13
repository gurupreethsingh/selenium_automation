package mongdb_database_testing;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoIterable;

public class O1_ConnectAndDisplayAllDatabases {

	public static void main(String[] args) {

		try (MongoClient conn = MongoClients.create("mongodb://127.0.0.1:27017")) {
			MongoIterable<String> allDatabaseNames = conn.listDatabaseNames();

			int count = 0;

			for (String eachDatabaseName : allDatabaseNames) {
				System.out.println(count + 1 + " - " + eachDatabaseName);
				count++;
			}

			System.out.println("\n*****************************************\n");
			System.out.println("Total database Count found is : " + count);

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Failed to connect and fetch database names.");
		}
	}
}
