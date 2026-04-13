package mongodb_database_testing;

import java.util.Scanner;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import shadow.org.bson.Document;

public class O3_showAllDocuments {

	public static void showAllDocuments() {

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
				FindIterable<Document> documents = collection.find();

				MongoCursor<Document> cursor = documents.iterator();

				System.out.println("\nDisplaying all documents:");
				System.out.println("************************");

				boolean hasDocuments = false;

				while (cursor.hasNext()) {
					hasDocuments = true;
					System.out.println(cursor.next().toJson());
				}

				if (!hasDocuments) {
					System.out.println("No documents found in this collection.");
				}
			} else {
				System.out.println("Database selection failed.");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Unable to fetch documents.");
		} finally {
			ConnectToMongoDatabase.closeConnection(mongoClient);
		}
	}

	public static void main(String[] args) {
		showAllDocuments();
	}
}
