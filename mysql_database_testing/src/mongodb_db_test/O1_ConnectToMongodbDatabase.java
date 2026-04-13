
package mongodb_db_test;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class O1_ConnectToMongodbDatabase {

	public static void main(String[] args) {

		// Create Mongo Client
		try (MongoClient conn = MongoClients.create("mongodb://localhost:27017")) {
			// Connect to Database ( and will create if not exists)
			MongoDatabase database = conn.getDatabase("test_database");
			System.out.println("Successfully connected to MongoDB!");
			System.out.println("Connected to database: " + database.getName());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to connect to MongoDB.");
		}
	}
}
