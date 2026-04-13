package mongodb_database_testing;

import java.util.Scanner;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class O1_createCollection {

	public static void createCollection() {

		MongoClient conn = null;
		MongoDatabase database = null;
		Scanner sc = new Scanner(System.in);

		try {
			conn = ConnectToMongoDatabase.connectToMongoServer();
			database = ConnectToMongoDatabase.selectMongoDatabase(conn);

			if (database != null) {
				System.out.println("Enter collection name:");
				String collectionName = sc.nextLine();

				database.createCollection(collectionName);

				System.out.println("Collection created successfully: " + collectionName);
			} else {
				System.out.println("Database selection failed.");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Unable to create collection.");
		} finally {
			ConnectToMongoDatabase.closeConnection(conn);
		}
	}

	public static void main(String[] args) {
		createCollection();
	}
}
