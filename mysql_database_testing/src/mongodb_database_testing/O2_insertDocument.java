package mongodb_database_testing;

import java.util.Scanner;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import shadow.org.bson.Document;

public class O2_insertDocument {

	public static void insertDocument() {

		MongoClient mongoClient = null;
		MongoDatabase database = null;
		Scanner sc = new Scanner(System.in);

		try {
			mongoClient = ConnectToMongoDatabase.connectToMongoServer();
			database = ConnectToMongoDatabase.selectMongoDatabase(mongoClient);

			if (database != null) {
				System.out.println("Enter collection name:");
				String collectionName = sc.nextLine();

				MongoCollection<Document> collection = database.getCollection(collectionName);

				System.out.print("Enter name: ");
				String name = sc.nextLine();

				System.out.print("Enter email: ");
				String email = sc.nextLine();

				System.out.print("Enter fees: ");
				double fees = Double.parseDouble(sc.nextLine());

				Document document = new Document("name", name).append("email", email).append("fees", fees);

				collection.insertOne(document);

				System.out.println("Document inserted successfully.");
			} else {
				System.out.println("Database selection failed.");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Unable to insert document.");
		} finally {
			ConnectToMongoDatabase.closeConnection(mongoClient);
		}
	}

	public static void main(String[] args) {
		insertDocument();
	}
}
