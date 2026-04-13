package mongodb_database_testing;

import static com.mongodb.client.model.Filters.eq;

import java.util.Scanner;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import shadow.org.bson.Document;

public class O4_fetchSpecificDocuments {

	public static void fetchSpecificDocuments() {

		MongoClient mongoClient = null;
		MongoDatabase database = null;
		Scanner sc = new Scanner(System.in);

		try {
			mongoClient = ConnectToMongoDatabase.connectToMongoServer();
			database = ConnectToMongoDatabase.selectMongoDatabase(mongoClient);

			if (database != null) {
				System.out.println("Enter collection name:");
				String collectionName = sc.nextLine();

				System.out.println("Enter name to search:");
				String name = sc.nextLine();

				MongoCollection<shadow.org.bson.Document> collection = database.getCollection(collectionName);

				FindIterable<Document> documents = collection.find(eq("name", name));
				MongoCursor<Document> cursor = documents.iterator();

				boolean found = false;

				while (cursor.hasNext()) {
					found = true;
					System.out.println(cursor.next().toJson());
				}

				if (!found) {
					System.out.println("No matching documents found.");
				}
			} else {
				System.out.println("Database selection failed.");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Unable to fetch specific documents.");
		} finally {
			ConnectToMongoDatabase.closeConnection(mongoClient);
		}
	}

	public static void main(String[] args) {
		fetchSpecificDocuments();
	}
}