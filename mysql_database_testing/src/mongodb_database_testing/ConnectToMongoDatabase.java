package mongodb_database_testing;

import java.util.Scanner;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import shadow.org.bson.Document;

public class ConnectToMongoDatabase {

	public static final String MONGO_HOST = "localhost";
	public static final int MONGO_PORT = 27017;
	public static final String CONNECTION_STRING = "mongodb://" + MONGO_HOST + ":" + MONGO_PORT;

	private static final Scanner SCANNER = new Scanner(System.in);

	private ConnectToMongoDatabase() {
	}

	public static MongoClient connectToMongoServer() {
		MongoClient conn = null;

		try {
			conn = MongoClients.create(CONNECTION_STRING);
			conn.getDatabase("admin").runCommand(new Document("ping", 1));
			System.out.println("Connection established successfully to the MongoDB server.");
		} catch (MongoException ex) {
			System.out.println("Connection failed: Unable to reach the MongoDB server.");
			System.out.println("Please ensure the MongoDB service is running and the host/port are correct.");
			System.out.println("Error details: " + ex.getMessage());
		} catch (Exception ex) {
			System.out.println("An unexpected error occurred while attempting to connect to MongoDB.");
			System.out.println("Error details: " + ex.getMessage());
		}

		return conn;
	}

	public static MongoDatabase selectMongoDatabase(MongoClient conn) {
		try {
			if (conn == null) {
				System.out.println("Database selection failed: MongoDB server connection is not available.");
				return null;
			}

			System.out.println("Enter a MongoDB database name:");
			String databaseName = SCANNER.nextLine();

			if (databaseName == null || databaseName.trim().isEmpty()) {
				System.out.println("Database selection failed: Database name cannot be empty.");
				return null;
			}

			String sanitizedDatabaseName = databaseName.trim();
			MongoDatabase database = conn.getDatabase(sanitizedDatabaseName);

			database.runCommand(new Document("ping", 1));

			System.out.println("MongoDB database selected successfully: " + sanitizedDatabaseName);
			return database;

		} catch (MongoException ex) {
			System.out.println("Database selection failed: Unable to access the specified MongoDB database.");
			System.out.println("Error details: " + ex.getMessage());
		} catch (Exception ex) {
			System.out.println("An unexpected error occurred while selecting the MongoDB database.");
			System.out.println("Error details: " + ex.getMessage());
		}

		return null;
	}

	public static void closeConnection(MongoClient conn) {
		try {
			if (conn != null) {
				conn.close();
				System.out.println("MongoDB connection closed successfully.");
			}
		} catch (Exception ex) {
			System.out.println("Unable to close the MongoDB connection properly.");
			System.out.println("Error details: " + ex.getMessage());
		}
	}
}